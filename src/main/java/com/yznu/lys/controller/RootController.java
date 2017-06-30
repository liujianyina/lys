package com.yznu.lys.controller;

import com.yznu.lys.domain.User;
import com.yznu.lys.service.SetmealService;
import com.yznu.lys.service.UserService;
import com.yznu.lys.utils.Constant;
import com.yznu.lys.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by 刘剑银 on 2017/6/27.
 */
@Controller
public class RootController extends BaseController {

    @Autowired
    private UserService userService;

    @Autowired
    private SetmealService setmealService;

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping({"/", "/index"})
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        model.put("setmealList", setmealService.findAll());
        return new ModelAndView("/index", model);
    }

    /**
     * 注册页
     *
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "/register";
    }

    /**
     * 注册请求
     *
     * @param user
     * @param code
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/register")
    public String register(User user, String code, final RedirectAttributes redirectAttributes) {
        /**
         * 如果用户名或者密码为空
         */
        if (Utils.isEmpty(user.getUsername()) || Utils.isEmpty(user.getPassword())) {
            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", "error.login.null");
            return "redirect:/register";
        }

        /**
         * 判断验证码
         */
        String rcode = (String) getSession().getAttribute("rcode");

        if (!rcode.equals(code.toUpperCase())) {
            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", "error.code.error");
            return "redirect:/register";
        }

        user.setBalance(0);
        if (Utils.isNull(userService.save(user))) {
            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", "error.register.illicit");
            return "redirect:/register";
        }
        return "redirect:/login";
    }

    /**
     * 登录页
     *
     * @return
     */
    @GetMapping("/login")
    public String login() {
        if (Utils.isNull(getSession().getAttribute(Constant.SessionKey.CURRENT_USER))) {
            return "/login";
        } else {
            return "redirect:/index";
        }
    }

    /**
     * 登录请求
     *
     * @param username
     * @param password
     * @param code
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/login")
    public String login(String username, String password, String code, final RedirectAttributes redirectAttributes) {
        /**
         * 如果用户名或者密码为空
         */
        if (Utils.isEmpty(username) || Utils.isEmpty(password)) {
            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", "error.login.null");
            return "redirect:/login";
        }

        /**
         * 判断验证码
         */
        String rcode = (String) getSession().getAttribute("rcode");
        if (!rcode.equals(code.toUpperCase())) {
            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", "error.code.error");
            return "redirect:/login";
        }

        User user = userService.login(username, password);

        if (!Utils.isNull(user)) {
            if (user.getStatus() == 1) {  //有效
                try {
                    getSession().invalidate();
                } catch (Exception e) {
                }
                getSession().setAttribute(Constant.SessionKey.CURRENT_USER, user);
                getSession().setAttribute(Constant.SessionKey.AVAILABLE_MENU, user.getResourceSids());
                getSession().setAttribute("USERNAME", username);
                String referer = getRequest().getHeader("referer");
                if (Utils.isEmpty(referer)) {
                    return "redirect:/index";
                } else {
                    return "redirect:" + referer;
                }
            } else {  //无效
                redirectAttributes.addFlashAttribute("ERROR_MESSAGE", "error.login.user.invalid");
                return "redirect:/login";
            }
        } else {  //用户或密码错误

            redirectAttributes.addFlashAttribute("ERROR_MESSAGE", "error.login.fail");
            return "redirect:/login";
        }
    }


    /**
     * 生成验证码
     *
     * @param request
     * @param response
     * @throws Exception
     */
    @GetMapping(value = "/captcha")
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        Font mFont = new Font("Times New Roman", Font.PLAIN, 20);

        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
        //表明生成的响应是图片
        response.setContentType("image/jpeg");

        int width = 110, height = 37;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        Graphics g = image.getGraphics();
        Random random = new Random();
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, width, height);

        g.setColor(new Color(255, 20, 60));
        g.setFont(mFont);

        //生成随机数,并将随机数字转换为字母
        String rcode = "";

        for (int i = 0; i < 4; i++) {
            int itmp = random.nextInt(26) + 65;
            char ctmp = (char) itmp;
            rcode += ctmp;
            g.drawString(String.valueOf(ctmp), 25 * i + 10, 25);
        }

        getSession().setAttribute("rcode", rcode);

        g.dispose();
        //image是最后生成的一个jpeg图片
        ImageIO.write(image, "JPEG", response.getOutputStream());

    }

    /**
     * 注销请求
     *
     * @return
     */
    @GetMapping("/loginOut")
    public String loginOut() {
        getSession().invalidate();
        return "redirect:/index";
    }
}

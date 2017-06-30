package com.yznu.lys.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.yznu.lys.domain.User;
import com.yznu.lys.service.OrderService;
import com.yznu.lys.service.UserService;
import com.yznu.lys.utils.Constant;
import com.yznu.lys.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘剑银 on 2017/6/28.
 */
@Controller
@RequestMapping("/person")
public class PersonController extends BaseController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * 个人主页
     *
     * @return
     */
    @GetMapping({"/index", "/"})
    public String index() {
        return "/person/index";
    }

    /**
     * 订单页
     *
     * @return
     */
    @GetMapping("/order")
    public ModelAndView order() {
        Long userSid = ((User) getSession().getAttribute(Constant.SessionKey.CURRENT_USER)).getSid();

        Map<String, Object> model = new HashMap<>();

        model.put("orderList", orderService.findByUserId(userSid));

        return new ModelAndView("/person/order", model);
    }

    /**
     * 个人信息页面
     *
     * @return
     */
    @GetMapping("/personal_infomation")
    public ModelAndView personalInfomation() {
        User user = (User) getSession().getAttribute(Constant.SessionKey.CURRENT_USER);
        if (user.getPhoneNum() == null) {
            user.setPhoneNum("");
        }
        Map<String, Object> model = new HashMap<>();
        model.put("user", user);
        return new ModelAndView("/person/personal_infomation", model);
    }

    /**
     * 更新用户信息
     *
     * @param username
     * @param password
     * @param phoneNum
     * @param balance
     * @param redirectAttributes
     * @return
     */
    @PostMapping("/update_user_info")
    public String update(String username, String password, String phoneNum, float balance, final RedirectAttributes redirectAttributes) {
        User user = (User) getSession().getAttribute(Constant.SessionKey.CURRENT_USER);
        user.setUsername(username);

        if (!Utils.isEmpty(password.trim())) {
            userService.updatePassword(password, user.getSid());
        }

        user.setPhoneNum(phoneNum);
        user.setBalance(balance);

        getSession().setAttribute(Constant.SessionKey.CURRENT_USER, user);
        getSession().setAttribute("USERNAME", username);

        userService.update(user);

        redirectAttributes.addFlashAttribute("message", "message.info.succeed");
        return "redirect:/person/personal_infomation";
    }
}

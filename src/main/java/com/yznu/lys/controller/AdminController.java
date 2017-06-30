package com.yznu.lys.controller;

import com.yznu.lys.domain.Setmeal;
import com.yznu.lys.service.OrderService;
import com.yznu.lys.service.SetmealService;
import com.yznu.lys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * 管理员功能
 * <p>
 * Created by 刘剑银 on 2017/6/29.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserService userService;

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private OrderService orderService;

    /**
     * 会员管理，管理员的默认主页
     *
     * @return
     */
    @GetMapping({"index", "/admin_member", "/"})
    public ModelAndView index() {
        Map<String, Object> model = new HashMap<>();
        model.put("userList", userService.findAll());
        return new ModelAndView("/admin/admin_member", model);
    }

    /**
     * 用户无效
     *
     * @param sid
     * @return
     */
    @GetMapping("/delete_user")
    public String updateStatus(Long sid) {
        userService.updateStatus(sid);
        return "redirect:/admin/index";
    }

    /**
     * 用户有效
     *
     * @param sid
     * @return
     */
    @GetMapping("/reset_user")
    public String resetUser(Long sid) {
        userService.resetStatus(sid);
        return "redirect:/admin/index";
    }

    /**
     * 删除用户
     *
     * @param sid
     * @return
     */
    @GetMapping("/deleteUser")
    public String deleteUser(Long sid) {
        userService.delete(sid);
        return "redirect:/admin/index";
    }

    /**
     * 套餐管理
     *
     * @return
     */
    @GetMapping("/admin_setmeal")
    public ModelAndView admin_setmeal() {
        Map<String, Object> modle = new HashMap<>();
        modle.put("setmealList", setmealService.findAll());
        return new ModelAndView("/admin/admin_setmeal", modle);
    }

    /**
     * 删除套餐
     *
     * @param sid
     * @return
     */
    @GetMapping("/delete_setmeal")
    public String deleteSetmeal(Long sid) {
        setmealService.delete_setmeal(sid);
        return "redirect:/admin/admin_setmeal";
    }

    /**
     * 销售记录
     *
     * @return
     */
    @GetMapping("/sales_record")
    public ModelAndView sales_record() {
        Map<String,Object> model = new HashMap<>();
        model.put("orders",orderService.findAll());
        return new ModelAndView("/admin/sales_record",model);
    }

    /**
     * 删除订单
     * @return
     */
    @GetMapping("/delete_order_admin")
    public String delete_order_admin(Long sid){
        orderService.delete(sid);
        return "redirect:/admin/sales_record";
    }

    /**
     * 上传商品页
     * @return
     */
    @GetMapping("/add_new_commodity")
    public String add_new_commodity(){
        return "/admin/add_new_commodity";
    }

    /**
     * 上传请求
     * @return
     */
    @PostMapping("/add_new_commodity")
    public String add_new_commodity(String cname,float price,int count){
        Setmeal setmeal = new Setmeal();
        setmeal.setCname(cname);
        setmeal.setPrice(price);
        setmeal.setCount(count);
        setmealService.save(setmeal);
        return "redirect:/admin/admin_setmeal";
    }


}

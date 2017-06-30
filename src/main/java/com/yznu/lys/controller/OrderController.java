package com.yznu.lys.controller;

import com.yznu.lys.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by 刘剑银 on 2017/6/29.
 */
@Controller
@RequestMapping("/order")
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    /**
     * 订单无效
     *
     * @param sid
     * @return
     */
    @GetMapping("/delete_user")
    public String delete_user(Long sid) {

        orderService.updateOrderStatus(sid);

        return "redirect:/person/order";
    }

}

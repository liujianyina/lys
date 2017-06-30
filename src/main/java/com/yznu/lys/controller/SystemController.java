package com.yznu.lys.controller;

import com.yznu.lys.domain.Order;
import com.yznu.lys.domain.Setmeal;
import com.yznu.lys.domain.User;
import com.yznu.lys.service.OrderService;
import com.yznu.lys.service.SetmealService;
import com.yznu.lys.service.UserService;
import com.yznu.lys.utils.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 刘剑银 on 2017/6/29.
 */
@Controller
@RequestMapping("/system")
public class SystemController extends BaseController {

    @Autowired
    private SetmealService setmealService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    /**
     * 转到购买商品页
     *
     * @return
     */
    @GetMapping("/buy")
    public ModelAndView buy(Long sid) {
        Map<String, Object> model = new HashMap<>();

        model.put("setmeal", setmealService.findBySid(sid));

        return new ModelAndView("/system/buySeatmeal", model);
    }

    @PostMapping("/buy")
    public String buy(Long sid, int count) {

        Setmeal setmeal = setmealService.findBySid(sid);

        /**
         * 计算出金额
         */
        float money = setmeal.getPrice() * count;

        /**
         * 更新账户金额，没有考虑账户余额是否不足
         */
        User user = (User) getSession().getAttribute(Constant.SessionKey.CURRENT_USER);
        userService.updateBalance(user.getBalance() - money, user.getSid());
        user.setBalance(user.getBalance() - money);

        getSession().setAttribute(Constant.SessionKey.CURRENT_USER, user);

        //生成订单
        Order order = new Order();
        order.setCname(setmeal.getCname());
        order.setPrice(money);
        order.setUserSid(user.getSid());

        /**
         * 订单入库
         */
        orderService.save(order);


        /**
         * 更新库存
         */
        setmealService.sell(sid, count);

        return "redirect:/person/order";

    }

}

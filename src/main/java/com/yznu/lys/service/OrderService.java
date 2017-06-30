package com.yznu.lys.service;

import com.yznu.lys.domain.Order;
import com.yznu.lys.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 刘剑银 on 2017/6/28.
 */
@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    /**
     * 保存订单
     *
     * @param order
     * @return
     */
    @Transactional
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    /**
     * 按编号删除订单
     *
     * @param sid
     * @return
     */
    @Transactional
    public void delete(Long sid) {
        orderRepository.deleteBySid(sid);
    }

    /**
     * 订单无效
     *
     * @param sid
     */
    @Transactional
    public void updateOrderStatus(Long sid) {
        orderRepository.updateOrderStatus(sid);
    }

    /**
     * 查询改用户下的所有订单信息
     *
     * @param userId
     * @return
     */
    public List<Order> findByUserId(Long userId) {
        return orderRepository.findByUserSid(userId);
    }

    /**
     * 查询所有订单
     *
     * @return
     */
    public List<Order> findAll() {
        return orderRepository.findAll();
    }
}

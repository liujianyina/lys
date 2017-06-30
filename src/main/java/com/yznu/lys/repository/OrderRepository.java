package com.yznu.lys.repository;

import com.yznu.lys.domain.Order;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.ManyToMany;
import java.util.List;

/**
 * Created by 刘剑银 on 2017/6/28.
 */
@Repository
public interface OrderRepository extends BaseRepository<Order> {

    /**
     * 按照SID删除订单
     *
     * @param sid
     * @return
     */
    void deleteBySid(Long sid);


    /**
     * 查找用户订单
     *
     * @param userSid
     * @return
     */
    @Query("SELECT o FROM Order o WHERE o.userSid = ?1 AND o.status != -1")
    List<Order> findByUserSid(Long userSid);

    /**
     * 用户订单无效
     *
     * @param sid
     */
    @Modifying
    @Query("UPDATE Order o SET o.status=-1 WHERE o.sid=?1")
    void updateOrderStatus(Long sid);

}

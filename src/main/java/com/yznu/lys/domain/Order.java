package com.yznu.lys.domain;

import com.yznu.lys.utils.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 订单类
 * Created by 刘剑银 on 2017/6/28.
 */
@Entity
@Table(name = Constant.TABLE_PREFIX + "order")
public class Order extends BaseDomain {

    private static final long serialVersionUID = -1197090389422725278L;
    /**
     * 用户id
     */
    @Column(nullable = false)
    private Long userSid;

    /**
     * 商品名
     */
    @Column(length = 30, nullable = false)
    private String cname;

    /**
     * 花费
     */
    @Column(length = 10)
    private float price;

    public Long getUserSid() {
        return userSid;
    }

    public void setUserSid(Long userSid) {
        this.userSid = userSid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

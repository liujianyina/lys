package com.yznu.lys.domain;

import com.yznu.lys.utils.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 餐点实体类
 * Created by 刘剑银 on 2017/6/28.
 */
@Entity
@Table(name = Constant.TABLE_PREFIX + "setmeal")
public class Setmeal extends BaseDomain {

    private static final long serialVersionUID = 1092034998735696791L;
    /**
     * 餐名
     */
    @Column(length = 30, nullable = false)
    private String cname;

    /**
     * 价格
     */
    @Column(nullable = false)
    private float price;

    /**
     * 数量
     */
    @Column(nullable = false)
    private int count;

    /**
     * 图片的url
     */
    private String imgurl;
    /**
     * 备注
     */
    private String note;

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getImgurl() {
        return imgurl;
    }

    public void setImgurl(String imgurl) {
        this.imgurl = imgurl;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}

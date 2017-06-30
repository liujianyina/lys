package com.yznu.lys.domain;

import com.yznu.lys.utils.Utils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by 刘剑银 on 2017/6/26.
 */
@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class BaseDomain implements Serializable {

    /**
     * 标识id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    protected Long sid;

    /**
     * 创建时间
     */
    @Column(nullable = false, updatable = false)
    protected Date createTime;

    /**
     * 更新时间
     */
    @Column(nullable = false)
    protected Date updateTime;


    /**
     * 状态
     */
    protected int status = 1;

    public BaseDomain() {
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public Long getSid() {
        return sid;
    }

    public void setSid(Long sid) {
        this.sid = sid;
    }

    public Date getCreateTime() {

        if (Utils.isNull(createTime)) {
            return new Date();
        } else {
            DateTime time = new DateTime(createTime, DateTimeZone.UTC);
            return time.toDate();
        }

    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        DateTime time = new DateTime(updateTime, DateTimeZone.UTC);
        return time.toDate();
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}

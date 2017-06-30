package com.yznu.lys.domain;

import com.yznu.lys.utils.Constant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * 资源
 * <p>
 * Created by 刘剑银 on 2017/6/26.
 */
@Entity
@Table(name = Constant.TABLE_PREFIX + "resource")
public class Resource extends BaseDomain implements Comparable<Resource> {
    private static final long serialVersionUID = 2329575755727666866L;


    /**
     * 资源类型
     */
    public enum Type {
        /**
         * 系统菜单，登录并授权访问
         */
        SYSREM_MENU(1),
        /**
         * 非系统菜单，登录访问
         */
        NONE_MENU(2),
        /**
         * 可匿名访问菜单
         */
        PUBLIC_MENU(3);

        private int value;

        Type(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * 资源名称
     */
    @Column(length = 30)
    private String cname;

    /**
     * 链接
     */
    @Column(length = 50)
    private String url;

    /**
     * 菜单类型
     */
    @Column(length = 1)
    private int Type;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getType() {
        return Type;
    }

    public void setType(int type) {
        Type = type;
    }

    @Override
    public int compareTo(Resource o) {
        return 0;
    }

}

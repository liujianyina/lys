package com.yznu.lys.domain;

import com.yznu.lys.utils.Constant;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by 刘剑银 on 2017/6/26.
 */
@Entity
@Table(name = Constant.TABLE_PREFIX + "user")
public class User extends BaseDomain {
    private static final long serialVersionUID = -3877803782068663991L;

    /**
     * 用户名
     */
    @Column(length = 30)
    private String username;

    /**
     * 密码
     */
    @Column(length = 32)
    private String password;

    /**
     * .
     * 手机号码
     */
    @Column(length = 11)
    private String phoneNum;

    /**
     * 账户余额
     */
    private float balance = 0.0f;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = Constant.TABLE_PREFIX + "user_role",
            joinColumns = {@JoinColumn(name = "user_sid")},
            inverseJoinColumns = {@JoinColumn(name = "role_sid")}
    )
    private List<Role> roleList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    /**
     * 取得用户所有可访问的菜单 sid
     *
     * @return
     */
    public Set<Long> getResourceSids() {
        Set<Long> sids = new HashSet<Long>();

        if (null != roleList && !roleList.isEmpty()) {
            for (Role role : roleList) {
                sids.addAll(role.getResourceSids());
            }
        }

        return sids;
    }

    /**
     * 取得用户所有可访问的url
     */
    public Set<String> getUrls() {
        Set<String> urls = new HashSet<>();
        if (null != roleList && !roleList.isEmpty()) {
            for (Role r : roleList) {
                urls.addAll(r.getResourceUrls());
            }
        }
        return urls;
    }

}

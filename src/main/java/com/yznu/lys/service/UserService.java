package com.yznu.lys.service;

import com.yznu.lys.domain.User;
import com.yznu.lys.repository.UserRepository;
import com.yznu.lys.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 刘剑银 on 2017/6/27.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    /**
     * 注册
     *
     * @param user
     * @return
     */
    @Transactional
    public User save(User user) {
        user.setPassword(Utils.getMD5String(user.getPassword()));
        return userRepository.save(user);
    }

    /**
     * 登录
     *
     * @param username
     * @param password
     * @return
     */
    public User login(String username, String password) {
        return userRepository.login(username, Utils.getMD5String(password));
    }


    /**
     * 更新账户信息
     *
     * @param user
     * @return
     */
    @Transactional
    public boolean update(User user) {
        return userRepository.upadte(user.getUsername(), user.getPhoneNum(), user.getBalance(), user.getSid()) != -1;
    }

    /**
     * 修改密码
     *
     * @param password
     * @param sid
     * @return
     */
    @Transactional
    public boolean updatePassword(String password, Long sid) {
        return userRepository.updatePassword(Utils.getMD5String(password), sid) != -1;
    }

    /**
     * 模拟买：用户余额减去商品价格
     *
     * @param balance
     * @param sid
     */
    @Transactional
    public void updateBalance(float balance, Long sid) {
        userRepository.updateBalance(balance, sid);
    }

    /**
     * 查询所有用户信息
     *
     * @return
     */
    public List<User> findAll() {
        return userRepository.findAll();
    }

    /**
     * 删除一个用户
     *
     * @param sid
     */
    @Transactional
    public void delete(Long sid) {
        userRepository.deleteBySid(sid);
    }

    /**
     * 让用户失效
     *
     * @param sid
     */
    @Transactional
    public void updateStatus(Long sid) {
        userRepository.updateStatus(sid);
    }

    /**
     * 让失效用户有效
     *
     * @param sid
     */
    @Transactional
    public void resetStatus(Long sid) {
        userRepository.resetStatus(sid);
    }
}

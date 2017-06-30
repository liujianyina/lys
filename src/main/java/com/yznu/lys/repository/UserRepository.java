package com.yznu.lys.repository;

import com.yznu.lys.domain.User;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by 刘剑银 on 2017/6/27.
 */
@Repository
public interface UserRepository extends BaseRepository<User> {

    /**
     * 登录
     *
     * @return
     */
    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    User login(String username, String password);

    /**
     * 删除指定用户
     *
     * @param sid
     * @return
     */
    void deleteBySid(Long sid);

    /**
     * 更新账户信息
     *
     * @param username
     * @param phoneNum
     * @param balance
     * @param sid
     * @return
     */
    @Modifying
    @Query("UPDATE User u SET u.username=?1,u.phoneNum=?2,u.balance=?3 WHERE u.sid=?4")
    int upadte(String username, String phoneNum, float balance, Long sid);

    /**
     * 修改密码
     *
     * @param password
     * @param sid
     * @return
     */
    @Modifying
    @Query("UPDATE User u SET u.password=?1 WHERE u.sid=?2")
    int updatePassword(String password, Long sid);

    @Modifying
    @Query("UPDATE User u SET u.balance=?1 WHERE u.sid=?2")
    void updateBalance(float balance, Long sid);

    @Modifying
    @Query("UPDATE User u SET u.status=-1 WHERE u.sid=?1")
    void updateStatus(Long sid);

    @Modifying
    @Query("UPDATE User u SET u.status=1 WHERE u.sid=?1")
    void resetStatus(Long sid);

}

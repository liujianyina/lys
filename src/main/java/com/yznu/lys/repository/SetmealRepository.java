package com.yznu.lys.repository;

import com.yznu.lys.domain.Setmeal;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by 刘剑银 on 2017/6/29.
 */
@Repository
public interface SetmealRepository extends BaseRepository<Setmeal> {

    /**
     * 按照sid查找套餐
     *
     * @param sid
     * @return
     */
    Setmeal findBySid(Long sid);

    /**
     * 更新库存
     *
     * @param count
     * @param sid
     */
    @Modifying
    @Query("UPDATE Setmeal s SET s.count=?1 WHERE s.sid=?2")
    void updateCount(int count, Long sid);

    void deleteBySid(Long sid);

}

package com.yznu.lys.service;

import com.yznu.lys.domain.Setmeal;
import com.yznu.lys.repository.SetmealRepository;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by 刘剑银 on 2017/6/29.
 */
@Service
public class SetmealService {

    @Autowired
    private SetmealRepository setmealRepository;

    /**
     * 查询所有的套餐
     *
     * @return
     */
    public List<Setmeal> findAll() {
        return setmealRepository.findAll();
    }


    /**
     * 按照id查询
     *
     * @param sid
     * @return
     */
    public Setmeal findBySid(Long sid) {
        return setmealRepository.findBySid(sid);
    }

    /**
     * 更新库存
     */
    @Transactional
    public void sell(Long sid, int count) {
        Setmeal setmeal = this.findBySid(sid);
        setmealRepository.updateCount(setmeal.getCount() - count, sid);
    }

    /**
     * 删除套餐
     *
     * @param sid
     */
    @Transactional
    public void delete_setmeal(Long sid) {
        setmealRepository.deleteBySid(sid);
    }

    /**
     * 保存
     * @param setmeal
     */
    @Transactional
    public void save(Setmeal setmeal){
        setmealRepository.save(setmeal);
    }

}

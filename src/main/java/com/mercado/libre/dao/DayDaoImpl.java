package com.mercado.libre.dao;

import com.mercado.libre.model.Day;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by mariano on 24/09/17.
 */
@Repository
@Transactional
public class DayDaoImpl extends Dao implements DayDao{


    public DayDaoImpl(){}


    @Override
    public Boolean save(Day day) {

        Day d = entityManager.find(Day.class, day.getNumDay());
        if(d ==null) {
            entityManager.persist(day);
            return true;
        }
        return false;

    }

    @Override
    public Day getDay(int day) {
        return entityManager.find(Day.class, day);
    }


}

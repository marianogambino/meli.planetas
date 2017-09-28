package com.mercado.libre.dao;

import com.mercado.libre.model.Day;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

/**
 * Created by mariano on 24/09/17.
 */

@Repository
public interface DayDao {

    Boolean save(Day day);
    Day getDay(int day);
}

package com.mercado.libre.dao;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by mariano on 24/09/17.
 */
@Repository
public class Dao {

    @PersistenceContext
    protected EntityManager entityManager;

}

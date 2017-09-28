package com.mercado.libre.restservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.web.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by mariano on 03/07/17.
 */
@SpringBootApplication (scanBasePackages = "com.mercado.libre")
@EntityScan(basePackages = "com.mercado.libre")
public class Application {

    public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }


}

package com.mycompany.mavenproject6.web.dao;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author guilh
 */
@Component("usersDao")
public class UsersDAO {

    private NamedParameterJdbcTemplate jdbc;

    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    @Transactional
    public boolean create(User user) {

        BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);

        jdbc.update("insert into users (username, password, email, enabled) values (:username, :password, :email, :enabled)", params);
        return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;
    }
}

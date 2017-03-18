package com.mycompany.mavenproject6.web.dao;

import java.util.List;
import javax.sql.DataSource;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@Transactional
@Component("usersDao")
public class UsersDAO {

    private NamedParameterJdbcTemplate jdbc;
    
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private SessionFactory sessionFactory;
    
    public Session session() {
        return sessionFactory.getCurrentSession();
    }
    
    @Autowired
    public void setDataSource(DataSource jdbc) {
        this.jdbc = new NamedParameterJdbcTemplate(jdbc);
    }

    @Transactional
    public void create(User user) {
        user.setEncryptedPassword(passwordEncoder.encode(user.getPassword()));
        session().save(user);
    }

    public boolean exists(String username) {
        
        return jdbc.queryForObject(
                "select count(*) from users where username = :username",
                new MapSqlParameterSource("username", username),
                Integer.class
        ) > 0;
    }

    @SuppressWarnings("unchecked")
    public List<User> getAllUsers() {
        return session().createQuery("from User").list();
        //return jdbc.query("select * from users, authorities where users.username=authorities.username", BeanPropertyRowMapper.newInstance(User.class));
    }
}

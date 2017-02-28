/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.service;

import com.mycompany.mavenproject6.web.dao.User;
import com.mycompany.mavenproject6.web.dao.UsersDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilh
 */
@Service("usersService")
public class UsersService {
    
    private UsersDAO usersDao;

    @Autowired
    public void setUsersDao(UsersDAO usersDao) {
        this.usersDao = usersDao;
    }
    
    public void create(User user) {
        usersDao.create(user);
    }

    public boolean exists(String username) {
        return usersDao.exists(username);
    }

    @Secured("ROLE_ADMIN")
    public List<User> getAllUsers() {
        return usersDao.getAllUsers();
    }
}

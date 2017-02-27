/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.controllers;

import com.mycompany.mavenproject6.web.dao.User;
import com.mycompany.mavenproject6.web.service.UsersService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author guilh
 */
@Controller
public class LoginController {

    private UsersService usersService;

    @Autowired
    public void setUsersService(UsersService usersService) {
        this.usersService = usersService;
    }

    @RequestMapping("/login")
    public String showLogin() {
        return "login";
    }

    @RequestMapping("/newaccount")
    public String showNewAccount(Model model) {

        model.addAttribute("user", new User());
        return "newaccount";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String createAccount(@Valid User user, BindingResult result) {

        if (result.hasErrors()) {
            return "newaccount";
        }
        
        user.setAuthority("user");
        user.setEnabled(true);

        usersService.create(user);

        return "accountcreated";
    }
}

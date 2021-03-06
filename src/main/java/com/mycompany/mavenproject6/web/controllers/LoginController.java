/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.controllers;

import com.mycompany.mavenproject6.web.dao.User;
import com.mycompany.mavenproject6.web.service.UsersService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    
    @RequestMapping("/denied")
    public String showDenied() {
        return "denied";
    }
    
    @RequestMapping("/loggedout")
    public String showLoggedOut() {
        return "loggedout";
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

        user.setAuthority("ROLE_USER");
        user.setEnabled(true);
        
        if (usersService.exists(user.getUsername())) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        // Esse try é usado como ultimo recurso, deve ser evitado
        // Motivo:
        // - Caso quase impossível: 2 pessoas tentam criar uma conta com mesmo usuario ao mesmo tempo,
        //   como estamos em multi-thread, um dos threads irá criar a conta primeiro e o outro irá falhar.
        // Razões:
        // - Try-Catch deve ser usado para situações imprevistas
        // - (Talvez) Isso reservaria um ID no db que vai falhar, perdendo varios IDs de chave primaria atoa
        try {
            usersService.create(user);
        } catch (DuplicateKeyException e) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        return "accountcreated";
    }
    
    // Principal princiapl : usuario logado
    //  public String showAdmin(Model model, Principal principal) {
    // 
    //@RequestParam(value="delete", required=false) String delete)
    //  - se o botão submit tiver name="delete" essa string tem valor, se não, null
    @RequestMapping("/admin")
    public String showAdmin(Model model) {
        
        List<User> users = usersService.getAllUsers();
        
        model.addAttribute("users", users);
        return "admin";
    }
}

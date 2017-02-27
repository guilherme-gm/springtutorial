/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.controllers;

import com.mycompany.mavenproject6.web.dao.Offer;
import com.mycompany.mavenproject6.web.service.OffersService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author guilh
 */
@Controller
public class HomeController {
    
    @RequestMapping("/")
    public String showHome(Model model) {
        return "home";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.controllers;

import com.mycompany.mavenproject6.web.dao.Offer;
import com.mycompany.mavenproject6.web.service.OffersService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author guilh
 */
@Controller
public class OffersController {

    private OffersService offersService;

    @Autowired
    public void setOffersService(OffersService offersService) {
        this.offersService = offersService;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String showTest(Model model, @RequestParam("id") String id) {
        System.out.println("ID = " + id);
        return "home";
    }
    
//    @ExceptionHandler(DataAccessException.class)
//    public String handleDatabaseException(DataAccessException ex){
//        return "error";
//    }

    @RequestMapping("/offers")
    public String showOffers(Model model) {

        //offersService.throwTestException();
        
        List<Offer> offers = offersService.getCurrent();

        //model.addAttribute("name", "<b>Tiffany</b>");
        model.addAttribute("offers", offers);

        return "offers";
    }

    @RequestMapping("/createoffer")
    public String createOffer(Model model) {
        model.addAttribute("offer", new Offer());
        
        return "createoffer";
    }

    // Result usado para validação
    @RequestMapping(value = "/docreate", method = RequestMethod.POST)
    public String doCreate(Model model, @Valid Offer offer, BindingResult result) {
        System.out.println(offer);

        if (result.hasErrors()) {
            /*System.out.println("Form does not validate.");
            
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError err : errors) {
                System.out.println(err.getDefaultMessage());
            }*/
            
            return "createoffer";
        }
        
        offersService.create(offer);
        
        return "offercreated";
    }

    /*
    @RequestMapping("/")
    public String showHome(HttpSession session) {
        
        session.setAttribute("name", "Boris");
        
        return "home";
    }
     */
 /*
    @RequestMapping("/")
    public ModelAndView showHome() {
        ModelAndView mv = new ModelAndView("home");
        
        Map<String, Object> model = mv.getModel();
        
        model.put("name", "<b>River</b>");
        
        return mv;
    }
     */
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.service;

import com.mycompany.mavenproject6.web.dao.Offer;
import com.mycompany.mavenproject6.web.dao.OffersDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

/**
 *
 * @author guilh
 */
@Service("offersService")
public class OffersService {
    
    private OffersDAO offersDao;

    @Autowired
    public void setOffersDao(OffersDAO offersDao) {
        this.offersDao = offersDao;
    }
    
    public List<Offer> getCurrent() {
        return offersDao.getOffers();
    }

    @Secured({"ROLE_ADMIN", "ROLE_USER"})
    public void create(Offer offer) {
        offersDao.create(offer);
    }

    public void throwTestException() {
        offersDao.getOffer(9999);
    }
    
    
}

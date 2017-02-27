package com.mycompany.mavenproject6.web.dao;

import com.mycompany.mavenproject6.web.validation.ValidEmail;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author guilh
 */
public class Offer {
    private int id;
    
    @NotNull // Desnecessário no caso pq tem q ter 5 chars
    @Size(min = 5, max = 100)
    private String name;
    
    @NotNull
    //@Pattern(regexp = ".*\\@.*\\..*", message = "This does not appear to be a valid email address")
    @ValidEmail(min = 6)
    private String email;
    
    @Size(min = 20, max = 100)
    private String text;

    public Offer(int id, String name, String email, String text) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Offer(String name, String email, String text) {
        this.name = name;
        this.email = email;
        this.text = text;
    }

    public Offer() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Offer{" + "id=" + id + ", name=" + name + ", email=" + email + ", text=" + text + '}';
    }
    
}

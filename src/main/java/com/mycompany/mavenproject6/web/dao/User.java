/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.dao;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilh
 */
public class User {

    @NotBlank(message = "Username cannot be blank.")
    @Size(min = 3, max = 15, message = "Username must be between 8 and 15 characters long")
    @Pattern(regexp = "^\\w{8,}$", message = "Characters must only contain alphanumeric characters")
    private String username;
    
    @NotBlank(message = "Password cannot be blank")
    @Pattern(regexp = "^\\S+$", message = "Password cannot contain spaces")
    @Size(min = 8, max = 15, message = "Password must be between 8 and 15 characters long.")
    private String password;
    
    @NotBlank
    @Email
    private String email;
    
    
    private boolean enabled = false;
    private String authority;

    public User(String username, String password, String email, String authority) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.authority = authority;
    }

    public User() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }

}

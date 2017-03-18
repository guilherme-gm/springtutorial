/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author guilh
 */
@Entity // Define como entidade
@Table(name="users") // Define a tabela
public class User {

    @NotBlank
    @Size(min = 3, max = 15)
    @Pattern(regexp = "^\\w{8,}$")
    @Id // Define como Chave Primária
    @Column(name = "username") // Define coluna (opcional)
    private String username;
    
    @NotBlank
    @Pattern(regexp = "^\\S+$")
    @Size(min = 8, max = 15)
    @Transient
    private String password;
    
    @Column(name = "password")
    private String encryptedPassword;
    
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

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
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

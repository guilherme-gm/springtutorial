/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject6.web.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.apache.commons.validator.routines.EmailValidator;

/**
 *
 * @author guilh
 */
public class ValidEmailImpl implements ConstraintValidator<ValidEmail, String> {

    private int min;
    
    // Inicialização da anotação, por exemplo pega o min colocado na anotação
    @Override
    public void initialize(ValidEmail constraintAnnotation) {
        min = constraintAnnotation.min();
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (email.length() < min) {
            return false;
        }
        
        if (!EmailValidator.getInstance(false).isValid(email)) {
            return false;
        }
        
        return true;
    }
    
}

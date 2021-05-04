package com.proyectoweb.barberia.Users.User.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.EmailFormatError;

import java.util.regex.Pattern;

public class UserEmail extends StringValueObject {
    public UserEmail(String value){
        this.validate(value);
        this.value = value;
    }

    public UserEmail(){}

    private void validate(String value){
        this.formatRule(value);
    }

    private void formatRule(String value){
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        boolean match = pattern.matcher(value).find();
        if(!match){
            throw new EmailFormatError("Email format not valid");
        }
    }
}

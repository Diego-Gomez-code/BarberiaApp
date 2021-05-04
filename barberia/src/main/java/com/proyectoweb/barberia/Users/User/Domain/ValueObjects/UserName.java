package com.proyectoweb.barberia.Users.User.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.LengthNotValid;

public class UserName extends StringValueObject {
    
    public UserName(String value) {
        this.validate(value);
        this.value = value;
    }

    public UserName(){}

    private void validate(String value) {
        this.lenghtRule(value);
        //TODO: Other Rules
    }

    private void lenghtRule(String value) {
        if (value.length() < 8) {
            throw new LengthNotValid("Number of characters invalid");
        }
    }
}

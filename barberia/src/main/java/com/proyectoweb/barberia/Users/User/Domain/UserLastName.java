package com.proyectoweb.barberia.Users.User.Domain;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;

public class UserLastName extends StringValueObject {

    public UserLastName(String value) {
        this.validate(value);
        this.value = value;
    }

    private void validate(String value) {
        this.lenghtRule(value);
        //TODO: Other Rules
    }

    private void lenghtRule(String value) {
        if (value.length() < 3) {
            throw new LengthNotValid("Number of characters invalid");
        }
    }

}

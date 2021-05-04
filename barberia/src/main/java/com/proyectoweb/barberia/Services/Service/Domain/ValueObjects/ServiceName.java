package com.proyectoweb.barberia.Services.Service.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.LengthNotValid;

public class ServiceName extends StringValueObject {

    public ServiceName(String value){
        this.validate(value);
        this.value = value;
    }
    private void validate(String value) {
        this.lenghtRule(value);
        //TODO: Other Rules Service name
    }

    private void lenghtRule(String value) {
        if (value.length() < 8) {
            throw new LengthNotValid("Number of characters invalid");
        }
    }
}

package com.proyectoweb.barberia.Services.Service.Domain.ValueObjects;

import com.proyectoweb.barberia.Services.Service.Domain.Exceptions.DescriptionNotValid;
import com.proyectoweb.barberia.Shared.Domain.StringValueObject;
import com.proyectoweb.barberia.Users.User.Domain.LengthNotValid;

public class ServiceDescription{

    private String value;

    public ServiceDescription(String value) {
        this.validate(value);
        this.value = value;
    }
    private void validate(String value) {
        this.lenghtRule(value);
        //TODO: Other Rules Service name
    }
    private void lenghtRule(String value) {
        if (value.length() < 0) {
            throw new DescriptionNotValid("Number of characters invald");
        }
    }
}

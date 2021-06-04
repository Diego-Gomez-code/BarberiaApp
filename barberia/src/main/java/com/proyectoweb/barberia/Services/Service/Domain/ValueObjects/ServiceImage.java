package com.proyectoweb.barberia.Services.Service.Domain.ValueObjects;

import com.proyectoweb.barberia.Services.Service.Domain.Exceptions.DescriptionNotValid;

public class ServiceImage {

    private String value;

    public ServiceImage(String value) {
        this.validate(value);
        this.value = value;
    }

    public ServiceImage() {

    }

    public String value() {
        return value;
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

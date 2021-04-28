package com.proyectoweb.barberia.Users.User.Domain;

public class LengthNotValid extends RuntimeException{
    public LengthNotValid(String message) {
        super(message);
    }
}

package com.proyectoweb.barberia.Users.User.Domain.Exceptions;

public class LengthNotValid extends RuntimeException{
    public LengthNotValid(String message) {
        super(message);
    }
}

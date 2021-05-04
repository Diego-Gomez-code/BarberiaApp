package com.proyectoweb.barberia.Users.User.Domain;

public class UserAlreadyExists extends RuntimeException{
    public UserAlreadyExists(String message) {
        super(message);
    }
}

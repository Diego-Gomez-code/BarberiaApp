package com.proyectoweb.barberia.Users.User.Domain;

public class UserNotExist extends RuntimeException {

    public UserNotExist(String message) {
        super(message);
    }
}

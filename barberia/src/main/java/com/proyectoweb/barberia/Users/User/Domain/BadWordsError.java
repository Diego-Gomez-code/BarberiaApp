package com.proyectoweb.barberia.Users.User.Domain;

public class BadWordsError extends RuntimeException {
    public BadWordsError(String mesagge) {
        super(mesagge);
    }
}

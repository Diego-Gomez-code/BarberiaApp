package com.proyectoweb.barberia.Users.User.Domain.Exceptions;

public class BadWordsError extends RuntimeException {
    public BadWordsError(String mesagge) {
        super(mesagge);
    }
}

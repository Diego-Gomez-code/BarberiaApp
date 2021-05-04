package com.proyectoweb.barberia.Users.User.Domain;

public class EmailFormatError extends RuntimeException{
    public EmailFormatError(String message){
        super(message);
    }
}

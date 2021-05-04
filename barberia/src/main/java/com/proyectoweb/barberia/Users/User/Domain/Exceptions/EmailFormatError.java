package com.proyectoweb.barberia.Users.User.Domain.Exceptions;

public class EmailFormatError extends RuntimeException{
    public EmailFormatError(String message){
        super(message);
    }
}

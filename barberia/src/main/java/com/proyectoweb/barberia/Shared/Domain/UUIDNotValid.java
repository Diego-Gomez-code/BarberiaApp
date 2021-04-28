package com.proyectoweb.barberia.Shared.Domain;

public class UUIDNotValid extends RuntimeException {
    public UUIDNotValid(String message){
        super(message);
    }
}

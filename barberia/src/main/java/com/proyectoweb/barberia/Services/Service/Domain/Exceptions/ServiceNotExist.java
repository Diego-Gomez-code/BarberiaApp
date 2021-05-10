package com.proyectoweb.barberia.Services.Service.Domain.Exceptions;

public class ServiceNotExist extends RuntimeException{
    public ServiceNotExist(String message){
        super(message);
    }
}

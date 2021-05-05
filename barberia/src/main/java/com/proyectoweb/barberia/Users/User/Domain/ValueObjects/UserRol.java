package com.proyectoweb.barberia.Users.User.Domain.ValueObjects;

import com.proyectoweb.barberia.Shared.Domain.StringValueObject;
import com.proyectoweb.barberia.Users.User.Domain.Exceptions.RolError;

public class UserRol extends StringValueObject {

    public UserRol(String value){
        this.validate(value);
        this.value = value;
    }

    public UserRol(){}

    public void validate(String value){
        this.clienteDuenoRol(value);
    }

    public void clienteDuenoRol(String value){
        if(!(value.equals("Dueño") || value.equals("Cliente"))){
            throw new RolError("El rol de usuario solo puede ser Cliente o dueño.");
        }
    }
}

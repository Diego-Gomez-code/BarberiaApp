package com.proyectoweb.barberia.Shared.Domain.Users;

import com.proyectoweb.barberia.Shared.Domain.CustomUUID;

public class UserId extends CustomUUID {

    public UserId(String value) {
        super(value);
    }
    private UserId(){
        super("");
    }
}

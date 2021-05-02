package com.proyectoweb.barberia.Users.User.Application.All;

import com.proyectoweb.barberia.Users.User.Domain.User;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserAllResponse {

    private List<User> usuarios;

    public UserAllResponse(List<User> usuarios){
        this.usuarios = usuarios;
    }

    public List<HashMap> response(){
        List<HashMap> response = usuarios.stream().map(u -> u.data()).collect(Collectors.toList());
        return response;
    }
}

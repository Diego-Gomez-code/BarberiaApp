package com.proyectoweb.barberia.Users.User.Application.Find;

import com.proyectoweb.barberia.Shared.Application.Response;
import com.proyectoweb.barberia.Users.User.Domain.User;

import java.util.HashMap;

public class UserFinderResponse implements Response {

    private User user;

    public UserFinderResponse(User user){
        this.user = user;
    }

    public HashMap response(){
        HashMap response = this.user.data();
        response.remove("id");
        return response;
    }
}

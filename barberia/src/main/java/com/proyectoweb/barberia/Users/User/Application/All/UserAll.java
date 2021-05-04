package com.proyectoweb.barberia.Users.User.Application.All;

import com.proyectoweb.barberia.Users.User.Domain.User;
import com.proyectoweb.barberia.Users.User.Domain.UserRepository;
import com.proyectoweb.barberia.Users.User.Domain.UsersEmpty;

import java.util.List;
import java.util.Optional;

public class UserAll {

    private UserRepository repository;

    public UserAll(UserRepository repository){
        this.repository = repository;
    }

    public List<User> execute(){
        Optional<List<User>> users = repository.all();
        if(users.isEmpty()){
            throw new UsersEmpty("No hay ningun usuario parce :/");
        }
        return users.get();
    }
}

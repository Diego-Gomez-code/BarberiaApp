package com.proyectoweb.barberia.Users.User.Application.Find;

import com.proyectoweb.barberia.Shared.Domain.Users.UserId;
import com.proyectoweb.barberia.Users.User.Domain.User;
import com.proyectoweb.barberia.Users.User.Domain.UserDomainFinder;
import com.proyectoweb.barberia.Users.User.Domain.UserRepository;

import java.util.Optional;

public class UserFinder {

    private UserDomainFinder finder;

    public UserFinder(UserRepository repository){
        this.finder = new UserDomainFinder(repository);
    }

    public User execute(String userId){
        Optional<User> usuario = finder.execute(new UserId(userId).value());
        return usuario.get();
    }
}

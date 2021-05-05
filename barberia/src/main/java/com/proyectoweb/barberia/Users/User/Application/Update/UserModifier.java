package com.proyectoweb.barberia.Users.User.Application.Update;

import com.proyectoweb.barberia.Users.User.Domain.*;
<<<<<<< HEAD
=======
import com.proyectoweb.barberia.Users.User.Domain.Ports.UserRepository;
import com.proyectoweb.barberia.Users.User.Domain.ValueObjects.*;
>>>>>>> Rama1

import java.util.Optional;

public class UserModifier {

    private UserRepository repository;
    private UserDomainFinder finder;
    private UserValidateWords validator;
    private ValidateWordService service;

    public UserModifier(UserRepository repository, ValidateWordService service) {
        this.repository = repository;
        this.service = service;
        this.finder = new UserDomainFinder(repository);
        this.validator = new UserValidateWords(service);
    }

    public void execute(String userId, String userFirstName, String userLastName, String userName, String userEmail, String userRol){
        validator.execute(new UserName(userName).value());
        Optional<User> actualUser = finder.execute(userId);
        User oldUser = actualUser.get();
        oldUser.updateUser(new UserFirstName(userFirstName), new UserLastName(userLastName), new UserName(userName), new UserEmail(userEmail), new UserRol(userRol));
        repository.update(userId, oldUser);
    }
}

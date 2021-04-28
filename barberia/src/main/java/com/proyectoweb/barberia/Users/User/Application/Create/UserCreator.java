package com.proyectoweb.barberia.Users.User.Application.Create;

import com.proyectoweb.barberia.Shared.Domain.Users.UserId;
import com.proyectoweb.barberia.Users.User.Domain.*;

public class UserCreator {
    private UserRepository repository;
    private ValidateWordService service;
    private UserValidateWords validator;
    private UserDomainFinder finder;

    public UserCreator(UserRepository repository, ValidateWordService service){
        this.repository = repository;
        this.service = service;
        this.validator = new UserValidateWords(service);
        this.finder = new UserDomainFinder(repository);
    }

    public void execute(String userId, String userFirstName, String userLastName, String userName, String userPassword){
        this.validate(userId);
        validator.execute(new UserName(userName).value());
        User user = new User(new UserId(userId), new UserFirstName(userFirstName), new UserLastName(userLastName), new UserName(userName), new UserPassword(userPassword));
        repository.save(user);
    }
    private void validate(String userId){
        try {
            this.finder.execute(userId);
        } catch (UserNotExist e) { }
    }
}

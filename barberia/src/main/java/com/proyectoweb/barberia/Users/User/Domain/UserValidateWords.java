package com.proyectoweb.barberia.Users.User.Domain;

public class UserValidateWords {

    private ValidateWordService service;

    public UserValidateWords(ValidateWordService service) {
        this.service = service;
    }

    public void execute(String word){
        if (service.validate(word)){
            throw new BadWordsError("The username contains bad words");
        }
    }
}

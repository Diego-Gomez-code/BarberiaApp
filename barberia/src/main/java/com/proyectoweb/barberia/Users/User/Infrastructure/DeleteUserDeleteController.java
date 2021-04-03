package com.proyectoweb.barberia.Users.User.Infrastructure;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class DeleteUserDeleteController {

    @DeleteMapping(value = "/{username}/delete")
    public void execute(@PathVariable("username") String username){
        //TODO: delete user
    }
}

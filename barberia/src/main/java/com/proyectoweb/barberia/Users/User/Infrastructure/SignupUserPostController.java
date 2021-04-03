package com.proyectoweb.barberia.Users.User.Infrastructure;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class SignupUserPostController {
    /*
    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public String execute(@RequestBody User user){
        //TODO: Signup
        return "";
    }
     */
}

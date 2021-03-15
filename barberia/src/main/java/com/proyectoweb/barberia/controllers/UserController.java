package com.proyectoweb.barberia.controllers;

import com.proyectoweb.barberia.models.User;
import com.proyectoweb.barberia.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.proyectoweb.barberia.BarberiaApplication.LOGGER;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> usuarios = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            usuarios = this.userService.getAllUsers();
            codigo = HttpStatus.OK;
        } catch (Exception e){
            LOGGER.error("UserController.getAllUsers Causa: " + e.toString());
        }
        return new ResponseEntity<List<User>>(usuarios, codigo);
    }

}

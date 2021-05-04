package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.ServiceCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/service")
public final class CreateServicePostController {

    @Autowired
    private ServiceCreator serviceCreator;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String execute(){
        return "entro sisisisiis";
    }
}

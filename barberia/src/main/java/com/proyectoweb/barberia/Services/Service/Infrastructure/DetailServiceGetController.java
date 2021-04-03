package com.proyectoweb.barberia.Services.Service.Infrastructure;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services")
public class DetailServiceGetController {
    /*
    @GetMapping(value = "/{idService}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Service> execute(@PathVariable("idService") String idService){
        //TODO: detail service
    }

     */
}

package com.proyectoweb.barberia.Services.Service.Infrastructure;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/services")
public class DeleteServiceDeleteController {

    @DeleteMapping(value = "/{idService}/delete")
    public void execute(@PathVariable("idService") String idService){

    }
}

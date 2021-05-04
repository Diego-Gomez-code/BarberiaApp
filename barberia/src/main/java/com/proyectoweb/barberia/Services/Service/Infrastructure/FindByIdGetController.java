package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.ServiceFindById;
import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Optional;

@RestController
@RequestMapping(value = "/service")
public class FindByIdGetController {

    @Autowired
    private ServiceFindById serviceFindById;

    @GetMapping(value = "find/{id}")
    public String execute(@PathParam("id") String id){

        String nuevo =  serviceFindById.execute(id);
        if(nuevo == null){
            return "entro es problema de logica";
        }
        return nuevo;
    }
}

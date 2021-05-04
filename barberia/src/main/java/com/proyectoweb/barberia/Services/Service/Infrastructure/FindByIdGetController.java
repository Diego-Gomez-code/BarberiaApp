package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.Find.ServiceFindById;
import com.proyectoweb.barberia.Services.Service.Application.Find.ServiceFindByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;

@RestController
@RequestMapping(value = "/service")
public class FindByIdGetController {

    @Autowired
    private ServiceFindById serviceFindById;

    @GetMapping(value = "find/{id}")
    public ResponseEntity execute(@PathVariable("id") String id){
        ServiceFindByIdResponse response = serviceFindById.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}

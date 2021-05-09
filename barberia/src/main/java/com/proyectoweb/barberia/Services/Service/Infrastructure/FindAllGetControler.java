package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.All.ServiceFindAll;
import com.proyectoweb.barberia.Services.Service.Application.All.ServiceFindAllResponse;
import com.proyectoweb.barberia.Services.Service.Application.ServiceCreator;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/service")
public class FindAllGetControler {

    @Autowired
    private ServiceFindAll serviceFindAll;

    @RequestMapping(value = "/findAll")
    public ResponseEntity<List<HashMap>> execute(){
        ServiceFindAllResponse response = new ServiceFindAllResponse(serviceFindAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

}

package com.proyectoweb.barberia.Services.CarritoService.Infrastructure;


import com.proyectoweb.barberia.Services.CarritoService.Application.All.CarritoFindAll;
import com.proyectoweb.barberia.Services.CarritoService.Application.All.CarritoFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/carritoservice")
public class FindAllCarritosGetController {

    @Autowired
    private CarritoFindAll carritoFindAll;

    @GetMapping(value = "/findAll")
    private ResponseEntity<List<HashMap>> execute(){
        System.out.println("entro al controller");
        CarritoFindAllResponse response = new CarritoFindAllResponse(carritoFindAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}

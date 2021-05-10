package com.proyectoweb.barberia.Services.Service.Infrastructure;



import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.CarritoCompraNotExist;
import com.proyectoweb.barberia.Services.Service.Application.ServiceDeleter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/service")
public class DeleteServicePostController {

    @Autowired
    private ServiceDeleter deleter;

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@PathVariable("id") String id){
        deleter.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(CarritoCompraNotExist.class)
    public ResponseEntity<HashMap> handleServiceNotExistException(CarritoCompraNotExist exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

}

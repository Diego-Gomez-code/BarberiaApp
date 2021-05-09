package com.proyectoweb.barberia.Products.CarritoCompra.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.CarritoCompra.Application.Delete.CarritoDeleter;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.CarritoCompraNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/carritocompra")
public class DeleteCarritoCompraPostController {

    @Autowired
    private CarritoDeleter deleter;

    @PostMapping(value = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@PathVariable("id") String id){
        deleter.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(CarritoCompraNotExist.class)
    public ResponseEntity<HashMap> handleCarritoNotExistException(CarritoCompraNotExist exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

}

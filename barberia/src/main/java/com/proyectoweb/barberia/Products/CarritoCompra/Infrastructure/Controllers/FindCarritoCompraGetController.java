package com.proyectoweb.barberia.Products.CarritoCompra.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.CarritoCompra.Application.Find.CarritoCompraFinder;
import com.proyectoweb.barberia.Products.CarritoCompra.Application.Find.CarritoCompraResponse;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.CarritoCompraNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/carritocompra")
public class FindCarritoCompraGetController {

    @Autowired
    private CarritoCompraFinder finder;

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<HashMap> execute(@PathVariable("id") String id){
        CarritoCompraResponse response = finder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(CarritoCompraNotExist.class)
    public ResponseEntity<HashMap> handleCarritoNotExistException(CarritoCompraNotExist exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

}

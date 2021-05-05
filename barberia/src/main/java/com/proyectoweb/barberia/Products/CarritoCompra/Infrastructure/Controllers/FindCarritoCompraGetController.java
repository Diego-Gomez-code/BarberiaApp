package com.proyectoweb.barberia.Products.CarritoCompra.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.CarritoCompra.Application.Find.CarritoCompraFinder;
import com.proyectoweb.barberia.Products.CarritoCompra.Application.Find.CarritoCompraResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}

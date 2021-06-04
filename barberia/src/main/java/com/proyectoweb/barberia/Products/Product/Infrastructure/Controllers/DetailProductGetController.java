package com.proyectoweb.barberia.Products.Product.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.Product.Application.Find.ProductFinder;
import com.proyectoweb.barberia.Products.Product.Application.Find.ProductFinderResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/products")
public class DetailProductGetController {

    @Autowired
    private ProductFinder finder;

    @GetMapping(value = "/find/{id}")
    public ResponseEntity<HashMap> execute(@PathVariable("id") String id){
        ProductFinderResponse response = finder.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> handleRuntimeException(RuntimeException exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }
}

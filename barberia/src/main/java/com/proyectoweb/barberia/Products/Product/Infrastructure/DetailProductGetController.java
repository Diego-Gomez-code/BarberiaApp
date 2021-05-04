package com.proyectoweb.barberia.Products.Product.Infrastructure;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class DetailProductGetController {
    /*
    @GetMapping(value = "/{idProcut}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> execute(@PathVariable("idProduct") String idProduct){
        //TODO: detail product
    }

     */
}

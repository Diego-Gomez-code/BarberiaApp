package com.proyectoweb.barberia.Products.Product.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.Product.Application.All.ProductAll;
import com.proyectoweb.barberia.Products.Product.Application.All.ProductAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(value = "/products")
public class ProductsGetController {

    @Autowired
    private ProductAll productAll;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap>> execute(){
        ProductAllResponse response = new ProductAllResponse(productAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}

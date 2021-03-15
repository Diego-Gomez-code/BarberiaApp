package com.proyectoweb.barberia.controllers;

import com.proyectoweb.barberia.models.Product;
import com.proyectoweb.barberia.models.User;
import com.proyectoweb.barberia.services.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.proyectoweb.barberia.BarberiaApplication.LOGGER;

@RestController
@RequestMapping(value = "/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> productos = null;
        HttpStatus codigo = HttpStatus.FORBIDDEN;
        try {
            productos = this.productService.getAllProducts();
            codigo = HttpStatus.OK;
        } catch (Exception e){
            LOGGER.error("ProductController.getAllProducts Causa: " + e.toString());
        }
        return new ResponseEntity<List<Product>>(productos, codigo);
    }

}

package com.proyectoweb.barberia.Products.Product.Infrastructure.Controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class DeleteProductDeleteController {

    @DeleteMapping(value = "/{idProduct}/delete")
    public void execute(@PathVariable("idProduct") String idProduct){
        //TODO: delete product
    }
}

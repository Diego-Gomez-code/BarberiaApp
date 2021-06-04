package com.proyectoweb.barberia.Products.Product.Infrastructure.Controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/products")
public class DeleteProductDeleteController {

    @DeleteMapping(value = "/{idProduct}/delete")
    public void execute(@PathVariable("idProduct") String idProduct){
        //TODO: delete product
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> handleRuntimeException(RuntimeException exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }
}

package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.ServiceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/service")
public class UpdateServicePostCrontoller {

    @Autowired
    private ServiceUpdate serviceUpdate;

    @PostMapping(value = "/update/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@PathVariable("id") String id, @RequestBody Request request){
        serviceUpdate.execute(id, request.getName(), request.getDescription(), request.getPrice());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> handleRuntimeException(RuntimeException exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    static class Request {
        private String name;
        private String description;
        private Double price;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}

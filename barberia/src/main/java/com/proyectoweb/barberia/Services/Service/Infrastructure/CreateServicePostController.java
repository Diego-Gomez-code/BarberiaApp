package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.ServiceCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/service")
public final class CreateServicePostController {

    @Autowired
    private ServiceCreator serviceCreator;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){

        serviceCreator.execute(request.getId(), request.getName(), request.getDescription(), request.getPrice());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String id;
        private String name;
        private String description;
        private Double price;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

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

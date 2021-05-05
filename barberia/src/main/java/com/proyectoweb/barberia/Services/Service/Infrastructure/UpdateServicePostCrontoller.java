package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.ServiceUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@RequestMapping(value = "/service")
public class UpdateServicePostCrontoller {

    @Autowired
    private ServiceUpdate serviceUpdate;

    @PostMapping(value = "/update" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        return null;
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

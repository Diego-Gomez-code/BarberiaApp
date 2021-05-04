package com.proyectoweb.barberia.Products.Product.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.Product.Application.Create.ProductCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/products")
public class CreateProductPostController {

    @Autowired
    private ProductCreator creator;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        creator.execute(request.getId(), request.getName(), request.getAmount(), request.getPrice(), request.getDescription());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    static class Request {
        private String id;
        private String name;
        private Integer amount;
        private Double price;
        private String description;

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

        public Integer getAmount() {
            return amount;
        }

        public void setAmount(Integer amount) {
            this.amount = amount;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


}

package com.proyectoweb.barberia.Products.Product.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.Product.Application.Update.ProductModifier;
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
public class ProductUpdatePostController {

    @Autowired
    private ProductModifier modifier;

    @PostMapping(value = "/update",  produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        modifier.execute(request.getUserId(), request.getProductId(), request.getName(), request.getAmount(), request.getPrice(), request.getDescription());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    static class Request {
        private String userId;
        private String productId;
        private String name;
        private Integer amount;
        private Double price;
        private String description;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getProductId() {
            return productId;
        }

        public void setProductId(String productId) {
            this.productId = productId;
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

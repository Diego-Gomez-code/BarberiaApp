package com.proyectoweb.barberia.Products.CarritoCompra.Infrastructure.Controllers;

import com.proyectoweb.barberia.Products.CarritoCompra.Application.AddProduct.CarritoAddProduct;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.CarritoCompraNotExist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/carritocompra")
public class AddProductCarritoPostController {

    @Autowired
    private CarritoAddProduct add;

    @PostMapping(value = "/addproduct", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        System.out.println("productid: " + request.getProductId());
        add.execute(request.getCarritoCompraId(), request.getProductId(), request.getName(), request.getQuantity(), request.getPrice());
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(null);
    }

    @ExceptionHandler(CarritoCompraNotExist.class)
    public ResponseEntity<HashMap> handleRuntimeException(CarritoCompraNotExist exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    static class Request {
        private String carritoCompraId;
        private String productId;
        private String name;
        private Integer quantity;
        private Double price;

        public String getCarritoCompraId() {
            return carritoCompraId;
        }

        public void setCarritoCompraId(String carritoCompraId) {
            this.carritoCompraId = carritoCompraId;
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

        public Integer getQuantity() {
            return quantity;
        }

        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

        public Double getPrice() {
            return price;
        }

        public void setPrice(Double price) {
            this.price = price;
        }
    }
}

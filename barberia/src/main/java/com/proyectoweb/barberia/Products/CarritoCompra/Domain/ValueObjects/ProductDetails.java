package com.proyectoweb.barberia.Products.CarritoCompra.Domain.ValueObjects;

import java.util.HashMap;
import java.util.Objects;

public class ProductDetails {
    private String productId;
    private String name;
    private Integer quantity;
    private Double price;

    public ProductDetails(String productId, String name, Integer quantity, Double price) {
        this.productId = productId;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public ProductDetails(){}

    public HashMap<String, Object> data(){
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            put("id", productId);
            put("name", name);
            put("quantity", quantity);
            put("price", price);
        }};
        return data;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDetails that = (ProductDetails) o;
        return Objects.equals(productId, that.productId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(quantity, that.quantity) &&
                Objects.equals(price, that.price);
    }

    @Override
    public int hashCode(){
        return Objects.hash(productId, name, quantity, price);
    }

    public String getProductId(){
        return this.productId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public boolean equalsProductId(ProductDetails productDetails){
        return this.productId.equals(productDetails.getProductId());
    }
}

package com.proyectoweb.barberia.Products.Product.Domain;

import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductAmount;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductDescription;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductName;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductPrice;
import com.proyectoweb.barberia.Shared.Domain.Products.ProductId;

import java.util.HashMap;
import java.util.Objects;

public class Product {

    ProductId productId;
    ProductName productName;
    ProductAmount productAmount;
    ProductPrice productPrice;
    ProductDescription productDescription;

    public Product(ProductId productId, ProductName productName, ProductAmount productAmount, ProductPrice productPrice, ProductDescription productDescription) {
        this.productId = productId;
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    public Product(){}

    public HashMap<String, Object> data(){
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            //put("id", productId.value());
            put("name", productName.value());
            put("amount", productAmount.value());
            put("price", productPrice.value());
            put("description", productDescription.value());
        }};
        return data;
    }

    public void updateProduct(ProductName productName, ProductAmount productAmount, ProductPrice productPrice, ProductDescription productDescription){
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) &&
                Objects.equals(productName, product.productName) &&
                Objects.equals(productAmount, product.productAmount) &&
                Objects.equals(productPrice, product.productPrice) &&
                Objects.equals(productDescription, product.productDescription);
    }
}

package com.proyectoweb.barberia.Products.Product.Domain;

import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.*;
import com.proyectoweb.barberia.Shared.Domain.Products.ProductId;

import java.util.HashMap;
import java.util.Objects;

public class Product {

    ProductId productId;
    ProductName productName;
    ProductAmount productAmount;
    ProductPrice productPrice;
    ProductDescription productDescription;
    ProductImage productImage;

    public Product(ProductId productId, ProductName productName, ProductAmount productAmount, ProductPrice productPrice, ProductDescription productDescription, ProductImage productImage) {
        this.productId = productId;
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImage = productImage;
    }

    public Product(){}

    public HashMap<String, Object> data(){
        HashMap<String, Object> data = new HashMap<String, Object>(){{
            //put("id", productId.value());
            put("name", productName.value());
            put("amount", productAmount.value());
            put("price", productPrice.value());
            put("description", productDescription.value());
            put("image", productImage.value());
        }};
        return data;
    }

    public void updateProduct(ProductName productName, ProductAmount productAmount, ProductPrice productPrice, ProductDescription productDescription, ProductImage productImage){
        this.productName = productName;
        this.productAmount = productAmount;
        this.productPrice = productPrice;
        this.productDescription = productDescription;
        this.productImage = productImage;
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
                Objects.equals(productDescription, product.productDescription) &&
                Objects.equals(productImage, product.productImage);
    }
}

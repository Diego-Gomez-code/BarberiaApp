package com.proyectoweb.barberia.Products.Product.Application.Create;

import com.proyectoweb.barberia.Products.Product.Domain.Ports.ProductRepository;
import com.proyectoweb.barberia.Products.Product.Domain.Product;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductAmount;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductDescription;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductName;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductPrice;
import com.proyectoweb.barberia.Shared.Domain.Products.ProductId;

public class ProductCreator {

    private ProductRepository repository;

    public ProductCreator(ProductRepository repository){
        this.repository = repository;
    }

    public void execute(String productId, String productName, Integer productAmount, Double productPrice, String productDescription){
        Product product = new Product(new ProductId(productId), new ProductName(productName), new ProductAmount(productAmount), new ProductPrice(productPrice), new ProductDescription(productDescription));
        repository.save(product);
    }
}

package com.proyectoweb.barberia.Products.Product.Application.Find;

import com.proyectoweb.barberia.Products.Product.Domain.Ports.ProductRepository;
import com.proyectoweb.barberia.Products.Product.Domain.Product;
import com.proyectoweb.barberia.Shared.Domain.Products.ProductId;

import java.util.Optional;

public class ProductFinder {

    private ProductRepository repository;

    public ProductFinder(ProductRepository repository){
        this.repository = repository;
    }

    public ProductFinderResponse execute(String id){
        Optional<Product> result = repository.find(new ProductId(id).value());
        if(result.isEmpty()){
            throw new RuntimeException("No hay productos.");
        }
        Product product = result.get();
        return new ProductFinderResponse(product);
    }
}

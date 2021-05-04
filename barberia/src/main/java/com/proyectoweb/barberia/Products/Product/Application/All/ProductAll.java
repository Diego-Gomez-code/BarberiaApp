package com.proyectoweb.barberia.Products.Product.Application.All;

import com.proyectoweb.barberia.Products.Product.Domain.Exceptions.ProductEmptyError;
import com.proyectoweb.barberia.Products.Product.Domain.Ports.ProductRepository;
import com.proyectoweb.barberia.Products.Product.Domain.Product;;import java.util.List;
import java.util.Optional;

public class ProductAll {

    private ProductRepository repository;

    public ProductAll(ProductRepository repository){
        this.repository = repository;
    }

    public List<Product> execute(){
        Optional<List<Product>> productos = repository.all();
        if(productos.isEmpty()){
            throw new ProductEmptyError("There's no products");
        }
        return productos.get();
    }
}

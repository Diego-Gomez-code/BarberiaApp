package com.proyectoweb.barberia.Products.Product.Domain.Ports;

import com.proyectoweb.barberia.Products.Product.Domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    void update(Product product);
    Optional<Product> find(String productId);
    void save(Product product);
    Optional<List<Product>> all();
}

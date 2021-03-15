package com.proyectoweb.barberia.services;

import com.proyectoweb.barberia.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public Product addProduct(Product product) throws Exception;
    public void updateProduct(Product product) throws Exception;
    public void deleteProduct(Product product) throws  Exception;
    public Product getProduct(int idProduct) throws  Exception;
    public List<Product> getAllProducts() throws  Exception;
}

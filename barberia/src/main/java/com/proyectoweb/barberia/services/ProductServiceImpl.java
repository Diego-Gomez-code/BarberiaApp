package com.proyectoweb.barberia.services;

import com.proyectoweb.barberia.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.proyectoweb.barberia.BarberiaApplication.LOGGER;

@Service
public class ProductServiceImpl implements ProductService {

    ProductServiceRepository repository;

    @Autowired
    public ProductServiceImpl(ProductServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product addProduct(Product product) throws Exception {
        return null;
    }

    @Override
    public void updateProduct(Product product) throws Exception {

    }

    @Override
    public void deleteProduct(Product product) throws Exception {

    }

    @Override
    public Product getProduct(int idProduct) throws Exception {
        return null;
    }

    @Override
    public List<Product> getAllProducts() throws Exception {
        List<Product> productos = null;
        try {
            productos = this.repository.findAll();
        } catch(Exception e){
            LOGGER.error("ProductServiceImpl.getAllProducts Causa: " + e.toString());
            throw new Exception("ProductServiceImpl.getAllProducts Causa: " + e.toString());
        }
        return productos;
    }
}

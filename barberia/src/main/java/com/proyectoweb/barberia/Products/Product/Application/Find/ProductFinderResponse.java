package com.proyectoweb.barberia.Products.Product.Application.Find;

import com.proyectoweb.barberia.Products.Product.Domain.Product;
import com.proyectoweb.barberia.Shared.Application.Response;

import java.util.HashMap;

public class ProductFinderResponse implements Response {

    private final Product product;
    private HashMap<String, Object> response;

    public ProductFinderResponse(Product product) {
        this.product = product;
    }

    @Override
    public HashMap<String, Object> response() {
        this.response = product.data();
        return response;
    }



}

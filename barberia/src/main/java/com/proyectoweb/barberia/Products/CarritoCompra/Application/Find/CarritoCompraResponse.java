package com.proyectoweb.barberia.Products.CarritoCompra.Application.Find;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.CarritoCompra;
import com.proyectoweb.barberia.Shared.Application.Response;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public class CarritoCompraResponse implements Response {

    private final CarritoCompra carritoCompra;
    private HashMap<String, Object> response;

    public CarritoCompraResponse(CarritoCompra carritoCompra){
        this.carritoCompra = carritoCompra;
    }

    @Override
    public HashMap<String, Object> response() {
        this.response = carritoCompra.data();
        this.setProducts();
        return response;
    }

    private void setProducts(){
        Optional<List<HashMap<String, Object>>> products = this.carritoCompra.getProducts();
        if(products.isPresent()){
            products.ifPresent(productList -> response.put("products", productList));
        } else {
            response.put("products", null);
        }
    }
}

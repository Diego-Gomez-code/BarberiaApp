package com.proyectoweb.barberia.Products.CarritoCompra.Domain;

import com.proyectoweb.barberia.Products.CarritoCompra.Domain.Exceptions.NoProductsError;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.ValueObjects.CompraTotal;
import com.proyectoweb.barberia.Products.CarritoCompra.Domain.ValueObjects.ProductDetails;
import com.proyectoweb.barberia.Products.Product.Domain.Product;
import com.proyectoweb.barberia.Shared.Domain.Products.CarritoCompraId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CarritoCompra {

    private CarritoCompraId carritoCompraId;
    private CompraTotal compraTotal;
    private Optional<List<ProductDetails>> products;

    public CarritoCompra(CarritoCompraId carritoCompraId, CompraTotal compraTotal, List<ProductDetails> products) {
        this.carritoCompraId = carritoCompraId;
        this.compraTotal = compraTotal;
        this.products = Optional.ofNullable(products);
    }

    public CarritoCompra(){}

    public static CarritoCompra create(CarritoCompraId carritoCompraId){
        return new CarritoCompra(carritoCompraId, new CompraTotal(0d), null);
    }

    public void updateCompraTotal(Double compra){
        Double newTotal = this.compraTotal.value() + compra;
        this.compraTotal = new CompraTotal(newTotal);
    }

    public void updateCompraTotalMinus(Double compra){
        Double newTotal = this.compraTotal.value() - compra;
        this.compraTotal = new CompraTotal(newTotal);
    }

    public Optional<List<HashMap<String, Object>>> getProducts(){
        Optional<List<HashMap<String, Object>>> response = Optional.empty();
        if(this.products.isPresent()){
            response = Optional.of(this.products.get().stream().map(product -> product.data()).collect(Collectors.toList()));
        }
        return response;
    }

    public void addProduct(ProductDetails productDetails){
        List<ProductDetails> productsList = this.products.isEmpty() ? new ArrayList<>() : this.products.get();
        productsList.add(productDetails);
        updateCompraTotal(productDetails.getPrice() * productDetails.getQuantity());
        System.out.println("productid 2: " + productDetails.getProductId());
        this.products = Optional.ofNullable(productsList);
    }

    public void updateProduct(ProductDetails productDetails){
        List<ProductDetails> productsList = this.products.get();
        ProductDetails actual = productsList.stream().filter(product -> product.equalsProductId(productDetails)).findFirst().get();
        productsList.remove(actual);
        productsList.add(productDetails);
        this.products = Optional.ofNullable(productsList);
    }

    public void removeProduct(ProductDetails productDetails){
        if(this.products.isEmpty()){
            throw new NoProductsError("No hay productos en el carrito.");
        }
        List<ProductDetails> productsList = this.products.get();
        ProductDetails actual = productsList.stream().filter(product -> product.equalsProductId(productDetails)).findFirst().get();
        productsList.remove(actual);
        updateCompraTotalMinus(productDetails.getPrice() * productDetails.getQuantity());
        this.products = Optional.ofNullable(productsList);
    }

    public HashMap<String, Object> data(){
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("id", carritoCompraId.value());
            put("total", compraTotal.value());
        }};
        return data;
    }

}

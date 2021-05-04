package com.proyectoweb.barberia.Products.Product.Application.Update;

import com.proyectoweb.barberia.Products.Product.Domain.Ports.ProductRepository;
import com.proyectoweb.barberia.Products.Product.Domain.Product;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductAmount;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductDescription;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductName;
import com.proyectoweb.barberia.Products.Product.Domain.ValueObjects.ProductPrice;
import com.proyectoweb.barberia.Users.User.Domain.Ports.UserRepository;
import com.proyectoweb.barberia.Users.User.Domain.User;
import com.proyectoweb.barberia.Users.User.Domain.UserDomainFinder;

import java.util.Optional;

public class ProductModifier {

    private ProductRepository productRepository;
    private UserDomainFinder finder;

    public ProductModifier(ProductRepository productRepository, UserRepository userRepository){
        this.productRepository = productRepository;
        this.finder = new UserDomainFinder(userRepository);
    }

    public void execute(String userId, String productId, String name, Integer amount, Double price, String description){
        Optional<User> user = finder.execute(userId);
        if(user.isEmpty() ){ //Cambiar por if rol == "cliente"
            throw new RuntimeException("Operacion invalida por credenciales.");
        }
        Optional<Product> product = productRepository.find(productId);
        Product finalProduct = product.get();
        finalProduct.updateProduct(new ProductName(name), new ProductAmount(amount), new ProductPrice(price), new ProductDescription(description));
        productRepository.update(finalProduct);
    }
}

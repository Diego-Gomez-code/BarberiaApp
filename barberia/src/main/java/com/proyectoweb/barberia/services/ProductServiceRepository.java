package com.proyectoweb.barberia.services;

import com.proyectoweb.barberia.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductServiceRepository extends JpaRepository<Product, Integer> {
    public Product getByName(String name);
}

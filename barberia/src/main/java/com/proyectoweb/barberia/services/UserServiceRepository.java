package com.proyectoweb.barberia.services;

import com.proyectoweb.barberia.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserServiceRepository extends JpaRepository<User, Integer> {
    public User getByUsername(String username);

}

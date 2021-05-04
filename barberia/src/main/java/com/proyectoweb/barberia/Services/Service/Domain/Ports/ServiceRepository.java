package com.proyectoweb.barberia.Services.Service.Domain.Ports;

import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Users.User.Domain.User;

import java.util.List;
import java.util.Optional;

public interface ServiceRepository {
    void save(Service service);
    String find(String serviceId);
    void update(Service service);
    Optional<List<Service>> findAll();
}

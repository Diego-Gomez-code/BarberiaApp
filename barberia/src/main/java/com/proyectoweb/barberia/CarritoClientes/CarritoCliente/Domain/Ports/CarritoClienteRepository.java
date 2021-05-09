package com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.Ports;

import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.CarritoCliente;
import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects.CarritoClienteId;

import java.util.Optional;

public interface CarritoClienteRepository {
    void save(CarritoCliente carritoCliente);
    Optional<CarritoCliente> find(String carritoClienteId);
}

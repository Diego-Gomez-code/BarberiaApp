package com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Application.Create;

import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.CarritoCliente;
import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.Ports.CarritoClienteRepository;
import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects.CarritoClienteId;
import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects.MetodoDePago;
import com.proyectoweb.barberia.Shared.Domain.Bus.Event.EventBus;
import com.proyectoweb.barberia.Shared.Domain.Products.CarritoCompraId;
import com.proyectoweb.barberia.Shared.Domain.Users.UserId;

public class CarritoClienteCreator {

    private CarritoClienteRepository repository;
    private EventBus eventBus;

    public CarritoClienteCreator(CarritoClienteRepository repository){
        this.repository = repository;
        this.eventBus = null;
    }

    public void execute(String carritoClienteId, String userId, String carritoCompraId, String metodoDePago){
        CarritoCliente carritoCliente = new CarritoCliente(new CarritoClienteId(carritoClienteId), new UserId(userId), new CarritoCompraId(carritoCompraId), new MetodoDePago(metodoDePago));
        this.repository.save(carritoCliente);
        //this.eventBus.publish(carritoCliente.pullDomainEvents());
    }
}

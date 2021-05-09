package com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain;

import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects.CarritoClienteId;
import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Domain.ValueObjects.MetodoDePago;
import com.proyectoweb.barberia.Shared.Domain.Aggregate.AggregateRoot;
import com.proyectoweb.barberia.Shared.Domain.CarritoClientes.CarritoClienteCreatedDomainEvent;
import com.proyectoweb.barberia.Shared.Domain.Products.CarritoCompraId;
import com.proyectoweb.barberia.Shared.Domain.Users.UserId;

import java.util.HashMap;
import java.util.Objects;

public class CarritoCliente extends AggregateRoot {

    private CarritoClienteId carritoClienteId;
    private UserId userId;
    private CarritoCompraId carritoCompraId;
    private MetodoDePago metodoDePago;

    public CarritoCliente(CarritoClienteId carritoClienteId, UserId userId, CarritoCompraId carritoCompraId, MetodoDePago metodoDePago) {
        this.carritoClienteId = carritoClienteId;
        this.userId = userId;
        this.carritoCompraId = carritoCompraId;
        this.metodoDePago = metodoDePago;
    }

    public CarritoCliente(){}

    public static CarritoCliente create(CarritoClienteId carritoClienteId, UserId userId, CarritoCompraId carritoCompraId, MetodoDePago metodoDePago){
        CarritoCliente cc = new CarritoCliente(carritoClienteId, userId, carritoCompraId, metodoDePago);
        cc.record(new CarritoClienteCreatedDomainEvent(carritoCompraId.value(), metodoDePago.value()));
        return cc;
    }

    public HashMap<String, String> data() {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", carritoClienteId.value());
            put("userId", userId.value());
            put("carritoCompraId", carritoCompraId.value());
            put("metodoDePago", metodoDePago.value());
        }};
        return data;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarritoCliente carritoCliente = (CarritoCliente) o;
        return Objects.equals(carritoClienteId, carritoCliente.carritoClienteId) &&
                Objects.equals(userId, carritoCliente.userId) &&
                Objects.equals(carritoCompraId, carritoCliente.carritoCompraId) &&
                Objects.equals(metodoDePago, carritoCliente.metodoDePago);
    }
}

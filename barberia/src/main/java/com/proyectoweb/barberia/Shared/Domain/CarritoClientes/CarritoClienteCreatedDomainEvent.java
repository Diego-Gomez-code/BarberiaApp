package com.proyectoweb.barberia.Shared.Domain.CarritoClientes;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class CarritoClienteCreatedDomainEvent extends DomainEvent {

    private final String metodoDePago;

    public CarritoClienteCreatedDomainEvent(){
        super(null);
        this.metodoDePago = "";
    }

    public CarritoClienteCreatedDomainEvent(String aggregateId, String metodoDePago){
        super(aggregateId);
        this.metodoDePago = metodoDePago;
    }

    public CarritoClienteCreatedDomainEvent(String aggregateId, String eventId, String ocurredOn, String metodoDePago){
        super(aggregateId, eventId, ocurredOn);
        this.metodoDePago = metodoDePago;
    }

    public String getMetodoDePago(){
        return metodoDePago;
    }

    @Override
    public String eventName() {
        return "CarritoCliente.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("metodoDePago", metodoDePago);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new CarritoClienteCreatedDomainEvent(aggregateId, eventId, occurredOn, (String) body.get("metodoDePago"));
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarritoClienteCreatedDomainEvent that = (CarritoClienteCreatedDomainEvent) o;
        return that.metodoDePago.equals(metodoDePago);
    }

    @Override
    public int hashCode(){
        return Objects.hash(metodoDePago);
    }
}

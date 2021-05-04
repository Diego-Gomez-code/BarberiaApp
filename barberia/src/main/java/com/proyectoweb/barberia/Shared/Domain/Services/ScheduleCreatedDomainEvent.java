package com.proyectoweb.barberia.Shared.Domain.Services;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;

public class ScheduleCreatedDomainEvent extends DomainEvent {

    //private final String scheduleId;
    //private final

    @Override
    public String eventName() {
        return null;
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return null;
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return null;
    }
}

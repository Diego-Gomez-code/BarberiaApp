package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.proyectoweb.barberia.Shared.Domain.Services.ScheduleCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({ScheduleCreatedDomainEvent.class})
public class ServiceUpdateSchedule {

    @EventListener
    public void on(ScheduleCreatedDomainEvent event) {
        System.out.println("Llego evento " + event.eventName() + "Date "+ event.getDateStart());
    }

}

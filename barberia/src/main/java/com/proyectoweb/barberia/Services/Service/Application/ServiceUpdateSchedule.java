package com.proyectoweb.barberia.Services.Service.Application;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.proyectoweb.barberia.Shared.Domain.Services.ScheduleCreatedDomainEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:8081")
@DomainEventSubscriber({ScheduleCreatedDomainEvent.class})
public final class ServiceUpdateSchedule {

    private ScheduleUpdateService scheduleUpdateService;

    public ServiceUpdateSchedule(ScheduleUpdateService scheduleUpdateService) {
        this.scheduleUpdateService = scheduleUpdateService;
    }

    @EventListener
    public void on(ScheduleCreatedDomainEvent event) {
        System.out.println("Llego evento " + event.eventName() + " Date "+ event.getDateStart());
        this.scheduleUpdateService.execute(event.getServiceId(),event.getScheduleId(), event.getDateStart(),event.getOption());
    }

}

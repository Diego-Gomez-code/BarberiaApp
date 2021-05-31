package com.proyectoweb.barberia.Services.CarritoService.Application;


import com.proyectoweb.barberia.Services.Service.Application.ScheduleUpdateService;
import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEventSubscriber;
import com.proyectoweb.barberia.Shared.Domain.Services.ScheduleCreatedDomainEvent;
import org.springframework.context.event.EventListener;

@DomainEventSubscriber({ScheduleCreatedDomainEvent.class})
public class CreateCarritoSchedule {

    private CreateCarritoService createCarritoService;

    public CreateCarritoSchedule(CreateCarritoService createCarritoService) {
        this.createCarritoService = createCarritoService;
    }

    @EventListener
    public void on(ScheduleCreatedDomainEvent event) {
        System.out.println("Llego evento " + event.eventName() + " Date "+ event.getDateStart());
    }
}

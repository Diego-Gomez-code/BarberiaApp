package com.proyectoweb.barberia.Shared.Infrastructure.Bus.Event.Spring;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEvent;
import com.proyectoweb.barberia.Shared.Domain.Bus.Event.EventBus;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
public class SpringApplicationEventBus implements EventBus {

    private final ApplicationEventPublisher publisher;

    public SpringApplicationEventBus(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
    @Override
    public void publish(List<DomainEvent> events) {
        events.forEach(this::publish);
    }

    private void publish(final DomainEvent event) {
        this.publisher.publishEvent(event);
    }
}

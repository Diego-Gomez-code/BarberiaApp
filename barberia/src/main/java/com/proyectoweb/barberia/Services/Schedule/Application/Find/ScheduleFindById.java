package com.proyectoweb.barberia.Services.Schedule.Application.Find;

import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;

public class ScheduleFindById {

    private ScheduleRepository repository;

    public ScheduleFindById(ScheduleRepository repository) {
        this.repository = repository;
    }
}

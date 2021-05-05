package com.proyectoweb.barberia.Services.Schedule.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;

public class UpdateSchedule {
    private ScheduleRepository repository;

    public UpdateSchedule(ScheduleRepository repository) {
        this.repository = repository;
    }
}

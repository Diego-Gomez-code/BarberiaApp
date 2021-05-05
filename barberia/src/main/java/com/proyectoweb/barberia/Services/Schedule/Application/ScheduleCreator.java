package com.proyectoweb.barberia.Services.Schedule.Application;

import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;

public class ScheduleCreator {

    private ScheduleRepository repository;

    public ScheduleCreator(ScheduleRepository repository) {
        this.repository = repository;
    }

    public void execute(){

    }
}
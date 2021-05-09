package com.proyectoweb.barberia.Services.Schedule.Application.All;


import com.proyectoweb.barberia.Services.Schedule.Domain.Ports.ScheduleRepository;
import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;

import java.util.List;
import java.util.Optional;

public class ScheduleFindAll {

    private ScheduleRepository scheduleRepository;

    public ScheduleFindAll(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public List<Schedule> execute(){
        Optional<List<Schedule>> horarios = scheduleRepository.findAll();
        
        return horarios.get();
    }
}

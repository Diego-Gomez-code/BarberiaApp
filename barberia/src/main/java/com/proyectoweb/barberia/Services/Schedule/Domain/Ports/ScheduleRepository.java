package com.proyectoweb.barberia.Services.Schedule.Domain.Ports;

import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;

import java.util.Optional;

public interface ScheduleRepository {

    void save(Schedule schedule);
    void update(Schedule schedule);
    Optional<Schedule> find(String scheduleId);
}

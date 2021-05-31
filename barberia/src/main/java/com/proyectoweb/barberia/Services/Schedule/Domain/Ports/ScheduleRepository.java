package com.proyectoweb.barberia.Services.Schedule.Domain.Ports;

import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;
import com.proyectoweb.barberia.Services.Service.Domain.Service;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {

    void save(Schedule schedule);
    void update(Schedule schedule);
    Optional<Schedule> find(String scheduleId);
    Optional<List<Schedule>> findAll();
    void delete(Schedule schedule);
}

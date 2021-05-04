package com.proyectoweb.barberia.Services.Schedule.Domain;

import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

public class Schedule {

    private ScheduleId scheduleId;
    private ServiceId serviceId;
    private ScheduleDate scheduleDateStart;
    private ScheduleDate scheduleDateEnd;

    public Schedule(ScheduleId scheduleId, ServiceId serviceId, ScheduleDate scheduleDateStart, ScheduleDate scheduleDateEnd) {
        this.scheduleId = scheduleId;
        this.serviceId = serviceId;
        this.scheduleDateStart = scheduleDateStart;
        this.scheduleDateEnd = scheduleDateEnd;
    }
}

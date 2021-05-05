package com.proyectoweb.barberia.Services.Schedule.Domain;

import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleOption;
import com.proyectoweb.barberia.Shared.Domain.Aggregate.AggregateRoot;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import com.proyectoweb.barberia.Shared.Domain.Users.UserId;

public class Schedule extends AggregateRoot {

    private ScheduleId scheduleId;
    private ServiceId serviceId;
    private ScheduleDate scheduleDateStart;
    private UserId userId;
    private ScheduleOption scheduleOption;

    public Schedule(ScheduleId scheduleId, ServiceId serviceId, ScheduleDate scheduleDateStart, UserId userId) {
        this.scheduleId = scheduleId;
        this.serviceId = serviceId;
        this.scheduleDateStart = scheduleDateStart;
        this.userId = userId;
    }
}

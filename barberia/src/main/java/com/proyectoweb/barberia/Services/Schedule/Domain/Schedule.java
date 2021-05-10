package com.proyectoweb.barberia.Services.Schedule.Domain;

import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleOption;
import com.proyectoweb.barberia.Shared.Domain.Aggregate.AggregateRoot;
import com.proyectoweb.barberia.Shared.Domain.Schedule.ScheduleId;
import com.proyectoweb.barberia.Shared.Domain.Services.ScheduleCreatedDomainEvent;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import com.proyectoweb.barberia.Shared.Domain.Users.UserId;

import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class Schedule extends AggregateRoot {



    private ScheduleId scheduleId;
    private ServiceId serviceId;
    private ScheduleDate scheduleDateStart;
    private ScheduleOption scheduleOption;

    public Schedule(ScheduleId scheduleId, ServiceId serviceId, ScheduleDate scheduleDateStart, ScheduleOption option) {
        this.scheduleId = scheduleId;
        this.serviceId = serviceId;
        this.scheduleDateStart = scheduleDateStart;
        this.scheduleOption = option;
    }

    public Schedule() {
    }

    public static Schedule creator(ScheduleId scheduleId, ServiceId serviceId, ScheduleDate scheduleDateStart, ScheduleOption option) {
        Schedule schedule = new Schedule(scheduleId, serviceId, scheduleDateStart, option);
        schedule.record(new ScheduleCreatedDomainEvent(scheduleId.value(), scheduleDateStart.value(), option.value(), serviceId.value()));
        return schedule;
    }

    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public HashMap<String, Object> data() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("schedule_id", scheduleId.value());
            put("datetime_start", format.format(scheduleDateStart.value()));
            put("service_id", serviceId.value());
            put("type", scheduleOption.value());
        }};
        return data;
    }
}

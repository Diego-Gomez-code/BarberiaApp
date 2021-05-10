package com.proyectoweb.barberia.Shared.Domain.Services;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Objects;

public class ScheduleCreatedDomainEvent extends DomainEvent {

    private final String scheduleId;
    private final Timestamp dateStart;
    private final String option;
    private final String serviceId;

    public ScheduleCreatedDomainEvent() {
        super(null);
        this.scheduleId = "";
        this.dateStart = null;
        this.option = "";
        this.serviceId = "";
    }

    public ScheduleCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String scheduleId, Timestamp dateStart, String option, String serviceId) {
        super(aggregateId, eventId, occurredOn);
        this.scheduleId = scheduleId;
        this.dateStart = dateStart;
        this.option = option;
        this.serviceId = serviceId;
    }

    public ScheduleCreatedDomainEvent(String scheduleId, Timestamp dateStart, String option, String serviceId) {
        this.scheduleId = scheduleId;
        this.dateStart = dateStart;
        this.option = option;
        this.serviceId = serviceId;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public Timestamp getDateStart() {
        return dateStart;
    }

    public String getOption() {
        return option;
    }

    public String getServiceId() {
        return serviceId;
    }

    @Override
    public String eventName() {
        return "order.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("scheduleId", scheduleId);
            put("dateStart", dateStart);
            put("option", option);
            put("serviceId", serviceId);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new ScheduleCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("scheduleId"),
                (Timestamp) body.get("dateStart"),
                (String) body.get("option"),
                (String) body.get("serviceId")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleCreatedDomainEvent that = (ScheduleCreatedDomainEvent) o;
        return option == that.option && Objects.equals(scheduleId, that.scheduleId) && Objects.equals(dateStart, that.dateStart);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, dateStart, option);
    }


}

package com.proyectoweb.barberia.Shared.Domain.Services;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Objects;

public class ScheduleCreatedDomainEvent extends DomainEvent {

    private final String scheduleId;
    private final String dateStart;
    private final char option;

    public ScheduleCreatedDomainEvent() {
        super(null);
        this.scheduleId = "";
        this.dateStart = "";
        this.option = 'a';
    }

    public ScheduleCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String scheduleId, String dateStart, char option) {
        super(aggregateId, eventId, occurredOn);
        this.scheduleId = scheduleId;
        this.dateStart = dateStart;
        this.option = option;
    }

    public ScheduleCreatedDomainEvent(String scheduleId, String dateStart, char option) {
        this.scheduleId = scheduleId;
        this.dateStart = dateStart;
        this.option = option;
    }

    public String getScheduleId() {
        return scheduleId;
    }

    public String getDateStart() {
        return dateStart;
    }

    public char getOption() {
        return option;
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
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new ScheduleCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("scheduleId"),
                (String) body.get("dateStart"),
                (char) body.get("option")
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

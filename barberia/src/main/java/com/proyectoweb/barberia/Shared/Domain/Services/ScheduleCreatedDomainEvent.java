package com.proyectoweb.barberia.Shared.Domain.Services;

import com.proyectoweb.barberia.Shared.Domain.Bus.Event.DomainEvent;

import java.io.Serializable;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Objects;

public class ScheduleCreatedDomainEvent extends DomainEvent {

    private final String scheduleId;
    private final GregorianCalendar scheduleDateStart;
    private final GregorianCalendar scheduleDateEnd;

    public ScheduleCreatedDomainEvent() {
        super(null);
        this.scheduleId = "";
        this.scheduleDateStart = new GregorianCalendar();
        this.scheduleDateEnd = new GregorianCalendar();
    }

    public ScheduleCreatedDomainEvent(String aggregateId, String eventId, String occurredOn, String scheduleId, GregorianCalendar scheduleDateStart, GregorianCalendar scheduleDateEnd) {
        super(aggregateId, eventId, occurredOn);
        this.scheduleId = scheduleId;
        this.scheduleDateStart = scheduleDateStart;
        this.scheduleDateEnd = scheduleDateEnd;
    }

    public ScheduleCreatedDomainEvent(String scheduleId, GregorianCalendar scheduleDateStart, GregorianCalendar scheduleDateEnd) {
        this.scheduleId = scheduleId;
        this.scheduleDateStart = scheduleDateStart;
        this.scheduleDateEnd = scheduleDateEnd;
    }


    @Override
    public String eventName() {
        return "schedule.created";
    }

    @Override
    public HashMap<String, Serializable> toPrimitive() {
        return new HashMap<String, Serializable>() {{
            put("scheduleId", scheduleId);
            put("scheduleDateStart", scheduleDateStart);
            put("scheduleDateEnd", scheduleDateEnd);
        }};
    }

    @Override
    public DomainEvent fromPrimitive(String aggregateId, HashMap<String, Serializable> body, String eventId, String occurredOn) {
        return new ScheduleCreatedDomainEvent(
                aggregateId,
                eventId,
                occurredOn,
                (String) body.get("scheduleId"),
                (GregorianCalendar) body.get("scheduleDateStart"),
                (GregorianCalendar) body.get("scheduleDateEnd")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ScheduleCreatedDomainEvent that = (ScheduleCreatedDomainEvent) o;
        return Objects.equals(scheduleId, that.scheduleId) && Objects.equals(scheduleDateStart, that.scheduleDateStart) && Objects.equals(scheduleDateEnd, that.scheduleDateEnd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(scheduleId, scheduleDateStart, scheduleDateEnd);
    }
}

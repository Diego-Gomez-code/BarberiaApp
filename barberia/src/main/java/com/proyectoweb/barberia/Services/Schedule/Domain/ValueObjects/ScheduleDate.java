package com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects;

import java.util.Date;
import java.util.GregorianCalendar;

public class ScheduleDate {

    // ValueObject para el Date?
    private GregorianCalendar value;

    public ScheduleDate(GregorianCalendar value) {
        this.value = value;
    }

    public GregorianCalendar value() {
        return value;
    }

    private void validate(String value) {
        //TODO: Other Rules Service name
    }


}

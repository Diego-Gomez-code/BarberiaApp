package com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.GregorianCalendar;

public class ScheduleDate {

    // ValueObject para el Date?
    private Timestamp value;

    public ScheduleDate() {
        this.value = new Timestamp(System.currentTimeMillis());
        
    }
    public ScheduleDate(Timestamp time) { this.value = time;}

    public  Timestamp value() {
        return value;
    }

    private void validate(String value) {
        //TODO: Other Rules Service name
    }


}

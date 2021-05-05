package com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects;

import java.sql.Date;
import java.util.GregorianCalendar;

public class ScheduleDate {

    // ValueObject para el Date?
    private Date value;

    public ScheduleDate(Date value) {
        this.value = value;
    }

    public  Date value() {
        return value;
    }

    private void validate(String value) {
        //TODO: Other Rules Service name
    }


}

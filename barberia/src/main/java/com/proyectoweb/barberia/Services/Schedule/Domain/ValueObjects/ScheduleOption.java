package com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects;

public class ScheduleOption {

    private String value;

    public ScheduleOption(String value) {
        this.validate(value);
        this.value = value;
    }

    public ScheduleOption() {
    }

    public String value(){return this.value;}

    public void validate(String value){
        if(!value.equals("c") && !value.equals("p")){
            throw new RuntimeException("Character not valid");
        }
    }
}

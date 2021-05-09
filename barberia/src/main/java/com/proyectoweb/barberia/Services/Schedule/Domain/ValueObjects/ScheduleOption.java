package com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects;

public class ScheduleOption {

    private char value;

    public ScheduleOption(char value) {
        this.validate(value);
        this.value = value;
    }

    public ScheduleOption() {
    }

    public char value(){return this.value;}

    public void validate(char value){
        if(value != 'p' ){
            throw new RuntimeException("Character not valid");
        }
    }
}

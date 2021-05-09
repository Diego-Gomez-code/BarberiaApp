package com.proyectoweb.barberia.Services.Schedule.Application.All;

import com.proyectoweb.barberia.Services.Schedule.Domain.Schedule;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ScheduleFindAllResponse {

    private List<Schedule> scheduleList;

    public ScheduleFindAllResponse(List<Schedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public List<HashMap> response(){
        List<HashMap> response = scheduleList.stream().map(p -> p.data()).collect(Collectors.toList());
        return response;
    }
}

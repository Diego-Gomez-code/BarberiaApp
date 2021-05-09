package com.proyectoweb.barberia.Services.Schedule.Infrastructure;

import com.proyectoweb.barberia.Services.Schedule.Application.All.ScheduleFindAll;
import com.proyectoweb.barberia.Services.Schedule.Application.All.ScheduleFindAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/schedule")
public class FindAllScheduleGetController {

    @Autowired
    private ScheduleFindAll scheduleFindAll;

    @RequestMapping(value = "/findAll")
    private ResponseEntity<List<HashMap>> execute(){
        ScheduleFindAllResponse response = new ScheduleFindAllResponse(scheduleFindAll.execute());
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }
}

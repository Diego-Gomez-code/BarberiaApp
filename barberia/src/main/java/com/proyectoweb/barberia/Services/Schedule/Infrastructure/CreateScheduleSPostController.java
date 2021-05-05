package com.proyectoweb.barberia.Services.Schedule.Infrastructure;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/schedule")
public class CreateScheduleSPostController {

    @PostMapping(value = "create")
    public ResponseEntity execute(){

        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
}

package com.proyectoweb.barberia.Services.Schedule.Infrastructure;

import com.proyectoweb.barberia.Services.Schedule.Application.ScheduleCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;
import java.sql.Timestamp;

@RestController
@RequestMapping(value = "/schedule")
public class CreateScheduleSPostController {

    @Autowired
    private ScheduleCreator scheduleCreator;

    @PostMapping(value = "create")
    public ResponseEntity execute(@RequestBody Request request){
        scheduleCreator.execute(request.getId(),request.getTime(),request.getService_id(),request.getType());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    static class Request{
        private String id;
        private Timestamp time;
        private String service_id;
        private char type;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public Timestamp getTime() {
            return time;
        }

        public void setTime(Timestamp time) {
            this.time = time;
        }

        public String getService_id() {
            return service_id;
        }

        public void setService_id(String service_id) {
            this.service_id = service_id;
        }

        public char getType() {
            return type;
        }

        public void setType(char type) {
            this.type = type;
        }
    }
}

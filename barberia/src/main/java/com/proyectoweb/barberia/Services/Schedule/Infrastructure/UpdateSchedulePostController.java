package com.proyectoweb.barberia.Services.Schedule.Infrastructure;

import com.proyectoweb.barberia.Services.Schedule.Application.UpdateSchedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/schedule")
public class UpdateSchedulePostController {

    @Autowired
    private UpdateSchedule updateSchedule;

    @PostMapping(value = "/update/{id}" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@PathVariable("id") String id, @RequestBody Request request){
        updateSchedule.execute(id, request.getDate(), request.getService_id(), request.getType());
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> handleRuntimeException(RuntimeException exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    static class Request {
        private String date;
        private String service_id;
        private String type;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getService_id() {
            return service_id;
        }

        public void setService_id(String service_id) {
            this.service_id = service_id;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }

}

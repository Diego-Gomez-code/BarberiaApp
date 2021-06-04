package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Application.Find.ServiceFindById;
import com.proyectoweb.barberia.Services.Service.Application.Find.ServiceFindByIdResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.HashMap;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(value = "/service")
public class FindByIdGetController {

    @Autowired
    private ServiceFindById serviceFindById;

    @GetMapping(value = "find/{id}")
    public ResponseEntity execute(@PathVariable("id") String id){
        ServiceFindByIdResponse response = serviceFindById.execute(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.response());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> handleRuntimeException(RuntimeException exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

}

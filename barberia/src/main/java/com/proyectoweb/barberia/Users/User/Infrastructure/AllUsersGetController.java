package com.proyectoweb.barberia.Users.User.Infrastructure;

import com.proyectoweb.barberia.Users.User.Application.All.UserAll;
import com.proyectoweb.barberia.Users.User.Application.All.UserAllResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class AllUsersGetController {

    @Autowired
    private UserAll userAll;

    @GetMapping(value = "/all")
    public ResponseEntity<List<HashMap>> execute(){
        UserAllResponse response = new UserAllResponse(userAll.execute());
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

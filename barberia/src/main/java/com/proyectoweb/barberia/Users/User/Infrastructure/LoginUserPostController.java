package com.proyectoweb.barberia.Users.User.Infrastructure;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@RestController
@CrossOrigin(origins = "http://localhost:8081")
@RequestMapping(value = "/users")
public class LoginUserPostController {

    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
    public String execute(@RequestBody Requestt request){

        System.out.println("entre al login");
        return null;
    }

}
class Requestt {
    private String userId;
    private String firstName;
    private String lastName;
    private String userName;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


}

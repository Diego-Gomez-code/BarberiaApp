package com.proyectoweb.barberia.Users.User.Infrastructure;

import com.proyectoweb.barberia.Shared.Domain.UUIDNotValid;
import com.proyectoweb.barberia.Users.User.Application.Create.UserCreator;
import com.proyectoweb.barberia.Users.User.Domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping(value = "/users")
public final class SignupUserPostController {

    @Autowired
    private UserCreator creator;

    @PostMapping(value = "/signup", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        creator.execute(request.getUserId(), request.getFirstName(), request.getLastName(), request.getUserName(), request.getEmail(), request.getRol(), request.getPassword());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler({UUIDNotValid.class, UpperLowerError.class, NotSymbolsFound.class, LengthNotValid.class})
    public ResponseEntity<HashMap> handleDataErrors(RuntimeException exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(BadWordsError.class)
    public ResponseEntity<HashMap> hanldleBadWords(BadWordsError exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    @ExceptionHandler(UserAlreadyExists.class)
    public ResponseEntity<HashMap> hanldleUserAlreadyExist(UserAlreadyExists exception)
    {
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
    }

    static class Request {
        private String userId;
        private String firstName;
        private String lastName;
        private String userName;
        private String email;
        private String rol;
        private String password;

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getRol() {
            return rol;
        }

        public void setRol(String rol) {
            this.rol = rol;
        }
    }

}



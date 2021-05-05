package com.proyectoweb.barberia.Users.User.Domain;

import com.proyectoweb.barberia.Shared.Domain.Users.UserId;
import com.proyectoweb.barberia.Users.User.Domain.ValueObjects.*;

import java.util.HashMap;
import java.util.Objects;

public class User {

    private UserId userId;
    private UserFirstName userFirstName;
    private UserLastName userLastName;
    private UserName userName;
    private UserEmail userEmail;
    private UserRol userRol;
    private UserPassword userPassword;

    public User(UserId userId, UserFirstName userFirstName, UserLastName userLastName, UserName userName, UserEmail userEmail, UserRol userRol, UserPassword userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRol = userRol;
        this.userPassword = userPassword;
    }

    public User(){}

    public void updateUser(UserFirstName userFirstName, UserLastName userLastName, UserName userName, UserEmail userEmail, UserRol userRol){
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userName = userName;
        this.userEmail = userEmail;
        this.userRol = userRol;
    }

    public boolean equalsById(String otherId) {
        return this.userId.equals(new UserId(otherId));
    }

    public HashMap<String, String> data() {
        HashMap<String, String> data = new HashMap<String, String>() {{
            put("id", userId.value());
            put("firstname", userFirstName.value());
            put("lastname", userLastName.value());
            put("username", userName.value());
            put("email", userEmail.value());
            put("rol", userRol.value());
        }};
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userId, user.userId) &&
                Objects.equals(userFirstName, user.userFirstName) &&
                Objects.equals(userLastName, user.userLastName) &&
                Objects.equals(userName, user.userName) &&
                Objects.equals(userPassword, user.userPassword) &&
                Objects.equals(userEmail, user.userEmail) &&
                Objects.equals(userRol, user.userRol);
    }

    public UserRol getUserRol(){
        return this.userRol;
    }
}

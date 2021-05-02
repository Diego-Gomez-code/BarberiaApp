package com.proyectoweb.barberia.Users.User.Domain;

import com.proyectoweb.barberia.Shared.Domain.Users.UserId;

import java.util.HashMap;
import java.util.Objects;

public class User {

    private UserId userId;
    private UserFirstName userFirstName;
    private UserLastName userLastName;
    private UserName userName;
    private UserPassword userPassword;

    public User(UserId userId, UserFirstName userFirstName, UserLastName userLastName, UserName userName, UserPassword userPassword) {
        this.userId = userId;
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userName = userName;
        this.userPassword = userPassword;
    }

    public User(){}

    public void updateUser(UserFirstName userFirstName, UserLastName userLastName, UserName userName){
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userName = userName;
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
                Objects.equals(userPassword, user.userPassword);
    }
}

package com.proyectoweb.barberia.services;

import com.proyectoweb.barberia.models.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public User addUser(User user) throws Exception;
    public void updateUser(User user) throws Exception;
    public void deleteUser(User user) throws  Exception;
    public User getUser(int idUser) throws  Exception;
    public List<User> getAllUsers() throws  Exception;

}

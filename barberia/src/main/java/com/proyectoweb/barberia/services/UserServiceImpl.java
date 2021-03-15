package com.proyectoweb.barberia.services;

import com.proyectoweb.barberia.models.User;
import org.apache.logging.log4j.spi.LoggerRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.proyectoweb.barberia.BarberiaApplication.LOGGER;

@Service
public class UserServiceImpl implements UserService {

    private UserServiceRepository repository;

    @Autowired
    public UserServiceImpl(UserServiceRepository repository) {
        this.repository = repository;
    }

    @Override
    public User addUser(User user) throws Exception {
        return null;
    }

    @Override
    public void updateUser(User user) throws Exception {

    }

    @Override
    public void deleteUser(User user) throws Exception {

    }

    @Override
    public User getUser(int idUser) throws Exception {
        return null;
    }

    @Override
    public List<User> getAllUsers() throws Exception {
        List<User> usuarios = null;
        try {
            usuarios = this.repository.findAll();
        } catch(Exception e){
            LOGGER.error("UserServiceImpl.getAllUsers Causa: " + e.toString());
            throw new Exception("UserServiceImpl.getAllUsers Causa: " + e.toString());
        }
        return usuarios;
    }
}

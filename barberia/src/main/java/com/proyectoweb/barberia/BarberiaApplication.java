package com.proyectoweb.barberia;

import org.springframework.boot.SpringApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:dependencies.xml")
public class BarberiaApplication {

    public static final Logger LOGGER = LoggerFactory.getLogger(BarberiaApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BarberiaApplication.class, args);
	}
		String hola = "hola";
}

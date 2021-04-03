package com.proyectoweb.barberia.Reservations.Reservation.Infrastructure;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/reservations")
public class DeleteReservationDeleteController {

    @DeleteMapping(value = "/{idReservation}/delete")
    public void execute(@PathVariable("idReservation") String idReservation){

    }
}

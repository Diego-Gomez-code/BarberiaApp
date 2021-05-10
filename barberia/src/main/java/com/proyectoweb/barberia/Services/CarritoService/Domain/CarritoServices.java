package com.proyectoweb.barberia.Services.CarritoService.Domain;

import com.proyectoweb.barberia.Services.Schedule.Domain.ValueObjects.ScheduleDate;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServicePrice;
import com.proyectoweb.barberia.Shared.Domain.Aggregate.AggregateRoot;
import com.proyectoweb.barberia.Shared.Domain.CarritoService.CarritoServiceId;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import com.proyectoweb.barberia.Shared.Domain.Users.UserId;

import java.text.SimpleDateFormat;
import java.util.HashMap;

public class CarritoServices extends AggregateRoot {

    private CarritoServiceId carritoServiceId;
    private ServiceId serviceId;
    private ScheduleDate scheduleDate;
    private ServicePrice servicePrice;
    private UserId userId;

    public CarritoServices() {
    }

    public CarritoServices(CarritoServiceId carritoServiceId, ServiceId serviceId, ScheduleDate scheduleDate, ServicePrice servicePrice, UserId userId) {
        this.carritoServiceId = carritoServiceId;
        this.serviceId = serviceId;
        this.scheduleDate = scheduleDate;
        this.servicePrice = servicePrice;
        this.userId = userId;
    }
    private static final SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public HashMap<String, Object> data(){
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        HashMap<String, Object> data = new HashMap<String, Object>() {{
            put("carritoId", carritoServiceId.value());
            put("serviceId", serviceId.value());
            put("reserva", format.format(scheduleDate.value()));
            put("price" , servicePrice.value());
            put("clienteId", servicePrice.value());
        }};
        return data;
    }
}

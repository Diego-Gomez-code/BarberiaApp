package com.proyectoweb.barberia.Services.Service.Infrastructure;

import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceDescription;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceName;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServicePrice;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryRepository implements ServiceRepository {
    private Service s1 = new Service(new ServiceId("e0120b07-cb48-4d7f-9f5d-2306ec248bb9")
            ,new ServiceName("Peluqueria"),
            new ServiceDescription("Arreglo de cabello"),
            new ServicePrice(10000.d));

    private Service s2 = new Service(new ServiceId("f14b0375-8553-448e-b475-78fcf9f46ccc")
            ,new ServiceName("Barberia"),
            new ServiceDescription("Arreglo de barba"),
            new ServicePrice(8000.d));

    private List<Service> services = new ArrayList<>(){{
       add(s1);
       add(s2);
    }};

    @Override
    public void save(Service service) {
        this.services.add(service);
    }

    @Override
    public String find(String ServiceId) {
        for (int i = 0; i < services.size(); i++) {
            if(this.services.get(i).equalsById(ServiceId)){
                return this.services.get(i).info();
            }
        }
        return null;
    }

    @Override
    public void update(Service service) {

    }

    @Override
    public Optional<List<Service>> findAll() {
        return null;
    }
}

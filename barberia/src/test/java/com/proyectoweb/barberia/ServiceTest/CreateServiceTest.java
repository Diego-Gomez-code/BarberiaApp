package com.proyectoweb.barberia.ServiceTest;

import com.proyectoweb.barberia.Services.Service.Application.ServiceCreator;
import com.proyectoweb.barberia.Services.Service.Domain.Ports.ServiceRepository;
import com.proyectoweb.barberia.Services.Service.Domain.Service;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceDescription;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServiceName;
import com.proyectoweb.barberia.Services.Service.Domain.ValueObjects.ServicePrice;
import com.proyectoweb.barberia.Services.Service.Infrastructure.InMemoryRepository;
import com.proyectoweb.barberia.Shared.Domain.Services.ServiceId;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.mockito.Mockito.*;

@SpringBootTest
public class CreateServiceTest {
    @Test
    void test_create_solo(){
        System.out.println("Entro Test Create");
        Service actual = new Service(new ServiceId("de3d0110-1e04-47a0-af31-f099a0dfd5d9"),new ServiceName("uñassuperwao"),new ServiceDescription("uñas"), new ServicePrice(5000.d));
        InMemoryRepository repository = new InMemoryRepository();
        repository.save(actual);
        List<Service> servicios = repository.findAll();
        for (Service valor: servicios) {
            System.out.println(valor.info());
        }
    }

    @Test
    void print_test_find_id() {
        System.out.println("Entro Test Find By ID");
        InMemoryRepository repository = new InMemoryRepository();
        Service actual = new Service(new ServiceId("de3d0110-1e04-47a0-af31-f099a0dfd5d9"), new ServiceName("uñassuperwao"), new ServiceDescription("uñas"), new ServicePrice(5000.d));
        repository.save(actual);
        System.out.println(repository.find("de3d0110-1e04-47a0-af31-f099a0dfd5d9"));
    }

    @Test
    void print_test_find_All(){
        InMemoryRepository repository = new InMemoryRepository();
        List<Service> servicios = repository.findAll();
        for (Service valor: servicios) {
            System.out.println(valor.info());
        }
        System.out.println("los servicios" +servicios);
    }
}

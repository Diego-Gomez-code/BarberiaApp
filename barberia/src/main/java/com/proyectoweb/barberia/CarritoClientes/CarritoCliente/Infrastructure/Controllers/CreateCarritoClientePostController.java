package com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Infrastructure.Controllers;

import com.proyectoweb.barberia.CarritoClientes.CarritoCliente.Application.Create.CarritoClienteCreator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.HashMap;

@RestController
@RequestMapping(value = "/carritocliente")
public class CreateCarritoClientePostController {

    @Autowired
    private CarritoClienteCreator creator;

    @PostMapping(value = "/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity execute(@RequestBody Request request){
        creator.execute(request.getId(), request.getUserId(), request.getCarritoCompraId(), request.getMetodoDePago());
        return ResponseEntity.status(HttpStatus.CREATED).body(null);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<HashMap> handleRuntimeException(RuntimeException exception){
        HashMap<String, String> response = new HashMap<String, String>() {{
            put("error", exception.getMessage());
        }};
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(response);
    }

    static class Request {
        private String id;
        private String userId;
        private String carritoCompraId;
        private String metodoDePago;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getCarritoCompraId() {
            return carritoCompraId;
        }

        public void setCarritoCompraId(String carritoCompraId) {
            this.carritoCompraId = carritoCompraId;
        }

        public String getMetodoDePago() {
            return metodoDePago;
        }

        public void setMetodoDePago(String metodoDePago) {
            this.metodoDePago = metodoDePago;
        }
    }
}

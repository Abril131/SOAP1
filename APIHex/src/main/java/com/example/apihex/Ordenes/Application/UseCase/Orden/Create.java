package com.example.apihex.Ordenes.Application.UseCase.Orden;

import com.example.apihex.Ordenes.Domain.Entities.Orden;
import com.example.apihex.Ordenes.Domain.Ports.IOrdenPort;
import com.example.apihex.Ordenes.Infrestructure.datos.requests.CreateOrdenResquest;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Create {

    @Autowired
    IOrdenPort repository;

    public OrdenResponse run(CreateOrdenResquest request) {
        Orden orden = new Orden();
        orden.setFecha(request.getFecha());
        orden.setStatus(request.getStatus());
        orden.setTotal(request.getTotal());
        return repository.Crear(orden);
    }
}

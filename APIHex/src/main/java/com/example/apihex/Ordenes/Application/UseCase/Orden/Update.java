package com.example.apihex.Ordenes.Application.UseCase.Orden;

import com.example.apihex.Ordenes.Domain.Ports.IOrdenPort;
import com.example.apihex.Ordenes.Infrestructure.datos.requests.UpdateOrdenRequest;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Update {
    @Autowired
    IOrdenPort repository;

    public BaseResponse run(UpdateOrdenRequest request){
        return repository.ActualizarStatus(request.getId(), request.getStatus());
    }
}

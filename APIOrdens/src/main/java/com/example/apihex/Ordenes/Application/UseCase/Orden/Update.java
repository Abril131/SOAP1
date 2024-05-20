package com.example.apihex.Ordenes.Application.UseCase.Orden;

import com.example.apihex.Ordenes.Domain.Ports.IOrdenPort;
import com.example.apihex.Ordenes.Domain.Ports.IOrdenProducPort;
import com.example.apihex.Ordenes.Infrestructure.datos.requests.UpdateOrdenRequest;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.BaseResponse;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenProducResponse;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Update {
    @Autowired
    IOrdenPort repository;

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private IOrdenProducPort productosReposiyo;

    public BaseResponse run(UpdateOrdenRequest request){
        String id = request.getId();
        String status = request.getStatus();
        BaseResponse response = repository.ActualizarStatus(id, status);
        if (status.equalsIgnoreCase("Enviado")){
            List<OrdenProducResponse> listaRequest = productosReposiyo.findProductosByOrdenId(id);
            for (OrdenProducResponse producto : listaRequest){
                updateProductos(from(producto));
            }
        }
        return response;
    }

    public void updateProductos(String request){
        template.convertAndSend("queue.change_ordenstatus",request);
    }

    private String from(OrdenProducResponse producto){
        String request = "{\"id\": \"" + producto.getProductoId() + "\", \"cantidad\":"+ producto.getCantidad() + "}";
        return request;
    }
}


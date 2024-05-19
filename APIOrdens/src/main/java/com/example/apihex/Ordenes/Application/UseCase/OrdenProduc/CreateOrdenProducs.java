package com.example.apihex.Ordenes.Application.UseCase.OrdenProduc;

import com.example.apihex.Ordenes.Domain.Entities.OrdenProduc;
import com.example.apihex.Ordenes.Domain.Ports.IOrdenProducPort;
import com.example.apihex.Ordenes.Infrestructure.datos.requests.CreateOrdenProducRequest;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenProducResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateOrdenProducs {
    @Autowired
    IOrdenProducPort repository;

    public List<OrdenProducResponse> run(String id, List<CreateOrdenProducRequest> productos){
        return productos.stream().map(producto -> from(id, producto)).toList();
    }

    private OrdenProducResponse from(String id, CreateOrdenProducRequest createOrdenProductosRequest) {
        OrdenProduc ordenProduc = new OrdenProduc();
        ordenProduc.setProductoId(createOrdenProductosRequest.getProductoId());
        ordenProduc.setCantidad(createOrdenProductosRequest.getCantidad());
        ordenProduc.setTotal(createOrdenProductosRequest.getTotal());
        ordenProduc.setOrdenId(id);
        return repository.CrearOrdenProducto(ordenProduc);
    }
}

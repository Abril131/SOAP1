package com.example.apihex.Ordenes.Infrestructure.Repository;

import com.example.apihex.Ordenes.Domain.Entities.OrdenProduc;
import com.example.apihex.Ordenes.Domain.Ports.IOrdenProducPort;
import com.example.apihex.Ordenes.Infrestructure.Models.OrdenProducModel;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenProducResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class OrdenProducRepository implements IOrdenProducPort {

    @Autowired
    OrdenRepository ordenRepository = new OrdenRepository();

    @Override
    public OrdenProducResponse CrearOrdenProducto(OrdenProduc ordenProductos) {
        OrdenProducModel model = new OrdenProducModel();
        model.setId(ordenProductos.getId());
        model.setProductoId(ordenProductos.getProductoId());
        model.setOrden(ordenRepository.findAndEnsureExist(ordenProductos.getOrdenId()));
        model.setCantidad(ordenProductos.getCantidad());
        return from(model);
    }

    OrdenProducResponse from(OrdenProducModel ordenProductos) {
        OrdenProducResponse resp = new OrdenProducResponse();
        resp.setId(ordenProductos.getId());
        resp.setProductoId(ordenProductos.getProductoId());
        resp.setOrdenId(ordenProductos.getOrden().getId());
        resp.setCantidad(ordenProductos.getCantidad());
        resp.setTotal(ordenProductos.getTotal());
        return resp;
    }
}

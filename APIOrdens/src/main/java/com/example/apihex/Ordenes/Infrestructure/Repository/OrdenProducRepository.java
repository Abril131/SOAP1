package com.example.apihex.Ordenes.Infrestructure.Repository;

import com.example.apihex.Ordenes.Domain.Entities.OrdenProduc;
import com.example.apihex.Ordenes.Domain.Ports.IOrdenProducPort;
import com.example.apihex.Ordenes.Infrestructure.Exceptions.NotFoundException;
import com.example.apihex.Ordenes.Infrestructure.Models.OrdenProducModel;
import com.example.apihex.Ordenes.Infrestructure.Repository.JPA.IOrdenProducRepository;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenProducResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrdenProducRepository implements IOrdenProducPort {

    @Autowired
    OrdenRepository ordenRepository;

    @Autowired
    IOrdenProducRepository repository;

    @Override
    public OrdenProducResponse CrearOrdenProducto(OrdenProduc ordenProductos) {
        OrdenProducModel model = new OrdenProducModel();
        model.setId(ordenProductos.getId());
        model.setProducto_id((ordenProductos.getProductoId()));
        model.setOrden(ordenRepository.findAndEnsureExist(ordenProductos.getOrdenId()));
        model.setCantidad(ordenProductos.getCantidad());
        return from(repository.save(model));
    }

    @Override
    public List<OrdenProducResponse> findProductosByOrdenId(String ordenId) {
        List<OrdenProducResponse> productos = repository.findByOrdenId(ordenId).stream().map(this::from).toList();
        if (productos.isEmpty()) {
            throw new NotFoundException("productos no encontrados");
        }
        return productos;
    }
    OrdenProducResponse from(OrdenProducModel ordenProductos) {
        OrdenProducResponse resp = new OrdenProducResponse();
        resp.setId(ordenProductos.getId());
        resp.setProductoId(ordenProductos.getProducto_id());
        resp.setOrdenId(ordenProductos.getOrden().getId());
        resp.setCantidad(ordenProductos.getCantidad());
        resp.setTotal(ordenProductos.getTotal());
        return resp;
    }
}

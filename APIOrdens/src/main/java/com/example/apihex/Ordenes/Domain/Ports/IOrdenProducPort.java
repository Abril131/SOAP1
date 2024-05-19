package com.example.apihex.Ordenes.Domain.Ports;

import com.example.apihex.Ordenes.Domain.Entities.OrdenProduc;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenProducResponse;

import java.util.List;

public interface IOrdenProducPort {

    OrdenProducResponse CrearOrdenProducto(OrdenProduc ordenProductos);

    List<OrdenProducResponse> findProductosByOrdenId(String ordenId);
}

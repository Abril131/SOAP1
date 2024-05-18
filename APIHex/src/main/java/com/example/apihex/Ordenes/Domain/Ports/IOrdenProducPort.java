package com.example.apihex.Ordenes.Domain.Ports;

import com.example.apihex.Ordenes.Domain.Entities.OrdenProduc;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenProducResponse;

public interface IOrdenProducPort {

    OrdenProducResponse CrearOrdenProducto(OrdenProduc ordenProductos);
}

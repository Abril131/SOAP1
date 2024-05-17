package com.example.apihex.Ordenes.Domain.Ports;

import com.example.apihex.Ordenes.Domain.Entities.Orden;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.BaseResponse;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenResponse;

public interface IOrdenPort {
    BaseResponse Listar();
    OrdenResponse Crear(Orden orden);
    BaseResponse ActualizarStatus(String id, String status);

}

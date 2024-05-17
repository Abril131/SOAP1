package com.example.apihex.Ordenes.Infrestructure.datos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateOrdenProducRequest {
    private String productoId;
    private float total;
    private int cantidad;
}

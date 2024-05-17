package com.example.apihex.Ordenes.Infrestructure.datos.responses;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class OrdenProducResponse {
    private String id;
    private String ordenId;
    private String productoId;
    private float total;
    private int cantidad;
}

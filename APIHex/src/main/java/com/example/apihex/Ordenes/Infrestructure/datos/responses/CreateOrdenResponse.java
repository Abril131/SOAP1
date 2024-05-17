package com.example.apihex.Ordenes.Infrestructure.datos.responses;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CreateOrdenResponse {
    private OrdenResponse orden;
    private List<OrdenProducResponse> produc;
}

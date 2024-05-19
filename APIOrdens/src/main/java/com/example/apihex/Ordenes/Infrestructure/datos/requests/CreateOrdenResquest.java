package com.example.apihex.Ordenes.Infrestructure.datos.requests;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
public class CreateOrdenResquest {
    private float total;
    private Date fecha;
    private String status;
    private List<CreateOrdenProducRequest> produc;

}

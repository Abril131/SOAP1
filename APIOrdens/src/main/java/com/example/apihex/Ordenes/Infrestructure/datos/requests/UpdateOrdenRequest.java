package com.example.apihex.Ordenes.Infrestructure.datos.requests;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateOrdenRequest {
    private String id;
    private String status;
}

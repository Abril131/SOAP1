package com.example.apihex.Ordenes.Domain.Entities;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter

public class OrdenProduc {
    private String id;
    @Setter
    private String ordenId;
    @Setter
    private String productoId;
    @Setter
    private float total;
    @Setter
    private int cantidad;

    public OrdenProduc(){
        this.id = UUID.randomUUID().toString();
    }
}

package com.example.apihex.Ordenes.Infrestructure.Models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="ordenes_compra")
@Getter
@Setter

public class OrdenProducModel {
    @Id
    private String id;

    @Column(nullable = false)
    private String productoId;

    @Column(nullable = false)
    private String ordenId;

    @Column(nullable = false)
    private float total;

    @Column(nullable = false)
    private int cantidad;

    @ManyToOne
    @JoinColumn(name="orden_id")
    private OrdenModel orden;


}

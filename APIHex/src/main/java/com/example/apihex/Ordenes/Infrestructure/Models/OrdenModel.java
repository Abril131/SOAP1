package com.example.apihex.Ordenes.Infrestructure.Models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Date;

@Entity
@Table(name = "ordenes")
@Getter @Setter
public class OrdenModel {
    @Id
    private String id;

    @Column(nullable = false)
    private float total;

    @Column(nullable = false)
    private Date fecha;

    @Column(nullable = false)
    private String status;

    @OneToMany(mappedBy = "orden")
    private List<OrdenProducModel> productos;
}
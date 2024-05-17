package com.example.apihex.Ordenes.Infrestructure.Repository.JPA;

import com.example.apihex.Ordenes.Infrestructure.Models.OrdenModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenRepository extends JpaRepository<OrdenModel, String> {
}

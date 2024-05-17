package com.example.apihex.Ordenes.Infrestructure.Repository.JPA;

import com.example.apihex.Ordenes.Infrestructure.Models.OrdenProducModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IOrdenProducRepository extends JpaRepository<OrdenProducModel, String > {
}

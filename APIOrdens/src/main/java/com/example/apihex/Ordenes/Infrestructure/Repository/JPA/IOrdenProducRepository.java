package com.example.apihex.Ordenes.Infrestructure.Repository.JPA;

import com.example.apihex.Ordenes.Infrestructure.Models.OrdenProducModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdenProducRepository extends JpaRepository<OrdenProducModel, String > {
    @Query(value = "SELECT * FROM ordenes_productos WHERE orden_id = :ordenId ;", nativeQuery = true)
    List<OrdenProducModel> findByOrdenId(String ordenId);
}

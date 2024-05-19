package com.example.apihex.Ordenes.Infrestructure.Controllers.Orden;

import com.example.apihex.Ordenes.Application.UseCase.Orden.Create;
import com.example.apihex.Ordenes.Application.UseCase.OrdenProduc.CreateOrdenProducs;
import com.example.apihex.Ordenes.Infrestructure.datos.requests.CreateOrdenResquest;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.BaseResponse;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.CreateOrdenResponse;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenProducResponse;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.OrdenResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ordenes")
public class CreateController {
    @Autowired
    public Create mainUseCase;

    @Autowired
    public CreateOrdenProducs secondUseCase;

    @PostMapping
    public BaseResponse run(@RequestBody CreateOrdenResquest request){
        OrdenResponse orden = mainUseCase.run(request);
        List<OrdenProducResponse> productos = secondUseCase.run(orden.getId(), request.getProduc());
        CreateOrdenResponse response = new CreateOrdenResponse();
        response.setOrden(orden);
        response.setProduc(productos);
        return BaseResponse.builder().data(response).message("Orden creada con exito").success(true).httpStatus(HttpStatus.valueOf(201)).build();
    }

}
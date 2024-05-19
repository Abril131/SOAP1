package com.example.apihex.Ordenes.Infrestructure.Controllers.Orden;

import com.example.apihex.Ordenes.Application.UseCase.Orden.Get;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes")
public class GetController {

    @Autowired
    private Get useCase;

    @GetMapping
    public BaseResponse run(){return useCase.run();}
}

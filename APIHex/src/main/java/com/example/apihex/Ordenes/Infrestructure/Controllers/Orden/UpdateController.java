package com.example.apihex.Ordenes.Infrestructure.Controllers.Orden;

import com.example.apihex.Ordenes.Application.UseCase.Orden.Update;
import com.example.apihex.Ordenes.Infrestructure.datos.requests.UpdateOrdenRequest;
import com.example.apihex.Ordenes.Infrestructure.datos.responses.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ordenes")
public class UpdateController {

    @Autowired
    private Update useCase;

    @PutMapping
    public BaseResponse update(@RequestBody UpdateOrdenRequest request) {return useCase.run(request);}
}

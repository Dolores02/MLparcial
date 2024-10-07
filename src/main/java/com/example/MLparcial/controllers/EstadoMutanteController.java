package com.example.MLparcial.controllers;


import com.example.MLparcial.entities.EstadoMutantes;
import com.example.MLparcial.services.EstadoMutantesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class EstadoMutanteController extends BaseControllerImpl<EstadoMutantes, EstadoMutantesServiceImpl> {

    @Autowired
    private EstadoMutantesServiceImpl estadoMutantesServiceImpl;

    @GetMapping("/stats")
    public ResponseEntity<?> getStats(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(estadoMutantesServiceImpl.getEstadoMutantes());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }

}
package com.example.MLparcial.controllers;


import com.example.MLparcial.entities.Mutante;
import com.example.MLparcial.services.MutanteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@CrossOrigin(origins = "*")
public class MutanteController extends BaseControllerImpl <Mutante, MutanteServiceImpl> {

    @Autowired
    private MutanteServiceImpl mutanteServiceImpl;

    @PostMapping(path = "/mutant")
    public ResponseEntity<?> checkMutant(@RequestBody Mutante mutante){
       try {
           boolean isMutant = mutanteServiceImpl.isMutant(mutante.getDna());

           if (isMutant) {
               return ResponseEntity.ok().build();  //200ok
           } else {
               return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); //403 forbidden
           }
       } catch (IllegalArgumentException e) {
           return ResponseEntity.status(HttpStatus.FORBIDDEN).build(); //403 forbidden
       }
    }
    @PostMapping("/mutant/save")
    @Override
    public ResponseEntity<?> save(Mutante entity){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(servicio.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\":\"Error, por favor intente más tarde.\"}");
        }
    }
}
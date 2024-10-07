package com.example.MLparcial.services;

import com.example.MLparcial.entities.EstadoMutantes;

public interface EstadoMutantesService extends BaseService <EstadoMutantes, Long>{
    EstadoMutantes getEstadoMutantes(); //obtener los datos actuales del estado de mutantes y humano
    void incrementarMutantes();
    void incrementarHumanos();
    void resetEstado();
}

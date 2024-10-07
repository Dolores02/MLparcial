package com.example.MLparcial.services;

import com.example.MLparcial.entities.EstadoMutantes;
import com.example.MLparcial.repositories.EstadoMutantesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstadoMutantesServiceImpl extends BaseServiceImpl<EstadoMutantes, Long> implements EstadoMutantesService {

    @Autowired
    private EstadoMutantesRepository estadoMutantesRepository;

    private EstadoMutantes estadoMutantes;

    public EstadoMutantesServiceImpl(EstadoMutantesRepository estadoMutantesRepository) {
        super(estadoMutantesRepository);
        estadoMutantes = estadoMutantesRepository.findById(1L).orElse(new EstadoMutantes()); // Asume que hay solo 1 registro
    }

    @Override
    public EstadoMutantes getEstadoMutantes() {
        return estadoMutantes;
    }

    @Override
    public void incrementarMutantes() {
        estadoMutantes.setMutantCounter(estadoMutantes.getMutantCounter() + 1);
        estadoMutantesRepository.save(estadoMutantes);
    }

    @Override
    public void incrementarHumanos() {
        estadoMutantes.setHumanCounter(estadoMutantes.getHumanCounter() + 1);
        estadoMutantesRepository.save(estadoMutantes);
    }

    @Override
    public void resetEstado() {
        estadoMutantes.setMutantCounter(0);
        estadoMutantes.setHumanCounter(0);
        estadoMutantesRepository.save(estadoMutantes);
    }
}

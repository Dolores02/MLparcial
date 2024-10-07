package com.example.MLparcial.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name="EstadoMutantes")
@Entity
public class EstadoMutantes extends Base {
    @Column(name = "contador_mutantes")
    private int mutantCounter;
    @Column(name = "contador_humanos")
    private int humanCounter;

    public double getRatio() {
        if (humanCounter == 0) {
            return 0;  // Evita la división por cero
        }
        return (double) mutantCounter / humanCounter;
    }

}

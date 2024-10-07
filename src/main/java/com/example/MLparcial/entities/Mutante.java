package com.example.MLparcial.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Audited
@Builder
@Table(name = "Mutantes")
public class Mutante extends Base{
    @Column(nullable = false)
    private String[] dna;

}

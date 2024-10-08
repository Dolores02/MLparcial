package com.example.MLparcial.entities;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.envers.Audited;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Audited
@Builder
@Table(name = "Mutantes")
public class Mutante extends Base{
    @Column(nullable = false, name ="dna", unique = true)
    private String[] dna;

}

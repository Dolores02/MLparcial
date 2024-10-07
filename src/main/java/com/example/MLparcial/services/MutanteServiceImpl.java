package com.example.MLparcial.services;

import com.example.MLparcial.entities.Mutante;
import com.example.MLparcial.repositories.BaseRepository;
import com.example.MLparcial.repositories.MutanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MutanteServiceImpl extends BaseServiceImpl<Mutante, Long> implements MutanteService {

    @Autowired
    private MutanteRepository mutanteRepository;  //accedo desde el repo a todos los metodos

    @Autowired
    private EstadoMutantesService estadoMutantesService; // servicio para manejar el estado de mutantes y humanos

    public MutanteServiceImpl(BaseRepository<Mutante, Long> baseRepository) {
        super(baseRepository);
    }



    public boolean isMutant(String[] dna) { //le paso array de string
        int n = dna.length;  //n va hasta el largo de dna
        int counter = 0;   //contador arranca en 0

        //VERIFICO QUE TODAS LAS FILAS CONTENGAN ATCG Y TAM CORRECTO
        for (String row : dna) {
            if (row.length() != n) {
                throw new IllegalArgumentException("La matriz de ADN no es NxN.");
            }
            if (!row.matches("[ATCG]+")) {
                throw new IllegalArgumentException("El ADN contiene caracteres no permitidos.");
            }
        }
        //RECORRO MATRIZ FILA POR FILA, BUSCANDO SECUENCIAS DE 4 O MAS LETRAS IGUALES
        for (int row=0; row<n; row++) {
            for (int col=0; col<n; col++) {
                if (checkHorizontal(dna,row,col,n) ||
                        checkVertical(dna,row,col,n) ||
                        checkDiagonalRight(dna,row,col,n) ||
                        checkDiagonalLeft(dna,row,col,n)) {
                    counter++;   //si en alguna hay una secuencia, se suma al counter
                    if (counter>1) {
                        estadoMutantesService.incrementarMutantes();// actualizo el contador de mutantes en la base de datos
                        Mutante mutante = new Mutante(dna);
                        mutanteRepository.save(mutante);
                        return true;   //si hay mas de una secuencia, ES MUTANTE
                    }
                }
            }
        }
        estadoMutantesService.incrementarHumanos(); // no es mutante, actualizo el contador de humanos en la base de datos
        return false;
    }  //FIN ISMUTANT


   //METODOS HORIZONTAL, VERTICAL Y DIAGONALES PARA VER SI HAY 4 O MAS LETRAS IGUALES

    private boolean checkHorizontal(String[] dna, int row, int col, int n) {
        if (col + 3 < n) {  // Verifica que haya al menos 4 columnas disponibles y no pase de n
            char base = dna[row].charAt(col);  // Letra inicial en la posición (row, col)
            int count = 1;  // Contador de letras consecutivas iguales

            // Recorre hacia la derecha columna por columna, verificando si las siguientes letras son iguales
            for (int i = 1; i + col < n && dna[row].charAt(col + i) == base; i++) {  //recorre de 1 col por col hasta encontrar una LETRA IGUAL A LA BASE
                count++;  // Aumenta el contador si encuentra letras iguales
                if (count >= 4) {
                    return true;  // Si hay 4 o más letras iguales consecutivas, retorna true
                }
            }
        }
        return false;  // Si no encuentra secuencia, retorna false
    }
    private boolean checkVertical(String[] dna, int row, int col, int n) {
        if (row + 3 < n) {  // Verifica que haya al menos 4 filas disponibles
            char base = dna[row].charAt(col);  // Letra inicial en la posición (row, col)
            int count = 1;  // Contador de letras consecutivas iguales

            // Recorre hacia abajo, verificando si las siguientes letras son iguales
            for (int i = 1; i + row < n && dna[row + i].charAt(col) == base; i++) {  //recorre 1 por 1 las filas de la columna
                count++;  // Aumenta el contador si encuentra letras iguales
                if (count >= 4) {
                    return true;  // Si hay 4 o más letras iguales consecutivas, retorna true
                }
            }
        }
        return false;  // Si no encuentra secuencia, retorna false
    }
    private boolean checkDiagonalRight(String[] dna, int row, int col, int n) {
        if (row + 3 < n && col + 3 < n) {  // Verifica que haya al menos 4 posiciones en la diagonal ↘
            char base = dna[row].charAt(col);  // Letra inicial en la posición (row, col)
            int count = 1;  // Contador de letras consecutivas iguales

            // Recorre en diagonal ↘, verificando si las siguientes letras son iguales
            for (int i = 1; row + i < n && col + i < n && dna[row + i].charAt(col + i) == base; i++) {
                count++;  // Aumenta el contador si encuentra letras iguales
                if (count >= 4) {
                    return true;  // Si hay 4 o más letras iguales consecutivas, retorna true
                }
            }
        }
        return false;  // Si no encuentra secuencia, retorna false
    }
    private boolean checkDiagonalLeft(String[] dna, int row, int col, int n) {
        if (row + 3 < n && col - 3 >= 0) {  // Verifica que haya al menos 4 posiciones en la diagonal ↙
            char base = dna[row].charAt(col);  // Letra inicial en la posición (row, col)
            int count = 1;  // Contador de letras consecutivas iguales

            // Recorre en diagonal ↙, verificando si las siguientes letras son iguales
            for (int i = 1; row + i < n && col - i >= 0 && dna[row + i].charAt(col - i) == base; i++) {
                count++;  // Aumenta el contador si encuentra letras iguales
                if (count >= 4) {
                    return true;  // Si hay 4 o más letras iguales consecutivas, retorna true
                }
            }
        }
        return false;  // Si no encuentra secuencia, retorna false
    }

//AHORA TENGO QUE CONTAR CUANTOS MUTANTES Y HUMANOS TENGO

    public int getMutanteCount() {
        return estadoMutantesService.getEstadoMutantes().getMutantCounter();
    }

    public int getHumanoCount() {
        return estadoMutantesService.getEstadoMutantes().getHumanCounter();
    }



}

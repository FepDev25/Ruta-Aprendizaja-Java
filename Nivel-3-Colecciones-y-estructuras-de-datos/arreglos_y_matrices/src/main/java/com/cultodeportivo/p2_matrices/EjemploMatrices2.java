package com.cultodeportivo.p2_matrices;

import com.cultodeportivo.p2_matrices.models.Matriz;

public class EjemploMatrices2 {
    public static void main(String[] args) {

        Matriz  m1 = new Matriz();
        Matriz  m2 = new Matriz();

        m1.setMatriz(new int[][] {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        });
        m2.setMatriz(new int[][] {
            {1, 2, 3}, 
            {4, 5, 6}, 
            {7, 8, 9}
        });

        int[][] resultado = m1.sumarMatriz(m2);
        EjemploMatrices.imprimirMatriz(resultado, "Matriz 1 + Matriz 2: ");


        Matriz m3 = new Matriz();
        m3.setMatriz(new int[][] {
            {5, 3, -4, -2}, 
            {8, -1, 0, -3}
        });

        Matriz m4 = new Matriz();
        m4.setMatriz(new int[][] {
            {1, 4, 0}, 
            {-5, 3, 7},
            {0, -9, 5},
            {5, 1, 4} 
        });

        resultado = m3.multiplicarMatriz(m4);
        EjemploMatrices.imprimirMatriz(resultado, "Matriz 3 * Matriz 4: ");


        Matriz m5 = new Matriz();
        m5.setMatriz(new int[][] {
            {1, 2}, 
            {3, 4},
            {5, 6}
        });
        int[][] transpuesta = m5.transponerMatriz();
        EjemploMatrices.imprimirMatriz(transpuesta, "Matriz 5: ");
    }
}

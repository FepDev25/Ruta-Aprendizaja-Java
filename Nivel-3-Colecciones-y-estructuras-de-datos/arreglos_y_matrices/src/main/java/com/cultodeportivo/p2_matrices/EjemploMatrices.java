package com.cultodeportivo.p2_matrices;

public class EjemploMatrices {
    public static void main(String[] args) {

        int matriz [][] = new int [2][2];
        matriz[0][0] = 1;
        matriz[0][1] = 2;
        matriz[1][0] = 3;
        matriz[1][1] = 4;
        imprimirMatriz(matriz, "Matriz 1: ");

        int[][] matriz2 = {
            {1, 2, 5, 12, 8, 10}, 
            {3, 4, 11, 10, 1, 2}, 
            {5, 6, 7, 8, 9, 10},
            {11, 12, 13, 14, 15, 16}
        };
        imprimirMatriz(matriz2, "Matriz 2: ");

        Number[][] matriz3 = {
            {1.2, 2.12, 50, 12, -8, 10}, 
            {3.2, 21.2f, 11, 10, 11, 2}, 
            {5.1, 6.12f, 70, 80, 99, 10},
            {1.3f, 12.3, 13, -1, 15, 16}
        };
        imprimirMatriz(matriz3, "Matriz 3: ");
    }

    public static void imprimirMatriz(int[][] matriz, String mensaje) {
        System.out.println(mensaje);
        for (int[] fila : matriz) {
            for (int elemento : fila) {
                System.out.print(String.format("%4d", elemento));
            }
            System.out.println();
        }
    }

    public static void imprimirMatriz(Number[][] matriz, String mensaje) {
        System.out.println(mensaje);
        for (Number[] fila : matriz) {
            for (Number elemento : fila) {
                System.out.print("  " + elemento);
            }
            System.out.println();
        }
    }

}

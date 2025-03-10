package com.cultodeportivo.p2_matrices.models;

public class Matriz {
    
    private int[][] matriz;

    public Matriz() {}

    public int[][] sumarMatriz(Matriz m) {

        int[][] resultado = new int[this.matriz.length][this.matriz[0].length];
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                resultado[i][j] = this.matriz[i][j] + m.getMatriz()[i][j];
            }
        }
        return resultado;
    }

    public int[][ ] restarMatriz(Matriz m) {

        int[][] resultado = new int[this.matriz.length][this.matriz[0].length];
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                resultado[i][j] = this.matriz[i][j] - m.getMatriz()[i][j];
            }
        }
        return resultado;
    }

    public int[][] multiplicarEscalar(int escalar) {

        int[][] resultado = new int[this.matriz.length][this.matriz[0].length];
        for (int i = 0; i < this.matriz.length; i++) {
            for (int j = 0; j < this.matriz[0].length; j++) {
                resultado[i][j] = this.matriz[i][j] * escalar;
            }
        }
        return resultado;
    }

    public int[][] multiplicarMatriz(Matriz m) {
        int filasA = this.matriz.length;
        int columnasA = this.matriz[0].length;
        int filasB = m.getMatriz().length;
        int columnasB = m.getMatriz()[0].length;
    
        if (columnasA != filasB) {
            throw new IllegalArgumentException("Las matrices no son compatibles para la multiplicación.");
        }
    
        int[][] resultado = new int[filasA][columnasB];
    
        for (int i = 0; i < filasA; i++) {
            for (int j = 0; j < columnasB; j++) {
                int suma = 0;
                for (int k = 0; k < columnasA; k++) {
                    suma += this.matriz[i][k] * m.getMatriz()[k][j];
                }
                resultado[i][j] = suma;
            }
        }
        return resultado;
    }

    public int[][] transponerMatriz() {
        int filas = this.matriz.length;
        int columnas = this.matriz[0].length;
        int[][] transpuesta = new int[columnas][filas];
    
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                transpuesta[j][i] = this.matriz[i][j];
            }
        }
        return transpuesta;
    }


    public Matriz(int[][] matriz) {
        this.matriz = matriz;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public void setMatriz(int[][] matriz) {
        this.matriz = matriz;
    }
}

package com.cultodeportivo.p1_arreglos;

public class EjemploArreglos2 {
    public static void main(String[] args) {

        String[] nombres = {"Luis", "Paco", "Felipe"};
        EjemploArreglos.imprimirArreglo(nombres, "Arreglo de nombres");

        System.out.println("Acceeder a indices del arreglo");
        System.out.println("Longitud: " + nombres.length);
        System.out.println("Indice 0: " + nombres[0]);
        System.out.println("Indice 1: " + nombres[1]);
        System.out.println("Indice 2: " + nombres[2]);
        try {
            System.out.println("Indice 3: " + nombres[3]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
        
        
    }
}

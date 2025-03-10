package com.cultodeportivo.p1_arreglos;

import com.cultodeportivo.p1_arreglos.models.Persona;

public class EjemploArreglos {
    public static void main(String[] args) {
        
        String nombres[] = new String[3];
        nombres[0] = "Luis";
        nombres[1] = "Paco";
        nombres[2] = "Felipe";
        imprimirArreglo(nombres, "Arreglo de nombres");

        Persona personas[] = new Persona[3];
        personas[0] = new Persona("Luis", 20);
        personas[1] = new Persona("Paco", 30);
        personas[2] = new Persona("Felipe", 40);
        imprimirArreglo(personas, "Arreglo de personas");

        Object[] objetos = new Object[3];
        objetos[0] = "Luis";
        objetos[1] = 20;
        objetos[2] = new Persona("Paco", 30);
        imprimirArreglo(objetos, "Arreglo de objetos");

        int[] enteros = new int[3];
        enteros[0] = 10;
        enteros[1] = 20;
        enteros[2] = 30;
        for (int i = 0; i < enteros.length; i++) {
            System.out.println(enteros[i]);
        }

    }


    public static void imprimirArreglo(Object[] arreglo, String nombre) {    
        System.out.println(nombre);
        for (Object arreglo1 : arreglo) {
            System.out.println(arreglo1);
        }
    }
}

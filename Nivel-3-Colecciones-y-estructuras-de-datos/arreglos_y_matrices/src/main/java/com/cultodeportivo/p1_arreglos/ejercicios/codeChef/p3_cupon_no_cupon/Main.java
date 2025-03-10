package com.cultodeportivo.p1_arreglos.ejercicios.codeChef.p3_cupon_no_cupon;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int sizeArray = scanner.nextInt();
                int costoCupon = scanner.nextInt();
                int descuentoAplicado = scanner.nextInt();
                int[] array = new int[sizeArray];

                for (int i = 0; i < sizeArray; i++) {
                    array[i] = scanner.nextInt();
                }

                int sumaInicial = sumarArreglo(array);

                for (int i = 0; i < sizeArray; i++) {
                    int newValor = array[i] - descuentoAplicado;
                    array[i] = newValor > 0 ? newValor : 0;
                }

                int sumaPostCupon = sumarArreglo(array);
                
                int costoTotal = sumaPostCupon + costoCupon;
                System.out.println(costoTotal >= sumaInicial ? "NO COUPON" : "COUPON");
            }
        }
    }

    public static int sumarArreglo(int[] array) {
        int suma = 0;
        for (int i = 0; i < array.length; i++) {
            suma += array[i];
        }
        return suma;
    }
}
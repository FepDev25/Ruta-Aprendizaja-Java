package com.cultodeportivo.p1_arreglos.ejercicios.codeChef.p4_costo_viveres;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int nArticulos = scanner.nextInt();
                int valorFrescura = scanner.nextInt();
                int[] articulos = new int[nArticulos];
                int[] precios = new int[nArticulos];
                
                for (int i = 0; i < nArticulos; i++) {
                    articulos[i] = scanner.nextInt();
                }
                
                for (int j = 0; j < nArticulos; j++) {
                    precios[j] = scanner.nextInt();
                }

                int total = 0;
                for (int i = 0; i < nArticulos; i++) {
                    if (articulos[i] >= valorFrescura) {
                        total += precios[i];
                    }
                }

                System.out.println(total);
                

            }
        }
    }
}

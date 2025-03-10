package com.cultodeportivo.p1_arreglos.ejercicios.codeChef.p4_costo_viveres;

import java.util.Scanner;

public class MainOpt {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int n = scanner.nextInt();
                int x = scanner.nextInt();
                int total = 0;

                int[] frescura = new int[n];
                for (int i = 0; i < n; i++) {
                    frescura[i] = scanner.nextInt();
                }

                for (int i = 0; i < n; i++) {
                    int precio = scanner.nextInt();
                    if (frescura[i] >= x) {
                        total += precio;
                    }
                }

                System.out.println(total);
            }
        }
    }
}

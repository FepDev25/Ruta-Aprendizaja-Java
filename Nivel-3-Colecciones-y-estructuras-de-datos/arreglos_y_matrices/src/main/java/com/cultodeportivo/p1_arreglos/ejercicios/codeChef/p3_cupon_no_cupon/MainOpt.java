package com.cultodeportivo.p1_arreglos.ejercicios.codeChef.p3_cupon_no_cupon;

import java.util.Scanner;

public class MainOpt {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int t = scanner.nextInt();

            while (t-- > 0) {
                int sizeArray = scanner.nextInt();
                int costoCupon = scanner.nextInt();
                int descuentoAplicado = scanner.nextInt();
                
                int costoInicial = 0, sumaPostCupon = 0;

                for (int i = 0; i < sizeArray; i++) {
                    int precio = scanner.nextInt();
                    costoInicial += precio;
                    sumaPostCupon += Math.max(0, precio - descuentoAplicado);
                }

                int costoTotal = sumaPostCupon + costoCupon;
                System.out.println(costoTotal < costoInicial ? "COUPON" : "NO COUPON");
            }
        }
    }
}

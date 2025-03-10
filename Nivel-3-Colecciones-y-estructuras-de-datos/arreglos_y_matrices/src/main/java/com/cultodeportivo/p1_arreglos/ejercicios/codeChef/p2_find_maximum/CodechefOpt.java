package com.cultodeportivo.p1_arreglos.ejercicios.codeChef.p2_find_maximum;

import java.util.Scanner;

public class CodechefOpt {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int T = sc.nextInt();
            while (T-- > 0) {
                int N = sc.nextInt();
                int max = 0;

                for (int i = 0; i < N; i++) {
                    int num = sc.nextInt();
                    if (num > max) {
                        max = num;
                    }
                }
                System.out.println(max);
            }
        }
    }
}

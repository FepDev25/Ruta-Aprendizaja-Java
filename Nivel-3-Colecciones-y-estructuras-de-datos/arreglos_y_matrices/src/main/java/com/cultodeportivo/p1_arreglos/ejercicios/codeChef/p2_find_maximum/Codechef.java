package com.cultodeportivo.p1_arreglos.ejercicios.codeChef.p2_find_maximum;

import java.util.Scanner;

public class Codechef {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
        
            int T = sc.nextInt();
            while(T > 0){

                int N = sc.nextInt();
                int[] array = pedirDatos(N, sc);
                int result = returnMaximum(array);
                System.out.println(result);

                T -= 1;
            }   
        }
    }

    public static int[] pedirDatos(int N, Scanner sc){
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = sc.nextInt();
        }
        return array;
    }

    public static  int returnMaximum(int[] array){
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){
                max = array[i];
            }
        }
        return max;

    }
}

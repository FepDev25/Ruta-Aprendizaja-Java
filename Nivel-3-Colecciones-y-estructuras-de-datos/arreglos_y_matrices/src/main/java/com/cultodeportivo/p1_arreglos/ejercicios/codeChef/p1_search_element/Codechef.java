package com.cultodeportivo.p1_arreglos.ejercicios.codeChef.p1_search_element;

import java.util.Scanner;

class Codechef {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int N = sc.nextInt();
            int X = sc.nextInt();
            
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            
            System.out.println(searchElement(arr, N, X));
        }
    }

    public static String searchElement(int arr[], int n, int x) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == x) {
                return "YES";
            }
        }
        return "NO";
    }
}

package com.cultodeportivo;

import com.cultodeportivo.threads.HiloMio;

public class EjemploThread {
    public static void main(String[] args) {
        Thread thread1 = new HiloMio("Hilo 1");
        Thread thread2 = new HiloMio("Hilo 2");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
           System.out.println("Error: " + e.getMessage());
        }

        new HiloMio("Hilo3").start();

    }
}

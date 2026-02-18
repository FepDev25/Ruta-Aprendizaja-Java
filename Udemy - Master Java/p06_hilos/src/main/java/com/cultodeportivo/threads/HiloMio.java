package com.cultodeportivo.threads;

public class HiloMio extends Thread {

    public HiloMio(String name){
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Iniciando metodo run en " + this.getName());
        for (int i = 0; i < 11; i++) {
            System.out.println("Paso: " + i + " de hilo: " + this.getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Exception: " + ex.getMessage());
            }
        }
    }

    
    
}

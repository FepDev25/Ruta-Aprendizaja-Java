package com.cultodeportivo.proyectos_integradores.p02_calculadora_cientifica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Calculadora {

    private static final int MAX_HISTORIAL = 10;
    public List<String> historial;
    private final Scanner sc;
    private static final String TEXTO_MENU = """
            === CALCULADORA CIENTÍFICA ===
            1. Operaciones Básicas
            2. Operaciones Avanzadas                  
            3. Trigonometría                          
            4. Conversiones Numéricas                 
            5. Operaciones con Potencias y Raíces     
            6. Estadística Básica                     
            7. Calculadora de Porcentajes             
            8. Historial de operaciones               
            9. Limpiar historial                      
            0. Salir       
            """;
    private final OpBasicas opBasicas;

    public Calculadora() {
        this.historial = new ArrayList<>();
        this.sc = new Scanner(System.in);
        this.opBasicas = new OpBasicas(this, sc);
    }

    public void menu(){
        int opcion = -1;

        while (opcion != 0) {
            System.out.print(TEXTO_MENU);
            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                switch (opcion) {
                    case 1 -> opBasicas.menu();
                    case 2 -> System.out.println("Operaciones Avanzadas - En desarrollo");
                    case 3 -> System.out.println("Trigonometría - En desarrollo");
                    case 4 -> System.out.println("Conversiones Numéricas - En desarrollo");
                    case 5 -> System.out.println("Operaciones con Potencias y Raíces - En desarrollo");
                    case 6 -> System.out.println("Estadística Básica - En desarrollo");
                    case 7 -> System.out.println("Calculadora de Porcentajes - En desarrollo");
                    case 8 -> mostrarHistorial();
                    case 9 -> limpiarHistorial();
                    case 0 -> System.out.println("Saliendo...");
                    default -> System.out.println("Opción no válida!");
                }
            } else {
                System.out.println("Por favor ingrese un número válido.");
                sc.next(); // Limpiar la entrada inválida
            }
        }
    }

    private void mostrarHistorial() {
        if (historial.isEmpty()) {
            System.out.println("El historial está vacío.");
        } else {
            System.out.println("Historial de operaciones (últimas " + historial.size() + " de máximo " + MAX_HISTORIAL + "):");
            for (int i = 0; i < historial.size(); i++) {
                System.out.println((i + 1) + ". " + historial.get(i));
            }
        }
    }

    private void limpiarHistorial() {
        historial.clear();
        System.out.println("Historial limpiado.");
    }

    public void agregarAlHistorial(String operacion) {
        historial.add(operacion);
        // Si el historial supera el límite, eliminar la operación más antigua
        if (historial.size() > MAX_HISTORIAL) {
            historial.remove(0);
        }
    }
}
package com.cultodeportivo.proyectos_integradores.p02_calculadora_cientifica;

import java.util.Scanner;
import java.util.function.BiFunction;

public class OpBasicas {

    private final Scanner sc;
    private final Calculadora calculadora;
    private final String TEXTO_MENU = """
            === Operaciones básicas ===
            1. Sumar
            2. Restar
            3. Multiplicar
            4. Dividir
            5. Módulo
            6. Sumar múltiples números
            7. Restar múltiples números
            8. Multiplicar múltiples números
            9. Salir
            Seleccione una opción: 
            """;

    public OpBasicas(Calculadora calculadora, Scanner sc) {
        this.calculadora = calculadora;
        this.sc = sc;
    }

    public void menu(){
        int operacion = 0;

        while (operacion != 9) {
            System.out.print(TEXTO_MENU);
            
            if (!sc.hasNextInt()) {
                System.out.println("Por favor ingrese un número válido.");
                sc.next(); // Limpiar la entrada inválida
                continue;
            }
            
            operacion = sc.nextInt();
            ejecutarOperacion(operacion);
        }
    }

    private void ejecutarOperacion(int operacion) {
        switch (operacion) {
            case 1 -> sumar();
            case 2 -> restar();
            case 3 -> multiplicar();
            case 4 -> dividir();
            case 5 -> modulo();
            case 6 -> sumarMultiples();
            case 7 -> restarMultiple();
            case 8 -> multiplicarMultiple();
            case 9 -> System.out.println("Saliendo...");
            default -> System.out.println("Opción no válida!");
        }
    }

    private int pedirNumero(String orden){
        System.out.println("Ingrese " + orden + " número: ");
        return sc.nextInt();
    }

    // Método genérico para operaciones binarias simples
    private void operacionBinaria(String operador, BiFunction<Integer, Integer, Number> operacion) {
        sc.nextLine(); // Consumir salto de línea pendiente
        int x = pedirNumero("primer");
        int y = pedirNumero("segundo");

        // Validación para división y módulo
        if ((operador.equals("/") || operador.equals("%")) && y == 0) {
            System.out.println("Error: El divisor no puede ser cero.");
            return;
        }

        Number resultado = operacion.apply(x, y);
        String operacionStr = x + " " + operador + " " + y + " = " + resultado;
        calculadora.agregarAlHistorial(operacionStr);

        System.out.println("Resultado: " + resultado);
    }

    public void sumar(){
        operacionBinaria("+", (x, y) -> x + y);
    }

    public void restar(){
        operacionBinaria("-", (x, y) -> x - y);
    }

    public void multiplicar(){
        operacionBinaria("*", (x, y) -> x * y);
    }

    public void dividir(){
        operacionBinaria("/", (x, y) -> (double) x / y);
    }

    public void modulo(){
        operacionBinaria("%", (x, y) -> x % y);
    }

    // Método genérico para operaciones múltiples
    private void operacionMultiple(String nombreOperacion, String operador, 
                                   int valorInicial, 
                                   BiFunction<Integer, Integer, Integer> operacion) {
        sc.nextLine(); // Consumir salto de línea pendiente
        System.out.println("Ingrese números para " + nombreOperacion + " (separados por espacio): ");
        String entrada = sc.nextLine().trim();
        
        if (entrada.isEmpty()) {
            System.out.println("No se ingresaron números.");
            return;
        }
        
        String[] numeros = entrada.split("\\s+");
        int resultado = valorInicial;
        StringBuilder sb = new StringBuilder();
        boolean primerNumero = true;
        
        for (String numStr : numeros) {
            try {
                int num = Integer.parseInt(numStr);
                
                if (primerNumero) {
                    resultado = num;
                    sb.append(num);
                    primerNumero = false;
                } else {
                    resultado = operacion.apply(resultado, num);
                    sb.append(" ").append(operador).append(" ").append(num);
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida ignorada: " + numStr);
            }
        }
        
        if (!primerNumero) { // Si se procesó al menos un número válido
            sb.append(" = ").append(resultado);
            calculadora.agregarAlHistorial(sb.toString());
            System.out.println("Resultado: " + resultado);
        } else {
            System.out.println("No se ingresaron números válidos.");
        }
    }

    public void sumarMultiples(){
        operacionMultiple("sumar", "+", 0, (a, b) -> a + b);
    }

    public void restarMultiple(){
        operacionMultiple("restar", "-", 0, (a, b) -> a - b);
    }

    public void multiplicarMultiple(){
        operacionMultiple("multiplicar", "*", 1, (a, b) -> a * b);
    }

}
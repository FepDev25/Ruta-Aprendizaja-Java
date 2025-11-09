package com.cultodeportivo.proyectos_integradores.p01_sistema_gestion_biblioteca;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

class Biblioteca {

    public static final int MAX_LIBROS = 50;
    public static final String TEXTO_MENU = """
            === SISTEMA DE GESTIÓN DE BIBLIOTECA ===
            1. Registrar nuevo libro
            2. Buscar libro por título
            3. Buscar libro por autor
            4. Listar todos los libros
            5. Mostrar estadísticas
            6. Verificar disponibilidad
            7. Salir
            Seleccione una opción: 
            """;

    private ArrayList<Libro> libros;
    private final Scanner s = new Scanner(System.in);

    public Biblioteca() {
        this.libros = new ArrayList<>();
    }

    public void startMenu() {
        int opcion = 0;

        while (opcion != 7) {
            System.out.print(TEXTO_MENU);

            if (s.hasNextInt()) {  // Verificar si hay un entero disponible
                opcion = s.nextInt();
                limpiarConsola();

                switch (opcion) {
                    case 1 ->
                        registrarLibros();
                    case 2 ->
                        buscarLibroPorNombre();
                    case 3 ->
                        buscarLibroPorAutor();
                    case 4 ->
                        listarTodosLibros();
                    case 5 ->
                        mostrarEstadisticas();
                    case 6 ->
                        verificarDisponibilidad();
                    case 7 ->
                        System.out.println("Adiós!");
                    default ->
                        System.out.println("Opción no válida!");
                }
            } else {
                limpiarConsola();
                String invalido = s.next(); // consume la entrada errónea
                System.out.println("Entrada no válida: '" + invalido + "'. Debes ingresar un número.");
            }

            if (opcion != 7) {
                confirmarAvance();
                limpiarConsola();
            }
        }
    }

    public void registrarLibros() {
        s.nextLine(); // Consumir el salto de línea pendiente

        // Solicitar: Título, Autor, ISBN, Año de publicación, Número de páginas, Categoría
        System.out.println("Ingrese el título del libro:");
        String titulo = s.nextLine();

        System.out.println("Ingrese el autor del libro:");
        String autor = s.nextLine();

        System.out.println("Ingrese el ISBN del libro (13 dígitos):");
        String isbn = s.nextLine();

        System.out.println("Ingrese el año de publicación:");
        int anio = s.nextInt();

        System.out.println("Ingrese el número de páginas:");
        int paginas = s.nextInt();
        s.nextLine(); // Consumir el salto de línea

        System.out.println("Ingrese la categoría del libro:");
        String categoria = s.nextLine();

        // Validaciones
        // Validar que el ISBN tenga exactamente 13 dígitos
        if (isbn.length() != 13) {
            System.out.println("El ISBN debe tener exactamente 13 dígitos.");
            return;
        }

        // Validar que el año sea entre 1500 y el año actual
        if (anio < 1500 || anio > 2025) {
            System.out.println("El año debe estar entre 1500 y 2025.");
            return;
        }

        // Almacenar hasta 50 libros
        if (libros.size() >= MAX_LIBROS) {
            System.out.println("No se pueden registrar más libros.");
            return;
        }

        // Crear y almacenar el libro
        Libro libro = new Libro(titulo, autor, isbn, anio, paginas, categoria);
        libros.add(libro);

        // Mensaje de confirmación con todos los datos ingresados
        System.out.println("Libro registrado con éxito:");
        System.out.println(libro);
    }

    public void buscarLibroPorNombre() {
        s.nextLine(); // Consumir el salto de línea pendiente
        ArrayList<Libro> resultados = new ArrayList<>();

        System.out.println("Ingrese el título del libro a buscar:");
        String titulo = s.nextLine();

        this.libros.forEach(libro -> {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                resultados.add(libro);
            }
        });

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron libros con el título proporcionado.");
        } else {
            System.out.println("Libros encontrados:");
            resultados.forEach(System.out::println);
        }

    }

    public void buscarLibroPorAutor() {
        s.nextLine(); // Consumir el salto de línea pendiente
        ArrayList<Libro> resultados = new ArrayList<>();

        System.out.println("Ingrese el autor del libro a buscar:");
        String autor = s.nextLine();

        this.libros.forEach(libro -> {
            if (libro.getAutor().toLowerCase().contains(autor.toLowerCase())) {
                resultados.add(libro);
            }
        });

        if (resultados.isEmpty()) {
            System.out.println("No se encontraron libros del autor proporcionado.");
        } else {
            System.out.println("Libros encontrados:");
            resultados.forEach(System.out::println);
        }
    }

    public void listarTodosLibros() {
        s.nextLine(); // Consumir el salto de línea pendiente
        if (this.libros.isEmpty()) {
            System.out.println("No hay libros registrados en la biblioteca.");
        } else {
            System.out.println("Listado de todos los libros:");
            this.libros.forEach(System.out::println);
        }
    }

    public void mostrarEstadisticas() {
        s.nextLine(); // Consumir el salto de línea pendiente

        // Total de libros en la biblioteca
        int totalLibros = this.libros.size();
        if (totalLibros == 0) {
            System.out.println("No hay libros registrados en la biblioteca.");
            return;
        }
        System.out.println("Total de libros en la biblioteca: " + totalLibros);

        // Calcular y mostrar el libro más antiguo y más reciente, y el promedio de páginas por libro
        Libro libroMasAntiguo = this.libros.get(0);
        Libro libroMasReciente = this.libros.get(0);
        int totalPaginas = 0;

        for (Libro libro : this.libros) {
            if (libro.getAnioPublicacion() < libroMasAntiguo.getAnioPublicacion()) {
                libroMasAntiguo = libro;
            }
            if (libro.getAnioPublicacion() > libroMasReciente.getAnioPublicacion()) {
                libroMasReciente = libro;
            }
            totalPaginas += libro.getNumPaginas();
        }

        System.out.println("Libro más antiguo: " + libroMasAntiguo);
        System.out.println("Libro más reciente: " + libroMasReciente);
        System.out.println("Promedio de páginas por libro: " + (totalPaginas / totalLibros));

        // Categoría con más libros
        Map<String, Integer> conteoCategorias = new HashMap<>();
        for (Libro libro : this.libros) {
            String categoria = libro.getCategoria();
            conteoCategorias.put(categoria, conteoCategorias.getOrDefault(categoria, 0) + 1);
        }

        String categoriaMasFrecuente = Collections.max(conteoCategorias.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Categoría con más libros: " + categoriaMasFrecuente);

        // Total de páginas en toda la biblioteca
        System.out.println("Total de páginas en toda la biblioteca: " + totalPaginas);
    }

    public void verificarDisponibilidad() {
        s.nextLine(); // Limpia el salto de línea pendiente

        System.out.println("Ingrese el ISBN del libro a buscar:");
        String isbn = s.nextLine().trim(); // Limpia espacios

        Optional<Libro> resultado = this.libros.stream()
                .filter(libro -> libro.getIsbn().equals(isbn))
                .findFirst();

        if (resultado.isEmpty()) {
            System.out.println("No se encontró ningún libro con el ISBN proporcionado.");
        } else {
            Libro libro = resultado.get();
            System.out.println("Libro encontrado:");
            System.out.println(libro);
        }
    }

    // Métodos privados
    private void limpiarConsola() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            System.out.println("No se pudo limpiar la consola.");
        }
    }

    private void confirmarAvance() {
        System.out.println("\nPresiona ENTER para continuar...");
        s.nextLine();
    }

    // Getters y Setters
    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> libros) {
        this.libros = libros;
    }

}

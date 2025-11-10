# PROYECTO 06: Sistema de Reserva de Asientos 💺

## Dificultad: ⭐⭐

## Descripción General

Sistema de reserva de asientos para cine, teatro o avión. Gestiona disponibilidad, precios por zona, visualización gráfica del mapa de asientos y generación de tickets.

## Estructura de Datos

```java
final int FILAS = 10;
final int COLUMNAS = 12;

// Estados de asientos: 0=Disponible, 1=Reservado, 2=Bloqueado
int[][] asientos = new int[FILAS][COLUMNAS];

// Información de reservas
String[][] nombresReserva = new String[FILAS][COLUMNAS];
int[][] numeroReserva = new int[FILAS][COLUMNAS];

// Precios por zona
double[] preciosPorFila = new double[FILAS];

// Estados
final int DISPONIBLE = 0;
final int RESERVADO = 1;
final int BLOQUEADO = 2;

// Contadores
int totalReservas = 0;
int numeroReservaActual = 1000;
double ingresosTotales = 0.0;
```

## Funcionalidades

### 1. Gestión de Asientos

- Inicializar sala de cine/teatro/avión
- Visualizar mapa de asientos con formato bonito
- Reservar asiento individual
- Reservar grupo de asientos
- Cancelar reserva
- Bloquear/desbloquear asientos

### 2. Búsqueda y Consultas

- Buscar asientos disponibles por zona
- Buscar reserva por nombre
- Buscar reserva por número
- Listar todas las reservas
- Mostrar estadísticas de ocupación

### 3. Zonas de Precio

- **VIP (Filas 1-3):** Precio más alto
- **Premium (Filas 4-6):** Precio medio
- **General (Filas 7-10):** Precio estándar
- Descuentos por grupo

### 4. Tickets y Reportes

- Generar ticket de reserva
- Reporte de ingresos totales
- Mapa de calor de popularidad
- Estadísticas por zona

## Algoritmos Clave

### Inicializar Sala

```java
void inicializarSala() {
    // Todos los asientos disponibles
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            asientos[i][j] = DISPONIBLE;
            nombresReserva[i][j] = "";
            numeroReserva[i][j] = 0;
        }
    }
    
    // Asignar precios por zona
    for (int i = 0; i < 3; i++) {
        preciosPorFila[i] = 15.00;  // VIP
    }
    for (int i = 3; i < 6; i++) {
        preciosPorFila[i] = 10.00;  // Premium
    }
    for (int i = 6; i < FILAS; i++) {
        preciosPorFila[i] = 7.00;   // General
    }
}
```

### Visualizar Mapa de Asientos

```java
void mostrarMapaAsientos() {
    System.out.println("\n       PANTALLA / ESCENARIO");
    System.out.println("    " + "═".repeat(COLUMNAS * 3));
    System.out.println();
    
    System.out.print("     ");
    for (int j = 0; j < COLUMNAS; j++) {
        System.out.printf("%2d ", j + 1);
    }
    System.out.println("\n");
    
    for (int i = 0; i < FILAS; i++) {
        System.out.printf("%2d  │", i + 1);
        
        for (int j = 0; j < COLUMNAS; j++) {
            char simbolo;
            
            switch (asientos[i][j]) {
                case DISPONIBLE:
                    simbolo = '▢';  // Disponible
                    break;
                case RESERVADO:
                    simbolo = '▣';  // Reservado
                    break;
                case BLOQUEADO:
                    simbolo = '✖';  // Bloqueado
                    break;
                default:
                    simbolo = '?';
            }
            
            System.out.print(" " + simbolo + " ");
            
            // Pasillo en el medio
            if (j == COLUMNAS / 2 - 1) {
                System.out.print(" ");
            }
        }
        
        System.out.printf("│ $%.2f", preciosPorFila[i]);
        
        // Indicar zona
        if (i < 3) {
            System.out.print(" [VIP]");
        } else if (i < 6) {
            System.out.print(" [PREMIUM]");
        } else {
            System.out.print(" [GENERAL]");
        }
        
        System.out.println();
    }
    
    System.out.println("\nLeyenda: ▢ Disponible  ▣ Reservado  ✖ Bloqueado");
    System.out.printf("Ocupación: %d/%d asientos\n", 
                     totalReservas, FILAS * COLUMNAS);
}
```

### Reservar Asiento

```java
boolean reservarAsiento(int fila, int columna, String nombre) {
    // Validar coordenadas
    if (!esAsientoValido(fila, columna)) {
        System.out.println("Asiento no válido.");
        return false;
    }
    
    // Verificar disponibilidad
    if (asientos[fila][columna] != DISPONIBLE) {
        System.out.println("Asiento no disponible.");
        return false;
    }
    
    // Realizar reserva
    asientos[fila][columna] = RESERVADO;
    nombresReserva[fila][columna] = nombre;
    numeroReserva[fila][columna] = numeroReservaActual++;
    totalReservas++;
    
    double precio = preciosPorFila[fila];
    ingresosTotales += precio;
    
    // Generar ticket
    generarTicket(fila, columna, nombre, precio, 
                  numeroReserva[fila][columna]);
    
    return true;
}

boolean esAsientoValido(int fila, int columna) {
    return fila >= 0 && fila < FILAS && 
           columna >= 0 && columna < COLUMNAS;
}
```

### Reservar Grupo de Asientos

```java
boolean reservarGrupo(int fila, int columnaInicio, 
                     int cantidad, String nombre) {
    // Verificar disponibilidad del grupo
    for (int j = columnaInicio; j < columnaInicio + cantidad; j++) {
        if (!esAsientoValido(fila, j) || 
            asientos[fila][j] != DISPONIBLE) {
            System.out.println("Grupo no disponible.");
            return false;
        }
    }
    
    // Reservar todos los asientos
    double precioTotal = 0;
    int numeroReservaGrupo = numeroReservaActual++;
    
    for (int j = columnaInicio; j < columnaInicio + cantidad; j++) {
        asientos[fila][j] = RESERVADO;
        nombresReserva[fila][j] = nombre;
        numeroReserva[fila][j] = numeroReservaGrupo;
        totalReservas++;
        precioTotal += preciosPorFila[fila];
    }
    
    // Aplicar descuento por grupo (5% si >= 4 asientos)
    if (cantidad >= 4) {
        precioTotal *= 0.95;
    }
    
    ingresosTotales += precioTotal;
    
    System.out.printf("Reserva grupal exitosa. Total: $%.2f\n", 
                     precioTotal);
    generarTicketGrupo(fila, columnaInicio, cantidad, nombre, 
                      precioTotal, numeroReservaGrupo);
    
    return true;
}
```

### Cancelar Reserva

```java
boolean cancelarReserva(int numeroReserva) {
    boolean encontrada = false;
    
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            if (this.numeroReserva[i][j] == numeroReserva) {
                asientos[i][j] = DISPONIBLE;
                double reembolso = preciosPorFila[i];
                ingresosTotales -= reembolso;
                totalReservas--;
                
                nombresReserva[i][j] = "";
                this.numeroReserva[i][j] = 0;
                
                System.out.printf("Asiento (%d,%d) liberado. " +
                                "Reembolso: $%.2f\n", 
                                i + 1, j + 1, reembolso);
                encontrada = true;
            }
        }
    }
    
    return encontrada;
}
```

### Buscar Asientos Disponibles en Zona

```java
void buscarDisponiblesPorZona(String zona) {
    int filaInicio = 0, filaFin = 0;
    
    switch (zona.toUpperCase()) {
        case "VIP":
            filaInicio = 0; filaFin = 3;
            break;
        case "PREMIUM":
            filaInicio = 3; filaFin = 6;
            break;
        case "GENERAL":
            filaInicio = 6; filaFin = FILAS;
            break;
        default:
            System.out.println("Zona no válida.");
            return;
    }
    
    System.out.println("\nAsientos disponibles en zona " + zona + ":");
    int contador = 0;
    
    for (int i = filaInicio; i < filaFin; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            if (asientos[i][j] == DISPONIBLE) {
                System.out.printf("Fila %d, Asiento %d ($%.2f)  ", 
                                i + 1, j + 1, preciosPorFila[i]);
                contador++;
                if (contador % 4 == 0) System.out.println();
            }
        }
    }
    
    System.out.println("\n\nTotal: " + contador + " asientos");
}
```

### Generar Ticket

```java
void generarTicket(int fila, int columna, String nombre, 
                  double precio, int numeroReserva) {
    System.out.println("\n" + "═".repeat(40));
    System.out.println("       TICKET DE RESERVA");
    System.out.println("═".repeat(40));
    System.out.printf("Nº Reserva: %d\n", numeroReserva);
    System.out.printf("Nombre:     %s\n", nombre);
    System.out.printf("Asiento:    Fila %d, Columna %d\n", 
                     fila + 1, columna + 1);
    System.out.printf("Zona:       %s\n", obtenerZona(fila));
    System.out.printf("Precio:     $%.2f\n", precio);
    System.out.println("═".repeat(40));
}

String obtenerZona(int fila) {
    if (fila < 3) return "VIP";
    if (fila < 6) return "PREMIUM";
    return "GENERAL";
}
```

### Estadísticas de Ocupación

```java
void mostrarEstadisticas() {
    int totalAsientos = FILAS * COLUMNAS;
    double porcentajeOcupacion = (totalReservas * 100.0) / totalAsientos;
    
    System.out.println("\n╔════════════════════════════════════╗");
    System.out.println("║       ESTADÍSTICAS DE SALA         ║");
    System.out.println("╠════════════════════════════════════╣");
    System.out.printf("║ Total asientos:       %3d          ║\n", 
                     totalAsientos);
    System.out.printf("║ Asientos reservados:  %3d          ║\n", 
                     totalReservas);
    System.out.printf("║ Asientos disponibles: %3d          ║\n", 
                     totalAsientos - totalReservas);
    System.out.printf("║ Ocupación:          %.1f%%          ║\n", 
                     porcentajeOcupacion);
    System.out.printf("║ Ingresos totales:  $%.2f        ║\n", 
                     ingresosTotales);
    System.out.println("╚════════════════════════════════════╝");
    
    // Estadísticas por zona
    mostrarEstadisticasPorZona();
}

void mostrarEstadisticasPorZona() {
    System.out.println("\nOcupación por zona:");
    
    String[] zonas = {"VIP", "PREMIUM", "GENERAL"};
    int[][] rangos = {{0, 3}, {3, 6}, {6, FILAS}};
    
    for (int z = 0; z < zonas.length; z++) {
        int ocupados = 0;
        int total = (rangos[z][1] - rangos[z][0]) * COLUMNAS;
        
        for (int i = rangos[z][0]; i < rangos[z][1]; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                if (asientos[i][j] == RESERVADO) {
                    ocupados++;
                }
            }
        }
        
        double porcentaje = (ocupados * 100.0) / total;
        System.out.printf("%-8s: %3d/%3d (%.1f%%)\n", 
                         zonas[z], ocupados, total, porcentaje);
    }
}
```

## Menú Principal

```bash
╔════════════════════════════════════════════╗
║      SISTEMA DE RESERVA DE ASIENTOS        ║
╠════════════════════════════════════════════╣
║  1. Ver mapa de asientos                   ║
║  2. Reservar asiento individual            ║
║  3. Reservar grupo de asientos             ║
║  4. Cancelar reserva                       ║
║  5. Buscar reserva                         ║
║  6. Buscar disponibles por zona            ║
║  7. Ver estadísticas                       ║
║  8. Bloquear/desbloquear asiento           ║
║  9. Reiniciar sala                         ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Validaciones

- Coordenadas dentro de límites
- Asiento disponible antes de reservar
- Nombre válido (no vacío)
- Número de reserva existente al cancelar

## Extras (Opcionales)

1. **Selección interactiva visual**
2. **Diferentes tipos de sala** (cine, teatro, avión)
3. **Historial de reservas**
4. **Descuentos:** estudiantes, tercera edad
5. **Guardar/cargar estado de sala**
6. **Notificaciones por email** (simuladas)

## Tiempo Estimado

4-5 horas

¡Gestiona tu sala como un profesional! 🎬🎭✈️

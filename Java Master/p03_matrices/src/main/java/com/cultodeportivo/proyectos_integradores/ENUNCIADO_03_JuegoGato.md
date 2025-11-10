# PROYECTO 03: Juego del Gato (Tic-Tac-Toe) ❌⭕

## Dificultad: ⭐⭐

## Descripción General

Implementación completa del clásico juego del gato con modo 1 vs 1 y 1 vs IA. Incluye detección de victoria, empate y estrategias de IA básica.

## Estructura de Datos

```java
char[][] tablero = new char[3][3];

// Símbolos
final char VACIO = ' ';
final char JUGADOR_X = 'X';
final char JUGADOR_O = 'O';

// Estado del juego
boolean turnoJugador1 = true;  // true=X, false=O
boolean juegoTerminado = false;
char ganador = VACIO;

// Estadísticas
int victoriasX = 0;
int victoriasO = 0;
int empates = 0;
```

## Funcionalidades

### 1. Gestión del Tablero

- Inicializar tablero vacío
- Visualizar tablero con formato bonito
- Colocar ficha en posición válida
- Verificar si casilla está ocupada
- Limpiar tablero para nueva partida

### 2. Lógica del Juego

- **Verificar victoria horizontal** (3 en fila)
- **Verificar victoria vertical** (3 en columna)
- **Verificar victoria diagonal** (ambas diagonales)
- **Verificar empate** (tablero lleno sin ganador)
- **Cambiar turno** entre jugadores

### 3. Modos de Juego

- **1 vs 1:** Dos jugadores humanos
- **1 vs IA Fácil:** Movimientos aleatorios
- **1 vs IA Medio:** Bloquear victorias obvias
- **1 vs IA Difícil:** Algoritmo Minimax simplificado

### 4. Estadísticas

- Contador de victorias por jugador
- Contador de empates
- Historial de movimientos
- Mejor jugador de la sesión

## Algoritmos Clave

### Inicializar Tablero

```java
void inicializarTablero() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            tablero[i][j] = VACIO;
        }
    }
}
```

### Visualizar Tablero

```java
void mostrarTablero() {
    System.out.println("\n    1   2   3");
    System.out.println("  ╔═══╦═══╦═══╗");
    
    for (int i = 0; i < 3; i++) {
        System.out.print((char)('A' + i) + " ║");
        for (int j = 0; j < 3; j++) {
            System.out.print(" " + tablero[i][j] + " ");
            if (j < 2) System.out.print("║");
        }
        System.out.println("║");
        
        if (i < 2) {
            System.out.println("  ╠═══╬═══╬═══╣");
        }
    }
    System.out.println("  ╚═══╩═══╩═══╝");
}
```

### Verificar Victoria Horizontal

```java
char verificarFilas() {
    for (int i = 0; i < 3; i++) {
        if (tablero[i][0] != VACIO &&
            tablero[i][0] == tablero[i][1] &&
            tablero[i][1] == tablero[i][2]) {
            return tablero[i][0];
        }
    }
    return VACIO;
}
```

### Verificar Victoria Vertical

```java
char verificarColumnas() {
    for (int j = 0; j < 3; j++) {
        if (tablero[0][j] != VACIO &&
            tablero[0][j] == tablero[1][j] &&
            tablero[1][j] == tablero[2][j]) {
            return tablero[0][j];
        }
    }
    return VACIO;
}
```

### Verificar Victoria Diagonal

```java
char verificarDiagonales() {
    // Diagonal principal (\)
    if (tablero[0][0] != VACIO &&
        tablero[0][0] == tablero[1][1] &&
        tablero[1][1] == tablero[2][2]) {
        return tablero[0][0];
    }
    
    // Diagonal secundaria (/)
    if (tablero[0][2] != VACIO &&
        tablero[0][2] == tablero[1][1] &&
        tablero[1][1] == tablero[2][0]) {
        return tablero[0][2];
    }
    
    return VACIO;
}
```

### Verificar Ganador

```java
char verificarGanador() {
    char ganador;
    
    ganador = verificarFilas();
    if (ganador != VACIO) return ganador;
    
    ganador = verificarColumnas();
    if (ganador != VACIO) return ganador;
    
    ganador = verificarDiagonales();
    return ganador;
}
```

### Verificar Empate

```java
boolean verificarEmpate() {
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (tablero[i][j] == VACIO) {
                return false;  // Aún hay espacios
            }
        }
    }
    return verificarGanador() == VACIO;
}
```

### IA Fácil (Aleatoria)

```java
void movimientoIAFacil() {
    Random random = new Random();
    int fila, columna;
    
    do {
        fila = random.nextInt(3);
        columna = random.nextInt(3);
    } while (tablero[fila][columna] != VACIO);
    
    tablero[fila][columna] = JUGADOR_O;
}
```

### IA Medio (Defensiva)

```java
boolean movimientoIAMedio() {
    // 1. Intentar ganar
    if (intentarGanar(JUGADOR_O)) return true;
    
    // 2. Bloquear victoria del oponente
    if (intentarBloquear(JUGADOR_X)) return true;
    
    // 3. Tomar centro si está libre
    if (tablero[1][1] == VACIO) {
        tablero[1][1] = JUGADOR_O;
        return true;
    }
    
    // 4. Movimiento aleatorio
    movimientoIAFacil();
    return true;
}

boolean intentarGanar(char jugador) {
    // Verificar cada fila
    for (int i = 0; i < 3; i++) {
        if (contarEnFila(i, jugador) == 2 && 
            contarEnFila(i, VACIO) == 1) {
            completarFila(i, jugador);
            return true;
        }
    }
    
    // Similar para columnas y diagonales...
    return false;
}
```

### Validar Movimiento

```java
boolean esMovimientoValido(int fila, int columna) {
    if (fila < 0 || fila >= 3 || columna < 0 || columna >= 3) {
        return false;  // Fuera de límites
    }
    return tablero[fila][columna] == VACIO;
}
```

## Visualización del Juego

```bash
    1   2   3
  ╔═══╦═══╦═══╗
A ║ X ║   ║ O ║
  ╠═══╬═══╬═══╣
B ║   ║ X ║   ║
  ╠═══╬═══╬═══╣
C ║ O ║   ║ X ║
  ╚═══╩═══╩═══╝

Turno de: X
Ingrese posición (ej: B2): 
```

## Menú Principal

```bash
╔════════════════════════════════════════════╗
║           JUEGO DEL GATO                   ║
╠════════════════════════════════════════════╣
║  1. Jugar 1 vs 1                           ║
║  2. Jugar vs IA (Fácil)                    ║
║  3. Jugar vs IA (Medio)                    ║
║  4. Jugar vs IA (Difícil)                  ║
║  5. Ver estadísticas                       ║
║  6. Resetear estadísticas                  ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝

Estadísticas:
X: 5 victorias
O: 3 victorias
Empates: 2
```

## Validaciones

- Coordenadas dentro del rango (A-C, 1-3)
- Casilla vacía antes de colocar ficha
- No permitir movimientos después de finalizar
- Validar entrada del usuario

## Extras (Opcionales)

1. **IA Difícil:** Algoritmo Minimax
2. **Tablero 4×4 o 5×5**
3. **Modo torneo:** Mejor de 3/5/7
4. **Sugerencias:** Mostrar mejores movimientos
5. **Animaciones:** Efectos al ganar
6. **Guardar partidas:** Serialización

## Casos de Prueba

### Victoria Horizontal

```bash
X X X
O O .
. . .
```

### Victoria Diagonal

```bash
X O .
O X .
. . X
```

### Empate

```bash
X O X
X X O
O X O
```

## Tiempo Estimado

3-4 horas

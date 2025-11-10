# PROYECTO 04: Buscaminas 💣

## Dificultad: ⭐⭐⭐⭐

## Descripción General

Implementación completa del juego Buscaminas con colocación aleatoria de minas, cálculo de números vecinos, revelado recursivo y sistema de banderas.

## Estructura de Datos

```java
final int FILAS = 10;
final int COLUMNAS = 10;
final int TOTAL_MINAS = 15;

// Tablero de juego (lo que ve el usuario)
char[][] tableroVisible = new char[FILAS][COLUMNAS];

// Tablero oculto (posiciones de minas)
boolean[][] tableroMinas = new boolean[FILAS][COLUMNAS];

// Números de minas vecinas
int[][] tableroNumeros = new int[FILAS][COLUMNAS];

// Estados de casillas
boolean[][] revelado = new boolean[FILAS][COLUMNAS];
boolean[][] bandera = new boolean[FILAS][COLUMNAS];

// Símbolos
final char OCULTO = '█';
final char MINA = '*';
final char BANDERA = '⚑';
final char VACIO = ' ';

// Estado del juego
boolean juegoTerminado = false;
boolean victoria = false;
int casillasReveladas = 0;
```

## Funcionalidades

### 1. Inicialización del Juego

- Colocar minas aleatoriamente
- Calcular números vecinos para cada casilla
- Inicializar tablero visible
- Reiniciar partida

### 2. Mecánicas de Juego

- **Revelar casilla:** Descubrir contenido
- **Revelar recursivo:** Expandir áreas vacías
- **Colocar/quitar bandera:** Marcar posibles minas
- **Verificar victoria:** Todas las no-minas reveladas
- **Game Over:** Pisar mina

### 3. Cálculo de Vecinos

- Contar minas adyacentes (8 direcciones)
- Generar números 1-8
- Identificar casillas vacías (0 minas)

### 4. Dificultades

- **Fácil:** 8×8, 10 minas
- **Medio:** 10×10, 15 minas
- **Difícil:** 12×12, 25 minas
- **Experto:** 16×16, 40 minas

## Algoritmos Clave

### Colocar Minas Aleatoriamente

```java
void colocarMinas() {
    Random random = new Random();
    int minasColocadas = 0;
    
    while (minasColocadas < TOTAL_MINAS) {
        int fila = random.nextInt(FILAS);
        int columna = random.nextInt(COLUMNAS);
        
        if (!tableroMinas[fila][columna]) {
            tableroMinas[fila][columna] = true;
            minasColocadas++;
        }
    }
}
```

### Calcular Números Vecinos

```java
void calcularNumeros() {
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            if (!tableroMinas[i][j]) {
                tableroNumeros[i][j] = contarMinasVecinas(i, j);
            }
        }
    }
}

int contarMinasVecinas(int fila, int col) {
    int contador = 0;
    
    // Verificar 8 direcciones
    int[] df = {-1, -1, -1,  0, 0,  1, 1, 1};
    int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1};
    
    for (int i = 0; i < 8; i++) {
        int nuevaFila = fila + df[i];
        int nuevaCol = col + dc[i];
        
        if (esValido(nuevaFila, nuevaCol) && 
            tableroMinas[nuevaFila][nuevaCol]) {
            contador++;
        }
    }
    
    return contador;
}

boolean esValido(int fila, int col) {
    return fila >= 0 && fila < FILAS && 
           col >= 0 && col < COLUMNAS;
}
```

### Revelar Casilla (Recursivo)

```java
void revelarCasilla(int fila, int col) {
    // Validaciones
    if (!esValido(fila, col)) return;
    if (revelado[fila][col]) return;
    if (bandera[fila][col]) return;
    
    // Revelar casilla actual
    revelado[fila][col] = true;
    casillasReveladas++;
    
    // Si es mina, game over
    if (tableroMinas[fila][col]) {
        juegoTerminado = true;
        victoria = false;
        revelarTodasLasMinas();
        return;
    }
    
    // Si es vacía (0 vecinos), expandir recursivamente
    if (tableroNumeros[fila][col] == 0) {
        int[] df = {-1, -1, -1,  0, 0,  1, 1, 1};
        int[] dc = {-1,  0,  1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < 8; i++) {
            revelarCasilla(fila + df[i], col + dc[i]);
        }
    }
}
```

### Colocar/Quitar Bandera

```java
void toggleBandera(int fila, int col) {
    if (!esValido(fila, col)) return;
    if (revelado[fila][col]) return;
    
    bandera[fila][col] = !bandera[fila][col];
}
```

### Verificar Victoria

```java
boolean verificarVictoria() {
    int casillasNoMina = (FILAS * COLUMNAS) - TOTAL_MINAS;
    return casillasReveladas == casillasNoMina;
}
```

### Mostrar Tablero

```java
void mostrarTablero() {
    System.out.print("\n   ");
    for (int j = 0; j < COLUMNAS; j++) {
        System.out.printf("%2d ", j);
    }
    System.out.println("\n   " + "───".repeat(COLUMNAS));
    
    for (int i = 0; i < FILAS; i++) {
        System.out.printf("%2d│", i);
        
        for (int j = 0; j < COLUMNAS; j++) {
            char simbolo = OCULTO;
            
            if (revelado[i][j]) {
                if (tableroMinas[i][j]) {
                    simbolo = MINA;
                } else if (tableroNumeros[i][j] == 0) {
                    simbolo = VACIO;
                } else {
                    simbolo = (char)('0' + tableroNumeros[i][j]);
                }
            } else if (bandera[i][j]) {
                simbolo = BANDERA;
            }
            
            System.out.printf(" %c ", simbolo);
        }
        System.out.println("│");
    }
    System.out.println("   " + "───".repeat(COLUMNAS));
}
```

### Revelar Todas las Minas (Game Over)

```java
void revelarTodasLasMinas() {
    for (int i = 0; i < FILAS; i++) {
        for (int j = 0; j < COLUMNAS; j++) {
            if (tableroMinas[i][j]) {
                revelado[i][j] = true;
            }
        }
    }
}
```

## Visualización del Juego

```bash
    0  1  2  3  4  5  6  7  8  9
   ──────────────────────────────
 0│ █  █  █  █  █  █  █  █  █  █ │
 1│ █  1  1  1  █  █  █  2  1  1 │
 2│ █  1     1  2  3  3  2  *  1 │
 3│ █  1        1  *  *  2  1  1 │
 4│ █  1  1  1  1  2  2  1       │
 5│ █  1  1  *  1        1  1  1 │
 6│ █  1  1  1  1        1  *  1 │
 7│ █  1              1  2  2  1 │
 8│ █  1  ⚑  1  1  1  1  *  1    │
 9│ █  1  1  1  1  *  1  1  1    │
   ──────────────────────────────

Minas restantes: 13
Casillas reveladas: 52/85

Comandos:
R fila col - Revelar casilla
B fila col - Colocar/quitar bandera
```

## Menú Principal

```bash
╔════════════════════════════════════════════╗
║              BUSCAMINAS                    ║
╠════════════════════════════════════════════╣
║  1. Nueva partida - Fácil (8×8, 10)       ║
║  2. Nueva partida - Medio (10×10, 15)     ║
║  3. Nueva partida - Difícil (12×12, 25)   ║
║  4. Nueva partida - Experto (16×16, 40)   ║
║  5. Continuar partida                      ║
║  6. Ver estadísticas                       ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Validaciones

- Coordenadas dentro de límites
- No revelar casillas ya reveladas
- No colocar bandera en casilla revelada
- Verificar victoria después de cada movimiento

## Extras (Opcionales)

1. **Cronómetro:** Medir tiempo de partida
2. **Primer clic seguro:** No mina en primera casilla
3. **Modo aventura:** Niveles progresivos
4. **Pistas:** Revelar casilla segura
5. **Récords:** Mejores tiempos por dificultad
6. **Modo dual:** Competencia 2 jugadores

## Casos de Prueba

### Tablero Inicial

```bash
█ █ █ █ █
█ █ █ █ █
█ █ █ █ █
█ █ █ █ █
█ █ █ █ █
```

### Después de revelar (3,3)

```bash
█ █ █ █ █
█ 1     1 █
█ 1     1 2
█ 1     1 █
█ █ █ █ █
```

### Game Over

```bash
* 1     1 2
1 1     1 *
    1 1 2 1
1 1 1 * 1  
1 * 1 1 1  
```

## Tiempo Estimado

6-8 horas

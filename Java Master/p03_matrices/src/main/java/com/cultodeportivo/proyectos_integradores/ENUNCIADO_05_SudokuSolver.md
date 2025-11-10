# PROYECTO 05: Solucionador de Sudoku 🔢

## Dificultad: ⭐⭐⭐⭐⭐

## Descripción General

Solucionador y validador de Sudoku usando backtracking. Incluye generación de puzzles, verificación de reglas, y resolución algorítmica del famoso juego de lógica.

## Estructura de Datos

```java
final int TAMANO = 9;
final int VACIO = 0;

int[][] tablero = new int[TAMANO][TAMANO];
int[][] tableroOriginal = new int[TAMANO][TAMANO];
boolean[][] celdaModificable = new boolean[TAMANO][TAMANO];

// Estadísticas
int intentos = 0;
long tiempoResolucion = 0;
```

## Funcionalidades

### 1. Gestión del Tablero

- Inicializar tablero vacío
- Cargar puzzle predefinido
- Visualizar tablero con formato bonito
- Marcar celdas modificables/fijas
- Reiniciar tablero

### 2. Validaciones de Reglas

- **Validar fila:** No repetir números 1-9
- **Validar columna:** No repetir números 1-9
- **Validar subcuadrícula 3×3:** No repetir números
- **Validar tablero completo**
- **Verificar solución correcta**

### 3. Resolución Algorítmica

- **Backtracking:** Resolver recursivamente
- **Buscar celda vacía**
- **Probar números válidos**
- **Retroceder en caso de error**
- **Contar soluciones posibles**

### 4. Funcionalidades Extra

- Generar puzzle aleatorio
- Diferentes niveles de dificultad
- Dar pistas al usuario
- Verificar si puzzle tiene solución única
- Mostrar paso a paso la resolución

## Algoritmos Clave

### Validar Fila

```java
boolean validarFila(int[][] tablero, int fila, int numero) {
    for (int col = 0; col < TAMANO; col++) {
        if (tablero[fila][col] == numero) {
            return false;
        }
    }
    return true;
}
```

### Validar Columna

```java
boolean validarColumna(int[][] tablero, int col, int numero) {
    for (int fila = 0; fila < TAMANO; fila++) {
        if (tablero[fila][col] == numero) {
            return false;
        }
    }
    return true;
}
```

### Validar Subcuadrícula 3×3

```java
boolean validarSubcuadricula(int[][] tablero, int fila, int col, 
                             int numero) {
    int filaInicio = fila - fila % 3;
    int colInicio = col - col % 3;
    
    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            if (tablero[filaInicio + i][colInicio + j] == numero) {
                return false;
            }
        }
    }
    return true;
}
```

### Es Movimiento Válido

```java
boolean esMovimientoValido(int[][] tablero, int fila, int col, 
                          int numero) {
    return validarFila(tablero, fila, numero) &&
           validarColumna(tablero, col, numero) &&
           validarSubcuadricula(tablero, fila, col, numero);
}
```

### Buscar Celda Vacía

```java
boolean buscarCeldaVacia(int[][] tablero, int[] posicion) {
    for (int fila = 0; fila < TAMANO; fila++) {
        for (int col = 0; col < TAMANO; col++) {
            if (tablero[fila][col] == VACIO) {
                posicion[0] = fila;
                posicion[1] = col;
                return true;
            }
        }
    }
    return false;  // Tablero completo
}
```

### Resolver Sudoku (Backtracking) ⭐

```java
boolean resolverSudoku(int[][] tablero) {
    int[] posicion = new int[2];
    
    // Si no hay celdas vacías, está resuelto
    if (!buscarCeldaVacia(tablero, posicion)) {
        return true;
    }
    
    int fila = posicion[0];
    int col = posicion[1];
    
    // Probar números del 1 al 9
    for (int numero = 1; numero <= 9; numero++) {
        intentos++;
        
        if (esMovimientoValido(tablero, fila, col, numero)) {
            // Colocar número
            tablero[fila][col] = numero;
            
            // Recursión: intentar resolver el resto
            if (resolverSudoku(tablero)) {
                return true;
            }
            
            // Backtrack: deshacer si no funcionó
            tablero[fila][col] = VACIO;
        }
    }
    
    return false;  // No hay solución desde este estado
}
```

### Contar Soluciones

```java
int contarSoluciones(int[][] tablero) {
    int[] posicion = new int[2];
    
    if (!buscarCeldaVacia(tablero, posicion)) {
        return 1;  // Encontró una solución
    }
    
    int fila = posicion[0];
    int col = posicion[1];
    int contador = 0;
    
    for (int numero = 1; numero <= 9; numero++) {
        if (esMovimientoValido(tablero, fila, col, numero)) {
            tablero[fila][col] = numero;
            contador += contarSoluciones(tablero);
            tablero[fila][col] = VACIO;
        }
    }
    
    return contador;
}
```

### Validar Tablero Completo

```java
boolean validarTableroCompleto(int[][] tablero) {
    // Verificar todas las filas
    for (int i = 0; i < TAMANO; i++) {
        boolean[] vistos = new boolean[10];
        for (int j = 0; j < TAMANO; j++) {
            int num = tablero[i][j];
            if (num < 1 || num > 9 || vistos[num]) {
                return false;
            }
            vistos[num] = true;
        }
    }
    
    // Verificar todas las columnas
    for (int j = 0; j < TAMANO; j++) {
        boolean[] vistos = new boolean[10];
        for (int i = 0; i < TAMANO; i++) {
            int num = tablero[i][j];
            if (vistos[num]) return false;
            vistos[num] = true;
        }
    }
    
    // Verificar todas las subcuadrículas 3×3
    for (int bloqueFila = 0; bloqueFila < 3; bloqueFila++) {
        for (int bloqueCol = 0; bloqueCol < 3; bloqueCol++) {
            boolean[] vistos = new boolean[10];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    int num = tablero[bloqueFila*3 + i][bloqueCol*3 + j];
                    if (vistos[num]) return false;
                    vistos[num] = true;
                }
            }
        }
    }
    
    return true;
}
```

### Mostrar Tablero

```java
void mostrarTablero(int[][] tablero) {
    System.out.println("\n  ╔═══════╦═══════╦═══════╗");
    
    for (int i = 0; i < TAMANO; i++) {
        if (i == 3 || i == 6) {
            System.out.println("  ╠═══════╬═══════╬═══════╣");
        }
        
        System.out.print(i + " ║");
        
        for (int j = 0; j < TAMANO; j++) {
            if (j == 3 || j == 6) {
                System.out.print("║");
            }
            
            if (tablero[i][j] == VACIO) {
                System.out.print(" . ");
            } else {
                System.out.print(" " + tablero[i][j] + " ");
            }
        }
        
        System.out.println("║");
    }
    
    System.out.println("  ╚═══════╩═══════╩═══════╝");
    System.out.println("    0 1 2 3 4 5 6 7 8");
}
```

### Generar Puzzle (Simplificado)

```java
void generarPuzzle(int dificultad) {
    // 1. Resolver tablero vacío para obtener solución completa
    resolverSudoku(tablero);
    
    // 2. Copiar tablero resuelto
    copiarTablero(tablero, tableroOriginal);
    
    // 3. Remover números según dificultad
    //    Fácil: 35-40 números dados
    //    Medio: 28-35 números dados
    //    Difícil: 22-28 números dados
    int numerosARemover = 81 - (40 - dificultad * 6);
    
    Random random = new Random();
    while (numerosARemover > 0) {
        int fila = random.nextInt(9);
        int col = random.nextInt(9);
        
        if (tablero[fila][col] != VACIO) {
            int backup = tablero[fila][col];
            tablero[fila][col] = VACIO;
            
            // Verificar que aún tenga solución única
            if (contarSoluciones(copiarTablero(tablero)) == 1) {
                numerosARemover--;
                celdaModificable[fila][col] = true;
            } else {
                tablero[fila][col] = backup;
            }
        }
    }
}
```

## Visualización del Tablero

```bash
  ╔═══════╦═══════╦═══════╗
0 ║ 5 3 . ║ . 7 . ║ . . . ║
1 ║ 6 . . ║ 1 9 5 ║ . . . ║
2 ║ . 9 8 ║ . . . ║ . 6 . ║
  ╠═══════╬═══════╬═══════╣
3 ║ 8 . . ║ . 6 . ║ . . 3 ║
4 ║ 4 . . ║ 8 . 3 ║ . . 1 ║
5 ║ 7 . . ║ . 2 . ║ . . 6 ║
  ╠═══════╬═══════╬═══════╣
6 ║ . 6 . ║ . . . ║ 2 8 . ║
7 ║ . . . ║ 4 1 9 ║ . . 5 ║
8 ║ . . . ║ . 8 . ║ . 7 9 ║
  ╚═══════╩═══════╩═══════╝
    0 1 2 3 4 5 6 7 8

Comandos:
C fila col número - Colocar número
B fila col - Borrar número
R - Resolver automáticamente
V - Verificar si es válido
H - Pista
```

## Menú Principal

```bash
╔════════════════════════════════════════════╗
║         SOLUCIONADOR DE SUDOKU             ║
╠════════════════════════════════════════════╣
║  1. Cargar puzzle predefinido              ║
║  2. Generar puzzle aleatorio               ║
║  3. Resolver puzzle actual                 ║
║  4. Jugar manualmente                      ║
║  5. Verificar solución                     ║
║  6. Dar pista                              ║
║  7. Ver estadísticas de resolución         ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Puzzle de Ejemplo

```java
int[][] puzzleFacil = {
    {5, 3, 0, 0, 7, 0, 0, 0, 0},
    {6, 0, 0, 1, 9, 5, 0, 0, 0},
    {0, 9, 8, 0, 0, 0, 0, 6, 0},
    {8, 0, 0, 0, 6, 0, 0, 0, 3},
    {4, 0, 0, 8, 0, 3, 0, 0, 1},
    {7, 0, 0, 0, 2, 0, 0, 0, 6},
    {0, 6, 0, 0, 0, 0, 2, 8, 0},
    {0, 0, 0, 4, 1, 9, 0, 0, 5},
    {0, 0, 0, 0, 8, 0, 0, 7, 9}
};
```

## Validaciones

- Números solo entre 1-9
- No modificar celdas fijas del puzzle original
- Verificar reglas de Sudoku antes de colocar
- Detectar si puzzle no tiene solución

## Extras (Opcionales)

1. **Resolver paso a paso** con visualización
2. **Técnicas humanas:** Naked singles, hidden singles, etc.
3. **Niveles de dificultad:** Fácil, medio, difícil, diabólico
4. **Guardar/cargar partidas**
5. **Modo competitivo:** Resolver contra reloj
6. **Estadísticas:** Puzzles resueltos, tiempo promedio

## Tiempo Estimado

8-10 horas

# PROYECTO 01: Calculadora de Matrices 🧮

## Dificultad: ⭐⭐⭐

## Descripción General

Calculadora completa para operaciones matemáticas con matrices. Implementa álgebra lineal desde cero usando solo arrays bidimensionales.

## Estructura de Datos

```java
final int MAX_FILAS = 10;
final int MAX_COLUMNAS = 10;

double[][] matrizA = new double[MAX_FILAS][MAX_COLUMNAS];
double[][] matrizB = new double[MAX_FILAS][MAX_COLUMNAS];
double[][] resultado = new double[MAX_FILAS][MAX_COLUMNAS];

int filasA, columnasA;
int filasB, columnasB;
```

## Funcionalidades

### 1. Operaciones Básicas

- **Suma:** A + B (mismo tamaño)
- **Resta:** A - B (mismo tamaño)
- **Multiplicación escalar:** k × A
- **Multiplicación de matrices:** A × B (columnas A = filas B)
- **División escalar:** A ÷ k

### 2. Operaciones de Transformación

- **Transpuesta:** A^T (intercambiar filas y columnas)
- **Invertir filas**
- **Invertir columnas**
- **Rotar 90° (horario/antihorario)**
- **Rotar 180°**
- **Espejo horizontal/vertical**

### 3. Propiedades y Verificaciones

- **Es cuadrada:** filas == columnas
- **Es simétrica:** A = A^T
- **Es identidad:** diagonal = 1, resto = 0
- **Es diagonal:** solo diagonal != 0
- **Es triangular superior/inferior**
- **Es ortogonal:** A × A^T = I

### 4. Cálculos Avanzados

- **Determinante** (2×2, 3×3)
- **Traza:** suma de diagonal principal
- **Norma:** √(suma de cuadrados)
- **Rango** (simplificado)

### 5. Matrices Especiales

- **Generar matriz identidad** (I)
- **Generar matriz cero**
- **Generar matriz aleatoria**
- **Generar matriz diagonal**

## Algoritmos Clave

### Suma de Matrices

```java
double[][] sumarMatrices(double[][] a, double[][] b, 
                         int filas, int cols) {
    double[][] resultado = new double[filas][cols];
    
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < cols; j++) {
            resultado[i][j] = a[i][j] + b[i][j];
        }
    }
    
    return resultado;
}
```

### Multiplicación de Matrices

```java
double[][] multiplicarMatrices(double[][] a, double[][] b,
                               int filasA, int colsA, int colsB) {
    double[][] resultado = new double[filasA][colsB];
    
    for (int i = 0; i < filasA; i++) {
        for (int j = 0; j < colsB; j++) {
            resultado[i][j] = 0;
            for (int k = 0; k < colsA; k++) {
                resultado[i][j] += a[i][k] * b[k][j];
            }
        }
    }
    
    return resultado;
}
```

### Transpuesta

```java
double[][] transponerMatriz(double[][] matriz, int filas, int cols) {
    double[][] transpuesta = new double[cols][filas];
    
    for (int i = 0; i < filas; i++) {
        for (int j = 0; j < cols; j++) {
            transpuesta[j][i] = matriz[i][j];
        }
    }
    
    return transpuesta;
}
```

### Determinante 2×2

```java
double determinante2x2(double[][] matriz) {
    return matriz[0][0] * matriz[1][1] - 
           matriz[0][1] * matriz[1][0];
}
```

### Determinante 3×3 (Regla de Sarrus)

```java
double determinante3x3(double[][] m) {
    return m[0][0] * m[1][1] * m[2][2] +
           m[0][1] * m[1][2] * m[2][0] +
           m[0][2] * m[1][0] * m[2][1] -
           m[0][2] * m[1][1] * m[2][0] -
           m[0][1] * m[1][0] * m[2][2] -
           m[0][0] * m[1][2] * m[2][1];
}
```

### Verificar Simetría

```java
boolean esSimetrica(double[][] matriz, int n) {
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (matriz[i][j] != matriz[j][i]) {
                return false;
            }
        }
    }
    return true;
}
```

### Rotar 90° (horario)

```java
double[][] rotar90Horario(double[][] matriz, int n) {
    double[][] rotada = new double[n][n];
    
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            rotada[j][n - 1 - i] = matriz[i][j];
        }
    }
    
    return rotada;
}
```

## Formato de Visualización

```bash
Matriz A (3×3):
┌                    ┐
│  1.0   2.0   3.0  │
│  4.0   5.0   6.0  │
│  7.0   8.0   9.0  │
└                    ┘

Matriz B (3×3):
┌                    ┐
│  9.0   8.0   7.0  │
│  6.0   5.0   4.0  │
│  3.0   2.0   1.0  │
└                    ┘

A + B = 
┌                      ┐
│  10.0  10.0  10.0   │
│  10.0  10.0  10.0   │
│  10.0  10.0  10.0   │
└                      ┘

A × B =
┌                      ┐
│  30.0  24.0  18.0   │
│  84.0  69.0  54.0   │
│ 138.0 114.0  90.0   │
└                      ┘

Propiedades de A:
✓ Es cuadrada (3×3)
✗ No es simétrica
✗ No es identidad
✗ No es diagonal
Determinante: 0.0
Traza: 15.0
```

## Menú Interactivo

```bash
╔════════════════════════════════════════════╗
║      CALCULADORA DE MATRICES               ║
╠════════════════════════════════════════════╣
║  1. Ingresar matriz A                      ║
║  2. Ingresar matriz B                      ║
║  3. Mostrar matrices                       ║
║  4. Suma (A + B)                           ║
║  5. Resta (A - B)                          ║
║  6. Multiplicación (A × B)                 ║
║  7. Multiplicación escalar                 ║
║  8. Transpuesta                            ║
║  9. Determinante                           ║
║ 10. Rotar matriz                           ║
║ 11. Verificar propiedades                  ║
║ 12. Generar matriz especial                ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Validaciones

- Verificar tamaños compatibles para operaciones
- No división por cero en escalar
- Determinante solo para matrices cuadradas
- Multiplicación: columnas A = filas B

## Extras (Opcionales)

1. **Potencia de matriz:** A^n
2. **Matriz inversa:** A^(-1) para 2×2
3. **Sistemas de ecuaciones:** Ax = b
4. **Factorización LU**
5. **Valores y vectores propios** (simplificado)
6. **Exportar/Importar matrices**

## Casos de Prueba

Matriz A (3×3):

```bash
1  2  3
4  5  6
7  8  9
```

Matriz B (3×3):

```bash
9  8  7
6  5  4
3  2  1
```

Identidad (3×3):

```bash
1  0  0
0  1  0
0  0  1
```

## Tiempo Estimado

5-7 horas

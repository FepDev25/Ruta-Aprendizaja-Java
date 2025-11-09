# P03 - Matrices en Java

## Descripción General

Este módulo profundiza en el estudio de matrices (arreglos bidimensionales) en Java, cubriendo desde conceptos básicos hasta operaciones matriciales avanzadas. Los ejemplos incluyen manipulación, transformaciones, algoritmos de búsqueda y análisis de propiedades matemáticas de matrices.

## Información del Proyecto

- **Artifact ID:** p03_matrices
- **Group ID:** com.cultodeportivo
- **Versión:** 1.0-SNAPSHOT
- **Java Version:** 17
- **Build Tool:** Maven

## Contenido del Módulo

### 1. Fundamentos de Matrices

#### Operaciones Básicas

- `EjemploMatrices.java` - Declaración, inicialización y acceso a elementos de matrices
- `EjemploMatricesStringFor.java` - Iteración sobre matrices de cadenas con bucles for
- `EjemploMatricesStringFor2.java` - Variante de iteración sobre matrices de strings

### 2. Operaciones Matriciales

#### Suma de Matrices

- `EjemploMatricesSumar.java` - Suma de dos matrices elemento por elemento
  - Operación: C\[i][j] = A\[i][j] + B\[i][j]
  - Requisito: Las matrices deben tener las mismas dimensiones

#### Suma de Filas y Columnas

- `EjemploMatricesSumarFilasColumnas.java` - Cálculo de sumas por filas y columnas
  - Suma total de cada fila
  - Suma total de cada columna
  - Aplicación: Tablas de datos, hojas de cálculo

### 3. Transformaciones de Matrices

#### Transposición

- `EjemploMatricesTranspuesta.java` - Visualización de matriz transpuesta (sin crear nueva matriz)
- `EjemploMatricesTransponerMatriz.java` - Creación de matriz transpuesta
  - Operación: B\[j][i] = A\[i][j]
  - Intercambio de filas por columnas

### 4. Algoritmos de Búsqueda

#### Búsqueda en Matrices

- `EjemploMatricesBuscar.java` - Búsqueda de valores en matrices bidimensionales
  - Recorrido secuencial
  - Retorno de posición (fila, columna)
  - Indicador de elemento encontrado/no encontrado

### 5. Matrices Especiales

#### Matriz Identidad

- `EjemploMatricesIdentidad.java` - Generación de matriz identidad
  - Diagonal principal con 1s
  - Resto de elementos con 0s
  - Propiedad: A × I = A

#### Matriz Simétrica

- `EjemploMatricesSimetrica.java` - Verificación de simetría
  - Propiedad: A\[i][j] = A\[j][i] para todo i, j
  - Comparación con la transpuesta

### 6. Estructuras Variables

#### Matrices Irregulares (Jagged Arrays)

- `EjemploMatricesColumnasVariable.java` - Matrices con diferente número de columnas por fila
  - Flexibilidad en la estructura
  - Ahorro de memoria para datos dispersos

### 7. Patrones Visuales

#### Generación de Marcos

- `EjemploMatricesMarco.java` - Creación de matriz con patrón de marco
  - Bordes con un valor
  - Interior con otro valor
  - Aplicación: Interfaces de usuario, diseño visual

## Conceptos Clave Aprendidos

### 1. Estructura Bidimensional

Las matrices son arreglos de arreglos, representando datos en formato de tabla con filas y columnas.

**Declaración:**

```java
int[][] matriz = new int[filas][columnas];
```

**Acceso:**

```java
elemento = matriz[fila][columna];
```

### 2. Representación en Memoria

En Java, las matrices bidimensionales son realmente arreglos de referencias a arreglos:

- Cada fila es un objeto arreglo independiente
- Permite matrices irregulares (filas con diferente longitud)
- Almacenamiento no necesariamente contiguo

### 3. Patrones de Iteración

#### Recorrido Completo

**Por filas (row-major order):**

```java
for (int i = 0; i < matriz.length; i++) {
    for (int j = 0; j < matriz[i].length; j++) {
        // procesar matriz[i][j]
    }
}
```

**For-each anidado:**

```java
for (int[] fila : matriz) {
    for (int elemento : fila) {
        // procesar elemento
    }
}
```

#### Recorrido de Diagonal

```java
for (int i = 0; i < n; i++) {
    // diagonal principal: matriz[i][i]
}
```

### 4. Operaciones Matriciales

#### OPeración Transposición

La transposición intercambia filas por columnas:

- Matriz original: m × n
- Matriz transpuesta: n × m
- Elemento (i,j) se convierte en (j,i)

#### OPeración Suma de Matrices

Solo se pueden sumar matrices de las mismas dimensiones:

- Operación elemento por elemento
- C\[i][j] = A\[i][j] + B\[i][j]

#### Simetría

Una matriz es simétrica si es igual a su transpuesta:

- A\[i][j] = A\[j][i]
- Solo aplicable a matrices cuadradas

### 5. Concepto Matrices Especiales

#### Especial Matriz Identidad

Matriz cuadrada con:

- 1s en la diagonal principal
- 0s en el resto
- Elemento neutro de la multiplicación matricial

#### Matriz Irregular

Matriz donde las filas pueden tener diferente longitud:

```java
int[][] irregular = new int[3][];
irregular[0] = new int[2];
irregular[1] = new int[4];
irregular[2] = new int[3];
```

## Complejidad Algorítmica

### Complejidad Algorítmica Operaciones Básicas

- **Acceso a elemento:** O(1) - tiempo constante
- **Recorrido completo:** O(m × n) - donde m = filas, n = columnas
- **Búsqueda lineal:** O(m × n) - peor caso
- **Transposición:** O(m × n) - requiere recorrer todos los elementos
- **Suma de matrices:** O(m × n) - operación elemento por elemento

### Optimizaciones

Para matrices grandes:

- Considerar acceso por filas (aprovecha localidad de caché)
- Usar algoritmos específicos para matrices dispersas
- Evaluar uso de bibliotecas especializadas para álgebra lineal

## Aplicaciones Prácticas

### 1. Procesamiento de Imágenes

Las imágenes digitales se representan como matrices:

- Píxeles organizados en filas y columnas
- Cada elemento contiene información de color
- Operaciones: filtros, rotación, escalado

### 2. Sistemas de Ecuaciones

Representación matricial de sistemas lineales:

- Matriz de coeficientes
- Operaciones: eliminación gaussiana, inversión

### 3. Juegos de Mesa

Tableros representados como matrices:

- Ajedrez: 8×8
- Sudoku: 9×9
- Detección de patrones y validaciones

### 4. Análisis de Datos

Tablas de datos estructurados:

- Hojas de cálculo
- Bases de datos relacionales en memoria
- Operaciones estadísticas

## Ejecución de Ejemplos

Para ejecutar cualquier ejemplo de este módulo:

```bash
cd p03_matrices
mvn clean compile
mvn exec:java -Dexec.mainClass="com.cultodeportivo.<NombreClase>"
```

Por ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.cultodeportivo.EjemploMatricesTransponerMatriz"
```

## Estructura del Proyecto

```bash
p03_matrices/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── cultodeportivo/
│   │               ├── EjemploMatrices.java
│   │               ├── EjemploMatricesSumar.java
│   │               ├── EjemploMatricesTransponerMatriz.java
│   │               ├── EjemploMatricesIdentidad.java
│   │               ├── EjemploMatricesSimetrica.java
│   │               ├── EjemploMatricesBuscar.java
│   │               └── ... (más ejemplos)
│   └── test/
└── target/
```

## Diferencias con Arreglos Unidimensionales

| Característica | Arreglo 1D | Matriz 2D |
|----------------|------------|-----------|
| Dimensiones | Una | Dos |
| Acceso | array[i] | matriz\[i]\[j]* |
| Iteración | Un bucle | Bucles anidados |
| Tamaño | length | length (filas), [i].length (columnas) |
| Complejidad espacio | O(n) | O(m × n) |
| Aplicaciones | Listas, secuencias | Tablas, grillas, grafos |

## Mejores Prácticas

### 1. Validación de Dimensiones

Siempre verificar que las dimensiones sean compatibles para operaciones:

```java
if (matrizA.length != matrizB.length || 
    matrizA[0].length != matrizB[0].length) {
    throw new IllegalArgumentException("Dimensiones incompatibles");
}
```

### 2. Uso de Constantes

Definir dimensiones como constantes para mayor claridad:

```java
final int FILAS = 3;
final int COLUMNAS = 4;
int[][] matriz = new int[FILAS][COLUMNAS];
```

### 3. Métodos Auxiliares

Encapsular operaciones comunes en métodos reutilizables:

```java
public static void imprimirMatriz(int[][] matriz) {
    for (int[] fila : matriz) {
        System.out.println(Arrays.toString(fila));
    }
}
```

### 4. Consideraciones de Memoria

Las matrices pueden consumir mucha memoria:

- Una matriz 1000×1000 de enteros: ~4MB
- Considerar alternativas para matrices dispersas
- Liberar referencias cuando no se necesiten

## Limitaciones y Alternativas

### Limitaciones de Arrays Nativos

1. **Tamaño fijo:** No se puede redimensionar
2. **Sin operaciones integradas:** Requiere implementación manual de operaciones
3. **Performance:** Sin optimizaciones para operaciones matriciales

### Bibliotecas Alternativas

Para operaciones matemáticas avanzadas:

- **Apache Commons Math** - Álgebra lineal, estadística
- **EJML (Efficient Java Matrix Library)** - Operaciones matriciales optimizadas
- **ND4J** - Computación numérica para deep learning
- **JAMA** - Álgebra lineal fundamental

## Matrices Tridimensionales y Multidimensionales

Java soporta arreglos de cualquier dimensión:

```java
int[][][] cubo = new int[alto][ancho][profundidad];
int elemento = cubo[x][y][z];
```

**Aplicaciones:**

- Representación de volúmenes 3D
- Animaciones (frames × filas × columnas)
- Cubos OLAP en análisis de datos

## Notas Técnicas

- Las matrices en Java son objetos en el heap
- Cada fila es un objeto separado
- Se inicializan con valores por defecto (0 para números, null para objetos)
- `matriz.length` da el número de filas
- `matriz[i].length` da el número de columnas en la fila i
- Soportan matrices irregulares de forma nativa

## Referencias

- [Java 2D Arrays Tutorial - Oracle](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Arrays API Documentation](https://docs.oracle.com/en/java/javase/17/docs/api/java.base/java/util/Arrays.html)
- [Linear Algebra - Wikipedia](https://en.wikipedia.org/wiki/Linear_algebra)
- [Matrix Operations](https://en.wikipedia.org/wiki/Matrix_(mathematics))

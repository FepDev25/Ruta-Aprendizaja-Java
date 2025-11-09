# P02 - Arreglos en Java

## Descripción General

Este módulo se enfoca en el estudio completo de arreglos (arrays) en Java, cubriendo desde operaciones básicas hasta algoritmos avanzados de manipulación, búsqueda y ordenamiento. Los ejemplos proporcionan una comprensión profunda de las estructuras de datos lineales en Java.

## Información del Proyecto

- **Artifact ID:** p02_arreglos
- **Group ID:** com.cultodeportivo
- **Versión:** 1.0-SNAPSHOT
- **Java Version:** 21
- **Build Tool:** Maven

## Contenido del Módulo

### 1. Fundamentos de Arreglos

#### Operaciones Básicas

- `EjemploArreglos.java` - Declaración, inicialización y acceso a elementos
- `EjemploArreglosFor.java` - Iteración básica con bucle for
- `EjemploArreglosForInverso.java` - Recorrido inverso de arreglos
- `EjemploArreglosForInversoMutable.java` - Inversión del orden de elementos modificando el arreglo original
- `EjemploArreglosForOrdenamiento.java` - Implementación de algoritmos de ordenamiento

### 2. Algoritmos de Ordenamiento

#### Algoritmo Burbuja (Bubble Sort)

- `EjemploArreglosForOrdenamientoBurbuja.java` - Implementación del algoritmo de ordenamiento burbuja
  - Complejidad temporal: O(n²)
  - Algoritmo de comparación e intercambio de elementos adyacentes

### 3. Algoritmos de Búsqueda

#### Búsqueda Lineal

- `EjemploArreglosBuscarNumero.java` - Búsqueda de números en arreglos de enteros
- `EjemploArreglosBuscarString.java` - Búsqueda de cadenas de texto en arreglos

### 4. Manipulación de Arreglos

#### Detección de Patrones

- `EjemploArreglosDetectarOrden.java` - Determinar si un arreglo está ordenado (ascendente, descendente o desordenado)

#### Operaciones de Inserción y Eliminación

- `EjemploArreglosDesplazarPosicion.java` - Desplazamiento de elementos para insertar en una posición específica
- `EjemploArreglosDesplazarPosicion2.java` - Variante del desplazamiento con validaciones
- `EjemploArreglosDesplazarPosicion2b.java` - Implementación alternativa del desplazamiento
- `EjemploArreglosDesplazarPosicion3.java` - Desplazamiento con entrada de usuario
- `EjemploArreglosDesplazarPosicion3b.java` - Versión mejorada con manejo de errores
- `EjemplosArreglosEliminarElemento.java` - Eliminación de elementos con reorganización del arreglo

### 5. Reorganización de Elementos

#### Ordenamiento Personalizado

- `EjemploArreglosOrdenPrincipioFinal.java` - Ordenamiento alternando elementos del inicio y final
  - Distribución de elementos en posiciones alternas

### 6. Separación y Clasificación

#### Clasificación por Criterios

- `EjemploArreglosParesImpares.java` - Separación de números pares e impares en arreglos distintos
  - Clasificación de elementos según condiciones lógicas

### 7. Combinación de Arreglos

#### Operaciones de Merge

- `EjemploArreglosCombinados.java` - Combinación de múltiples arreglos en uno solo
  - Fusión de estructuras de datos

### 8. Estadísticas y Análisis

#### Cálculos sobre Arreglos

- `EjemploArreglosNumMayor.java` - Determinación del elemento máximo en un arreglo
- `EjemploArregloNotasAlumnos.java` - Sistema de gestión de calificaciones
  - Cálculo de promedios
  - Identificación de notas superiores e inferiores al promedio
  - Aplicación práctica de arreglos en contexto educativo

## Conceptos Clave Aprendidos

### 1. Estructura de Datos Lineal

Los arreglos son estructuras de datos de tamaño fijo que almacenan elementos del mismo tipo en posiciones contiguas de memoria.

**Características:**

- Tamaño fijo definido en tiempo de creación
- Acceso directo a elementos mediante índice
- Índices basados en cero (0 a n-1)

### 2. Complejidad Algorítmica

**Operaciones básicas:**

- Acceso: O(1) - tiempo constante
- Búsqueda lineal: O(n) - tiempo lineal
- Inserción/Eliminación: O(n) - requiere desplazamiento de elementos
- Ordenamiento burbuja: O(n²) - tiempo cuadrático

### 3. Patrones de Iteración

**Recorrido hacia adelante:**

```java
for (int i = 0; i < array.length; i++) {
    // procesamiento
}
```

**Recorrido inverso:**

```java
for (int i = array.length - 1; i >= 0; i--) {
    // procesamiento
}
```

**For-each (lectura):**

```java
for (TipoDato elemento : array) {
    // procesamiento
}
```

### 4. Inmutabilidad de Tamaño

Una vez creado un arreglo, su tamaño no puede modificarse. Para "agregar" o "eliminar" elementos:

- Se debe crear un nuevo arreglo con el tamaño deseado
- Copiar los elementos existentes
- Agregar/omitir el elemento correspondiente

### 5. Utilidad de Arrays

La clase `java.util.Arrays` proporciona métodos estáticos útiles:

- `Arrays.sort()` - Ordenamiento optimizado
- `Arrays.toString()` - Representación en cadena
- `Arrays.copyOf()` - Copia de arreglos
- `Arrays.fill()` - Llenado con un valor

## Algoritmos Implementados

### 1. Ordenamiento Burbuja (Bubble Sort)

**Algoritmo:**

1. Comparar pares de elementos adyacentes
2. Intercambiar si están en orden incorrecto
3. Repetir hasta que no haya intercambios

**Características:**

- Simple de implementar
- Ineficiente para grandes conjuntos de datos
- Complejidad: O(n²)

### 2. Búsqueda Lineal

**Algoritmo:**

1. Recorrer el arreglo secuencialmente
2. Comparar cada elemento con el valor buscado
3. Retornar índice o indicador de no encontrado

**Características:**

- No requiere arreglo ordenado
- Complejidad: O(n)

### 3. Desplazamiento de Elementos

**Algoritmo para inserción:**

1. Desplazar elementos hacia la derecha desde la posición de inserción
2. Insertar el nuevo elemento en la posición liberada

**Algoritmo para eliminación:**

1. Desplazar elementos hacia la izquierda desde la posición eliminada
2. Reducir el contador de elementos activos

## Casos de Uso Prácticos

### 1. Sistema de Calificaciones

`EjemploArregloNotasAlumnos.java` demuestra:

- Almacenamiento de datos homogéneos
- Cálculos estadísticos (promedio)
- Análisis comparativo de datos

### 2. Gestión de Inventario

`EjemploArreglos.java` (con productos) muestra:

- Almacenamiento de información de productos
- Ordenamiento alfabético
- Acceso indexado a elementos

## Ejecución de Ejemplos

Para ejecutar cualquier ejemplo de este módulo:

```bash
cd p02_arreglos
mvn clean compile
mvn exec:java -Dexec.mainClass="com.cultodeportivo.<NombreClase>"
```

Por ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.cultodeportivo.EjemploArreglosForOrdenamientoBurbuja"
```

## Estructura del Proyecto

```bash
p02_arreglos/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── cultodeportivo/
│   │               ├── EjemploArreglos.java
│   │               ├── EjemploArreglosFor.java
│   │               ├── EjemploArreglosForOrdenamientoBurbuja.java
│   │               ├── EjemploArreglosBuscarNumero.java
│   │               ├── EjemploArreglosParesImpares.java
│   │               ├── EjemploArregloNotasAlumnos.java
│   │               └── ... (más ejemplos)
│   └── test/
└── target/
```

## Limitaciones de los Arreglos

1. **Tamaño Fijo:** No se puede redimensionar dinámicamente
2. **Tipo Homogéneo:** Todos los elementos deben ser del mismo tipo
3. **Ineficiencia en Inserciones/Eliminaciones:** Requiere desplazamiento de elementos

## Alternativas Modernas

Para aplicaciones que requieren estructuras dinámicas, considere:

- `ArrayList<T>` - Arreglo dinámico
- `LinkedList<T>` - Lista enlazada
- `Vector<T>` - Arreglo sincronizado (legacy)

## Mejores Prácticas

1. **Validación de Índices:** Siempre verificar que el índice esté dentro del rango válido (0 a length-1)

2. **Uso de Enhanced For:** Preferir for-each cuando no se necesita el índice

3. **Utilidad Arrays:** Aprovechar métodos de `java.util.Arrays` para operaciones comunes

4. **Inmutabilidad:** Considerar arreglos como inmutables cuando sea posible para mayor seguridad

5. **Documentación:** Documentar el propósito de cada posición del arreglo si tiene significado específico

## Notas Técnicas

- Los arreglos en Java son objetos y se almacenan en el heap
- Se inicializan automáticamente con valores por defecto (0 para números, null para objetos, false para boolean)
- La propiedad `length` es final y representa el tamaño total del arreglo
- Los arreglos son covariantes (si B extiende A, entonces B[] es subtipo de A[])

## Referencias

- [Java Arrays Documentation](https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html)
- [Arrays Tutorial - Oracle](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html)
- [Algorithm Complexity](https://en.wikipedia.org/wiki/Time_complexity)

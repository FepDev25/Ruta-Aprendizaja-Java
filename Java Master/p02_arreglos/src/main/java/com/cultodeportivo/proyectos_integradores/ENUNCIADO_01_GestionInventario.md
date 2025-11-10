# PROYECTO 01: Sistema de Gestión de Inventario 📦

## Dificultad: ⭐⭐⭐

## Descripción General

Desarrolla un sistema completo de gestión de inventario para una tienda que maneje productos usando arrays paralelos. Aprenderás a manejar múltiples arrays coordinados y algoritmos de búsqueda y ordenamiento.

## Objetivos de Aprendizaje

- Arrays paralelos (múltiples arrays relacionados)
- Búsqueda secuencial y binaria
- Algoritmos de ordenamiento (burbuja, selección)
- Inserción y eliminación de elementos
- Desplazamiento de posiciones en arrays
- Cálculos y estadísticas con arrays

## Funcionalidades Requeridas

### Menú Principal

```bash
╔════════════════════════════════════════════╗
║   SISTEMA DE GESTIÓN DE INVENTARIO 📦      ║
╠════════════════════════════════════════════╣
║  1. Registrar nuevo producto               ║
║  2. Buscar producto                        ║
║  3. Actualizar stock                       ║
║  4. Eliminar producto                      ║
║  5. Listar todos los productos             ║
║  6. Ordenar productos                      ║
║  7. Productos con stock bajo               ║
║  8. Estadísticas del inventario            ║
║  9. Reporte de valor total                 ║
║ 10. Buscar productos por rango de precio   ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Estructura de Datos (Arrays Paralelos)

```java
final int MAX_PRODUCTOS = 100;

// Arrays paralelos - cada índice representa el mismo producto
String[] codigos = new String[MAX_PRODUCTOS];      // P001, P002, etc.
String[] nombres = new String[MAX_PRODUCTOS];       // Nombre del producto
String[] categorias = new String[MAX_PRODUCTOS];   // Electrónica, Ropa, etc.
double[] precios = new double[MAX_PRODUCTOS];       // Precio unitario
int[] stock = new int[MAX_PRODUCTOS];               // Cantidad en almacén
int[] stockMinimo = new int[MAX_PRODUCTOS];         // Stock mínimo requerido

int totalProductos = 0; // Contador de productos registrados
```

## Módulos Detallados

### 1. Registrar Nuevo Producto

**Funcionalidad:**

- Verificar que hay espacio disponible (totalProductos < MAX_PRODUCTOS)
- Generar código automático (P001, P002, ...)
- Solicitar: nombre, categoría, precio, stock inicial, stock mínimo
- Validar que el código no exista (aunque se genera automático)
- Insertar en la siguiente posición disponible
- Incrementar totalProductos

**Validaciones:**

- Precio > 0
- Stock >= 0
- Stock mínimo > 0
- Nombre no vacío
- Categoría válida (predefinida)

**Ejemplo de salida:**

```bash
╔════════════════════════════════════════════╗
║      PRODUCTO REGISTRADO EXITOSAMENTE      ║
╠════════════════════════════════════════════╣
║ Código:      P015                          ║
║ Nombre:      Laptop Dell XPS 13            ║
║ Categoría:   Electrónica                   ║
║ Precio:      $1,299.99                     ║
║ Stock:       25 unidades                   ║
║ Stock Min:   5 unidades                    ║
╚════════════════════════════════════════════╝
```

### 2. Buscar Producto

**Métodos de búsqueda:**

**A) Por código:**

- Búsqueda secuencial en array de códigos
- Retornar índice si existe, -1 si no existe

**B) Por nombre:**

- Búsqueda parcial (contains)
- Mostrar todos los productos que coincidan
- Case insensitive

**C) Por categoría:**

- Listar todos los productos de una categoría
- Contar cuántos hay

Mostrar información completa del producto encontrado

### 3. Actualizar Stock

**Opciones:**

- **Entrada de mercancía:** sumar al stock
- **Venta:** restar del stock
- **Ajuste manual:** establecer nuevo valor

**Validaciones:**

- Producto debe existir
- No puede quedar stock negativo
- Alertar si stock queda por debajo del mínimo

**Registro de movimiento:**

```bash
Producto: Laptop Dell XPS 13
Stock anterior: 25
Movimiento: -3 (Venta)
Stock nuevo: 22
Estado: ⚠️ OK
```

### 4. Eliminar Producto

**Proceso:**

1. Buscar producto por código
2. Mostrar información completa
3. Solicitar confirmación
4. Desplazar todos los elementos posteriores una posición atrás
5. Decrementar totalProductos
6. Limpiar última posición

**Algoritmo de eliminación:**

```java
// Desplazar elementos
for (int i = indiceEliminar; i < totalProductos - 1; i++) {
    codigos[i] = codigos[i + 1];
    nombres[i] = nombres[i + 1];
    // ... resto de arrays
}
totalProductos--;
```

### 5. Listar Todos los Productos

**Formato tabular:**

```bash
╔════════════════════════════════════════════════════════════════════╗
║                      INVENTARIO COMPLETO                           ║
╠════╦══════════════════════╦═══════════════╦══════════╦═══════╦════╣
║ #  ║ Código │ Nombre      ║ Categoría     ║ Precio   ║ Stock ║ Min║
╠════╬══════════════════════╬═══════════════╬══════════╬═══════╬════╣
║ 1  ║ P001   │ Laptop HP   ║ Electrónica   ║ $899.99  ║  15   ║ 5  ║
║ 2  ║ P002   │ Mouse       ║ Accesorios    ║ $25.50   ║  50   ║ 10 ║
║ 3  ║ P003   │ Teclado     ║ Accesorios    ║ $45.00   ║  30   ║ 8  ║
╚════╩══════════════════════╩═══════════════╩══════════╩═══════╩════╝
Total de productos: 3
```

### 6. Ordenar Productos

**Opciones de ordenamiento:**

- Por código (ascendente/descendente)
- Por nombre (alfabético A-Z / Z-A)
- Por precio (menor a mayor / mayor a menor)
- Por stock (menor a mayor / mayor a menor)
- Por categoría

**Implementar:**

- **Método burbuja** para uno
- **Método selección** para otro
- Mantener sincronizados todos los arrays paralelos

**Algoritmo burbuja para ordenar por precio:**

```java
for (int i = 0; i < totalProductos - 1; i++) {
    for (int j = 0; j < totalProductos - 1 - i; j++) {
        if (precios[j] > precios[j + 1]) {
            // Intercambiar en TODOS los arrays
            intercambiar(j, j + 1);
        }
    }
}
```

### 7. Productos con Stock Bajo

**Funcionalidad:**

- Recorrer todos los productos
- Identificar aquellos donde: `stock < stockMinimo`
- Listar en formato de alerta
- Calcular cantidad a pedir para llegar al doble del mínimo
- Ordenar por urgencia (menor diferencia primero)

**Ejemplo:**

```bash
╔════════════════════════════════════════════╗
║       ⚠️  ALERTAS DE STOCK BAJO ⚠️          ║
╠════════════════════════════════════════════╣
║ CRÍTICO:                                   ║
║ P005 - Monitor Samsung                     ║
║   Stock actual: 2  │  Mínimo: 10          ║
║   Pedir: 18 unidades                       ║
║                                            ║
║ BAJO:                                      ║
║ P012 - Mouse Inalámbrico                   ║
║   Stock actual: 8  │  Mínimo: 10          ║
║   Pedir: 12 unidades                       ║
╚════════════════════════════════════════════╝
Total de productos con stock bajo: 2
```

### 8. Estadísticas del Inventario

Calcular y mostrar:

- **Total de productos** registrados
- **Productos por categoría** (conteo)
- **Precio promedio** de todos los productos
- **Producto más caro** y más barato
- **Stock total** en almacén
- **Producto con mayor stock** y menor stock
- **Porcentaje de productos** con stock bajo

**Distribución por categoría:**

```bash
Productos por categoría:
Electrónica:  ████████████ (15 productos - 45%)
Accesorios:   ████████ (10 productos - 30%)
Ropa:         ████ (5 productos - 15%)
Otros:        ███ (3 productos - 10%)
```

### 9. Reporte de Valor Total

**Calcular:**

- **Valor individual:** precio × stock
- **Valor total del inventario:** suma de todos
- **Valor por categoría**
- **Top 10 productos más valiosos**

**Formato:**

```bash
╔════════════════════════════════════════════╗
║      REPORTE DE VALOR DEL INVENTARIO       ║
╠════════════════════════════════════════════╣
║ Por Categoría:                             ║
║   Electrónica:    $45,890.50               ║
║   Accesorios:     $12,340.00               ║
║   Ropa:           $8,750.25                ║
║   Otros:          $2,100.00                ║
║                                            ║
║ VALOR TOTAL:      $69,080.75               ║
╠════════════════════════════════════════════╣
║ Top 3 Productos Más Valiosos:             ║
║ 1. Laptop Dell XPS    $32,499.75           ║
║    (25 × $1,299.99)                        ║
║ 2. Monitor 4K         $8,999.50            ║
║    (10 × $899.95)                          ║
║ 3. Impresora HP       $6,750.00            ║
║    (15 × $450.00)                          ║
╚════════════════════════════════════════════╝
```

### 10. Buscar por Rango de Precio

**Funcionalidad:**

- Solicitar precio mínimo y máximo
- Buscar todos los productos en ese rango
- Ordenar resultados por precio
- Mostrar cantidad encontrada

**Ejemplo:**

```bash
Ingrese precio mínimo: $100
Ingrese precio máximo: $500

Productos encontrados en rango $100 - $500:

1. Mouse Gaming - $125.99 (Stock: 20)
2. Teclado Mecánico - $189.50 (Stock: 15)
3. Webcam HD - $299.99 (Stock: 8)
4. Audífonos Bluetooth - $450.00 (Stock: 12)

Total encontrados: 4 productos
```

## Algoritmos Importantes

### 1. Búsqueda Secuencial

```java
int buscarPorCodigo(String codigo) {
    for (int i = 0; i < totalProductos; i++) {
        if (codigos[i].equals(codigo)) {
            return i;
        }
    }
    return -1;
}
```

### 2. Ordenamiento Burbuja (sincronizando arrays)

```java
void ordenarPorPrecio() {
    for (int i = 0; i < totalProductos - 1; i++) {
        for (int j = 0; j < totalProductos - 1 - i; j++) {
            if (precios[j] > precios[j + 1]) {
                intercambiarPosiciones(j, j + 1);
            }
        }
    }
}

void intercambiarPosiciones(int i, int j) {
    // Intercambiar en TODOS los arrays paralelos
    String tempCod = codigos[i];
    codigos[i] = codigos[j];
    codigos[j] = tempCod;
    
    String tempNom = nombres[i];
    nombres[i] = nombres[j];
    nombres[j] = tempNom;
    
    // ... continuar con el resto
}
```

### 3. Inserción Ordenada

```java
void insertarOrdenado(producto nuevo) {
    // Encontrar posición
    int pos = 0;
    while (pos < totalProductos && 
           nombres[pos].compareTo(nuevo.nombre) < 0) {
        pos++;
    }
    
    // Desplazar elementos
    for (int i = totalProductos; i > pos; i--) {
        copiarPosicion(i - 1, i);
    }
    
    // Insertar en posición
    insertarEnPosicion(nuevo, pos);
    totalProductos++;
}
```

## Conceptos a Aplicar

### 1. Arrays

- Declaración e inicialización
- Arrays paralelos coordinados
- Recorrido con for clásico
- Longitud fija (MAX_PRODUCTOS)

### 2. Algoritmos de Búsqueda

- Búsqueda secuencial
- Búsqueda por criterios múltiples
- Búsqueda en rangos

### 3. Algoritmos de Ordenamiento

- Burbuja (Bubble Sort)
- Selección (Selection Sort)
- Mantener sincronización entre arrays

### 4. Manipulación de Arrays

- Inserción
- Eliminación con desplazamiento
- Intercambio de elementos
- Copia de elementos

### 5. Cálculos Estadísticos

- Sumas y promedios
- Búsqueda de máximos y mínimos
- Conteos y porcentajes
- Agrupación por categorías

## Extras (Opcionales - Desafío)

1. **Historial de movimientos:** Array para últimos 50 movimientos
2. **Búsqueda binaria:** Después de ordenar
3. **Ordenamiento por selección:** Implementar alternativo
4. **Backup de datos:** Copiar arrays a arrays de respaldo
5. **Restaurar datos:** Desde backup
6. **Productos más vendidos:** Tracking de ventas
7. **Alertas automáticas:** Al iniciar, mostrar productos críticos

## Casos de Prueba

Registra estos productos de prueba:

1. Laptop HP - Electrónica - $899.99 - Stock: 15 - Min: 5
2. Mouse Logitech - Accesorios - $25.50 - Stock: 50 - Min: 10
3. Teclado Mecánico - Accesorios - $189.50 - Stock: 3 - Min: 8
4. Monitor Samsung - Electrónica - $299.99 - Stock: 20 - Min: 7
5. Cable HDMI - Accesorios - $12.99 - Stock: 2 - Min: 15

Prueba:

- Eliminar producto del medio
- Ordenar por diferentes criterios
- Buscar productos con stock bajo
- Actualizar stock con ventas

## Criterios de Evaluación

- **Arrays paralelos sincronizados**
- **Búsqueda funciona correctamente**
- **Ordenamiento mantiene integridad**
- **Eliminación desplaza correctamente**
- **Estadísticas precisas**
- **Código bien estructurado**

## Tiempo Estimado

6-8 horas de desarrollo

## Consejos

1. Crea un método para intercambiar posiciones que maneje todos los arrays
2. Siempre sincroniza operaciones en todos los arrays paralelos
3. Valida índices antes de acceder a arrays
4. Usa constantes para tamaños de arrays
5. Crea métodos auxiliares para operaciones repetitivas
6. Prueba con pocos productos primero
7. Implementa un método para mostrar un producto por índice

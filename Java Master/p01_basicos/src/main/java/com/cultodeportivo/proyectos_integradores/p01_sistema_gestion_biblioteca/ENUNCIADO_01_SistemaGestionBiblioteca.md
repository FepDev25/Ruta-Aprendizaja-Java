# PROYECTO 01: Sistema de Gestión de Biblioteca 📚

## Dificultad: ⭐⭐⭐

## Descripción General

Desarrolla un sistema de gestión para una pequeña biblioteca que permita administrar libros y realizar operaciones básicas de consulta e información.

## Objetivos de Aprendizaje

- Manipulación avanzada de Strings
- Uso de arrays para almacenar información
- Implementación de bucles complejos
- Condicionales múltiples
- Entrada y salida de datos formateada
- Manejo de fechas básicas

## Funcionalidades Requeridas

### 1. Menú Principal

Crea un menú interactivo que se repita hasta que el usuario decida salir:

```bash
=== SISTEMA DE GESTIÓN DE BIBLIOTECA ===
1. Registrar nuevo libro
2. Buscar libro por título
3. Buscar libro por autor
4. Listar todos los libros
5. Mostrar estadísticas
6. Verificar disponibilidad
7. Salir
Seleccione una opción: 
```

### 2. Registro de Libros

- Solicitar: Título, Autor, ISBN, Año de publicación, Número de páginas, Categoría
- Validar que el ISBN tenga exactamente 13 dígitos
- Validar que el año sea entre 1500 y el año actual
- Almacenar hasta 50 libros
- Mensaje de confirmación con todos los datos ingresados

### 3. Búsqueda por Título

- Permitir búsqueda parcial (case insensitive)
- Mostrar todos los libros que coincidan
- Si no hay coincidencias, mostrar mensaje apropiado
- Formato de salida limpio y legible

### 4. Búsqueda por Autor

- Búsqueda parcial por nombre de autor (case insensitive)
- Listar todos los libros del autor encontrado
- Contar cuántos libros tiene ese autor en la biblioteca

### 5. Listar Todos los Libros

- Mostrar información completa de todos los libros registrados
- Numeración consecutiva
- Formato tabular o bien estructurado
- Mostrar total de libros al final

### 6. Estadísticas

Calcular y mostrar:

- Total de libros en la biblioteca
- Libro más antiguo y más reciente
- Promedio de páginas por libro
- Categoría con más libros
- Total de páginas en toda la biblioteca

### 7. Verificar Disponibilidad

- Solicitar ISBN del libro
- Buscar y mostrar si existe
- Mostrar toda la información del libro si se encuentra

## Requisitos Técnicos

### Validaciones Obligatorias

1. ISBN: exactamente 13 caracteres numéricos
2. Año: entre 1500 y año actual (usar utildate o System para obtener año actual)
3. Páginas: número positivo mayor a 0
4. Título y Autor: no pueden estar vacíos
5. Categoría: elegir de una lista predefinida (Ficción, No Ficción, Ciencia, Historia, Arte)

### Formato de Salida Esperado

```bash
╔════════════════════════════════════════════╗
║         INFORMACIÓN DEL LIBRO              ║
╠════════════════════════════════════════════╣
║ Título:      El Quijote                    ║
║ Autor:       Miguel de Cervantes           ║
║ ISBN:        9788424178543                 ║
║ Año:         1605                          ║
║ Páginas:     863                           ║
║ Categoría:   Ficción                       ║
╚════════════════════════════════════════════╝
```

## Extras (Opcionales - Desafío)

1. **Prestamos**: Agregar funcionalidad de préstamo con fecha de devolución
2. **Ordenamiento**: Ordenar libros por título, año o autor
3. **Exportar**: Generar un reporte de texto con todos los libros
4. **Colores**: Usar códigos ANSI para colorear la salida en consola
5. **Persistencia**: Guardar los libros en un archivo de texto (usar lo aprendido en manejo de archivos)

## Criterios de Evaluación

- **Funcionalidad completa**: Todas las opciones del menú funcionan
- **Validaciones**: Todos los datos son validados correctamente
- **Código limpio**: Variables con nombres descriptivos
- **Comentarios**: Código bien documentado
- **Manejo de errores**: El programa no se rompe con entradas inválidas
- **Formato**: Salidas bien formateadas y legibles

## Tiempo Estimado

4-6 horas de desarrollo

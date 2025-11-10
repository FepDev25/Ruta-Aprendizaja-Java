# PROYECTO 03: Analizador de Texto 📝

## Dificultad: ⭐⭐⭐

## Descripción General

Crea una herramienta poderosa de análisis de texto que procese y extraiga información detallada de cadenas de texto, aplicando técnicas avanzadas de manipulación de Strings.

## Objetivos de Aprendizaje

- Dominio completo de métodos de String
- Uso intensivo de bucles y condicionales
- Operadores relacionales y lógicos
- Arrays de caracteres y palabras
- Algoritmos de búsqueda y conteo
- Validación y formateo de texto

## Funcionalidades Requeridas

### Menú Principal

```bash
╔════════════════════════════════════════════╗
║         ANALIZADOR DE TEXTO v1.0           ║
╠════════════════════════════════════════════╣
║  1. Ingresar/Modificar texto               ║
║  2. Análisis básico                        ║
║  3. Análisis de palabras                   ║
║  4. Búsqueda y reemplazo                   ║
║  5. Análisis de caracteres                 ║
║  6. Validaciones de formato                ║
║  7. Transformaciones de texto              ║
║  8. Estadísticas avanzadas                 ║
║  9. Exportar reporte completo              ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
Texto actual: [primeras 50 caracteres...]
```

## Módulos Detallados

### 1. Ingresar/Modificar Texto

- Permitir entrada de texto de varias líneas
- Opción de cargar texto de ejemplo
- Límite de 5000 caracteres
- Mostrar confirmación con primeros 100 caracteres
- Opción de agregar más texto al existente
- Opción de limpiar texto actual

### 2. Análisis Básico

Calcular y mostrar:

- **Total de caracteres** (con y sin espacios)
- **Total de palabras**
- **Total de líneas**
- **Total de párrafos** (separados por doble salto)
- **Longitud promedio de palabras**
- **Densidad léxica**: palabras únicas / total palabras × 100

**Formato de salida:**

```bash
╔════════════════════════════════════════════╗
║          ANÁLISIS BÁSICO                   ║
╠════════════════════════════════════════════╣
║ Caracteres (con espacios):     1,234       ║
║ Caracteres (sin espacios):     1,034       ║
║ Palabras:                        215       ║
║ Líneas:                           45       ║
║ Párrafos:                         12       ║
║ Promedio caracteres/palabra:    4.81       ║
║ Densidad léxica:               65.12%      ║
╚════════════════════════════════════════════╝
```

### 3. Análisis de Palabras

- **Palabra más larga** y su longitud
- **Palabra más corta** y su longitud
- **Top 10 palabras más frecuentes** (con contador)
- **Total de palabras únicas**
- **Palabras que empiezan con vocal/consonante**
- **Palabras con más de N caracteres** (N ingresado por usuario)
- **Lista de palabras palíndromas** encontradas

Considerar:

- Ignorar mayúsculas/minúsculas en conteo
- Eliminar signos de puntuación
- Tratar palabras con guion como una sola

### 4. Búsqueda y Reemplazo

Implementar:

- **Buscar palabra/frase**: mostrar cantidad de apariciones
- **Buscar con contexto**: mostrar línea donde aparece
- **Búsqueda case-sensitive/insensitive**
- **Reemplazar palabra/frase**: global o selectivo
- **Resaltar todas las apariciones**: marcar con [ENCONTRADO]
- **Buscar palabras que contienen**: subcadena específica

**Ejemplo:**

```bash
Texto original: "El gato subió al árbol. El gato maúlla."
Buscar: "gato"
Coincidencias encontradas: 2
¿Reemplazar por?: "perro"
Resultado: "El perro subió al árbol. El perro maúlla."
```

### 5. Análisis de Caracteres

- **Vocales**: cantidad total y porcentaje
- **Consonantes**: cantidad total y porcentaje
- **Dígitos numéricos**: cantidad y cuáles
- **Signos de puntuación**: tipos y cantidad
- **Mayúsculas vs minúsculas**: cantidad de cada una
- **Espacios en blanco**: cantidad y tipos (espacios, tabs)
- **Caracteres especiales**: símbolos encontrados

Mostrar tabla de frecuencia de cada carácter (top 20).

### 6. Validaciones de Formato

Verificar si el texto contiene:

- **Email válido**: formato <nombre@dominio.ext>
- **Números de teléfono**: varios formatos
- **URLs**: detectar links http/https
- **Fechas**: formatos dd/mm/yyyy, yyyy-mm-dd
- **Números**: enteros, decimales, negativos
- **Código postal**: formato específico
- **Menciones**: @usuario
- **Hashtags**: #etiqueta

Para cada tipo encontrado, listar todos los casos.

### 7. Transformaciones de Texto

Aplicar y mostrar:

- **Todo MAYÚSCULAS**
- **todo minúsculas**
- **Capitalizar Primera Letra De Cada Palabra**
- **Invertir texto completo**
- **Invertir cada palabra** (mantener orden)
- **Eliminar espacios extras** (múltiples → uno)
- **Eliminar puntuación**
- **Codificar en ROT13**
- **Contar y eliminar palabras duplicadas consecutivas**
- **Justificar texto** (ancho específico)

### 8. Estadísticas Avanzadas

- **Índice de legibilidad** (fórmula simplificada)
- **Tiempo estimado de lectura** (palabras por minuto)
- **Nivel de complejidad**: basado en longitud de palabras
- **Distribución de longitud de palabras**: histograma ASCII
- **Análisis de sentencias**: promedio palabras por oración
- **Palabras por párrafo**: promedio y distribución

**Distribución de longitud (ejemplo):**

```bash
1-3 letras:  ████████████ (45 palabras)
4-6 letras:  ████████████████████ (78 palabras)
7-9 letras:  ██████████ (38 palabras)
10+ letras:  ████ (12 palabras)
```

### 9. Exportar Reporte Completo

Generar reporte de texto que incluya:

- Todos los análisis realizados
- Fecha y hora de generación
- Texto original (primeros 500 caracteres)
- Todas las estadísticas calculadas
- Formato profesional con separadores

## Requisitos Técnicos

### Métodos de String a Utilizar

```java
- length(), isEmpty()
- charAt(), substring()
- toLowerCase(), toUpperCase()
- trim(), strip()
- split(), join()
- contains(), indexOf(), lastIndexOf()
- startsWith(), endsWith()
- replace(), replaceAll()
- matches() // para expresiones regulares básicas
- toCharArray()
- equals(), equalsIgnoreCase()
- compareTo(), compareToIgnoreCase()
```

### Validaciones

1. Texto no puede estar vacío para análisis
2. Validar entradas numéricas (N caracteres, ancho de justificación)
3. Confirmar antes de reemplazar texto
4. Límite de 5000 caracteres en entrada

### Algoritmos Requeridos

1. **Contar palabras**: split por espacios, considerar puntuación
2. **Palabra más frecuente**: algoritmo de conteo manual (sin Map)
3. **Detectar palíndromo**: comparar string con su reverso
4. **Validar email**: usar contains("@") y contains(".")
5. **Histograma**: usar bucles y operadores para generar barras

## Conceptos a Aplicar

### 1. Strings (Principal foco)

- Todos los métodos mencionados arriba
- Manipulación intensiva de cadenas
- Concatenación eficiente
- Comparaciones y búsquedas

### 2. Bucles

- `for` para recorrer caracteres
- `for-each` para arrays de palabras
- `while` para menú principal
- Bucles anidados para análisis complejos

### 3. Condicionales

- `if-else` para clasificaciones
- `switch` para menús
- Operador ternario para formateo

### 4. Arrays

- Arrays de String (palabras)
- Arrays de char (caracteres)
- Arrays de int (contadores)

### 5. Operadores

- Aritméticos: cálculo de promedios, porcentajes
- Relacionales: comparaciones
- Lógicos: validaciones compuestas

## Casos de Prueba

Prueba tu programa con estos textos:

**Texto 1 - Simple:**

```bash
Hola mundo. Java es genial.
```

**Texto 2 - Palíndromos:**

```bash
Anita lava la tina. Oso. Reconocer. Radar.
```

**Texto 3 - Con datos:**

```bash
Contacto: juan@email.com, tel: 555-1234
Web: https://ejemplo.com, fecha: 2025-11-08
```

**Texto 4 - Complejo:**

```bash
El análisis de texto es fundamental en el procesamiento 
del lenguaje natural. @usuario #java #programacion
```

## Extras (Opcionales - Desafío)

1. **Análisis de sentimiento**: clasificar palabras positivas/negativas
2. **Sugerencias ortográficas**: detectar palabras raras
3. **Generador de resumen**: extraer oraciones clave
4. **Nube de palabras ASCII**: tamaño proporcional a frecuencia
5. **Análisis bilingüe**: detectar palabras en inglés/español
6. **Encriptación César**: codificar con desplazamiento
7. **Comparador de textos**: similitud entre dos textos

## Criterios de Evaluación

- **Todas las funcionalidades completas**
- **Precisión en conteos y estadísticas**
- **Manejo robusto de casos especiales** (texto vacío, caracteres especiales)
- **Código eficiente** (evitar procesamiento redundante)
- **Formato de salida profesional**
- **Validaciones completas**

## Tiempo Estimado

5-7 horas de desarrollo

## Consejos

1. Empieza con análisis básico antes de los complejos
2. Crea métodos auxiliares para operaciones repetitivas
3. Almacena el texto procesado para evitar recalcular
4. Usa String.format() o printf para formato de salida
5. Prueba con textos de diferentes tamaños y características
6. Comenta secciones complejas de tu código
7. Considera eficiencia: no recorras el texto innecesariamente

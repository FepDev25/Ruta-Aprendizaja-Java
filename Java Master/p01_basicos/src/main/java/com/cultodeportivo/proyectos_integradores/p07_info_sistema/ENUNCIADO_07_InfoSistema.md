# PROYECTO 07: Sistema de Información del Sistema 💻

## Dificultad: ⭐⭐

## Descripción General

Desarrolla una aplicación que muestre información detallada del sistema operativo, la JVM, el entorno de ejecución y propiedades del sistema. Aplica los conocimientos de `System`, fechas y formateo.

## Objetivos de Aprendizaje

- Uso de System.getProperty()
- Uso de System.getenv()
- Manejo de fechas con utildate
- Formateo profesional de información
- Manipulación de Strings para presentación
- Comprensión del entorno de ejecución Java

## Funcionalidades Requeridas

### Menú Principal

```bash
╔════════════════════════════════════════════╗
║    INFORMACIÓN DEL SISTEMA v1.0 💻         ║
╠════════════════════════════════════════════╣
║  1. Información del Sistema Operativo     ║
║  2. Información de Java/JVM                ║
║  3. Información del Usuario                ║
║  4. Información de Directorios             ║
║  5. Variables de Entorno                   ║
║  6. Propiedades del Sistema                ║
║  7. Información de Memoria                 ║
║  8. Información de Fecha y Hora            ║
║  9. Información de Red                     ║
║ 10. Reporte Completo                       ║
║ 11. Exportar Información                   ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Módulos Detallados

### 1. Información del Sistema Operativo 🖥️

Mostrar:

- **Nombre del SO**: `System.getProperty("os.name")`
- **Versión del SO**: `System.getProperty("os.version")`
- **Arquitectura**: `System.getProperty("os.arch")`
- **Número de procesadores**: `Runtime.getRuntime().availableProcessors()`
- **Separador de línea**: `System.getProperty("line.separator")` (mostrarlo como texto)
- **Separador de ruta**: `System.getProperty("path.separator")`
- **Separador de archivo**: `System.getProperty("file.separator")`

**Formato de salida:**

```bash
╔════════════════════════════════════════════╗
║      INFORMACIÓN DEL SISTEMA OPERATIVO     ║
╠════════════════════════════════════════════╣
║ Sistema Operativo: Linux                   ║
║ Versión:          5.15.0-83-generic        ║
║ Arquitectura:     amd64                    ║
║ Procesadores:     8 núcleos                ║
║ Separador línea:  \\n (Unix)               ║
║ Separador ruta:   : (dos puntos)           ║
║ Separador archivo: / (forward slash)       ║
║                                            ║
║ Tipo de sistema: Sistema Unix-like         ║
╚════════════════════════════════════════════╝
```

**Análisis adicional:**

- Detectar si es Windows, Linux o Mac
- Indicar si es sistema de 32 o 64 bits
- Mostrar recomendaciones según el SO

### 2. Información de Java/JVM ☕

Mostrar:

- **Versión de Java**: `System.getProperty("java.version")`
- **Vendedor de Java**: `System.getProperty("java.vendor")`
- **URL del vendedor**: `System.getProperty("java.vendor.url")`
- **Directorio de instalación**: `System.getProperty("java.home")`
- **Versión de especificación**: `System.getProperty("java.specification.version")`
- **Nombre de la JVM**: `System.getProperty("java.vm.name")`
- **Versión de la JVM**: `System.getProperty("java.vm.version")`
- **Vendedor de la JVM**: `System.getProperty("java.vm.vendor")`
- **Class Path**: `System.getProperty("java.class.path")`
- **Library Path**: `System.getProperty("java.library.path")`

**Características:**

- Detectar versión mayor de Java (8, 11, 17, etc.)
- Indicar si es LTS (Long Term Support)
- Mostrar características principales de la versión
- Listar JAR files en el classpath (separados)

### 3. Información del Usuario 👤

Mostrar:

- **Nombre de usuario**: `System.getProperty("user.name")`
- **Directorio home**: `System.getProperty("user.home")`
- **Directorio de trabajo actual**: `System.getProperty("user.dir")`
- **Idioma del usuario**: `System.getProperty("user.language")`
- **País del usuario**: `System.getProperty("user.country")`
- **Zona horaria**: `System.getProperty("user.timezone")`
- **Variables USER y HOME**: `System.getenv("USER")`, `System.getenv("HOME")`

**Información adicional:**

- Listar archivos en directorio home (primeros 10)
- Listar archivos en directorio actual
- Mostrar tamaño total de archivos en directorio actual

### 4. Información de Directorios 📁

Mostrar:

- **Directorio temporal**: `System.getProperty("java.io.tmpdir")`
- **Directorio de trabajo**: `System.getProperty("user.dir")`
- **Directorio home del usuario**: `System.getProperty("user.home")`

**Análisis de cada directorio:**

- Verificar si existe
- Verificar permisos (lectura/escritura)
- Mostrar ruta absoluta
- Contar archivos (si es posible)
- Mostrar espacio disponible (usar `File` si es necesario)

### 5. Variables de Entorno 🌍

Funcionalidad:

- Listar TODAS las variables de entorno
- Buscar variable específica
- Mostrar valor de variables comunes

**Variables comunes a mostrar:**

- PATH
- HOME / USERPROFILE
- TEMP / TMP
- JAVA_HOME (si existe)
- CLASSPATH (si existe)
- USER / USERNAME
- SHELL (en Unix)
- LANG / LANGUAGE

**Formato:**

```bash
╔════════════════════════════════════════════╗
║        VARIABLES DE ENTORNO                ║
╠════════════════════════════════════════════╣
║ PATH:                                      ║
║   /usr/local/bin                           ║
║   /usr/bin                                 ║
║   /bin                                     ║
║   ...                                      ║
║                                            ║
║ HOME:                                      ║
║   /home/usuario                            ║
║                                            ║
║ JAVA_HOME:                                 ║
║   /usr/lib/jvm/java-17                     ║
║                                            ║
║ Total de variables: 45                     ║
╚════════════════════════════════════════════╝
```

### 6. Propiedades del Sistema ⚙️

Listar TODAS las propiedades del sistema:

```java
Properties props = System.getProperties();
```

**Opciones:**

- Mostrar todas las propiedades
- Buscar propiedad por nombre
- Filtrar por categoría (java.*, user.*, os.*)
- Ordenar alfabéticamente
- Mostrar total de propiedades

**Formato tabular:**

```bash
Propiedad                    | Valor
-----------------------------|----------------------------------
file.encoding                | UTF-8
file.separator               | /
java.class.version           | 61.0
java.home                    | /usr/lib/jvm/java-17
...
```

### 7. Información de Memoria 💾

Mostrar estadísticas de memoria de la JVM:

```java
Runtime runtime = Runtime.getRuntime();
long maxMemory = runtime.maxMemory();
long totalMemory = runtime.totalMemory();
long freeMemory = runtime.freeMemory();
long usedMemory = totalMemory - freeMemory;
```

**Información a mostrar:**

- **Memoria máxima**: Máxima que puede usar la JVM
- **Memoria total**: Actualmente asignada
- **Memoria libre**: Disponible en la asignada
- **Memoria usada**: En uso actualmente
- **Porcentaje de uso**: (usada/total) × 100

**Conversiones:**

- Mostrar en bytes, KB, MB, GB según tamaño
- Usar 1024 bytes = 1 KB

**Gráfico ASCII:**

```bash
Uso de Memoria:
[████████████░░░░░░░░] 60% (450 MB / 750 MB)

Distribución:
Usada:    ████████████ 450 MB
Libre:    ████████     300 MB
Total:    ████████████████████ 750 MB
Máxima:   ██████████████████████████ 1024 MB
```

### 8. Información de Fecha y Hora 📅

Mostrar:

- **Fecha y hora actual**: `new Date()`
- **Timestamp**: `System.currentTimeMillis()`
- **Nano time**: `System.nanoTime()`
- **Zona horaria**: Calcular offset GMT
- **Día de la semana**
- **Día del año**
- **Semana del año**

**Formatos múltiples:**

```bash
╔════════════════════════════════════════════╗
║       INFORMACIÓN DE FECHA Y HORA          ║
╠════════════════════════════════════════════╣
║ Fecha actual:                              ║
║   Formato completo:  Viernes, 8 de         ║
║                      noviembre de 2025     ║
║   Formato corto:     08/11/2025            ║
║   Formato ISO:       2025-11-08            ║
║                                            ║
║ Hora actual:                               ║
║   Formato 24h:       15:30:45              ║
║   Formato 12h:       03:30:45 PM           ║
║                                            ║
║ Timestamp:           1699458645000 ms      ║
║ Nano time:           12345678901234 ns     ║
║                                            ║
║ Zona horaria:        GMT-5:00              ║
║ Día de la semana:    Viernes (día 5)       ║
║ Día del año:         312 de 365            ║
╚════════════════════════════════════════════╝
```

**Cálculos adicionales:**

- Días transcurridos en el año
- Días restantes en el año
- Días hasta fin de mes
- Determinar si es año bisiesto
- Tiempo de ejecución de la JVM (usando timestamp al inicio)

### 9. Información de Red 🌐

Mostrar (usando propiedades del sistema y variables de entorno):

- **Nombre del host**: intentar obtener de variables de entorno
- **Usuario de red**: `USER` o `USERNAME`
- **Dominio**: si está disponible

**Si es posible sin clases avanzadas:**

- Detectar conexión de red (basado en variables)
- Mostrar configuración regional

### 10. Reporte Completo 📄

Generar reporte que incluya:

- Resumen de toda la información recopilada
- Formato profesional
- Secciones claramente separadas
- Fecha y hora de generación
- Versión del programa

**Estructura:**

```bash
═══════════════════════════════════════════════
       REPORTE COMPLETO DEL SISTEMA
       Generado: 08/11/2025 15:30:45
       Versión del programa: 1.0
═══════════════════════════════════════════════

1. SISTEMA OPERATIVO
   [información completa]

2. JAVA/JVM
   [información completa]

3. USUARIO
   [información completa]

... [resto de secciones]

═══════════════════════════════════════════════
       Fin del reporte
═══════════════════════════════════════════════
```

### 11. Exportar Información 💾

**Opciones de exportación:**

- **Formato texto plano** (.txt)
- **Formato CSV** (para propiedades)
- **Formato Markdown** (.md)

**Funcionalidad:**

- Elegir qué secciones exportar
- Generar nombre de archivo automático: `system_info_YYYYMMDD_HHMMSS.txt`
- Guardar en directorio actual
- Confirmar ubicación del archivo guardado

## Requisitos Técnicos

### Propiedades del Sistema a Usar

```java
// Sistema Operativo
System.getProperty("os.name")
System.getProperty("os.version")
System.getProperty("os.arch")

// Java
System.getProperty("java.version")
System.getProperty("java.vendor")
System.getProperty("java.home")
System.getProperty("java.vm.name")
System.getProperty("java.vm.version")
System.getProperty("java.class.path")

// Usuario
System.getProperty("user.name")
System.getProperty("user.home")
System.getProperty("user.dir")
System.getProperty("user.language")
System.getProperty("user.country")

// Otros
System.getProperty("file.separator")
System.getProperty("path.separator")
System.getProperty("line.separator")
```

### Variables de Entorno a Usar

```java
System.getenv("PATH")
System.getenv("HOME")
System.getenv("USER")
System.getenv("JAVA_HOME")
System.getenv("TEMP")
// ... y todas las disponibles
```

### Runtime

```java
Runtime runtime = Runtime.getRuntime();
runtime.availableProcessors()
runtime.maxMemory()
runtime.totalMemory()
runtime.freeMemory()
```

### Date

```java
Date now = new Date();
long timestamp = System.currentTimeMillis();
long nanoTime = System.nanoTime();
```

## Conceptos a Aplicar

### 1. System

- System.getProperty()
- System.getenv()
- System.currentTimeMillis()
- System.nanoTime()
- System.out.println(), printf()

### 2. Strings

- Manipulación intensiva
- Formateo profesional
- Concatenación
- split() para PATH

### 3. Date (utildate)

- Creación de fechas
- Formateo básico
- Cálculos de tiempo

### 4. Condicionales

- Detectar tipo de SO
- Validar existencia de propiedades
- Clasificar información

### 5. Bucles

- Iterar sobre propiedades
- Iterar sobre variables de entorno
- Procesar listas

### 6. Wrappers

- Long.parseLong()
- Integer.parseInt()
- Conversiones

## Extras (Opcionales - Desafío)

1. **Monitor en tiempo real**: Actualizar memoria cada segundo
2. **Alertas**: Notificar si memoria > 80%
3. **Comparador**: Guardar y comparar entre ejecuciones
4. **Benchmark**: Medir rendimiento del sistema
5. **Gráficos ASCII avanzados**: Para todas las métricas
6. **Modo servidor**: Mostrar uptime simulado
7. **Health Check**: Verificar estado general del sistema

## Casos de Prueba

1. Ejecutar en diferentes sistemas operativos (Windows/Linux/Mac)
2. Verificar todas las propiedades se muestran correctamente
3. Probar con diferentes versiones de Java si es posible
4. Validar exportación de reportes
5. Verificar cálculos de memoria

## Criterios de Evaluación

- **Todas las secciones funcionan**
- **Información precisa y actualizada**
- **Formato profesional**
- **Manejo de propiedades inexistentes**
- **Código bien estructurado**
- **Conversiones correctas** (bytes → MB)

## Tiempo Estimado

3-4 horas de desarrollo

## Consejos

1. Prueba cada propiedad individualmente primero
2. Ten cuidado con propiedades que pueden no existir
3. Usa try-catch para propiedades opcionales
4. Formatea la salida con printf para alineación
5. Crea métodos para conversiones repetitivas (bytes → MB)
6. Documenta qué hace cada propiedad
7. Prueba en diferentes entornos si puedes

# Proyecto 02 - Analizador de Logs y Métricas de Servidor

## Descripción General

Desarrollar una herramienta profesional para analizar logs de servidores web, identificar patrones de tráfico, detectar anomalías, generar reportes estadísticos y visualizar métricas. El sistema debe procesar grandes volúmenes de registros de forma eficiente y proporcionar análisis en tiempo real.

**Dificultad:** ⭐⭐⭐⭐  
**Tiempo estimado:** 10-12 horas  
**Conceptos clave:** Map para conteo y agrupación, TreeMap para ordenamiento temporal, Set para IPs únicas, algoritmos de análisis

---

## Objetivos de Aprendizaje

- Usar **HashMap** para conteo eficiente (O(1)) de eventos
- Aplicar **TreeMap** para mantener datos ordenados temporalmente
- Implementar **LinkedHashMap** para logs ordenados por tiempo de inserción
- Utilizar **HashSet** para identificar IPs únicas y eliminar duplicados
- Crear **Map anidados** para estadísticas multi-dimensionales
- Usar **Comparator** para ordenar por múltiples criterios
- Aplicar **PriorityQueue** para identificar top N elementos

---

## Estructura de Clases

### 1. Clase `LogEntry`

Representa una entrada individual en el log del servidor.

**Atributos:**

- timestamp: LocalDateTime
- ipAddress: String
- metodoHTTP: String (GET, POST, PUT, DELETE, etc.)
- urlSolicitada: String
- codigoEstado: int (200, 404, 500, etc.)
- tiempoRespuesta: int (en milisegundos)
- bytesTransferidos: long
- userAgent: String (navegador/cliente)
- ipOrigen: String (puede ser diferente por proxies)

**Métodos importantes:**

- esError() retorna true si código >= 400
- esExitoso() retorna true si código entre 200-299
- esLento() retorna true si tiempo > umbral
- getCategoriaEstado() retorna "Exitoso", "Redirección", "Error Cliente", "Error Servidor"
- toString() con formato legible
- equals() y hashCode() basados en timestamp e ipAddress

### 2. Clase `EstadisticaURL`

Estadísticas agregadas para una URL específica.

**Atributos:**

- url: String
- numeroVisitas: int
- tiempoPromedioRespuesta: double
- tiempoMinimoRespuesta: int
- tiempoMaximoRespuesta: int
- totalBytesTransferidos: long
- errores: int
- visitasUnicas: Set&lt;String&gt; (IPs únicas que visitaron)

**Métodos importantes:**

- agregarVisita(LogEntry)
- calcularPromedioRespuesta()
- getTasaError() retorna porcentaje
- getVisitantesUnicos() retorna tamaño del Set
- toString() con formato de reporte

### 3. Clase `EstadisticaIP`

Estadísticas de actividad por dirección IP.

**Atributos:**

- ipAddress: String
- numeroSolicitudes: int
- urlsVisitadas: Set&lt;String&gt;
- metodosMasUsados: Map&lt;String, Integer&gt;
- primeraVista: LocalDateTime
- ultimaVista: LocalDateTime
- totalErrores: int
- esPosibleBot: boolean (más de N solicitudes/minuto)

**Métodos importantes:**

- agregarSolicitud(LogEntry)
- calcularSolicitudesPorMinuto()
- getMetodoMasFrecuente()
- esComportamientoSospechoso() analiza patrones anómalos
- toString() con resumen de actividad

### 4. Clase `RangoDeTiempo`

Representa un intervalo de tiempo con estadísticas.

**Atributos:**

- inicio: LocalDateTime
- fin: LocalDateTime
- totalSolicitudes: int
- solicitudesExitosas: int
- solicitudesConError: int
- tiempoPromedioRespuesta: double
- ipsUnicas: Set&lt;String&gt;

**Métodos importantes:**

- contiene(LocalDateTime) verifica si timestamp está en el rango
- agregarLog(LogEntry)
- calcularTasaExito()
- getSolicitudesPorSegundo()
- toString() con resumen del período

### 5. Clase `AnalizadorLogs`

Clase principal que procesa y analiza los logs.

**Atributos:**

- logs: List&lt;LogEntry&gt; (todos los logs, ordenados por timestamp)
- estadisticasPorURL: Map&lt;String, EstadisticaURL&gt;
- estadisticasPorIP: Map&lt;String, EstadisticaIP&gt;
- logsExitosos: List&lt;LogEntry&gt; (código 200-299)
- logsConError: List&lt;LogEntry&gt; (código >= 400)
- logsLentos: List&lt;LogEntry&gt; (tiempo > umbral)
- ipsUnicas: Set&lt;String&gt;
- urlsUnicas: Set&lt;String&gt;
- estadisticasPorCodigo: Map&lt;Integer, Integer&gt; (contador por código HTTP)
- estadisticasPorHora: Map&lt;Integer, RangoDeTiempo&gt; (hora 0-23)

**Métodos importantes:**

- agregarLog(LogEntry) y procesar estadísticas
- cargarLogsDesdeArchivo(String rutaArchivo) parsea archivo de logs
- analizarLogs() procesa todas las estadísticas
- getURLsMasVisitadas(int top)
- getIPsMasActivas(int top)
- getIPsSospechosas() detecta posibles bots/ataques
- getCodigosEstadoMasFrecuentes()
- getHoraPico() retorna hora con más tráfico
- getURLsMasLentas(int top)
- filtrarPorRangoFecha(LocalDateTime inicio, LocalDateTime fin)
- filtrarPorCodigoEstado(int codigo)
- filtrarPorIP(String ip)
- detectarAnomalias() identifica patrones inusuales
- generarReporteCompleto() String con todas las estadísticas

### 6. Clase `DetectorAnomalias`

Detecta comportamientos inusuales en los logs.

**Atributos:**

- umbralesConfigurables: Map&lt;String, Double&gt; (ej: "solicitudes_por_minuto_max")
- patronesNormales: Map&lt;String, Object&gt; (comportamiento base)

**Métodos importantes:**

- detectarPicosDeTrafic(List&lt;LogEntry&gt;) identifica aumentos repentinos
- detectarBots(Map&lt;String, EstadisticaIP&gt;)
- detectarAtaquesDDoS(List&lt;LogEntry&gt;) múltiples IPs atacando simultáneamente
- detectarEscaneoDeDirectorios(Map&lt;String, EstadisticaIP&gt;) muchos 404 desde una IP
- detectarFallosEnCadena(List&lt;LogEntry&gt;) múltiples errores 500 seguidos
- generarAlerta(String tipo, String descripcion)

---

## Funcionalidades Requeridas

### Procesamiento de Logs

1. Cargar logs desde archivo de texto (formato Apache/Nginx)
2. Parsear cada línea y crear objetos LogEntry
3. Validar formato y descartar líneas inválidas
4. Almacenar logs ordenados cronológicamente
5. Actualizar estadísticas en tiempo real al agregar logs

### Análisis de URLs

1. Identificar las URLs más visitadas (top 10)
2. Calcular tiempo promedio de respuesta por URL
3. Detectar URLs con mayor tasa de error
4. Identificar URLs más lentas
5. Obtener distribución de métodos HTTP por URL
6. Calcular bytes transferidos por URL

### Análisis de IPs

1. Listar IPs más activas (top 20)
2. Identificar IPs con comportamiento sospechoso
3. Detectar posibles bots (alta frecuencia de solicitudes)
4. Analizar URLs visitadas por IP específica
5. Identificar IPs que generan más errores
6. Calcular tiempo de sesión (primera - última solicitud)

### Análisis Temporal

1. Identificar hora pico del día
2. Generar distribución de tráfico por hora
3. Calcular solicitudes por minuto en intervalos específicos
4. Detectar picos anormales de tráfico
5. Comparar tráfico entre días/semanas
6. Identificar períodos de baja actividad

### Análisis de Errores

1. Contar errores por código HTTP (404, 500, 503, etc.)
2. Identificar URLs que más generan errores
3. Detectar patrones de fallos en cascada
4. Analizar causas comunes de errores 404
5. Identificar servicios caídos (errores 503)
6. Generar alerta por tasa de error > umbral

### Detección de Anomalías

1. Detectar posibles ataques DDoS
2. Identificar escaneo de directorios (muchos 404 seguidos)
3. Detectar intentos de explotación (patrones en URLs)
4. Identificar bots maliciosos
5. Detectar patrones inusuales de tráfico
6. Generar reportes de seguridad

### Reportes y Visualización

1. Generar reporte completo de estadísticas
2. Exportar métricas en formato CSV
3. Crear gráfico ASCII de distribución horaria
4. Generar reporte de top 10 en cada categoría
5. Crear dashboard textual con métricas principales
6. Exportar lista de IPs bloqueadas recomendadas

---

## Reglas de Negocio

1. **Formato de Log**: Apache Combined Log Format o similar
2. **Códigos HTTP**:
   - 2xx: Exitoso
   - 3xx: Redirección
   - 4xx: Error del cliente
   - 5xx: Error del servidor
3. **Umbral de Respuesta Lenta**: > 1000ms (configurable)
4. **Detección de Bot**: > 60 solicitudes por minuto desde una IP
5. **Ataque DDoS**: > 100 IPs distintas con picos simultáneos
6. **Escaneo de Directorios**: > 20 errores 404 seguidos desde una IP
7. **IP Sospechosa**: Combina alta frecuencia + alta tasa de error
8. **Hora Pico**: Hora con máximo número de solicitudes

---

## Casos de Prueba

### Prueba 1: Carga y Parseo de Logs

1. Cargar archivo con 1000 líneas de logs
2. Verificar que se parseen correctamente
3. Validar que los logs estén ordenados por timestamp
4. Contar cuántas líneas inválidas fueron descartadas
5. Verificar que las estadísticas básicas se calculen

### Prueba 2: Análisis de URLs

1. Identificar top 5 URLs más visitadas
2. Calcular tiempo promedio de respuesta
3. Encontrar URL más lenta
4. Listar URLs con errores
5. Verificar bytes totales transferidos

### Prueba 3: Análisis de IPs

1. Listar top 10 IPs más activas
2. Detectar IPs con comportamiento sospechoso
3. Identificar posibles bots
4. Analizar distribución de métodos HTTP por IP
5. Calcular tiempo de sesión promedio

### Prueba 4: Análisis Temporal

1. Determinar hora pico del día
2. Generar distribución de tráfico por hora
3. Calcular solicitudes por minuto en pico
4. Identificar períodos de baja actividad
5. Detectar picos anormales de tráfico

### Prueba 5: Detección de Anomalías

1. Simular ataque DDoS y detectarlo
2. Simular escaneo de directorios y detectarlo
3. Identificar IPs que deberían bloquearse
4. Detectar fallos en cascada (errores 500 consecutivos)
5. Generar reporte de seguridad completo

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== ANALIZADOR DE LOGS DE SERVIDOR ===

1. Gestión de Logs
   1.1. Cargar logs desde archivo
   1.2. Agregar log manual
   1.3. Ver resumen de logs cargados
   1.4. Limpiar logs actuales

2. Análisis de URLs
   2.1. Top URLs más visitadas
   2.2. URLs más lentas
   2.3. URLs con más errores
   2.4. Estadísticas de URL específica
   2.5. Distribución de métodos HTTP

3. Análisis de IPs
   3.1. Top IPs más activas
   3.2. IPs sospechosas
   3.3. Detectar bots
   3.4. Actividad de IP específica
   3.5. IPs recomendadas para bloqueo

4. Análisis Temporal
   4.1. Distribución de tráfico por hora
   4.2. Hora pico
   4.3. Tráfico en rango de fechas
   4.4. Solicitudes por minuto
   4.5. Comparar períodos

5. Análisis de Errores
   5.1. Errores por código HTTP
   5.2. URLs que generan más errores
   5.3. Tasa de error global
   5.4. Detectar fallos en cascada
   5.5. Análisis de errores 404

6. Detección de Anomalías
   6.1. Detectar ataques DDoS
   6.2. Detectar escaneo de directorios
   6.3. Identificar patrones inusuales
   6.4. Generar reporte de seguridad
   6.5. Configurar umbrales de detección

7. Reportes
   7.1. Reporte completo
   7.2. Dashboard de métricas
   7.3. Exportar a CSV
   7.4. Top 10 en todas las categorías
   7.5. Gráfico de distribución horaria

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Procesamiento en Streaming**: Procesar logs en tiempo real mientras se agregan
2. **Machine Learning Simple**: Detectar anomalías usando desviación estándar
3. **Geolocalización**: Determinar país de origen por IP
4. **Análisis de User-Agent**: Identificar navegadores y sistemas operativos
5. **Correlación de Eventos**: Encontrar patrones entre diferentes tipos de logs
6. **Predicción**: Predecir tráfico futuro basado en histórico

### Mejoras Técnicas

1. Implementar caché de estadísticas para consultas frecuentes
2. Usar TreeMap para mantener logs ordenados por timestamp automáticamente
3. Implementar índices secundarios con Map para búsquedas rápidas
4. Usar PriorityQueue para mantener top N elementos eficientemente
5. Implementar filtros combinados (IP + URL + fecha)
6. Parseo paralelo de archivos grandes usando streams

---

## Ejemplo de Salida

```bash
=== REPORTE DE ANÁLISIS DE LOGS ===
Período analizado: 2025-11-10 00:00:00 a 2025-11-10 23:59:59
Total de logs procesados: 125,430
IPs únicas: 3,247
URLs únicas: 892

--- MÉTRICAS GLOBALES ---
Solicitudes exitosas: 118,234 (94.3%)
Solicitudes con error: 7,196 (5.7%)
Tiempo promedio respuesta: 245ms
Solicitudes lentas (>1s): 1,523 (1.2%)
Bytes transferidos: 45.3 GB

--- TOP 5 URLs MÁS VISITADAS ---
1. /api/products (23,456 visitas, 156ms promedio, 99.2% éxito)
2. /home (18,234 visitas, 89ms promedio, 100% éxito)
3. /api/users (15,678 visitas, 234ms promedio, 95.4% éxito)
4. /search (12,345 visitas, 567ms promedio, 92.1% éxito)
5. /login (9,876 visitas, 123ms promedio, 97.8% éxito)

--- TOP 5 IPs MÁS ACTIVAS ---
1. 192.168.1.100 (4,523 solicitudes, 234 URLs, Bot detectado)
2. 10.0.0.45 (2,341 solicitudes, 45 URLs, Normal)
3. 172.16.0.23 (1,987 solicitudes, 78 URLs, Normal)
4. 203.45.67.89 (1,654 solicitudes, 345 URLs, Sospechosa - Alta tasa error)
5. 198.51.100.42 (1,432 solicitudes, 23 URLs, Normal)

--- DISTRIBUCIÓN HORARIA (ASCII) ---
00:00 ████░░░░░░ 3,245
03:00 ███░░░░░░░ 2,134
06:00 █████░░░░░ 4,567
09:00 ███████░░░ 8,234
12:00 ██████████ 12,456 ← HORA PICO
15:00 █████████░ 10,234
18:00 ████████░░ 9,123
21:00 ██████░░░░ 6,789

--- ALERTAS DE SEGURIDAD ---
⚠️  DDoS detectado: 234 IPs atacando simultáneamente (12:15-12:23)
⚠️  Escaneo de directorios desde IP 203.45.67.89 (145 errores 404)
⚠️  Bot malicioso detectado: 192.168.1.100 (120 req/min)
✓ IPs recomendadas para bloqueo: 3

--- ANÁLISIS DE ERRORES ---
Código 404 (No encontrado): 5,234 (72.7% de errores)
Código 500 (Error servidor): 1,234 (17.1% de errores)
Código 403 (Prohibido): 523 (7.3% de errores)
Código 503 (Servicio no disponible): 205 (2.9% de errores)

URLs con más errores 404:
1. /admin (1,234 intentos) ← Posible ataque
2. /wp-admin (987 intentos) ← Escaneo de WordPress
3. /phpmyadmin (654 intentos) ← Escaneo de phpMyAdmin
```

---

## Conceptos Clave a Aplicar

1. **HashMap para Conteo**: Uso intensivo para contar ocurrencias O(1)
2. **TreeMap para Ordenamiento**: Mantener logs ordenados por timestamp
3. **Set para Unicidad**: IPs únicas, URLs únicas sin duplicados
4. **Map Anidados**: Map&lt;String, Map&lt;String, Integer&gt;&gt; para estadísticas multi-nivel
5. **LinkedHashMap**: Mantener orden de inserción cuando importa
6. **PriorityQueue**: Encontrar top N elementos eficientemente
7. **Comparator Personalizado**: Ordenar por múltiples criterios
8. **getOrDefault()**: Simplificar contadores en Maps

---

## Notas Técnicas

- Formato de log típico: `IP - - [timestamp] "MÉTODO URL HTTP/1.1" código bytes "referer" "user-agent"`
- Usar **SimpleDateFormat** o **DateTimeFormatter** para parsear timestamps
- Implementar método robusto de parseo que maneje formatos variados
- Considerar usar **BufferedReader** para archivos grandes
- Validar IPs con expresión regular
- Implementar límites de memoria (no cargar archivos enormes completos)
- Usar **computeIfAbsent()** para inicializar Maps anidados elegantemente

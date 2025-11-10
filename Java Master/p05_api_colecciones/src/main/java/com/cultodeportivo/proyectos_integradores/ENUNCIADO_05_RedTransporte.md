# Proyecto 05 - Red de Transporte Público con Rutas y Conexiones

## Descripción General

Desarrollar un sistema de transporte público que modele una red completa de estaciones, líneas, rutas y conexiones. El sistema debe calcular rutas óptimas entre estaciones, gestionar horarios, identificar transbordos necesarios y proporcionar información en tiempo real sobre el servicio. Implementa algoritmos de búsqueda de caminos usando colecciones como grafos.

**Dificultad:** ⭐⭐⭐⭐⭐  
**Tiempo estimado:** 12-15 horas  
**Conceptos clave:** Map de grafos, algoritmos BFS/Dijkstra, Queue para búsqueda, Set para visitados

---

## Objetivos de Aprendizaje

- Modelar **grafos usando Map&lt;Estacion, List&lt;Conexion&gt;&gt;**
- Implementar **búsqueda en amplitud (BFS)** usando Queue
- Usar **Set para nodos visitados** en recorridos de grafos
- Aplicar **PriorityQueue para algoritmo de Dijkstra** (ruta más corta)
- Utilizar **Map para distancias** y reconstrucción de caminos
- Crear **LinkedHashMap para rutas ordenadas** por paradas
- Implementar **algoritmos de búsqueda de caminos**

---

## Estructura de Clases

### 1. Enum `TipoTransporte`

Define los tipos de transporte disponibles.

**Valores:**

- METRO
- BUS
- TREN
- TRANVIA
- TELEFERICO

### 2. Clase `Estacion`

Representa una estación o parada.

**Atributos:**

- id: String (único, formato "EST-001")
- nombre: String
- ubicacion: String (dirección o coordenadas)
- tipoTransporte: Set&lt;TipoTransporte&gt; (puede tener múltiples tipos)
- esTransbordo: boolean
- servicios: Set&lt;String&gt; (baños, cajeros, tiendas, etc.)
- codigoPostal: String
- coordenadaX: double
- coordenadaY: double

**Métodos importantes:**

- tieneServicio(String)
- permiteTransbordo()
- distanciaEuclidiana(Estacion otra) calcula distancia física
- equals() y hashCode() basados en id
- toString()

### 3. Clase `Linea`

Representa una línea de transporte (ej: Línea 1 del Metro).

**Atributos:**

- id: String (único, formato "LIN-001")
- nombre: String ("Línea 1", "Ruta 506")
- codigo: String ("L1", "R506")
- tipoTransporte: TipoTransporte
- color: String (para visualización)
- estaciones: LinkedHashMap&lt;Integer, Estacion&gt; (orden → estación)
- horarioInicio: LocalTime
- horarioFin: LocalTime
- frecuenciaMinutos: int
- tarifaBase: double

**Métodos importantes:**

- agregarEstacion(Estacion, int orden)
- getEstacionPorOrden(int)
- contieneEstacion(Estacion)
- getOrdenEstacion(Estacion)
- calcularTiempoViaje(Estacion origen, Estacion destino)
- getEstacionesEntreMedias(Estacion origen, Estacion destino)
- estaOperativa(LocalTime hora)
- toString()

### 4. Clase `Conexion`

Representa una conexión directa entre dos estaciones.

**Atributos:**

- estacionOrigen: Estacion
- estacionDestino: Estacion
- linea: Linea
- tiempoViaje: int (en minutos)
- distancia: double (en kilómetros)
- tarifa: double

**Métodos importantes:**

- getTiempoTotal() incluye espera promedio
- getCosto()
- esTransbordo() si origen y destino tienen diferentes tipos
- toString()

### 5. Clase `Ruta`

Representa una ruta calculada entre dos estaciones.

**Atributos:**

- origen: Estacion
- destino: Estacion
- conexiones: List&lt;Conexion&gt;
- tiempoTotalViaje: int
- distanciaTotal: double
- tarifaTotal: double
- numeroTransbordos: int
- lineasUsadas: List&lt;Linea&gt;

**Métodos importantes:**

- agregarConexion(Conexion)
- calcularTiempoTotal()
- calcularDistanciaTotal()
- calcularTarifaTotal()
- getTransbordos() retorna List&lt;Estacion&gt; donde hay transbordo
- toString() descripción paso a paso
- compareTo() para ordenar por tiempo o costo

### 6. Clase `RedTransporte`

Grafo que representa toda la red de transporte.

**Atributos:**

- estaciones: Map&lt;String, Estacion&gt;
- lineas: Map&lt;String, Linea&gt;
- grafo: Map&lt;Estacion, List&lt;Conexion&gt;&gt; (lista de adyacencia)
- transbordos: Map&lt;Estacion, Set&lt;Linea&gt;&gt; (estaciones con múltiples líneas)

**Métodos importantes:**

- agregarEstacion(Estacion)
- agregarLinea(Linea)
- agregarConexion(Conexion) actualiza grafo bidireccional
- buscarEstacionPorNombre(String) búsqueda parcial
- buscarEstacionesCercanas(double x, double y, double radio)
- getEstacionesTransbordo()
- getLineasQueConectan(Estacion, Estacion)
- validarConexion(Estacion, Estacion) verifica si existe conexión directa
- toString() resumen de la red

### 7. Clase `CalculadorRutas`

Motor de cálculo de rutas óptimas.

**Atributos:**

- red: RedTransporte

**Métodos importantes:**

- **calcularRutaMasRapida(Estacion origen, Estacion destino)** usa BFS o Dijkstra
- **calcularRutaMasCorta(Estacion origen, Estacion destino)** menor distancia
- **calcularRutaMasBarata(Estacion origen, Estacion destino)** menor costo
- **calcularRutaConMenosTransbordos(Estacion origen, Estacion destino)**
- busquedaEnAmplitud(Estacion inicio, Estacion fin) implementa BFS
- algoritmod Dijkstra(Estacion inicio, Estacion fin, criterio) genérico
- reconstruirCamino(Map&lt;Estacion, Estacion&gt; padres, Estacion inicio, Estacion fin)
- calcularRutasAlternativas(Estacion origen, Estacion destino, int cantidad)

### 8. Clase `Horario`

Gestiona horarios y frecuencias de las líneas.

**Atributos:**

- linea: Linea
- horariosLlegada: Map&lt;Estacion, List&lt;LocalTime&gt;&gt;
- diasOperacion: Set&lt;DayOfWeek&gt;

**Métodos importantes:**

- calcularProximaLlegada(Estacion, LocalTime horaActual)
- getTiempoEspera(Estacion, LocalTime)
- estaOperativaHoy(LocalDate)
- generarHorarios() crea horarios basados en frecuencia

### 9. Clase `GestorTransporte`

Clase principal del sistema.

**Atributos:**

- red: RedTransporte
- calculador: CalculadorRutas
- horarios: Map&lt;String, Horario&gt; (id línea → horario)
- tarifas: Map&lt;TipoTransporte, Double&gt;
- historicoConsultas: List&lt;Ruta&gt;

**Métodos importantes:**

- consultarRuta(String nombreOrigen, String nombreDestino, String criterio)
- getOpcionesRuta(Estacion origen, Estacion destino) múltiples alternativas
- calcularTiempoConHorarios(Ruta, LocalTime horaInicio)
- buscarEstacionesPorNombre(String)
- getLineasDisponibles(TipoTransporte)
- generarMapaRed() visualización ASCII
- getEstadisticasRed()
- guardarRutaFrecuente(Ruta) para acceso rápido

---

## Funcionalidades Requeridas

### Construcción de la Red

1. Agregar estaciones con información completa
2. Crear líneas de transporte
3. Definir conexiones entre estaciones
4. Identificar estaciones de transbordo automáticamente
5. Validar consistencia de la red (grafo conexo)

### Búsqueda de Rutas

1. **Ruta más rápida**: Minimizar tiempo de viaje
2. **Ruta más corta**: Minimizar distancia física
3. **Ruta más barata**: Minimizar costo
4. **Ruta con menos transbordos**: Maximizar viaje en una sola línea
5. Calcular múltiples rutas alternativas
6. Considerar horarios y tiempos de espera

### Algoritmos de Búsqueda

1. **BFS (Breadth-First Search)**: Para rutas con menos paradas
2. **Dijkstra**: Para rutas óptimas según peso (tiempo, costo, distancia)
3. Reconstrucción de camino desde nodos visitados
4. Manejo de grafos ponderados y no ponderados

### Información en Tiempo Real

1. Calcular tiempo de espera en estación actual
2. Próximas llegadas de cada línea
3. Determinar si una línea está operativa en horario actual
4. Calcular tiempo total incluyendo esperas y transbordos
5. Verificar disponibilidad de servicio en día/hora específicos

### Consultas Geográficas

1. Buscar estaciones cercanas a coordenadas
2. Calcular distancia física entre estaciones
3. Encontrar estación más cercana a una ubicación
4. Listar estaciones en radio específico

### Estadísticas y Análisis

1. Estaciones más conectadas (mayor grado en grafo)
2. Líneas más largas
3. Tiempo promedio de viaje en la red
4. Estaciones de transbordo más utilizadas
5. Análisis de consultas frecuentes
6. Identificar estaciones críticas (puntos de corte en grafo)

---

## Reglas de Negocio

1. **Conexiones Bidireccionales**: Si A conecta con B, entonces B conecta con A
2. **Tiempo de Transbordo**: Agregar 5 minutos adicionales por cada transbordo
3. **Tarifa de Transbordo**: Primera conexión tarifa completa, transbordos 50% de descuento
4. **Horarios**: Las líneas operan en horario definido (ej: 6:00 - 23:00)
5. **Frecuencia**: Tiempo de espera = frecuencia / 2 (promedio)
6. **Grafo Conexo**: Todas las estaciones deben ser alcanzables desde cualquier otra
7. **Estación Transbordo**: Tiene al menos 2 líneas diferentes

---

## Casos de Prueba

### Prueba 1: Construcción de Red Simple

1. Crear 10 estaciones
2. Crear 2 líneas que las conecten
3. Establecer conexiones entre estaciones
4. Verificar que el grafo sea conexo
5. Identificar estaciones de transbordo

### Prueba 2: Algoritmo BFS - Ruta con Menos Paradas

1. Buscar ruta entre estaciones alejadas
2. Verificar que use BFS correctamente
3. Comparar con ruta más rápida (puede ser diferente)
4. Contar número de paradas
5. Validar que el camino sea válido

### Prueba 3: Algoritmo Dijkstra - Ruta Más Rápida

1. Buscar ruta minimizando tiempo de viaje
2. Verificar que elija conexiones más rápidas aunque sean más largas
3. Comparar tiempo total con otras rutas
4. Validar reconstrucción correcta del camino
5. Probar con múltiples orígenes y destinos

### Prueba 4: Cálculo con Transbordos

1. Buscar ruta que requiera 2 transbordos
2. Verificar que calcule tiempo adicional de transbordo
3. Comprobar descuento en tarifa
4. Identificar estaciones de transbordo correctamente
5. Comparar con ruta sin transbordos (si existe)

### Prueba 5: Rutas Alternativas

1. Solicitar 3 rutas diferentes entre dos estaciones
2. Verificar que sean distintas
3. Comparar tiempos, costos y transbordos
4. Ordenar por criterio especificado
5. Permitir al usuario elegir

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== SISTEMA DE TRANSPORTE PÚBLICO ===

1. Gestión de Red
   1.1. Agregar estación
   1.2. Agregar línea
   1.3. Agregar conexión
   1.4. Ver información de estación
   1.5. Ver información de línea
   1.6. Listar todas las estaciones
   1.7. Listar todas las líneas

2. Búsqueda de Rutas
   2.1. Calcular ruta más rápida
   2.2. Calcular ruta más corta
   2.3. Calcular ruta más barata
   2.4. Calcular ruta con menos transbordos
   2.5. Ver rutas alternativas
   2.6. Buscar con horario específico

3. Consultas de Estaciones
   3.1. Buscar estación por nombre
   3.2. Estaciones cercanas a ubicación
   3.3. Estaciones de transbordo
   3.4. Estaciones de una línea
   3.5. Líneas que pasan por estación

4. Información en Tiempo Real
   4.1. Próximas llegadas en estación
   4.2. Tiempo de espera estimado
   4.3. Líneas operativas ahora
   4.4. Estado del servicio

5. Estadísticas
   5.1. Estaciones más conectadas
   5.2. Líneas más largas
   5.3. Tiempo promedio de viaje
   5.4. Consultas más frecuentes
   5.5. Análisis de la red

6. Visualización
   6.1. Mapa de la red (ASCII)
   6.2. Ver ruta en mapa
   6.3. Grafo de conexiones

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Algoritmo A***: Implementar búsqueda con heurística usando distancia euclidiana
2. **Detección de Ciclos**: Identificar rutas circulares en la red
3. **Puntos de Corte**: Encontrar estaciones críticas cuya eliminación desconecta la red
4. **Clustering**: Agrupar estaciones en zonas geográficas
5. **Optimización Multi-Objetivo**: Balance entre tiempo, costo y transbordos
6. **Simulación de Tráfico**: Considerar congestión en diferentes horarios

### Mejoras Técnicas

1. Implementar caché de rutas frecuentes para acceso O(1)
2. Usar PriorityQueue correctamente en Dijkstra
3. Optimizar BFS usando deque para mejor rendimiento
4. Implementar índices espaciales para búsquedas geográficas
5. Usar WeakHashMap para liberar rutas antiguas
6. Implementar algoritmo de Floyd-Warshall para todas las rutas más cortas

---

## Ejemplo de Salida

```bash
=== CALCULANDO RUTA ===
Origen: Estación Central
Destino: Aeropuerto

--- RUTA MÁS RÁPIDA (45 minutos) ---

1️⃣ Estación Central
   ⬇️ Línea 1 (Metro - Roja) - 15 min
   Paradas: Plaza de Armas, Santa Lucía, Universidad, Tobalaba

2️⃣ Tobalaba [TRANSBORDO]
   🔄 Cambio a Línea 5 (Metro - Verde)
   Tiempo de transbordo: 5 min

3️⃣ Tobalaba
   ⬇️ Línea 5 (Metro - Verde) - 25 min
   Paradas: Rodrigo de Araya, Vicente Valdés, Aeropuerto

4️⃣ Aeropuerto [LLEGADA]

📊 RESUMEN:
- Tiempo total: 45 minutos
- Distancia: 28.5 km
- Transbordos: 1 (en Tobalaba)
- Líneas utilizadas: 2 (L1, L5)
- Tarifa total: $900
  * Línea 1: $600 (tarifa completa)
  * Línea 5: $300 (50% descuento por transbordo)

⏰ HORARIO:
Si tomas el tren a las 08:00:
- Salida Estación Central: 08:00
- Llegada Tobalaba: 08:15
- Espera promedio: 3 min
- Salida Tobalaba: 08:18
- Llegada Aeropuerto: 08:43

--- RUTAS ALTERNATIVAS ---

Opción 2: Ruta más corta (25 km, 52 min, 2 transbordos)
Opción 3: Ruta más barata ($750, 58 min, 0 transbordos)

=== ESTADÍSTICAS DE LA RED ===
Total estaciones: 136
Total líneas: 7
Conexiones totales: 284
Tiempo promedio de viaje: 35 min
Estaciones de transbordo: 12

--- ESTACIONES MÁS CONECTADAS ---
1. Plaza de Armas - 4 líneas (L1, L2, L3, L5)
2. Tobalaba - 3 líneas (L1, L4, L5)
3. Los Leones - 3 líneas (L1, L6, L7)

--- LÍNEA MÁS LARGA ---
Línea 1 (Metro Roja): 38 km, 30 estaciones
```

---

## Conceptos Clave a Aplicar

1. **Grafo como Map**: Map&lt;Estacion, List&lt;Conexion&gt;&gt; representa lista de adyacencia
2. **BFS con Queue**: Búsqueda en amplitud para camino más corto en paradas
3. **Dijkstra con PriorityQueue**: Camino más corto ponderado (tiempo, costo)
4. **Set de Visitados**: Evitar ciclos en recorrido de grafo
5. **Map de Distancias**: Almacenar distancias/tiempos desde origen
6. **Reconstrucción de Camino**: Map&lt;Nodo, NodoPadre&gt; para rearmar ruta
7. **LinkedHashMap**: Mantener orden de estaciones en línea
8. **TreeSet con Comparator**: Ordenar rutas por criterio

---

## Notas Técnicas

- **Estructura de Grafo**: Usar lista de adyacencia (más eficiente que matriz)
- **BFS**: Complejidad O(V + E) donde V=estaciones, E=conexiones
- **Dijkstra**: Complejidad O((V + E) log V) con PriorityQueue
- **Grafo Bidireccional**: Al agregar conexión A→B, agregar también B→A
- **Pesos**: Pueden ser tiempo, distancia o costo según criterio
- **Inicialización**: Distancias iniciales = infinito, excepto origen = 0
- **Heurística para A***: Distancia euclidiana = sqrt((x2-x1)² + (y2-y1)²)

**¡Éxito con el proyecto!** 🚇🚌🚊🚎🗺️

# Proyecto 04 - Gestor de Torneo Deportivo Multi-Deporte

## Descripción General

Desarrollar un sistema completo para gestionar torneos deportivos que soporte múltiples deportes simultáneamente, con fases de grupos, eliminatorias, clasificaciones, estadísticas detalladas y generación automática de fixtures. El sistema debe manejar equipos, jugadores, partidos, resultados y rankings en tiempo real.

**Dificultad:** ⭐⭐⭐⭐⭐  
**Tiempo estimado:** 12-15 horas  
**Conceptos clave:** Map para tablas de posiciones, List para fixtures, TreeSet para rankings, algoritmos de torneo

---

## Objetivos de Aprendizaje

- Usar **TreeMap** para mantener tablas de posiciones ordenadas automáticamente
- Aplicar **LinkedHashMap** para preservar orden de fixtures generados
- Implementar **Map&lt;Equipo, List&lt;Partido&gt;&gt;** para historial
- Utilizar **TreeSet** con Comparator personalizado para rankings
- Crear algoritmos de **generación de fixtures** (round-robin, eliminación directa)
- Usar **PriorityQueue** para próximos partidos por fecha
- Aplicar **Set operations** para verificar disponibilidad de equipos

---

## Estructura de Clases

### 1. Enum `TipoDeporte`

Define los deportes soportados.

**Valores:**

- FUTBOL
- BASQUET
- VOLEY
- TENIS
- FUTBOL_SALA

### 2. Enum `FaseTorneo`

Define las fases del torneo.

**Valores:**

- FASE_GRUPOS
- OCTAVOS_FINAL
- CUARTOS_FINAL
- SEMIFINAL
- TERCER_PUESTO
- FINAL

### 3. Clase `Jugador`

Representa un jugador individual.

**Atributos:**

- id: String (único, formato "JUG-001")
- nombre: String
- apellido: String
- numero: int (dorsal/número)
- posicion: String (depende del deporte)
- fechaNacimiento: LocalDate
- nacionalidad: String
- estadisticas: Map&lt;String, Integer&gt; (goles, asistencias, tarjetas, etc.)

**Métodos importantes:**

- getEdad()
- agregarEstadistica(String tipo, int cantidad)
- getEstadistica(String tipo)
- getNombreCompleto()
- equals() y hashCode() basados en id
- toString()

### 4. Clase `Equipo`

Representa un equipo deportivo.

**Atributos:**

- id: String (único, formato "EQU-001")
- nombre: String
- ciudad: String
- entrenador: String
- añoFundacion: int
- jugadores: List&lt;Jugador&gt;
- coloresUniforme: Set&lt;String&gt;

**Métodos importantes:**

- agregarJugador(Jugador)
- removerJugador(Jugador)
- buscarJugadorPorNumero(int)
- getJugadoresPorPosicion(String)
- getCantidadJugadores()
- equals() y hashCode() basados en id
- toString()

### 5. Clase `Partido`

Representa un encuentro deportivo.

**Atributos:**

- id: String (único, formato "PAR-001")
- equipoLocal: Equipo
- equipoVisitante: Equipo
- fecha: LocalDateTime
- fase: FaseTorneo
- deporte: TipoDeporte
- puntosLocal: int
- puntosVisitante: int
- estadoPartido: String (Programado, EnCurso, Finalizado, Suspendido)
- estadisticasPartido: Map&lt;String, Object&gt; (goleadores, tarjetas, etc.)
- penales: boolean (para desempate)
- penalesLocal: int
- penalesVisitante: int

**Métodos importantes:**

- jugarPartido(int puntosLocal, int puntosVisitante)
- getGanador() retorna Equipo o null si empate
- hayEmpate()
- esPartidoFinalizado()
- registrarEstadistica(String tipo, Object valor)
- toString() con resultado
- equals() y hashCode() basados en id

### 6. Clase `Grupo`

Representa un grupo en fase de grupos.

**Atributos:**

- nombre: String ("Grupo A", "Grupo B", etc.)
- equipos: Set&lt;Equipo&gt;
- partidos: List&lt;Partido&gt;
- tablaPos posiciones: TreeMap&lt;Equipo, EstadisticaEquipo&gt; (ordenada automáticamente)

**Métodos importantes:**

- agregarEquipo(Equipo)
- generarFixture() crea partidos round-robin
- registrarResultado(Partido)
- actualizarTabla()
- getTablaOrdenada() retorna List ordenada por puntos
- getClasificados(int cantidad) retorna top N equipos
- toString() con tabla de posiciones

### 7. Clase `EstadisticaEquipo`

Estadísticas de un equipo en el torneo.

**Atributos:**

- equipo: Equipo
- partidosJugados: int
- ganados: int
- empatados: int
- perdidos: int
- puntosAFavor: int (goles/puntos anotados)
- puntosEnContra: int
- puntos: int (3 por victoria, 1 por empate)
- diferenciaGoles: int

**Métodos importantes:**

- registrarVictoria(int aFavor, int enContra)
- registrarEmpate(int aFavor, int enContra)
- registrarDerrota(int aFavor, int enContra)
- calcularDiferenciaGoles()
- calcularPuntos()
- compareTo() para ordenar por: puntos → diferencia → aFavor
- toString() formato tabla

### 8. Clase `Eliminatoria`

Representa la fase de eliminación directa.

**Atributos:**

- fase: FaseTorneo
- partidos: List&lt;Partido&gt;
- equiposClasificados: Set&lt;Equipo&gt;

**Métodos importantes:**

- agregarPartido(Partido)
- getGanadores() retorna equipos que avanzan
- todosPartidosFinalizados()
- generarSiguienteFase() retorna nueva Eliminatoria

### 9. Clase `Torneo`

Clase principal que gestiona todo el torneo.

**Atributos:**

- id: String (único, formato "TOR-001")
- nombre: String
- añ o: int
- deporte: TipoDeporte
- equiposParticipantes: Set&lt;Equipo&gt;
- grupos: List&lt;Grupo&gt;
- faseActual: FaseTorneo
- eliminatorias: Map&lt;FaseTorneo, Eliminatoria&gt;
- todosLosPartidos: List&lt;Partido&gt; (ordenados cronológicamente)
- campeon: Equipo (null hasta que finaliza)
- subcampeon: Equipo

**Métodos importantes:**

- agregarEquipo(Equipo)
- crearFaseGrupos(int cantidadGrupos)
- generarFixtureCompleto()
- avanzarSiguienteFase()
- registrarResultado(Partido)
- getTablaGeneral() todos los equipos ordenados
- getProximosPartidos(int cantidad)
- getPartidosPorFecha(LocalDate)
- getPartidosPorEquipo(Equipo)
- generarEstadisticas() reporte completo
- getGoleadoresDelTorneo() top scorers
- finalizarTorneo()

### 10. Clase `GestorTorneos`

Gestiona múltiples torneos.

**Atributos:**

- torneos: Map&lt;String, Torneo&gt;
- equiposRegistrados: Map&lt;String, Equipo&gt;
- jugadoresRegistrados: Map&lt;String, Jugador&gt;

**Métodos importantes:**

- crearTorneo(Torneo)
- registrarEquipo(Equipo)
- registrarJugador(Jugador)
- buscarTorneoPorNombre(String)
- listarTorneosActivos()
- listarTorneosPorDeporte(TipoDeporte)
- generarRankingHistorico() basado en campeonatos ganados
- buscarPartidosPorFecha(LocalDate) en todos los torneos

---

## Funcionalidades Requeridas

### Gestión de Equipos y Jugadores

1. Registrar equipos con información completa
2. Agregar jugadores a equipos
3. Buscar jugadores por nombre, número o posición
4. Actualizar estadísticas de jugadores
5. Transferir jugadores entre equipos
6. Validar número mínimo de jugadores por equipo

### Creación de Torneos

1. Crear torneo especificando deporte y formato
2. Inscribir equipos participantes
3. Validar número de equipos (potencia de 2 para eliminatorias puras)
4. Configurar fase de grupos (cantidad de grupos)
5. Establecer fechas de inicio y fin

### Generación de Fixtures

1. **Fase de Grupos (Round-Robin)**: Cada equipo juega contra todos los del grupo
2. **Eliminación Directa**: Generación automática de llaves
3. **Sistema Mixto**: Grupos + eliminatorias
4. Distribuir partidos en fechas evitando conflictos
5. Respetar reglas específicas del deporte

### Registro de Resultados

1. Ingresar resultado de partido (puntos por equipo)
2. Actualizar tabla de posiciones automáticamente
3. Registrar estadísticas del partido (goleadores, tarjetas, etc.)
4. Determinar ganador con reglas de desempate
5. Manejar empates en eliminatorias (penales, tiempo extra)

### Clasificación y Avance

1. Determinar clasificados de fase de grupos
2. Emparejar equipos para eliminatorias
3. Avanzar ganadores a siguiente ronda
4. Generar partido por tercer puesto
5. Declarar campeón y subcampeón

### Consultas y Estadísticas

1. Tabla de posiciones de grupo
2. Tabla general de todo el torneo
3. Clasificados a siguientes fases
4. Goleadores/Máximos anotadores
5. Equipos con mejor defensa
6. Equipos con mejor ataque
7. Partidos de un equipo específico
8. Próximos partidos programados
9. Historial de enfrentamientos entre equipos

### Rankings y Reportes

1. Ranking de equipos por puntos
2. Estadísticas de jugadores (goles, asistencias)
3. Comparación entre equipos
4. Evolución del torneo (gráficos ASCII)
5. Reporte final con campeón y estadísticas

---

## Reglas de Negocio

1. **Puntuación en Grupos**:
   - Victoria: 3 puntos
   - Empate: 1 punto
   - Derrota: 0 puntos
2. **Criterios de Desempate en Grupos**:
   1. Mayor cantidad de puntos
   2. Mejor diferencia de goles
   3. Mayor cantidad de goles a favor
   4. Resultado directo entre equipos empatados
3. **Eliminatorias**: No hay empates, resolver con tiempo extra o penales
4. **Mínimo de Jugadores**: Varía por deporte (fútbol: 11, básquet: 5, etc.)
5. **Formato de Grupos**: Equipos distribuidos equitativamente
6. **Fechas**: No puede haber dos partidos del mismo equipo el mismo día
7. **Estadísticas**: Se actualizan en tiempo real al registrar resultados

---

## Casos de Prueba

### Prueba 1: Creación de Torneo con Grupos

1. Crear torneo de fútbol con 16 equipos
2. Dividir en 4 grupos de 4 equipos
3. Generar fixture de fase de grupos (round-robin)
4. Verificar que cada equipo juegue 3 partidos
5. Validar que no haya partidos duplicados

### Prueba 2: Registro de Resultados y Tablas

1. Simular todos los partidos de un grupo
2. Registrar resultados variados (victorias, empates)
3. Verificar actualización automática de tabla
4. Comprobar ordenamiento por puntos y criterios de desempate
5. Identificar los 2 clasificados del grupo

### Prueba 3: Fase Eliminatoria

1. Clasificar 8 equipos de fase de grupos
2. Generar cuadro de cuartos de final
3. Simular partidos de cuartos
4. Generar semifinales con ganadores
5. Simular final y tercer puesto

### Prueba 4: Estadísticas de Jugadores

1. Registrar goles de diferentes jugadores
2. Mantener tabla de goleadores actualizada
3. Calcular promedios de gol por partido
4. Identificar jugador más valioso
5. Generar reporte de estadísticas individuales

### Prueba 5: Torneo Completo

1. Crear torneo desde cero
2. Ejecutar todas las fases (grupos + eliminatorias)
3. Registrar todos los resultados
4. Determinar campeón y subcampeón
5. Generar reporte final completo

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== GESTOR DE TORNEOS DEPORTIVOS ===

1. Gestión de Equipos y Jugadores
   1.1. Registrar equipo
   1.2. Registrar jugador
   1.3. Agregar jugador a equipo
   1.4. Ver plantilla de equipo
   1.5. Actualizar estadísticas jugador

2. Gestión de Torneos
   2.1. Crear nuevo torneo
   2.2. Inscribir equipo en torneo
   2.3. Configurar fase de grupos
   2.4. Generar fixture completo
   2.5. Ver información del torneo

3. Registro de Resultados
   3.1. Registrar resultado de partido
   3.2. Ver partidos pendientes
   3.3. Ver partidos finalizados
   3.4. Registrar estadísticas del partido
   3.5. Modificar resultado (antes de avanzar fase)

4. Consultas y Tablas
   4.1. Ver tabla de posiciones (grupo)
   4.2. Ver tabla general
   4.3. Ver clasificados a siguientes fases
   4.4. Ver fixture completo
   4.5. Próximos partidos
   4.6. Partidos por equipo
   4.7. Partidos por fecha

5. Estadísticas
   5.1. Goleadores del torneo
   5.2. Equipos goleadores
   5.3. Equipos con mejor defensa
   5.4. Diferencia de goles
   5.5. Estadísticas de equipo específico
   5.6. Estadísticas de jugador

6. Avance de Fases
   6.1. Finalizar fase de grupos
   6.2. Generar eliminatorias
   6.3. Avanzar a siguiente ronda
   6.4. Ver cuadro eliminatorio
   6.5. Finalizar torneo

7. Reportes
   7.1. Reporte completo del torneo
   7.2. Historial de enfrentamientos
   7.3. Evolución de equipos
   7.4. Exportar resultados

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Algoritmo de Balanceo**: Distribuir equipos en grupos balanceando fuerza
2. **Predicción de Resultados**: Sistema básico basado en historial
3. **Sistema de Ranking ELO**: Implementar puntuación ELO para equipos
4. **Calendario Inteligente**: Optimizar fechas minimizando viajes
5. **Simulación Monte Carlo**: Simular todo el torneo para predecir probabilidades
6. **Soporte Multi-Idioma**: Nombres traducidos de equipos y reportes

### Mejoras Técnicas

1. Usar TreeSet con Comparator para mantener ranking actualizado automáticamente
2. Implementar caché de estadísticas calculadas
3. Usar PriorityQueue para gestionar próximos partidos por fecha
4. Implementar índices secundarios para búsquedas rápidas
5. Usar EnumMap para estadísticas por fase
6. Implementar patrón Observer para actualizar tablas automáticamente

---

## Ejemplo de Salida

```bash
=== COPA AMÉRICA 2025 - FÚTBOL ===

--- FASE DE GRUPOS - GRUPO A ---
Pos | Equipo         | PJ | G | E | P | GF | GC | Dif | Pts
----|----------------|----| --| --| --|----|----|-----|----
 1  | Argentina      |  3 | 3 | 0 | 0 | 8  | 1  | +7  | 9  ✓
 2  | Uruguay        |  3 | 2 | 0 | 1 | 5  | 3  | +2  | 6  ✓
 3  | Chile          |  3 | 1 | 0 | 2 | 3  | 5  | -2  | 3
 4  | Perú           |  3 | 0 | 0 | 3 | 1  | 8  | -7  | 0

✓ = Clasificados a cuartos de final

--- RESULTADOS GRUPO A ---
Fecha 1:
  Argentina 3 - 0 Perú
  Uruguay 2 - 1 Chile

Fecha 2:
  Argentina 2 - 1 Uruguay
  Chile 1 - 0 Perú

Fecha 3:
  Argentina 3 - 0 Chile
  Uruguay 2 - 1 Perú

--- CUADRO DE ELIMINATORIAS ---

CUARTOS DE FINAL:
  QF1: Argentina vs Ecuador (25/06 - 20:00)
  QF2: Brasil vs Uruguay (25/06 - 23:00)
  QF3: Colombia vs Chile (26/06 - 20:00)
  QF4: México vs Paraguay (26/06 - 23:00)

SEMIFINALES:
  SF1: Ganador QF1 vs Ganador QF2 (29/06 - 20:00)
  SF2: Ganador QF3 vs Ganador QF4 (29/06 - 23:00)

TERCER PUESTO:
  Perdedor SF1 vs Perdedor SF2 (02/07 - 18:00)

FINAL:
  Ganador SF1 vs Ganador SF2 (02/07 - 21:00)

--- TABLA DE GOLEADORES ---
Pos | Jugador              | Equipo      | Goles | Partidos
----|----------------------|-------------|-------|----------
 1  | Lionel Messi         | Argentina   |   5   |    5
 2  | Luis Suárez          | Uruguay     |   4   |    5
 3  | Neymar Jr            | Brasil      |   4   |    4
 4  | James Rodríguez      | Colombia    |   3   |    5
 5  | Alexis Sánchez       | Chile       |   2   |    4

--- ESTADÍSTICAS DEL TORNEO ---
Total de partidos: 24
Goles totales: 56
Promedio goles/partido: 2.33
Tarjetas amarillas: 45
Tarjetas rojas: 3
Equipo más goleador: Argentina (8 goles en fase grupos)
Mejor defensa: Brasil (1 gol en contra en fase grupos)
Partido con más goles: Brasil 4 - 2 Venezuela (6 goles)

🏆 CAMPEÓN: [Pendiente - Final el 02/07]
🥈 SUBCAMPEÓN: [Pendiente]
🥉 TERCER PUESTO: [Pendiente]
```

---

## 🎓 Conceptos Clave a Aplicar

1. **TreeMap para Tablas**: Mantener equipos ordenados automáticamente con Comparator
2. **LinkedHashMap para Fixtures**: Preservar orden de generación de partidos
3. **Set para Equipos**: Garantizar unicidad y operaciones de conjunto
4. **List Ordenada**: Mantener partidos ordenados cronológicamente
5. **Map&lt;Equipo, EstadisticaEquipo&gt;**: Acceso O(1) a estadísticas
6. **Comparator Complejo**: Ordenar por múltiples criterios (puntos, diferencia, goles)
7. **EnumMap**: Eficiente para mapear fases del torneo
8. **PriorityQueue**: Mantener próximos partidos ordenados por fecha

---

## Notas Técnicas

- **Algoritmo Round-Robin**: Generar todos los emparejamientos posibles
- **Fórmula**: n equipos → n(n-1)/2 partidos en round-robin
- **Eliminatorias**: Número de equipos debe ser potencia de 2 (8, 16, 32)
- **Comparator para Tabla**: Implementar todos los criterios de desempate
- **Actualizaciones**: Usar métodos que actualicen múltiples estructuras simultáneamente
- **Validaciones**: Verificar que fase anterior esté completa antes de avanzar
- **Performance**: Indexar partidos por equipo para búsquedas rápidas

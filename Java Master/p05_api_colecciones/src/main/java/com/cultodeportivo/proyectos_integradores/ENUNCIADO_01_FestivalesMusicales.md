# Proyecto 01 - Sistema de Gestión de Festivales Musicales

## Descripción General

Desarrollar un sistema completo para gestionar festivales de música que permita administrar artistas, escenarios, horarios de presentaciones, venta de entradas y generar estadísticas. El sistema debe manejar múltiples festivales simultáneamente y permitir a los asistentes consultar la programación.

**Dificultad:** ⭐⭐⭐  
**Tiempo estimado:** 8-10 horas  
**Conceptos clave:** List para programación, Set para artistas únicos, Map para entradas, Comparable/Comparator

---

## Objetivos de Aprendizaje

- Usar **ArrayList** para listas ordenadas de eventos y presentaciones
- Aplicar **HashSet** para garantizar unicidad de artistas y asistentes
- Implementar **HashMap** para gestión de entradas por festival y escenario
- Crear **TreeSet** para rankings de artistas por popularidad
- Utilizar **Comparable** para ordenamiento natural de presentaciones por hora
- Implementar **Comparator** para múltiples criterios de ordenamiento
- Usar **LinkedHashMap** para mantener orden de inserción en horarios

---

## Estructura de Clases

### 1. Clase `Artista`

Representa un artista o banda musical.

**Atributos:**

- id: String (único, formato "ART-001")
- nombre: String
- generoMusical: String (Rock, Pop, Electrónica, Hip-Hop, etc.)
- paisOrigen: String
- añosActivo: int
- numeroSeguidores: int
- cachePresentacion: double (costo de contratación)

**Métodos importantes:**

- equals() y hashCode() basados en el id
- compareTo() para ordenar por número de seguidores (descendente)
- toString() descriptivo

### 2. Clase `Escenario`

Representa un escenario del festival.

**Atributos:**

- nombre: String (Principal, Alternativo, Electrónico, etc.)
- capacidad: int
- ubicacion: String
- tieneEquipoSonido: boolean
- tieneEquipoLuces: boolean

**Métodos importantes:**

- equals() y hashCode() basados en el nombre
- toString() descriptivo

### 3. Clase `Presentacion`

Representa una presentación de un artista en un horario específico.

**Atributos:**

- artista: Artista
- escenario: Escenario
- fechaHora: LocalDateTime
- duracionMinutos: int
- asistentesEsperados: int
- asistentesReales: int (inicialmente 0, se actualiza después del show)

**Métodos importantes:**

- getHoraFin() que calcula la hora de finalización
- equals() basado en escenario y fechaHora (no puede haber dos shows al mismo tiempo en el mismo escenario)
- hashCode() consistente con equals()
- compareTo() para ordenar por fecha y hora
- toString() con formato legible

### 4. Clase `Entrada`

Representa un boleto para asistir al festival.

**Atributos:**

- numeroEntrada: String (único, formato "ENT-FES001-00123")
- tipoEntrada: String (General, VIP, Backstage)
- precio: double
- fechaCompra: LocalDate
- nombreComprador: String
- emailComprador: String

**Métodos importantes:**

- equals() y hashCode() basados en numeroEntrada
- toString() con formato de ticket

### 5. Clase `Festival`

Representa un festival de música completo.

**Atributos:**

- id: String (único, formato "FES-001")
- nombre: String
- ciudad: String
- fechaInicio: LocalDate
- fechaFin: LocalDate
- escenarios: List&lt;Escenario&gt;
- presentaciones: List&lt;Presentacion&gt; (ordenada por fecha/hora)
- artistasParticipantes: Set&lt;Artista&gt; (unicidad garantizada)
- entradasVendidas: List&lt;Entrada&gt;
- capacidadTotal: int

**Métodos importantes:**

- agregarEscenario(Escenario)
- programarPresentacion(Presentacion) validando conflictos de horario
- verificarDisponibilidadEscenario(Escenario, LocalDateTime, int duracion)
- venderEntrada(Entrada)
- getEntradasDisponibles()
- getPresentacionesPorEscenario(Escenario)
- getPresentacionesPorArtista(Artista)
- getPresentacionesPorDia(LocalDate)
- getArtistasMasPopulares(int top) usando TreeSet
- calcularIngresoTotal()
- generarProgramacion() retorna String con horarios formateados

### 6. Clase `GestorFestivales`

Clase principal que gestiona múltiples festivales.

**Atributos:**

- festivales: Map&lt;String, Festival&gt; (clave: id del festival)
- artistasRegistrados: Map&lt;String, Artista&gt; (catálogo global de artistas)
- entradas: Map&lt;String, Entrada&gt; (todas las entradas por número)
- estadisticasGeneros: Map&lt;String, Integer&gt; (contador de presentaciones por género)

**Métodos importantes:**

- registrarArtista(Artista)
- buscarArtistaPorNombre(String nombre) retorna List&lt;Artista&gt; con búsqueda parcial
- buscarArtistasPorGenero(String genero)
- crearFestival(Festival)
- buscarFestival(String id)
- listarFestivalesPorCiudad(String ciudad)
- listarFestivalesActivos() festivales en curso o futuros
- generarRankingArtistas() basado en número de presentaciones
- obtenerEstadisticasPorGenero()
- buscarEntrada(String numero)
- validarEntrada(String numero) para ingreso al festival

---

## Funcionalidades Requeridas

### Gestión de Artistas

1. Registrar artistas en el sistema con validación de datos
2. Buscar artistas por nombre (búsqueda parcial, case-insensitive)
3. Filtrar artistas por género musical
4. Obtener ranking de artistas por popularidad (seguidores)
5. Actualizar información de artistas (seguidores, años activo)

### Gestión de Festivales

1. Crear festivales con fechas, ciudad y capacidad
2. Agregar escenarios a un festival
3. Programar presentaciones validando:
   - El escenario está libre en ese horario
   - No hay solapamiento con otras presentaciones
   - La fecha está dentro del rango del festival
4. Consultar programación completa del festival
5. Filtrar presentaciones por escenario, artista o día
6. Calcular ingresos totales del festival

### Venta de Entradas

1. Vender entradas con tipos (General, VIP, Backstage) y precios diferentes
2. Generar número único de entrada
3. Validar disponibilidad antes de vender
4. Consultar entradas vendidas por festival
5. Buscar entrada por número para validación de ingreso
6. Calcular porcentaje de ocupación del festival

### Estadísticas y Reportes

1. Géneros musicales más representados en el festival
2. Artistas con más presentaciones programadas
3. Escenarios más utilizados
4. Ingresos por tipo de entrada
5. Día con más presentaciones programadas
6. Presentaciones con mayor asistencia esperada

### Ordenamiento

Implementar diferentes criterios de ordenamiento usando Comparator:

1. Artistas por nombre (alfabético)
2. Artistas por género y luego por seguidores
3. Presentaciones por escenario y luego por hora
4. Festivales por fecha de inicio
5. Entradas por fecha de compra

---

## Reglas de Negocio

1. **Unicidad de Artistas**: No puede haber dos artistas con el mismo id en el sistema
2. **Conflictos de Horario**: Un artista no puede tener dos presentaciones simultáneas
3. **Disponibilidad de Escenarios**: Un escenario solo puede tener una presentación a la vez
4. **Capacidad del Festival**: No se pueden vender más entradas que la capacidad total
5. **Fechas Válidas**: Las presentaciones deben estar dentro del rango de fechas del festival
6. **Precios de Entradas**:
   - General: precio base
   - VIP: precio base × 2.5
   - Backstage: precio base × 4
7. **Duración Mínima**: Las presentaciones deben durar al menos 30 minutos
8. **Cambio de Horario**: Al reprogramar, validar nuevamente disponibilidad

---

## Casos de Prueba

### Prueba 1: Registro y Búsqueda de Artistas

1. Registrar 10 artistas de diferentes géneros
2. Buscar artistas por nombre parcial (ej: "The")
3. Filtrar artistas de género "Rock"
4. Obtener top 5 artistas más populares
5. Verificar que no se pueden registrar artistas duplicados

### Prueba 2: Creación y Programación de Festival

1. Crear un festival de 3 días con 4 escenarios
2. Programar 20 presentaciones en diferentes horarios
3. Intentar programar presentación con conflicto de horario (debe fallar)
4. Consultar programación completa ordenada por hora
5. Filtrar presentaciones del Escenario Principal

### Prueba 3: Venta de Entradas

1. Vender 50 entradas generales
2. Vender 20 entradas VIP
3. Vender 5 entradas Backstage
4. Verificar que se respeta la capacidad máxima
5. Buscar una entrada por número y validarla

### Prueba 4: Estadísticas

1. Generar ranking de artistas por número de presentaciones
2. Obtener distribución de géneros musicales
3. Calcular ingreso total del festival
4. Identificar el día con más presentaciones
5. Listar escenarios ordenados por número de shows

### Prueba 5: Múltiples Festivales

1. Crear 3 festivales en diferentes ciudades
2. Programar artistas en múltiples festivales
3. Buscar festivales por ciudad
4. Listar todos los festivales activos
5. Comparar ingresos entre festivales

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== SISTEMA DE GESTIÓN DE FESTIVALES MUSICALES ===

1. Gestión de Artistas
   1.1. Registrar nuevo artista
   1.2. Buscar artista por nombre
   1.3. Listar artistas por género
   1.4. Ver ranking de artistas
   1.5. Actualizar datos de artista

2. Gestión de Festivales
   2.1. Crear nuevo festival
   2.2. Agregar escenario a festival
   2.3. Programar presentación
   2.4. Ver programación completa
   2.5. Ver programación por escenario
   2.6. Ver programación por día

3. Venta de Entradas
   3.1. Vender entrada
   3.2. Buscar entrada
   3.3. Validar entrada (ingreso)
   3.4. Ver entradas disponibles
   3.5. Ver entradas vendidas

4. Estadísticas y Reportes
   4.1. Géneros más representados
   4.2. Artistas con más shows
   4.3. Ingresos del festival
   4.4. Ocupación por escenario
   4.5. Día más activo

5. Búsqueda Avanzada
   5.1. Buscar festivales por ciudad
   5.2. Buscar presentaciones de artista
   5.3. Festivales activos
   5.4. Próximas presentaciones (24 horas)

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Sistema de Recomendaciones**: Sugerir artistas similares basándose en género y seguidores
2. **Detección de Conflictos**: Validar que un artista tenga tiempo para trasladarse entre escenarios
3. **Optimización de Horarios**: Algoritmo para maximizar asistencia evitando solapamiento de artistas populares
4. **Sistema de Favoritos**: Permitir que cada asistente marque sus artistas favoritos y generar itinerario personalizado
5. **Exportación**: Generar archivo CSV con la programación completa
6. **Estadísticas Avanzadas**: Calcular promedio de asistencia por género musical

### Mejoras Técnicas

1. Implementar Comparator para ordenar presentaciones por múltiples criterios simultáneamente
2. Usar LinkedHashMap para mantener orden de inserción en programación por día
3. Implementar caché de búsquedas frecuentes usando Map
4. Crear un Iterator personalizado para recorrer presentaciones por escenario
5. Usar Collections.unmodifiableList() para exponer colecciones sin permitir modificaciones externas

---

## Ejemplo de Salida

```bash
=== FESTIVAL LOLLAPALOOZA 2025 ===
Ciudad: Santiago, Chile
Fechas: 15-17 de Marzo, 2025
Escenarios: 4 | Capacidad Total: 100,000

--- PROGRAMACIÓN DÍA 1 (15-MAR-2025) ---

ESCENARIO PRINCIPAL:
  16:00 - 17:30 | Imagine Dragons (Rock) - 1500 asistentes esperados
  18:00 - 19:30 | Arctic Monkeys (Rock) - 2000 asistentes esperados
  20:00 - 22:00 | The Weeknd (Pop) - 3000 asistentes esperados

ESCENARIO ELECTRÓNICO:
  15:00 - 16:30 | Martin Garrix (Electrónica) - 1000 asistentes esperados
  17:00 - 18:30 | Alesso (Electrónica) - 1200 asistentes esperados
  19:00 - 21:00 | David Guetta (Electrónica) - 2500 asistentes esperados

ESTADÍSTICAS:
- Entradas vendidas: 85,340 / 100,000 (85.3%)
  * General: 60,000 ($50 c/u) = $3,000,000
  * VIP: 20,000 ($125 c/u) = $2,500,000
  * Backstage: 5,340 ($200 c/u) = $1,068,000
- Ingreso Total: $6,568,000
- Géneros representados: Rock (8), Pop (6), Electrónica (12), Hip-Hop (4)
- Artista más popular: The Weeknd (45M seguidores)
```

---

## 🎓 Conceptos Clave a Aplicar

1. **ArrayList vs LinkedList**: Usar ArrayList para programaciones (acceso frecuente por índice), LinkedList para cola de entrada
2. **HashSet para Unicidad**: Garantizar que un artista no se registre dos veces
3. **HashMap para Búsqueda Rápida**: Acceso O(1) a festivales y artistas por id
4. **TreeSet para Rankings**: Mantener artistas ordenados automáticamente por popularidad
5. **Comparable en Presentacion**: Ordenamiento natural por fecha/hora
6. **Multiple Comparators**: Ordenar artistas por diferentes criterios según necesidad
7. **LinkedHashMap**: Mantener orden de inserción en horarios por día
8. **equals() y hashCode()**: Correcta implementación para usar en Sets y Maps

---

## Notas Técnicas

- Usar **LocalDateTime** para fechas y horas de presentaciones
- Implementar validaciones robustas en todos los métodos de inserción
- Considerar usar **Collections.sort()** con Comparators personalizados
- Manejar casos especiales: festivales sin presentaciones, búsquedas sin resultados
- Validar que los escenarios no se solapen en tiempo
- Generar números únicos de entrada usando UUID o contador secuencial
- Formatear salidas de forma clara y profesional

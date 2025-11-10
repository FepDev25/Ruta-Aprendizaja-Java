# Proyecto 07 - Sistema de Inventario de Videojuegos con Estadísticas

## Descripción General

Desarrollar un sistema completo para gestionar una colección personal de videojuegos con estadísticas detalladas, rankings dinámicos, sistema de logros, tiempo de juego, categorización múltiple y recomendaciones basadas en preferencias. El sistema debe permitir búsquedas complejas y generar análisis exhaustivos de la biblioteca personal.

**Dificultad:** ⭐⭐⭐⭐  
**Tiempo estimado:** 10-12 horas  
**Conceptos clave:** Map para categorización, TreeSet para rankings, estadísticas complejas, múltiples criterios de ordenamiento

---

## Objetivos de Aprendizaje

- Usar **Map&lt;Categoria, Set&lt;Videojuego&gt;&gt;** para categorización múltiple
- Aplicar **TreeSet con Comparator** para rankings dinámicos
- Implementar **Map de estadísticas** por juego
- Utilizar **LinkedHashMap** para historial de sesiones
- Crear **filtros complejos** combinando múltiples colecciones
- Usar **Comparator múltiple** para ordenar por varios criterios
- Aplicar **agregaciones** y cálculos estadísticos

---

## Estructura de Clases

### 1. Enum `Plataforma`

**Valores:**

- PC, PLAYSTATION_5, PLAYSTATION_4, XBOX_SERIES, XBOX_ONE, NINTENDO_SWITCH, STEAM, EPIC_GAMES, MOBILE

### 2. Enum `Genero`

**Valores:**

- ACCION, AVENTURA, RPG, ESTRATEGIA, DEPORTES, CARRERAS, SIMULACION, TERROR, PUZZLE, PLATAFORMAS, SHOOTER, LUCHA, MUSICAL

### 3. Enum `EstadoJuego`

**Valores:**

- NO_JUGADO, JUGANDO, COMPLETADO, ABANDONADO, PLATINADO_100

### 4. Clase `Videojuego`

Representa un videojuego en la colección.

**Atributos:**

- id: String (único, formato "VJ-001")
- titulo: String
- desarrolladora: String
- publicadora: String
- añoLanzamiento: int
- generos: Set&lt;Genero&gt; (puede tener múltiples géneros)
- plataformas: Set&lt;Plataforma&gt; (disponible en múltiples plataformas)
- metacriticScore: int (0-100)
- precioCompra: double
- fechaCompra: LocalDate
- horasJugadas: double
- estado: EstadoJuego
- valoracionPersonal: double (1-10)
- notasPersonales: String

**Métodos importantes:**

- agregarGenero(Genero)
- agregarPlataforma(Plataforma)
- actualizarEstado(EstadoJuego)
- agregarHorasJugadas(double)
- calcularValorPorHora() precio / horasJugadas
- esRecomendable() basado en valoración y horas
- equals() y hashCode() basados en id
- toString()

### 5. Clase `Logro`

Representa un logro/trofeo del juego.

**Atributos:**

- nombre: String
- descripcion: String
- esOculto: boolean
- puntos: int
- desbloqueado: boolean
- fechaDesbloqueo: LocalDateTime
- rareza: String (Común, Poco común, Raro, Muy raro, Ultra raro)
- porcentajeJugadores: double (% que lo ha desbloqueado)

**Métodos importantes:**

- desbloquear()
- esRaro() retorna true si rareza es Raro o superior
- toString()

### 6. Clase `SesionJuego`

Registra una sesión de juego.

**Atributos:**

- videojuego: Videojuego
- fechaInicio: LocalDateTime
- fechaFin: LocalDateTime
- duracionMinutos: int
- logrosDesbloqueados: List&lt;Logro&gt;
- notasSesion: String

**Métodos importantes:**

- calcularDuracion()
- agregarLogro(Logro)
- toString()

### 7. Clase `EstadisticasJuego`

Estadísticas detalladas de un videojuego específico.

**Atributos:**

- videojuego: Videojuego
- sesiones: List&lt;SesionJuego&gt; (ordenadas cronológicamente)
- logros: Map&lt;String, Logro&gt; (nombre → logro)
- totalLogros: int
- logrosDesbloqueados: int
- porcentajeCompletado: double
- tiempoPromedioSesion: double
- rachaActual: int (días consecutivos jugando)
- rachaMasLarga: int

**Métodos importantes:**

- registrarSesion(SesionJuego)
- desbloquearLogro(String nombre)
- calcularPorcentajeCompletado()
- calcularTiempoPromedioSesion()
- actualizarRacha()
- getTiempoTotalJugado()
- getLogrosPorRareza(String rareza)
- getLogrosNoDesbloqueados()

### 8. Clase `Biblioteca`

Colección personal de videojuegos.

**Atributos:**

- usuario: String
- videojuegos: Map&lt;String, Videojuego&gt; (id → juego)
- estadisticas: Map&lt;String, EstadisticasJuego&gt; (id juego → estadísticas)
- juegosPorGenero: Map&lt;Genero, Set&lt;Videojuego&gt;&gt;
- juegosPorPlataforma: Map&lt;Plataforma, Set&lt;Videojuego&gt;&gt;
- juegosPorEstado: Map&lt;EstadoJuego, Set&lt;Videojuego&gt;&gt;
- historialSesiones: List&lt;SesionJuego&gt; (todas las sesiones)
- wishlist: List&lt;String&gt; (juegos deseados)

**Métodos importantes:**

- agregarJuego(Videojuego)
- eliminarJuego(String id)
- buscarPorTitulo(String) búsqueda parcial
- buscarPorGenero(Genero)
- buscarPorPlataforma(Plataforma)
- buscarPorEstado(EstadoJuego)
- filtrarPorMultiplesGeneros(Set&lt;Genero&gt;) intersección
- registrarSesion(SesionJuego)
- getJuegosMasJugados(int top)
- getJuegosMejorValorados(int top)
- getJuegosRecientes() últimas adquisiciones
- calcularValorTotal Biblioteca()
- calcularHorasTotales()
- generarResumen()

### 9. Clase `Ranking`

Genera rankings dinámicos de videojuegos.

**Atributos:**

- biblioteca: Biblioteca
- criterioActual: String

**Métodos importantes:**

- rankearPorHorasJugadas() retorna TreeSet
- rankearPorValoracion() retorna TreeSet
- rankearPorMetacritic() retorna TreeSet
- rankearPorFechaCompra() retorna TreeSet
- rankearPorValorPorHora() mejor inversión
- rankearPorCompletado() porcentaje de logros
- compararJuegos(Videojuego v1, Videojuego v2, String criterio)

### 10. Clase `Analizador`

Análisis avanzado de la biblioteca.

**Atributos:**

- biblioteca: Biblioteca

**Métodos importantes:**

- getDistribucionPorGenero() Map&lt;Genero, Integer&gt;
- getDistribucionPorPlataforma()
- getDistribucionPorAño()
- getDistribucionPorEstado()
- calcularTiempoPromedioParaCompletar()
- calcularGastoPorGenero()
- identificarGenerosPreferidos() basado en horas jugadas
- calcularEficienciaLogros() logros/hora
- getJuegosSubutilizados() poco jugados vs precio
- getJuegosAbandonados() detectar patrones
- generarReporte Completo()
- compararConPromedios() comparar con estadísticas globales

### 11. Clase `Recomendador`

Sistema de recomendaciones.

**Atributos:**

- biblioteca: Biblioteca

**Métodos importantes:**

- recomendarPorGenero() basado en géneros más jugados
- recomendarSimilares(Videojuego) mismos géneros/desarrolladora
- recomendarParaCompletar() juegos casi completados
- recomendarNuevosLanzamientos() por géneros preferidos
- recomendarPlataforma(Plataforma) juegos que podrías comprar
- sugerirProximoJuego() basado en estado y valoraciones

---

## Funcionalidades Requeridas

### Gestión de Biblioteca

1. Agregar videojuegos con información completa
2. Actualizar información de juegos existentes
3. Eliminar juegos de la colección
4. Agregar/actualizar valoración personal
5. Actualizar estado del juego
6. Registrar horas jugadas

### Búsquedas y Filtros

1. Buscar por título (búsqueda parcial)
2. Filtrar por género (único o múltiple)
3. Filtrar por plataforma
4. Filtrar por estado de juego
5. Filtrar por rango de años
6. Filtrar por valoración mínima
7. Filtros combinados (género + plataforma + estado)

### Sistema de Logros

1. Registrar logros de cada juego
2. Desbloquear logros con fecha
3. Calcular porcentaje de completado
4. Listar logros por rareza
5. Mostrar logros pendientes
6. Comparar con porcentaje global de jugadores

### Sesiones de Juego

1. Registrar sesión con inicio y fin
2. Calcular duración automáticamente
3. Asociar logros desbloqueados en sesión
4. Mantener historial de sesiones
5. Calcular tiempo promedio de sesión
6. Identificar rachas de juego

### Rankings Dinámicos

1. Top juegos más jugados
2. Top juegos mejor valorados personalmente
3. Top juegos por Metacritic
4. Mejor valor por hora (precio/horas)
5. Juegos más completados
6. Ordenar por múltiples criterios

### Estadísticas y Análisis

1. Distribución de juegos por género
2. Distribución por plataforma
3. Distribución por estado
4. Gasto total de la biblioteca
5. Horas totales jugadas
6. Valor promedio por hora
7. Géneros preferidos
8. Juegos abandonados
9. Juegos subutilizados
10. Eficiencia en logros

### Recomendaciones

1. Sugerir próximo juego a jugar
2. Recomendar basado en géneros favoritos
3. Juegos similares a uno específico
4. Juegos cerca de completar
5. Sugerir adquisiciones por plataforma

---

## Reglas de Negocio

1. **Múltiples Géneros**: Un juego puede pertenecer a varios géneros
2. **Múltiples Plataformas**: Un juego puede estar en varias plataformas
3. **Horas Jugadas**: Se acumulan con cada sesión registrada
4. **Estados**: Deben seguir lógica (No jugado → Jugando → Completado)
5. **Logros**: Solo se desbloquean una vez
6. **Valoración Personal**: 1-10 con decimales
7. **Valor por Hora**: precio / horasJugadas (infinito si horasJugadas = 0)
8. **Racha**: Días consecutivos con al menos una sesión
9. **Géneros Preferidos**: Top 3 géneros con más horas jugadas
10. **Juego Subutilizado**: Alto precio, pocas horas, comprado hace > 3 meses

---

## Casos de Prueba

### Prueba 1: Construcción de Biblioteca

1. Agregar 20 videojuegos de diferentes géneros y plataformas
2. Verificar categorización automática por género y plataforma
3. Actualizar estados de varios juegos
4. Agregar valoraciones personales
5. Calcular valor total de la biblioteca

### Prueba 2: Sesiones y Horas Jugadas

1. Registrar 10 sesiones de diferentes juegos
2. Verificar actualización de horas jugadas
3. Calcular tiempo promedio de sesión
4. Identificar juego más jugado
5. Calcular horas totales de la biblioteca

### Prueba 3: Sistema de Logros

1. Agregar 20 logros a un juego
2. Desbloquear 10 logros progresivamente
3. Calcular porcentaje de completado
4. Filtrar logros por rareza
5. Listar logros pendientes

### Prueba 4: Rankings Dinámicos

1. Generar ranking por horas jugadas
2. Generar ranking por valoración personal
3. Generar ranking por valor/hora
4. Comparar resultados de diferentes criterios
5. Verificar ordenamiento correcto con TreeSet

### Prueba 5: Análisis Completo

1. Generar distribución por género
2. Identificar géneros preferidos
3. Calcular gasto por género
4. Detectar juegos subutilizados
5. Generar reporte completo de la biblioteca

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== GESTOR DE BIBLIOTECA DE VIDEOJUEGOS ===

1. Gestión de Juegos
   1.1. Agregar juego
   1.2. Editar juego
   1.3. Eliminar juego
   1.4. Ver información detallada
   1.5. Actualizar valoración
   1.6. Cambiar estado

2. Búsqueda y Filtros
   2.1. Buscar por título
   2.2. Filtrar por género
   2.3. Filtrar por plataforma
   2.4. Filtrar por estado
   2.5. Filtrar por año
   2.6. Búsqueda avanzada (múltiples filtros)

3. Sesiones y Tiempo de Juego
   3.1. Registrar nueva sesión
   3.2. Ver historial de sesiones
   3.3. Sesiones por juego
   3.4. Calcular tiempo total jugado
   3.5. Ver racha actual

4. Logros y Completado
   4.1. Agregar logros a juego
   4.2. Desbloquear logro
   4.3. Ver logros del juego
   4.4. Porcentaje de completado
   4.5. Logros por rareza
   4.6. Logros pendientes

5. Rankings
   5.1. Top juegos más jugados
   5.2. Top mejor valorados
   5.3. Mejor valor por hora
   5.4. Más completados
   5.5. Por Metacritic score
   5.6. Adquisiciones recientes

6. Estadísticas
   6.1. Resumen de biblioteca
   6.2. Distribución por género
   6.3. Distribución por plataforma
   6.4. Distribución por estado
   6.5. Géneros preferidos
   6.6. Análisis financiero
   6.7. Juegos subutilizados

7. Recomendaciones
   7.1. Próximo juego a jugar
   7.2. Similares a un juego
   7.3. Juegos por completar
   7.4. Basadas en géneros favoritos

8. Wishlist
   8.1. Agregar a wishlist
   8.2. Ver wishlist
   8.3. Mover de wishlist a biblioteca

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Integración con API**: Obtener datos de IGDB o Metacritic
2. **Comparación Social**: Comparar biblioteca con amigos
3. **Predicción de Tiempo**: Estimar horas para completar
4. **Detección de Ofertas**: Alertar cuando juegos de wishlist están en oferta
5. **Análisis de Backlog**: Priorizar qué jugar basándose en múltiples factores
6. **Exportación**: Generar informe PDF o Excel

### Mejoras Técnicas

1. Usar EnumMap para estadísticas por género/plataforma
2. Implementar índices secundarios para búsquedas rápidas
3. Usar TreeSet con Comparator dinámico para rankings
4. Implementar caché de cálculos estadísticos costosos
5. Usar streams para filtros y agregaciones complejas
6. Implementar patrón Observer para actualizar rankings automáticamente

---

## Ejemplo de Salida

```bash
=== MI BIBLIOTECA DE VIDEOJUEGOS ===
Usuario: GameMaster2024
Juegos en colección: 156
Valor total: $4,235.50
Horas totales jugadas: 1,247 horas
Valor promedio por hora: $3.39

--- RESUMEN POR ESTADO ---
✅ Completados: 45 (28.8%)
🎮 Jugando: 12 (7.7%)
📦 No jugados (Backlog): 87 (55.8%)
🚫 Abandonados: 8 (5.1%)
🏆 Platinados/100%: 4 (2.6%)

--- TOP 10 JUEGOS MÁS JUGADOS ---
1. The Witcher 3 - 156h | ⭐ 9.5 | 🏆 85% completado
2. Elden Ring - 142h | ⭐ 9.8 | 🏆 72% completado
3. Red Dead Redemption 2 - 128h | ⭐ 9.0 | 🏆 65% completado
4. Cyberpunk 2077 - 89h | ⭐ 8.5 | 🏆 45% completado
5. Baldur's Gate 3 - 87h | ⭐ 10.0 | 🏆 91% completado
6. God of War - 65h | ⭐ 9.2 | 🏆 100% completado ✓
7. Spider-Man - 58h | ⭐ 8.8 | 🏆 100% completado ✓
8. Horizon Zero Dawn - 52h | ⭐ 8.7 | 🏆 78% completado
9. Ghost of Tsushima - 48h | ⭐ 9.3 | 🏆 82% completado
10. Days Gone - 45h | ⭐ 7.5 | 🏆 55% completado

--- MEJOR VALOR POR HORA ---
1. The Witcher 3: $0.19/hora (Compra: $29.99, 156h)
2. Terraria: $0.21/hora (Compra: $9.99, 47h)
3. Stardew Valley: $0.28/hora (Compra: $14.99, 53h)
4. Elden Ring: $0.42/hora (Compra: $59.99, 142h)
5. Hollow Knight: $0.45/hora (Compra: $14.99, 33h)

--- DISTRIBUCIÓN POR GÉNERO ---
🎯 RPG: 45 juegos (28.8%) - 542h jugadas
⚔️ Acción-Aventura: 38 juegos (24.4%) - 398h jugadas
🎮 Acción: 28 juegos (17.9%) - 187h jugadas
🧩 Puzzle/Plataformas: 18 juegos (11.5%) - 65h jugadas
🏃 Shooter: 15 juegos (9.6%) - 42h jugadas
⚡ Otros: 12 juegos (7.8%) - 13h jugadas

--- MIS GÉNEROS PREFERIDOS (por horas jugadas) ---
1. 🥇 RPG - 542 horas (43.4% del tiempo)
2. 🥈 Acción-Aventura - 398 horas (31.9%)
3. 🥉 Acción - 187 horas (15.0%)

--- JUEGOS SUBUTILIZADOS ⚠️ ---
Juegos caros que casi no has jugado:
1. Final Fantasy XVI - $69.99, 2h jugadas, comprado hace 4 meses
2. Starfield - $69.99, 5h jugadas, comprado hace 3 meses
3. Diablo IV - $69.99, 3h jugadas, comprado hace 6 meses

💡 Has gastado $209.97 en juegos que apenas has tocado.

--- PRÓXIMOS A COMPLETAR ---
Juegos que estás cerca de terminar:
1. Baldur's Gate 3 - 91% completado (87h jugadas)
   Logros pendientes: 3
   Estimado para 100%: 8 horas más

2. God of War Ragnarök - 88% completado (62h jugadas)
   Logros pendientes: 5
   Estimado para 100%: 10 horas más

--- RECOMENDACIÓN: PRÓXIMO JUEGO ---
Basándose en tus géneros favoritos y juegos mejor valorados:

🎯 Sugerencia: Persona 5 Royal
  ✓ Género: RPG (tu favorito)
  ✓ Desarrolladora: Atlus (similar a juegos que amas)
  ✓ Metacritic: 95
  ✓ Estado: No jugado (en tu backlog)
  ✓ Razón: Amaste Baldur's Gate 3 (10★), este tiene mecánicas similares

--- ESTADÍSTICAS DE LA SEMANA ---
Juegos jugados esta semana: 4
Tiempo total de juego: 18 horas
Logros desbloqueados: 7
Racha actual: 5 días consecutivos 🔥
Racha más larga: 12 días

--- SESIÓN MÁS RECIENTE ---
Elden Ring - Hoy, 20:30 a 23:45 (3h 15min)
Logros desbloqueados:
  🏆 "Radahn, el Azote" (Muy raro - 12.3% de jugadores)
  🏆 "Señor de las Estrellas" (Raro - 28.5% de jugadores)
```

---

## 🎓 Conceptos Clave a Aplicar

1. **Map de Categorización**: Map&lt;Genero, Set&lt;Videojuego&gt;&gt; para clasificación múltiple
2. **TreeSet con Comparator**: Rankings que se reordenan automáticamente
3. **EnumMap**: Eficiente para estadísticas por Genero/Plataforma/Estado
4. **Set de Géneros**: Permite juegos con múltiples géneros
5. **LinkedHashMap**: Mantener orden de sesiones
6. **Comparator Encadenado**: Ordenar por múltiples criterios (horas → valoración → título)
7. **Stream API**: Filtros complejos y agregaciones
8. **computeIfAbsent()**: Inicializar estructuras anidadas

---

## Notas Técnicas

- **Categorización Múltiple**: Un juego puede estar en múltiples Maps simultáneamente
- **Rankings Dinámicos**: Usar TreeSet que se reordena al cambiar datos
- **Valor por Hora**: Manejar división por cero (mostrar "No jugado" o "∞")
- **Filtros AND/OR**: Combinar filtros con intersección (AND) o unión (OR) de Sets
- **Cálculos Agregados**: Usar streams para sum(), average(), max(), min()
- **Comparator Compuesto**: Comparator.comparing().thenComparing().thenComparing()
- **Eficiencia**: Mantener índices secundarios para búsquedas frecuentes

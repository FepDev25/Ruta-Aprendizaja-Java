# Proyecto 03 - Sistema de Recomendación de Películas y Series

## Descripción General

Desarrollar una plataforma estilo Netflix que gestione un catálogo de películas y series, registre valoraciones de usuarios, genere recomendaciones personalizadas basadas en gustos similares y mantenga listas de reproducción personalizadas. El sistema debe usar algoritmos de similitud para sugerir contenido relevante.

**Dificultad:** ⭐⭐⭐⭐  
**Tiempo estimado:** 10-12 horas  
**Conceptos clave:** Map anidados, Set para intersecciones, List de favoritos, algoritmos de similitud

---

## Objetivos de Aprendizaje

- Usar **Map anidados** para estructura compleja: Map&lt;Usuario, Map&lt;Contenido, Valoración&gt;&gt;
- Aplicar **Set operations** (intersection, union) para encontrar usuarios similares
- Implementar **TreeMap** para rankings ordenados automáticamente
- Utilizar **LinkedHashMap** para historial de visualización ordenado
- Crear algoritmos de **similitud** usando colecciones
- Usar **Comparator** para ordenar por múltiples criterios (rating, popularidad, año)
- Aplicar **streams** para filtros complejos

---

## Estructura de Clases

### 1. Clase `Contenido` (abstracta)

Clase base para películas y series.

**Atributos:**

- id: String (único, formato "MOV-001" o "SER-001")
- titulo: String
- añoLanzamiento: int
- generos: Set&lt;String&gt; (Drama, Acción, Comedia, etc.)
- director: String
- actores: List&lt;String&gt;
- duracionMinutos: int (para película) o episodios (para serie)
- sinopsis: String
- clasificacionEdad: String (ATP, +13, +16, +18)
- paisOrigen: String

**Métodos importantes:**

- abstract getTipo() retorna "Película" o "Serie"
- contieneGenero(String) verifica si tiene el género
- contieneActor(String) búsqueda case-insensitive
- equals() y hashCode() basados en id
- toString() con información completa

### 2. Clase `Pelicula` extends Contenido

**Atributos adicionales:**

- duracionMinutos: int

**Métodos adicionales:**

- getTipo() retorna "Película"
- toString() incluye duración

### 3. Clase `Serie` extends Contenido

**Atributos adicionales:**

- numeroTemporadas: int
- numeroEpisodios: int
- enEmision: boolean

**Métodos adicionales:**

- getTipo() retorna "Serie"
- toString() incluye temporadas y episodios

### 4. Clase `Valoracion`

Representa la calificación de un usuario a un contenido.

**Atributos:**

- contenido: Contenido
- puntuacion: double (1.0 a 5.0)
- fechaValoracion: LocalDate
- comentario: String (opcional)

**Métodos importantes:**

- esPositiva() retorna true si puntuación >= 3.5
- toString() con formato legible

### 5. Clase `Usuario`

Representa un usuario de la plataforma.

**Atributos:**

- id: String (único, formato "USR-001")
- nombre: String
- email: String
- fechaRegistro: LocalDate
- generosPreferidos: Set&lt;String&gt; (géneros que le gustan)
- valoraciones: Map&lt;String, Valoracion&gt; (id contenido → valoración)
- historialVisualizacion: List&lt;Contenido&gt; (orden cronológico)
- miLista: List&lt;Contenido&gt; (watchlist)
- favoritos: Set&lt;Contenido&gt;

**Métodos importantes:**

- valorarContenido(Contenido, double puntuación, String comentario)
- agregarAMiLista(Contenido)
- agregarAFavoritos(Contenido)
- marcarComoVisto(Contenido)
- getValoracionPromedio() calcula promedio de sus valoraciones
- getContenidosValoradosPositivamente() retorna Set
- tieneValoracion(Contenido) verifica si ya valoró
- getGenerosPreferidosAutomatico() basado en contenidos mejor valorados
- equals() y hashCode() basados en id

### 6. Clase `Catalogo`

Gestiona todo el contenido disponible.

**Atributos:**

- contenidoPorId: Map&lt;String, Contenido&gt;
- peliculasPorGenero: Map&lt;String, Set&lt;Pelicula&gt;&gt;
- seriesPorGenero: Map&lt;String, Set&lt;Serie&gt;&gt;
- contenidoPorAño: TreeMap&lt;Integer, List&lt;Contenido&gt;&gt; (ordenado)
- contenidoPorDirector: Map&lt;String, List&lt;Contenido&gt;&gt;
- contenidoPorActor: Map&lt;String, List&lt;Contenido&gt;&gt;
- generosDisponibles: Set&lt;String&gt;

**Métodos importantes:**

- agregarContenido(Contenido)
- buscarPorId(String)
- buscarPorTitulo(String) búsqueda parcial, case-insensitive
- buscarPorGenero(String)
- buscarPorDirector(String)
- buscarPorActor(String)
- buscarPorAño(int)
- buscarPorRangoAños(int inicio, int fin)
- getEstrenos(int año)
- getContenidosPorGeneros(Set&lt;String&gt; géneros) intersección
- getEstadisticasPorGenero()

### 7. Clase `SistemaRecomendacion`

Motor de recomendaciones basado en similitud.

**Atributos:**

- usuarios: Map&lt;String, Usuario&gt;
- valoraciones: Map&lt;String, Map&lt;String, Valoracion&gt;&gt; (id usuario → (id contenido → valoración))
- similitudesCalculadas: Map&lt;String, Map&lt;String, Double&gt;&gt; (caché de similitudes entre usuarios)

**Métodos importantes:**

- registrarUsuario(Usuario)
- calcularSimilitudUsuarios(Usuario u1, Usuario u2) usando coeficiente de similitud
- encontrarUsuariosSimilares(Usuario, int topN)
- generarRecomendaciones(Usuario, int cantidad) basado en usuarios similares
- recomendarPorGenero(Usuario, int cantidad) basado en géneros preferidos
- recomendarPopulares(int cantidad) contenidos mejor valorados globalmente
- getContenidosSimilares(Contenido) basado en géneros, director, actores
- actualizarCacheSimilitudes()

### 8. Clase `EstadisticasPlataforma`

Genera estadísticas y rankings globales.

**Atributos:**

- catalogo: Catalogo
- sistema: SistemaRecomendacion

**Métodos importantes:**

- getContenidosMejorValorados(int top)
- getContenidosMasVistos(int top)
- getGenerosPopulares()
- getDirectoresMejorValorados()
- getActoresMasPopulares() basado en apariciones
- getEstadisticasUsuario(Usuario) genera reporte personalizado
- getDistribucionValoraciones() Map con conteo por puntuación
- getTendencias() contenidos con valoraciones recientes altas

---

## Funcionalidades Requeridas

### Gestión de Contenido

1. Agregar películas y series al catálogo
2. Buscar contenido por múltiples criterios
3. Filtrar por género, año, director, actor
4. Búsqueda combinada (género + año + director)
5. Obtener información detallada de contenido
6. Listar estrenos recientes

### Gestión de Usuarios

1. Registrar nuevos usuarios
2. Valorar contenido (1-5 estrellas) con comentario opcional
3. Agregar contenido a "Mi Lista" (watchlist)
4. Marcar contenido como favorito
5. Registrar visualización en historial
6. Ver perfil con estadísticas personales

### Sistema de Recomendaciones

1. **Recomendaciones por Similitud**: Encontrar usuarios con gustos similares y recomendar lo que ellos valoraron positivamente
2. **Recomendaciones por Género**: Basadas en géneros preferidos del usuario
3. **Recomendaciones por Contenido**: Sugerir contenido similar al que el usuario vio/valoró
4. **Contenido Popular**: Recomendar lo más visto y mejor valorado globalmente
5. **Tendencias**: Contenido con valoraciones recientes positivas
6. **Nuevos Estrenos**: Filtrados por géneros de interés

### Algoritmo de Similitud

Calcular similitud entre usuarios usando:

1. **Contenidos en Común**: Intersección de lo que ambos han valorado
2. **Diferencia de Valoraciones**: Qué tan parecidas son sus puntuaciones
3. **Géneros Preferidos**: Intersección de géneros favoritos
4. **Coeficiente de Similitud**: Combinar factores anteriores

### Búsqueda Avanzada

1. Búsqueda por texto en título y sinopsis
2. Filtros combinados: género + año + clasificación
3. Ordenar resultados por: rating, año, popularidad, título
4. Búsqueda por actor principal
5. Contenido del mismo director

### Estadísticas y Rankings

1. Top 10 películas mejor valoradas
2. Top 10 series mejor valoradas
3. Contenidos más vistos del mes
4. Géneros más populares
5. Directores con mejores ratings
6. Actores más buscados
7. Distribución de valoraciones
8. Estadísticas por usuario

---

## Reglas de Negocio

1. **Valoraciones**: Deben estar entre 1.0 y 5.0 (con decimales)
2. **Valoración Única**: Un usuario solo puede valorar cada contenido una vez (puede actualizar)
3. **Historial Ordenado**: Las visualizaciones se registran en orden cronológico
4. **Mi Lista**: No puede tener duplicados (usar Set o validar)
5. **Favoritos**: Subconjunto de contenido que el usuario ha visto o valorado
6. **Similitud Mínima**: Solo considerar usuarios con similitud > 0.3 para recomendaciones
7. **Géneros**: Deben ser de lista predefinida (Drama, Acción, Comedia, Terror, Romance, Ciencia Ficción, etc.)
8. **Clasificación de Edad**: ATP, +13, +16, +18
9. **Recomendaciones**: Excluir contenido ya valorado por el usuario

---

## Casos de Prueba

### Prueba 1: Construcción del Catálogo

1. Agregar 20 películas de diferentes géneros y años
2. Agregar 10 series de diferentes géneros
3. Verificar que se indexen correctamente por género
4. Buscar contenido por director y verificar resultados
5. Buscar por actor y verificar apariciones

### Prueba 2: Gestión de Usuarios y Valoraciones

1. Crear 5 usuarios con diferentes perfiles
2. Cada usuario valora 10 contenidos diferentes
3. Verificar que no se puedan duplicar valoraciones
4. Actualizar una valoración existente
5. Calcular valoración promedio de cada usuario

### Prueba 3: Sistema de Recomendaciones por Similitud

1. Usuario A y B valoran positivamente películas de Acción
2. Usuario A ve una nueva película de Acción que B no ha visto
3. Sistema debe recomendar esa película a B
4. Verificar que usuarios con gustos opuestos tengan baja similitud
5. Generar top 5 recomendaciones para cada usuario

### Prueba 4: Búsqueda y Filtros

1. Buscar películas de género "Drama" de los años 2020-2025
2. Buscar series del director específico
3. Buscar contenido con actor específico
4. Búsqueda por texto parcial en título
5. Ordenar resultados por rating descendente

### Prueba 5: Estadísticas Globales

1. Generar top 10 contenidos mejor valorados
2. Calcular géneros más populares
3. Identificar contenidos con más visualizaciones
4. Generar reporte de usuario individual
5. Calcular distribución de valoraciones (1★, 2★, etc.)

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== PLATAFORMA DE STREAMING - RECOMENDACIONES ===

1. Gestión de Contenido
   1.1. Agregar película
   1.2. Agregar serie
   1.3. Buscar contenido
   1.4. Listar por género
   1.5. Estrenos del año

2. Gestión de Usuario
   2.1. Registrar usuario
   2.2. Seleccionar usuario activo
   2.3. Ver perfil y estadísticas
   2.4. Configurar géneros preferidos

3. Valoraciones y Listas
   3.1. Valorar contenido
   3.2. Ver mis valoraciones
   3.3. Agregar a Mi Lista
   3.4. Agregar a Favoritos
   3.5. Marcar como visto

4. Recomendaciones
   4.1. Recomendaciones personalizadas (similitud)
   4.2. Recomendaciones por género
   4.3. Contenido similar a...
   4.4. Populares en la plataforma
   4.5. Tendencias actuales
   4.6. Nuevos estrenos para mí

5. Búsqueda Avanzada
   5.1. Buscar por título
   5.2. Buscar por director
   5.3. Buscar por actor
   5.4. Filtros combinados
   5.5. Ordenar resultados

6. Rankings y Estadísticas
   6.1. Top películas mejor valoradas
   6.2. Top series mejor valoradas
   6.3. Más vistos del mes
   6.4. Géneros populares
   6.5. Estadísticas de usuario

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Algoritmo Collaborative Filtering**: Implementar recomendaciones usando filtrado colaborativo básico
2. **Content-Based Filtering**: Recomendar basándose en similitud de contenido (géneros, director, actores)
3. **Sistema Híbrido**: Combinar ambos enfoques
4. **Detección de Comunidades**: Agrupar usuarios con gustos muy similares
5. **Predicción de Rating**: Predecir qué puntuación daría un usuario a contenido no visto
6. **Series Temporales**: Analizar cómo evolucionan los gustos del usuario en el tiempo

### Mejoras Técnicas

1. Implementar caché de recomendaciones que se actualice periódicamente
2. Usar TreeSet con Comparator para mantener rankings actualizados automáticamente
3. Implementar índice invertido para búsqueda de texto completo
4. Optimizar cálculo de similitud usando Sets (intersección O(n))
5. Implementar lazy loading de similitudes (calcular solo cuando se necesitan)
6. Usar WeakHashMap para caché que libere memoria automáticamente

---

## Ejemplo de Salida

```bash
=== PERFIL DE USUARIO ===
Usuario: María López (USR-042)
Miembro desde: 15/03/2024
Contenidos valorados: 47
Valoración promedio: 4.2 ⭐
Géneros favoritos: Drama, Thriller, Ciencia Ficción

--- MI LISTA (5) ---
1. Inception (2010) - Ciencia Ficción - ⭐ 4.8
2. Breaking Bad (2008) - Drama - ⭐ 4.9
3. Interstellar (2014) - Ciencia Ficción - ⭐ 4.7
4. The Dark Knight (2008) - Acción - ⭐ 4.9
5. Stranger Things (2016) - Ciencia Ficción - ⭐ 4.6

--- RECOMENDACIONES PERSONALIZADAS ---
Basadas en usuarios similares a ti:

1. ⭐ 4.7 | The Matrix (1999) - Ciencia Ficción
   "Usuarios como tú valoraron esto con 4.8"
   85% de coincidencia con tus gustos
   
2. ⭐ 4.6 | Black Mirror (2011) - Ciencia Ficción
   "7 usuarios similares lo valoraron positivamente"
   82% de coincidencia

3. ⭐ 4.8 | The Shawshank Redemption (1994) - Drama
   "Tu usuario similar favorito le dio 5 estrellas"
   78% de coincidencia

--- PORQUE TE RECOMENDAMOS ESTO ---
"The Matrix":
  ✓ Género: Ciencia Ficción (tu favorito)
  ✓ Usuarios similares (8) lo valoraron promedio 4.7
  ✓ Mismo director que "Inception" (5★)
  ✓ Actor: Keanu Reeves (aparece en 3 de tus favoritos)

--- USUARIOS SIMILARES A TI ---
1. Carlos Ruiz (USR-089) - Similitud: 87%
   Contenidos en común: 23
   Géneros compartidos: Drama, Thriller, Ciencia Ficción
   
2. Ana Torres (USR-034) - Similitud: 79%
   Contenidos en común: 18
   Géneros compartidos: Drama, Ciencia Ficción

--- TENDENCIAS ESTA SEMANA ---
1. Oppenheimer (2023) - 234 valoraciones nuevas (⭐ 4.6)
2. The Last of Us (2023) - 189 valoraciones nuevas (⭐ 4.8)
3. Dune: Part Two (2024) - 156 valoraciones nuevas (⭐ 4.5)
```

---

## Conceptos Clave a Aplicar

1. **Map Anidados**: Map&lt;String, Map&lt;String, Valoracion&gt;&gt; para estructura compleja
2. **Set Operations**: intersection() para encontrar contenidos comunes
3. **TreeMap**: Mantener contenido ordenado por año automáticamente
4. **LinkedHashMap**: Preservar orden de historial de visualización
5. **Comparator Múltiple**: Ordenar por rating, luego por año, luego por título
6. **computeIfAbsent()**: Inicializar Maps anidados elegantemente
7. **Stream API**: Filtros y transformaciones complejas
8. **Set de Géneros**: Garantizar unicidad y permitir intersecciones rápidas

---

## Notas Técnicas

- **Algoritmo de Similitud**: Usar coeficiente de Jaccard o Cosine Similarity
- **Fórmula Jaccard**: similitud = |A ∩ B| / |A ∪ B|
- **Optimización**: Cachear cálculos de similitud costosos
- **Estructura**: Usuario → Set&lt;ContenidoValorado&gt; para intersecciones rápidas
- **Índices**: Mantener índices secundarios para búsquedas rápidas
- **Actualización**: Recalcular similitudes solo cuando hay nuevas valoraciones
- **Performance**: Limitar cálculo de similitud a usuarios activos recientes

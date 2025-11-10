# Proyecto 06 - Plataforma de Cursos Online con Progreso

## Descripción General

Desarrollar una plataforma de aprendizaje online que gestione cursos, lecciones, evaluaciones, estudiantes y seguimiento detallado del progreso. El sistema debe manejar inscripciones, completar lecciones, realizar evaluaciones, generar certificados y proporcionar recomendaciones personalizadas de cursos basadas en intereses y progreso.

**Dificultad:** ⭐⭐⭐  
**Tiempo estimado:** 8-10 horas  
**Conceptos clave:** Map para tracking de progreso, List ordenadas de lecciones, Set para certificaciones

---

## Objetivos de Aprendizaje

- Usar **Map&lt;Estudiante, Map&lt;Leccion, ProgresoLeccion&gt;&gt;** para tracking anidado
- Aplicar **LinkedHashMap** para mantener orden de lecciones
- Implementar **TreeSet** para rankings de estudiantes
- Utilizar **Set** para certificaciones obtenidas
- Crear **List ordenada** de evaluaciones por fecha
- Usar **Comparator** para ordenar cursos por popularidad, rating, dificultad
- Aplicar filtros complejos combinando múltiples colecciones

---

## Estructura de Clases

### 1. Enum `NivelDificultad`

**Valores:**

- PRINCIPIANTE
- INTERMEDIO
- AVANZADO
- EXPERTO

### 2. Enum `TipoContenido`

**Valores:**

- VIDEO
- LECTURA
- EJERCICIO_PRACTICO
- QUIZ
- PROYECTO
- EXAMEN

### 3. Clase `Leccion`

Representa una lección individual dentro de un curso.

**Atributos:**

- id: String (único, formato "LEC-001")
- titulo: String
- descripcion: String
- tipoContenido: TipoContenido
- duracionMinutos: int
- orden: int (orden dentro del módulo)
- urlContenido: String (link al video/documento)
- prerequisitos: Set&lt;Leccion&gt; (lecciones que deben completarse antes)
- puntos: int (puntos que otorga al completar)

**Métodos importantes:**

- puedeAcceder(Set&lt;Leccion&gt; leccionesCompletadas)
- esEvaluacion() retorna true si es Quiz o Examen
- equals() y hashCode() basados en id
- toString()

### 4. Clase `Modulo`

Agrupa lecciones relacionadas.

**Atributos:**

- id: String (único, formato "MOD-001")
- nombre: String
- descripcion: String
- orden: int (orden dentro del curso)
- lecciones: LinkedHashMap&lt;Integer, Leccion&gt; (orden → lección)
- duracionTotal: int (suma de duraciones)

**Métodos importantes:**

- agregarLeccion(Leccion)
- getLeccionPorOrden(int)
- calcularDuracionTotal()
- getCantidadLecciones()
- toString()

### 5. Clase `Evaluacion`

Representa una evaluación (quiz o examen).

**Atributos:**

- leccion: Leccion (debe ser tipo QUIZ o EXAMEN)
- preguntas: List&lt;String&gt;
- respuestasCorrectas: Map&lt;Integer, String&gt; (número pregunta → respuesta)
- puntajeMinimo: double (para aprobar)
- intentosPermitidos: int
- tiempoLimiteMinutos: int

**Métodos importantes:**

- agregarPregunta(String pregunta, String respuesta)
- calificar(Map&lt;Integer, String&gt; respuestasEstudiante)
- aprobo(double puntaje)

### 6. Clase `Curso`

Representa un curso completo.

**Atributos:**

- id: String (único, formato "CUR-001")
- titulo: String
- descripcion: String
- instructor: String
- nivel: NivelDificultad
- categorias: Set&lt;String&gt; (Programación, Diseño, Marketing, etc.)
- modulos: LinkedHashMap&lt;Integer, Modulo&gt; (orden → módulo)
- duracionTotal: int (horas)
- precio: double
- valoracion: double (1-5 estrellas)
- cantidadValoraciones: int
- estudiantesInscritos: int
- fechaCreacion: LocalDate
- requisitos: Set&lt;String&gt; (conocimientos previos)

**Métodos importantes:**

- agregarModulo(Modulo)
- calcularDuracionTotal()
- agregarValoracion(double puntuacion)
- getTodasLasLecciones() retorna List ordenada
- getCantidadTotal Lecciones()
- contieneCategoria(String)
- equals() y hashCode() basados en id
- toString()

### 7. Clase `ProgresoLeccion`

Registra el progreso de un estudiante en una lección específica.

**Atributos:**

- leccion: Leccion
- completada: boolean
- fechaInicio: LocalDateTime
- fechaCompletado: LocalDateTime (null si no completada)
- tiempoInvertido: int (minutos)
- intentosEvaluacion: int (si es evaluación)
- puntajeObtenido: double (si es evaluación)

**Métodos importantes:**

- completar()
- registrarIntento(double puntaje)
- getTiempoInvertido()
- aprobada() si es evaluación y puntaje >= mínimo

### 8. Clase `ProgresoCurso`

Registra el progreso completo de un estudiante en un curso.

**Atributos:**

- estudiante: Estudiante
- curso: Curso
- fechaInscripcion: LocalDate
- progreso Lecciones: Map&lt;String, ProgresoLeccion&gt; (id lección → progreso)
- leccionActual: Leccion
- porcentajeCompletado: double
- certificadoObtenido: boolean
- fechaCertificado: LocalDate

**Métodos importantes:**

- iniciarLeccion(Leccion)
- completarLeccion(Leccion)
- registrarEvaluacion(Leccion, double puntaje)
- calcularPorcentajeCompletado()
- puedeObtenerCertificado() todas las lecciones completadas y evaluaciones aprobadas
- generarCertificado()
- getLeccionesCompletadas() retorna Set
- getLeccionesPendientes() retorna List
- getProximaLeccion() basado en orden y prerequisitos

### 9. Clase `Estudiante`

Representa un estudiante de la plataforma.

**Atributos:**

- id: String (único, formato "EST-001")
- nombre: String
- email: String
- fechaRegistro: LocalDate
- cursosInscritos: Map&lt;String, ProgresoCurso&gt; (id curso → progreso)
- certificadosObtenidos: Set&lt;Curso&gt;
- categoriasInteres: Set&lt;String&gt;
- puntosTotales: int (suma de puntos de lecciones completadas)
- nivel: int (basado en puntos)

**Métodos importantes:**

- inscribirCurso(Curso)
- getProgresoCurso(Curso)
- getCursosCompletados() retorna List
- getCursosEnProgreso() retorna List
- agregarCertificado(Curso)
- calcularNivel() basado en puntos (cada 1000 puntos = 1 nivel)
- getTiempoTotalEstudio() suma de todos los cursos
- getPromedioValoraciones() si el estudiante valoró cursos
- equals() y hashCode() basados en id

### 10. Clase `PlataformaCursos`

Clase principal que gestiona toda la plataforma.

**Atributos:**

- cursos: Map&lt;String, Curso&gt;
- estudiantes: Map&lt;String, Estudiante&gt;
- cursosPopulares: TreeSet&lt;Curso&gt; (ordenados por estudiantes inscritos)
- cursosMejorValorados: TreeSet&lt;Curso&gt; (ordenados por valoración)
- categorias: Set&lt;String&gt;
- progresoGlobal: Map&lt;String, Map&lt;String, ProgresoCurso&gt;&gt; (id estudiante → (id curso → progreso))

**Métodos importantes:**

- registrarCurso(Curso)
- registrarEstudiante(Estudiante)
- inscribirEstudianteEnCurso(Estudiante, Curso)
- buscarCursosPorCategoria(String)
- buscarCursosPorNivel(NivelDificultad)
- buscarCursosPorTitulo(String) búsqueda parcial
- getCursosPopulares(int top)
- getCursosMejorValorados(int top)
- recomendarCursos(Estudiante) basado en categorías de interés y nivel
- getEstadisticasEstudiante(Estudiante)
- getEstadisticasCurso(Curso)
- getRankingEstudiantes() ordenado por puntos
- generarReporte Plataforma()

---

## Funcionalidades Requeridas

### Gestión de Cursos

1. Crear cursos con módulos y lecciones
2. Establecer prerequisitos entre lecciones
3. Configurar evaluaciones con preguntas y respuestas
4. Actualizar valoración de cursos
5. Buscar cursos por categoría, nivel, título
6. Listar cursos más populares y mejor valorados

### Gestión de Estudiantes

1. Registrar estudiantes con intereses
2. Inscribir estudiantes en cursos
3. Ver cursos inscritos y su progreso
4. Calcular nivel del estudiante basado en puntos
5. Listar certificados obtenidos

### Seguimiento de Progreso

1. Registrar inicio de lección
2. Marcar lección como completada
3. Calcular porcentaje de completado de curso
4. Validar prerequisitos antes de acceder a lección
5. Registrar tiempo invertido en cada lección
6. Determinar próxima lección disponible

### Evaluaciones

1. Presentar evaluación (quiz/examen)
2. Calificar respuestas automáticamente
3. Permitir múltiples intentos (hasta límite)
4. Registrar puntajes en progreso
5. Validar puntaje mínimo para aprobar
6. Bloquear avance si no aprueba evaluación obligatoria

### Certificados

1. Verificar completado del 100% del curso
2. Validar aprobación de todas las evaluaciones
3. Generar certificado con fecha
4. Almacenar certificados del estudiante
5. Mostrar certificados obtenidos

### Recomendaciones

1. Recomendar cursos basados en categorías de interés
2. Sugerir cursos de nivel apropiado
3. Recomendar cursos relacionados a los completados
4. Sugerir siguientes pasos en ruta de aprendizaje

### Estadísticas y Rankings

1. Ranking de estudiantes por puntos
2. Ranking de cursos por popularidad
3. Ranking de cursos por valoración
4. Estadísticas de estudiante (tiempo, cursos, nivel)
5. Estadísticas de curso (inscritos, completados, valoración)
6. Reporte global de la plataforma

---

## Reglas de Negocio

1. **Prerequisitos**: No se puede acceder a lección sin completar prerequisitos
2. **Orden de Lecciones**: Debe seguirse el orden dentro de cada módulo
3. **Evaluaciones**: Mínimo 70% de puntaje para aprobar
4. **Intentos**: Si se agotan intentos sin aprobar, se bloquea el curso
5. **Certificado**: Requiere 100% completado + todas evaluaciones aprobadas
6. **Puntos**: Solo se otorgan al completar por primera vez
7. **Niveles**: Nivel = puntosTotales / 1000 (cada 1000 puntos = 1 nivel)
8. **Valoración**: Solo pueden valorar estudiantes que completaron al menos 50% del curso

---

## Casos de Prueba

### Prueba 1: Creación de Curso Completo

1. Crear curso con 3 módulos
2. Agregar 4 lecciones por módulo
3. Configurar 2 evaluaciones
4. Establecer prerequisitos entre lecciones
5. Verificar cálculo correcto de duración total

### Prueba 2: Inscripción y Progreso Básico

1. Registrar estudiante
2. Inscribir en curso
3. Completar primera lección
4. Verificar actualización de porcentaje
5. Verificar otorgamiento de puntos

### Prueba 3: Prerequisitos y Bloqueos

1. Intentar acceder a lección con prerequisitos no completados (debe fallar)
2. Completar prerequisitos
3. Verificar acceso desbloqueado
4. Avanzar secuencialmente
5. Validar flujo correcto

### Prueba 4: Evaluaciones

1. Completar lección tipo Quiz
2. Responder evaluación (aprobado)
3. Verificar registro de puntaje
4. Responder evaluación (reprobado)
5. Validar límite de intentos

### Prueba 5: Certificado Completo

1. Completar todas las lecciones de un curso
2. Aprobar todas las evaluaciones
3. Verificar elegibilidad para certificado
4. Generar certificado
5. Validar almacenamiento en perfil de estudiante

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== PLATAFORMA DE CURSOS ONLINE ===

1. Gestión de Cursos
   1.1. Crear nuevo curso
   1.2. Agregar módulo a curso
   1.3. Agregar lección a módulo
   1.4. Configurar evaluación
   1.5. Ver información de curso
   1.6. Listar todos los cursos

2. Gestión de Estudiantes
   2.1. Registrar estudiante
   2.2. Ver perfil de estudiante
   2.3. Actualizar intereses
   2.4. Ver certificados obtenidos
   2.5. Ver ranking de estudiantes

3. Inscripciones
   3.1. Inscribir estudiante en curso
   3.2. Ver mis cursos
   3.3. Ver cursos en progreso
   3.4. Ver cursos completados

4. Aprendizaje
   4.1. Ver lecciones disponibles
   4.2. Iniciar lección
   4.3. Completar lección
   4.4. Realizar evaluación
   4.5. Ver mi progreso en curso

5. Búsqueda y Recomendaciones
   5.1. Buscar cursos por categoría
   5.2. Buscar cursos por nivel
   5.3. Buscar cursos por título
   5.4. Cursos populares
   5.5. Cursos mejor valorados
   5.6. Recomendaciones personalizadas

6. Certificados
   6.1. Ver cursos listos para certificar
   6.2. Generar certificado
   6.3. Ver mis certificados
   6.4. Descargar certificado

7. Estadísticas y Reportes
   7.1. Mis estadísticas
   7.2. Estadísticas de curso
   7.3. Ranking de estudiantes
   7.4. Reporte de plataforma

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Ruta de Aprendizaje**: Secuencia recomendada de cursos para alcanzar objetivo
2. **Sistema de Logros/Badges**: Insignias por completar hitos
3. **Foros de Discusión**: Por curso con threads y respuestas
4. **Competencias**: Desafíos cronometrados entre estudiantes
5. **Proyecto Final**: Evaluación práctica integral
6. **Mentor/Tutor**: Sistema de tutoría entre estudiantes

### Mejoras Técnicas

1. Usar Observer pattern para notificar completado de lecciones
2. Implementar caché de recomendaciones personalizadas
3. Usar TreeSet con Comparator para mantener rankings actualizados
4. Implementar sistema de eventos para tracking de actividad
5. Optimizar búsquedas con índices secundarios
6. Usar EnumMap para estadísticas por nivel de dificultad

---

## Ejemplo de Salida

```bash
=== PERFIL DE ESTUDIANTE ===
Estudiante: María González (EST-042)
Email: maria.gonzalez@email.com
Miembro desde: 15/03/2024
Nivel: 5 ⭐ (5,450 puntos)
Certificados obtenidos: 3

--- MIS CURSOS EN PROGRESO ---

1. 📘 Java Completo - De Cero a Experto
   Instructor: Andrés Guzmán
   Progreso: ████████░░ 75% completado
   Módulos: 8/10 completados
   Lecciones: 45/60 completadas
   Tiempo invertido: 24 horas
   Próxima lección: "Streams y API funcional"

2. 📗 Spring Boot Microservicios
   Instructor: Juan Pérez
   Progreso: ███░░░░░░░ 30% completado
   Módulos: 3/12 completados
   Lecciones: 12/45 completadas
   Tiempo invertido: 8 horas
   Próxima lección: "Configuración de Spring Boot"

--- MIS CERTIFICADOS ---
✓ Python para Data Science (Completado: 10/02/2024)
✓ SQL y Bases de Datos (Completado: 15/03/2024)
✓ Git y GitHub (Completado: 01/04/2024)

--- PROGRESO EN "JAVA COMPLETO" ---

Módulo 1: Fundamentos de Java ✅ 100%
  ✓ Introducción a Java (15 min)
  ✓ Instalación del JDK (20 min)
  ✓ Mi primer programa (25 min)
  ✓ Quiz: Fundamentos (10 min) - Aprobado: 85%

Módulo 2: POO en Java ✅ 100%
  ✓ Clases y Objetos (30 min)
  ✓ Herencia y Polimorfismo (45 min)
  ✓ Interfaces y Clases Abstractas (40 min)
  ✓ Quiz: POO (15 min) - Aprobado: 90%

Módulo 3: Colecciones y Genéricos ⏳ 50%
  ✓ List y ArrayList (25 min)
  ✓ Set y Map (30 min)
  ⏳ Generics avanzados (PRÓXIMA)
  🔒 Quiz: Colecciones (Bloqueada - requiere completar todas las lecciones)

--- RECOMENDACIONES PERSONALIZADAS ---

Basadas en tu progreso e intereses:

1. 🎯 Spring Framework: De Cero a Experto
   Nivel: Intermedio | Duración: 40h | ⭐ 4.8
   "Ya que estás aprendiendo Java, este es el siguiente paso natural"
   Inscripción recomendada después de completar Java Completo

2. 🎯 Patrones de Diseño en Java
   Nivel: Avanzado | Duración: 15h | ⭐ 4.6
   "Perfecto para tu nivel actual (Nivel 5)"
   Aplicarás los conceptos de POO que ya dominas

3. 🎯 Docker y Kubernetes
   Nivel: Intermedio | Duración: 25h | ⭐ 4.7
   "Complementa tu aprendizaje de microservicios"

--- PRÓXIMO HITO ---
🏆 Completa "Java Completo" para obtener tu certificado (25% restante)
⚡ Tiempo estimado restante: 8 horas
🎯 Lecciones pendientes: 15

=== ESTADÍSTICAS DE LA PLATAFORMA ===
Total estudiantes: 12,450
Total cursos: 350
Certificados emitidos hoy: 23
Curso más popular: "Python para Data Science" (2,340 inscritos)
Curso mejor valorado: "Clean Code" (4.9 ⭐)
```

---

## Conceptos Clave a Aplicar

1. **Map Anidado**: Map&lt;Estudiante, Map&lt;Leccion, Progreso&gt;&gt; para tracking
2. **LinkedHashMap**: Mantener orden de lecciones y módulos
3. **TreeSet con Comparator**: Rankings automáticos de cursos y estudiantes
4. **Set de Prerequisitos**: Validar dependencias entre lecciones
5. **Set de Certificados**: Garantizar unicidad
6. **List Ordenada**: Secuencia de lecciones disponibles
7. **computeIfAbsent()**: Inicializar progreso de forma elegante
8. **Filtros Complejos**: Combinar múltiples criterios de búsqueda

---

## Notas Técnicas

- **Estructura de Progreso**: Usar Maps anidados para acceso O(1)
- **Validación de Prerequisitos**: Verificar Set de lecciones completadas
- **Cálculo de Porcentaje**: (leccionesCompletadas / totalLecciones) × 100
- **Niveles**: Usar división entera para calcular nivel
- **Ordenamiento**: TreeSet actualiza orden automáticamente al cambiar criterio
- **Certificados**: Validar 100% completado AND todas evaluaciones aprobadas
- **Recomendaciones**: Filtrar por categorías ∩ nivel apropiado

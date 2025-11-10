# PROYECTO 07: Gestor de Tareas y Proyectos 📊

## Dificultad: ⭐⭐⭐⭐ | Tiempo: 10-12 horas

## Descripción

Sistema de gestión de proyectos estilo Trello/Jira con proyectos, tareas, subtareas, usuarios asignados, estados, prioridades, etiquetas, comentarios y reportes de avance.

## Jerarquía Principal

### Clase Proyecto

Atributos: id, nombre, descripción, fechaInicio, fechaFin, presupuesto, lider, equipo, tareas, estado

Estados: PLANIFICACION, EN_PROGRESO, PAUSADO, COMPLETADO, CANCELADO

Métodos: agregarTarea(), asignarMiembro(), calcularProgreso(), generarReporte()

### Clase Abstracta: ItemTrabajo

Subclases: Tarea, Historia, Bug, Mejora

Atributos comunes: id, título, descripción, prioridad, estado, asignado, estimación, tiempoReal, fechaCreación, etiquetas

Métodos abstractos: calcularComplejidad(), esBloquante(), puedeIniciar()

### Clase Tarea (hereda ItemTrabajo)

Atributos: proyecto, subtareas, dependencias, comentarios, archivosAdjuntos

Estados: PENDIENTE, EN_PROGRESO, EN_REVISION, BLOQUEADA, COMPLETADA, CANCELADA

Prioridades: BAJA, MEDIA, ALTA, URGENTE, CRITICA

Métodos:

- agregarSubtarea()
- agregarDependencia() - tarea debe esperar otra
- cambiarEstado()
- asignarUsuario()
- registrarTiempo()
- agregarComentario()

### Clase Subtarea

Atributos: tareapadre, título, completada, asignado

Métodos: marcarCompletada(), calcularProgresoPadre()

### Clase Usuario

Atributos: id, nombre, email, rol, proyectosAsignados, tareasAsignadas, disponibilidad

Roles: ADMINISTRADOR, LIDER_PROYECTO, DESARROLLADOR, TESTER, DISEÑADOR, ANALISTA

Métodos: verTareasAsignadas(), verProyectos(), reportarTiempo(), cambiarDisponibilidad()

### Clase Comentario

Atributos: autor, texto, fecha, menciones, reacciones

Métodos: editar(), eliminar(), mencionarUsuario(), responder()

### Clase Sprint (Metodología Ágil)

Atributos: numero, fechaInicio, fechaFin, tareas, meta, velocidad

Métodos: planificar(), iniciar(), cerrar(), calcularVelocidad()

### Interface Notificable

Implementan: Tarea, Proyecto, Comentario

Métodos: notificarAsignacion(), notificarCambioEstado(), notificarMencion()

## Funcionalidades

### 1. Gestión de Proyectos

- Crear proyecto nuevo
- Asignar equipo de trabajo
- Definir fechas y presupuesto
- Ver tablero Kanban del proyecto
- Calcular progreso general
- Archivar proyecto completado

### 2. Gestión de Tareas

- Crear tarea con todos los detalles
- Asignar usuario responsable
- Establecer prioridad y estado
- Agregar subtareas (checklist)
- Definir dependencias entre tareas
- Registrar tiempo trabajado
- Adjuntar archivos (simulado)

### 3. Tablero Kanban

Columnas: Por Hacer | En Progreso | En Revisión | Completadas

- Mover tareas entre columnas
- Filtrar por asignado
- Filtrar por prioridad
- Ordenar por fecha/prioridad
- Vista de lista o tarjetas

### 4. Sistema de Etiquetas

Etiquetas predefinidas: Frontend, Backend, Base de Datos, Testing, Diseño, Documentación, Hotfix

Métodos:

- Crear etiqueta personalizada
- Asignar etiquetas a tareas
- Filtrar por etiqueta
- Estadísticas por etiqueta

### 5. Seguimiento de Tiempo

- Iniciar temporizador en tarea
- Detener temporizador
- Registrar tiempo manual
- Ver tiempo total por tarea
- Ver tiempo total por usuario
- Comparar estimado vs real

### 6. Sistema de Comentarios

- Agregar comentario a tarea
- Mencionar usuarios con @
- Responder comentarios
- Ver historial completo
- Notificar menciones

### 7. Reportes y Métricas

- Progreso del proyecto (%)
- Burndown chart (tareas pendientes)
- Tareas por estado
- Tareas por usuario
- Tareas vencidas
- Velocidad del equipo
- Tiempo promedio por tarea
- Eficiencia (estimado vs real)

### 8. Filtros y Búsquedas

- Buscar por título/descripción
- Filtrar por estado
- Filtrar por prioridad
- Filtrar por asignado
- Filtrar por etiqueta
- Filtrar por fecha vencimiento
- Combinación de filtros

## Reglas de Negocio

### Proyectos

- Debe tener al menos 1 líder asignado
- Fecha fin debe ser posterior a fecha inicio
- No se pueden eliminar proyectos con tareas activas
- Solo líder o admin pueden cerrar proyecto

### Tareas

- Solo se puede iniciar si dependencias están completadas
- Tarea bloqueada no puede cambiar a en progreso
- Usuario solo puede trabajar máximo 3 tareas simultáneas
- Estimación en horas (debe ser > 0)
- Prioridad CRITICA requiere aprobación de líder

### Subtareas

- Tarea padre no se completa si hay subtareas pendientes
- Progreso padre se calcula: (completadas / totales) × 100

### Tiempo

- No se puede registrar más de 12 horas en un día
- Tiempo real se suma automáticamente
- Alertar si tiempo real > estimado × 1.5

## Casos de Prueba

Escenario 1: Crear Proyecto con Tareas

1. Admin crea proyecto "App Móvil"
2. Asigna 3 desarrolladores
3. Crea 5 tareas principales
4. Asigna tareas a desarrolladores
5. Verifica tablero Kanban vacío en "En Progreso"

Escenario 2: Tarea con Subtareas

1. Crear tarea "Implementar Login"
2. Agregar subtareas:
   - Diseñar interfaz
   - Crear formulario
   - Validar credenciales
   - Manejar errores
3. Completar 2 de 4 subtareas
4. Progreso tarea = 50%
5. Tarea aún no se puede marcar completada

Escenario 3: Dependencias de Tareas

1. Tarea A: "Diseñar base de datos"
2. Tarea B: "Implementar API" (depende de A)
3. Intentar iniciar Tarea B
4. Sistema bloquea (A aún no completada)
5. Completar Tarea A
6. Ahora B se puede iniciar

Escenario 4: Seguimiento de Tiempo

1. Usuario asignado a tarea (estimación: 8 horas)
2. Inicia temporizador
3. Trabaja 3 horas, pausa
4. Continúa 2 horas más
5. Registra manualmente 4 horas adicionales
6. Total: 9 horas (1 hora más del estimado)
7. Sistema genera alerta de sobrecarga

Escenario 5: Reportes de Proyecto

1. Proyecto con 20 tareas totales
2. 8 completadas, 10 en progreso, 2 pendientes
3. Progreso = 8/20 = 40%
4. Generar burndown chart
5. Calcular velocidad: 8 tareas / 2 semanas = 4 tareas/semana
6. Proyectar fecha finalización

## Menú del Sistema

```bash
╔════════════════════════════════════════════╗
║    GESTOR DE TAREAS Y PROYECTOS            ║
╠════════════════════════════════════════════╣
║  PROYECTOS                                 ║
║    1. Crear proyecto                       ║
║    2. Ver mis proyectos                    ║
║    3. Ver tablero Kanban                   ║
║    4. Asignar equipo                       ║
║                                            ║
║  TAREAS                                    ║
║    5. Crear tarea                          ║
║    6. Ver mis tareas                       ║
║    7. Actualizar estado                    ║
║    8. Agregar comentario                   ║
║    9. Registrar tiempo                     ║
║   10. Buscar tareas                        ║
║                                            ║
║  EQUIPO                                    ║
║   11. Ver miembros del equipo              ║
║   12. Tareas por usuario                   ║
║   13. Disponibilidad                       ║
║                                            ║
║  REPORTES                                  ║
║   14. Progreso del proyecto                ║
║   15. Burndown chart                       ║
║   16. Tiempo por tarea                     ║
║   17. Velocidad del equipo                 ║
║   18. Tareas vencidas                      ║
║                                            ║
║   0. Salir                                 ║
╚════════════════════════════════════════════╝
```

## Visualización Tablero Kanban

```bash
╔═══════════════╦═══════════════╦═══════════════╦═══════════════╗
║  POR HACER    ║  EN PROGRESO  ║  EN REVISIÓN  ║  COMPLETADAS  ║
╠═══════════════╬═══════════════╬═══════════════╬═══════════════╣
║ [ALTA] #12    ║ [URGENTE] #8  ║ [MEDIA] #5    ║ ✓ #1          ║
║ Login UI      ║ API Rest      ║ Testing       ║ Diseño DB     ║
║ @juan         ║ @maria        ║ @pedro        ║               ║
║ Est: 5h       ║ 3h/8h 🔴      ║ 2h/4h         ║               ║
║               ║               ║               ║               ║
║ [MEDIA] #15   ║ [ALTA] #10    ║               ║ ✓ #2          ║
║ Validaciones  ║ Integración   ║               ║ Setup         ║
║ @ana          ║ @juan         ║               ║               ║
║ Est: 3h       ║ 2h/6h         ║               ║               ║
╚═══════════════╩═══════════════╩═══════════════╩═══════════════╝

Leyenda: 🔴 Sobrepasó estimación | 🟡 80% tiempo | 🟢 A tiempo
```

## Extras Opcionales

1. Gráficos Avanzados: Gantt chart, velocity chart
2. Retrospectivas: Reuniones de equipo
3. Roadmap: Planificación a largo plazo
4. Plantillas: Proyectos predefinidos
5. Integraciones: Git, Slack (simulado)
6. Calendario: Vista de deadlines
7. Milestone: Hitos del proyecto
8. Riesgos: Identificación y mitigación

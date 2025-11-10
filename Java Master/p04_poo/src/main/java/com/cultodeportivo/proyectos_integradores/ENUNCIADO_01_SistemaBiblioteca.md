# PROYECTO 01: Sistema de Gestión de Biblioteca 📚

## Dificultad: ⭐⭐⭐

## Descripción General

Sistema integral para administrar una biblioteca que gestiona diferentes tipos de materiales bibliográficos (libros, revistas, DVDs), usuarios con diferentes permisos, préstamos con fechas de devolución y un sistema de multas por retraso.

## Objetivos de Aprendizaje

- Aplicar herencia con jerarquías de clases
- Implementar interfaces para comportamientos comunes
- Usar polimorfismo para tratamiento uniforme de objetos
- Trabajar con genéricos para repositorios reutilizables
- Gestionar fechas y cálculos temporales
- Validar reglas de negocio complejas

## Estructura del Sistema

### Jerarquía de Materiales Bibliográficos

Clase Abstracta: MaterialBibliografico

- Atributos: id, título, autor/creador, año publicación, estado (disponible/prestado)
- Métodos abstractos: calcularDiasMaximoPrestamo(), obtenerInformacionCompleta()
- Métodos concretos: prestar(), devolver(), estaDisponible()

Subclases:

Libro (hereda de MaterialBibliografico)

- Atributos adicionales: ISBN, editorial, número de páginas, género
- Días máximo de préstamo: 14 días
- Permite renovación: Sí

Revista (hereda de MaterialBibliografico)

- Atributos adicionales: ISSN, número de edición, mes, periodicidad
- Días máximo de préstamo: 7 días
- Permite renovación: No

DVD (hereda de MaterialBibliografico)

- Atributos adicionales: director, duración (minutos), clasificación, idioma
- Días máximo de préstamo: 3 días
- Permite renovación: No

### Jerarquía de Usuarios

Clase Abstracta: Usuario

- Atributos: id, nombre, apellido, email, teléfono, fecha de registro
- Métodos abstractos: obtenerLimitePrestamos(), calcularMulta()
- Métodos concretos: prestarMaterial(), devolverMaterial(), listarPrestamosActivos()

Subclases:

Estudiante (hereda de Usuario)

- Atributo adicional: número de matrícula, carrera
- Límite de préstamos simultáneos: 3
- Multa por día de retraso: $1.00

Profesor (hereda de Usuario)

- Atributo adicional: departamento, especialidad
- Límite de préstamos simultáneos: 5
- Multa por día de retraso: $0.50

UsuarioGeneral (hereda de Usuario)

- Atributo adicional: tipo de membresía (básica/premium)
- Límite de préstamos: 2 (básica), 4 (premium)
- Multa por día de retraso: $2.00

### Interfaces

Prestable

- Métodos: prestar(), devolver(), estaDisponible(), puedeRenovarse()

Catalogable

- Métodos: agregarAlCatalogo(), eliminarDelCatalogo(), buscarPorCriterio()

Notificable

- Métodos: enviarNotificacion(), generarRecordatorio()

### Clase Préstamo

AAtributos:

- id del préstamo
- material prestado (MaterialBibliografico)
- usuario que prestó (Usuario)
- fecha de préstamo
- fecha de devolución esperada
- fecha de devolución real (puede ser null)
- estado (activo/devuelto/vencido)
- número de renovaciones

Métodos:

- calcularDiasRetraso(): retorna días de retraso si aplica
- calcularMulta(): calcula multa según días de retraso y tipo de usuario
- renovarPrestamo(): extiende fecha si es permitido
- marcarComoDevuelto(): registra devolución
- estaVencido(): verifica si pasó la fecha límite

### Clase Biblioteca (Gestión Principal)

Atributos:

- nombre de la biblioteca
- colección de materiales (usar genéricos)
- colección de usuarios (usar genéricos)
- colección de préstamos activos
- colección de historial de préstamos

Métodos:

- Gestión de Materiales:
  - agregarMaterial()
  - eliminarMaterial()
  - buscarMaterialPorId()
  - buscarMaterialPorTitulo()
  - buscarMaterialPorAutor()
  - listarMaterialesDisponibles()
  - listarTodosMateriales()

- Gestión de Usuarios:
  - registrarUsuario()
  - eliminarUsuario()
  - buscarUsuarioPorId()
  - buscarUsuarioPorNombre()
  - listarUsuarios()

- Gestión de Préstamos:
  - realizarPrestamo()
  - devolverMaterial()
  - renovarPrestamo()
  - listarPrestamosActivos()
  - listarPrestamosVencidos()
  - calcularMultasPendientes()

- Reportes:
  - generarReporteMaterialesMasPrestados()
  - generarReporteUsuariosActivos()
  - generarReporteMultasPendientes()
  - generarEstadisticasGenerales()

## Funcionalidades Principales

### 1. Gestión de Catálogo

- Agregar nuevos materiales al catálogo
- Clasificar materiales por tipo
- Buscar materiales por diferentes criterios
- Ver disponibilidad de materiales
- Eliminar materiales obsoletos

### 2. Gestión de Usuarios

- Registrar diferentes tipos de usuarios
- Actualizar información de usuarios
- Ver historial de préstamos por usuario
- Calcular multas acumuladas
- Suspender usuarios con multas pendientes

### 3. Sistema de Préstamos

- Verificar disponibilidad antes de prestar
- Validar límite de préstamos por tipo de usuario
- Registrar fecha de préstamo y devolución esperada
- Permitir renovación si el material lo permite
- Calcular días de retraso automáticamente
- Aplicar multas según tipo de usuario

### 4. Control de Devoluciones

- Registrar devolución de materiales
- Calcular multa si hay retraso
- Actualizar estado del material a disponible
- Liberar cupo de préstamo del usuario
- Guardar en historial

### 5. Sistema de Notificaciones (Simulado)

- Recordatorio 2 días antes de vencimiento
- Notificación de vencimiento
- Aviso de multa acumulada
- Confirmación de préstamo exitoso
- Confirmación de devolución

### 6. Reportes y Estadísticas

- Top 10 materiales más prestados
- Usuarios con más préstamos
- Materiales nunca prestados
- Multas totales recaudadas
- Tasa de devolución a tiempo
- Materiales actualmente prestados por categoría

## Reglas de Negocio

### Préstamos

- Un material solo puede prestarse si está disponible
- Un usuario no puede exceder su límite de préstamos simultáneos
- No se pueden hacer préstamos a usuarios con multas pendientes superiores a $50
- La renovación solo se permite si el material lo permite y no hay reservas
- Solo se permite 1 renovación por préstamo

### Multas

- La multa se calcula por cada día de retraso
- El monto de multa varía según el tipo de usuario
- Las multas se redondean a 2 decimales
- Multas mayores a $100 generan suspensión temporal

### Devoluciones

- Se puede devolver en cualquier momento
- La devolución antes de la fecha no genera crédito
- La devolución tardía genera multa automática
- Al devolver, el material debe pasar a estado disponible

## Validaciones Importantes

- ID único para cada material, usuario y préstamo
- Email válido para usuarios
- ISBN válido para libros (formato: XXX-X-XXXX-XXXX-X)
- ISSN válido para revistas (formato: XXXX-XXXX)
- Fechas coherentes (devolución no puede ser antes del préstamo)
- Límites de préstamo respetados
- Material existente y disponible antes de prestar
- Usuario existente y sin suspensión

## Casos de Prueba Recomendados

### Escenario 1: Préstamo Normal

1. Registrar estudiante "Juan Pérez"
2. Agregar libro "El Quijote" al catálogo
3. Realizar préstamo exitoso
4. Verificar que el libro ya no está disponible
5. Verificar que Juan tiene 1 préstamo activo
6. Devolver a tiempo
7. Verificar multa = $0

### Escenario 2: Préstamo con Retraso

1. Registrar usuario general "María García"
2. Agregar DVD "Inception" al catálogo
3. Realizar préstamo
4. Simular que pasaron 5 días (fecha límite: 3 días)
5. Devolver con retraso
6. Verificar multa = $4.00 (2 días × $2.00)
7. Verificar que la multa se registró

### Escenario 3: Límite de Préstamos

1. Registrar estudiante con límite de 3 préstamos
2. Prestar 3 libros diferentes
3. Intentar prestar un 4to libro
4. Verificar que se rechaza por límite alcanzado
5. Devolver 1 libro
6. Ahora sí poder prestar el 4to libro

### Escenario 4: Renovación

1. Registrar profesor
2. Prestar libro (permite renovación)
3. Renovar antes de vencimiento
4. Verificar nueva fecha de devolución
5. Intentar renovar por 2da vez
6. Verificar que se rechaza

### Escenario 5: Usuario Suspendido

1. Usuario con multa acumulada de $60
2. Intentar realizar nuevo préstamo
3. Verificar que se rechaza por multas pendientes
4. Pagar multa
5. Ahora sí poder prestar

### Escenario 6: Búsquedas

1. Agregar 10 libros de diferentes autores
2. Buscar por autor "García Márquez"
3. Buscar por título parcial "historia"
4. Listar solo disponibles
5. Listar todos los materiales

## Menú Interactivo

```bash
╔════════════════════════════════════════════════════╗
║         SISTEMA DE GESTIÓN DE BIBLIOTECA           ║
╠════════════════════════════════════════════════════╣
║  GESTIÓN DE MATERIALES                             ║
║    1. Agregar Libro                                ║
║    2. Agregar Revista                              ║
║    3. Agregar DVD                                  ║
║    4. Buscar Material                              ║
║    5. Listar Todos los Materiales                  ║
║    6. Listar Materiales Disponibles                ║
║                                                    ║
║  GESTIÓN DE USUARIOS                               ║
║    7. Registrar Estudiante                         ║
║    8. Registrar Profesor                           ║
║    9. Registrar Usuario General                    ║
║   10. Buscar Usuario                               ║
║   11. Listar Usuarios                              ║
║                                                    ║
║  GESTIÓN DE PRÉSTAMOS                              ║
║   12. Realizar Préstamo                            ║
║   13. Devolver Material                            ║
║   14. Renovar Préstamo                             ║
║   15. Listar Préstamos Activos                     ║
║   16. Listar Préstamos Vencidos                    ║
║                                                    ║
║  REPORTES                                          ║
║   17. Materiales Más Prestados                     ║
║   18. Usuarios con Multas Pendientes               ║
║   19. Estadísticas Generales                       ║
║                                                    ║
║   0. Salir                                         ║
╚════════════════════════════════════════════════════╝
```

## Extras Opcionales (Desafíos)

1. Sistema de Reservas: Permitir reservar materiales prestados
2. Categorías y Etiquetas: Sistema de tags para búsqueda avanzada
3. Historial Completo: Ver todo el historial de un material o usuario
4. Exportar Reportes: Guardar reportes en archivos de texto
5. Sistema de Calificaciones: Usuarios pueden calificar materiales
6. Recomendaciones: Sugerir materiales según historial
7. Múltiples Bibliotecas: Sistema de red de bibliotecas
8. Persistencia: Guardar y cargar datos desde archivos

## Diagrama UML Sugerido

Clases Principales:

- MaterialBibliografico (abstracta)
  - Libro
  - Revista
  - DVD
- Usuario (abstracta)
  - Estudiante
  - Profesor
  - UsuarioGeneral
- Prestamo
- Biblioteca

Interfaces:

- Prestable
- Catalogable
- Notificable

Relaciones:

- Biblioteca tiene una colección de MaterialBibliografico (composición)
- Biblioteca tiene una colección de Usuario (composición)
- Prestamo asocia Usuario con MaterialBibliografico
- MaterialBibliografico implementa Prestable y Catalogable
- Usuario implementa Notificable

## Tiempo Estimado

Fase 1 - Diseño: 1-2 horas

- Diseñar jerarquía de clases
- Definir interfaces
- Establecer relaciones

Fase 2 - Implementación Básica: 3-4 horas

- Crear clases abstractas y concretas
- Implementar interfaces
- Gestión básica de materiales y usuarios

Fase 3 - Lógica de Préstamos: 2-3 horas

- Sistema de préstamos
- Validaciones
- Cálculo de multas

Fase 4 - Funcionalidades Avanzadas: 2-3 horas

- Búsquedas y filtros
- Reportes
- Menú interactivo

Total: 8-10 horas

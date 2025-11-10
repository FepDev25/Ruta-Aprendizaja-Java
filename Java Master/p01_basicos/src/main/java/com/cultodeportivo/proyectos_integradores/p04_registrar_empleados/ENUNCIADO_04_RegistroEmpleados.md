# PROYECTO 04: Sistema de Registro de Empleados 👥

## Dificultad: ⭐⭐⭐⭐

## Descripción General

Desarrolla un sistema completo de gestión de empleados que maneje información personal, cálculo de salarios, asistencias y genere reportes detallados. Este es el proyecto más completo que integra TODOS los conceptos básicos.

## Objetivos de Aprendizaje

- Integración completa de todos los conceptos básicos
- Manejo complejo de arrays multidimensionales
- Cálculos financieros y fechas
- Validaciones exhaustivas
- Formateo profesional de reportes
- Lógica de negocio compleja

## Funcionalidades Requeridas

### Menú Principal

```bash
╔═══════════════════════════════════════════════╗
║   SISTEMA DE GESTIÓN DE EMPLEADOS v2.0        ║
╠═══════════════════════════════════════════════╣
║  1. Gestión de Empleados                      ║
║     → Registrar nuevo empleado                ║
║     → Modificar información                   ║
║     → Eliminar empleado                       ║
║     → Buscar empleado                         ║
║  2. Control de Asistencia                     ║
║     → Registrar entrada/salida                ║
║     → Ver asistencias del mes                 ║
║     → Reporte de ausencias                    ║
║  3. Gestión de Nómina                         ║
║     → Calcular salario                        ║
║     → Agregar bonos/deducciones               ║
║     → Generar recibo de pago                  ║
║  4. Reportes y Estadísticas                   ║
║     → Reporte general                         ║
║     → Empleado del mes                        ║
║     → Estadísticas salariales                 ║
║  5. Configuración del Sistema                 ║
║  0. Salir                                     ║
╚═══════════════════════════════════════════════╝
```

## Información del Empleado

### Datos Personales

- **ID** (generado automáticamente: EMP001, EMP002...)
- **Nombre completo**
- **Fecha de nacimiento** (calcular edad)
- **Género** (M/F/Otro)
- **Dirección**
- **Teléfono** (validar formato)
- **Email** (validar formato)
- **Estado civil** (Soltero/Casado/Divorciado/Viudo)

### Datos Laborales

- **Departamento** (Ventas, IT, RRHH, Finanzas, Operaciones)
- **Cargo/Puesto**
- **Fecha de ingreso** (calcular antigüedad)
- **Tipo de contrato** (Tiempo completo/Medio tiempo/Por horas)
- **Salario base mensual**
- **Nivel de educación** (Secundaria/Técnico/Universitario/Posgrado)
- **Estado** (Activo/Inactivo/Vacaciones/Licencia)

## Módulos Detallados

### 1. Gestión de Empleados

#### 1.1 Registrar Nuevo Empleado

- Solicitar todos los datos personales y laborales
- Validar cada campo según reglas específicas
- Generar ID automático correlativo
- Calcular edad a partir de fecha de nacimiento
- Mostrar resumen y confirmar registro
- Máximo 100 empleados

**Validaciones:**

- Nombre: no vacío, solo letras y espacios
- Fecha nacimiento: formato dd/mm/yyyy, edad entre 18 y 70
- Teléfono: formato (999) 999-9999 o 999-999-9999
- Email: contiene @ y dominio válido
- Salario: mayor a salario mínimo ($500)

#### 1.2 Modificar Información

- Buscar empleado por ID o nombre
- Mostrar datos actuales
- Permitir modificar campos específicos
- Recalcular edad/antigüedad si se modifican fechas
- Confirmar cambios

#### 1.3 Eliminar Empleado

- Buscar empleado
- Mostrar información completa
- Solicitar confirmación (escribir "CONFIRMAR")
- Cambiar estado a "Inactivo" (no eliminar físicamente)
- Registrar fecha de salida

#### 1.4 Buscar Empleado

Opciones de búsqueda:

- Por ID exacto
- Por nombre (búsqueda parcial)
- Por departamento
- Por rango salarial
- Por antigüedad (años en la empresa)

### 2. Control de Asistencia

#### 2.1 Registrar Entrada/Salida

- Buscar empleado por ID
- Registrar hora de entrada
- Registrar hora de salida
- Calcular horas trabajadas del día
- Validar: no puede salir antes de entrar
- Almacenar últimas 30 asistencias por empleado

**Formato de registro:**

```bash
Fecha: 08/11/2025
Empleado: Juan Pérez (EMP001)
Entrada: 08:30 AM
Salida: 05:45 PM
Horas trabajadas: 9h 15min
```

#### 2.2 Ver Asistencias del Mes

- Seleccionar empleado
- Mostrar tabla con todas las asistencias del mes
- Calcular total de horas trabajadas
- Marcar días sin registro (ausencias)
- Calcular puntualidad (llegadas después de las 9:00)

#### 2.3 Reporte de Ausencias

- Listar empleados con ausencias
- Contar días de ausencia por empleado
- Calcular porcentaje de asistencia
- Alertar si ausencias > 3 en el mes

### 3. Gestión de Nómina

#### 3.1 Calcular Salario

Fórmula completa:

```bash
Salario Bruto = Salario Base + Bonos + Horas Extra
Deducciones = Impuestos + Seguro Social + Préstamos
Salario Neto = Salario Bruto - Deducciones
```

**Componentes:**

- **Salario Base**: según tipo de contrato
- **Bono de Antigüedad**: 2% del salario base por cada año
- **Bono de Productividad**: basado en asistencia perfecta (10% del base)
- **Horas Extra**: 1.5x del valor hora normal
- **Impuesto sobre la renta**:
  - 0-1000: 0%
  - 1001-2000: 10%
  - 2001-3000: 15%
  - 3001+: 20%
- **Seguro Social**: 9.75% del salario bruto
- **Préstamos**: monto fijo si aplica

#### 3.2 Agregar Bonos/Deducciones

- Seleccionar empleado
- Tipo: Bono o Deducción
- Concepto: descripción
- Monto: cantidad
- Aplicar solo al mes actual

#### 3.3 Generar Recibo de Pago

```bash
╔════════════════════════════════════════════════╗
║           RECIBO DE PAGO                       ║
║           Mes: Noviembre 2025                  ║
╠════════════════════════════════════════════════╣
║ Empleado: Juan Pérez                           ║
║ ID: EMP001                                     ║
║ Departamento: Ventas                           ║
║ Cargo: Vendedor Senior                         ║
╠════════════════════════════════════════════════╣
║ INGRESOS                                       ║
║   Salario Base:              $1,500.00         ║
║   Bono Antigüedad (3 años):    $90.00         ║
║   Bono Productividad:         $150.00         ║
║   Horas Extra (10h):          $125.00         ║
║   Otros Bonos:                 $50.00         ║
║                              ─────────         ║
║   Salario Bruto:            $1,915.00         ║
╠════════════════════════════════════════════════╣
║ DEDUCCIONES                                    ║
║   Impuesto (10%):             $191.50         ║
║   Seguro Social (9.75%):      $186.71         ║
║   Préstamo:                   $100.00         ║
║                              ─────────         ║
║   Total Deducciones:          $478.21         ║
╠════════════════════════════════════════════════╣
║ SALARIO NETO:               $1,436.79         ║
╚════════════════════════════════════════════════╝
Fecha de pago: 30/11/2025
```

### 4. Reportes y Estadísticas

#### 4.1 Reporte General

- Total de empleados por departamento
- Distribución por género
- Distribución por tipo de contrato
- Edad promedio de empleados
- Antigüedad promedio
- Empleados activos vs inactivos

#### 4.2 Empleado del Mes

Criterios de evaluación:

- Asistencia perfecta: 30 puntos
- Sin llegadas tarde: 25 puntos
- Antigüedad: 5 puntos por año (max 20)
- Sin ausencias: 25 puntos

Mostrar top 3 con puntajes.

#### 4.3 Estadísticas Salariales

- Salario promedio general
- Salario promedio por departamento
- Empleado con mayor salario
- Empleado con menor salario
- Total de nómina mensual
- Gráfico ASCII de distribución salarial

### 5. Configuración del Sistema

- Establecer salario mínimo
- Configurar horario laboral estándar
- Establecer porcentajes de impuestos
- Configurar bonos automáticos
- Ver información del sistema
- Backup de datos (mostrar resumen)

## Requisitos Técnicos

### Estructura de Datos

```java
// Usar arrays paralelos
String[] empleadosIDs = new String[100];
String[] empleadosNombres = new String[100];
String[] empleadosFechaNac = new String[100];
// ... resto de campos

// Para asistencias (matriz 2D)
String[][] asistencias = new String[100][30]; // 100 empleados, 30 días
```

### Validaciones Completas

1. Todos los campos obligatorios
2. Formatos de fecha válidos
3. Rangos numéricos apropiados
4. No duplicar IDs
5. Email y teléfono con formato correcto

### Cálculos Precisos

- Usar double para salarios y porcentajes
- Redondear a 2 decimales
- Validar operaciones matemáticas
- Prevenir división por cero

## Conceptos a Aplicar (TODOS)

### Fundamentos

- Variables de todos los tipos primitivos
- Constantes para valores fijos
- Conversiones de tipos

### Operadores

- Aritméticos: cálculos salariales
- Relacionales: comparaciones
- Lógicos: validaciones compuestas
- Asignación: actualización de datos

### Strings

- Manipulación intensiva
- Formateo de reportes
- Validaciones de formato
- Concatenación eficiente

### Condicionales

- if-else anidados complejos
- switch para menús
- Operador ternario

### Bucles

- for para arrays
- while para menús
- do-while para validaciones
- Bucles anidados

### Wrappers

- Conversiones Integer/Double
- Parsing de strings
- Manejo de excepciones

### Entrada/Salida

- Scanner con validación
- Formateo con printf
- Salidas estructuradas

### Fechas

- Comparación de fechas
- Cálculo de diferencias
- Validación de formatos

## Extras (Opcionales - Desafío Extremo)

1. **Sistema de permisos**: Admin vs Usuario regular
2. **Vacaciones**: Calcular días disponibles
3. **Evaluaciones de desempeño**: Puntuación trimestral
4. **Organigrama**: Mostrar jerarquía con ASCII art
5. **Exportar a CSV**: Generar archivo de texto separado por comas
6. **Búsqueda avanzada**: Múltiples filtros combinados
7. **Dashboard**: Resumen visual con gráficos ASCII

## Casos de Prueba

Registra estos empleados de prueba:

1. **María García** - IT - $2,500 - 5 años antigüedad
2. **Pedro López** - Ventas - $1,800 - 2 años antigüedad
3. **Ana Martínez** - RRHH - $2,000 - 3 años antigüedad
4. **Carlos Ruiz** - Finanzas - $3,200 - 8 años antigüedad

Prueba escenarios:

- Empleado con asistencia perfecta
- Empleado con 5 ausencias
- Cálculo de salario con horas extra
- Modificación de datos
- Búsquedas variadas

## Criterios de Evaluación

- **Funcionalidad completa**: Todas las opciones funcionan
- **Validaciones exhaustivas**: No se rompe con datos inválidos
- **Cálculos precisos**: Nómina calculada correctamente
- **Código organizado**: Estructura clara y limpia
- **Comentarios**: Documentación adecuada
- **Formato profesional**: Salidas bien presentadas
- **Manejo de errores**: Robusto ante entradas inesperadas

## Tiempo Estimado

10-15 horas de desarrollo (el más complejo)

## Consejos Importantes

1. **Divide y conquista**: Implementa un módulo a la vez
2. **Prueba constantemente**: No avances sin probar
3. **Usa métodos auxiliares**: Evita código duplicado
4. **Planifica la estructura de datos**: Piensa antes de codificar
5. **Comenta mientras codificas**: No dejes para después
6. **Maneja los índices con cuidado**: Evita ArrayIndexOutOfBounds
7. **Valida TODO**: El usuario puede ingresar cualquier cosa
8. **Usa constantes**: Para valores que no cambian

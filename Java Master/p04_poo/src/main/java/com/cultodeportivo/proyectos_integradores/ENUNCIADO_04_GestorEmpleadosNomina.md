# PROYECTO 04: Gestor de Empleados y Nómina 👔

## Dificultad: ⭐⭐⭐

## Tiempo Estimado: 8-10 horas

## Descripción

Sistema de recursos humanos que gestiona diferentes tipos de empleados, calcula nóminas con deducciones e impuestos, maneja asistencias, vacaciones y genera recibos de pago.

## Jerarquía de Empleados

### Clase Abstracta: Empleado

Atributos: id, nombre, apellido, RFC, NSS, fechaContratacion, departamento, puesto, status

Métodos abstractos:

- calcularSalarioBruto()
- calcularBonificaciones()
- obtenerTipoContrato()

Métodos concretos:

- calcularAntiguedad()
- estaActivo()
- solicitarVacaciones()

### Subclases

EmpleadoPorHora

- Atributos: tarifaPorHora, horasTrabajadas
- Salario = horas × tarifa
- Sin prestaciones completas
- Tiempo extra: 1.5x después de 40 horas

EmpleadoAsalariado

- Atributos: salarioMensual
- Salario fijo mensual
- Prestaciones completas
- Aguinaldo: 15 días

EmpleadoPorComision

- Atributos: salarioBase, comisionPorcentaje, ventasRealizadas
- Salario = base + (ventas × comisión)
- Bonos por metas
- Sin tope de ingresos

EmpleadoGerente (hereda de EmpleadoAsalariado)

- Atributos: bonoGerencial, equipoACargo
- Bonos por desempeño del equipo
- Prestaciones premium
- Coche de empresa

EmpleadoPracticante

- Atributos: universidad, semestre, tutor
- Salario reducido
- Prestaciones limitadas
- Duración máxima: 6 meses

## Departamentos (Enum)

- RECURSOS_HUMANOS
- VENTAS
- MARKETING
- SISTEMAS
- FINANZAS
- OPERACIONES
- LEGAL

## Clase Nomina

Atributos: período, empleado, salarioBruto, deducciones, bonificaciones, salarioNeto

Conceptos de Pago:

- Salario base
- Tiempo extra
- Bonos de desempeño
- Comisiones
- Compensaciones especiales

Deducciones:

- ISR (Impuesto sobre renta) - progresivo
- IMSS (6.5% del salario)
- Fondo de ahorro (5%)
- Préstamos
- Faltas

Bonificaciones:

- Puntualidad (5% si sin faltas)
- Productividad (según metas)
- Antigüedad (1% por año)
- Bono de transporte
- Vales de despensa

## Clase Asistencia

Atributos: empleado, fecha, horaEntrada, horaSalida, tipo

Tipos:

- ASISTENCIA
- FALTA (sin justificar)
- FALTA_JUSTIFICADA (con justificar)
- RETARDO (después de 15 min)
- PERMISO
- VACACIONES
- INCAPACIDAD

Métodos:

- registrarEntrada()
- registrarSalida()
- calcularHorasTrabajadas()
- esRetardo() - más de 15 min
- aplicarDescuento() - por falta/retardo

## Clase Vacaciones

Atributos: empleado, fechaInicio, fechaFin, días, status, año

Reglas:

- 1 año: 6 días
- 2 años: 8 días
- 3-4 años: 10 días
- 5+ años: 12 días + 2 por cada 5 años

Métodos:

- calcularDiasDisponibles()
- solicitarVacaciones()
- aprobarRechazar()
- verificarSaldoDias()

## Funcionalidades

### 1. Gestión de Empleados

- Contratar empleado (crear expediente)
- Dar de baja (liquidación)
- Actualizar datos personales
- Cambiar departamento/puesto
- Promocionar empleado

### 2. Control de Asistencia

- Registrar entrada/salida diaria
- Reportar faltas y retardos
- Justificar ausencias
- Calcular horas trabajadas
- Generar reporte mensual

### 3. Cálculo de Nómina

- Calcular salario bruto por tipo empleado
- Aplicar deducciones automáticas
- Agregar bonificaciones
- Calcular salario neto
- Generar recibo de pago

### 4. Gestión de Vacaciones

- Solicitar período vacacional
- Aprobar/rechazar solicitudes
- Verificar días disponibles
- Consultar historial
- Calcular prima vacacional

### 5. Reportes

- Nómina total por período
- Empleados por departamento
- Asistencias del mes
- Deducciones totales
- Bonos pagados
- Rotación de personal

## Reglas de Negocio

### Nómina

- Se calcula quincenalmente
- ISR se aplica sobre tabla progresiva
- Deducciones no pueden exceder 30% del salario
- Bonos se pagan según políticas empresa

### Asistencia

- Horario estándar: 8:00 - 17:00
- Tolerancia: 15 minutos
- 3 retardos = 1 falta
- Falta injustificada = descuento día completo

### Vacaciones

- Deben solicitarse 15 días antes
- Mínimo 5 días consecutivos
- Máximo 2 períodos por año
- Prima vacacional: 25% del salario de vacaciones

## Casos de Prueba

### Escenario 1: Cálculo Nómina Asalariado

1. Empleado con salario $15,000/mes
2. Sin faltas (bono puntualidad 5%)
3. 3 años antigüedad (bono 3%)
4. Calcular deducciones (ISR + IMSS)
5. Generar recibo con desglose

### Escenario 2: Empleado Por Hora con Tiempo Extra

1. Tarifa: $150/hora
2. Trabajó 50 horas en la semana
3. 40 horas normales = $6,000
4. 10 horas extra 1.5x = $2,250
5. Total bruto = $8,250

### Escenario 3: Empleado Comisión

1. Salario base: $5,000
2. Ventas del mes: $100,000
3. Comisión: 8%
4. Comisión ganada = $8,000
5. Total = $13,000

### Escenario 4: Solicitud Vacaciones

1. Empleado con 2 años antigüedad (8 días)
2. Ya usó 3 días
3. Disponibles: 5 días
4. Solicita 6 días
5. Sistema rechaza (insuficientes)

### Escenario 5: Control Asistencia

1. Empleado llega 9:20 (retardo)
2. Sistema registra 20 min tarde
3. Es su 3er retardo del mes
4. Se convierte en falta
5. Descuento en nómina

## Menú del Sistema

```bash
╔═══════════════════════════════════════════╗
║    SISTEMA DE GESTIÓN DE EMPLEADOS       ║
╠═══════════════════════════════════════════╣
║  EMPLEADOS                                ║
║    1. Contratar empleado                  ║
║    2. Buscar empleado                     ║
║    3. Actualizar datos                    ║
║    4. Dar de baja                         ║
║    5. Listar por departamento             ║
║                                           ║
║  ASISTENCIAS                              ║
║    6. Registrar entrada                   ║
║    7. Registrar salida                    ║
║    8. Justificar falta                    ║
║    9. Ver asistencias del mes             ║
║                                           ║
║  NÓMINA                                   ║
║   10. Calcular nómina individual          ║
║   11. Calcular nómina general             ║
║   12. Generar recibo de pago              ║
║   13. Ver historial de pagos              ║
║                                           ║
║  VACACIONES                               ║
║   14. Solicitar vacaciones                ║
║   15. Aprobar/rechazar solicitud          ║
║   16. Consultar días disponibles          ║
║                                           ║
║  REPORTES                                 ║
║   17. Nómina total                        ║
║   18. Asistencias y faltas                ║
║   19. Empleados activos                   ║
║                                           ║
║   0. Salir                                ║
╚═══════════════════════════════════════════╝
```

## Formato Recibo de Pago

```bash
═══════════════════════════════════════════════
           EMPRESA XYZ S.A. DE C.V.
              RECIBO DE NÓMINA
═══════════════════════════════════════════════
Período: 01/11/2025 - 15/11/2025
Folio: NOM-2025-001234

DATOS DEL EMPLEADO
───────────────────────────────────────────────
Nombre: Juan Pérez García
RFC: PEGJ850615ABC
NSS: 12345678901
Departamento: SISTEMAS
Puesto: Desarrollador Senior
Antigüedad: 3 años 5 meses

PERCEPCIONES
───────────────────────────────────────────────
Salario base             $15,000.00
Bono puntualidad             $750.00
Bono antigüedad              $450.00
Vales despensa             $1,500.00
                        ───────────
Subtotal percepciones   $17,700.00

DEDUCCIONES
───────────────────────────────────────────────
ISR                       $2,100.00
IMSS                      $1,155.00
Fondo ahorro                $750.00
                        ───────────
Subtotal deducciones     $4,005.00

═══════════════════════════════════════════════
NETO A PAGAR:           $13,695.00
═══════════════════════════════════════════════
Método de pago: Transferencia bancaria
Cuenta:    1234
Fecha de pago: 15/11/2025
═══════════════════════════════════════════════
```

## Extras Opcionales

1. Evaluación de Desempeño: Calificaciones trimestrales
2. Capacitaciones: Registro de cursos tomados
3. Organigrama: Visualizar estructura
4. Préstamos: Solicitud y descuento automático
5. Incidencias: Reporte de problemas
6. Horarios Flexibles: Diferentes turnos
7. Home Office: Registro remoto
8. Beneficios: Seguro, gimnasio, comedor

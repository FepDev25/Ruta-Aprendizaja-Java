# PROYECTO 08: Centro Médico y Citas 🏥

## Dificultad: ⭐⭐⭐⭐ | Tiempo: 10-12 horas

## Descripción

Sistema hospitalario integral que gestiona pacientes, doctores por especialidad, citas médicas, historiales clínicos, recetas, estudios de laboratorio y facturación de servicios.

## Jerarquía Principal

### Clase Paciente

Atributos: id, nombre, apellidos, fechaNacimiento, genero, tipoSangre, NSS, RFC, teléfono, email, dirección, contactoEmergencia, alergias

Métodos: agendarCita(), verHistorialClinico(), verRecetas(), calcularEdad(), tieneSeguro()

### Clase Abstracta: PersonalMedico

Subclases: Doctor, Enfermero, Administrador

Atributos comunes: id, nombre, cedulaProfesional, especialidad, turno, salario

Métodos abstractos: calcularSalario(), puedeAtender(), obtenerHorario()

### Clase Doctor (hereda PersonalMedico)

Atributos: especialidad, subespecialidad, añosExperiencia, pacientesAtendidos, calificacionPromedio

Especialidades (Enum): MEDICINA_GENERAL, PEDIATRIA, CARDIOLOGIA, NEUROLOGIA, DERMATOLOGIA, GINECOLOGIA, TRAUMATOLOGIA, OFTALMOLOGIA, PSIQUIATRIA, ONCOLOGIA

Métodos:

- verAgenda()
- atenderPaciente()
- prescribirMedicamento()
- solicitarEstudios()
- darDiagnostico()

### Clase Cita

Atributos: id, paciente, doctor, fechaHora, duracion, motivo, estado, consultorio, costoConsulta

Estados: PROGRAMADA, CONFIRMADA, EN_CURSO, COMPLETADA, CANCELADA, NO_ASISTIO

Tipos: PRIMERA_VEZ, SEGUIMIENTO, URGENCIA, CIRUGIA

Métodos:

- confirmar()
- cancelar()
- reprogramar()
- iniciarConsulta()
- finalizarConsulta()
- generarNotasMedicas()

### Clase HistorialClinico

Atributos: paciente, consultas, diagnosticos, tratamientos, cirugias, alergias, padecimientosCronicos, vacunas

Métodos:

- agregarConsulta()
- agregarDiagnostico()
- agregarTratamiento()
- verHistorialCompleto()
- generarResumen()
- exportarPDF() - simulado

### Clase Consulta

Atributos: fecha, doctor, motivoConsulta, sintomasPaciente, signosVitales, diagnostico, tratamiento, observaciones, proximaCita

SignosVitales: presionArterial, frecuenciaCardiaca, temperatura, peso, altura, IMC, saturacionOxigeno

Métodos:

- registrarSignosVitales()
- calcularIMC()
- establecerDiagnostico()
- prescribirTratamiento()

### Clase Receta

Atributos: id, paciente, doctor, fecha, vigencia, medicamentos, indicaciones

Métodos:

- agregarMedicamento()
- verificarVigencia()
- surtirReceta()
- generarRecetaImpresa()

### Clase Medicamento

Atributos: nombre, dosis, frecuencia, duracion, viaAdministracion, indicaciones

ViasAdministracion: ORAL, INTRAVENOSA, INTRAMUSCULAR, TOPICA, SUBLINGUAL

### Clase EstudioLaboratorio

Atributos: id, paciente, tipo, fechaSolicitud, fechaResultado, estado, resultados, interpretacion

Tipos: SANGRE, ORINA, RAYOS_X, TOMOGRAFIA, RESONANCIA, ULTRASONIDO, ELECTROCARDIOGRAMA

Estados: SOLICITADO, EN_PROCESO, LISTO, ENTREGADO

### Clase Factura

Atributos: id, paciente, fecha, conceptos, subtotal, descuento, IVA, total, metodoPago, pagada

Conceptos: Consulta, Estudios, Medicamentos, Procedimientos, Hospitalización

Métodos:

- agregarConcepto()
- aplicarDescuento() - por seguro
- calcularTotal()
- generarRecibo()
- registrarPago()

### Sistema de Seguros

Interface Asegurable: calcularCobertura(), validarPoliza(), procesarReembolso()

Tipos Seguro: PARTICULAR (sin seguro), SEGURO_POPULAR, IMSS, ISSSTE, PRIVADO

Coberturas:

- Sin seguro: 100% del costo
- Seguro popular: 90% cubierto
- IMSS/ISSSTE: 100% cubierto
- Privado: según póliza (60-100%)

## Funcionalidades

### 1. Gestión de Pacientes

- Registrar nuevo paciente
- Actualizar datos personales
- Ver historial clínico completo
- Buscar paciente por nombre/NSS
- Ver citas programadas
- Agregar alergias y padecimientos

### 2. Gestión de Doctores

- Registrar doctor con especialidad
- Ver agenda del día
- Ver pacientes atendidos
- Estadísticas de consultas
- Calificación promedio

### 3. Sistema de Citas

- Agendar nueva cita
- Ver disponibilidad de doctores
- Confirmar asistencia
- Cancelar/reprogramar cita
- Sistema de recordatorios (24h antes)
- Lista de espera para cancelaciones

### 4. Consulta Médica

- Registrar signos vitales
- Ingresar motivo de consulta
- Registrar exploración física
- Establecer diagnóstico
- Prescribir medicamentos
- Solicitar estudios de laboratorio
- Generar notas médicas
- Programar seguimiento

### 5. Recetas y Medicamentos

- Generar receta médica
- Listar medicamentos prescritos
- Verificar vigencia
- Historial de recetas
- Control de medicamentos controlados

### 6. Estudios de Laboratorio

- Solicitar estudios
- Registrar resultados
- Ver estudios pendientes
- Interpretar resultados
- Adjuntar imágenes (simulado)

### 7. Facturación

- Generar factura de consulta
- Agregar servicios adicionales
- Aplicar cobertura de seguro
- Procesar pago
- Generar recibo
- Historial de pagos

### 8. Reportes

- Pacientes atendidos por período
- Ingresos por servicio
- Consultas por especialidad
- Doctores más solicitados
- Estadísticas de ocupación
- Citas canceladas/no show
- Enfermedades más comunes

## Reglas de Negocio

### Citas

- Duración estándar: 30 minutos
- No se pueden agendar citas en horarios ocupados
- Cancelación con menos de 2 horas: cargo 50%
- Máximo 3 no-shows = suspensión temporal
- Urgencias tienen prioridad

### Consultas

- Primera vez: requiere historia clínica completa
- Seguimiento: máximo cada 3 meses mismo doctor
- Signos vitales obligatorios en toda consulta
- Receta válida por 30 días

### Facturación

- Consulta general: $500
- Especialista: $800
- Urgencias: $1,200
- IVA 0% (servicios médicos exentos)
- Seguro descuenta automáticamente

### Horarios

- Lunes-Viernes: 8:00-20:00
- Sábados: 9:00-14:00
- Domingos: Solo urgencias
- Cada doctor tiene horario específico

## Casos de Prueba

Escenario 1: Primera Consulta

1. Registrar paciente nuevo "Juan Pérez"
2. Llenar historia clínica (alergias: penicilina)
3. Agendar cita con Dr. García (cardiología)
4. Fecha: mañana 10:00 AM
5. Verificar disponibilidad del doctor
6. Confirmar cita
7. Enviar recordatorio (simulado)

Escenario 2: Consulta Completa

1. Paciente llega a consulta
2. Enfermera toma signos vitales
3. Doctor atiende: presión alta (140/90)
4. Diagnóstico: Hipertensión
5. Prescribe medicamento: Losartán 50mg c/24h
6. Genera receta válida 30 días
7. Solicita estudios: perfil lipídico
8. Programa seguimiento en 1 mes

Escenario 3: Sistema de Seguros

1. Paciente con seguro privado (80% cobertura)
2. Consulta: $800
3. Cobertura: $800 × 0.80 = $640
4. Paciente paga: $160
5. Generar factura con desglose
6. Enviar a aseguradora para reembolso

Escenario 4: Cancelación de Cita

1. Paciente agenda cita para pasado mañana
2. Intenta cancelar con 1 hora de anticipación
3. Sistema cobra 50% por cancelación tardía
4. Libera espacio en agenda doctor
5. Notifica a pacientes en lista de espera

Escenario 5: Urgencia Médica

1. Paciente llega a urgencias sin cita
2. Sistema busca doctor disponible
3. Asigna Dr. López (turno actual)
4. Consulta tipo URGENCIA
5. Costo: $1,200
6. Atención inmediata (priority)

## Menú del Sistema

```bash
╔══════════════════════════════════════════╗
║      SISTEMA CENTRO MÉDICO               ║
╠══════════════════════════════════════════╣
║  PACIENTES                               ║
║    1. Registrar paciente                 ║
║    2. Buscar paciente                    ║
║    3. Ver historial clínico              ║
║    4. Actualizar datos                   ║
║                                          ║
║  CITAS                                   ║
║    5. Agendar cita                       ║
║    6. Ver citas del día                  ║
║    7. Confirmar cita                     ║
║    8. Cancelar/reprogramar               ║
║    9. Ver disponibilidad doctores        ║
║                                          ║
║  CONSULTAS                               ║
║   10. Iniciar consulta                   ║
║   11. Registrar signos vitales           ║
║   12. Diagnosticar                       ║
║   13. Prescribir medicamento             ║
║   14. Solicitar estudios                 ║
║   15. Finalizar consulta                 ║
║                                          ║
║  ESTUDIOS                                ║
║   16. Ver estudios pendientes            ║
║   17. Registrar resultados               ║
║   18. Entregar resultados                ║
║                                          ║
║  FACTURACIÓN                             ║
║   19. Generar factura                    ║
║   20. Procesar pago                      ║
║   21. Ver pagos pendientes               ║
║                                          ║
║  REPORTES                                ║
║   22. Pacientes atendidos                ║
║   23. Ingresos del día                   ║
║   24. Estadísticas doctores              ║
║                                          ║
║   0. Salir                               ║
╚══════════════════════════════════════════╝
```

## Formato Receta Médica

```bash
╔══════════════════════════════════════════════╗
║         CENTRO MÉDICO "SALUD PLUS"           ║
║        Calle Reforma #123, CDMX              ║
║           Tel: (55) 1234-5678                ║
╠══════════════════════════════════════════════╣
║               RECETA MÉDICA                  ║
╠══════════════════════════════════════════════╣
Fecha: 09/11/2025
Folio: RX-2025-001234

DATOS DEL MÉDICO
Dr. Roberto García Martínez
Cédula: 1234567
Especialidad: Cardiología

DATOS DEL PACIENTE
Nombre: Juan Pérez López
Edad: 45 años
NSS: 12345678901

PRESCRIPCIÓN
────────────────────────────────────────────────
1. Losartán 50 mg
   Tomar 1 tableta cada 24 horas
   Duración: 30 días
   Vía: Oral

2. Atorvastatina 20 mg
   Tomar 1 tableta cada 24 horas (noche)
   Duración: 30 días
   Vía: Oral

────────────────────────────────────────────────
INDICACIONES GENERALES:
- Tomar medicamentos con alimentos
- Evitar alcohol
- Control en 30 días

Vigencia: 30 días
Próxima cita: 09/12/2025 10:00 AM

                    _______________________
                    Firma del Médico
╚══════════════════════════════════════════════╝
```

## Extras Opcionales

1. Expediente Electrónico: Digitalización completa
2. Telemedicina: Consultas virtuales
3. App Paciente: Agendar, ver recetas
4. Inventario Farmacia: Control medicamentos
5. Hospitalización: Camas, internamiento
6. Quirófano: Programación cirugías
7. Imagenología: Gestión de estudios
8. Ambulancias: Servicio de urgencias

¡Administra un centro médico completo! 🏥💉

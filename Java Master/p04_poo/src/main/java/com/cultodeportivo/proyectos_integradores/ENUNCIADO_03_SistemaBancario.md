# PROYECTO 03: Sistema Bancario Multi-Cuenta 🏦

## Dificultad: ⭐⭐⭐⭐

## Tiempo Estimado: 10-12 horas

## Descripción

Sistema bancario completo con múltiples tipos de cuentas, operaciones financieras, clientes, tarjetas y auditoría de transacciones. Implementa reglas bancarias reales y manejo de excepciones personalizado.

## Jerarquía Principal

### Clase Abstracta: CuentaBancaria

Atributos: numeroCuenta, titular (Cliente), saldo, fechaApertura, estado, tasaInteres

Métodos abstractos:

- calcularInteresMensual()
- aplicarComisionMantenimiento()
- obtenerLimiteTransferencia()

Métodos concretos:

- depositar(monto)
- retirar(monto) - valida saldo
- transferir(cuentaDestino, monto)
- consultarSaldo()
- generarEstadoCuenta()

### Subclases de Cuenta

CuentaAhorro

- Tasa de interés: 2% anual
- Comisión: $5/mes si saldo < $500
- Límite retiros: 6 por mes
- Sin cheques

CuentaCorriente

- Sobregiro permitido: hasta $1,000
- Comisión manejo: $10/mes
- Cheques ilimitados
- Sin límite de retiros

CuentaNomina

- Sin comisión si hay depósito mensual
- Tasa interés: 0.5%
- Tarjeta débito gratis
- Retiros ilimitados

CuentaInversion

- Tasa interés: 5% anual
- Saldo mínimo: $10,000
- Plazo fijo o variable
- Penalidad por retiro anticipado

### Clase Cliente

Atributos: id, nombre, apellido, RFC, CURP, fechaNacimiento, email, teléfono, dirección, tipoCliente

Tipos de Cliente:

- ClienteBasico: 1 cuenta permitida
- ClientePremium: hasta 5 cuentas, tasas preferenciales
- ClienteEmpresarial: cuentas ilimitadas, gerente asignado

Métodos:

- abrirCuenta()
- cerrarCuenta()
- solicitarTarjeta()
- verHistorialTransacciones()

### Clase Tarjeta

TarjetaDebito (asociada a cuenta)

- Límite diario retiros ATM: $5,000
- Límite compras: según saldo
- Sin comisión

TarjetaCredito

- Línea de crédito asignada
- Tasa interés: 18% anual
- Pago mínimo: 10% del saldo
- Fecha de corte y pago

### Clase Transaccion

Tipos:

- Depósito (efectivo, cheque, transferencia)
- Retiro (ATM, ventanilla)
- Transferencia (interbancaria, mismo banco)
- Pago de servicios
- Compra con tarjeta

Atributos:

- id, tipo, monto, fecha, cuentaOrigen, cuentaDestino, concepto, estatus

### Excepciones Personalizadas

- `SaldoInsuficienteException`
- `LimiteExcedidoException`
- `CuentaBloqueadaException`
- `TransaccionNoAutorizadaException`

## Funcionalidades Principales

### 1. Gestión de Cuentas

- Abrir cuenta (requiere depósito inicial)
- Cerrar cuenta (validar saldo en 0)
- Bloquear/desbloquear cuenta
- Cambiar tipo de cuenta
- Consultar saldo y movimientos

### 2. Operaciones Bancarias

- Depósito en efectivo/cheque
- Retiro (validar límites)
- Transferencia entre cuentas
- Pago de servicios (luz, agua, teléfono)
- Domiciliación de pagos

### 3. Gestión de Tarjetas

- Solicitar tarjeta débito/crédito
- Activar/desactivar tarjeta
- Reportar robo/extravío
- Cambiar NIP
- Consultar movimientos de tarjeta

### 4. Intereses y Comisiones

- Cálculo automático de intereses mensuales
- Aplicación de comisiones según tipo cuenta
- Penalizaciones por sobregiro
- Bonificaciones por saldo promedio

### 5. Auditoría y Seguridad

- Registro de todas las operaciones
- Bitácora de accesos
- Detección de movimientos sospechosos
- Límites de montos por transacción
- Autenticación en dos pasos (simulado)

### 6. Reportes

- Estado de cuenta mensual
- Historial de transacciones
- Análisis de gastos por categoría
- Proyección de intereses
- Resumen fiscal anual

## Reglas de Negocio

### Apertura de Cuenta

- Cliente debe ser mayor de 18 años
- Depósito inicial mínimo: $100 (ahorro), $500 (corriente), $10,000 (inversión)
- Requiere identificación oficial
- Máximo de cuentas según tipo cliente

### Transacciones

- Retiros mayores a $10,000 requieren aviso previo
- Transferencias interbancarias tardan 24-48 horas
- Transferencias mismo banco: inmediatas
- Límite diario transferencias: $50,000
- Horario operaciones: 8:00 - 20:00

### Intereses

- Se calculan sobre saldo promedio mensual
- Se abonan el último día del mes
- Impuesto (ISR) se retiene automáticamente

### Comisiones

- Por retiro en ATM de otro banco: $15
- Por consulta saldo ATM otro banco: $5
- Por reposición de tarjeta: $100
- Por estado de cuenta impreso: $20

## Casos de Prueba

### Escenario 1: Apertura y Depósitos

1. Registrar cliente "María López"
2. Abrir cuenta de ahorro con $500
3. Realizar depósito de $1,000
4. Verificar saldo = $1,500
5. Generar número de cuenta único

### Escenario 2: Transferencia Entre Cuentas

1. Cuenta A con $5,000
2. Cuenta B con $1,000
3. Transferir $2,000 de A a B
4. Validar saldo A = $3,000
5. Validar saldo B = $3,000
6. Registrar transacción en ambas cuentas

### Escenario 3: Retiro Excediendo Saldo

1. Cuenta con $500
2. Intentar retirar $600
3. Lanzar SaldoInsuficienteException
4. Saldo permanece en $500
5. Registrar intento fallido

### Escenario 4: Sobregiro en Cuenta Corriente

1. Cuenta corriente con $100
2. Límite sobregiro: $1,000
3. Retirar $500
4. Saldo queda en -$400
5. Aplicar interés por sobregiro

### Escenario 5: Cálculo de Intereses

1. Cuenta ahorro con saldo promedio $10,000
2. Tasa: 2% anual
3. Interés mensual = $10,000 × 0.02 / 12 = $16.67
4. Abonar al final del mes
5. Aplicar retención ISR

### Escenario 6: Límite de Retiros

1. Cuenta ahorro (límite: 6 retiros/mes)
2. Realizar 6 retiros exitosos
3. Intentar 7mo retiro
4. Lanzar LimiteExcedidoException
5. Sugerir esperar siguiente mes

## Menú del Sistema

```bash
╔══════════════════════════════════════════╗
║       SISTEMA BANCARIO - BankApp         ║
╠══════════════════════════════════════════╣
║  GESTIÓN DE CLIENTES                     ║
║    1. Registrar nuevo cliente            ║
║    2. Buscar cliente                     ║
║    3. Actualizar datos cliente           ║
║                                          ║
║  GESTIÓN DE CUENTAS                      ║
║    4. Abrir cuenta                       ║
║    5. Consultar saldo                    ║
║    6. Ver estado de cuenta               ║
║    7. Cerrar cuenta                      ║
║                                          ║
║  OPERACIONES                             ║
║    8. Depositar                          ║
║    9. Retirar                            ║
║   10. Transferir                         ║
║   11. Pagar servicio                     ║
║                                          ║
║  TARJETAS                                ║
║   12. Solicitar tarjeta                  ║
║   13. Consultar movimientos tarjeta      ║
║   14. Reportar tarjeta                   ║
║                                          ║
║  REPORTES                                ║
║   15. Estado de cuenta                   ║
║   16. Historial transacciones            ║
║   17. Análisis de gastos                 ║
║                                          ║
║   0. Salir                               ║
╚══════════════════════════════════════════╝
```

## Extras Opcionales

1. Simulador de Créditos: Calcular pagos de préstamos
2. Inversiones: Compra de CETES, fondos
3. Banca Móvil: Interfaz simplificada
4. Alertas: Notificaciones de movimientos
5. Presupuestos: Establecer límites de gasto
6. Metas de Ahorro: Objetivos financieros
7. Cashback: Recompensas por compras
8. Criptomonedas: Compra/venta simulada

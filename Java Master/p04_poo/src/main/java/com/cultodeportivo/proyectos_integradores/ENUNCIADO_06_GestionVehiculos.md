# PROYECTO 06: Sistema de Gestión de Vehículos 🚗

## Dificultad: ⭐⭐⭐ | Tiempo: 8-10 horas

## Descripción

Agencia de renta y venta de vehículos con diferentes tipos (autos, motos, camiones), sistema de alquiler, mantenimiento, seguros y cálculo de costos según características.

## Jerarquía de Vehículos

### Clase Abstracta: Vehiculo

Atributos: id, marca, modelo, año, color, kilometraje, precio, status, VIN, placas

Métodos abstractos: calcularDepreciacion(), calcularCostoMantenimiento(), obtenerCapacidad()

Métodos concretos: estaDisponible(), necesitaMantenimiento(), registrarKilometraje()

### Subclases

Automovil

- Atributos: numeroPuertas, tipoTransmision, tipoCombustible, numeroAsientos
- Tipos: SEDAN, SUV, HATCHBACK, COUPE, CONVERTIBLE
- Depreciación: 15% anual
- Mantenimiento cada 10,000 km

Motocicleta

- Atributos: cilindrada, tipoMoto (deportiva, cruiser, touring)
- Depreciación: 20% anual
- Mantenimiento cada 5,000 km
- Requiere licencia tipo A

Camion

- Atributos: capacidadCarga (toneladas), numeroEjes, tipoCamion
- Tipos: CARGA, VOLTEO, REFRIGERADO, TANQUE
- Depreciación: 10% anual
- Mantenimiento cada 15,000 km
- Requiere licencia federal

VehiculoElectrico (puede ser auto o moto)

- Atributos: capacidadBateria, autonomia, tiempoRecarga
- Sin combustible
- Mantenimiento reducido 50%
- Subsidio gubernamental en compra

## Clase Cliente

Atributos: id, nombre, licencia (tipo y vigencia), historialRentas, creditScore

Tipos Cliente: INDIVIDUAL, EMPRESARIAL, GOBIERNO

Métodos: rentarVehiculo(), devolverVehiculo(), comprarVehiculo(), verHistorial()

## Clase Renta

Atributos: id, cliente, vehiculo, fechaInicio, fechaFin, diasRentados, costoTotal, seguro, status

Status: ACTIVA, COMPLETADA, CANCELADA, EXTENDIDA

Métodos: calcularCosto(), extenderRenta(), aplicarPenalizacion(), generarContrato()

### Cálculo de Costos Renta

- Auto estándar: $400/día
- Auto lujo: $800/día
- Moto: $250/día
- Camión pequeño: $600/día
- Camión grande: $1,200/día
- Descuento por período: 7+ días (-10%), 15+ días (-20%), 30+ días (-30%)
- Seguro básico: +$50/día
- Seguro completo: +$100/día
- GPS: +$30/día
- Silla bebé: +$20/día

## Sistema de Mantenimiento

Clase Mantenimiento

Tipos: PREVENTIVO, CORRECTIVO, EMERGENCIA

Servicios:

- Cambio aceite
- Cambio llantas
- Revisión frenos
- Alineación y balanceo
- Reparación motor
- Pintura
- Lavado

Atributos: vehiculo, fecha, tipo, servicios realizados, costo, mecanicoAsignado

## Sistema de Seguros

Interface Asegurable: calcularPrima(), renovarSeguro(), reportarSiniestro()

Tipos Cobertura:

- Responsabilidad civil (obligatorio)
- Daños materiales
- Robo total
- Daños a terceros
- Gastos médicos

## Funcionalidades

### 1. Gestión de Inventario

- Agregar vehículo al inventario
- Actualizar datos vehículo
- Cambiar status (disponible/rentado/mantenimiento/vendido)
- Buscar por marca, modelo, tipo
- Ver vehículos disponibles para renta

### 2. Sistema de Rentas

- Cotizar renta (calcular costo estimado)
- Reservar vehículo
- Iniciar renta (generar contrato)
- Extender renta
- Finalizar renta
- Calcular cargos extra (kilometraje, daños)

### 3. Ventas

- Publicar vehículo en venta
- Calcular precio con depreciación
- Negociar precio
- Vender vehículo
- Transferencia de propiedad

### 4. Mantenimiento

- Agendar mantenimiento preventivo
- Registrar reparaciones
- Calcular costos de mantenimiento
- Alertas de servicio próximo
- Historial de mantenimientos

### 5. Gestión de Clientes

- Registrar cliente
- Verificar licencia válida
- Ver historial de rentas
- Calcular puntaje cliente (buen pagador, sin daños)
- Lista negra (clientes problemáticos)

### 6. Reportes

- Ingresos por rentas
- Vehículos más rentados
- Mantenimientos del mes
- Vehículos requieren servicio
- Utilización de flota (% tiempo rentado)

## Reglas de Negocio

- Cliente debe tener licencia vigente apropiada para el vehículo
- Edad mínima: 21 años para autos, 18 para motos
- Depósito requerido: $2,000 (auto), $1,000 (moto), $5,000 (camión)
- Kilometraje incluido: 200 km/día, exceso: $2/km
- Gasolina: cliente devuelve con mismo nivel o paga reposición + 20%
- Daños: se cobra según peritaje
- Multas de tránsito: responsabilidad del cliente + cargo administrativo

## Casos de Prueba

Escenario 1: Renta Simple

1. Cliente solicita auto sedan
2. Sistema muestra disponibles
3. Cliente selecciona por 5 días
4. Costo: $400 × 5 = $2,000
5. \n+ Seguro básico $250
6. Total: $2,250
7. Generar contrato

Escenario 2: Renta con Descuento

1. Cliente renta camión 10 días
2. $1,200 × 10 = $12,000
3. Descuento 10% (>7 días) = -$1,200
4. Total: $10,800

Escenario 3: Devolución con Cargos

1. Auto rentado con 200 km incluidos/día × 3 días = 600 km
2. Cliente devuelve con 900 km recorridos
3. Exceso: 300 km × $2 = $600 extra
4. Gasolina 1/4 tanque menos: $500
5. Cargos adicionales: $1,100

Escenario 4: Mantenimiento Automático

1. Auto con 9,800 km
2. Cliente renta 5 días, recorre 1,000 km
3. Al devolver tiene 10,800 km
4. Sistema alerta: requiere mantenimiento (cada 10,000 km)
5. Auto pasa a status MANTENIMIENTO
6. No disponible hasta servicio

## Menú del Sistema

```bash
╔══════════════════════════════════════════╗
║    SISTEMA DE GESTIÓN DE VEHÍCULOS       ║
╠══════════════════════════════════════════╣
║  INVENTARIO                              ║
║    1. Ver todos los vehículos            ║
║    2. Agregar vehículo                   ║
║    3. Buscar vehículo                    ║
║    4. Actualizar datos                   ║
║                                          ║
║  RENTAS                                  ║
║    5. Nueva renta                        ║
║    6. Extender renta                     ║
║    7. Finalizar renta                    ║
║    8. Ver rentas activas                 ║
║    9. Historial rentas                   ║
║                                          ║
║  VENTAS                                  ║
║   10. Publicar en venta                  ║
║   11. Vender vehículo                    ║
║                                          ║
║  MANTENIMIENTO                           ║
║   12. Agendar servicio                   ║
║   13. Registrar reparación               ║
║   14. Ver próximos servicios             ║
║                                          ║
║  CLIENTES                                ║
║   15. Registrar cliente                  ║
║   16. Ver historial cliente              ║
║                                          ║
║  REPORTES                                ║
║   17. Ingresos del mes                   ║
║   18. Vehículos más rentados             ║
║                                          ║
║   0. Salir                               ║
╚══════════════════════════════════════════╝
```

## Extras Opcionales

1. Sistema de reservas online
2. Rastreo GPS en tiempo real
3. Seguro integrado con aseguradora
4. Promociones y descuentos especiales
5. Programa de lealtad
6. App móvil para clientes
7. Inspección con fotos pre/post renta
8. Firma digital de contratos

# PROYECTO 02: Tienda Online con Carrito de Compras 🛒

## Dificultad: ⭐⭐⭐⭐

## Descripción General

E-commerce completo con catálogo de productos, carrito de compras, sistema de pagos múltiple, aplicación de descuentos, gestión de inventario y generación de facturas. Incluye diferentes categorías de productos con comportamientos específicos.

## Objetivos de Aprendizaje

- Implementar herencia con múltiples niveles
- Usar interfaces para métodos de pago
- Aplicar Strategy Pattern con descuentos
- Trabajar con composición (Carrito contiene Productos)
- Usar genéricos para colecciones tipadas
- Calcular impuestos y descuentos complejos

## Estructura del Sistema

### Jerarquía de Productos

Clase Abstracta: Producto

Atributos:

- id, nombre, descripción, precio base, stock disponible, categoría, marca

Métodos abstractos:

- calcularPrecioFinal() - cada tipo aplica su lógica
- esElegibleParaDescuento()
- obtenerDetallesCompletos()

Métodos concretos:

- reducirStock(), aumentarStock(), estaDisponible()

Subclases de Producto:

Electronico

- Atributos adicionales: garantíaMeses, voltaje, consumoWatts
- Precio final: precio base + 16% IVA
- Descuento máximo: 15%
- Garantía extendida: +$50

Ropa

- Atributos adicionales: talla, color, material, temporada
- Precio final: precio base + 8% IVA
- Descuento máximo: 40% (temporada anterior)
- Envío gratis si precio > $50

Alimento

- Atributos adicionales: fechaCaducidad, temperatura almacenamiento, calorías
- Precio final: precio base (exento de IVA)
- No permite devolución
- Descuento por fecha próxima a vencer

Libro

- Atributos adicionales: ISBN, autor, editorial, numeroPaginas, idioma
- Precio final: precio base + 0% IVA (exento)
- Descuento máximo: 25%
- Permite venta digital o física

### Interfaces del Sistema

Descargable (para productos digitales)

- obtenerEnlaceDescarga()
- generarCodigoActivacion()
- verificarLicencia()

Devolvible (no todos los productos permiten devolución)

- puedeDevolvorse()
- calcularCostoDevolucion()
- obtenerPeriodoDevolución() - retorna días

Envolvible (para regalo)

- aplicarEnvoltorio()
- agregarMensajePersonalizado()
- calcularCostoEnvoltorio()

Promocionable

- aplicarDescuento()
- verificarElegibilidadPromocion()
- calcularPrecioConDescuento()

### Sistema de Carrito de Compras

Clase ItemCarrito

Atributos:

- producto
- cantidad
- precioUnitario en momento de agregar
- descuento aplicado

Métodos:

- calcularSubtotal()
- aplicarDescuento()
- aumentarCantidad()
- disminuirCantidad()

Clase CarritoCompras

Atributos:

- cliente propietario
- lista de ItemCarrito
- fecha de creación
- cupón de descuento aplicado

Métodos principales:

- agregarProducto()
- eliminarProducto()
- actualizarCantidad()
- vaciarCarrito()
- calcularSubtotal() - suma sin impuestos ni descuentos
- calcularDescuentos() - suma todos los descuentos
- calcularImpuestos() - suma IVA de todos los productos
- calcularTotal() - subtotal + impuestos - descuentos
- aplicarCuponDescuento()
- verificarDisponibilidadStock()

### Jerarquía de Clientes

Clase Cliente

Atributos:

- id, nombre, email, teléfono, dirección, fechaRegistro

Métodos:

- realizarCompra()
- verHistorialCompras()
- agregarDireccionEnvio()

ClienteRegular (hereda de Cliente)

- Descuento estándar: 0%
- Puntos por compra: 1 punto por cada $10
- Envío gratuito: compras > $100

ClienteVIP (hereda de Cliente)

- Descuento estándar: 5%
- Puntos por compra: 2 puntos por cada $10
- Envío gratuito: siempre
- Acceso a ventas exclusivas

ClientePremium (hereda de ClienteVIP)

- Descuento estándar: 10%
- Puntos por compra: 3 puntos por cada $10
- Cashback: 2% de cada compra
- Soporte prioritario

### Sistema de Pagos (Interfaces)

Interface MetodoPago

- procesarPago()
- validarDatos()
- generarComprobante()
- obtenerComision() - algunos métodos tienen comisión

Implementaciones:

PagoTarjetaCredito

- número, titular, fechaVencimiento, CVV
- Comisión: 3.5%
- Permite cuotas

PagoTarjetaDebito

- número, banco, titular
- Comisión: 1.5%
- Pago inmediato

PagoPayPal

- email de cuenta
- Comisión: 4%
- Protección al comprador

PagoTransferencia

- cuenta bancaria, referencia
- Sin comisión
- Requiere validación manual

PagoEfectivo

- código de referencia para pagar en tienda
- Sin comisión
- 48 horas para completar

### Sistema de Descuentos

Interface EstrategiaDescuento

- calcularDescuento()
- esAplicable()
- obtenerDescripcion()

Implementaciones:

DescuentoPorcentaje

- porcentaje de descuento
- aplica a toda la compra

DescuentoFijo

- monto fijo a descontar
- mínimo de compra requerido

DescuentoPorCategoria

- aplica solo a productos de cierta categoría
- porcentaje específico

Descuento2x1

- compra 2 productos, paga 1
- válido en productos específicos

DescuentoPorVolumen

- descuento escalonado según cantidad
- 5 productos: 5%, 10 productos: 10%, 20+: 20%

### Clase Factura

Atributos:

- número de factura (auto-incremental)
- cliente
- lista de productos comprados
- subtotal, impuestos, descuentos, total
- método de pago usado
- fecha de compra
- estado (pendiente/pagada/cancelada)

Métodos:

- generarFactura()
- imprimirFactura() - formato texto
- enviarPorEmail() - simulado
- calcularMontoTotal()
- aplicarNotaCredito() - para devoluciones

## Funcionalidades Principales

### 1. Gestión de Productos

- Agregar producto al catálogo con todos sus datos
- Actualizar precio y stock
- Categorizar productos
- Buscar por nombre, categoría, rango de precio
- Filtrar productos disponibles
- Ordenar por precio, popularidad, nuevo

### 2. Gestión de Carrito

- Agregar productos al carrito
- Modificar cantidades
- Eliminar productos
- Ver resumen del carrito con subtotales
- Aplicar cupones de descuento
- Validar stock antes de proceder al pago
- Guardar carrito para después

### 3. Proceso de Compra

- Seleccionar método de envío
- Elegir dirección de entrega
- Aplicar descuentos disponibles
- Seleccionar método de pago
- Confirmar orden
- Generar factura
- Enviar confirmación

### 4. Sistema de Promociones

- Descuentos por temporada
- Ofertas flash (limitadas en tiempo)
- Cupones de descuento
- Descuentos por volumen
- Envío gratis por monto mínimo
- Puntos de lealtad canjeables

### 5. Gestión de Inventario

- Control de stock en tiempo real
- Alertas de stock bajo
- Reabastecimiento automático sugerido
- Historial de movimientos de inventario
- Productos más vendidos
- Productos con baja rotación

### 6. Reportes de Ventas

- Ventas totales por período
- Productos más vendidos
- Categorías más populares
- Clientes que más compran
- Métodos de pago más usados
- Promedio de ticket de compra
- Ingresos por impuestos
- Descuentos otorgados

## Reglas de Negocio

### Productos

- Stock no puede ser negativo
- Precio debe ser mayor a 0
- Solo se pueden vender productos con stock disponible
- Productos digitales tienen stock ilimitado
- Alimentos con fecha vencida no se pueden vender

### Carrito

- No se puede agregar más cantidad que stock disponible
- El precio se congela al agregar al carrito
- Carrito se vacía después de compra exitosa
- Carritos abandonados > 7 días se eliminan
- Máximo 50 productos diferentes en el carrito

### Descuentos

- No se pueden acumular todos los descuentos
- Descuento máximo: 50% del total
- Cupones tienen fecha de validez
- Un cupón solo se usa una vez por cliente
- Descuentos de cliente VIP se aplican automáticamente

### Pagos

- Se valida el método de pago antes de procesar
- Comisiones se suman al total
- Pago exitoso reserva el stock inmediatamente
- Pago fallido libera el stock
- Se genera factura solo con pago confirmado

### Envíos

- Envío gratis según tipo de cliente y monto
- Costo de envío varía por peso y distancia
- Productos frágiles tienen cargo extra
- Envío nacional: 3-5 días
- Envío express: 24 horas (+$20)

## Validaciones Importantes

- Stock suficiente antes de agregar al carrito
- Email válido para el cliente
- Tarjeta de crédito válida (algoritmo Luhn)
- Fecha de vencimiento de tarjeta futura
- Dirección de envío completa
- Cupón válido y no expirado
- Total de compra mayor a mínimo ($10)
- Cliente no suspendido o con pagos pendientes

## Casos de Prueba Recomendados

### Escenario 1: Compra Simple

1. Cliente regular navega el catálogo
2. Agrega 2 electrónicos al carrito
3. Verifica total con IVA incluido
4. Procede al pago con tarjeta de crédito
5. Confirma compra
6. Recibe factura generada
7. Stock se reduce correctamente

### Escenario 2: Aplicar Descuentos

1. Cliente VIP (5% descuento automático)
2. Agrega 5 productos de ropa (descuento volumen 5%)
3. Aplica cupón "VERANO20" (20% adicional)
4. Sistema calcula mejor combinación de descuentos
5. Verifica total con todos los descuentos aplicados

### Escenario 3: Stock Insuficiente

1. Producto con solo 3 unidades en stock
2. Cliente intenta agregar 5 unidades
3. Sistema alerta que solo hay 3 disponibles
4. Cliente acepta solo 3
5. Otro cliente intenta comprar 2
6. Verifica que ahora solo queda 1 en stock

### Escenario 4: Productos Digitales

1. Comprar libro digital (implementa Descargable)
2. Pago exitoso
3. Genera enlace de descarga
4. Crea código de activación
5. Envía por email
6. Stock ilimitado no se reduce

### Escenario 5: Devolución

1. Cliente compró ropa hace 5 días (implementa Devolvible)
2. Solicita devolución
3. Sistema verifica período válido (14 días)
4. Calcula costo de devolución (envío)
5. Procesa devolución
6. Incrementa stock nuevamente
7. Genera nota de crédito

### Escenario 6: Cliente Premium con Cashback

1. Cliente Premium realiza compra de $500
2. Obtiene 10% descuento automático
3. Obtiene 3 puntos por cada $10 (150 puntos)
4. Obtiene 2% cashback ($10)
5. Acumula beneficios para próxima compra

## Menú Interactivo

```bash
╔═══════════════════════════════════════════════╗
║          TIENDA ONLINE - E-COMMERCE           ║
╠═══════════════════════════════════════════════╣
║  CATÁLOGO                                     ║
║    1. Ver todos los productos                 ║
║    2. Buscar producto                         ║
║    3. Filtrar por categoría                   ║
║    4. Ver ofertas y promociones               ║
║                                               ║
║  CARRITO DE COMPRAS                           ║
║    5. Ver carrito                             ║
║    6. Agregar producto al carrito             ║
║    7. Modificar cantidad en carrito           ║
║    8. Eliminar producto del carrito           ║
║    9. Aplicar cupón de descuento              ║
║   10. Proceder al pago                        ║
║                                               ║
║  GESTIÓN DE CLIENTES                          ║
║   11. Registrar cliente                       ║
║   12. Actualizar datos de cliente             ║
║   13. Ver historial de compras                ║
║   14. Ver puntos acumulados                   ║
║                                               ║
║  ADMINISTRACIÓN (solo admin)                  ║
║   15. Agregar producto al catálogo            ║
║   16. Actualizar stock                        ║
║   17. Gestionar promociones                   ║
║   18. Ver reportes de ventas                  ║
║   19. Ver inventario                          ║
║                                               ║
║   0. Salir                                    ║
╚═══════════════════════════════════════════════╝
```

## Formato de Factura

```bash
════════════════════════════════════════════════════
               FACTURA DE VENTA
                 TIENDA ONLINE
════════════════════════════════════════════════════
Factura #: 00001234
Fecha: 09/11/2025 14:30:45
Cliente: Juan Pérez (VIP)
Email: juan.perez@email.com

────────────────────────────────────────────────────
PRODUCTO          CANT    P.UNIT     SUBTOTAL
────────────────────────────────────────────────────
Laptop HP           1    $800.00      $800.00
Mouse Logitech      2     $25.00       $50.00
Teclado Mecánico    1    $120.00      $120.00
────────────────────────────────────────────────────
                            Subtotal:    $970.00
                            IVA (16%):   $155.20
                   Descuento VIP (5%):   -$48.50
                    Cupón "TECH10":      -$97.00
                    Envío:                 $0.00
                            ────────────────────
                            TOTAL:       $979.70
────────────────────────────────────────────────────
Método de pago: Tarjeta Crédito 1234
Estado: PAGADA
Puntos ganados: 195
────────────────────────────────────────────────────
        ¡Gracias por su compra!
════════════════════════════════════════════════════
```

## Extras Opcionales

1. Sistema de Reseñas: Clientes califican productos
2. Lista de Deseos: Guardar productos para después
3. Comparador: Comparar especificaciones de productos
4. Notificaciones: Alertas de ofertas y restock
5. Chat de Soporte: Asistencia en tiempo real
6. Programa de Referidos: Gana puntos por invitar amigos
7. Suscripciones: Compras recurrentes automáticas
8. Rastreo de Envíos: Estado del pedido en tiempo real

## Tiempo Estimado

Total: 10-12 horas

# PROYECTO 06: Conversor Universal 🔄

## Dificultad: ⭐⭐

## Descripción General

Crea una herramienta de conversión completa que transforme valores entre diferentes unidades de medida, sistemas numéricos, monedas y más. Una aplicación práctica y útil para aplicar operadores y Math.

## Objetivos de Aprendizaje

- Operaciones aritméticas precisas
- Uso de constantes y fórmulas
- Condicionales para selección de conversiones
- Formateo de números con decimales
- Validación de entradas numéricas
- Organización de código modular

## Funcionalidades Requeridas

### Menú Principal

```bash
╔════════════════════════════════════════════╗
║       CONVERSOR UNIVERSAL v2.0 🔄          ║
╠════════════════════════════════════════════╣
║  1. Conversión de Temperatura              ║
║  2. Conversión de Longitud                 ║
║  3. Conversión de Masa/Peso                ║
║  4. Conversión de Volumen                  ║
║  5. Conversión de Área                     ║
║  6. Conversión de Velocidad                ║
║  7. Conversión de Tiempo                   ║
║  8. Conversión de Datos (Bytes)            ║
║  9. Conversión de Monedas                  ║
║ 10. Sistemas Numéricos                     ║
║ 11. Conversión de Energía                  ║
║ 12. Historial de Conversiones             ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Módulos de Conversión

### 1. Temperatura 🌡️

**Unidades soportadas:**

- Celsius (°C)
- Fahrenheit (°F)
- Kelvin (K)
- Rankine (°R)

**Fórmulas:**

```bash
°F = (°C × 9/5) + 32
°C = (°F - 32) × 5/9
K = °C + 273.15
°R = (°F + 459.67)
```

**Características especiales:**

- Indicar si está por debajo/arriba del punto de congelación del agua
- Indicar si está por debajo/arriba del punto de ebullición del agua
- Mostrar temperatura en todas las unidades simultáneamente
- Validar que Kelvin no sea negativo (0 K es el cero absoluto)

**Ejemplo de salida:**

```bash
╔════════════════════════════════════════════╗
║      CONVERSIÓN DE TEMPERATURA             ║
╠════════════════════════════════════════════╣
║ Valor ingresado: 25°C                      ║
║                                            ║
║ Equivalencias:                             ║
║   Celsius:     25.00 °C                    ║
║   Fahrenheit:  77.00 °F                    ║
║   Kelvin:     298.15 K                     ║
║   Rankine:    536.67 °R                    ║
║                                            ║
║ Estado: Por encima del punto de            ║
║         congelación (0°C / 32°F)           ║
╚════════════════════════════════════════════╝
```

### 2. Longitud 📏

**Unidades soportadas:**

- Milímetros (mm)
- Centímetros (cm)
- Metros (m)
- Kilómetros (km)
- Pulgadas (in)
- Pies (ft)
- Yardas (yd)
- Millas (mi)
- Millas náuticas (nmi)

**Conversiones base (a metros):**

```bash
1 km = 1000 m
1 cm = 0.01 m
1 mm = 0.001 m
1 in = 0.0254 m
1 ft = 0.3048 m
1 yd = 0.9144 m
1 mi = 1609.344 m
1 nmi = 1852 m
```

**Comparaciones interesantes:**

- Si > 1000 m: "Equivale a X campos de fútbol"
- Si > 100 km: "Distancia aproximada entre ciudades"
- Mostrar en unidades más relevantes automáticamente

### 3. Masa/Peso ⚖️

**Unidades soportadas:**

- Miligramos (mg)
- Gramos (g)
- Kilogramos (kg)
- Toneladas métricas (t)
- Onzas (oz)
- Libras (lb)
- Toneladas cortas (ton)
- Toneladas largas (long ton)

**Conversiones base (a kilogramos):**

```bash
1 g = 0.001 kg
1 mg = 0.000001 kg
1 t = 1000 kg
1 oz = 0.0283495 kg
1 lb = 0.453592 kg
1 ton = 907.185 kg
```

**Referencias visuales:**

- Si < 0.1 kg: "Peso de un objeto pequeño"
- Si 0.1-1 kg: "Peso de un libro"
- Si 1-50 kg: "Peso humano infantil/adulto ligero"
- Si 50-100 kg: "Peso humano adulto promedio"
- Si > 100 kg: "Peso de un objeto pesado"

### 4. Volumen 🥤

**Unidades soportadas:**

- Mililitros (ml)
- Litros (L)
- Metros cúbicos (m³)
- Centímetros cúbicos (cm³)
- Onzas fluidas (fl oz)
- Tazas (cup)
- Pintas (pt)
- Cuartos (qt)
- Galones (gal)

**Conversiones base (a litros):**

```bash
1 m³ = 1000 L
1 cm³ = 0.001 L
1 ml = 0.001 L
1 fl oz = 0.0295735 L
1 cup = 0.236588 L
1 pt = 0.473176 L
1 qt = 0.946353 L
1 gal = 3.78541 L
```

### 5. Área 📐

**Unidades soportadas:**

- Milímetros cuadrados (mm²)
- Centímetros cuadrados (cm²)
- Metros cuadrados (m²)
- Kilómetros cuadrados (km²)
- Hectáreas (ha)
- Pulgadas cuadradas (in²)
- Pies cuadrados (ft²)
- Yardas cuadradas (yd²)
- Acres
- Millas cuadradas (mi²)

**Conversiones base (a metros cuadrados):**

```bash
1 km² = 1,000,000 m²
1 ha = 10,000 m²
1 cm² = 0.0001 m²
1 ft² = 0.092903 m²
1 acre = 4046.86 m²
1 mi² = 2,589,988 m²
```

**Referencias:**

- Campo de fútbol: ~7,140 m²
- Cancha de tenis: ~260 m²

### 6. Velocidad 🚗

**Unidades soportadas:**

- Metros por segundo (m/s)
- Kilómetros por hora (km/h)
- Millas por hora (mph)
- Pies por segundo (ft/s)
- Nudos (knots)
- Velocidad de la luz (c)
- Mach (M)

**Conversiones base (a m/s):**

```bash
1 km/h = 0.277778 m/s
1 mph = 0.44704 m/s
1 ft/s = 0.3048 m/s
1 knot = 0.514444 m/s
1 M = 343 m/s (a nivel del mar)
c = 299,792,458 m/s
```

**Comparaciones:**

- Velocidad de caminata: ~1.4 m/s
- Velocidad de carrera: ~3-6 m/s
- Límite urbano típico: ~13.9 m/s (50 km/h)
- Velocidad supersónica: > 343 m/s

### 7. Tiempo ⏰

**Unidades soportadas:**

- Milisegundos (ms)
- Segundos (s)
- Minutos (min)
- Horas (h)
- Días (d)
- Semanas (w)
- Meses (mo) - asumir 30 días
- Años (y) - asumir 365 días
- Décadas
- Siglos

**Conversiones base (a segundos):**

```bash
1 ms = 0.001 s
1 min = 60 s
1 h = 3600 s
1 d = 86,400 s
1 w = 604,800 s
1 mo = 2,592,000 s
1 y = 31,536,000 s
```

**Formato especial:**

- Convertir grandes cantidades a formato legible
- Ejemplo: 100,000 segundos = 1 día, 3 horas, 46 minutos, 40 segundos

### 8. Datos Digitales 💾

**Unidades soportadas:**

- Bits (b)
- Bytes (B)
- Kilobytes (KB)
- Megabytes (MB)
- Gigabytes (GB)
- Terabytes (TB)
- Petabytes (PB)

**Conversiones (sistema binario):**

```bash
1 B = 8 bits
1 KB = 1024 B
1 MB = 1024 KB
1 GB = 1024 MB
1 TB = 1024 GB
1 PB = 1024 TB
```

**Referencias:**

- Imagen HD: ~5 MB
- Canción MP3: ~3-5 MB
- Película HD: ~4-8 GB
- Juego AAA: ~50-100 GB

### 9. Conversión de Monedas 💱

**Monedas soportadas:**

- USD (Dólar estadounidense)
- EUR (Euro)
- GBP (Libra esterlina)
- JPY (Yen japonés)
- MXN (Peso mexicano)
- CAD (Dólar canadiense)
- AUD (Dólar australiano)
- BRL (Real brasileño)
- COP (Peso colombiano)

**Tasas de cambio (usar valores aproximados fijos):**

```java
// Base: USD = 1.00
final double USD_TO_EUR = 0.92;
final double USD_TO_GBP = 0.79;
final double USD_TO_JPY = 149.50;
final double USD_TO_MXN = 17.20;
final double USD_TO_CAD = 1.36;
final double USD_TO_AUD = 1.53;
final double USD_TO_BRL = 4.95;
final double USD_TO_COP = 3950.00;
```

**Características:**

- Mostrar fecha de última actualización
- Convertir de cualquier moneda a cualquier otra
- Redondear a 2 decimales
- Mostrar símbolo de la moneda ($, €, £, ¥)

### 10. Sistemas Numéricos 🔢

**Sistemas soportados:**

- Decimal (base 10)
- Binario (base 2)
- Octal (base 8)
- Hexadecimal (base 16)

**Usar:**

```java
Integer.toBinaryString()
Integer.toOctalString()
Integer.toHexString()
Integer.parseInt(string, base)
```

**Mostrar:**

- Representación en todos los sistemas
- Número de bits necesarios
- Conversión con explicación paso a paso (opcional)

### 11. Energía ⚡

**Unidades soportadas:**

- Julios (J)
- Kilojulios (kJ)
- Calorías (cal)
- Kilocalorías (kcal)
- Vatios-hora (Wh)
- Kilovatios-hora (kWh)
- Electronvoltios (eV)

**Conversiones base (a Julios):**

```bash
1 kJ = 1000 J
1 cal = 4.184 J
1 kcal = 4184 J
1 Wh = 3600 J
1 kWh = 3,600,000 J
```

### 12. Historial de Conversiones 📋

**Funcionalidad:**

- Guardar las últimas 20 conversiones
- Formato: "25°C → 77°F (Temperatura) - 08/11/2025 15:30"
- Opción de volver a realizar una conversión del historial
- Opción de limpiar historial
- Exportar historial como texto

## Características Especiales

### Modo Rápido ⚡

Acceso directo a conversiones populares:

- °C ↔ °F
- km ↔ mi
- kg ↔ lb
- L ↔ gal
- USD ↔ EUR

### Calculadora de Conversión 🧮

Operaciones con unidades:

```bash
Ejemplo: ¿Cuánto es 5 km + 3000 m en millas?
Resultado: 5 mi
```

### Comparador 🔍

Comparar dos valores con unidades diferentes:

```bash
¿Qué es mayor?
A: 1000 metros
B: 1 kilómetro
Resultado: Son iguales
```

## Requisitos Técnicos

### Constantes de Conversión

```java
// Temperatura
final double CELSIUS_TO_FAHRENHEIT_FACTOR = 9.0/5.0;
final double CELSIUS_TO_FAHRENHEIT_OFFSET = 32.0;
final double CELSIUS_TO_KELVIN_OFFSET = 273.15;

// Longitud
final double METERS_TO_FEET = 3.28084;
final double METERS_TO_MILES = 0.000621371;

// etc...
```

### Precisión

- Usar `double` para todos los cálculos
- Redondear resultados a 6 decimales
- Usar `Math.round()` o `String.format("%.6f", valor)`

### Validaciones

1. Valor numérico válido
2. Temperatura en Kelvin ≥ 0
3. Valores negativos solo donde tengan sentido
4. Unidades de origen y destino diferentes

## Conceptos a Aplicar

### 1. Operadores

- Aritméticos: multiplicación, división
- Relacionales: comparaciones
- Casting: int a double

### 2. Math

- Math.round()
- Math.pow() (para conversiones de área)
- Math.abs() (valores absolutos)

### 3. Constantes

- final para factores de conversión
- Organización clara

### 4. Wrappers

- Double.parseDouble()
- Integer.parseInt()
- Conversiones de bases numéricas

### 5. Strings

- Formateo con printf
- Concatenación
- Símbolos especiales (°, ², ³)

### 6. Condicionales

- switch para menús
- if-else para validaciones
- Operador ternario

## Extras (Opcionales - Desafío)

1. **Modo científico**: Notación científica para números grandes
2. **Gráfico de comparación**: Barras ASCII
3. **Conversión por voz**: Simular entrada de voz con texto
4. **Favoritos**: Guardar conversiones favoritas
5. **Temas**: Categorías personalizadas
6. **API de tasas**: Simular actualización de tasas de cambio
7. **Conversión inversa automática**: Mostrar ambas direcciones

## Casos de Prueba

Verifica con estos ejemplos:

1. 0°C = 32°F = 273.15K
2. 1 km = 0.621371 mi
3. 1 kg = 2.20462 lb
4. 100°C = 212°F (punto de ebullición)
5. 1 GB = 1,073,741,824 bytes

## Criterios de Evaluación

- **Todas las conversiones correctas**
- **Precisión de cálculos** (6 decimales mínimo)
- **Validaciones completas**
- **Formato profesional**
- **Código bien organizado con constantes**
- **Manejo de errores robusto**

## Tiempo Estimado

4-5 horas de desarrollo

## Consejos

1. Define todas las constantes al inicio
2. Crea métodos para cada tipo de conversión
3. Usa una unidad base para cada categoría
4. Primero convierte a la base, luego a la unidad deseada
5. Prueba con valores conocidos (0°C, 100°C, etc.)
6. Usa printf para formateo consistente
7. Comenta las fórmulas de conversión

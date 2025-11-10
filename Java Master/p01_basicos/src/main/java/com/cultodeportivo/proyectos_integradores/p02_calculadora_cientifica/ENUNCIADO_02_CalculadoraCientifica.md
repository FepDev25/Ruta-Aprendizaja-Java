# PROYECTO 02: Calculadora Científica Avanzada 🔢

## Dificultad: ⭐⭐

## Descripción General

Desarrolla una calculadora científica completa que vaya más allá de las operaciones básicas, implementando funciones matemáticas avanzadas y conversiones numéricas.

## Objetivos de Aprendizaje

- Uso intensivo de la clase Math
- Operadores aritméticos y lógicos
- Condicionales para control de flujo
- Entrada y salida formateada
- Manejo de wrappers y conversiones
- Validación de datos numéricos

## Funcionalidades Requeridas

### Menú Principal

```bash
╔════════════════════════════════════════════╗
║      CALCULADORA CIENTÍFICA v1.0           ║
╠════════════════════════════════════════════╣
║  1. Operaciones Básicas                    ║
║  2. Operaciones Avanzadas                  ║
║  3. Trigonometría                          ║
║  4. Conversiones Numéricas                 ║
║  5. Operaciones con Potencias y Raíces     ║
║  6. Estadística Básica                     ║
║  7. Calculadora de Porcentajes             ║
║  8. Historial de operaciones               ║
║  9. Limpiar historial                      ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Módulos Detallados

### 1. Operaciones Básicas

Implementar:

- **Suma**: a + b
- **Resta**: a - b
- **Multiplicación**: a × b
- **División**: a ÷ b (validar división por cero)
- **Módulo**: a % b

### 2. Operaciones Avanzadas

- **Valor absoluto**: |x|
- **Redondeo**: redondear a n decimales
- **Piso**: Math.floor()
- **Techo**: Math.ceil()
- **Máximo** entre dos números
- **Mínimo** entre dos números
- **Signo**: determinar si es positivo, negativo o cero

### 3. Trigonometría

Calcular (el usuario elige entre grados o radianes):

- **Seno**: sin(x)
- **Coseno**: cos(x)
- **Tangente**: tan(x)
- **Arcoseno**: asin(x)
- **Arcocoseno**: acos(x)
- **Arcotangente**: atan(x)

**Conversiones:**

- Grados a Radianes: radianes = grados × π/180
- Radianes a Grados: grados = radianes × 180/π

### 4. Conversiones Numéricas

Implementar conversión entre sistemas:

- **Decimal → Binario**
- **Decimal → Octal**
- **Decimal → Hexadecimal**
- **Binario → Decimal**
- **Octal → Decimal**
- **Hexadecimal → Decimal**

Usar: `Integer.toBinaryString()`, `Integer.toOctalString()`, `Integer.toHexString()`, `Integer.parseInt()`

### 5. Potencias y Raíces

- **Potencia**: x^y (usar Math.pow())
- **Raíz cuadrada**: √x
- **Raíz cúbica**: ∛x
- **Raíz n-ésima**: ⁿ√x
- **Exponencial**: e^x
- **Logaritmo natural**: ln(x)
- **Logaritmo base 10**: log₁₀(x)

### 6. Estadística Básica

Solicitar una serie de números (hasta 20) y calcular:

- **Media aritmética**: (Σx) / n
- **Mediana**: valor central ordenado
- **Moda**: valor más frecuente
- **Rango**: max - min
- **Varianza**: σ²
- **Desviación estándar**: σ

### 7. Calculadora de Porcentajes

- **Calcular el X% de Y**: (X/100) × Y
- **Y es el X% de cuánto**: Y / (X/100)
- **Y es qué % de Z**: (Y/Z) × 100
- **Incremento porcentual**: X + (X × P/100)
- **Decremento porcentual**: X - (X × P/100)

### 8. Historial

- Guardar las últimas 10 operaciones realizadas
- Mostrar: operación completa y resultado
- Formato: `25 * 4 = 100`
- Opción para limpiar historial

## Requisitos Técnicos

### Validaciones Obligatorias

1. **División por cero**: Detectar y mostrar error apropiado
2. **Raíces de negativos**: Validar para raíces pares
3. **Logaritmos**: Validar que el argumento sea positivo
4. **Trigonometría inversa**: Validar dominio (-1 a 1 para asin/acos)
5. **Entrada numérica**: Capturar excepciones de formato

### Formato de Resultados

- Números con hasta 6 decimales
- Usar `System.out.printf("%.6f", resultado)`
- Mostrar notación científica para números muy grandes/pequeños
- Símbolos matemáticos en la salida (√, π, ×, ÷)

### Constantes Matemáticas

```java
final double PI = Math.PI;
final double E = Math.E;
final double PHI = (1 + Math.sqrt(5)) / 2; // Número áureo
```

## Conceptos a Aplicar

### 1. Operadores

- Aritméticos: +, -, *, /, %
- Relacionales: validaciones numéricas
- Lógicos: condiciones compuestas

### 2. Clase Math

- `Math.pow()`, `Math.sqrt()`, `Math.cbrt()`
- `Math.sin()`, `Math.cos()`, `Math.tan()`
- `Math.abs()`, `Math.max()`, `Math.min()`
- `Math.floor()`, `Math.ceil()`, `Math.round()`
- `Math.log()`, `Math.log10()`, `Math.exp()`
- `Math.PI`, `Math.E`

### 3. Wrappers

- `Integer.parseInt()`, `Double.parseDouble()`
- `Integer.toBinaryString()`, `Integer.toHexString()`
- `Integer.toString()` con diferentes bases
- Manejo de `NumberFormatException`

### 4. Condicionales

- `switch` para menú principal y submenús
- `if-else` para validaciones
- Operador ternario para mensajes

### 5. Bucles

- `while` para menú principal
- `for` para operaciones con arrays (estadística)
- `do-while` para validación de entrada

### 6. Strings

- Formateo de resultados
- Construcción de historial
- Símbolos especiales: "√", "π", "×"

## Extras (Opcionales - Desafío)

1. **Calculadora de matrices**: Suma, resta, multiplicación de matrices 2×2
2. **Números complejos**: Operaciones básicas con números complejos
3. **Ecuación cuadrática**: Resolver ax² + bx + c = 0
4. **Combinatoria**: Calcular factorial, combinaciones, permutaciones
5. **Conversión de unidades**: Temperatura, longitud, masa, etc.
6. **Gráfica ASCII**: Mostrar gráfica simple de funciones
7. **Modo científico avanzado**: Notación científica completa

## Ejemplo de Salida Esperada

```bash
╔════════════════════════════════════════════╗
║         OPERACIÓN REALIZADA                ║
╠════════════════════════════════════════════╣
║ Operación: √(64)                           ║
║ Resultado: 8.000000                        ║
║                                            ║
║ Agregado al historial [1/10]               ║
╚════════════════════════════════════════════╝

¿Desea realizar otra operación? (S/N): 
```

## Criterios de Evaluación

- **Todas las operaciones funcionan correctamente**
- **Validaciones completas** (división por cero, dominios, etc.)
- **Formato profesional** de entrada y salida
- **Manejo de errores** robusto
- **Historial funcional**
- **Código bien estructurado** y comentado

## Tiempo Estimado

3-5 horas de desarrollo

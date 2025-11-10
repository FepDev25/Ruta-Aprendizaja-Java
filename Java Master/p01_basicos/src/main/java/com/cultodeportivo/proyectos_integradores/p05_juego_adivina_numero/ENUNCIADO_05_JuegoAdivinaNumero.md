# PROYECTO 05: Juego - Adivina el Número 🎮

## Dificultad: ⭐⭐

## Descripción General

Desarrolla un juego interactivo donde el jugador debe adivinar un número secreto. Incluye diferentes niveles de dificultad, sistema de puntuación, récords y múltiples modos de juego.

## Objetivos de Aprendizaje

- Generación de números aleatorios
- Lógica de juego y control de flujo
- Bucles para repetición de turnos
- Condicionales para verificar respuestas
- Sistema de puntuación y estadísticas
- Entrada/salida interactiva

## Funcionalidades Requeridas

### Menú Principal

```bash
╔════════════════════════════════════════════╗
║      ADIVINA EL NÚMERO v2.0 🎯             ║
╠════════════════════════════════════════════╣
║  1. Juego Clásico                          ║
║  2. Juego Contrareloj                      ║
║  3. Juego Matemático                       ║
║  4. Multijugador (2 jugadores)             ║
║  5. Ver Estadísticas                       ║
║  6. Ver Récords                            ║
║  7. Configuración                          ║
║  8. Tutorial / Reglas                      ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Modos de Juego

### 1. Juego Clásico

**Objetivo**: Adivinar el número secreto con pistas.

**Niveles de Dificultad:**

- **Fácil**: 1-50, intentos ilimitados, pistas detalladas
- **Medio**: 1-100, máximo 10 intentos, pistas normales
- **Difícil**: 1-500, máximo 7 intentos, pistas mínimas
- **Experto**: 1-1000, máximo 5 intentos, sin pistas detalladas

**Funcionamiento:**

1. Sistema genera número aleatorio según nivel
2. Jugador tiene X intentos para adivinarlo
3. Después de cada intento, recibe pistas:
   - "Muy frío" (diferencia > 50)
   - "Frío" (diferencia 26-50)
   - "Tibio" (diferencia 11-25)
   - "Caliente" (diferencia 6-10)
   - "¡Muy caliente!" (diferencia 1-5)
4. También indicar si el número es mayor o menor
5. Calcular puntuación basada en intentos usados

**Sistema de Puntuación:**

```bash
Puntos = (Intentos máximos - Intentos usados) × Multiplicador nivel
Multiplicadores: Fácil: ×10, Medio: ×25, Difícil: ×50, Experto: ×100

Bonos:
- Adivinar en el primer intento: +500 puntos
- Adivinar en ≤3 intentos: +200 puntos
- Adivinar sin pistas: +150 puntos
```

### 2. Juego Contrareloj ⏱️

**Objetivo**: Adivinar el mayor número de números en tiempo limitado.

**Características:**

- Rango: 1-50
- Tiempo: 2 minutos (120 segundos)
- Por cada número correcto: +10 puntos
- Por cada error: -2 puntos
- Bonus de racha: 3 consecutivos = +20 puntos extra
- Mostrar números adivinados y tiempo restante

**Formato de juego:**

```bash
Tiempo restante: 115 seg | Puntos: 45 | Racha: 2
Número actual: ¿?
Tu intento: _
```

### 3. Juego Matemático 🧮

**Objetivo**: Resolver operación matemática en lugar de adivinar.

**Funcionamiento:**

1. Sistema genera operación matemática aleatoria
2. Jugador debe calcular el resultado
3. Tiene 3 intentos por operación
4. Tipos de operaciones (según nivel):

**Niveles:**

- **Nivel 1**: Suma y resta (números 1-20)
- **Nivel 2**: Multiplicación (números 1-12)
- **Nivel 3**: División exacta
- **Nivel 4**: Operaciones combinadas
- **Nivel 5**: Potencias y raíces

**Ejemplos:**

```bash
Nivel 1: 15 + 23 = ?
Nivel 2: 7 × 8 = ?
Nivel 3: 56 ÷ 8 = ?
Nivel 4: (12 + 8) × 3 = ?
Nivel 5: 5² = ?
```

**Puntuación:**

- 1er intento: 50 puntos
- 2do intento: 30 puntos
- 3er intento: 10 puntos
- Error: 0 puntos

### 4. Multijugador (2 jugadores) 👥

**Modo A - Por Turnos:**

1. Cada jugador adivina un número en su turno
2. Mismo número secreto para ambos
3. Gana quien lo adivine primero
4. Máximo 10 intentos cada uno

**Modo B - Competencia:**

1. Cada jugador tiene su propio número secreto
2. Juegan simultáneamente
3. Gana quien adivine primero
4. Ver intentos del oponente (sin ver pistas)

**Modo C - Duelo:**

1. Jugador 1 piensa un número (no lo ingresa, solo lo piensa)
2. Jugador 2 intenta adivinarlo
3. Jugador 1 da pistas (mayor/menor)
4. Validar honestidad al final
5. Intercambiar roles

### 5. Ver Estadísticas 📊

Mostrar:

- **Total de partidas jugadas**
- **Partidas ganadas vs perdidas**
- **Porcentaje de victorias**
- **Promedio de intentos por victoria**
- **Nivel favorito**
- **Total de puntos acumulados**
- **Mejor racha de victorias**
- **Tiempo total jugado**

**Gráfico de rendimiento:**

```bash
Victorias por nivel:
Fácil:    ████████████ (12 victorias)
Medio:    ████████ (8 victorias)
Difícil:  ████ (4 victorias)
Experto:  ██ (2 victorias)
```

### 6. Ver Récords 🏆

Mantener registro de:

- **Menor número de intentos** (por nivel)
- **Mayor puntuación** (por modo de juego)
- **Racha más larga** (victorias consecutivas)
- **Tiempo más rápido** (en modo contrareloj)
- **Más números adivinados** (en contrareloj)
- **Fecha y hora de cada récord**

**Formato:**

```bash
╔════════════════════════════════════════════╗
║            TABLA DE RÉCORDS                ║
╠════════════════════════════════════════════╣
║ Modo Clásico - Nivel Experto               ║
║   Récord: 3 intentos                       ║
║   Puntuación: 350 pts                      ║
║   Fecha: 08/11/2025 15:30                  ║
║                                            ║
║ Modo Contrareloj                           ║
║   Récord: 23 números en 120 seg           ║
║   Puntuación: 230 pts                      ║
║   Fecha: 07/11/2025 18:45                  ║
╚════════════════════════════════════════════╝
```

### 7. Configuración ⚙️

Opciones configurables:

- **Activar/desactivar pistas**
- **Activar/desactivar sonidos** (con texto: "¡BEEP!", "¡BOOP!")
- **Cambiar nombres de jugadores**
- **Restablecer estadísticas** (con confirmación)
- **Restablecer récords** (con confirmación)
- **Velocidad de animaciones** (lenta/normal/rápida)
- **Tema de colores** (simular con símbolos)

### 8. Tutorial / Reglas

Explicar:

- Cómo jugar cada modo
- Sistema de puntuación detallado
- Significado de las pistas
- Consejos y estrategias
- Ejemplos de jugadas

## Características Especiales

### Sistema de Logros/Achievements

Desbloquear logros especiales:

- ✓ **Primera Victoria**: Gana tu primera partida
- ✓ **Principiante**: 10 victorias totales
- ✓ **Experto**: 50 victorias totales
- ✓ **Maestro**: 100 victorias totales
- ✓ **Suertudo**: Adivina en el primer intento
- ✓ **Perseverante**: Gana usando todos los intentos
- ✓ **Veloz**: Gana en modo contrareloj con +180 puntos
- ✓ **Matemático**: 20 victorias en modo matemático
- ✓ **Racha Imparable**: 10 victorias consecutivas
- ✓ **Perfeccionista**: 5 victorias sin usar pistas

### Animaciones de Texto

Agregar efectos visuales con texto:

**Al ganar:**

```bash
  ╔═══════════════════════════════════╗
  ║    ¡¡¡ FELICIDADES !!!            ║
  ║    🎉 🎊 🎈 🎁                    ║
  ║                                   ║
  ║    ¡Adivinaste el número!         ║
  ║    Número secreto: 42             ║
  ║    Intentos: 5                    ║
  ║    Puntuación: 125 pts            ║
  ╚═══════════════════════════════════╝
```

**Al perder:**

```bash
  ╔═══════════════════════════════════╗
  ║         GAME OVER                 ║
  ║         💀 😢 💔                  ║
  ║                                   ║
  ║    Número secreto era: 42         ║
  ║    Tus intentos: 10               ║
  ║    ¡Mejor suerte la próxima!      ║
  ╚═══════════════════════════════════╝
```

### Sistema de Hints (Pistas adicionales)

El jugador puede solicitar pistas especiales (máximo 2 por partida):

- **Paridad**: "El número es par/impar"
- **Divisibilidad**: "Es divisible por 3/5"
- **Dígitos**: "Tiene 2 dígitos"
- **Rango reducido**: "Está entre X y Y" (reduce rango a la mitad)
- Costo: -10 puntos por pista

## Requisitos Técnicos

### Generación de Números Aleatorios

```java
// Usar Math.random()
int min = 1;
int max = 100;
int numeroSecreto = (int) (Math.random() * (max - min + 1)) + min;
```

### Validaciones

- Entrada debe ser un número entero
- Número dentro del rango permitido
- Manejar entradas inválidas sin romper el programa
- Confirmación para resetear datos

### Almacenamiento de Datos

- Arrays para historial de intentos
- Variables para estadísticas
- Almacenar récords por separado

## Conceptos a Aplicar

### 1. Operadores

- Aritméticos: cálculo de puntos, diferencias
- Relacionales: comparaciones mayor/menor
- Lógicos: validaciones compuestas
- Módulo: verificar paridad

### 2. Condicionales

- if-else anidados: evaluar pistas
- switch: menús y opciones
- Operador ternario: mensajes

### 3. Bucles

- while: juego principal
- for: contar intentos, recorrer historial
- do-while: validar entrada

### 4. Math

- Math.random(): números aleatorios
- Math.abs(): calcular diferencia
- Math.pow(): modo matemático

### 5. Wrappers

- Integer.parseInt(): convertir entrada
- Manejo de NumberFormatException

### 6. Strings

- Concatenación de mensajes
- Formateo de salidas
- Comparaciones (nombres de jugadores)

## Extras (Opcionales - Desafío)

1. **Modo Historia**: Serie de niveles progresivos con narrativa
2. **Sistema de Niveles**: XP y niveles de jugador
3. **Modo Infinito**: Jugar hasta perder
4. **Ranking Global**: Top 10 mejores puntuaciones
5. **Modo Secreto**: Números primos solamente
6. **Power-ups**: Habilidades especiales (revelar dígito, eliminar mitad)
7. **Guardar partida**: Continuar después

## Casos de Prueba

Prueba estos escenarios:

1. Adivinar en el primer intento
2. Usar todos los intentos y perder
3. Ganar en el último intento
4. Usar pistas adicionales
5. Jugar contrareloj completo
6. Multijugador completo
7. Resetear estadísticas

## Criterios de Evaluación

- **Todos los modos funcionan**
- **Sistema de puntuación correcto**
- **Estadísticas precisas**
- **Validaciones completas**
- **Interfaz clara y atractiva**
- **Manejo de errores robusto**
- **Código bien estructurado**

## Tiempo Estimado

4-6 horas de desarrollo

## Consejos

1. Empieza con el modo clásico básico
2. Prueba la generación de números aleatorios
3. Implementa el sistema de pistas gradualmente
4. Agrega los otros modos una vez que el clásico funcione
5. Prueba cada modo extensivamente
6. Haz el código modular y reutilizable
7. Agrega comentarios para lógica compleja
8. ¡Diviértete programando! Es un juego después de todo 😄

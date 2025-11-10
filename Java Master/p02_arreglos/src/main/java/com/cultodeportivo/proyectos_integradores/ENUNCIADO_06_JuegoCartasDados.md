# PROYECTO 06: Juego - Cartas y Dados 🎲🃏

## Dificultad: ⭐⭐⭐

## Descripción General

Colección de juegos de azar usando arrays para representar mazos de cartas, dados y fichas. Implementa algoritmos de mezcla, reparto y puntuación.

## Estructura de Datos

```java
// Para cartas
final int TOTAL_CARTAS = 52;
String[] mazo = new String[TOTAL_CARTAS];
boolean[] cartasUsadas = new boolean[TOTAL_CARTAS];
String[][] manos = new String[4][13]; // 4 jugadores, 13 cartas max

// Para dados
int[] dados = new int[6]; // Hasta 6 dados
int[] frecuenciaDados = new int[7]; // Contar 1-6

// Resultados
int[] puntosJugadores = new int[4];
```

## Juegos Incluidos

### 1. BlackJack (21) ♠️

**Objetivo:** Acercarse a 21 sin pasarse

**Reglas:**

- As = 1 u 11
- Figuras (J, Q, K) = 10
- Resto = valor nominal
- Jugador vs Casa
- Pedir carta o plantarse

**Funcionalidad:**

- Crear y mezclar mazo
- Repartir cartas iniciales
- Calcular valores de manos
- Determinar ganador

### 2. Poker (5 cartas) 🃏

**Objetivo:** Mejor combinación de 5 cartas

**Combinaciones (menor a mayor):**

1. Carta alta
2. Par
3. Doble par
4. Trío
5. Escalera
6. Color
7. Full House
8. Poker
9. Escalera de color
10. Escalera real

**Funcionalidad:**

- Repartir 5 cartas por jugador
- Detectar combinaciones
- Comparar manos
- Determinar ganador

### 3. Generala (Dados) 🎲

**Objetivo:** Completar categorías con 5 dados

**Categorías:**

- Generala (5 iguales): 50 puntos
- Poker (4 iguales): 40 puntos
- Full (3+2): 30 puntos
- Escalera: 20/25 puntos
- Números (1-6): suma total

**Funcionalidad:**

- Tirar 5 dados
- Permitir 3 lanzamientos
- Seleccionar dados a mantener
- Calcular puntuación

### 4. Craps (Dados) 🎲🎲

**Objetivo:** Juego de apuestas con 2 dados

**Reglas:**

- Primera tirada: 7 u 11 = gana, 2,3,12 = pierde
- Cualquier otro = "punto"
- Tirar hasta sacar el punto (gana) o 7 (pierde)

### 5. Guerra de Cartas ⚔️

**Objetivo:** Ganar todas las cartas

**Reglas:**

- 2 jugadores
- Cada uno voltea una carta
- Carta mayor gana ambas
- Empate = guerra (3 cartas boca abajo, 1 boca arriba)

### 6. Solitario Simplificado 🂡

**Objetivo:** Ordenar cartas por palo

**Funcionalidad:**

- Repartir cartas en pilas
- Mover cartas según reglas
- Verificar movimientos válidos

## Algoritmos Importantes

### Crear Mazo de Cartas

```java
void crearMazo() {
    String[] palos = {"♠", "♥", "♦", "♣"};
    String[] valores = {"A", "2", "3", "4", "5", "6", 
                        "7", "8", "9", "10", "J", "Q", "K"};
    
    int index = 0;
    for (int p = 0; p < palos.length; p++) {
        for (int v = 0; v < valores.length; v++) {
            mazo[index] = valores[v] + palos[p];
            index++;
        }
    }
}
```

### Mezclar Mazo (Fisher-Yates)

```java
void mezclarMazo() {
    for (int i = TOTAL_CARTAS - 1; i > 0; i--) {
        int j = (int) (Math.random() * (i + 1));
        String temp = mazo[i];
        mazo[i] = mazo[j];
        mazo[j] = temp;
    }
}
```

### Repartir Cartas

```java
void repartirCartas(int numJugadores, int cartasPorJugador) {
    int cartaActual = 0;
    
    for (int c = 0; c < cartasPorJugador; c++) {
        for (int j = 0; j < numJugadores; j++) {
            manos[j][c] = mazo[cartaActual];
            cartasUsadas[cartaActual] = true;
            cartaActual++;
        }
    }
}
```

### Tirar Dados

```java
void tirarDados(int cantidad) {
    for (int i = 0; i < cantidad; i++) {
        dados[i] = (int) (Math.random() * 6) + 1;
    }
}
```

### Detectar Poker (Cartas)

```java
boolean tienePoker(String[] mano) {
    int[] frecuencias = new int[13]; // A-K
    
    for (int i = 0; i < 5; i++) {
        int valor = obtenerValorCarta(mano[i]);
        frecuencias[valor]++;
    }
    
    for (int i = 0; i < 13; i++) {
        if (frecuencias[i] == 4) return true;
    }
    
    return false;
}
```

### Detectar Escalera

```java
boolean tieneEscalera(String[] mano) {
    int[] valores = new int[5];
    
    for (int i = 0; i < 5; i++) {
        valores[i] = obtenerValorCarta(mano[i]);
    }
    
    ordenarArray(valores);
    
    for (int i = 0; i < 4; i++) {
        if (valores[i + 1] != valores[i] + 1) {
            return false;
        }
    }
    
    return true;
}
```

### Calcular Valor BlackJack

```java
int calcularValorMano(String[] mano, int numCartas) {
    int valor = 0;
    int ases = 0;
    
    for (int i = 0; i < numCartas; i++) {
        char carta = mano[i].charAt(0);
        
        if (carta == 'A') {
            ases++;
            valor += 11;
        } else if (carta == 'J' || carta == 'Q' || carta == 'K') {
            valor += 10;
        } else {
            valor += Character.getNumericValue(carta);
        }
    }
    
    // Ajustar ases si es necesario
    while (valor > 21 && ases > 0) {
        valor -= 10;
        ases--;
    }
    
    return valor;
}
```

### Detectar Generala (Dados)

```java
boolean tieneGenerala(int[] dados, int cantidad) {
    int primero = dados[0];
    for (int i = 1; i < cantidad; i++) {
        if (dados[i] != primero) return false;
    }
    return true;
}
```

## Formato de Juego

### BlackJack

```bash
╔════════════════════════════════════════════╗
║              BLACKJACK 21                  ║
╠════════════════════════════════════════════╣
║ Mano de la Casa:                           ║
║   [8♥] [?]                                 ║
║   Valor: 8                                 ║
║                                            ║
║ Tu mano:                                   ║
║   [A♠] [9♦]                                ║
║   Valor: 20                                ║
║                                            ║
║ ¿Pedir carta (P) o Plantarse (S)? _       ║
╚════════════════════════════════════════════╝
```

### Generala

```bash
╔════════════════════════════════════════════╗
║              GENERALA                      ║
╠════════════════════════════════════════════╣
║ Lanzamiento 1 de 3                         ║
║                                            ║
║ Dados:  [🎲6] [🎲6] [🎲3] [🎲6] [🎲1]      ║
║                                            ║
║ ¿Qué dados mantener? (1-5 o 0 para todos) ║
║ Ejemplo: 1 2 4 (mantiene dados 1, 2 y 4)  ║
╚════════════════════════════════════════════╝

Puntuación actual:
Generala: ⬜ (50)
Poker:    ⬜ (40)
Full:     ⬜ (30)
Escalera: ⬜ (25)
```

## Extras (Opcionales)

1. **Ranking de jugadores:** Guardar mejores puntuaciones
2. **Torneos:** Multiple rondas
3. **Estadísticas:** Victorias, derrotas, porcentajes
4. **IA simple:** Para jugar contra la máquina
5. **Animaciones ASCII:** Cartas volteándose
6. **Apuestas:** Sistema de fichas virtuales
7. **Multijugador:** Hasta 4 jugadores

## Casos de Prueba

Prueba cada juego:

1. BlackJack: llegar a 21, pasarse, ganar con menor
2. Poker: detectar todas las combinaciones
3. Generala: completar categorías
4. Verificar mezcla aleatoria del mazo

## Tiempo Estimado

6-8 horas

# PROYECTO 05: Sistema de Votación 🗳️

## Dificultad: ⭐⭐

## Descripción General

Sistema electoral que gestiona votaciones, candidatos y resultados con conteo automático, validación de votos y generación de reportes.

## Estructura de Datos

```java
final int MAX_CANDIDATOS = 20;
final int MAX_VOTANTES = 500;

String[] nombresCandidatos = new String[MAX_CANDIDATOS];
String[] partidosCandidatos = new String[MAX_CANDIDATOS];
int[] votosPorCandidato = new int[MAX_CANDIDATOS];

String[] votantes = new String[MAX_VOTANTES]; // IDs de votantes
boolean[] haVotado = new boolean[MAX_VOTANTES];

int totalCandidatos = 0;
int totalVotantes = 0;
int totalVotosEmitidos = 0;
```

## Funcionalidades

### 1. Configuración de Elección

- Registrar candidatos
- Asignar partidos
- Registrar votantes elegibles
- Establecer tipo de elección

### 2. Proceso de Votación

- Verificar identidad del votante
- Validar que no haya votado
- Mostrar papeleta con candidatos
- Registrar voto
- Marcar votante como "ha votado"
- Opción de voto nulo/blanco

### 3. Escrutinio y Resultados

- Contar votos por candidato
- Calcular porcentajes
- Determinar ganador (mayoría simple)
- Segunda vuelta (si es necesario)
- Votos válidos vs inválidos

### 4. Estadísticas

- Participación electoral (%)
- Abstención
- Votos por partido
- Distribución geográfica simulada

### 5. Reportes

- Acta oficial de resultados
- Gráfico de barras
- Ranking de candidatos
- Análisis por partido

## Algoritmos Clave

### Ordenar por Votos

```java
void ordenarPorVotos() {
    for (int i = 0; i < totalCandidatos - 1; i++) {
        for (int j = i + 1; j < totalCandidatos; j++) {
            if (votosPorCandidato[i] < votosPorCandidato[j]) {
                intercambiarCandidatos(i, j);
            }
        }
    }
}
```

### Determinar Ganador

```java
int determinarGanador() {
    int maxVotos = 0;
    int ganador = -1;
    boolean empate = false;
    
    for (int i = 0; i < totalCandidatos; i++) {
        if (votosPorCandidato[i] > maxVotos) {
            maxVotos = votosPorCandidato[i];
            ganador = i;
            empate = false;
        } else if (votosPorCandidato[i] == maxVotos) {
            empate = true;
        }
    }
    
    return empate ? -1 : ganador;
}
```

### Verificar Segunda Vuelta

```java
boolean requiereSegundaVuelta() {
    if (totalVotosEmitidos == 0) return false;
    
    ordenarPorVotos();
    double porcentaje = (votosPorCandidato[0] * 100.0) / 
                        totalVotosEmitidos;
    
    return porcentaje < 50.0; // Requiere más del 50%
}
```

## Formato de Resultados

```bash
╔════════════════════════════════════════════╗
║      RESULTADOS OFICIALES - ELECCIÓN       ║
╠════════════════════════════════════════════╣
║ Votantes registrados:    500               ║
║ Votos emitidos:          387               ║
║ Participación:           77.4%             ║
║ Abstención:              22.6%             ║
╠════════════════════════════════════════════╣
║ RESULTADOS POR CANDIDATO:                  ║
╠════════════════════════════════════════════╣
║ 1. María García (Partido A)               ║
║    Votos: 156 (40.3%)                      ║
║    ████████████████████                    ║
║                                            ║
║ 2. Juan López (Partido B)                 ║
║    Votos: 132 (34.1%)                      ║
║    ████████████████                        ║
║                                            ║
║ 3. Carlos Ruiz (Partido C)                ║
║    Votos: 78 (20.2%)                       ║
║    ██████████                              ║
║                                            ║
║ 4. Ana Martínez (Independiente)           ║
║    Votos: 21 (5.4%)                        ║
║    ███                                     ║
╠════════════════════════════════════════════╣
║ ⚠️  Se requiere SEGUNDA VUELTA             ║
║    Ningún candidato alcanzó 50%+1          ║
╚════════════════════════════════════════════╝
```

## Casos de Prueba

Candidatos:

1. María García - Partido Progresista
2. Juan López - Partido Liberal
3. Carlos Ruiz - Partido Conservador
4. Ana Martínez - Independiente

Simular 100 votantes con votos distribuidos.

## Tiempo Estimado

3-4 horas

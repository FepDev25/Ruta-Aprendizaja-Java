# PROYECTO 03: Sistema de Calificaciones 📝

## Dificultad: ⭐⭐⭐

## Descripción General

Sistema para gestionar calificaciones de estudiantes con estadísticas avanzadas, promedios, rankings y análisis de rendimiento.

## Estructura de Datos

```java
final int MAX_ESTUDIANTES = 50;
final int MAX_MATERIAS = 8;

String[] nombresEstudiantes = new String[MAX_ESTUDIANTES];
double[][] calificaciones = new double[MAX_ESTUDIANTES][MAX_MATERIAS];
String[] nombresMaterias = new String[MAX_MATERIAS];
boolean[][] asistencias = new boolean[MAX_ESTUDIANTES][MAX_MATERIAS];

int totalEstudiantes = 0;
int totalMaterias = 5; // Predefinido
```

## Funcionalidades

### 1. Gestión de Estudiantes

- Registrar estudiante
- Eliminar estudiante
- Listar todos

### 2. Gestión de Calificaciones

- Ingresar calificación (0-100)
- Modificar calificación
- Ver calificaciones de un estudiante
- Ver calificaciones de una materia

### 3. Promedios y Estadísticas

- Promedio por estudiante
- Promedio por materia
- Promedio general del grupo
- Estudiante con mejor promedio
- Estudiante con peor promedio
- Materia más difícil (menor promedio)
- Materia más fácil (mayor promedio)

### 4. Rankings

- Top 10 estudiantes
- Últimos 5 estudiantes
- Ordenar por promedio general
- Ordenar por materia específica

### 5. Análisis de Rendimiento

- Estudiantes aprobados/reprobados (>= 60)
- Distribución de calificaciones:
  - 90-100: Excelente
  - 80-89: Muy Bueno
  - 70-79: Bueno
  - 60-69: Suficiente
  - 0-59: Insuficiente
- Porcentaje de aprobación por materia

### 6. Reportes

- Boleta individual
- Reporte grupal
- Histograma de calificaciones
- Gráfico ASCII de distribución

## Algoritmos Clave

### Calcular Promedio Estudiante

```java
double calcularPromedioEstudiante(int indice) {
    double suma = 0;
    int materiasCursadas = 0;
    
    for (int j = 0; j < totalMaterias; j++) {
        if (calificaciones[indice][j] >= 0) {
            suma += calificaciones[indice][j];
            materiasCursadas++;
        }
    }
    
    return materiasCursadas > 0 ? suma / materiasCursadas : 0;
}
```

### Ordenar por Promedio

```java
void ordenarPorPromedio() {
    for (int i = 0; i < totalEstudiantes - 1; i++) {
        for (int j = i + 1; j < totalEstudiantes; j++) {
            if (calcularPromedioEstudiante(i) < 
                calcularPromedioEstudiante(j)) {
                intercambiarEstudiantes(i, j);
            }
        }
    }
}
```

### Encontrar Mediana

```java
double calcularMediana(int materia) {
    // Copiar calificaciones a array temporal
    double[] temp = new double[totalEstudiantes];
    for (int i = 0; i < totalEstudiantes; i++) {
        temp[i] = calificaciones[i][materia];
    }
    
    // Ordenar
    ordenarArray(temp);
    
    // Calcular mediana
    int medio = totalEstudiantes / 2;
    if (totalEstudiantes % 2 == 0) {
        return (temp[medio - 1] + temp[medio]) / 2.0;
    } else {
        return temp[medio];
    }
}
```

## Formato de Boleta

```bash
╔════════════════════════════════════════════╗
║          BOLETA DE CALIFICACIONES          ║
╠════════════════════════════════════════════╣
║ Estudiante: Juan Pérez García              ║
║ Matrícula:  EST001                         ║
╠════════════════════════════════════════════╣
║ Materia              │ Calif. │ Estado     ║
╠══════════════════════╪════════╪════════════╣
║ Matemáticas          │  95.0  │ Excelente  ║
║ Física               │  88.5  │ Muy Bueno  ║
║ Química              │  76.0  │ Bueno      ║
║ Historia             │  82.0  │ Muy Bueno  ║
║ Inglés               │  91.5  │ Excelente  ║
╠════════════════════════════════════════════╣
║ PROMEDIO GENERAL:    86.6  │ Muy Bueno    ║
║ Estado:              APROBADO              ║
╚════════════════════════════════════════════╝
```

## Histograma de Distribución

```bash
Distribución de Calificaciones - Matemáticas

90-100: ████████████ (12 estudiantes)
80-89:  ████████ (8 estudiantes)
70-79:  ████ (4 estudiantes)
60-69:  ██ (2 estudiantes)
0-59:   █ (1 estudiante)

Promedio: 82.5
Mediana: 85.0
Moda: 90.0
```

## Extras (Opcionales)

1. **Asistencias:** Tracking de asistencias
2. **Tareas:** Array adicional para tareas
3. **Participación:** Puntos extra
4. **Desempeño histórico:** Comparar con semestres anteriores
5. **Predicción:** Estimar calificación final
6. **Exportar:** Generar archivo CSV

## Casos de Prueba

Estudiantes de prueba:

1. Juan Pérez - [95, 88, 76, 82, 91]
2. María García - [100, 95, 92, 88, 96]
3. Carlos López - [65, 70, 68, 72, 69]
4. Ana Martínez - [85, 88, 90, 84, 87]
5. Luis Rodríguez - [55, 58, 62, 60, 57]

## Tiempo Estimado

5-7 horas

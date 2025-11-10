# PROYECTO 04: Analizador de Datos Estadísticos 📈

## Dificultad: ⭐⭐⭐⭐

## Descripción General

Herramienta avanzada para análisis estadístico de conjuntos de datos numéricos. Implementa algoritmos estadísticos desde cero usando solo arrays.

## Estructura de Datos

```java
final int MAX_DATOS = 1000;
double[] datos = new double[MAX_DATOS];
int totalDatos = 0;
```

## Funcionalidades

### 1. Entrada de Datos

- Manual (uno por uno)
- Generación aleatoria (rango personalizado)
- Desde texto (copiar/pegar números)
- Carga de dataset predefinido

### 2. Estadística Descriptiva

**Medidas de Tendencia Central:**

- Media aritmética
- Mediana
- Moda (valor más frecuente)
- Media geométrica
- Media armónica

**Medidas de Dispersión:**

- Rango (max - min)
- Varianza (poblacional y muestral)
- Desviación estándar
- Coeficiente de variación
- Rango intercuartílico (Q3 - Q1)

**Medidas de Posición:**

- Mínimo y máximo
- Cuartiles (Q1, Q2, Q3)
- Deciles (D1-D9)
- Percentiles (P1-P99)

### 3. Análisis de Distribución

- Frecuencias absolutas
- Frecuencias relativas
- Frecuencias acumuladas
- Tabla de frecuencias agrupadas
- Histograma ASCII
- Polígono de frecuencias

### 4. Detección de Outliers

- Método del rango intercuartílico (IQR)
- Límite inferior: Q1 - 1.5 × IQR
- Límite superior: Q3 + 1.5 × IQR
- Listar valores atípicos

### 5. Transformaciones de Datos

- Normalización (0-1)
- Estandarización (z-score)
- Logaritmo natural
- Raíz cuadrada
- Potencia

### 6. Comparación de Datasets

- Cargar dos conjuntos de datos
- Comparar medias (prueba t básica)
- Comparar varianzas
- Gráfico comparativo

### 7. Análisis de Correlación

- Entre dos variables (dos arrays)
- Coeficiente de correlación de Pearson
- Diagrama de dispersión ASCII

### 8. Regresión Lineal Simple

- Calcular pendiente y ordenada
- Ecuación de la recta: y = mx + b
- Predicciones
- R² (coeficiente de determinación)

## Algoritmos Estadísticos

### Media Aritmética

```java
double calcularMedia() {
    double suma = 0;
    for (int i = 0; i < totalDatos; i++) {
        suma += datos[i];
    }
    return suma / totalDatos;
}
```

### Mediana

```java
double calcularMediana() {
    // Copiar y ordenar
    double[] temp = copiarArray(datos, totalDatos);
    ordenar(temp);
    
    int medio = totalDatos / 2;
    if (totalDatos % 2 == 0) {
        return (temp[medio - 1] + temp[medio]) / 2.0;
    } else {
        return temp[medio];
    }
}
```

### Moda

```java
double calcularModa() {
    int maxFrecuencia = 0;
    double moda = datos[0];
    
    for (int i = 0; i < totalDatos; i++) {
        int frecuencia = contarFrecuencia(datos[i]);
        if (frecuencia > maxFrecuencia) {
            maxFrecuencia = frecuencia;
            moda = datos[i];
        }
    }
    
    return moda;
}
```

### Varianza

```java
double calcularVarianza() {
    double media = calcularMedia();
    double sumaCuadrados = 0;
    
    for (int i = 0; i < totalDatos; i++) {
        double diferencia = datos[i] - media;
        sumaCuadrados += diferencia * diferencia;
    }
    
    return sumaCuadrados / totalDatos;
}
```

### Desviación Estándar

```java
double calcularDesviacionEstandar() {
    return Math.sqrt(calcularVarianza());
}
```

### Cuartiles

```java
double calcularCuartil(int q) {
    double[] ordenado = copiarYOrdenar(datos);
    int posicion = (q * (totalDatos + 1)) / 4;
    return ordenado[posicion];
}
```

### Correlación de Pearson

```java
double calcularCorrelacion(double[] x, double[] y, int n) {
    double mediaX = media(x, n);
    double mediaY = media(y, n);
    
    double sumProductos = 0;
    double sumCuadradosX = 0;
    double sumCuadradosY = 0;
    
    for (int i = 0; i < n; i++) {
        double difX = x[i] - mediaX;
        double difY = y[i] - mediaY;
        
        sumProductos += difX * difY;
        sumCuadradosX += difX * difX;
        sumCuadradosY += difY * difY;
    }
    
    return sumProductos / 
           Math.sqrt(sumCuadradosX * sumCuadradosY);
}
```

### Regresión Lineal

```java
void calcularRegresion(double[] x, double[] y, int n) {
    double mediaX = media(x, n);
    double mediaY = media(y, n);
    
    double numerador = 0;
    double denominador = 0;
    
    for (int i = 0; i < n; i++) {
        numerador += (x[i] - mediaX) * (y[i] - mediaY);
        denominador += (x[i] - mediaX) * (x[i] - mediaX);
    }
    
    double m = numerador / denominador;
    double b = mediaY - m * mediaX;
    
    System.out.println("Ecuación: y = " + m + "x + " + b);
}
```

## Histograma ASCII

```bash
Distribución de Frecuencias (intervalo: 10)

  0-10:  ████ (4)
 10-20:  ████████ (8)
 20-30:  ████████████████ (16)
 30-40:  ████████████████████ (20)
 40-50:  ████████████ (12)
 50-60:  ████████ (8)
 60-70:  ████ (4)
 70-80:  ██ (2)
 80-90:  █ (1)
90-100:  █ (1)

Total: 76 datos
```

## Tabla de Frecuencias

```bash
╔══════════════════════════════════════════════════════════╗
║              TABLA DE FRECUENCIAS                        ║
╠═════════╦═════════╦═════════╦═════════╦═════════════════╣
║ Clase   ║   fi    ║   fr    ║   Fi    ║      Fr         ║
╠═════════╬═════════╬═════════╬═════════╬═════════════════╣
║  0-10   ║    4    ║  0.053  ║    4    ║     5.3%        ║
║ 10-20   ║    8    ║  0.105  ║   12    ║    15.8%        ║
║ 20-30   ║   16    ║  0.211  ║   28    ║    36.8%        ║
║ 30-40   ║   20    ║  0.263  ║   48    ║    63.2%        ║
║ 40-50   ║   12    ║  0.158  ║   60    ║    78.9%        ║
╚═════════╩═════════╩═════════╩═════════╩═════════════════╝
```

## Reporte Completo

```bash
╔════════════════════════════════════════════╗
║       ANÁLISIS ESTADÍSTICO COMPLETO        ║
╠════════════════════════════════════════════╣
║ Tamaño de muestra: 100                     ║
║                                            ║
║ TENDENCIA CENTRAL:                         ║
║   Media:             50.5                  ║
║   Mediana:           52.0                  ║
║   Moda:              48.0                  ║
║                                            ║
║ DISPERSIÓN:                                ║
║   Rango:             98.5                  ║
║   Varianza:          425.3                 ║
║   Desv. Estándar:    20.6                  ║
║   Coef. Variación:   40.8%                 ║
║                                            ║
║ POSICIÓN:                                  ║
║   Mínimo:            1.5                   ║
║   Q1:                32.5                  ║
║   Q2 (Mediana):      52.0                  ║
║   Q3:                68.5                  ║
║   Máximo:            100.0                 ║
║   IQR:               36.0                  ║
║                                            ║
║ OUTLIERS:                                  ║
║   Detectados: 3                            ║
║   Valores: [1.5, 2.3, 100.0]               ║
╚════════════════════════════════════════════╝
```

## Extras (Opcionales)

1. **Prueba de normalidad:** Verificar distribución normal
2. **Asimetría y curtosis:** Medidas de forma
3. **Intervalos de confianza:** Para la media
4. **Comparación de grupos:** ANOVA simple
5. **Series de tiempo:** Análisis de tendencia
6. **Bootstrap:** Remuestreo para intervalos

## Casos de Prueba

Dataset 1: Calificaciones

```bash
[85, 90, 78, 92, 88, 76, 95, 82, 89, 91, 
 87, 84, 93, 79, 86, 90, 88, 85, 92, 81]
```

Dataset 2: Edades

```bash
[23, 25, 22, 28, 30, 24, 27, 26, 29, 23, 
 25, 31, 22, 24, 28, 26, 25, 27, 24, 23]
```

## Tiempo Estimado

8-10 horas

# PROYECTO 02: Procesador de Imágenes ASCII 🖼️

## Dificultad: ⭐⭐⭐⭐

## Descripción General

Editor de imágenes que representa gráficos usando caracteres ASCII en matrices. Implementa filtros, rotaciones, detección de bordes y efectos visuales.

## Estructura de Datos

```java
final int MAX_ALTO = 50;
final int MAX_ANCHO = 80;

char[][] imagen = new char[MAX_ALTO][MAX_ANCHO];
char[][] imagenTemporal = new char[MAX_ALTO][MAX_ANCHO];

int alto, ancho;

// Escala de grises ASCII (de oscuro a claro)
char[] escalaGrises = {' ', '.', ':', '-', '=', '+', '*', '#', '%', '@'};
```

## Funcionalidades

### 1. Carga y Visualización

- Crear imagen en blanco
- Cargar imagen predefinida (logo, emoji, texto)
- Dibujar líneas y formas básicas
- Visualizar imagen actual

### 2. Transformaciones Geométricas

- **Rotar 90°** (horario/antihorario)
- **Rotar 180°**
- **Espejo horizontal** (voltear izq-der)
- **Espejo vertical** (voltear arriba-abajo)
- **Escalar** (ampliar/reducir)
- **Recortar** (crop)

### 3. Filtros Básicos

- **Invertir:** cambiar caracteres oscuros↔claros
- **Aclarar:** subir en escala de grises
- **Oscurecer:** bajar en escala de grises
- **Alto contraste:** solo extremos
- **Binarizar:** solo blanco/negro

### 4. Filtros Avanzados

- **Blur (desenfoque):** promediar vecindario
- **Sharpen (nitidez):** realzar diferencias
- **Detección de bordes:** algoritmo Sobel simplificado
- **Emboss (relieve):** efecto 3D
- **Negativo:** invertir completamente

### 5. Operaciones de Composición

- **Superponer:** dos imágenes en capas
- **Diferencia:** XOR de dos imágenes
- **Mezclar:** promedio ponderado

## Algoritmos Clave

### Rotar 90° Horario

```java
char[][] rotar90Horario(char[][] img, int alto, int ancho) {
    char[][] rotada = new char[ancho][alto];
    
    for (int i = 0; i < alto; i++) {
        for (int j = 0; j < ancho; j++) {
            rotada[j][alto - 1 - i] = img[i][j];
        }
    }
    
    return rotada;
}
```

### Espejo Horizontal

```java
void espejoHorizontal(char[][] img, int alto, int ancho) {
    for (int i = 0; i < alto; i++) {
        for (int j = 0; j < ancho / 2; j++) {
            char temp = img[i][j];
            img[i][j] = img[i][ancho - 1 - j];
            img[i][ancho - 1 - j] = temp;
        }
    }
}
```

### Filtro Blur (3×3)

```java
char aplicarBlur(char[][] img, int i, int j, int alto, int ancho) {
    int suma = 0;
    int contador = 0;
    
    // Ventana 3×3
    for (int di = -1; di <= 1; di++) {
        for (int dj = -1; dj <= 1; dj++) {
            int ni = i + di;
            int nj = j + dj;
            
            if (ni >= 0 && ni < alto && nj >= 0 && nj < ancho) {
                suma += obtenerValor(img[ni][nj]);
                contador++;
            }
        }
    }
    
    int promedio = suma / contador;
    return obtenerCaracter(promedio);
}

int obtenerValor(char c) {
    for (int i = 0; i < escalaGrises.length; i++) {
        if (escalaGrises[i] == c) return i;
    }
    return 0;
}

char obtenerCaracter(int valor) {
    return escalaGrises[Math.min(valor, escalaGrises.length - 1)];
}
```

### Detección de Bordes (Sobel simplificado)

```java
char detectarBorde(char[][] img, int i, int j, int alto, int ancho) {
    // Operador Sobel horizontal
    int gx = 0;
    if (i > 0 && j > 0 && i < alto-1 && j < ancho-1) {
        gx = obtenerValor(img[i-1][j+1]) + 
             2*obtenerValor(img[i][j+1]) + 
             obtenerValor(img[i+1][j+1]) -
             obtenerValor(img[i-1][j-1]) - 
             2*obtenerValor(img[i][j-1]) - 
             obtenerValor(img[i+1][j-1]);
    }
    
    // Operador Sobel vertical
    int gy = 0;
    if (i > 0 && j > 0 && i < alto-1 && j < ancho-1) {
        gy = obtenerValor(img[i+1][j-1]) + 
             2*obtenerValor(img[i+1][j]) + 
             obtenerValor(img[i+1][j+1]) -
             obtenerValor(img[i-1][j-1]) - 
             2*obtenerValor(img[i-1][j]) - 
             obtenerValor(img[i-1][j+1]);
    }
    
    int magnitud = (int)Math.sqrt(gx*gx + gy*gy);
    return magnitud > 3 ? '#' : ' ';
}
```

### Escalar (reducir a la mitad)

```java
char[][] escalarMitad(char[][] img, int alto, int ancho) {
    int nuevoAlto = alto / 2;
    int nuevoAncho = ancho / 2;
    char[][] escalada = new char[nuevoAlto][nuevoAncho];
    
    for (int i = 0; i < nuevoAlto; i++) {
        for (int j = 0; j < nuevoAncho; j++) {
            // Promediar bloque 2×2
            int suma = obtenerValor(img[i*2][j*2]) +
                       obtenerValor(img[i*2][j*2+1]) +
                       obtenerValor(img[i*2+1][j*2]) +
                       obtenerValor(img[i*2+1][j*2+1]);
            escalada[i][j] = obtenerCaracter(suma / 4);
        }
    }
    
    return escalada;
}
```

## Imágenes Predefinidas

### Emoji Feliz (10×10)

```bash
   @@@@   
  @    @  
 @  ##  @ 
 @      @ 
 @ #  # @ 
 @  ##  @ 
  @ ## @  
   @@@@   
          
```

### Logo Simple (15×20)

```bash
####################
#                  #
#   ####    ####   #
#   #  #    #  #   #
#   ####    ####   #
#   #       #      #
#   #       #      #
#                  #
####################
```

## Menú Interactivo

```bash
╔════════════════════════════════════════════╗
║      PROCESADOR DE IMÁGENES ASCII          ║
╠════════════════════════════════════════════╣
║  1. Crear imagen en blanco                 ║
║  2. Cargar imagen predefinida              ║
║  3. Mostrar imagen                         ║
║  4. Rotar imagen                           ║
║  5. Espejar (H/V)                          ║
║  6. Aplicar filtro                         ║
║  7. Detectar bordes                        ║
║  8. Escalar imagen                         ║
║  9. Recortar imagen                        ║
║ 10. Superponer imágenes                    ║
║ 11. Deshacer última operación              ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Validaciones

- Verificar límites al rotar/escalar
- Asegurar índices válidos en vecindarios
- Imagen no vacía para operaciones
- Tamaños compatibles para superponer

## Extras (Opcionales)

1. **Historial de operaciones** (undo/redo)
2. **Dibujo interactivo** (líneas, rectángulos, círculos)
3. **Texto sobre imagen**
4. **Guardar/cargar desde archivo**
5. **Animaciones ASCII** (frames)
6. **Compresión Run-Length Encoding**

## Casos de Prueba

Imagen Original (5×5):

```bash
##.##
#...#
.....
#...#
##.##
```

Rotar 90°:

```bash
###.#
#....
.....
....#
###.#
```

Espejo Horizontal:

```bash
##.##
#...#
.....
#...#
##.##
```

Detección Bordes:

```bash
#####
#   #
#   #
#   #
#####
```

## Tiempo Estimado

6-8 horas

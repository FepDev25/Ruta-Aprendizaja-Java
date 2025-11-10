# PROYECTO 08: Validador de Datos 🔍

## Dificultad: ⭐⭐⭐

## Descripción General

Desarrolla una herramienta completa de validación que verifique diferentes tipos de datos, detecte patrones, valide formatos y proporcione retroalimentación detallada. Perfecta para practicar Strings, operadores y condicionales complejos.

## Objetivos de Aprendizaje

- Manipulación avanzada de Strings
- Uso de expresiones regulares básicas con matches()
- Validaciones complejas con múltiples condiciones
- Lógica booleana avanzada
- Operadores relacionales y lógicos
- Manejo de caracteres especiales
- Wrappers y conversiones

## Funcionalidades Requeridas

### Menú Principal

```bash
╔════════════════════════════════════════════╗
║      VALIDADOR DE DATOS v2.0 🔍            ║
╠════════════════════════════════════════════╣
║  1. Validar Email                          ║
║  2. Validar Contraseña                     ║
║  3. Validar Número de Teléfono             ║
║  4. Validar Fecha                          ║
║  5. Validar Nombre de Usuario              ║
║  6. Validar URL                            ║
║  7. Validar Tarjeta de Crédito             ║
║  8. Validar Código Postal                  ║
║  9. Validar RFC/DNI/Cédula                 ║
║ 10. Validar IPv4                           ║
║ 11. Validar Nombre Completo                ║
║ 12. Validar Número de Matrícula            ║
║ 13. Modo Batch (validar múltiples)         ║
║ 14. Generador de datos válidos             ║
║  0. Salir                                  ║
╚════════════════════════════════════════════╝
```

## Validadores Detallados

### 1. Validador de Email 📧

**Reglas básicas:**

- Debe contener exactamente un @
- Debe haber al menos un caracter antes del @
- Debe haber al menos un caracter después del @
- Debe contener un punto (.) después del @
- Debe haber al menos 2 caracteres después del último punto
- No puede empezar ni terminar con punto
- No puede contener espacios
- Caracteres permitidos: letras, números, punto, guion, underscore

**Validaciones adicionales:**

- Longitud mínima: 5 caracteres
- Longitud máxima: 100 caracteres
- Dominios comunes: gmail, yahoo, hotmail, outlook
- TLDs comunes: .com, .net, .org, .edu, .mx, .es

**Niveles de validación:**

- **Básica**: Estructura mínima correcta
- **Intermedia**: + restricciones de caracteres
- **Avanzada**: + dominios conocidos, formato profesional

**Formato de salida:**

```bash
╔════════════════════════════════════════════╗
║         VALIDACIÓN DE EMAIL                ║
╠════════════════════════════════════════════╣
║ Email ingresado: usuario@gmail.com         ║
║                                            ║
║ ✓ Tiene formato válido                     ║
║ ✓ Contiene @                               ║
║ ✓ Tiene dominio válido                     ║
║ ✓ Tiene extensión válida                   ║
║ ✓ Longitud apropiada                       ║
║ ✓ Sin caracteres inválidos                 ║
║                                            ║
║ Resultado: ✓ EMAIL VÁLIDO                  ║
║ Confianza: 100%                            ║
║ Tipo: Email personal (Gmail)               ║
╚════════════════════════════════════════════╝
```

**Casos de prueba:**

- ✓ <usuario@dominio.com>
- ✓ <nombre.apellido@empresa.mx>
- ✗ @sinusuario.com
- ✗ <usuario@.com>
- ✗ usuario@dominio
- ✗ usuario <espacios@dominio.com>

### 2. Validador de Contraseña 🔒

**Niveles de seguridad:**

**Débil:**

- Mínimo 6 caracteres
- Solo letras o solo números

**Media:**

- Mínimo 8 caracteres
- Letras y números

**Fuerte:**

- Mínimo 10 caracteres
- Letras mayúsculas y minúsculas
- Números
- Al menos un carácter especial (@, #, $, %, &, *, !)

**Muy Fuerte:**

- Mínimo 12 caracteres
- Todas las condiciones anteriores
- Sin secuencias obvias (123, abc)
- Sin palabras comunes (password, admin)

**Validaciones:**

1. Longitud mínima y máxima (6-50)
2. Contiene mayúsculas
3. Contiene minúsculas
4. Contiene números
5. Contiene caracteres especiales
6. No contiene espacios
7. No es una contraseña común

**Contraseñas comunes a rechazar:**

- password, 123456, qwerty, admin, letmein, welcome

**Análisis de fortaleza:**

```bash
╔════════════════════════════════════════════╗
║      ANÁLISIS DE CONTRASEÑA                ║
╠════════════════════════════════════════════╣
║ Contraseña: MyP@ssw0rd2024                 ║
║                                            ║
║ ✓ Longitud: 14 caracteres                  ║
║ ✓ Contiene mayúsculas (2)                  ║
║ ✓ Contiene minúsculas (7)                  ║
║ ✓ Contiene números (4)                     ║
║ ✓ Contiene símbolos (1)                    ║
║ ✓ No contiene espacios                     ║
║ ✗ Contiene palabra común: "password"      ║
║                                            ║
║ Nivel: FUERTE                              ║
║ Puntuación: 85/100                         ║
║ Tiempo estimado para crackear: 5 años     ║
║                                            ║
║ Sugerencias:                               ║
║ - Evita palabras comunes                   ║
║ - Usa más caracteres especiales            ║
╚════════════════════════════════════════════╝
```

### 3. Validador de Teléfono 📱

**Formatos aceptados:**

- 10 dígitos: 5551234567
- Con guiones: 555-123-4567
- Con paréntesis: (555) 123-4567
- Con código país: +52 555 123 4567
- Con espacios: 555 123 4567

**Validaciones:**

- Exactamente 10 dígitos (sin código país)
- Solo números y separadores permitidos
- No puede empezar con 0 o 1 (en muchos países)
- Código de área válido (3 dígitos)

**Análisis:**

- Extraer código de área
- Extraer número local
- Identificar tipo (móvil/fijo basado en código de área)
- Validar código de área conocido

### 4. Validador de Fecha 📅

**Formatos soportados:**

- dd/mm/yyyy (08/11/2025)
- yyyy-mm-dd (2025-11-08)
- dd-mm-yyyy (08-11-2025)
- dd.mm.yyyy (08.11.2025)

**Validaciones:**

- Día válido (1-31)
- Mes válido (1-12)
- Año válido (1900-2100)
- Días correctos según mes (febrero 28/29, etc.)
- Años bisiestos
- Fecha no puede ser futura (opcional)
- Fecha debe ser mayor a una específica (opcional)

**Algoritmo de año bisiesto:**

```bash
Es bisiesto si:
- Divisible por 4 Y
- (NO divisible por 100 O divisible por 400)
```

**Análisis adicional:**

- Calcular día de la semana
- Calcular edad si es fecha de nacimiento
- Días desde/hasta hoy
- Es fin de semana o día laboral

**Formato de salida:**

```bash
╔════════════════════════════════════════════╗
║        VALIDACIÓN DE FECHA                 ║
╠════════════════════════════════════════════╣
║ Fecha ingresada: 08/11/2025                ║
║                                            ║
║ ✓ Formato válido (dd/mm/yyyy)              ║
║ ✓ Día válido (08)                          ║
║ ✓ Mes válido (11 - Noviembre)              ║
║ ✓ Año válido (2025)                        ║
║ ✓ Combinación válida                       ║
║                                            ║
║ Información adicional:                     ║
║ - Día de la semana: Sábado                 ║
║ - Es fin de semana: Sí                     ║
║ - Días desde hoy: 0 (hoy)                  ║
║ - Estación: Otoño                          ║
║                                            ║
║ Resultado: ✓ FECHA VÁLIDA                  ║
╚════════════════════════════════════════════╝
```

### 5. Validador de Nombre de Usuario 👤

**Reglas:**

- Longitud: 3-20 caracteres
- Solo letras, números, guion bajo, guion medio
- Debe empezar con letra
- No puede terminar con guion
- No puede tener dos guiones consecutivos
- No caracteres especiales ni espacios
- No números al inicio

**Validaciones adicionales:**

- No puede ser una palabra reservada (admin, root, system)
- No puede contener palabras ofensivas
- Debe ser único (simular con array de usuarios existentes)

**Sugerencias:**

- Si no es válido, sugerir alternativas
- Agregar números al final
- Reemplazar espacios por guiones

### 6. Validador de URL 🌐

**Estructura básica:**

```bash
protocolo://dominio.extension/ruta?parametros#fragmento
```

**Validaciones:**

- Protocolo válido: http, https, ftp
- Dominio no vacío
- Extensión válida (2-6 letras)
- Caracteres permitidos en ruta
- Formato de parámetros correcto

**Análisis:**

- Extraer protocolo
- Extraer dominio
- Extraer extensión
- Extraer ruta
- Extraer parámetros
- Verificar si es URL segura (HTTPS)

### 7. Validador de Tarjeta de Crédito 💳

**Algoritmo de Luhn:**

```bash
1. De derecha a izquierda, duplicar cada segundo dígito
2. Si el resultado es > 9, sumar sus dígitos (18 → 1+8=9)
3. Sumar todos los dígitos
4. Si el total % 10 == 0, es válido
```

**Validaciones:**

- 13-19 dígitos
- Solo números (sin espacios ni guiones para cálculo)
- Aplicar algoritmo de Luhn
- Identificar tipo de tarjeta:
  - Visa: empieza con 4
  - MasterCard: empieza con 51-55
  - Amex: empieza con 34 o 37

**Formato:**

- Aceptar: 1234567890123456
- Aceptar: 1234 5678 9012 3456
- Aceptar: 1234-5678-9012-3456

### 8. Validador de Código Postal 📮

**Formatos por país:**

- **México**: 5 dígitos (12345)
- **USA**: 5 dígitos o 5+4 (12345 o 12345-6789)
- **España**: 5 dígitos (28001)
- **UK**: Formato especial (SW1A 1AA)

**Validaciones:**

- Longitud correcta según país
- Solo números (o formato UK)
- Rango válido
- No todo ceros

**Análisis:**

- Identificar país por formato
- Identificar estado/provincia (primeros dígitos)
- Validar que exista en lista de códigos conocidos

### 9. Validador de RFC/DNI/Cédula 🆔

**RFC (México):**

- 13 caracteres: 4 letras + 6 dígitos + 3 caracteres
- Formato: ABCD123456XYZ
- Validar estructura y dígito verificador

**DNI (España):**

- 8 dígitos + 1 letra
- Calcular letra verificadora

**Cédula (Colombia):**

- 6-10 dígitos
- Solo números

### 10. Validador de IPv4 🌍

**Formato:** XXX.XXX.XXX.XXX

**Validaciones:**

- Exactamente 4 octetos separados por puntos
- Cada octeto: número entre 0-255
- No puede tener ceros a la izquierda (01.1.1.1 es inválido)
- Sin espacios

**Análisis adicional:**

- Identificar clase de IP (A, B, C, D, E)
- Identificar si es privada o pública
- Identificar si es especial (loopback, broadcast)

**Rangos especiales:**

- Loopback: 127.0.0.0 - 127.255.255.255
- Privada clase A: 10.0.0.0 - 10.255.255.255
- Privada clase B: 172.16.0.0 - 172.31.255.255
- Privada clase C: 192.168.0.0 - 192.168.255.255

### 11. Validador de Nombre Completo 📝

**Reglas:**

- Mínimo 2 palabras (nombre y apellido)
- Solo letras, espacios, apóstrofes, guiones
- Cada palabra debe empezar con mayúscula
- No números ni caracteres especiales
- Longitud: 5-100 caracteres

**Validaciones:**

- Detectar títulos (Dr., Ing., Lic.)
- Detectar sufijos (Jr., Sr., III)
- Validar acentos y ñ
- No más de 5 palabras

### 12. Validador de Matrícula/Placa 🚗

**Formatos comunes:**

- **México**: 3 letras + 4 números (ABC1234)
- **USA**: Varía por estado, ej: ABC123, 1ABC234
- **Europa**: Formato país-específico

**Validaciones:**

- Formato correcto según país
- Letras permitidas (sin vocales en algunos formatos)
- Números en posición correcta
- Sin caracteres especiales

### 13. Modo Batch 📋

**Funcionalidad:**

- Ingresar múltiples datos del mismo tipo
- Validar todos a la vez
- Mostrar resumen de resultados:
  - Total validados
  - Válidos
  - Inválidos
  - Porcentaje de éxito
- Listar cuáles fallaron y por qué

### 14. Generador de Datos Válidos 🎲

**Para cada tipo de dato, generar ejemplos válidos:**

- Email aleatorio válido
- Contraseña fuerte aleatoria
- Teléfono válido
- Fecha válida aleatoria
- Username válido
- URL válida
- etc.

**Características:**

- Usar Math.random()
- Asegurar que cumple todas las reglas
- Opción de generar N ejemplos

## Requisitos Técnicos

### Métodos de String Esenciales

```java
- length()
- charAt()
- contains()
- indexOf(), lastIndexOf()
- substring()
- split()
- matches() // para patrones simples
- toLowerCase(), toUpperCase()
- trim()
- replace(), replaceAll()
- startsWith(), endsWith()
```

### Validación de Caracteres

```java
Character.isDigit(char)
Character.isLetter(char)
Character.isLetterOrDigit(char)
Character.isUpperCase(char)
Character.isLowerCase(char)
```

### Conversiones

```java
Integer.parseInt()
Double.parseDouble()
Manejo de NumberFormatException
```

## Conceptos a Aplicar

### 1. Strings (Principal)

- Todos los métodos mencionados
- Manipulación intensiva
- Búsqueda de patrones
- Extracción de subcadenas

### 2. Operadores

- Lógicos: &&, ||, !
- Relacionales: ==, !=, <, >, <=, >=
- Aritméticos: para algoritmos (Luhn)

### 3. Condicionales

- if-else anidados complejos
- switch para tipos de validación
- Operador ternario

### 4. Bucles

- for para recorrer caracteres
- while para bucles de validación
- Algoritmos iterativos

### 5. Wrappers

- Character para análisis de chars
- Integer, Double para conversiones

## Extras (Opcionales - Desafío)

1. **Modo interactivo**: Corregir dato inválido en tiempo real
2. **Historial**: Guardar todas las validaciones
3. **Estadísticas**: Qué validaciones fallan más
4. **Comparador**: Comparar fortaleza de 2 contraseñas
5. **API simulada**: Validar contra "base de datos"
6. **Validador personalizado**: Usuario crea sus reglas
7. **Exportar reglas**: Documentar todas las validaciones

## Criterios de Evaluación

- **Todas las validaciones funcionan**
- **Mensajes claros y descriptivos**
- **Manejo de casos especiales**
- **Código modular y reutilizable**
- **Validaciones precisas**
- **Formato profesional**

## Tiempo Estimado

5-7 horas de desarrollo

## Consejos

1. Empieza con validaciones simples (email, teléfono)
2. Crea métodos auxiliares reutilizables
3. Prueba con casos extremos
4. Usa constantes para valores fijos
5. Documenta las reglas de cada validación
6. Proporciona mensajes útiles de error
7. Haz el código modular

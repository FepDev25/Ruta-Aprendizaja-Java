# P01 - Fundamentos de Java

## Descripción General

Este módulo cubre los conceptos fundamentales del lenguaje Java, incluyendo sintaxis básica, tipos de datos, operadores, estructuras de control, y conceptos esenciales de programación orientada a objetos a nivel básico.

## Información del Proyecto

- **Artifact ID:** p01_basicos
- **Group ID:** com.cultodeportivo
- **Versión:** 1.0-SNAPSHOT
- **Java Version:** 21
- **Build Tool:** Maven

## Contenido del Módulo

### 1. Operadores

#### Operadores Aritméticos

- `OperadoresAritmeticos.java` - Implementación de operaciones matemáticas básicas (suma, resta, multiplicación, división, módulo)

#### Operadores de Asignación

- `OperadoresAsignacion.java` - Operadores de asignación compuesta (+=, -=, *=, /=, %=)

#### Operadores Relacionales

- `OperadoresRelacionales.java` - Comparaciones entre valores (==, !=, <, >, <=, >=)

#### Operadores Lógicos

- `OperadoresLogicos.java` - Operadores AND (&&), OR (||), NOT (!)
- `OperadoresLogicosLogin.java` - Ejemplo práctico de validación de credenciales

#### Operadores Unarios

- `OperadoresUnarios.java` - Incremento (++), decremento (--), negación

#### Precedencia de Operadores

- `PrecedenciaOperadores.java` - Orden de evaluación de expresiones complejas

### 2. Estructuras de Control

#### Condicionales

- `SentenciaIf.java` - Estructura if básica
- `SentenciaIfElse.java` - Estructura if-else
- `SentenciaIfElseIfNumDiasMes.java` - Ejemplo práctico para determinar días en un mes
- `SentenciaSwitchCase.java` - Estructura switch-case
- `SentenciaSwitchCaseNumDiasMes.java` - Implementación alternativa con switch
- `OperadorTernario.java` - Operador condicional ternario (? :)
- `OperadorTernarioNumeroMayor.java` - Ejemplo de uso del operador ternario

#### Bucles

- `SentenciaFor.java` - Bucle for básico
- `SentenciaForArreglo.java` - Iteración sobre arreglos con for
- `SentenciaWhile.java` - Bucle while
- `SentenciaDoWhile.java` - Bucle do-while
- `SentenciasBucleEtiquetas.java` - Uso de etiquetas (labels) en bucles
- `SentenciasBucleEtiquetasBuscar.java` - Búsqueda con break y etiquetas

### 3. Tipos de Datos Primitivos

#### Enteros

- `PrimitivosEnteros.java` - Tipos byte, short, int, long

#### Flotantes

- `PrimitivosFloat.java` - Tipos float y double

#### Caracteres

- `PrimitivosCaracteres.java` - Tipo char y representación Unicode

#### Booleanos

- `PrimitivosBooleanos.java` - Tipo boolean

#### Conversiones

- `ConversionDeTipos.java` - Casting implícito y explícito
- `ConversionDeTiposString.java` - Conversión entre String y tipos primitivos

### 4. Wrapper Classes y Autoboxing

- `WrapperInteger.java` - Clase envoltorio Integer
- `WrapperBoolean.java` - Clase envoltorio Boolean
- `AutoboxingInteger.java` - Autoboxing y unboxing automático
- `WrapperOperadoresRelacionales.java` - Comparación de objetos wrapper

### 5. Strings

#### Operaciones Básicas

- `EjemploString.java` - Creación y manipulación básica de cadenas
- `EjemploStringMetodos.java` - Métodos principales de la clase String
- `EjemploStringConcatenacion.java` - Concatenación de cadenas
- `EjemploStringInmutable.java` - Inmutabilidad de strings
- `EjemploStringValidar.java` - Validación de cadenas

#### Rendimiento

- `EjemploStringTestRendimientoConcat.java` - Comparación de rendimiento entre String, StringBuilder y StringBuffer

#### Extensiones

- `EjemploStringExtensionArchivo.java` - Extracción de extensiones de archivo

### 6. Entrada y Salida

#### Scanner

- `SistemasNumericos.java` - Conversión entre sistemas numéricos (decimal, binario, octal, hexadecimal)
- `SistemasNumericosEntradaScanner.java` - Lectura de datos con Scanner
- `SistemasNumericosScanner.java` - Validación de entrada con Scanner

#### Argumentos de Línea de Comandos

- `ArgumentosLineaComando.java` - Procesamiento de argumentos del main
- `ArgumentosLineaComandoCalculadora.java` - Calculadora simple usando argumentos

### 7. Fecha y Hora (java.util)

- `EjemploJavaUtilDate.java` - Uso básico de la clase Date
- `EjemploJavaUtilDateParse.java` - Parseo de fechas
- `EjemploJavaUtilCalendar.java` - Manipulación de fechas con Calendar

### 8. Clase Math

- `EjemploClaseMath.java` - Funciones matemáticas (abs, max, min, pow, sqrt, random, etc.)

### 9. Operador instanceof

- `OperadorInstanceOf.java` - Verificación de tipos en tiempo de ejecución
- `OperadorInstanceOfTiposGenericos.java` - instanceof con tipos genéricos

### 10. Paso de Parámetros

- `PasarPorValor.java` - Paso por valor de tipos primitivos
- `PasarPorReferencia.java` - Paso por referencia de objetos
- `PasoPorReferencia2.java` - Ejemplos adicionales de paso por referencia

### 11. Entorno del Sistema

- `EjemploVariablesDeEntorno.java` - Acceso a variables de entorno del sistema
- `EjemploPropiedadesDeSistema.java` - Propiedades del sistema Java
- `EjemploEjecutarProgramaSO.java` - Ejecución de programas externos desde Java

### 12. Clase Object

- `EjemploMetodoGetClass.java` - Introspección de clases con getClass()

## Conceptos Clave Aprendidos

1. **Tipos de Datos Primitivos:** Comprensión de los 8 tipos primitivos de Java y sus características.

2. **Operadores:** Dominio de operadores aritméticos, relacionales, lógicos y de asignación.

3. **Estructuras de Control:** Uso efectivo de condicionales (if, switch, ternario) y bucles (for, while, do-while).

4. **Inmutabilidad de Strings:** Entendimiento del comportamiento inmutable de String y uso de StringBuilder/StringBuffer para optimización.

5. **Wrapper Classes:** Conocimiento de las clases envoltorio y el mecanismo de autoboxing/unboxing.

6. **Entrada/Salida:** Manejo de entrada de usuario con Scanner y argumentos de línea de comandos.

7. **API de Utilidades:** Uso de clases utilitarias como Math, Date, Calendar.

8. **Reflexión Básica:** Introducción a la introspección con instanceof y getClass().

9. **Interacción con el Sistema:** Acceso a propiedades del sistema y variables de entorno.

## Ejecución de Ejemplos

Para ejecutar cualquier ejemplo de este módulo:

```bash
cd p01_basicos
mvn clean compile
mvn exec:java -Dexec.mainClass="com.cultodeportivo.<paquete>.<NombreClase>"
```

Por ejemplo:

```bash
mvn exec:java -Dexec.mainClass="com.cultodeportivo.operadores.OperadoresAritmeticos"
```

## Estructura de Paquetes

```bash
com.cultodeportivo
├── adicionales/
├── bucles/
├── condicionales/
├── entradasalida/
├── entornosistema/
├── operadores/
├── operadorinstanceof/
├── pasovalorreferencia/
├── strings/
├── utildate/
└── wrapperautoboxing/
```

## Notas Técnicas

- Todos los ejemplos son independientes y pueden ejecutarse de forma individual.
- El proyecto utiliza Maven para la gestión de dependencias y compilación.
- Se recomienda Java 21 para aprovechar las características más recientes del lenguaje.
- Los ejemplos siguen las convenciones de nomenclatura de Java (camelCase para métodos y variables, PascalCase para clases).

## Referencias

- [Java SE 21 Documentation](https://docs.oracle.com/en/java/javase/21/)
- [Java Language Specification](https://docs.oracle.com/javase/specs/)
- [Maven Documentation](https://maven.apache.org/guides/)

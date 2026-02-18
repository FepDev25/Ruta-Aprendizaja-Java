# An Introduction to Java

El libro, *Core Java, Volume I: Fundamentals*, en su Duodécima Edición, está actualizado para reflejar las características de **Java 17**. Este primer capítulo ofrece una visión general de las capacidades de Java que lo distinguen de otros lenguajes de programación, explica los objetivos de diseño de sus creadores y detalla su corta historia y evolución.

## 1.1 Java como Plataforma de Programación

Java irrumpió en la escena de Internet a finales de 1995 y alcanzó un estatus de celebridad instantánea. Fue el primer y único lenguaje de programación en tener una historia de diez minutos en National Public Radio. La promesa de Java era convertirse en el "pegamento universal" que conectaría a los usuarios con la información, independientemente de su fuente.

Aunque inicialmente se comentó que el entusiasmo en torno a Java como lenguaje estaba exagerado, se reconoció que **Java nunca fue solo un lenguaje; es toda una plataforma**.

La plataforma Java se distingue por tres componentes principales:

1. **Un buen lenguaje** con una sintaxis agradable y semántica comprensible (a diferencia de C++).
2. **Un vasto entorno de ejecución** que proporciona servicios esenciales como **seguridad, portabilidad** entre sistemas operativos y **recolección automática de basura** (*automatic garbage collection*).
3. **Una biblioteca enorme** que contiene miles de clases (la API ha crecido de unas 200 a más de 4,000 clases desde 1995, abarcando áreas como la interfaz de usuario, la gestión de bases de datos, la seguridad y el procesamiento XML).

Esta combinación de un buen lenguaje, un entorno de ejecución de alta calidad y una biblioteca extensa es lo que ha hecho de Java una propuesta "irresistible" para muchos programadores.

## 1.2 Las “Palabras de Moda” del Libro Blanco de Java

Los diseñadores de Java publicaron un influyente libro blanco que resumía sus objetivos de diseño mediante 11 "palabras de moda" (buzzwords):

1. **Simple**: Java fue diseñado para ser programado fácilmente, tomando la sintaxis de C++ pero omitiendo muchas de sus características confusas y poco utilizadas que causan más problemas que beneficios. Esto incluye la omisión de archivos de cabecera (*header files*), aritmética de punteros, sintaxis de punteros, estructuras, uniones, sobrecarga de operadores (*operator overloading*) y clases base virtuales. Además, ser simple implica ser **pequeño**; el intérprete básico y el soporte de clases ocupan solo unos 40K, con las bibliotecas estándar y el soporte de *threads* añadiendo otros 175K.
2. **Orientado a Objetos** (*Object-Oriented*).
3. **Distribuido** (*Distributed*).
4. **Robusto** (*Robust*).
5. **Seguro** (*Secure*).
6. **Arquitectura-Neutral** (*Architecture-Neutral*).
7. **Portátil** (*Portable*).
8. **Interpretado** (*Interpreted*).
9. **Alto Rendimiento** (*High-Performance*).
10. **Multihilo** (*Multithreaded*).
11. **Dinámico** (*Dynamic*).

## 1.4 Una Breve Historia de Java

La historia de Java se remonta a 1991, cuando un grupo de ingenieros de Sun, liderados por **James Gosling** y Patrick Naughton, comenzó el proyecto "Green". El objetivo era diseñar un lenguaje pequeño y que generara código ajustado, destinado a dispositivos de consumo como los descodificadores de televisión por cable. Era fundamental que el lenguaje no estuviera ligado a una única arquitectura, ya que diferentes fabricantes podrían elegir distintas CPUs.

La evolución de Java incluye hitos importantes:

* **Java 1.0 (1996):** Primer lanzamiento. Aunque generó entusiasmo, no era adecuado para el desarrollo serio de aplicaciones (por ejemplo, no se podía imprimir).
* **Java 1.1:** Mejoró las deficiencias más obvias de la versión 1.0, mejoró la capacidad de *reflection* y añadió un nuevo modelo de eventos para la programación GUI.
* **Java 1.2 (1998):** Renombrado a **Java 2 Standard Edition**. Reemplazó los kits de herramientas gráficos iniciales con versiones escalables sofisticadas. También se introdujeron la Micro Edition (para dispositivos embebidos) y la Enterprise Edition (para procesamiento del lado del servidor).
* **Java 1.3 y 1.4:** Mejoras incrementales. El interés inicial en *applets* de Java y aplicaciones del lado del cliente disminuyó, y Java se convirtió en la plataforma de elección para **aplicaciones del lado del servidor**.
* **Versión 5.0 (2004):** Primera actualización significativa del lenguaje desde la versión 1.1. Se añadieron tipos **genéricos** (similares a los *templates* de C++), el bucle "**for each**", *autoboxing* y **anotaciones**.
* **Java 9 (2017):** Introdujo el sistema de **módulos** para descomponer la plataforma monolítica de Java en unidades de código autocontenidas.
* **Desde 2018:** Las versiones de Java se lanzan cada seis meses para una introducción más rápida de características. Java 11 y **Java 17** han sido designadas versiones de **soporte a largo plazo (LTS)**.

## 1.5 Conceptos Erróneos Comunes sobre Java

El capítulo finaliza abordando varias ideas equivocadas sobre el lenguaje:

* **Java no es una extensión de HTML:** Java es un lenguaje de programación, mientras que HTML se usa para describir la estructura de una página web. No tienen nada en común, salvo que históricamente existieron extensiones HTML para colocar *applets* Java en páginas web.
* **Usar XML no elimina la necesidad de Java:** XML es una forma de describir datos; Java es un lenguaje de programación. Aunque XML puede procesarse con cualquier lenguaje, la API de Java contiene un excelente soporte para el procesamiento XML, y muchas herramientas importantes de XML están implementadas en Java.
* **Java no es un lenguaje de programación fácil de aprender:** Ningún lenguaje de la potencia de Java es realmente fácil. La dificultad radica en la cantidad de bibliotecas que deben manejarse para el trabajo serio. El libro solo dedica siete capítulos al lenguaje Java en sí; el resto (de ambos volúmenes) enseña cómo utilizar las bibliotecas, que contienen miles de clases e interfaces, muchas de las cuales deben conocerse para crear aplicaciones realistas.

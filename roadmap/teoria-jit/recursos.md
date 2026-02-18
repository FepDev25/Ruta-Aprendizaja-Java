# RECURSOS DE TEORIA JIT - JAVA

Este documento organiza toda la documentacion oficial y recursos de calidad para el aprendizaje teorico Just-In-Time.

## ESTRATEGIA DE USO

1. Antes de cada proyecto: leer modulos relevantes en la seccion correspondiente
2. Durante proyecto: consultar API docs y guias especificas
3. Para labs: profundizar en documentacion avanzada

---

## DOCUMENTACION OFICIAL ORACLE

### Core Documentation
- Java SE Documentation: https://docs.oracle.com/en/java/javase/21/
- Java Tutorials (The Java Tutorial): https://docs.oracle.com/javase/tutorial/
- Java Language Specification: https://docs.oracle.com/javase/specs/jls/se21/html/index.html
- JVM Specification: https://docs.oracle.com/javase/specs/jvms/se21/html/index.html
- Java API Documentation: https://docs.oracle.com/en/java/javase/21/docs/api/index.html

### JVM & Performance
- HotSpot Virtual Machine Garbage Collection Tuning Guide: https://docs.oracle.com/en/java/javase/21/gctuning/
- Java Platform, Standard Edition Tools Reference: https://docs.oracle.com/en/java/javase/21/docs/specs/man/
- Flight Recorder & Mission Control: https://docs.oracle.com/javacomponents/jmc.htm

### Modern Java Features
- JEP (JDK Enhancement Proposals): https://openjdk.org/jeps/0
- Release Notes por version: https://www.oracle.com/java/technologies/javase/21-relnotes.html

---

## RECURSOS POR FASE DE PROYECTOS

### FASE 1: FUNDAMENTOS (Proyectos 1-2)

**MODULO 2: Fundamentos de Java**
- Oracle Tutorial - Language Basics: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/
- Oracle Tutorial - Arrays: https://docs.oracle.com/javase/tutorial/java/nutsandbolts/arrays.html
- Effective Java (Libro) - Items 1-9, 49-58

**MODULO 3: POO**
- Oracle Tutorial - Classes and Objects: https://docs.oracle.com/javase/tutorial/java/javaOO/
- Oracle Tutorial - Interfaces and Inheritance: https://docs.oracle.com/javase/tutorial/java/IandI/
- Head First Java (Libro) - Capitulos 1-11
- Effective Java - Items 15-25 (Immutability, Composition)

**MODULO 4: Collections Framework**
- Oracle Tutorial - Collections: https://docs.oracle.com/javase/tutorial/collections/
- Java Collections Framework Overview: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/doc-files/coll-overview.html
- Effective Java - Items 26-30

**MODULO 5: Excepciones**
- Oracle Tutorial - Exceptions: https://docs.oracle.com/javase/tutorial/essential/exceptions/
- Effective Java - Items 69-77

**MODULO 6: I/O**
- Oracle Tutorial - Basic I/O: https://docs.oracle.com/javase/tutorial/essential/io/
- Oracle Tutorial - File I/O (NIO.2): https://docs.oracle.com/javase/tutorial/essential/io/fileio.html

**MODULO 12: Testing**
- JUnit 5 User Guide: https://junit.org/junit5/docs/current/user-guide/
- Mockito Documentation: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
- Test Driven Development by Example (Libro) - Kent Beck

---

### FASE 2: BACKEND & DATA (Proyectos 3-4)

**MODULO 8: Generics & Annotations**
- Oracle Tutorial - Generics: https://docs.oracle.com/javase/tutorial/java/generics/
- Oracle Tutorial - Annotations: https://docs.oracle.com/javase/tutorial/java/annotations/
- Java Generics and Collections (Libro) - Naftalin & Wadler
- Effective Java - Items 26-33

**MODULO 9: Streams API & Funcional**
- Oracle Tutorial - Lambda Expressions: https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html
- Oracle Tutorial - Aggregate Operations: https://docs.oracle.com/javase/tutorial/collections/streams/
- Package java.util.stream: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/stream/package-summary.html
- Modern Java in Action (Libro) - Manning

**MODULO 10: JDBC & Database**
- Oracle Tutorial - JDBC: https://docs.oracle.com/javase/tutorial/jdbc/
- JDBC API Guide: https://docs.oracle.com/en/java/javase/21/docs/api/java.sql/module-summary.html
- Hibernate Documentation: https://hibernate.org/orm/documentation/
- JPA Specification: https://jakarta.ee/specifications/persistence/

**MODULO 11: Frameworks (Spring Boot)**
- Spring Boot Reference Documentation: https://docs.spring.io/spring-boot/reference/
- Spring Framework Documentation: https://docs.spring.io/spring-framework/reference/
- Spring Data JPA Reference: https://docs.spring.io/spring-data/jpa/reference/
- Baeldung Spring Tutorials: https://www.baeldung.com/spring-tutorial

**MODULO 13: Build Tools**
- Maven Getting Started: https://maven.apache.org/guides/getting-started/
- Maven Complete Reference: https://maven.apache.org/ref/current/
- Gradle User Manual: https://docs.gradle.org/current/userguide/userguide.html
- Gradle Build Language Reference: https://docs.gradle.org/current/dsl/

---

### FASE 3: CONCURRENCIA & PERFORMANCE (Proyectos 5-6)

**MODULO 1: JVM Architecture**
- JVM Specification (leer capitulos 2, 5): https://docs.oracle.com/javase/specs/jvms/se21/html/
- Inside the Java Virtual Machine (Libro) - Bill Venners
- HotSpot Internals Wiki: https://wiki.openjdk.org/display/HotSpot/
- GC Tuning Guide completa: https://docs.oracle.com/en/java/javase/21/gctuning/
- Shipilev Blog (JVM Internals): https://shipilev.net/

**MODULO 7: Concurrency & Multithreading**
- Oracle Tutorial - Concurrency: https://docs.oracle.com/javase/tutorial/essential/concurrency/
- Package java.util.concurrent: https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/concurrent/package-summary.html
- Java Concurrency in Practice (Libro) - Brian Goetz (OBLIGATORIO)
- The Art of Multiprocessor Programming (Libro) - Herlihy & Shavit
- Doug Lea's Concurrent Programming in Java: http://gee.cs.oswego.edu/dl/cpj/

**MODULO 14: Performance & Tuning**
- Java Performance: The Definitive Guide (Libro) - Scott Oaks
- Optimizing Java (Libro) - Evans, Gough, Newland
- JMH Samples: https://github.com/openjdk/jmh/tree/master/jmh-samples
- Async Profiler Guide: https://github.com/async-profiler/async-profiler
- JFR & JMC Documentation: https://docs.oracle.com/javacomponents/jmc-5-5/jfr-runtime-guide/

---

### FASE 4: PRODUCCION & ECOSISTEMA (Proyectos 7-8)

**MODULO 11: Ecosistema Frameworks (Profundizacion)**
- Micronaut Documentation: https://docs.micronaut.io/latest/guide/
- Quarkus Guides: https://quarkus.io/guides/
- Spring Cloud Reference: https://docs.spring.io/spring-cloud/reference/
- Resilience4j User Guide: https://resilience4j.readme.io/
- Testcontainers Documentation: https://testcontainers.com/guides/

**MODULO 15: Modern Java Features**
- Java Language Updates (Java 8-21): https://docs.oracle.com/en/java/javase/21/language/
- Project Loom (Virtual Threads): https://openjdk.org/projects/loom/
- JEP 444 - Virtual Threads: https://openjdk.org/jeps/444
- JEP 441 - Pattern Matching for switch: https://openjdk.org/jeps/441
- JEP 431 - Sequenced Collections: https://openjdk.org/jeps/431
- Module System Tutorial: https://docs.oracle.com/javase/tutorial/modules/
- Inside Java Podcast: https://inside.java/podcast/

---

## LIBROS FUNDAMENTALES

### Obligatorios
1. **Effective Java (3rd Edition)** - Joshua Bloch
   - Bible de best practices
   - Leer items relevantes por modulo

2. **Java Concurrency in Practice** - Brian Goetz
   - Obligatorio antes de Proyectos 5-6
   - Fundamentos de concurrencia correcta

3. **Modern Java in Action** - Raoul-Gabriel Urma
   - Lambdas, Streams, Features modernas
   - Para Fase 2-4

### Recomendados
4. **Java Performance: The Definitive Guide** - Scott Oaks
   - Performance y JVM tuning
   - Para Proyectos 5-8

5. **Designing Data-Intensive Applications** - Martin Kleppmann
   - No especifico de Java pero esencial para arquitectura
   - Para Proyectos 7-8

6. **Release It! (2nd Edition)** - Michael Nygard
   - Patrones de produccion
   - Para Proyecto 7-8

### Referencia
7. **Core Java Volume I & II** - Cay Horstmann
   - Referencia completa del lenguaje
   - Consulta cuando necesario

8. **Java: The Complete Reference** - Herbert Schildt
   - Enciclopedia de Java
   - Referencia rapida

---

## RECURSOS ONLINE DE CALIDAD

### Tutoriales & Articulos
- Baeldung: https://www.baeldung.com/ (Tutoriales practicos de todo)
- JournalDev: https://www.journaldev.com/java-tutorial-java-ee-tutorials
- Vogella Tutorials: https://www.vogella.com/tutorials/java.html
- DZone Java Zone: https://dzone.com/java-jdk-development-tutorials-tools-news
- InfoQ Java: https://www.infoq.com/java/

### Blogs Tecnicos
- Inside Java: https://inside.java/ (Oficial de Oracle)
- Aleksey Shipilev: https://shipilev.net/ (JVM internals)
- Baeldung: https://www.baeldung.com/
- Vlad Mihalcea: https://vladmihalcea.com/ (JPA/Hibernate)
- Martin Fowler: https://martinfowler.com/ (Arquitectura)

### Comunidades
- Stack Overflow - Java Tag: https://stackoverflow.com/questions/tagged/java
- Reddit r/java: https://www.reddit.com/r/java/
- Java subreddit wiki: https://www.reddit.com/r/java/wiki/index
- OpenJDK Mailing Lists: https://mail.openjdk.org/mailman/listinfo

### Videos & Courses
- Java Brains (YouTube): https://www.youtube.com/@Java.Brains
- Amigoscode (YouTube): https://www.youtube.com/@amigoscode
- Oracle Learning Library: https://www.youtube.com/@OracleLearning
- Devoxx (Conferencias): https://www.youtube.com/@DevoxxForever

---

## HERRAMIENTAS - DOCUMENTACION

### IDEs
- IntelliJ IDEA Documentation: https://www.jetbrains.com/help/idea/
- Eclipse IDE Guide: https://help.eclipse.org/latest/
- VS Code Java Extension Pack: https://code.visualstudio.com/docs/languages/java

### Build Tools
- Maven CLI Reference: https://maven.apache.org/ref/current/maven-embedder/cli.html
- Gradle Command Line: https://docs.gradle.org/current/userguide/command_line_interface.html

### Testing
- JUnit 5: https://junit.org/junit5/docs/current/user-guide/
- Mockito: https://javadoc.io/doc/org.mockito/mockito-core/latest/org/mockito/Mockito.html
- AssertJ: https://assertj.github.io/doc/
- Testcontainers: https://java.testcontainers.org/
- JMH: https://github.com/openjdk/jmh

### Profiling & Monitoring
- VisualVM Documentation: https://visualvm.github.io/documentation.html
- Async Profiler: https://github.com/async-profiler/async-profiler
- JDK Mission Control: https://docs.oracle.com/javacomponents/jmc.htm
- Micrometer: https://micrometer.io/docs
- Prometheus Java Client: https://prometheus.github.io/client_java/

### Containerization
- Jib (Containerize Java): https://github.com/GoogleContainerTools/jib
- Docker Java Best Practices: https://docs.docker.com/language/java/

---

## SPECS & RFCs

### Java Specifications
- Java Language Spec: https://docs.oracle.com/javase/specs/jls/se21/html/index.html
- JVM Spec: https://docs.oracle.com/javase/specs/jvms/se21/html/index.html
- JDBC Spec: https://download.oracle.com/otndocs/jcp/jdbc-4_3-mrel3-spec/

### Jakarta EE (ex Java EE)
- Jakarta EE Specifications: https://jakarta.ee/specifications/
- Jakarta Persistence (JPA): https://jakarta.ee/specifications/persistence/
- Jakarta RESTful Web Services: https://jakarta.ee/specifications/restful-ws/

---

## ORDEN DE LECTURA SUGERIDO

### Antes de Proyecto 1
- Oracle Tutorial - Language Basics
- Effective Java - Items 1-9, 15-25
- Head First Java - Capitulos 1-7

### Antes de Proyecto 2
- Oracle Tutorial - Collections, Exceptions, I/O
- Effective Java - Items 26-30, 69-77

### Antes de Proyecto 3
- Oracle Tutorial - Generics, Lambda, Streams
- Spring Boot Getting Started Guide
- JPA/Hibernate Basics

### Antes de Proyecto 4
- Modern Java in Action - Capitulos 1-10
- Spring Data JPA Reference
- Maven/Gradle Guides

### Antes de Proyecto 5
- Java Concurrency in Practice - Capitulos 1-7 (COMPLETO)
- GC Tuning Guide - Secciones 1-4
- JVM Specification - Capitulo 2

### Antes de Proyecto 6
- Java Concurrency in Practice - Capitulos 8-16
- Oracle Tutorial - NIO.2
- Package java.util.concurrent - Javadoc completo

### Antes de Proyecto 7
- Java Performance: The Definitive Guide - Capitulos 1-5
- Spring Cloud Reference
- Release It! - Capitulos 1-4

### Antes de Proyecto 8
- Designing Data-Intensive Applications - Capitulos 1-3, 5-7
- JEPs relevantes (Virtual Threads, Pattern Matching)
- Kubernetes & Docker best practices

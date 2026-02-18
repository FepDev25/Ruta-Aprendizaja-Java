# ROADMAP: JAVA

## MÓDULO 1: JVM Architecture & Runtime Internals
### Capítulo 1.1: Java Virtual Machine (JVM)
- **Topic 1.1.1**: JVM architecture - Class Loader, Runtime Data Areas, Execution Engine
- **Topic 1.1.2**: Class loading mechanism - Bootstrap, Extension, Application ClassLoaders
- **Topic 1.1.3**: Runtime Data Areas - Method Area, Heap, Stack, PC Register, Native Method Stack
- **Topic 1.1.4**: Execution Engine - Interpreter, JIT compiler, Garbage Collector
- **Topic 1.1.5**: JVM implementations - HotSpot, OpenJ9, GraalVM
- **Topic 1.1.6**: Bytecode structure - .class file format
- **Topic 1.1.7**: Verification process - Bytecode verification

### Capítulo 1.2: Just-In-Time (JIT) Compilation
- **Topic 1.2.1**: JIT compiler architecture - C1 (Client), C2 (Server)
- **Topic 1.2.2**: Tiered compilation - Interpreter → C1 → C2
- **Topic 1.2.3**: Method inlining - Performance optimization
- **Topic 1.2.4**: Escape analysis - Stack allocation optimization
- **Topic 1.2.5**: Loop optimization - Loop unrolling, invariant code motion
- **Topic 1.2.6**: Dead code elimination - Unreachable code removal
- **Topic 1.2.7**: Deoptimization - Fallback to interpreter

### Capítulo 1.3: Garbage Collection
- **Topic 1.3.1**: GC fundamentals - Mark and Sweep, Generational hypothesis
- **Topic 1.3.2**: Heap generations - Young (Eden, Survivor), Old, Metaspace
- **Topic 1.3.3**: Serial GC - Single-threaded collector
- **Topic 1.3.4**: Parallel GC - Throughput collector
- **Topic 1.3.5**: CMS (Concurrent Mark Sweep) - Low-latency collector
- **Topic 1.3.6**: G1 GC (Garbage First) - Region-based collector
- **Topic 1.3.7**: ZGC y Shenandoah - Ultra-low latency collectors
- **Topic 1.3.8**: GC tuning - JVM flags, heap sizing

### Capítulo 1.4: Memory Model
- **Topic 1.4.1**: Java Memory Model (JMM) - Happens-before relationship
- **Topic 1.4.2**: Memory visibility - volatile, synchronization
- **Topic 1.4.3**: Object layout - Header, fields, padding
- **Topic 1.4.4**: Stack vs Heap - Allocation strategies
- **Topic 1.4.5**: Memory leaks - Common patterns, detection
- **Topic 1.4.6**: Reference types - Strong, Soft, Weak, Phantom
- **Topic 1.4.7**: Metaspace - Class metadata storage

### Capítulo 1.5: ClassLoader & Reflection
- **Topic 1.5.1**: ClassLoader hierarchy - Parent delegation model
- **Topic 1.5.2**: Custom ClassLoaders - Dynamic class loading
- **Topic 1.5.3**: Class initialization - Static blocks, class loading order
- **Topic 1.5.4**: Reflection API - Class, Method, Field inspection
- **Topic 1.5.5**: Dynamic proxies - Proxy pattern implementation
- **Topic 1.5.6**: MethodHandles - Modern reflection alternative
- **Topic 1.5.7**: Performance implications - Reflection overhead

---

## MÓDULO 2: Fundamentos de Java
### Capítulo 2.1: Sintaxis Básica
- **Topic 2.1.1**: Programa Java básico - main method, estructura
- **Topic 2.1.2**: Tipos de datos primitivos - byte, short, int, long, float, double, char, boolean
- **Topic 2.1.3**: Variables - Declaración, inicialización, scope
- **Topic 2.1.4**: Operadores - Aritméticos, relacionales, lógicos, bitwise
- **Topic 2.1.5**: Literales - Numéricos, strings, caracteres
- **Topic 2.1.6**: Conversión de tipos - Casting implícito/explícito
- **Topic 2.1.7**: Autoboxing/Unboxing - Primitivos ↔ Wrappers

### Capítulo 2.2: Control Flow
- **Topic 2.2.1**: Condicionales - if/else, switch
- **Topic 2.2.2**: Switch expressions (Java 12+) - Enhanced switch
- **Topic 2.2.3**: Loops - for, while, do-while
- **Topic 2.2.4**: Enhanced for loop - for-each
- **Topic 2.2.5**: Break y continue - Loop control
- **Topic 2.2.6**: Labels - Named loops
- **Topic 2.2.7**: Return statement - Method exit

### Capítulo 2.3: Arrays
- **Topic 2.3.1**: Array declaration - Single/multi-dimensional
- **Topic 2.3.2**: Array initialization - Static, dynamic
- **Topic 2.3.3**: Array operations - Traversal, copying
- **Topic 2.3.4**: Arrays utility class - Sorting, searching, filling
- **Topic 2.3.5**: Varargs - Variable arguments
- **Topic 2.3.6**: Array limitations - Fixed size
- **Topic 2.3.7**: Jagged arrays - Arrays of arrays

### Capítulo 2.4: Strings
- **Topic 2.4.1**: String immutability - Inmutable objects
- **Topic 2.4.2**: String pool - Literal optimization
- **Topic 2.4.3**: String methods - length, charAt, substring, concat
- **Topic 2.4.4**: String comparison - equals vs ==
- **Topic 2.4.5**: StringBuilder y StringBuffer - Mutable strings
- **Topic 2.4.6**: String formatting - format, printf
- **Topic 2.4.7**: Text blocks (Java 15+) - Multi-line strings

### Capítulo 2.5: Métodos
- **Topic 2.5.1**: Method declaration - Signature, return type
- **Topic 2.5.2**: Method parameters - Pass-by-value
- **Topic 2.5.3**: Method overloading - Same name, different parameters
- **Topic 2.5.4**: Varargs methods - Variable arguments
- **Topic 2.5.5**: Recursive methods - Recursion patterns
- **Topic 2.5.6**: Static methods - Class-level methods
- **Topic 2.5.7**: Method references - :: operator

---

## MÓDULO 3: Programación Orientada a Objetos
### Capítulo 3.1: Clases y Objetos
- **Topic 3.1.1**: Class declaration - Fields, methods, constructors
- **Topic 3.1.2**: Object creation - new operator
- **Topic 3.1.3**: Constructors - Default, parameterized, overloading
- **Topic 3.1.4**: this keyword - Self-reference
- **Topic 3.1.5**: static keyword - Class variables/methods
- **Topic 3.1.6**: final keyword - Constants, immutability
- **Topic 3.1.7**: Nested classes - Inner, static nested

### Capítulo 3.2: Encapsulación
- **Topic 3.2.1**: Access modifiers - public, private, protected, default
- **Topic 3.2.2**: Getters y Setters - Property access
- **Topic 3.2.3**: JavaBeans conventions - Bean pattern
- **Topic 3.2.4**: Immutable objects - Defensive copying
- **Topic 3.2.5**: Encapsulation benefits - Data hiding
- **Topic 3.2.6**: Records (Java 14+) - Data carrier classes
- **Topic 3.2.7**: Sealed classes (Java 17+) - Restricted inheritance

### Capítulo 3.3: Herencia
- **Topic 3.3.1**: extends keyword - Class inheritance
- **Topic 3.3.2**: super keyword - Parent class access
- **Topic 3.3.3**: Method overriding - Runtime polymorphism
- **Topic 3.3.4**: @Override annotation - Compile-time checking
- **Topic 3.3.5**: final classes/methods - Preventing inheritance/override
- **Topic 3.3.6**: Object class - Root of hierarchy
- **Topic 3.3.7**: Composition vs Inheritance - Design choice

### Capítulo 3.4: Polimorfismo
- **Topic 3.4.1**: Compile-time polymorphism - Overloading
- **Topic 3.4.2**: Runtime polymorphism - Overriding
- **Topic 3.4.3**: Dynamic method dispatch - Virtual method invocation
- **Topic 3.4.4**: Upcasting y Downcasting - Type conversion
- **Topic 3.4.5**: instanceof operator - Type checking
- **Topic 3.4.6**: Pattern matching (Java 16+) - instanceof enhancement
- **Topic 3.4.7**: Covariant return types - Override with subtype

### Capítulo 3.5: Abstracción
- **Topic 3.5.1**: Abstract classes - Partial implementation
- **Topic 3.5.2**: Abstract methods - Contract definition
- **Topic 3.5.3**: Interfaces - Full abstraction
- **Topic 3.5.4**: Default methods (Java 8+) - Interface evolution
- **Topic 3.5.5**: Static methods in interfaces - Utility methods
- **Topic 3.5.6**: Private methods in interfaces (Java 9+) - Code reuse
- **Topic 3.5.7**: Functional interfaces - Single abstract method

---

## MÓDULO 4: Collections Framework
### Capítulo 4.1: Collection Hierarchy
- **Topic 4.1.1**: Collection interface - Root interface
- **Topic 4.1.2**: Iterable interface - for-each support
- **Topic 4.1.3**: Collection types - List, Set, Queue, Deque
- **Topic 4.1.4**: Map interface - Key-value pairs
- **Topic 4.1.5**: Collections utility class - Static methods
- **Topic 4.1.6**: Collection factory methods (Java 9+) - List.of, Set.of, Map.of
- **Topic 4.1.7**: Legacy collections - Vector, Stack, Hashtable

### Capítulo 4.2: List Interface
- **Topic 4.2.1**: ArrayList - Dynamic array
- **Topic 4.2.2**: LinkedList - Doubly-linked list
- **Topic 4.2.3**: Vector - Synchronized ArrayList
- **Topic 4.2.4**: List operations - add, remove, get, set
- **Topic 4.2.5**: List iteration - Iterator, ListIterator
- **Topic 4.2.6**: List sorting - Collections.sort, Comparator
- **Topic 4.2.7**: ArrayList vs LinkedList - Performance comparison

### Capítulo 4.3: Set Interface
- **Topic 4.3.1**: HashSet - Hash table implementation
- **Topic 4.3.2**: LinkedHashSet - Insertion-order preservation
- **Topic 4.3.3**: TreeSet - Sorted set (Red-Black tree)
- **Topic 4.3.4**: Set operations - add, remove, contains
- **Topic 4.3.5**: equals y hashCode - Set membership
- **Topic 4.3.6**: EnumSet - Enum-optimized set
- **Topic 4.3.7**: Set mathematical operations - Union, intersection, difference

### Capítulo 4.4: Map Interface
- **Topic 4.4.1**: HashMap - Hash table implementation
- **Topic 4.4.2**: LinkedHashMap - Insertion-order preservation
- **Topic 4.4.3**: TreeMap - Sorted map (Red-Black tree)
- **Topic 4.4.4**: Hashtable - Synchronized HashMap (legacy)
- **Topic 4.4.5**: Map operations - put, get, remove, containsKey
- **Topic 4.4.6**: Map iteration - keySet, values, entrySet
- **Topic 4.4.7**: ConcurrentHashMap - Thread-safe map

### Capítulo 4.5: Queue & Deque
- **Topic 4.5.1**: Queue interface - FIFO structure
- **Topic 4.5.2**: PriorityQueue - Heap-based priority queue
- **Topic 4.5.3**: Deque interface - Double-ended queue
- **Topic 4.5.4**: ArrayDeque - Resizable array deque
- **Topic 4.5.5**: LinkedList as Queue/Deque - Dual implementation
- **Topic 4.5.6**: Blocking queues - Thread-safe queues
- **Topic 4.5.7**: Queue operations - offer, poll, peek

---

## MÓDULO 5: Excepciones y Manejo de Errores
### Capítulo 5.1: Exception Hierarchy
- **Topic 5.1.1**: Throwable class - Root of exception hierarchy
- **Topic 5.1.2**: Exception vs Error - Recoverable vs unrecoverable
- **Topic 5.1.3**: Checked exceptions - Compile-time checking
- **Topic 5.1.4**: Unchecked exceptions - RuntimeException
- **Topic 5.1.5**: Common exceptions - NullPointerException, IllegalArgumentException
- **Topic 5.1.6**: Error types - OutOfMemoryError, StackOverflowError
- **Topic 5.1.7**: Exception best practices - When to use each

### Capítulo 5.2: Try-Catch-Finally
- **Topic 5.2.1**: try block - Protected code
- **Topic 5.2.2**: catch block - Exception handling
- **Topic 5.2.3**: finally block - Cleanup code
- **Topic 5.2.4**: Multiple catch blocks - Exception hierarchy
- **Topic 5.2.5**: Multi-catch (Java 7+) - Single catch for multiple types
- **Topic 5.2.6**: try-with-resources (Java 7+) - Automatic resource management
- **Topic 5.2.7**: Suppressed exceptions - AutoCloseable resources

### Capítulo 5.3: Throwing Exceptions
- **Topic 5.3.1**: throw statement - Explicit exception throwing
- **Topic 5.3.2**: throws clause - Method signature declaration
- **Topic 5.3.3**: Custom exceptions - Extending Exception
- **Topic 5.3.4**: Exception chaining - Caused by relationship
- **Topic 5.3.5**: Rethrowing exceptions - Preserving stack trace
- **Topic 5.3.6**: Exception translation - Abstraction layer
- **Topic 5.3.7**: Assertions - Design-time checks

### Capítulo 5.4: Error Handling Patterns
- **Topic 5.4.1**: Fail-fast principle - Early error detection
- **Topic 5.4.2**: Defensive programming - Input validation
- **Topic 5.4.3**: Exception logging - Stack trace logging
- **Topic 5.4.4**: Global exception handlers - Centralized handling
- **Topic 5.4.5**: Optional<T> - Avoiding null
- **Topic 5.4.6**: Try-success-failure pattern - Functional error handling
- **Topic 5.4.7**: Circuit breaker pattern - Failure resilience

### Capítulo 5.5: Best Practices
- **Topic 5.5.1**: Exception vs return codes - Modern approach
- **Topic 5.5.2**: Catch specific exceptions - Avoid catching Throwable
- **Topic 5.5.3**: Don't swallow exceptions - Proper handling
- **Topic 5.5.4**: Clean up resources - try-with-resources
- **Topic 5.5.5**: Document exceptions - Javadoc @throws
- **Topic 5.5.6**: Prefer unchecked exceptions - Less boilerplate
- **Topic 5.5.7**: Exception performance - Cost of exceptions

---

## MÓDULO 6: I/O y Serialización
### Capítulo 6.1: I/O Streams
- **Topic 6.1.1**: InputStream y OutputStream - Byte streams
- **Topic 6.1.2**: Reader y Writer - Character streams
- **Topic 6.1.3**: FileInputStream/FileOutputStream - File I/O
- **Topic 6.1.4**: BufferedInputStream/BufferedOutputStream - Buffering
- **Topic 6.1.5**: DataInputStream/DataOutputStream - Primitive types
- **Topic 6.1.6**: ObjectInputStream/ObjectOutputStream - Object serialization
- **Topic 6.1.7**: Stream decorators - Wrapper pattern

### Capítulo 6.2: File Operations
- **Topic 6.2.1**: File class - File/directory representation
- **Topic 6.2.2**: Path interface (NIO.2) - File path operations
- **Topic 6.2.3**: Files utility class - Static file operations
- **Topic 6.2.4**: File operations - Create, read, write, delete
- **Topic 6.2.5**: Directory operations - List, walk, traverse
- **Topic 6.2.6**: File attributes - Metadata reading/writing
- **Topic 6.2.7**: Watch Service - File system monitoring

### Capítulo 6.3: NIO (New I/O)
- **Topic 6.3.1**: Buffers - ByteBuffer, CharBuffer, etc.
- **Topic 6.3.2**: Channels - FileChannel, SocketChannel
- **Topic 6.3.3**: Selectors - Multiplexed I/O
- **Topic 6.3.4**: Non-blocking I/O - Asynchronous operations
- **Topic 6.3.5**: Memory-mapped files - Efficient large file access
- **Topic 6.3.6**: Direct buffers - Off-heap memory
- **Topic 6.3.7**: Scatter/Gather - Vectored I/O

### Capítulo 6.4: Serialización
- **Topic 6.4.1**: Serializable interface - Object serialization
- **Topic 6.4.2**: serialVersionUID - Version control
- **Topic 6.4.3**: transient keyword - Excluding fields
- **Topic 6.4.4**: Custom serialization - writeObject/readObject
- **Topic 6.4.5**: Externalizable interface - Full control
- **Topic 6.4.6**: Serialization security - Deserialization attacks
- **Topic 6.4.7**: Alternative serialization - JSON, XML, Protobuf

### Capítulo 6.5: Scanner & Formatter
- **Topic 6.5.1**: Scanner class - Parsing input
- **Topic 6.5.2**: Console class - Console I/O
- **Topic 6.5.3**: Formatter class - Formatted output
- **Topic 6.5.4**: PrintWriter - Formatted text output
- **Topic 6.5.5**: String tokenization - StringTokenizer
- **Topic 6.5.6**: Regular expressions - Pattern matching
- **Topic 6.5.7**: Resource bundles - Internationalization

---

## MÓDULO 7: Concurrency & Multithreading
### Capítulo 7.1: Thread Fundamentals
- **Topic 7.1.1**: Thread class - Thread creation
- **Topic 7.1.2**: Runnable interface - Task definition
- **Topic 7.1.3**: Thread lifecycle - New, Runnable, Blocked, Waiting, Terminated
- **Topic 7.1.4**: Thread methods - start, run, sleep, join
- **Topic 7.1.5**: Thread priority - Priority levels
- **Topic 7.1.6**: Daemon threads - Background threads
- **Topic 7.1.7**: Thread groups - Thread organization

### Capítulo 7.2: Synchronization
- **Topic 7.2.1**: synchronized keyword - Mutual exclusion
- **Topic 7.2.2**: Intrinsic locks - Monitor locks
- **Topic 7.2.3**: Synchronized methods - Method-level sync
- **Topic 7.2.4**: Synchronized blocks - Block-level sync
- **Topic 7.2.5**: volatile keyword - Memory visibility
- **Topic 7.2.6**: wait/notify/notifyAll - Inter-thread communication
- **Topic 7.2.7**: Deadlocks - Detection y prevention

### Capítulo 7.3: Concurrent Collections
- **Topic 7.3.1**: ConcurrentHashMap - Thread-safe map
- **Topic 7.3.2**: CopyOnWriteArrayList - Thread-safe list
- **Topic 7.3.3**: ConcurrentLinkedQueue - Non-blocking queue
- **Topic 7.3.4**: BlockingQueue - Producer-consumer pattern
- **Topic 7.3.5**: ArrayBlockingQueue - Bounded blocking queue
- **Topic 7.3.6**: LinkedBlockingQueue - Unbounded blocking queue
- **Topic 7.3.7**: PriorityBlockingQueue - Priority queue

### Capítulo 7.4: Executor Framework
- **Topic 7.4.1**: Executor interface - Task execution
- **Topic 7.4.2**: ExecutorService - Lifecycle management
- **Topic 7.4.3**: ThreadPoolExecutor - Configurable thread pool
- **Topic 7.4.4**: Executors factory - Pre-configured pools
- **Topic 7.4.5**: ScheduledExecutorService - Scheduled tasks
- **Topic 7.4.6**: Future<T> - Async computation result
- **Topic 7.4.7**: Callable<T> - Task with return value

### Capítulo 7.5: Advanced Concurrency
- **Topic 7.5.1**: Lock interface - Explicit locks
- **Topic 7.5.2**: ReentrantLock - Reentrant mutual exclusion
- **Topic 7.5.3**: ReadWriteLock - Read-write separation
- **Topic 7.5.4**: Condition - Advanced wait/notify
- **Topic 7.5.5**: Semaphore - Resource limiting
- **Topic 7.5.6**: CountDownLatch - Thread coordination
- **Topic 7.5.7**: CyclicBarrier - Synchronization point
- **Topic 7.5.8**: Phaser - Flexible barrier
- **Topic 7.5.9**: Atomic variables - Lock-free programming

---

## MÓDULO 8: Generics & Annotations
### Capítulo 8.1: Generics Fundamentals
- **Topic 8.1.1**: Generic classes - Type parameters
- **Topic 8.1.2**: Generic methods - Method-level generics
- **Topic 8.1.3**: Generic interfaces - Interface generics
- **Topic 8.1.4**: Type parameter naming - Conventions (T, E, K, V)
- **Topic 8.1.5**: Raw types - Legacy compatibility
- **Topic 8.1.6**: Type erasure - Runtime type information
- **Topic 8.1.7**: Generic array creation - Limitations

### Capítulo 8.2: Bounded Type Parameters
- **Topic 8.2.1**: Upper bounds - extends keyword
- **Topic 8.2.2**: Multiple bounds - Multiple constraints
- **Topic 8.2.3**: Lower bounds - super keyword (wildcards)
- **Topic 8.2.4**: Recursive type bounds - Self-referencing
- **Topic 8.2.5**: PECS principle - Producer Extends Consumer Super
- **Topic 8.2.6**: Unbounded wildcards - <?> usage
- **Topic 8.2.7**: Type parameter inference - Diamond operator

### Capítulo 8.3: Annotations
- **Topic 8.3.1**: Built-in annotations - @Override, @Deprecated, @SuppressWarnings
- **Topic 8.3.2**: Meta-annotations - @Retention, @Target, @Inherited
- **Topic 8.3.3**: Custom annotations - Defining annotations
- **Topic 8.3.4**: Annotation processing - Compile-time processing
- **Topic 8.3.5**: Reflection with annotations - Runtime access
- **Topic 8.3.6**: Annotation elements - Parameters
- **Topic 8.3.7**: Repeating annotations (Java 8+) - Multiple annotations

### Capítulo 8.4: Reflection API
- **Topic 8.4.1**: Class<T> object - Runtime type information
- **Topic 8.4.2**: Field reflection - Field access/modification
- **Topic 8.4.3**: Method reflection - Method invocation
- **Topic 8.4.4**: Constructor reflection - Object creation
- **Topic 8.4.5**: Modifier inspection - Access modifiers
- **Topic 8.4.6**: Array reflection - Dynamic array manipulation
- **Topic 8.4.7**: Reflection performance - Overhead considerations

### Capítulo 8.5: Advanced Reflection
- **Topic 8.5.1**: Dynamic proxies - Proxy pattern
- **Topic 8.5.2**: InvocationHandler - Proxy behavior
- **Topic 8.5.3**: MethodHandles - Modern reflection
- **Topic 8.5.4**: VarHandle (Java 9+) - Low-level variable access
- **Topic 8.5.5**: Unsafe API - Low-level operations
- **Topic 8.5.6**: Security implications - Reflection risks
- **Topic 8.5.7**: Reflection alternatives - Code generation

---

## MÓDULO 9: Streams API & Programación Funcional
### Capítulo 9.1: Lambda Expressions
- **Topic 9.1.1**: Lambda syntax - Arrow notation
- **Topic 9.1.2**: Functional interfaces - Single abstract method
- **Topic 9.1.3**: Built-in functional interfaces - Predicate, Function, Consumer, Supplier
- **Topic 9.1.4**: Method references - :: operator
- **Topic 9.1.5**: Constructor references - Class::new
- **Topic 9.1.6**: Closure - Variable capture
- **Topic 9.1.7**: Effectively final - Closure restrictions

### Capítulo 9.2: Stream Fundamentals
- **Topic 9.2.1**: Stream creation - Collection.stream(), Arrays.stream()
- **Topic 9.2.2**: Intermediate operations - map, filter, flatMap
- **Topic 9.2.3**: Terminal operations - collect, forEach, reduce
- **Topic 9.2.4**: Lazy evaluation - Deferred execution
- **Topic 9.2.5**: Stream pipeline - Chaining operations
- **Topic 9.2.6**: Short-circuiting operations - findFirst, anyMatch
- **Topic 9.2.7**: Parallel streams - parallelStream()

### Capítulo 9.3: Stream Operations
- **Topic 9.3.1**: Filtering - filter, distinct, limit, skip
- **Topic 9.3.2**: Mapping - map, mapToInt, flatMap
- **Topic 9.3.3**: Sorting - sorted, Comparator
- **Topic 9.3.4**: Matching - allMatch, anyMatch, noneMatch
- **Topic 9.3.5**: Finding - findFirst, findAny
- **Topic 9.3.6**: Reduction - reduce, collect
- **Topic 9.3.7**: Grouping - Collectors.groupingBy

### Capítulo 9.4: Collectors
- **Topic 9.4.1**: toList, toSet, toMap - Collection conversion
- **Topic 9.4.2**: joining - String concatenation
- **Topic 9.4.3**: groupingBy - Grouping elements
- **Topic 9.4.4**: partitioningBy - Boolean classification
- **Topic 9.4.5**: summarizing - Statistics collectors
- **Topic 9.4.6**: reducing - Custom reduction
- **Topic 9.4.7**: Custom collectors - Collector interface

### Capítulo 9.5: Optional<T>
- **Topic 9.5.1**: Optional creation - of, ofNullable, empty
- **Topic 9.5.2**: Optional methods - isPresent, get, orElse
- **Topic 9.5.3**: Optional chaining - map, flatMap, filter
- **Topic 9.5.4**: Optional terminal operations - ifPresent, orElseThrow
- **Topic 9.5.5**: Optional best practices - Avoiding get()
- **Topic 9.5.6**: OptionalInt/Long/Double - Primitive optionals
- **Topic 9.5.7**: Optional anti-patterns - Misuse cases

---

## MÓDULO 10: JDBC & Database Access
### Capítulo 10.1: JDBC Fundamentals
- **Topic 10.1.1**: JDBC architecture - Driver, Connection, Statement
- **Topic 10.1.2**: JDBC drivers - Type 1, 2, 3, 4
- **Topic 10.1.3**: DriverManager - Connection management
- **Topic 10.1.4**: Connection interface - Database connection
- **Topic 10.1.5**: Statement interface - SQL execution
- **Topic 10.1.6**: PreparedStatement - Parameterized queries
- **Topic 10.1.7**: CallableStatement - Stored procedures

### Capítulo 10.2: CRUD Operations
- **Topic 10.2.1**: Executing queries - SELECT statements
- **Topic 10.2.2**: ResultSet - Query results
- **Topic 10.2.3**: Inserting data - INSERT statements
- **Topic 10.2.4**: Updating data - UPDATE statements
- **Topic 10.2.5**: Deleting data - DELETE statements
- **Topic 10.2.6**: Batch updates - Batch processing
- **Topic 10.2.7**: Generated keys - Auto-increment retrieval

### Capítulo 10.3: Transactions
- **Topic 10.3.1**: Transaction management - commit, rollback
- **Topic 10.3.2**: Auto-commit mode - Default behavior
- **Topic 10.3.3**: Transaction isolation levels - Read committed, serializable
- **Topic 10.3.4**: Savepoints - Partial rollback
- **Topic 10.3.5**: Connection pooling - HikariCP, C3P0
- **Topic 10.3.6**: Distributed transactions - XA transactions
- **Topic 10.3.7**: Transaction best practices - Resource cleanup

### Capítulo 10.4: Advanced JDBC
- **Topic 10.4.1**: Metadata - DatabaseMetaData, ResultSetMetaData
- **Topic 10.4.2**: Scrollable ResultSets - Forward/backward navigation
- **Topic 10.4.3**: Updatable ResultSets - Direct updates
- **Topic 10.4.4**: RowSet - Disconnected rowsets
- **Topic 10.4.5**: BLOB/CLOB - Large objects
- **Topic 10.4.6**: Custom type mapping - SQL-Java mapping
- **Topic 10.4.7**: Connection validation - Health checks

### Capítulo 10.5: ORMs & JPA
- **Topic 10.5.1**: Hibernate - Leading ORM
- **Topic 10.5.2**: JPA (Jakarta Persistence API) - ORM standard
- **Topic 10.5.3**: Entity mapping - @Entity, @Table
- **Topic 10.5.4**: Relationships - @OneToMany, @ManyToMany
- **Topic 10.5.5**: JPQL - Object-oriented queries
- **Topic 10.5.6**: Criteria API - Type-safe queries
- **Topic 10.5.7**: Entity lifecycle - Managed, detached, transient

---

## MÓDULO 11: Ecosistema de Frameworks
### Capítulo 11.1: Web Frameworks
- **Topic 11.1.1**: Spring Framework - Ecosystem líder enterprise
- **Topic 11.1.2**: Jakarta EE (Java EE) - Enterprise standard
- **Topic 11.1.3**: Micronaut - Microservices-first framework
- **Topic 11.1.4**: Quarkus - Supersonic Subatomic Java
- **Topic 11.1.5**: Play Framework - Reactive web framework
- **Topic 11.1.6**: Vert.x - Event-driven toolkit
- **Topic 11.1.7**: Spark - Micro web framework

### Capítulo 11.2: ORM & Persistence Frameworks
- **Topic 11.2.1**: Hibernate - De-facto ORM standard
- **Topic 11.2.2**: JPA (Jakarta Persistence API) - Persistence specification
- **Topic 11.2.3**: MyBatis - SQL mapping framework
- **Topic 11.2.4**: jOOQ - Type-safe SQL
- **Topic 11.2.5**: EclipseLink - JPA reference implementation
- **Topic 11.2.6**: Exposed - Kotlin SQL framework
- **Topic 11.2.7**: Spring Data - Data access abstraction

### Capítulo 11.3: Microservices & Cloud
- **Topic 11.3.1**: Spring Cloud - Microservices patterns
- **Topic 11.3.2**: Helidon - Oracle's microservices framework
- **Topic 11.3.3**: Dropwizard - RESTful web services
- **Topic 11.3.4**: Axon Framework - Event sourcing/CQRS
- **Topic 11.3.5**: Apache Camel - Integration framework
- **Topic 11.3.6**: Resilience4j - Fault tolerance library
- **Topic 11.3.7**: Eureka, Consul - Service discovery

### Capítulo 11.4: Testing Frameworks
- **Topic 11.4.1**: JUnit - Unit testing standard
- **Topic 11.4.2**: TestNG - Advanced testing framework
- **Topic 11.4.3**: Mockito - Mocking framework
- **Topic 11.4.4**: AssertJ - Fluent assertions
- **Topic 11.4.5**: RestAssured - REST API testing
- **Topic 11.4.6**: Testcontainers - Integration testing
- **Topic 11.4.7**: Cucumber - BDD framework

### Capítulo 11.5: Utility & Supporting Libraries
- **Topic 11.5.1**: Lombok - Boilerplate reduction
- **Topic 11.5.2**: Guava - Google core libraries
- **Topic 11.5.3**: Apache Commons - Utility components
- **Topic 11.5.4**: SLF4J/Logback - Logging abstraction
- **Topic 11.5.5**: Jackson/Gson - JSON processing
- **Topic 11.5.6**: MapStruct - Bean mapping
- **Topic 11.5.7**: Caffeine - High-performance caching

---

## MÓDULO 12: Testing
### Capítulo 12.1: JUnit 5
- **Topic 12.1.1**: Test structure - @Test, assertions
- **Topic 12.1.2**: Lifecycle methods - @BeforeEach, @AfterEach
- **Topic 12.1.3**: Assertions - assertEquals, assertTrue, assertThrows
- **Topic 12.1.4**: Assumptions - Conditional test execution
- **Topic 12.1.5**: Parameterized tests - @ParameterizedTest
- **Topic 12.1.6**: Nested tests - @Nested
- **Topic 12.1.7**: Test instance lifecycle - @TestInstance

### Capítulo 12.2: Mockito
- **Topic 12.2.1**: Mock objects - @Mock annotation
- **Topic 12.2.2**: Stubbing - when().thenReturn()
- **Topic 12.2.3**: Verification - verify() methods
- **Topic 12.2.4**: Argument matchers - any(), eq()
- **Topic 12.2.5**: Spies - @Spy annotation
- **Topic 12.2.6**: Argument captors - @Captor
- **Topic 12.2.7**: MockitoExtension - JUnit 5 integration

### Capítulo 12.3: Integration Testing
- **Topic 12.3.1**: Integration test strategies - Component integration
- **Topic 12.3.2**: Database testing - In-memory vs real databases
- **Topic 12.3.3**: HTTP testing - REST API testing libraries
- **Topic 12.3.4**: Embedded databases - H2, HSQLDB, Derby
- **Topic 12.3.5**: Testcontainers - Docker-based testing
- **Topic 12.3.6**: Test fixtures - Data setup/teardown
- **Topic 12.3.7**: Test isolation - Transaction rollback patterns

### Capítulo 12.4: Test Coverage & Quality
- **Topic 12.4.1**: JaCoCo - Code coverage
- **Topic 12.4.2**: Coverage metrics - Line, branch, method
- **Topic 12.4.3**: Mutation testing - PIT
- **Topic 12.4.4**: Test-Driven Development (TDD) - Red-Green-Refactor
- **Topic 12.4.5**: Behavior-Driven Development (BDD) - Cucumber
- **Topic 12.4.6**: Property-based testing - jqwik
- **Topic 12.4.7**: Performance testing - JMH benchmarks

### Capítulo 12.5: Best Practices
- **Topic 12.5.1**: Test naming - Given-When-Then
- **Topic 12.5.2**: Test organization - AAA pattern
- **Topic 12.5.3**: Test independence - Isolated tests
- **Topic 12.5.4**: Test data builders - Builder pattern
- **Topic 12.5.5**: Avoiding test smells - Brittle tests
- **Topic 12.5.6**: CI/CD integration - Automated testing
- **Topic 12.5.7**: Test documentation - Living documentation

---

## MÓDULO 13: Build Tools & Maven/Gradle
### Capítulo 13.1: Maven
- **Topic 13.1.1**: POM (Project Object Model) - pom.xml
- **Topic 13.1.2**: Maven lifecycle - clean, compile, test, package
- **Topic 13.1.3**: Dependencies - Dependency management
- **Topic 13.1.4**: Repositories - Central, local, remote
- **Topic 13.1.5**: Plugins - Build customization
- **Topic 13.1.6**: Multi-module projects - Parent POM
- **Topic 13.1.7**: Profiles - Environment-specific builds

### Capítulo 13.2: Gradle
- **Topic 13.2.1**: build.gradle - Build script
- **Topic 13.2.2**: Gradle tasks - Task definition
- **Topic 13.2.3**: Dependency management - Configurations
- **Topic 13.2.4**: Gradle wrapper - Version consistency
- **Topic 13.2.5**: Kotlin DSL - build.gradle.kts
- **Topic 13.2.6**: Multi-project builds - Composite builds
- **Topic 13.2.7**: Build performance - Build cache, daemon

### Capítulo 13.3: Dependency Management
- **Topic 13.3.1**: Transitive dependencies - Dependency tree
- **Topic 13.3.2**: Dependency scopes - compile, test, runtime
- **Topic 13.3.3**: Dependency exclusions - Conflict resolution
- **Topic 13.3.4**: BOM (Bill of Materials) - Version management
- **Topic 13.3.5**: Dependency versions - Semantic versioning
- **Topic 13.3.6**: SNAPSHOT dependencies - Development versions
- **Topic 13.3.7**: Security auditing - Vulnerability scanning

### Capítulo 13.4: Packaging & Distribution
- **Topic 13.4.1**: JAR packaging - Library distribution
- **Topic 13.4.2**: WAR packaging - Web application
- **Topic 13.4.3**: Executable JARs - Fat JARs, uber JARs
- **Topic 13.4.4**: Shading - Dependency relocation
- **Topic 13.4.5**: Assembly - Custom packaging
- **Topic 13.4.6**: Docker images - Containerization
- **Topic 13.4.7**: Native images - GraalVM native compilation

### Capítulo 13.5: CI/CD Integration
- **Topic 13.5.1**: Jenkins - Continuous integration
- **Topic 13.5.2**: GitHub Actions - Workflow automation
- **Topic 13.5.3**: GitLab CI - Pipeline configuration
- **Topic 13.5.4**: Build automation - Automated builds
- **Topic 13.5.5**: Artifact deployment - Nexus, Artifactory
- **Topic 13.5.6**: Release management - Versioning, tagging
- **Topic 13.5.7**: Quality gates - SonarQube integration

---

## MÓDULO 14: Performance & JVM Tuning
### Capítulo 14.1: Performance Profiling
- **Topic 14.1.1**: VisualVM - Profiling tool
- **Topic 14.1.2**: JProfiler - Commercial profiler
- **Topic 14.1.3**: Async Profiler - Low-overhead profiling
- **Topic 14.1.4**: Flame graphs - Performance visualization
- **Topic 14.1.5**: CPU profiling - Hotspot identification
- **Topic 14.1.6**: Memory profiling - Heap analysis
- **Topic 14.1.7**: Thread profiling - Concurrency analysis

### Capítulo 14.2: JVM Tuning
- **Topic 14.2.1**: Heap sizing - Xmx, Xms flags
- **Topic 14.2.2**: GC selection - Choosing collector
- **Topic 14.2.3**: GC tuning - Pause time vs throughput
- **Topic 14.2.4**: Metaspace tuning - Class metadata
- **Topic 14.2.5**: Thread stack size - Xss flag
- **Topic 14.2.6**: JIT compilation - Compiler flags
- **Topic 14.2.7**: Flight Recorder - Production profiling

### Capítulo 14.3: Memory Optimization
- **Topic 14.3.1**: Memory leak detection - Heap dumps
- **Topic 14.3.2**: Object pooling - Reusing objects
- **Topic 14.3.3**: String interning - String pool optimization
- **Topic 14.3.4**: Lazy initialization - On-demand loading
- **Topic 14.3.5**: Weak/Soft references - Cache implementation
- **Topic 14.3.6**: Off-heap memory - DirectByteBuffer
- **Topic 14.3.7**: Memory footprint - Object size reduction

### Capítulo 14.4: Code Optimization
- **Topic 14.4.1**: Algorithmic complexity - Big O notation
- **Topic 14.4.2**: Data structure selection - Performance trade-offs
- **Topic 14.4.3**: StringBuilder optimization - String concatenation
- **Topic 14.4.4**: Collection optimization - Right collection choice
- **Topic 14.4.5**: Stream optimization - Parallel streams, primitive streams
- **Topic 14.4.6**: Reflection avoidance - MethodHandles alternative
- **Topic 14.4.7**: Microbenchmarking - JMH framework

### Capítulo 14.5: Monitoring & Observability
- **Topic 14.5.1**: JMX (Java Management Extensions) - Monitoring
- **Topic 14.5.2**: Metrics collection - Micrometer
- **Topic 14.5.3**: Distributed tracing - OpenTelemetry
- **Topic 14.5.4**: Logging frameworks - SLF4J, Logback, Log4j2
- **Topic 14.5.5**: APM tools - New Relic, Datadog, Dynatrace
- **Topic 14.5.6**: Health checks - Application health
- **Topic 14.5.7**: Alerting - Prometheus, Grafana

---

## MÓDULO 15: Modern Java Features (Java 8+)
### Capítulo 15.1: Java 8 Features
- **Topic 15.1.1**: Lambda expressions - Functional programming
- **Topic 15.1.2**: Stream API - Declarative collections
- **Topic 15.1.3**: Optional<T> - Null safety
- **Topic 15.1.4**: Default methods - Interface evolution
- **Topic 15.1.5**: Method references - :: operator
- **Topic 15.1.6**: Date/Time API - java.time package
- **Topic 15.1.7**: CompletableFuture - Async programming

### Capítulo 15.2: Java 9-11 Features
- **Topic 15.2.1**: Module system (Java 9) - JPMS
- **Topic 15.2.2**: JShell (Java 9) - REPL
- **Topic 15.2.3**: var keyword (Java 10) - Type inference
- **Topic 15.2.4**: HTTP Client (Java 11) - Modern HTTP API
- **Topic 15.2.5**: Collection factory methods (Java 9) - List.of, Set.of
- **Topic 15.2.6**: Private interface methods (Java 9) - Code reuse
- **Topic 15.2.7**: String methods (Java 11) - isBlank, lines, strip

### Capítulo 15.3: Java 12-17 Features
- **Topic 15.3.1**: Switch expressions (Java 12-14) - Enhanced switch
- **Topic 15.3.2**: Text blocks (Java 15) - Multi-line strings
- **Topic 15.3.3**: Records (Java 16) - Data carriers
- **Topic 15.3.4**: Pattern matching (Java 16+) - instanceof enhancement
- **Topic 15.3.5**: Sealed classes (Java 17) - Restricted inheritance
- **Topic 15.3.6**: Stream enhancements - toList() (Java 16)
- **Topic 15.3.7**: NullPointerException messages - Helpful NPEs

### Capítulo 15.4: Java 18-21 Features
- **Topic 15.4.1**: Pattern matching for switch (Java 21) - Advanced patterns
- **Topic 15.4.2**: Virtual Threads (Java 21) - Lightweight concurrency
- **Topic 15.4.3**: Sequenced collections (Java 21) - Ordered collections
- **Topic 15.4.4**: String templates (Preview) - Interpolation
- **Topic 15.4.5**: Unnamed patterns (Java 21) - _ placeholder
- **Topic 15.4.6**: Foreign Function & Memory API - Native interop
- **Topic 15.4.7**: Vector API - SIMD operations

### Capítulo 15.5: Migration Strategies
- **Topic 15.5.1**: Version migration planning - Incremental upgrade
- **Topic 15.5.2**: Compatibility testing - Breaking changes
- **Topic 15.5.3**: Module adoption - Migrating to modules
- **Topic 15.5.4**: Legacy code modernization - Refactoring strategies
- **Topic 15.5.5**: JDK tooling updates - New tools, deprecated features
- **Topic 15.5.6**: Performance improvements - Newer JDK benefits
- **Topic 15.5.7**: LTS versions - Java 8, 11, 17, 21

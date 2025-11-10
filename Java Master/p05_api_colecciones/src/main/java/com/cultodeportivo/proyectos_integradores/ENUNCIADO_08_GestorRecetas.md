# Proyecto 08 - Gestor de Recetas y Planificador de Menús

## Descripción General

Desarrollar un sistema completo de gestión culinaria que permita administrar recetas, ingredientes, planificar menús semanales, generar listas de compras automáticas, gestionar inventario de despensa y proporcionar recomendaciones nutricionales. El sistema debe calcular información nutricional, costos y sugerir recetas basadas en ingredientes disponibles.

**Dificultad:** ⭐⭐⭐  
**Tiempo estimado:** 8-10 horas  
**Conceptos clave:** Set para ingredientes, Map para recetas, List de compras, algoritmos de planificación

---

## Objetivos de Aprendizaje

- Usar **Map&lt;Ingrediente, Cantidad&gt;** para ingredientes de recetas
- Aplicar **Set operations** para verificar disponibilidad de ingredientes
- Implementar **List ordenada** para planificación semanal
- Utilizar **LinkedHashSet** para listas de compras sin duplicados
- Crear **Map para inventario** con tracking de cantidades
- Usar **TreeMap** para recetas ordenadas por categoría
- Aplicar **filtros complejos** basados en múltiples criterios

---

## Estructura de Clases

### 1. Enum `CategoriaReceta`

**Valores:**

- DESAYUNO, ALMUERZO, CENA, POSTRE, ENTRADA, SNACK, BEBIDA, ENSALADA, SOPA

### 2. Enum `TipoCocina`

**Valores:**

- MEXICANA, ITALIANA, CHINA, JAPONESA, INDIA, FRANCESA, MEDITERRANEA, AMERICANA, VEGETARIANA, VEGANA

### 3. Enum `NivelDificultad`

**Valores:**

- MUY_FACIL, FACIL, INTERMEDIO, DIFICIL, EXPERTO

### 4. Enum `UnidadMedida`

**Valores:**

- GRAMOS, KILOGRAMOS, MILILITROS, LITROS, TAZAS, CUCHARADAS, CUCHARADITAS, UNIDADES, PIZCA, AL_GUSTO

### 5. Clase `Ingrediente`

Representa un ingrediente individual.

**Atributos:**

- id: String (único, formato "ING-001")
- nombre: String
- categoria: String (Vegetales, Carnes, Lácteos, Granos, Especias, etc.)
- calorias: double (por 100g o 100ml)
- proteinas: double
- carbohidratos: double
- grasas: double
- precioPromedio: double (por unidad base)
- esAlergeno: boolean
- esVegetariano: boolean
- esVegano: boolean

**Métodos importantes:**

- calcularCalorias(double cantidad, UnidadMedida)
- calcularPrecio(double cantidad, UnidadMedida)
- equals() y hashCode() basados en id
- toString()

### 6. Clase `CantidadIngrediente`

Representa una cantidad específica de un ingrediente.

**Atributos:**

- ingrediente: Ingrediente
- cantidad: double
- unidad: UnidadMedida
- opcional: boolean

**Métodos importantes:**

- calcularCalorias()
- calcularPrecio()
- convertirA(UnidadMedida) conversión entre unidades
- toString() ej: "250g de Harina"

### 7. Clase `Receta`

Representa una receta completa.

**Atributos:**

- id: String (único, formato "REC-001")
- nombre: String
- descripcion: String
- categoria: CategoriaReceta
- tipoCocina: TipoCocina
- dificultad: NivelDificultad
- tiempoPreparacion: int (minutos)
- tiempoCoccion: int (minutos)
- porciones: int
- ingredientes: Map&lt;Ingrediente, CantidadIngrediente&gt;
- pasos: List&lt;String&gt; (instrucciones ordenadas)
- etiquetas: Set&lt;String&gt; (sin gluten, bajo en calorías, rápida, etc.)
- valoracion: double (1-5 estrellas)
- vecesPreparada: int
- fechaCreacion: LocalDate

**Métodos importantes:**

- agregarIngrediente(CantidadIngrediente)
- agregarPaso(String)
- calcularCaloriasTotales()
- calcularCaloriasPorPorcion()
- calcularCostoTotal()
- calcularCostoPorPorcion()
- getTiempoTotal()
- contieneIngrediente(Ingrediente)
- esAptaPara(String restriccion) vegetariana, vegana, sin gluten
- ajustarPorciones(int nuevasPorciones) recalcula cantidades
- toString()

### 8. Clase `MenuDiario`

Representa el menú de un día específico.

**Atributos:**

- fecha: LocalDate
- desayuno: Receta
- almuerzo: Receta
- cena: Receta
- snacks: List&lt;Receta&gt;
- caloriasObjetivo: int
- observaciones: String

**Métodos importantes:**

- agregarReceta(CategoriaReceta, Receta)
- calcularCaloriasTotales()
- calcularCostoTotal()
- getTodasLasRecetas()
- cumpleObjetivoCalorias() verifica si está dentro del rango
- toString()

### 9. Clase `PlanSemanal`

Planificación de menú para una semana.

**Atributos:**

- fechaInicio: LocalDate
- menusPorDia: LinkedHashMap&lt;LocalDate, MenuDiario&gt; (orden cronológico)
- personasACocinar: int

**Métodos importantes:**

- agregarMenuDia(LocalDate, MenuDiario)
- getMenuDia(LocalDate)
- getMenuDia(DayOfWeek)
- calcularIngredientesTotales() retorna Map&lt;Ingrediente, CantidadIngrediente&gt;
- generarListaCompras()
- calcularCostoSemanal()
- calcularPromedioCalorias()
- getRecetasMasUsadas()
- toString() vista semanal

### 10. Clase `ListaCompras`

Lista de compras generada automáticamente.

**Atributos:**

- fecha: LocalDate
- items: LinkedHashMap&lt;Ingrediente, CantidadIngrediente&gt; (orden de supermercado)
- itemsComprados: Set&lt;Ingrediente&gt;
- costoTotal: double
- completada: boolean

**Métodos importantes:**

- agregarItem(CantidadIngrediente)
- marcarComoComprado(Ingrediente)
- consolidarCantidades() suma cantidades del mismo ingrediente
- ordenarPorCategoria()
- calcularTotal()
- getItemsPendientes()
- toString() formato lista de compras

### 11. Clase `Despensa`

Inventario de ingredientes disponibles.

**Atributos:**

- inventario: Map&lt;Ingrediente, CantidadIngrediente&gt;
- fechasVencimiento: Map&lt;Ingrediente, LocalDate&gt;

**Métodos importantes:**

- agregarIngrediente(CantidadIngrediente, LocalDate vencimiento)
- consumirIngrediente(Ingrediente, double cantidad)
- tieneDisponible(Ingrediente, double cantidad)
- getIngredientesDisponibles()
- getIngredientesPorVencer(int dias) próximos a vencer
- getIngredientesVencidos()
- puedeHacerReceta(Receta) verifica disponibilidad
- getIngredientesFaltantes(Receta)
- actualizarDespensaDespuesDeCompra(ListaCompras)

### 12. Clase `RecetarioPersonal`

Colección de recetas del usuario.

**Atributos:**

- recetas: Map&lt;String, Receta&gt; (id → receta)
- recetasPorCategoria: Map&lt;CategoriaReceta, Set&lt;Receta&gt;&gt;
- recetasPorTipoCocina: Map&lt;TipoCocina, Set&lt;Receta&gt;&gt;
- recetasFavoritas: Set&lt;Receta&gt;
- recetasRecientes: List&lt;Receta&gt; (últimas preparadas)

**Métodos importantes:**

- agregarReceta(Receta)
- buscarPorNombre(String) búsqueda parcial
- buscarPorCategoria(CategoriaReceta)
- buscarPorTipoCocina(TipoCocina)
- buscarPorIngrediente(Ingrediente)
- buscarPorTiempoMaximo(int minutos)
- buscarPorDificultad(NivelDificultad)
- buscarPorEtiqueta(String)
- filtrarPorIngredientesDisponibles(Despensa)
- getRecetasMasPreparadas(int top)
- getRecetasMejorValoradas(int top)
- marcarComoFavorita(Receta)
- registrarPreparacion(Receta) actualiza contador y recientes

### 13. Clase `PlanificadorMenus`

Genera planificaciones automáticas.

**Atributos:**

- recetario: RecetarioPersonal
- despensa: Despensa
- restriccionesDieteticas: Set&lt;String&gt;

**Métodos importantes:**

- generarPlanSemanal(int calorias Objetivo)
- generarPlanBalanceado() variedad de categorías y cocinas
- generarPlanConIngredientesDisponibles() maximiza uso de despensa
- generarPlanEconomico() minimiza costo
- generarPlanRapido() recetas de menos de 30 min
- sugerirRecetaPara(CategoriaReceta, int calorías) con restricciones
- balancearNutrientes(MenuDiario)
- evitarRepeticiones(PlanSemanal, int diasSinRepetir)

### 14. Clase `CalculadoraNutricional`

Calcula información nutricional.

**Atributos:**

- receta: Receta

**Métodos importantes:**

- calcularMacronutrientes() retorna Map&lt;String, Double&gt; (proteínas, carbos, grasas)
- calcularDistribucionCalorica() % de cada macronutriente
- esBalanceada() verifica proporciones saludables
- calcularIndiceSaludable() score basado en ingredientes y nutrientes
- generarEtiquetaNutricional() String con tabla nutricional

---

## Funcionalidades Requeridas

### Gestión de Recetas

1. Crear recetas con ingredientes y pasos
2. Editar recetas existentes
3. Ajustar cantidades por número de porciones
4. Buscar recetas por múltiples criterios
5. Valorar recetas (estrellas)
6. Marcar recetas como favoritas
7. Registrar cuántas veces se preparó

### Gestión de Ingredientes

1. Registrar ingredientes con información nutricional
2. Categorizar ingredientes
3. Establecer precios promedio
4. Marcar ingredientes como alérgenos
5. Identificar ingredientes vegetarianos/veganos

### Planificación de Menús

1. Crear plan semanal manual
2. Generar plan semanal automático balanceado
3. Planificar basándose en ingredientes disponibles
4. Planificar con restricciones dietéticas
5. Ajustar plan por número de personas
6. Calcular calorías totales del plan

### Lista de Compras

1. Generar lista automáticamente desde plan semanal
2. Consolidar cantidades del mismo ingrediente
3. Ordenar por categoría (sección del supermercado)
4. Marcar items como comprados
5. Calcular costo total estimado
6. Exportar lista

### Gestión de Despensa

1. Registrar ingredientes disponibles con cantidad
2. Establecer fechas de vencimiento
3. Consumir ingredientes al preparar receta
4. Alertar sobre ingredientes por vencer
5. Identificar ingredientes vencidos
6. Verificar si se puede hacer receta con lo disponible
7. Mostrar ingredientes faltantes para receta

### Cálculos y Estadísticas

1. Calcular información nutricional por receta
2. Calcular costo por receta y por porción
3. Estadísticas de recetas más preparadas
4. Distribución de categorías de recetas
5. Análisis de gasto en comida semanal/mensual
6. Seguimiento de calorías consumidas

### Recomendaciones

1. Sugerir recetas con ingredientes próximos a vencer
2. Recomendar recetas con ingredientes disponibles
3. Sugerir recetas balanceadas nutricionalmente
4. Recomendar recetas económicas
5. Sugerir recetas rápidas para días ocupados

---

## Reglas de Negocio

1. **Porciones**: Al ajustar porciones, todas las cantidades se multiplican proporcionalmente
2. **Calorías**: Se calculan sumando (cantidad × calorías del ingrediente)
3. **Costo**: Se calcula sumando (cantidad × precio del ingrediente)
4. **Tiempo Total**: tiempo de preparación + tiempo de cocción
5. **Lista de Compras**: Consolidar cantidades del mismo ingrediente
6. **Despensa**: No se puede consumir más de lo disponible
7. **Vencimiento**: Ingredientes vencidos no se consideran disponibles
8. **Receta Vegetariana**: Todos los ingredientes deben ser vegetarianos
9. **Receta Vegana**: Todos los ingredientes deben ser veganos
10. **Balanceado**: 40-60% carbohidratos, 20-30% proteínas, 20-30% grasas

---

## Casos de Prueba

### Prueba 1: Creación de Recetas Completas

1. Crear 15 recetas de diferentes categorías
2. Agregar ingredientes con cantidades
3. Agregar pasos de preparación
4. Calcular información nutricional
5. Verificar cálculo de costos

### Prueba 2: Planificación Semanal

1. Crear plan semanal manualmente
2. Asignar recetas a cada día
3. Calcular ingredientes totales necesarios
4. Generar lista de compras consolidada
5. Verificar cálculo de costo semanal

### Prueba 3: Gestión de Despensa

1. Registrar 20 ingredientes en despensa
2. Marcar fechas de vencimiento
3. Verificar disponibilidad para hacer receta
4. Consumir ingredientes al preparar
5. Alertar sobre ingredientes por vencer

### Prueba 4: Búsquedas y Filtros

1. Buscar recetas por categoría
2. Buscar por ingrediente específico
3. Filtrar por tiempo máximo de preparación
4. Filtrar por restricciones dietéticas
5. Buscar recetas con ingredientes disponibles

### Prueba 5: Planificación Automática

1. Generar plan semanal balanceado
2. Verificar variedad de categorías y cocinas
3. Validar balance nutricional
4. Comprobar no repetición de recetas
5. Ajustar por número de personas

---

## Interfaz de Usuario (Menú Interactivo)

```bash
=== GESTOR DE RECETAS Y PLANIFICADOR DE MENÚS ===

1. Gestión de Recetas
   1.1. Crear nueva receta
   1.2. Editar receta
   1.3. Ver receta detallada
   1.4. Valorar receta
   1.5. Marcar como favorita
   1.6. Ajustar porciones

2. Búsqueda de Recetas
   2.1. Buscar por nombre
   2.2. Buscar por categoría
   2.3. Buscar por tipo de cocina
   2.4. Buscar por ingrediente
   2.5. Buscar por tiempo
   2.6. Buscar por dificultad
   2.7. Recetas con ingredientes disponibles

3. Planificación de Menús
   3.1. Crear plan semanal manual
   3.2. Generar plan automático balanceado
   3.3. Generar plan con ingredientes disponibles
   3.4. Generar plan económico
   3.5. Generar plan rápido
   3.6. Ver plan actual
   3.7. Modificar día del plan

4. Lista de Compras
   4.1. Generar desde plan semanal
   4.2. Ver lista de compras
   4.3. Marcar items como comprados
   4.4. Calcular costo total
   4.5. Exportar lista

5. Gestión de Despensa
   5.1. Agregar ingrediente a despensa
   5.2. Ver inventario de despensa
   5.3. Consumir ingrediente
   5.4. Ingredientes por vencer
   5.5. Ingredientes vencidos
   5.6. Verificar disponibilidad para receta

6. Información Nutricional
   6.1. Ver info nutricional de receta
   6.2. Calcular calorías del día
   6.3. Análisis nutricional semanal
   6.4. Verificar balance de macros

7. Estadísticas
   7.1. Recetas más preparadas
   7.2. Recetas mejor valoradas
   7.3. Gasto semanal/mensual
   7.4. Distribución por categorías
   7.5. Análisis de despensa

8. Recomendaciones
   8.1. Recetas con ingredientes por vencer
   8.2. Recetas con ingredientes disponibles
   8.3. Recetas balanceadas
   8.4. Recetas económicas
   8.5. Recetas rápidas

0. Salir
```

---

## Desafíos Opcionales

### Nivel Avanzado

1. **Conversión de Unidades**: Automática entre sistema métrico e imperial
2. **Escalado Inteligente**: Ajustar tiempos de cocción al cambiar porciones
3. **Sustituciones**: Sugerir ingredientes alternativos
4. **Análisis de Macros**: Tracking diario de macronutrientes
5. **Integración con API**: Buscar recetas en línea (Spoonacular, TheMealDB)
6. **Generación de Imágenes**: Representación visual del plato

### Mejoras Técnicas

1. Usar EnumMap para recetas por categoría
2. Implementar conversión automática entre UnidadMedida
3. Usar TreeSet con Comparator para rankings de recetas
4. Implementar caché de cálculos nutricionales
5. Usar computeIfAbsent() para listas de compras consolidadas
6. Optimizar búsquedas con índices secundarios

---

## Ejemplo de Salida

```bash
=== MI RECETARIO PERSONAL ===
Total de recetas: 87
Recetas favoritas: 12
Recetas preparadas este mes: 24

--- PLAN SEMANAL (15-21 Noviembre 2025) ---
Personas: 4 | Objetivo: 2000 cal/persona/día

LUNES 15/11:
  🌅 Desayuno: Avena con frutas y miel (320 cal)
  🍽️ Almuerzo: Pollo al curry con arroz (680 cal)
  🌙 Cena: Ensalada César con salmón (550 cal)
  Snacks: Yogurt griego (150 cal)
  Total: 1,700 cal | Costo: $12.50/persona

MARTES 16/11:
  🌅 Desayuno: Huevos revueltos con aguacate (420 cal)
  🍽️ Almuerzo: Pasta a la bolognesa (750 cal)
  🌙 Cena: Tacos de pescado (580 cal)
  Snacks: Frutos secos (200 cal)
  Total: 1,950 cal | Costo: $10.80/persona

[... resto de la semana ...]

RESUMEN SEMANAL:
- Promedio calorías/día: 1,890 cal ✓
- Costo total: $312.60 ($ 11.17/persona/día)
- Balance nutricional: 45% carbos, 25% proteínas, 30% grasas ✓

--- LISTA DE COMPRAS CONSOLIDADA ---

📦 VEGETALES Y FRUTAS:
  ✓ Tomates - 2 kg ($4.50)
  ☐ Cebollas - 1 kg ($2.00)
  ☐ Aguacates - 6 unidades ($12.00)
  ☐ Lechuga - 3 unidades ($4.50)
  ☐ Plátanos - 2 kg ($3.00)
  ☐ Manzanas - 1.5 kg ($4.00)

🥩 CARNES Y PESCADOS:
  ☐ Pollo pechuga - 2 kg ($18.00)
  ☐ Salmón - 800g ($24.00)
  ☐ Carne molida - 1 kg ($12.00)
  ☐ Pescado blanco - 1 kg ($15.00)

🥛 LÁCTEOS:
  ☐ Leche - 4 litros ($8.00)
  ☐ Queso mozzarella - 500g ($6.00)
  ☐ Yogurt natural - 2 kg ($10.00)
  ☐ Mantequilla - 250g ($4.00)

🌾 GRANOS Y PASTAS:
  ☐ Arroz blanco - 2 kg ($5.00)
  ☐ Pasta - 1 kg ($3.50)
  ☐ Avena - 1 kg ($4.00)
  ☐ Lentejas - 500g ($2.50)

Items comprados: 1/32
Costo estimado: $312.60

--- ALERTA DE DESPENSA ---
⚠️ Ingredientes por vencer (próximos 3 días):
  - Crema de leche (vence: 16/11) - 200ml disponibles
  - Espinacas frescas (vence: 17/11) - 150g disponibles
  
💡 Sugerencia: Preparar "Crema de espinacas" hoy para aprovecharlos

🔴 Ingredientes vencidos:
  - Yogurt de fresa (venció: 10/11) - ¡Descartar!

--- RECETA DEL DÍA: POLLO AL CURRY ---
Categoría: Almuerzo | Cocina: India
Dificultad: ⭐⭐ Intermedio
Tiempo: 45 min (15 prep + 30 cocción)
Porciones: 4 | Valoración: ⭐⭐⭐⭐⭐ 4.8
Veces preparada: 8 veces

INGREDIENTES:
  ✓ 500g Pechuga de pollo (Disponible)
  ✓ 2 Cebollas medianas (Disponible)
  ✗ 400ml Leche de coco (FALTA - Agregar a lista)
  ✓ 3 cdas Curry en polvo (Disponible)
  ✓ 2 dientes Ajo (Disponible)
  ✓ Al gusto Sal y pimienta (Disponible)

INFORMACIÓN NUTRICIONAL (por porción):
  Calorías: 420 kcal
  Proteínas: 35g (33%)
  Carbohidratos: 18g (17%)
  Grasas: 23g (50%)
  
  Balance: ⚠️ Alto en grasas (recomendado 20-30%)

COSTO:
  Total: $15.60
  Por porción: $3.90

PASOS:
  1. Cortar el pollo en cubos medianos
  2. Picar finamente la cebolla y el ajo
  3. Saltear la cebolla y el ajo en aceite
  4. Agregar el pollo y dorar
  5. [... más pasos ...]

--- RECOMENDACIONES PERSONALIZADAS ---

🎯 Para ti (basado en tus gustos):
1. Risotto de champiñones ⭐ 4.7
   Razón: Te encantan las recetas italianas
   Ingredientes: 8/10 disponibles
   Tiempo: 40 min

2. Pad Thai de camarones ⭐ 4.6
   Razón: Similar a tu receta favorita
   Ingredientes: 12/15 disponibles
   Tiempo: 35 min

💰 Económicas (menos de $5/porción):
1. Lentejas con verduras - $2.30/porción
2. Pasta al pesto - $3.80/porción

⚡ Rápidas (menos de 30 min):
1. Quesadillas de pollo - 15 min
2. Ensalada de atún - 10 min
```

---

## 🎓 Conceptos Clave a Aplicar

1. **Map para Ingredientes**: Map&lt;Ingrediente, CantidadIngrediente&gt; en recetas
2. **Set Operations**: Verificar disponibilidad con intersección de Sets
3. **LinkedHashMap**: Mantener orden en planes semanales y listas de compras
4. **TreeMap**: Recetas ordenadas por categoría o valoración
5. **List Ordenada**: Pasos de recetas y menús diarios
6. **LinkedHashSet**: Lista de compras sin duplicados pero ordenada
7. **computeIfAbsent()**: Consolidar cantidades en lista de compras
8. **EnumMap**: Eficiente para recetas por categoría

---

## Notas Técnicas

- **Consolidación**: Al generar lista de compras, sumar cantidades del mismo ingrediente
- **Conversión de Unidades**: Implementar conversiones básicas (tazas ↔ ml, kg ↔ libras)
- **Cálculos Nutricionales**: (cantidad × nutriente del ingrediente) / 100
- **Balance de Macros**: (calorías del macro × 4 o 9) / calorías totales × 100
- **Disponibilidad**: Usar containsAll() o intersección de Sets
- **Ordenamiento**: TreeSet con Comparator para rankings automáticos
- **Performance**: Cachear cálculos nutricionales costosos

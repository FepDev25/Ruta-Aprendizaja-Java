# PROYECTO 02: Agenda de Contactos 📞

## Dificultad: ⭐⭐

## Descripción General

Crea una agenda digital que gestione contactos usando arrays. Practica ordenamiento alfabético, búsqueda de strings y manipulación de datos personales.

## Objetivos de Aprendizaje

- Arrays de Strings
- Ordenamiento alfabético
- Búsqueda de texto parcial
- Comparación de strings (compareTo)
- Validación de formatos (email, teléfono)

## Estructura de Datos

```java
final int MAX_CONTACTOS = 200;

String[] nombres = new String[MAX_CONTACTOS];
String[] apellidos = new String[MAX_CONTACTOS];
String[] telefonos = new String[MAX_CONTACTOS];
String[] emails = new String[MAX_CONTACTOS];
String[] direcciones = new String[MAX_CONTACTOS];
String[] categorias = new String[MAX_CONTACTOS]; // Familia, Trabajo, Amigos

int totalContactos = 0;
```

## Funcionalidades Principales

### 1. Agregar Contacto

- Validar email y teléfono
- No duplicar nombres+apellidos
- Asignar categoría
- Inserción ordenada alfabéticamente

### 2. Buscar Contacto

**Opciones:**

- Por nombre (parcial)
- Por apellido (parcial)
- Por teléfono
- Por email
- Por categoría

### 3. Listar Contactos

**Modos:**

- Todos (ordenados alfabéticamente)
- Por categoría
- Por inicial (A-Z)
- Favoritos (con marcador especial)

### 4. Editar Contacto

- Buscar por nombre completo
- Modificar cualquier campo
- Reordenar si cambia nombre

### 5. Eliminar Contacto

- Buscar y confirmar
- Desplazar array
- Decrementar contador

### 6. Estadísticas

- Total de contactos
- Contactos por categoría
- Inicial más común
- Dominio de email más usado

### 7. Exportar Contactos

Generar archivo de texto con formato:

```bash
NOMBRE | APELLIDO | TELÉFONO | EMAIL | CATEGORÍA
Juan | Pérez | 555-1234 | juan@email.com | Trabajo
```

### 8. Funciones Especiales

- **Detectar duplicados:** Mismo teléfono o email
- **Cumpleaños:** Array adicional con fechas
- **Notas:** Campo adicional para observaciones
- **Favoritos:** Marcar/desmarcar contactos importantes

## Algoritmos Clave

### Ordenamiento Alfabético

```java
// Por apellido, luego nombre
void ordenarContactos() {
    for (int i = 0; i < totalContactos - 1; i++) {
        for (int j = i + 1; j < totalContactos; j++) {
            String nombre1 = apellidos[i] + " " + nombres[i];
            String nombre2 = apellidos[j] + " " + nombres[j];
            
            if (nombre1.compareToIgnoreCase(nombre2) > 0) {
                intercambiar(i, j);
            }
        }
    }
}
```

### Búsqueda por Inicial

```java
void buscarPorInicial(char inicial) {
    for (int i = 0; i < totalContactos; i++) {
        if (apellidos[i].toUpperCase().charAt(0) == inicial) {
            mostrarContacto(i);
        }
    }
}
```

## Validaciones

### Teléfono

- 10 dígitos
- Formatos aceptados: 5551234567, 555-123-4567, (555) 123-4567

### Email

- Contiene @
- Tiene dominio con punto
- No espacios

### Nombre/Apellido

- Solo letras y espacios
- No vacío
- Entre 2 y 50 caracteres

## Formato de Salida

```bash
╔════════════════════════════════════════════╗
║          INFORMACIÓN DEL CONTACTO          ║
╠════════════════════════════════════════════╣
║ Nombre:     Juan Pérez García              ║
║ Teléfono:   (555) 123-4567                 ║
║ Email:      juan.perez@empresa.com         ║
║ Dirección:  Calle Principal 123            ║
║ Categoría:  Trabajo                        ║
║ Estado:     ⭐ Favorito                     ║
╚════════════════════════════════════════════╝
```

## Extras (Opcionales)

1. **Grupos:** Crear grupos personalizados
2. **Historial:** Últimas 10 búsquedas
3. **Importar:** Leer contactos desde texto
4. **Llamada rápida:** Números 1-9 para favoritos
5. **Sincronización:** Simular backup/restore
6. **Búsqueda inteligente:** Por similitud de nombre

## Casos de Prueba

Registra estos contactos:

1. Ana García - 555-0001 - <ana@email.com> - Familia
2. Carlos López - 555-0002 - <carlos@work.com> - Trabajo
3. María Rodríguez - 555-0003 - <maria@email.com> - Amigos
4. Luis Martínez - 555-0004 - <luis@email.com> - Familia
5. Sofía Hernández - 555-0005 - <sofia@work.com> - Trabajo

Prueba:

- Ordenar alfabéticamente
- Buscar por inicial "M"
- Listar solo categoría "Trabajo"
- Editar teléfono de Carlos
- Eliminar a Luis

## Tiempo Estimado

4-5 horas

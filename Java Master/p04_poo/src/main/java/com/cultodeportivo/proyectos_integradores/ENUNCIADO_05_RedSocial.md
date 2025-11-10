# PROYECTO 05: Red Social Simplificada 📱

## Dificultad: ⭐⭐⭐⭐⭐ | Tiempo: 12-15 horas

## Descripción

Red social con usuarios, publicaciones multimedia, comentarios, reacciones, sistema de amistades, chat, notificaciones y timeline personalizado. El proyecto más complejo aplicando composición e interfaces.

## Estructura Principal

### Clase Usuario

Atributos: id, username, email, contraseña (hash), nombre, biografia, fotoPerfil, fechaRegistro, verificado

Relaciones: lista de amigos, lista de seguidores, lista seguidos, lista publicaciones propias, lista notificaciones

Métodos: publicar(), comentar(), darLike(), agregarAmigo(), seguir(), dejarDeSeguir(), buscarUsuarios()

### Clase Abstracta: Contenido

Subclases: Publicacion, Comentario, Historia (24h), Mensaje

Atributos comunes: id, autor, texto, fechaCreacion, privacidad, reacciones

Métodos abstractos: obtenerTipo(), puedeEditarse(), tiempoDeVida()

### Clase Publicacion (hereda Contenido)

Tipos: Texto, Imagen, Video, Compartida

Atributos: multimedia, ubicación, etiquetados, comentarios, compartidas

Privacidad: Pública, Amigos, Solo yo

### Clase Reaccion

Tipos (Enum): ME_GUSTA, ME_ENCANTA, ME_DIVIERTE, ME_ENTRISTECE, ME_ENOJA

Atributos: usuario, tipo, fecha

### Clase Comentario

Atributos: publicacion padre, respuestas (comentarios anidados), menciones

Métodos: responder(), editar(), eliminar()

### Clase Amistad

Atributos: usuario1, usuario2, fechaAmistad, estado

Estados: PENDIENTE, ACEPTADA, RECHAZADA, BLOQUEADO

### Sistema de Notificaciones

Tipos: Nueva solicitud amistad, Aceptó amistad, Comentó publicación, Le gustó publicación, Te mencionó, Nuevo seguidor, Cumpleaños

Interface Notificable: enviarNotificacion(), marcarComoLeida(), eliminarNotificacion()

### Clase Timeline

Métodos: generarFeed() - ordena publicaciones por relevancia, filtrarPorFecha(), filtrarPorUsuario()

Algoritmo Feed:

- Publicaciones de amigos (ponderación alta)
- Publicaciones de seguidos (media)
- Publicaciones populares (likes/comentarios)
- Orden cronológico con relevancia

## Funcionalidades

### 1. Gestión de Usuarios

- Registro con validación email
- Login/logout
- Actualizar perfil
- Cambiar foto perfil
- Ver perfil público

### 2. Sistema de Amistades

- Enviar solicitud amistad
- Aceptar/rechazar solicitud
- Eliminar amigo
- Bloquear usuario
- Ver lista amigos
- Sugerencias de amistad

### 3. Publicaciones

- Crear publicación texto/multimedia
- Editar publicación (antes 5 min)
- Eliminar publicación
- Comentar publicación
- Reaccionar (6 tipos)
- Compartir publicación
- Etiquetar amigos

### 4. Timeline y Feed

- Ver publicaciones de amigos
- Ver publicaciones populares
- Filtrar por tipo contenido
- Buscar publicaciones
- Ver perfil con todas sus publicaciones

### 5. Sistema de Chat

- Enviar mensaje privado
- Ver conversaciones
- Historial de chat
- Mensajes no leídos
- Escribiendo... (indicador)

### 6. Notificaciones

- Centro de notificaciones
- Contador sin leer
- Marcar como leída
- Eliminar notificación

### 7. Búsqueda

- Buscar usuarios por nombre
- Buscar por hashtags
- Buscar publicaciones
- Filtros avanzados

### 8. Estadísticas

- Publicaciones totales
- Amigos/seguidores
- Reacciones recibidas
- Comentarios recibidos
- Actividad reciente

## Reglas de Negocio

- Username único de 3-20 caracteres
- Email válido y único
- Solo amigos pueden comentar publicaciones privadas
- No se puede dar like dos veces a misma publicación
- Máximo 100 amigos para usuarios no verificados
- Historias se eliminan después de 24 horas
- Publicaciones pueden editarse solo primeros 5 minutos
- Usuario bloqueado no puede ver contenido

## Casos de Prueba

Escenario 1: Publicar y Recibir Reacciones

1. Usuario crea publicación "¡Hola mundo!"
2. Amigo1 da ME_GUSTA
3. Amigo2 da ME_ENCANTA
4. Usuario recibe 2 notificaciones
5. Publicación muestra 2 reacciones

Escenario 2: Sistema de Comentarios Anidados

1. Usuario publica foto
2. Amigo1 comenta "Qué bonito"
3. Usuario responde comentario "Gracias!"
4. Amigo2 responde al de Amigo1
5. Se crea árbol de comentarios

Escenario 3: Solicitud de Amistad

1. UsuarioA envía solicitud a UsuarioB
2. Estado: PENDIENTE
3. UsuarioB recibe notificación
4. UsuarioB acepta
5. Ambos son amigos
6. Ahora ven publicaciones mutuas

## Menú del Sistema

```bash
╔════════════════════════════════════════╗
║         RED SOCIAL - SocialApp         ║
╠════════════════════════════════════════╣
║  1. Ver timeline                       ║
║  2. Crear publicación                  ║
║  3. Ver mis publicaciones              ║
║  4. Ver perfil                         ║
║  5. Buscar usuarios                    ║
║  6. Gestionar amistades                ║
║  7. Ver notificaciones                 ║
║  8. Chat                               ║
║  9. Configuración                      ║
║  0. Cerrar sesión                      ║
╚════════════════════════════════════════╝
```

## Extras Opcionales

1. Sistema de grupos
2. Eventos y calendario
3. Stories (historias 24h)
4. Marketplace
5. Páginas de empresa
6. Encuestas en publicaciones
7. Streaming en vivo
8. Stickers y GIFs

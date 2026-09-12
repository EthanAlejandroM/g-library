<h1 align= "center"> G-LIBRARY</h1>

<h3 align= "center">Este es un proyecto académico</h3> 

<h2 align= "center"> Introducción</h2>

### Descripción
Sistema de gestión bibliotecaria donde administradores y bibliotecarios se encargan de gestionar las diferentes funciones para los usuarios.

### Características principales
- Gestionar libros. 
- Gestionar usuarios. 
- Gestionar prestamos.
- Generar reportes.
- Gestionar acceso al sistema.

>[!NOTE]
> Por el momento, solo se trabajará con el requerimiento "Gestionar usuarios" el cual se encuentra en desarrollo.


### Tecnologías utilizadas 
- Java
- MySql
- JavaFX
- CSS


### Diagrama "Gestionar usuarios" 
![Ver o descargar Diagrama](docs/ArquitecturaGestionarUsuarios.svg)

### Estructura del proyecto

```text
g-library/
├── src/
│   ├── UI/
│   │   └── Interfaz.java
│   ├── Business/
│   │   └── GestionUsuario.java
│   └── Service/
│       ├── ConexionBD.java
│       ├── EstudianteDAO.java
│       ├── ProfesorDAO.java
│       └── UsuarioDAO.java
├── docs/
│   └── ArquitecturaGestionarUsuarios.svg
├── .gitignore
├── CONTRIBUTING.md
└── README.md
```


| Área | Estado |
|---|---|
|Interfaz         | En progreso |
| Base de datos |  En progreso |
| Gestión de usuarios | En progreso |
| Pruebas | En progreso |

### Autores
- Nicolle Mera 
- Ethan Alejandro Mezu 
- Robinson Elian Corrales
- Jesus David Tobar
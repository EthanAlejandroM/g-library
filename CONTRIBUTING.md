<h1 align= "center"> Documentación</h1>
<p align= "center">Para contribuidores</p>

<p align="center">
<img src="https://img.shields.io/badge/ESTADO-EN%20DESAROLLO-blue">
</p>

## INDICE

- [Instalación](#instalación)
- [Estructura del proyecto](#estructura-del-proyecto)
- [Flujo de trabajo con Git](#flujo-de-trabajo-con-git)
- [Ramas](#ramas)
- [Commits](#commits)
- [Pull Requests](#pull-requests)
- [Issues](#Issues)
- [Resolución de conflictos](#resolución-de-conflictos)

________

### Instalación

1. Copia el link del repositorio y pegalo en la terminal:

```bash
git clone https://github.com/EthanAlejandroM/g-library.git
```

2. Luego ejecuta el comando para posicionarte en la carpeta del repositorio:

```bash
cd g-library
```
Y ya lo tienes como repositorio local :D !

_______

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
### MER (modelo entidad relación)
 [Ver diagrama MER](docs/mer.jpeg)

## Flujo de trabajo con Git
Para mantener un orden en el proyecto y evitar problemas entre los cambios de los demás integrantes, es importante seguir el siguiente flujo de trabajo:

1. **Actualizar la rama** `main`

Asegurate de tener la versión más reciente del proyecto antes de empezar a trabajar en él. Para ello ejecuta los siguientes comandos en tu terminal:

```bash
git switch main
git pull origin main
```
> [!TIP]
> No los ejecutes juntos, primero ejecuta uno y después el otro.

2. **Crea una rama para el trabajo**

Ver sección [Ramas](#ramas). 

3. **Realizar cambios.**

Trabaja unicamente en la funcionalidad o corrección que corresponde a tu rama.

>[!IMPORTANT]
> Antes de continuar, verifica que el proyecto compile y funcione de manera correcta.

4. **Guardar los cambios realizados con un commit**

Ver como realizar commits en la sección [Commits](#commits).

5. **Subir la rama a Github**

Sube tu rama al repositorio remoto:

```bash
git push -u origin feature/nombre-de-la-rama-que-creaste
```

6. **Hacer una solicitud para integrar tus cambios**

Una vez que hayas subido la rama, deberás crear un pull request desde github hacia `main`.

Revisar la sección [Pull Requests](#pull-requests).

>[!WARNING]
> Revisa si hay un problema en Issues relacionado con tu modificación y si ya fue resuelto o sigue pendiente antes de subirlo.

Revisar la sección [Issues](#Issues).

7. **Revisión del pull request**

Todos los integrantes del equipo o al menos dos de ellos tendrán que revisar los cambios solicitados y aceptarlos si está bien para integrarlo al `main` o rechazarlo si no cumple con lo que se necesita o porque puede dañar el proceso.

____________

### Ramas

Las ramas permiten que los integrantes trabajen en una funcionalidad o corrección distinta sin tocar directamente la rama `main` que es *la **rama principal** del proyecto*.

>[!WARNING]
> No se deben realizar cambios directamente sobre `main`. Los cambios deben realizarse en una rama independiente y posteriormente hacer una solicitud de integración mediante pull request.

**Estructura de las ramas**

```text
main
├── feature/g-usuarios/database
├── feature/g-usuarios/interface
│
├── docs
├── fix
└── refactor
```

**¿Cómo crear una rama para trabajar en ella?**

* Si vas a trabajar en una nueva funcionalidad ejecuta el comando en tu terminal:

```bash
git switch -c feature/nombre-de-la-nueva-funcionalidad
```
* Si vas a trabajar dentro de una funcionalidad:

```bash
git switch -c feature/g-usuarios/nombre-de-lo-que-vas-a-hacer
```

En este proyecto, para los nombres de las ramas estaremos utilizando:

* feature: Nueva funcionalidad.
* fix: corrección de errores.
* docs: cambios en documentación.
* refactor: cambios en el código sin comprometer la funcionalidad.


>[!NOTE]
>Los nombres deben ser breves y descriptivos, escritos en minúsculas y utilizando `-` para la separacion de palabras.

**¿Cómo cambiar entre ramas?**

Utiliza el comando:

```bash
git switch nombre-de-la-rama-a-la-que-quieres-cambiar
```
**¿Cómo eliminar una rama?**

Una vez que el trabajo de una rama haya sido integrado a `main`, la rama puede eliminarse. Para ello, ejecuta el comando:

```bash
git branch -d nombre-de-la-rama-que-quieres-eliminar
```

>[!TIP]
>Mantén las ramas enfocadas en **una sola tarea**. Evita mezclar varias funcionalidades o correcciones diferentes en la misma rama.

__________

### Commits

Los commits permiten registrar los cambios realizados en el proyecto. Deben ser mensajes breves que describa claramente qué se modificó.

**¿Cómo crear un commit?**

Antes de hacer un commit, averigua el estado de tus modificaciones con:

```bash
git status
```

Luego, escribe el comando en tu consola. Eso es para guardar los cambios hechos y subirlos a la rama en la que estas trabajando:

```bash
git add .
git commit -m "tipo: descripcion del cambio"
git push origin nombre-rama-donde-estás-trabajando
```
>[!IMPORTANT]
>Asegurate de verificar que hayas pasado todos los cambios recientes de la rama main, si no te saldrá un error. Además recuerda no trabajar sobre la rama `main`.

**Formato:**

```text
tipo: descripción del cambio
```
Esto para tener un orden en los cambios realizados.

**Tipos de commit**

`feat`: Nueva funcionalidad

`fix`: Corrección de un error

`docs`: Cambios en documentación

`refactor`: mejora del código sin comprometer la funcionalidad

`test`: agregar o modificar pruebas

*Ejemplo:*

```bash
git add .
git commit -m "fix: corregir validación de correo"
```
_________

### Pull requests

Los PR (Pull request) se utilizan para proponer la integración de cambios realizados en una rama hacia `main`.

**Antes de hacer un pull request asegurate de:**

- Haber terminado la funcionalidad o corrección correspondiente. 

- Comprobar que el proyecto compile.

- Probar los cambios realizados.

- Haber realizado los commits.

- haber subido a la rama correspondiente.
____________


El pull request debe explicar de forma breve:

- Que cambios se realizaron.
- Que funcionalidad se agregó o modificó.
- Si se realizaron pruebas
- Si existe algun problema pendiente.
- Subir una captura de prueba donde se vea la modificación. 
___________

Una vez que el PR haya sido evaluado y aceptado por los integrantes, se puede realizar el "merge" que corresponde a la integración a la rama `main`.

>[!IMPORTANT]
>NO hagas merge de tus propias cambios sin que al menos otro integrante los haya revisado, más si los cambios pueden afectar partes del proyecto.

___________

### Issues

Permiten organizar, registrar y dar seguimiento a tareas, errores o mejoras que DEBEN realizarse en el proyecto.

**¿Cuándo crearlo?**

- Cuando hay un error por corregir.
- Registrar una tarea pendiente.

>[!NOTE]
>Cuando un PR solucione completamente un Issue se puede utilizar "Closes #numero-issue" en la descripcion del PR. Al integrarlo en main GitHub cierra de forma automática el Issue correspondiente.

*Los Issues son importantes para tareas complejas que requieren comunicación entre los integrantes, si no es necesario, es mejor hacer un PR.*

____

### Resolución de conflictos

Un conflicto ocurre cuando git no puede combinar dos cambios realizados sobre la misma parte de un archivo.

En ese caso, se recomienda **actualizar la rama**.

Si por algun motivo no hiciste este paso, en la interfaz de GitHub va a aparecer que la rama main esta desactualizada a comparación de la rama en la que estemos trabajando. Es por eso que debemos cumplir con el protocolo de **revisar el código y ver con qué versión nos quedamos**.

Posteriormente se guardan los cambios con un commit, por ejemplo:

``` bash
git add .
git commit -m "fix: resolver conflicto de merge"
```

**Recomendaciónes:**

- No aceptar automáticamente una versión sin revisar qué cambios se están descartando.

- Revisar el archivo completo después de resolver el conflicto.

- Comprobar que el proyecto compile correctamente.

- Realizar las pruebas necesarias antes de crear o actualizar el Pull Request.

- Si no se tiene claro qué versión conservar, consultar con el integrante que realizó los cambios.

>[!IMPORTANT]
>Resolver cuidadosamente los conflictos, ya que una resolución incorrecta puede eliminar cambios hechos por otro integrante.
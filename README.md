# Operación fuego de Quasar MELI


## Introducción

Api Rest que contiene los servicios requeridos para poder calcular la posicion y el mensaje enviado por la nave portacarga recibida por los tres satélites (kenobi, skywalker y sato), basado en la operación Fuego de Quasar indicada por MELI.

## Consideraciones Técnicas

Desarrollada sobre Java 8, utilizando Spring boot y base de datos relacional H2.

### Paquetes

DEscripcion de los paquetes del proyecto, los cuales distribuyen las clases por sus funcionalidades.

* controller: Clases que reciben peticiones HTTP y exponen los endpoints de los servicios.
* dto: Clases que representa el request y response del API.
* entity: Clases que representan entidades de base de datos.
* exception: Clases para el manejo de errores.
* repository: Interfaces para la interacción con bases de datos extendiendo de la clase JpaRepository.
* service: Clases con lógica del servicio.


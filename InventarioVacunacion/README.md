###API RETO KRUGER - INVENTARIO DE VACUNACIÓN DE EMPLEADOS
Kruger Corporation requiere una aplicación para llevar un registro del inventario del estado de vacunación de los empleados

###herramientas utilizadas:
- Lenguaje: JAVA -Framework: Spring boot. 
- Persistencia de datos: Base de datos Postgresql.
- Documentación de la API hecha en (Swagger-OpenAPI) 
- Seguridades de los endpoints basado en roles de usuarios 
- Se incluye el modelo de datos.

###Pasos para Levantar la aplicación:
- Se debe ejecutar el script sql con nombre schema.sql para crear la base de datos con sus tablas y sus registros iniciales. 
- Se debe importar el proyecto InventarioVacunacion al ide en este caso se usó IntelliJ IDEA 
- En el archivo application-dev.properties se puede cambiar los parámetros referentes a la conexión con la base de datos (usuario-contraseña) 
- Correr la clase principal InventarioVacunacionApplication para levantar el proyecto

###Pasos para consumir los servicios API REST
- Se tiene un usuario con las siguientes credenciales con rol Administrador   username: admin password: 12345 el cual servirá para autenticarnos a través del siguiente path,  http://localhost:8090/vacunacion/api/auth/authenticate Que devolverá un token para poder consumir los demas endpoints 
**Nota:** Se Debe Correr El Test Para Que La Clave Se Guarde Encriptada En La Base De Datos..
- El Token devuelto se lo debe de colocar en postman en el campo que aparece en la pestaña Authorization y Escoger el Type Bearer Token 
- Se podrán consumir los demás servicios los cuales se muestran detallados en el siguiente link {host}:{puerto}/{contexto}/swagger-ui.html en mi caso es http://localhost:8090/vacunacion/api/swagger-ui.html#/

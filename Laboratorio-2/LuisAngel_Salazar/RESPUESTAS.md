1.- ¿Qué diferencia existe entre @RestController y @Controller?

@Controller se utiliza principalmente para aplicaciones web que devuelven vistas HTML.
@RestController se utiliza para crear APIs REST y devuelve directamente los datos, normalmente en formato JSON.

2.- ¿Para qué sirve @RequestMapping?

sirve para definir la ruta (URL) que atenderá un controlador o método. También puede especificar el método HTTP utilizado, como GET, POST, PUT o DELETE.

3.-¿Cuál es la diferencia entre @PathVariable y @RequestParam?

@PathVariable obtiene un valor directamente de la URL.
@RequestParam obtiene un valor de los parámetros de consulta.

4.-¿Por qué se recomienda inyección por constructor?

Se recomienda porque permite proporcionar las dependencias de una clase desde su creación.

5.-¿Qué problema se evita al separar Controller y Service?

Se evita mezclar responsabilidades.
Controller: recibe las peticiones HTTP y devuelve las respuestas.
Service: contiene la lógica de negocio.

6.-¿Qué código HTTP se debe devolver al crear un recurso correctamente?

Al crear correctamente un recurso mediante POST, se debe devolver el código:
201 Created
Este código indica que el recurso fue creado exitosamente.

7.-¿Por qué POST y PUT requieren body JSON?

POST y PUT normalmente se utilizan para crear o actualizar recursos, por lo que necesitan recibir los datos del recurso.

8.-¿Qué ocurre si Angular intenta consumir un endpoint que no existe?

ESi Angular realiza una petición a un endpoint que no existe en el backend, Spring Boot normalmente responde con el código HTTP:
404 Not Found
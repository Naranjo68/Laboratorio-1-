1.- ¿Qué diferencia existe entre @RestController y @Controller?

@RestController se usa para crear APIs y devuelve los datos directamente en formato JSON. @Controller normalmente se usa para devolver vistas HTML.

2.- ¿Para qué sirve @RequestMapping?

Sirve para definir la ruta o URL que tendrá un controlador o uno de sus métodos.

3.-¿Cuál es la diferencia entre @PathVariable y @RequestParam?

@PathVariable obtiene un valor que está dentro de la URL, por ejemplo /productos/1. @RequestParam obtiene un parámetro después del ?, por ejemplo /productos?id=1.

4.-¿Por qué se recomienda inyección por constructor?

Porque hace que las dependencias sean más claras y facilita las pruebas y el mantenimiento del código.

5.-¿Qué problema se evita al separar Controller y Service?

Se evita tener toda la lógica del programa dentro del controlador. Así el código queda más ordenado y fácil de mantener.

6.-¿Qué código HTTP se debe devolver al crear un recurso correctamente?

Se debe devolver 201 Created.

7.-¿Por qué POST y PUT requieren body JSON?

Porque normalmente necesitan recibir los datos del recurso que queremos crear o actualizar.

8.-¿Qué ocurre si Angular intenta consumir un endpoint que no existe?

El servidor devuelve un error, normalmente 404 Not Found, y Angular recibe ese error.
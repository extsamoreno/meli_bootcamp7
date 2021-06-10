DEASAFÍO 1 - COMENTARIOS

1. Usar el puerto 8082: Cuando uses Postman o el Browser para hacer peticiones a la aplicación, emplear la url: "http://localhost:8082/"

2. La aplicación cuenta con unos datos base en archivos JSON, en la carpeta "resources", para alimentar el repository de User, Post y Product.
	- User ya cuenta con los Id del 1 al 10.
	- Post ya cuenta con los Id 1 y 2.
	- Product ya cuenta con los Id 1 y 2.

3. La base de datos para User, Post y Product son una estructura de tipo HashMap, donde la "llave" es el Id y el "valor" la correspondiente instancia de clase. 

4. Al enviar un nuevo Post se realiza la validación que el userId exista y que los postId y productId no existan en la base de datos; por tanto, cada nuevo Post debe tener postId y productId diferentes a los enviados previamente.

5. Al generar la lista de Post, cada uno de ellos muestra por defecto los atributos de hasPromo y discount.


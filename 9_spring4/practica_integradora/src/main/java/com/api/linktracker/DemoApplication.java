package com.api.linktracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}

/*
 Práctica integradora

Link Tracker es un sistema para tracker enmascarar URLs y poder obtener analítica de cuantas veces se llamó a cada uno de los links, así como también agregar reglas de negocio para el funcionamiento del redirect.
Se pide desarrollar una aplicación utilizando Spring Boot con Maven que soporte los siguientes casos de uso:
1.OK. Crear un link: Endpoint POST para crear link a partir de una URL válida y tiene que devolver un JSON con el linkId para utilizar en la redireccion.
2.OK. Redirección:  Dado un link (ej: http://localhost:8080/link/{linkId} ) tiene que realizar un redirect a la URL enmascarada. Siempre y cuando el link sea válido. En el caso de que el link sea invalido devolver 404. (INVESTIGAR REDIRECT)
3. Estadísticas por link: Endpoint GET que dado un link (ej: http://localhost:8080/metrics/{linkID} ) tiene que devolver la estadística de cantidad de veces que se redireccionó.
4. OK. Invalidate link: Endpoint POST para invalidar un link ((ej: http://localhost:8080/invalidate/{linkID} )
5. OK. Al crear los links se tiene que poder agregar un password que va a ser un query param al llamar a la redirección.

Ayuda: Repositorio a utilizar para guardar información, puede ser un HashMap<Integer, LinkDTO> o un List<LinkDTO>

 */
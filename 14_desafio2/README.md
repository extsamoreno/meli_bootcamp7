# Desafío de Testing Automatizado

_El objetivo de este desafío es aplicar los contenidos abordados hasta el momento durante el BOOTCAMP MeLi (Git, Java, Spring y Testing), haciendo principal hincapié en las validaciones y tipos de testing que pueden ser utilizados a partir de un enunciado propuesto, una especificación de requisitos y documentación anexada._

## Comenzando 🚀

_A continuación unos comentarios para poder facilitar la evaluación de la funcionalidad de "TuCasita Tasaciones"._


### Tener en cuenta 📋

* _Dentro de este repo se encuentra la colección de Postman "apiTuCasita" para faciitar el testeo de los endpoints._
* _Los métodos del Service recurren a PropertyRepository para poder levantar en memoria las colecciones._

```
PropertyRepository lee dos json: "properties.json" y "districts.json".
```

* _PropertyRepository NO se encargará de persistir en una base las nuevas propiedades y distritos dados de alta a través de los Http Post._
* _La finalidad de los Post Request es simplemente verificar las validations de los campos solicitados._
* _Estos Post no se han llegado a testear._
* _Ha sido excluido dentro del Coverage de los tests, los siguientes packages: "model", "dto" y "repository", y el controller: "PropertyExceptionController"._

## Autor ✒️

**Mariano Julián González** - *Desafío Testing Automatizado* - [mariangonzal](https://github.com/mariangonzal)

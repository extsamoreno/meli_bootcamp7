# Bienvenido al Desafio
---
A continuación se explica la unica cosa que se debe tener encuenta a la hora de correr los test 

---

1. Ejecutar el archivo Tasaciones.postman_collection.json en postman con el orden que esta.

2. Cuando ejecute los test por primera vez no va a tener inconveniente, pero por segunda vez va a generar error debido a que se inserta una casa al json, por lo cual al volverlo a insertar va a generar error, se recomienda eliminar house.json el siguiente codigo 


 {
    "name": "Casa Prueba Ingreso ",
    "neighborhood": {
      "name": "Madrid",
      "price": 2340.0
    },
    "environments": [
      {
        "environmentId": 1,
        "name": "Alcoba",
        "width": 12.7,
        "leng": 19.2
      },
      {
        "environmentId": 2,
        "name": "Dormitorio",
        "width": 11.1,
        "leng": 22.2
      },
      {
        "environmentId": 3,
        "name": "Sala",
        "width": 2.1,
        "leng": 1.2
      }
    ]
  },
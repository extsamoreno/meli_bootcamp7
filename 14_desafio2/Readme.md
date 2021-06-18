# TuCasita Tasaciones

### Reference Documentation

* To get started, clone the repository into your IDEA of preference.

##Important
In the resources folder there is a postman file where you have all the endpoint queries

### Guides

Next I will mention the "endpoints" developed, their functions and how to test them in case there are problems with the posman file.

###1ts Endpoint

Allows to receive a house by parameter

    @PostMapping("/newHouse")

* Postman 
  
localhost:8080/house/newHouse 

* Payload

        {
        "id":8,
        "prop_name": "House8",
        "district": {
                "id": 1,
                "name": "Center",
                "price": 120
        },
        "environments": [  
        {
                "name": "Bath",
                "width": 1,
                "length": 30
                },
                {
                "name": "Room",
                "width": 6,
                "length": 6
                },
                {
                "name": "Yard",
                "width": 15,
                "length": 30
        }]
        }

* Response 

        ¡Exit!


###2nd Endpoint

It allows to determine the total square meters of a property

        @GetMapping("/meterProperty/{id}")

* Postman 
  
        localhost:8080/house/meterProperty/1

* Response:

        {
        "prop_name": "House1",
        "squareMeter": 340.0
        }

###3rd Endpoint
Indicate the value of a property based on its environments and measurements.
Please note that prices per square meter are determined by district

    @GetMapping("/priceProperty/{id}")

* Postman

        localhost:8080/house/priceProperty/1

* Response:

        {
        "prop_name": "House1",
        "price": 170000.0
        }

###4th Endpoint
It allows you to determine which is the largest environment of a property.

@GetMapping("/largestEnvironment/{id}")

* Postman
  
        localhost:8080/house/largestEnvironment/1

* Response:

        {
        "prop_name": "House1",
        "environmentHouse": {
                    "name": "Yard",
                    "width": 15.0,
                    "length": 20.0
        },
        "squareMeter": 300.0
        }

###5th Endpoint

It allows to determine the amount of square meters that each environment 
of a property has.

@GetMapping("/meterPerEnvironment/{id}")

* Postman

        localhost:8080/house/meterPerEnvironment/1

* Response:

        {
        "prop_name": "House1",
        "meterPerEnvironment": {
                "yard": 300.0,
                "bath": 4.0,
                "room": 36.0
        }
        }

##Test

You can run the "all Test" with coverage ignoring the following classes and packages:
            
    desafio2.testing.domian.*
    desafio2.testing.exception.*
    desafio2.testing.service.tdo.*
    desafio2.testing.util.*
    desafio2.testing.TestingApplication
    desafio2.testing.controller.HandlerExceptionController

The answer you should give is 100% of the classes, 100% of the methods, and 97% of the lines tested.

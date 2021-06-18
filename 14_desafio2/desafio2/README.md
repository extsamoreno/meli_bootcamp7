# Getting Started

### Resource files
No json resource files are needed 
    

### Request examples
*[/districts] 
    *[/add] Http://localhost:8080/districts/add
    Body:
    {
        "name": "Distrito 12",
        "price": 500
    }
    
*[/properties]
    *[/add] Http://localhost:8080/properties/add
    Body:
    {
        "name": "Casa de Angel",
        "districtId": 1,
        "roomList": [
            {
                "name": "Living",
                "width": 5,
                "length": 6
            },
            {
                "name": "Bedroom",
                "width": 3,
                "length": 4
            },
            {
                "name": "Kitchen",
                "width": 3,
                "length": 6
            }
        ]
    }
    *[/{propId}/area] Http://localhost:8080/properties/1/area
    *[/{propId}/price] Http://localhost:8080/properties/1/price
    *[/{propId}/rooms/area] Http://localhost:8080/properties/1/rooms/area
    *[/{propId}/rooms/biggest] Http://localhost:8080/properties/1/rooms/biggest

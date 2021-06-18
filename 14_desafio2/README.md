# Challenge of Testing
if you want test the endpoints run the proyect and just run the test

## Requeriments of the system

# US 0001:
Calculate the total square metter of a property

| METHOD | SIGN |
| --- | --- |
| GET | /calculate/house/{houseId}/totalMeters |
| Example | /calculate/house/1/totalMeters |
| Response | totalMeters m2 |
| Response example | 856.0 m2 |

## Params:

| Params | Type | Description |
| --- | --- | --- |
| houseId | int | number that identifies the house |

# US 0002:
Indicate the value of a property based on its environments and measurements taking into account the price for the neighborhood

| METHOD | SIGN |
| --- | --- |
| GET | /calculate/house/{houseId}/totalPrice |
| Example | /calculate/house/1/totalPrice |
| Response | U$D totalPrice  |
| Example Response | U$D 4780.00 |

## Params:

| Params | Type | Description |
| --- | --- | --- |
| houseId | int | number that identifies the house |

# US 0003:
Determine which is the largest environment

| METHOD | SIGN |
| --- | --- |
| GET | /calculate/house/{houseId}/biggerRoom |
| Example | /calculate/house/1/biggerRoom |
| Response |  |

```json
{
    "name": "Room1",
    "width": 23.0,
    "length": 12.0
}
```

## Params:

| Params | Type | Description |
| --- | --- | --- |
| houseId | int | number that identifies the house |

# US 0004:
Determine the amount of square meters that each room of a property has

| METHOD | SIGN |
| --- | --- |
| GET | /calculate/house/{houseId}/mettersByRoom |
| Example | /calculate/house/1/mettersByRoom |
| Response |  |

```json
[
    {
        "name": "Room1",
        "totalMeters": 100.0
    },
    {
        "name": "Room2",
        "totalMeters": 85.0
    }
]
```

## Params:

| Params | Type | Description |
| --- | --- | --- |
| houseId | int | number that identifies the house |

# US 0005:
Add a new house to data base

| METHOD | SIGN |
| --- | --- |
| POST | /calculate |
| Payload | |
```json
{
    "name": "MyHouse",
    "district": {
        "name": "MyDistrict"
    },
    "rooms": [
        {
            "name": "Room1",
            "width": 23.0,
            "length": 12.0
        },
        {
            "name": "Room2",
            "width": 15.0,
            "length": 9.0
        }
    ]
}
```
| Example | /calculate |
| Correct Response | Status Code 200 |
| Error Response | Status Code 400 |

# US 0006:
Get a house by id

| METHOD | SIGN |
| --- | --- |
| GET | /calculate/house/{houseId} |
| Example | /calculate/house/1 |
| Response |  |

```json
{
    "name": "MyHouse",
    "district": {
        "name": "MyDistrict"
    },
    "rooms": [
        {
            "name": "Room1",
            "width": 23.0,
            "length": 12.0
        },
        {
            "name": "Room2",
            "width": 15.0,
            "length": 9.0
        }
    ]
}
```

## Params:

| Params | Type | Description |
| --- | --- | --- |
| houseId | int | number that identifies the house |

# US 0007:
Add a new district in data base

| METHOD | SIGN |
| --- | --- |
| POST | /district |
| Payload | |
```json
{
    "name": "MyHouse",
    "price": 1000.0
}
```
| Example | /calculate |
| Correct Response | Status Code 200 |
| Error Response | Status Code 400 |

# US 0008:
Get a district by id

| METHOD | SIGN |
| --- | --- |
| GET | /district/{districtId} |
| Example | /district/1 |
| Response |  |

```json
{
    "name": "MyDistrict"
}
```

## Params:

| Params | Type | Description |
| --- | --- | --- |
| districtId | int | number that identifies the district |
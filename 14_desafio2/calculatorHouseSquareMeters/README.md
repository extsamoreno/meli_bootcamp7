# TuCasita Transacciones 🏠

_BOOTCAMP BACKEND JAVA - Challenge Testing_



![coverage](https://img.shields.io/badge/Coverage_Classes-100%25-greendark)
![coverage](https://img.shields.io/badge/Coverage_Methods-92%25-greendark)
![coverage](https://img.shields.io/badge/Coverage_Lines-96%25-greendark)

### Prerequisites 📋

_The url to enter the API is the following:_

```
"http://localhost:8080/meli/api/CalculatorHouseSquareMeters/v1/"
```
_The export of the json file to perform the tests in postman is located in the root of the project with the following name:_

```
"API RETO 2 SPRING BOOT TEST.postman_collection.json"
```
### Things to keep in mind 📌

_1. When starting the API, the following house is automatically loaded:_
```
{
    "houseName": "Casa1",
    "districtName": "Barrio Bajo",
    "numberRooms": 1,
    "totalSquareMeters": 100.0,
    "totalPrice": 80000.0,
    "rooms": [
        {
            "name": "Habitación Principal",
            "width": 10.0,
            "length": 10.0
        }
    ]
}
```
_2. When starting the API, the following districts are automatically loaded:_
```
[
    {
        "districtName": "Barrio Bajo",
        "squareMeterPrice": 800.0
    },
    {
        "districtName": "Barrio Medio Bajo",
        "squareMeterPrice": 1600.0
    },
    {
        "districtName": "Barrio Medio",
        "squareMeterPrice": 2400.0
    },
    {
        "districtName": "Barrio Medio Alto",
        "squareMeterPrice": 3200.0
    },
    {
        "districtName": "Barrio Alto",
        "squareMeterPrice": 4000.0
    }
]
```

_3. The following is the body of the Json to perform the correct creation of a new house:_
```
{
    "houseName": String(Name of the house),
    "districtName": String(Name of the district),
    "rooms": [
        {
            "name": String(Name of the room),
            "width": Double(width of the room),
            "length": Double(length of the room)
        },
        ...
    ]
}
```
_3.1. The following are the validations of the fields to make a correct creation of a new house:_

  | Atributo | Validations |
  |   :---:  |-------------|
  |houseName|Must not be Null. <br> Can not exceed 30 characters. <br> Must not be empty. <br> Must start in uppercase.|
  |districtName|Must not be Null. <br> Can not exceed 45 characters. <br> Must not be empty. <br> Must start in uppercase.|
  |rooms|Must not be Null. <br> Minimum length of rooms is 1.|
  |name|Must not be Null. <br> Can not exceed 30 characters. <br> Must not be empty. <br> Must start in uppercase.|
  |width|Must not be Null <br> Must be maximum 25 <br> Must be minimum 1 <br> Must be positive|
  |length|Must not be Null <br> Must be maximum 33 <br> Must be minimum 1 <br> Must be positive|

_4. The following is the body of the Json to perform the correct creation of a new district:_
```
{
    "districtName": String(Name of the district),
    "squareMeterPrice": Double(Square meter price of the district)
}
```
_4.1. The following are the validations of the fields to make a correct creation of a new district:_

| Atributo | Validations |
  |   :---:  |-------------|
|districtName|Must not be Null. <br> Can not exceed 45 characters. <br> Must not be empty. <br> Must start in uppercase.|
|squareMeterPrice|Must not be Null <br> Must be maximum 4000 <br> Must be minimum 1 <br> Must be positive|

### User Stories Solution 👨‍💻
- #### US-0001: Calculate the total square meters of a property
  _It was solved by entering the following EndPoint_
  ```
  {API URL}/totalQuantity/{houseName}
  ```
- #### US-0002: Indicate the value of a property based on its environments and measurements, taking into account the prices per square meter according to the district.
  _It was solved by entering the following EndPoint_
  ```
  {API URL}/totalQuantity/{houseName}
  ```
- #### US-0003: Determine which is the largest environment.
  _It was solved by entering the following EndPoint_
  ```
  {API URL}/biggestRoom/{houseName}
  ```
- #### US-0004: Determine the amount of square meters that each room of a house has.
    _It was solved by entering the following EndPoint_
    ```
      {API URL}/list/{houseName}
    ```

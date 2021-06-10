# SOCIALMELI API 🤝

_BOOTCAMP BACKEND JAVA - Challenge Spring_

### Prerequisites 📋

_The url to enter the API is the following:_

```
"http://localhost:8080/meli/api/socialmeli/v1/"
```

### Things to keep in mind 📌

_1. When starting the API, the following users are automatically loaded:_

```
{
  {
    "userId": 1,
    "userName": "Vendedor1",
    "isSeller": false
  },
  {
    "userId": 2,
    "userName": "Vendedor2",
    "isSeller": false
  },
  {
    "userId": 3,
    "userName": "Vendedor3",
    "isSeller": false
  },
  {
    "userId": 4,
    "userName": "Vendedor4",
    "isSeller": false
  },
  {
    "userId": 5,
    "userName": "Vendedor5",
    "isSeller": false
  },
  {
    "userId": 6,
    "userName": "Comprador1",
    "isSeller": true
  },
  {
    "userId": 7,
    "userName": "Comprador2",
    "isSeller": true
  },
  {
    "userId": 8,
    "userName": "Comprador3",
    "isSeller": true
  },
  {
    "userId": 9,
    "userName": "Comprador4",
    "isSeller": true
  },
  {
    "userId": 10,
    "userName": "Comprador5",
    "isSeller": true
  }
}
```
### Things to keep in mind ⛔️

* Sellers can not follow other sellers.
* Buyers can not follow a seller more than once.
* The attributes delivered through Json through the Post method in the Payload must be sent in CamelCase format.
* A publication with the same ID cannot be repeated more than once.

### Examples of PayLoads 📎
_1. Creating a new post:_ 
```
{
    "userId":1,
    "idPost": 1,
    "date": "09-06-2021",
    "detail":
    {
        "productId": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Back",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```
_2. Creating a new post whit promo:_
```
{
    "userId":1,
    "idPost": 2,
    "date": "09-06-2021",
    "detail":
    {
        "productId": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Back",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "hasPromo":true,
    "discount":0.25
}
```
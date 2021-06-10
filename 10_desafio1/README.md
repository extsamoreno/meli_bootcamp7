# REST API - Social Meli application

## Install

    Open pom.xml with your Favourite IDE - I recomended IntelliJ IDEA

## Run the app

    Run 'SpringChallengeApplication' 
    with command + R in Mac

# REST API

The REST API to the example app is described below.

## US 0001 - To be able to carry out the action of "Follow" to a certain seller

### Request

`POST /users/1/follow/4`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0

    1

## US 0002 - Obtain the result of the number of users who follow a certain seller

### Request

`GET /users/4/followers/count/`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json

    {
    "userID": 2,
    "userName": "Eduardo",
    "seller": false,
    "followers_count": 2
    }

## US 0003 - Get a list of all users who follow a certain seller (Who's following me?)

### Request

`GET /users/4/followers/list/`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json

    {
    "userID": 4,
    "userName": "Danilo",
    "seller": true,
    "followed": [
        {
            "userID": 2,
            "userName": "Eduardo",
            "seller": false
        },
        {
            "userID": 3,
            "userName": "Franco",
            "seller": false
        }
        ]
    }

## US 0004 - Get a list of all sellers that are followed by a certain user (Who am I following?)

### Request

`GET /users/3/followed/list/`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json

    {
    "userID": 3,
    "userName": "Franco",
    "seller": false,
    "followed": [
        {
            "userID": 1,
            "userName": "Matias",
            "seller": true
        },
        {
            "userID": 4,
            "userName": "Danilo",
            "seller": true
        }
        ]
    }

## US 0005 - Register a new publication

### Request

`POST /products/newpost`

    {
    "userID" : 4,
    "postID" : 67,
    "date" : "29-05-2021",
    "detail" : {
    "productID" : 5,
    "productName" : "Monitor 24'' 75hz IPS",
    "type" : "Gamer",
    "brand" : "Samsung",
    "color" : "Grey & Black",
    "notes" : "Rare Edition"
    },
    "category" : 100,
    "price" : 25000
    }

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0    

    1

## US 0006 - Obtain a list of the publications made by the sellers that a user follows in the last two weeks (for this take into account sort by date, latest posts first).

### Request

`GET /products/followed/3/list`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0    

    {
    "userID": 3,
    "userName": "Franco",
    "seller": false,
    "posts": [
        {
            "userID": 1,
            "postID": 5,
            "date": "09-06-2021",
            "detail": {
                "productID": 3,
                "productName": "Auriculares Gamer HyperX",
                "type": "Metal y Acrilico",
                "brand": "HyperX",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 17000.0
        },
        {
            "userID": 4,
            "postID": 2,
            "date": "30-05-2021",
            "detail": {
                "productID": 2,
                "productName": "Escritorio en L",
                "type": "Melamina",
                "brand": "Platinium",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 17000.0
        },
        {
            "userID": 4,
            "postID": 1,
            "date": "29-05-2021",
            "detail": {
                "productID": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Grey & Black",
                "notes": "Rare Edition"
            },
            "category": 100,
            "price": 29999.5
        },
        {
            "userID": 4,
            "postID": 67,
            "date": "29-05-2021",
            "detail": {
                "productID": 5,
                "productName": "Monitor 24'' 75hz IPS",
                "type": "Gamer",
                "brand": "Samsung",
                "color": "Grey & Black",
                "notes": "Rare Edition"
            },
            "category": 100,
            "price": 25000.0
        },
        {
            "userID": 4,
            "postID": 4,
            "date": "28-05-2021",
            "detail": {
                "productID": 2,
                "productName": "Escritorio en V",
                "type": "Melamina",
                "brand": "Platinium",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.0,
            "hasPromo": true,
            "discount": 10.0
        },
        {
            "userID": 1,
            "postID": 6,
            "date": "28-05-2021",
            "detail": {
                "productID": 2,
                "productName": "Mouse Inalambrico Logitech",
                "type": "Plastico",
                "brand": "Logitech",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.0,
            "hasPromo": true,
            "discount": 10.0
        }
        ]
    }

## US 0007 - To be able to carry out the action of “Unfollow” (stop following) to a certain seller.

### Request

`POST /users/1/unfollow/2`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0    

    1

## US 0008 - Ascending and descending alphabetical ordering

### Request

`GET /users/3/followed/list?order=name_asc`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json 

    {
    "userID": 3,
    "userName": "Franco",
    "seller": false,
    "followed": [
        {
            "userID": 4,
            "userName": "Danilo",
            "seller": true
        },
        {
            "userID": 1,
            "userName": "Matias",
            "seller": true
        }
        ]
    }

## US 0009 - Ascending and descending date ordering

### Request

`GET /products/followed/3/list?order=date_asc`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json 

    {
    "userID": 3,
    "userName": "Franco",
    "seller": false,
    "posts": [
        {
            "userID": 4,
            "postID": 4,
            "date": "28-05-2021",
            "detail": {
                "productID": 2,
                "productName": "Escritorio en V",
                "type": "Melamina",
                "brand": "Platinium",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.0,
            "hasPromo": true,
            "discount": 10.0
        },
        {
            "userID": 1,
            "postID": 6,
            "date": "28-05-2021",
            "detail": {
                "productID": 2,
                "productName": "Mouse Inalambrico Logitech",
                "type": "Plastico",
                "brand": "Logitech",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.0,
            "hasPromo": true,
            "discount": 10.0
        },
        {
            "userID": 4,
            "postID": 1,
            "date": "29-05-2021",
            "detail": {
                "productID": 1,
                "productName": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Grey & Black",
                "notes": "Rare Edition"
            },
            "category": 100,
            "price": 29999.5
        },
        {
            "userID": 4,
            "postID": 67,
            "date": "29-05-2021",
            "detail": {
                "productID": 5,
                "productName": "Monitor 24'' 75hz IPS",
                "type": "Gamer",
                "brand": "Samsung",
                "color": "Grey & Black",
                "notes": "Rare Edition"
            },
            "category": 100,
            "price": 25000.0
        },
        {
            "userID": 4,
            "postID": 2,
            "date": "30-05-2021",
            "detail": {
                "productID": 2,
                "productName": "Escritorio en L",
                "type": "Melamina",
                "brand": "Platinium",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 17000.0
        },
        {
            "userID": 1,
            "postID": 5,
            "date": "09-06-2021",
            "detail": {
                "productID": 3,
                "productName": "Auriculares Gamer HyperX",
                "type": "Metal y Acrilico",
                "brand": "HyperX",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 17000.0
        }
        ]
    }

## US 0010 - Carry out the publication of a new promotional product

### Request

`POST /products/newpost`

    {
    "userID" : 4,
    "postID" : 45,
    "date" : "29-05-2021",
    "detail" : {
    "productID" : 34,
    "productName" : "Monitor 24'' 75hz IPS",
    "type" : "Gamer",
    "brand" : "Samsung",
    "color" : "Grey & Black",
    "notes" : "Rare Edition"
    },
    "category" : 100,
    "price" : 25000,
    "hasPromo" : true,
    "discount": 10
    }

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0    

    1

## US 0011 - Get the amount of promotional products for a given seller

### Request

`GET /products/4/countPromo`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0    

    {
    "userID": 4,
    "userName": "Danilo",
    "seller": true,
    "promoproducts_count": 1
    }

## US 0012 - Get a list of all promotional products from a certain seller

### Request

`GET /products/4/list`

### Response

    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0    

    {
    "userID": 4,
    "userName": "Danilo",
    "seller": true,
    "posts": [
        {
            "userID": 4,
            "postID": 4,
            "date": "28-05-2021",
            "detail": {
                "productID": 2,
                "productName": "Escritorio en V",
                "type": "Melamina",
                "brand": "Platinium",
                "color": "Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 15000.0,
            "hasPromo": true,
            "discount": 10.0
        }
        ]
    }
# Getting Started

### Resource files
This being a non-database-connected API, you will need to provide .json files for the following entities:
* [Users.json] contains all the users signed in the system. format example below. 
    {
        "userId": 1,
        "userName": "fgomez"
    }
    
    

### Request examples
*[/users] 
    *[/{userId}/follow/{userIdToFollow}] Http://localhost:8080/users/1/follow/2
    *[/{userId}/followers/count] Http://localhost:8080/users/2/followers/count
    *[/{userId}/followers/list](optional param "order") Http://localhost:8080/users/4/followers/list?order=name_desc
    *[/{userId}/followed/list](optional param "order") Http://localhost:8080/users/3/followed/list?order=name_asc
    *[{userId}/unfollow/{userIdToUnfollow}] Http://localhost:8080/users/1/unfollow/2
    
*[/products]
    *[/followed/{userId}/list] Http://localhost:8080/products/followed/1/list?order=date_asc
    *[/newpromopost] Http://localhost:8080/products/newpromopost
    Body:
    {
        "userId": 2,
        "idPost": 1,
        "date": "29-05-2021",
        "detail": {
            "productId": 1,
            "productName": "Silla Gamer",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red Black",
            "notes": "Special Edition"
        },
        "category": 100,
        "price": 1500.50,
        "hasPromo": true,
        "discount": 0.25
    }
*[/newpost] Http://localhost:8080/products/newpost
    Body:
    {
        "userId": 2,
        "idPost": 2,
        "date": "01-06-2021",
        "detail": {
            "productId": 10,
            "productName": "Silla Gamer",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red Black",
            "notes": "Special Edition"
        },
        "category": 100,
        "price": 1500.50
    }
*[/{userId}/countPromo] Http://localhost:8080/products/2/countPromo
*[/{userId}/list] Http://localhost:8080/products/2/list

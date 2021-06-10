# Meli Challenge # 1
This readme bring some context about the SocialMeli API.
## Considerations: 
### 1) The User repository have pre-loaded users configured to be loaded each time the API is executed. A hashmap is being used to simulate the database and the pre-loaded users are:
`userId: 1 - userName: Usuario 1`

`userId: 2 - userName: Usuario 2`

`userId: 3 - userName: Usuario 3`

`userId: 4 - userName: Usuario 4`

`userId: 5 - userName: Usuario 5`

`userId: 1235 - userName: Usuario prueba.`

There's all the users that can be used for Postman test. If you wanna add another user you should add the new user in the hashmap located in UserRepository. Apart from user, neither post nor product have pre-loaded registers, if you wanna try all the API you should consider it.

Also, the API is running at 8080 port.

### 2) For each requirement it was used the next payload examples:

#### * 0001 (To be able to carry out the action of "Follow" to a certain seller):

Request Type -> `Post`

URL          -> `http://localhost:8080/users/{userId}/follow/{userToFollow}`

Example      -> `http://localhost:8080/users/1/follow/4`

Exceptions:
  -> if you try to request 2 times in a row the same follow should throw an `UserAlreadyFollowerException`

  -> if you put an unknown user id in both cases should throw `UserNotFoundException`

Payload      -> `Not required`

#### * 0002 (Obtain the result of the number of users who follow a certain seller):

Request Type -> `Get`

URL          -> `http://localhost:8080/users/{userId}/followers/count`

Example      -> `http://localhost:8080/users/4/followers/count`

Exceptions:
  -> if you put an unknown user id should throw `UserNotFoundException`

Payload      -> `Not required`

#### * 0003/0008 (Get a list of all users who follow a certain seller (Who's following me?)) (Ascending and descending alphabetical ordering):

Request Type -> `Get`

URL          -> `http://localhost:8080/users/{userId}/followers/list`

Example      -> 
```
http://localhost:8080/users/4/followers/list
http://localhost:8080/users/4/followers/list?order=name_des
http://localhost:8080/users/4/followers/list?order=name_asc
```

Exceptions:

  -> if you put an unknown user id should throw `UserNotFoundException`

  -> if you put an order request param different from `name_asc` or `name_des` should throw `IncorrectOrderTypeException`

Payload      -> `Not required`

Notes        -> By default, the list will be sorted descending

#### * 0004/0008 (Get a list of all sellers that are followed by a certain user (Who am I following?)) (Ascending and descending alphabetical ordering):

Request Type -> `Get`

URL          -> `http://localhost:8080/users/{userId}/followed/list`

Example      -> 
```
http://localhost:8080/users/1/followed/list
http://localhost:8080/users/1/followed/list?order=name_des
http://localhost:8080/users/1/followed/list?order=name_asc
```

Exceptions:

  -> if you put an unknown user id should throw `UserNotFoundException`

  -> if you put an order request param different from `name_asc` or `name_des` should throw `IncorrectOrderTypeException`

Payload      -> `Not required`

Notes        -> By default, the list will be sorted descending

#### * 0005 (Register a new publication):

Request Type -> `Post`

URL          -> `http://localhost:8080/products/newpost`

Example      -> `http://localhost:8080/products/newpost`

Exceptions:

  -> if `detail` or `date` are `null` values should throw `MissingDataException`

  -> if the `user id` included in the post has not been found should throw `UserNotFoundException`

  -> if the `post id` is already used on a different post should throw `PostIdAlreadyExistException`

  -> if the `date` included in the post is over the actual date should throw `OverActualDateException`

Payload:

Normal Post:
```
{
    "userId": 4,
    "id_post": 21,
    "date": "01-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```
Post without date (MissingDataException):
```
{
    "userId": 4,
    "id_post": 21,
    "date": "",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```
Unknown User (UsernotFoundException)
```
{
    "userId": 40,
    "id_post": 21,
    "date": "01-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```
Over Date (OverActualDateException)
```
{
    "userId": 4,
    "id_post": 22,
    "date": "01-06-2022",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50
}
```

#### * 0006/0009 (Obtain a list of the publications made by the sellers that a user follows in the last two weeks (for this take into account sort by date, latest posts first)) (Sort by ascending and descending date):

Request Type -> `Get`

URL          -> `http://localhost:8080/products/followed/{userId}/list`

Example 
```
http://localhost:8080/products/followed/1/list
http://localhost:8080/products/followed/1/list?order=date_desc
http://localhost:8080/products/followed/1/list?order=date_asc
```

Exceptions:

  -> if you put an order request param different from `name_asc` or `name_desc` should throw `IncorrectOrderTypeException`

Payload      -> `Not required`

#### * 0007 (To be able to carry out the action of "Unfollow" (stop following) to a certainseller):

Request Type -> `Post`

URL          -> `http://localhost:8080/users/{userId}/unfollow/{userIdToUnfollow}`

Example      -> `http://localhost:8080/users/1/unfollow/2`

Exceptions:

  -> if you put an unknown `user id` in both cases should throw `UserNotFoundException`
  
  -> if you try to request 2 times in a row the same unfollow should throw an `UserAlreadyUnfollowerException`
  
Payload      -> `Not required`

#### * 0010 (Carry out the publication of a new promotional product):

Request Type -> `Post`

URL          -> `http://localhost:8080/products/newpromopost`

Example      -> `http://localhost:8080/products/newpromopost`

Exceptions:

  -> if `detail` or `date` are `null` values should throw `MissingDataException`
  
  -> if the `user id` included in the post has not been found should throw `UserNotFoundException`
  
  -> if the `post id` is already used on a different post should throw `PostIdAlreadyExistException`
  
  -> if the `date` included in the post is over the actual date should throw `OverActualDateException`
  
Payload:

Normal Post:
```
{
    "userId": 4,
    "id_post": 28,
    "date": "01-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "hasPromo": true,
    "discount": 0.25
}
```
Post without date (MissingDataException):
```
{
    "userId": 4,
    "id_post": 28,
    "date": "",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "hasPromo": true,
    "discount": 0.25
}
```
Unknown User (UsernotFoundException)
```
{
    "userId": 40,
    "id_post": 28,
    "date": "01-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "hasPromo": true,
    "discount": 0.25
}
```
Over Date (OverActualDateException)
```
{
    "userId": 4,
    "id_post": 28,
    "date": "01-06-2022",
    "detail": {
        "product_id": 1,
        "productName": "Silla Gamer",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
    "hasPromo": true,
    "discount": 0.25
}
```

#### * 0011 (Get the amount of promotional products for a given seller):

Request Type -> `Get`

URL          -> `http://localhost:8080/products/{userId}/countPromo`

Example      -> `http://localhost:8080/products/4/countPromo`

Exceptions:

  -> if you put an unknown `user id` should throw `UserNotFoundException`
  
Payload      -> `Not required`

#### * 0012 (Get a list of all promotional products from a certain seller):

Request Type -> `Get`

URL          -> `http://localhost:8080/products/{userId}/list`

Example      -> `http://localhost:8080/products/4/list`

Exceptions:
  -> if you put an unknown `user id` should throw `UserNotFoundException`
  
Payload      -> `Not required`

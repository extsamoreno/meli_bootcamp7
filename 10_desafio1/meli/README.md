# Social Meli



## EndPoints para su utilización


#### POST http://localhost:8080/user/{userId}/follow/{userIdToFollow}
  - userId follow to userIdToFollow
```json
 {} 
 ```
#### GET http://localhost:8080/user/{{userId}}/followers/list/
  - count followers to userId

#### GET http://localhost:8080/user/{userId}/followers/count/
  - count followers to userId

#### GET http://localhost:8080/user/{userId}/followers/list/
  - follower list to userId

#### GET http://localhost:8080/user/{userId}/follow/list/
  - follow list to userId

#### GET http://localhost:8080/user//{userId}/unfollow/{userIdToUnFollow}/
 - userId unfollow to userIdToUnFollow



#### POST http://localhost:8080/product/newpost/

  - new Publications
  Body :
  ```json
  {
  "id":2,
  "user":2,
  "date":"2021-06-05",
  "products":{
    "id":1,
    "name":"mouse",
    "type":" ",
    "brand":" ",
    "color":"red",
    "notes":" "
  },
  "category":{
    "name":"informatica"
  },
  "price": 2000,
  "hasPromo": true,
  "discount": 10
}
 ```


#### GET http://localhost:8080/product/followed/{userId}/list/
  - followed list order to userId

#### GET http://localhost:8080/product/{userId}/countPromo/
  - Count promo by User



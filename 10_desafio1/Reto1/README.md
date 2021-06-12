# README

![https://www.unipymes.com/wp-content/uploads/2016/09/MercadoLibre.png](https://www.unipymes.com/wp-content/uploads/2016/09/MercadoLibre.png)

# Hello, I’m Nicoll, and Its my first challenger in Meli!

![https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif](https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif)

### Description:

SocialMeli is a proyect, where the users can follow the favorites sellers and realize all new products

### Observations:

**In this proyect use the same User Object by buyer and seller, because I think the buyer also can sell, and seller also can buy.**

**You can see the javaDoc on
`10_desafio1/Reto1/JavaDoc/allpackages-index.html`**
### Users:

This user are by default

```
id : 1569, name : "Construcciones SAS" 
id : 1570, name : "Mega SAS" 
id : 1235, name : "Edilberto Suarez"
id : 1236, name : "Jenny Angarita"
```

### Create new users

**`GET`**[localhost:8080/users/create](http://localhost:8080/users/create)

**Example:**

```jsx
{
    "name" : "nicoll"
}
```

**Output:**
```
User created nicoll id: 1571
```

# Requirements API rest:

## **Follow to user**

**`POST`** /users/{userId}/follow/{userIdToFollow}

**Example:**

[localhost:8080/users/1235/follow/1570](localhost:8080/users/1570/followers/count/)

**Output**:

```jsx
Following to Mega SAS 
```

### Exceptions

- `UserIdNotFoundException`
- `SameIdException`
- `UserAlreadyFollowException`

## Unf**ollow to user**

**`POST`** /users/{userId}/unfollow/{userIdToUnfollow}

**Example:**

[localhost:8080/users/1235/unfollow/1570](http://localhost:8080/users/1235/unfollow/1570)

**Output**:

```jsx
Has unfollow to Mega SAS
```

### Exceptions

- `UserIdNotFoundException`
- `SameIdException`
- `UserNotFollowException`

## Count how many followers user has

**`GET`** /users/{userId}/followers/count/

**Example:**

[localhost:8080/users/1570/followers/count/](http://localhost:8080/users/1570/followers/count/)

**Output**:

```jsx
{
    "id": 1570,
    "name": "Mega SAS",
    "followers_count": 1
}
```

### Exceptions

- `UserIdNotFoundException`

## List followers

**`GET`** /users/{userId}/followers/list

Default order ascendent

**Example:**

[localhost:8080/users/1570/followers/list?order=name_asc](http://localhost:8080/users/1570/followers/list?order=name_asc)

**Output**:

```jsx
{
    "userId": 1570,
    "userName": "Mega SAS",
    "followers": [
        {
            "id": 1235,
            "name": "Edilberto Suarez"
        },
        {
            "id": 1236,
            "name": "Jenny Angarita"
        }
    ]
}
```

### Exceptions

- `UserIdNotFoundException`
- `OrderNotFoundException`

## List followed

**`GET`** /users/{userId}/followed/list

Default order ascendent

**Example:**

[localhost:8080/users/1235/followed/list?order=name_desc](http://localhost:8080/users/1235/followed/list?order=name_desc)

**Output**:

```jsx
"userId": 1235,
    "userName": "Edilberto Suarez",
    "followed": [
        {
            "id": 1570,
            "name": "Mega SAS"
        }
    ]
}
```

### Exceptions

- `UserIdNotFoundException`
- `OrderNotFoundException`

## Create new post and promo post

`POST` localhost:8080/products/newpost

Id must be **unique** and you can use the same endpoint to create promo post

**Example post:**

```jsx
{
        "userId": 1570,
        "id_post" : 13,
        "date" : "27-05-2021",
        "detail" :
        { 
        "product_id" : 10,
        "productName" : "Silla Gamer Normal",
        "type" : "Gamer",
        "brand" : "Racer",
        "color" : "Red &amp; Black",
        "notes" : "Special Edition"
        },
        "category" : 100,
        "price" : 1500.50
        
}
```

**Example promo post:**

`POST` localhost:8080/products/newpromopost

```jsx
{
    "userId": 1570,
    "id_post" : 31, 
	    "date" : "28-05-2021",
    "detail" :
        { "product_id" : 1,
          "productName" : "Silla Gamer Promo",
          "type" : "Gamer",
          "brand" : "Racer",  
          "color" : "Red &amp; Black",
          "notes" :  "Special Edition"
        },
        "category" : "700",
        "price" : 1500.50,
        "hasPromo": true,
        "discount": 0.25
}
```

**Output**:

`The post Silla Gamer Normal was created`

`The post Silla Gamer Promo was created`

### Exceptions

- `UserIdNotFoundException`
- `DuplicatedPostException`
- `DateNotExistException`

## List products that user follow

**`GET`** /products/followed/{userId}/list

Default order ascendent

**Example:**

[localhost:8080/products/followed/1235/list?order=date_desc](http://localhost:8080/products/followed/1235/list?order=date_desc)

**Output:**

```jsx

    "userId": 1235,
    "posts": [
        {
            "id_post": 13,
            "date": "27-05-2021",
            "detail": {
                "product_id": 10,
                "productName": "Silla Gamer Normal",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red &amp; Black",
                "notes": "Special Edition"
            },
            "category": 100,
            "price": 1500.5
        },
        {
            "id_post": 31,
            "date": "27-05-2021",
            "detail": {
                "product_id": 1,
                "productName": "Silla Gamer Promo",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red &amp; Black",
                "notes": "Special Edition"
            },
            "category": 700,
            "price": 1500.5,
            "hasPromo": true,
            "discount": 0.25
        }
    ]
}
```

### Exceptions

- `UserIdNotFoundException`

## Count product promo that the seller has

**`GET`** /products/{userId}/countPromo/

Default order ascendent

**Example:**

[localhost:8080/products/1570/countPromo/](http://localhost:8080/products/1570/countPromo/)

**Output:**

```jsx
{
    "userId": 1570,
    "userName": "Mega SAS",
    "promoproducts_count": 2
}
```

### Exceptions

- `UserIdNotFoundException`

## Product promo by user

**`GET`** /products/{userId}/list

**Example:**

localhost:8080/products/1570/list/

**Output:**

```jsx
{
    "id": 1570,
    "name": "Mega SAS",
    "posts": [
        [
            {
                "id_post": 31,
                "date": "28-05-2021",
                "detail": {
                    "product_id": 1,
                    "productName": "Silla Gamer Promo",
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red &amp; Black",
                    "notes": "Special Edition"
                },
                "category": 700,
                "price": 1500.5,
                "hasPromo": true,
                "discount": 0.25
            },
            {
                "id_post": 30,
                "date": "28-05-2021",
                "detail": {
                    "product_id": 1,
                    "productName": "Silla Gamer Promo",
                    "type": "Gamer",
                    "brand": "Racer",
                    "color": "Red &amp; Black",
                    "notes": "Special Edition"
                },
                "category": 700,
                "price": 1500.5,
                "hasPromo": true,
                "discount": 0.25
            }
        ]
    ]
}
```

### Exceptions

- `UserIdNotFoundException`

# Glossary exception

- `UserIdNotFoundException` User don't exist in database
- `SameIdException` UserId is equals to UserIdToFollow
- `UserAlreadyFollowException` User already follow
- `OrderNotFoundException` Order used is not correct
- `DuplicatedPostException` Post already exist
- `DateNotExistException` Date is after today date
- `UserNotFollowException` User not follow the seller or other user

Thank You for taking the time to view my proyect 😄

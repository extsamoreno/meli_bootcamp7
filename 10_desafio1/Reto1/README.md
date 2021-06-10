# README

![https://www.unipymes.com/wp-content/uploads/2016/09/MercadoLibre.png](https://www.unipymes.com/wp-content/uploads/2016/09/MercadoLibre.png)

# Hello, I’m Nicoll, and Its my first challenger in Meli!

![https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif](https://raw.githubusercontent.com/MartinHeinz/MartinHeinz/master/wave.gif)

### Description:

SocialMeli is a proyect, where the users can follow the favorites sellers and realize all new products

### Observations:

**In this proyect use the same User Object by buyer and seller, because I think the buyer also can sell, and seller also can buy.**

### Users:

This user are by default

```
id : 1569, name : "Construcciones SAS" 
id : 1570, name : "Mega SAS" 
id : 1235, name : "Edilberto Suarez"
id : 1236, name : "Jenny Angarita"
```

# Requirements API rest:

## **Follow a user**

**POST** /users/{userId}/follow/{userIdToFollow}

**Example:**

[localhost:8080/users/1235/follow/1570](localhost:8080/users/1570/followers/count/)

**Output**:

```jsx
Following to Mega SAS 
```

### Exceptions

- `UserIdNotFoundException` User dont exist in database
- `SameIdException` UserId is equals to UserIdToFollow
- `UserAlreadyFollowException` User already follow

## Count how many followers user has

**GET** /users/{userId}/followers/count/

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

- `UserIdNotFoundException` User dont exist in database

Thank You for taking the time to view my proyect 😄
# Challenge of Spring

Requeriments of the system:

# US 0001: 

Be able to perform the action of following a certain seller

| METHOD | SIGN |
| :--------: | :--------: |
| POST | /users/{userId}/follow/{userIdToFollow} |
| Example | /users/1235/follow/1569 |
| Correct Response | Status Code 200 |
| Error Response | Status Code 400 |

### Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies the current user |
| userIdToFollow | int | Number that identifies the user to follow |

---

# US 0002: 

Obtain the result of the number of users who follow a certain seller

| METHOD | SIGN |
| :---: | :---: |
| GET | /users/{userId}/followers/count/ |
| Example | /users/1569/followers/count/ |
| Response |
 ```json
{
   "userId": 1569,
   "userName": "seller1",
   "followersCount": 35
} 
```


### Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies the current user |

----

# US 0003:

Get a list of all users who follow a certain seller

| METHOD | SIGN |
| :---: | :---: |
| GET | /users/{UserID}/followers/list |
| Example | /users/1569/followers/list |
| Response |

```json
{
	"userId": 1569,
    "userName": "seller1",
    "followers": [
        {
            "userId": 4698,
            "userName": "user1"
        },
        {
            "userId": 1536,
            "userName": "user2"
        },
        {
            "userId": 2236,
            "userName": "user3"
        }
    ]
}
```

### Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies the current user |

-----

# US 0004: 

Get a list of all the sellers that a certain user follows

| METHOD | SIGN |
| :---: | :---: |
| GET | /users/{UserID}/followed/list |
| Example | /users/4698/followed/list |
| Response |

```json
{
	"userId": 4698,
    "userName": "user1",
    "followed": [
        {
            "userId": 1596,
            "userName": "seller1"
        },
        {
            "userId": 6932,
            "userName": "seller2"
        },
        {
            "userId": 6631,
            "userName": "seller3"
        }
    ]
}
```

### Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies the current user |

------

# US 0005:
Add a new post

| METHOD | SIGN |
| :---: | :---: |
| POST | /products/newpost |
| PAYLOAD |

```json
{
    "userId": 1235,
   	"postId": 18,
    "date": "29-04-2021",
    "detail": {
        "productId": 1,
        "productName": "Gamer Chair",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category": 100,
    "price": 1500.50,
}
```
| | |
| --- | --- |
| Correct Response | Status Code 200 |
| Error Response | Status Code 400 |

### Details:

| Field | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies each user |
| postId | int | Identification number of each of the publications |
| date | Date | Publication date (dd-mm-yyyy) |
| productId | int | Identification number of each of the products associated with a publication |
| productName | String | Character string representing the name of a product |
| type | String | Character string representing the type of a product |
| brand | String | Character string representing the brand of a product |
| color | String | Character string representing the color of a product |
| notes | String | String of characters to place notes or observations of a product |
| category | int | Identifier used to know the category to which a product belongs |
| price | double | Price of the product |

----

# US 0006:
Obtain a list of the publications made by the sellers that a user follows in the last two weeks 

| METHOD | SIGN |
| :---: | :---: |
| GET | /products/followed/{userId}/list |
| Example | /products/followed/4698/list |
| RESPONSE |

```json
{
    "userId": 4698,
   	"posts": [
   		{
   		    "postId": 32,
   		    "date": "01-05-2021",
   		    "detail": {
                    "product_id": 62,
   			        "productName": "Headset RGB",
               	    "type": "Gamer",
              	    "brand" : "Razer",
              	    "color" : "Green with RGB",
              	    "notes" : "Without batery"
           	},
   		    "category" : 120,
   		    "price" : 2800.69,
   		},
        {
   		    "postId": 18,
   		    "date": "29-04-2021",
   		    "detail": {
                    "product_id": 1,
   			        "productName": "Gamer chair",
              	    "type": "Gamer",
              	    "brand": "Racer",
              	    "color": "Red & Black",
              	    "notes": "Special Edition"
           	},
   		    "category": 100,
   		    "price": 15000.50,
   		}
   	]   
}
```

### Filters / Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies the current user |

----

# US 0007:
Be able to perform the unfollow action

| METHOD | SIGN |
| :---: | :---: |
| POST | /users/{userId}/unfollow/{userIdToUnfollow} |
| Example | /users/1569/unfollow/1235 |


### Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies the current user |
| userIdToUnfollow | int | Number that identifies the user to unfollow |

----
# US 0008:
Ascending and descending alphabetical ordering

| METHOD | SIGN |
| :---: | :---: |
| GET | /users/{UserID}/followers/list|
| Example  | /users/3928/followers/list?order=name_asc |
| GET | /users/{UserID}/followed/list |
| Example | /users/5312/followed/list?order=name_desc |

### Filters:

| Order | Type | Description |
| :--- | :---: | :--- |
| alphabetical | ascending | name_asc |
| alphabetical | descending | name_desc |

----
# US 0009:
Sort by ascending and descending date

| METHOD | SIGN |
| :---: | :---: |
| GET | /products/followed/{userId}/list |
| Example | /products/followed/1513/list?order=date_asc |



### Filters:

| Order | Type | Description |
| :--- | :---: | :--- |
| Date | ascending | date_asc |
| Date | descending | date_desc |

------


## Extra Bonus
# US 0010:

Carry out the publication of a new promotional product

| METHOD | SIGN |
| :---: | :---: |
| POST | /products/newpromopost |
| PAYLOAD |

```json
{
    "userId": 1569,
   	"postId": 18,
    "date": "29-04-2021",
    "detail": {
        "productId": 1,
        "productName": "Gamer chair",
        "type": "Gamer",
        "brand": "Racer",
        "color": "Red & Black",
        "notes": "Special Edition"
    },
    "category" : 100,
    "price" : 1500.50,
    "hasPromo": true,
    "discount": 0.25
}
```
| | |
| :---: | :---:|
| Correct Response | Status Code |
| Error Response | Status Code 400 |

### Details:

| Field | Type | Description |
| :--- | :---: | :--- |
| userId | int | Number that identifies each user |
| postId | int | Number that identifies each post |
| date | Date | Publication date (dd-mm-yyyy) |
| productId | int | Identification number of each of the products associated with a publication |
| productName | String | Character string representing the name of a product |
| type | String | Character string representing the type of a product |
| brand | String | Character string representing the brand of a product |
| color | String | Character string representing the color of a product |
| notes | String | String of characters to place notes or observations of a product |
| category | int | Identifier used to know the category to which a product belongs |
| price | double | Price of the product |
| hasPromo | boolean | determines if a product is on promotion or not |
| discount | double | set the discount amount |

----
# US 0011:
Get the number of promotional products from a specific seller

| METHOD | SIGN |
| :---: | :---: |
| GET | /products/{userId}/countPromo/ |
| Response |

```json
{  
   "userId" : 1569,
   "userName": "seller1",
   "countPromos": 23
}
```

### Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | number that identifies each user |

----

# US 0012:

Get a list of all promotional products from a specific seller

| METHOD | SIGN |
| :---: | :---: |
| GET | /products/{userId}/list/ |
| Response |

```json
{   	 
    "userId": 1569,
    "userName": "seller1",
    "posts": [
        {
         	"postId": 18,
         	"date": "29-04-2021",
         	"detail": {
                "productId": 1,
              	"productName": "Gamer chair",
              	"type": "Gamer",
              	"brand": "Racer",
              	"color": "Red & Black",
              	"notes": "Special Edition"
           	},
         	"category": 100,
         	"price": 15000.50,
         	"hasPromo": true,
         	"discount": 0.25
        },
        {
         	"postId": 32,
         	"date": "01-05-2021",
         	"detail": {
                "productId": 62,
              	"productName": "Headset RGB",
              	"type": "Gamer",
              	"brand": "Razer",
              	"color": "Green with RGB",
              	"notes": "Without batery"
           	},
         	"category": 120,
         	"price": 2800.69,
         	"hasPromo": true,
         	"discount": 0.10
        	}
     	]   
}
```

### Params:

| Params | Type | Description |
| :--- | :---: | :--- |
| userId | int | number that identifies each user |
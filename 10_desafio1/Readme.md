# "SOCIAL MELI"

### Reference Documentation

* To get started, clone the repository into your IDEA of preference.

##Important
In the resources folder there is a json file to import to the posman where you have all the endpoint queries


### Guides

Next I will mention the "endpoints" developed, their functions and how to test them in case there are problems with the posman file.

###Aclaration

In the user.json file are all the users and sellers.
From userId 1 to userId 5, they are sellers, and from userId 6 to userId 9 they are users


###1ts Endpoint
Allows a user(userId) to follow a seller/user(UserIdToFollow).

@PostMapping("/{userId}/follow/{userIdToFollow}")

* Posman:
  localhost:8080/users/9/follow/2
  localhost:8080/users/8/follow/2
  localhost:8080/users/6/follow/4
  localhost:8080/users/6/follow/2
  
  
* Response:
  Status Code 200 (todo OK)
  Status Code 400 (Bad Request)

###2nd Endpoint
Allows you to know the number of users who follow a seller(userId).

@GetMapping("/{userId}/followers/count")

* Posman:
  
    localhost:8080/users/2/followers/count
    
* Response
  
      {
      "userId": 2,
      "userName": "andres david",
      "followers_count": 3,
      "isSeller": 1
      }

it will only return value in the "followers_count" field if it previously ran on endpoint 1 for example:

    localhost: 8080 / users / 9 / follow / 2
    
    localhost: 8080 / users / 8 / follow / 2
    
    localhost: 8080 / users / 6 / follow / 2


###3rd Endpoint

Lets you know a list of users who follow a seller(userId). Optionally you can add a criterion of order name_asc or name_desc

@GetMapping("/{userID}/followers/list")

* Posman:
  
    localhost:8080/users/2/followers/list
* Response:
  
          {
      "userId": 2,
      "userName": "andres david",
      "followMeList": [
              {
              "userId": 9,
              "userName": "rosa buyatti",
              "isSeller": 0
              },
              {
              "userId": 8,
              "userName": "belen cancian",
              "isSeller": 0
              },
              {
              "userId": 6,
              "userName": "fiorella jaime",
              "isSeller": 0
              }
      ],
      "isSeller": 1
      }

Remember to run this in endpoint 1:

    localhost: 8080 / users / 9 / follow / 2
    
    localhost: 8080 / users / 8 / follow / 2
    
    localhost: 8080 / users / 6 / follow / 2

* Aclaration
  
  Can be sorted as follows

* Posman

    localhost:8080/users/2/followers/list?order=name_desc
  
    localhost:8080/users/2/followers/list?order=name_asc

* Example:

localhost:8080/users/2/followers/list?order=name_desc

Response:

    {
    "userId": 2,
    "userName": "andres david",
    "followMeList": [
        {
            "userId": 9,
            "userName": "rosa buyatti",
            "isSeller": 0
        },
        {
            "userId": 6,
            "userName": "fiorella jaime",
            "isSeller": 0
        },
        {
            "userId": 8,
            "userName": "belen cancian",
            "isSeller": 0
        }
    ],
    "isSeller": 1
    }

* Example:

  localhost:8080/users/2/followers/list?order=name_asc

* Response:

      {
      "userId": 2,
      "userName": "andres david",
      "followMeList": [
            {
            "userId": 8,
            "userName": "belen cancian",
            "isSeller": 0
            },
            {
            "userId": 6,
            "userName": "fiorella jaime",
            "isSeller": 0
            },
            {
            "userId": 9,
            "userName": "rosa buyatti",
            "isSeller": 0
            }
      ],
      "isSeller": 1
      }

###4th Endpoint

It allows you to know a list of sellers that a user(userId) follows. Optionally you can add a criterion of order name_asc or name_desc

@GetMapping("/{userId}/followed/list")

* Posman:

  localhost:8080/users/6/followed/list
* Response:

        {
        "userId": 6,
        "userName": "fiorella jaime",
        "followList": [
                    {
                    "userId": 4,
                    "userName": "laura martinez",
                    "isSeller": 1
                    },
                    {
                    "userId": 2,
                    "userName": "andres david",
                    "isSeller": 1
                    }
        ],
        "isSeller": 0
        }

if in endpoint 1 you execute:

    localhost:8080/users/6/follow/4

    localhost:8080/users/6/follow/2


* Aclaration

  Can be sorted as follows

execute:

localhost:8080/users/6/followed/list?order=name_asc

response:

        {
        "userId": 6,
        "userName": "fiorella jaime",
        "followList": [
                    {
                    "userId": 2,
                    "userName": "andres david",
                    "isSeller": 1
                    },
                    {
                    "userId": 4,
                    "userName": "laura martinez",
                    "isSeller": 1
                    }
        ],
        "isSeller": 0
        }

execute:

localhost:8080/users/6/followed/list?order=name_desc

response:

    {
    "userId": 6,
    "userName": "fiorella jaime",
    "followList": [
                {
                "userId": 4,
                "userName": "laura martinez",
                "isSeller": 1
                },
                {
                "userId": 2,
                "userName": "andres david",
                "isSeller": 1
                }
    ],
    "isSeller": 0
    }



###5th Endpoint
 
allows a user/seller(userId) to unfollow a seller(userIdToUnfollow)

@PostMapping("/{userId}/unfollow/{userIdToUnfollow}")

* Posman
  
  localhost:8080/users/8/unfollow/2

###6th Endpoint

Allows to register a new post.

@PostMapping("/newpost")

* Posman:

  localhost:8080/products/newpost

*Payload
  
Examples:
####1


    {
    "userId": 2,
    "id_post" : 12,
    "date" : "02-06-2021",
    "detail" :{
          "product_id" : 1,
          "productName" : "Silla",
          "type" : "Ergonomica",
          "brand" : "x",
          "color" : "x",
          "notes" : "x"
    },
    "category" : 300,
    "price" : 2000.50
    }


####2


    {
    "userId": 2,
    "id_post" : 13,
    "date" : "01-06-2021",
    "detail" :{
          "product_id" : 1,
          "productName" : "Silla Gamer",
          "type" : "Gamer",
          "brand" : "Racer",
          "color" : "Red & Black",
          "notes" : "Special Edition"
    },
    "category" : 100,
    "price" : 1500.50
    }
####3
      {
      "userId": 2,
      "id_post" : 14,
      "date" : "07-06-2021",
      "detail" :{
            "product_id" : 1,
            "productName" : "Mesa",
            "type" : "x",
            "brand" : "x",
            "color" : "x",
            "notes" : "x"
      },
      "category" : 200,
      "price" : 2200.50
      }


###7th Endpoint
allows you to get posts up to two weeks old from sellers that a particular user(userId) follows.

@GetMapping("/followed/{userId}/list")

* Posman:
  
  localhost:8080/products/followed/6/list

* Response


    {
    "userId": 6,
    "posts": [
    {
    "id_post": 12,
    "date": "02-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Silla",
        "type": "Ergonomica",
        "brand": "x",
        "color": "x",
        "notes": "x"
    },
    "category": 300,
    "price": 2000.5
    },
    {
    "id_post": 13,
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
    "price": 1500.5
    },
    {
    "id_post": 14,
    "date": "07-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Mesa",
        "type": "x",
        "brand": "x",
        "color": "x",
        "notes": "x"
    },
    "category": 200,
    "price": 2200.5
    }
    ]
    }

You will get this result if you previously ran the following peyloads on endpoint 6:

* Aclaration

  Can be sorted as follows

execute:

localhost:8080/products/followed/6/list?order=name_asc

*Response

      {
    "userId": 6,
    "posts": [
        {
            "id_post": 13,
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
            "price": 1500.5
        },
        {
            "id_post": 12,
            "date": "02-06-2021",
            "detail": {
                "product_id": 1,
                "productName": "Silla",
                "type": "Ergonomica",
                "brand": "x",
                "color": "x",
                "notes": "x"
            },
            "category": 300,
            "price": 2000.5
        },
        {
            "id_post": 14,
            "date": "07-06-2021",
            "detail": {
                "product_id": 1,
                "productName": "Mesa",
                "type": "x",
                "brand": "x",
                "color": "x",
                "notes": "x"
            },
            "category": 200,
            "price": 2200.5
        }
    ]
    }


execute:

localhost:8080/products/followed/6/list?order=name_desc

*Response

    {
    "userId": 6,
    "posts": [
    {
    "id_post": 14,
    "date": "07-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Mesa",
        "type": "x",
        "brand": "x",
        "color": "x",
        "notes": "x"
    },
    "category": 200,
    "price": 2200.5
    },
    {
    "id_post": 12,
    "date": "02-06-2021",
    "detail": {
        "product_id": 1,
        "productName": "Silla",
        "type": "Ergonomica",
        "brand": "x",
        "color": "x",
        "notes": "x"
    },
    "category": 300,
    "price": 2000.5
    },
    {
    "id_post": 13,
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
    "price": 1500.5
    }
    ]
    }


##Decisions:

I only have one user class because at first I didn't need to have to separate it, but then I had to differentiate them, so I added an attribute to differentiate them.
At first, to differentiate, I validated that the string "user" or the string "seller" exists in the name, but it didn't seem correct to me, so I changed it and wasted a lot of time correcting it, so I couldn't make the bonus.




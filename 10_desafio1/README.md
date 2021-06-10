# REST API - Social Meli application

## Install

    Open pom.xml with your Favourite IDE - I recomended IntelliJ IDEA

## Run the app

    Run 'SpringChallengeApplication' 
    with command + R in Mac

# REST API

The REST API to the example app is described below.

## US 0001 

### Request

`POST /users/1/follow/4`

### Response

    Date: Thu, 10 Jun 2021 16:19:44 GMT
    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 0

    1

## US 0002

### Request

`GET /users/2/followers/count/`

### Response

    Date: Thu, 10 Jun 2021 16:21:23 GMT
    Status: 200 OK
    Connection: keep-alive
    Content-Type: application/json
    Content-Length: 36

    {
    "userID": 2,
    "userName": "Eduardo",
    "seller": false,
    "followers_count": 1
    }


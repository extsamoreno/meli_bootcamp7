# Diego Prieto's repository - Wave7
---
Inside this repository there's the different activities developed during bootcamp.

---
## Challenge #1

It has the following services:

Service                 | Method.   |EndPoint
------------------------|-----------|-----------
Follow seller           |Post       |/users/{userId}/follow/{userIdToFollow}
Count Followers         |Get        |/users/{userId}/followers/count/
Followers list          |Get        |/users/{UserID}/followers/list
Sellers Followed list   |Get        |/users/{UserID}/followed/list
New Post                |Post       |/products/newpost
Get Posts list from followed <br>sellers|Get      |/products/followed/{userId}/list
Unfollow seller         |Post       |/users/{userId}/unfollow/{userIdToUnfollow}
New product in promotion|Post       |/products/newpromopost
Count products in promotion <br> from sellers  |Get      |/products/{userId}/countPromo/
List of products in promotion <br> from sellers |Get      |/products/{userId}/list/

<br>
<br>
The project has three json that emulates the information from database:

* user.json: Has the information from the users.
* posts.json: Has the information from posts made by sellers.
* follow.json: Has the relation between user and ids that the user follows.

<br>
<br>

__There's a Postman collection to make the tests of each service.__






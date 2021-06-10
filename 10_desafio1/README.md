## Meli Challenge 1 - SocialMeli

Software Developer: Diego Banfi

### General Considerations

- By way of database emulation, it has been chosen to work with static Maps
- To recreate pre-existing data in these data storage sources, there is the possibility to send a POST request to generate a context scenario. This Context generates users and posts (with and without promo), with the
  following IDs, which cannot be entered in duplicate:
  
  ```
  Users:
  userId : 1, userName : "user_1" 
  userId : 2, userName : "user_2"
  userId : 3, userName : "user_3"
  userId : 4, userName : "a_user_4"
  userId : 5, userName : "z_user_5"
  userId : 6, userName : "x_user_6"
  userId : 7, userName : "b_user_7"
  userId : 8, userName : "y_user_8"
  userId : 1547, userName : "m_user_1547"
  userId : 6684, userName : "m_user_6684"
  ```
  
  ```
  Posts:
  postId: 1, userId: 1 
  postId: 2, userId: 1 
  postId: 3, userId: 1 
  postId: 4, userId: 1 
  postId: 5, userId: 1, hasPromo: true 
  postId: 6, userId: 1, hasPromo: true 
  postId: 7, userId: 1, hasPromo: true 
  postId: 8, userId: 1, hasPromo: true 
  postId: 9, userId: 2 
  postId: 10, userId: 2 
  postId: 11, userId: 2 
  postId: 12, userId: 2 
  postId: 13, userId: 2, hasPromo: true 
  postId: 14, userId: 2, hasPromo: true 
  postId: 15, userId: 2, hasPromo: true
    ```

  This context is reinitialized each time this method is called. (for more information see Context class, located in Context package).
  
  To load de Context Scenario:

  ```jsx
  method: POST
  path: /context/loadContext
  ```

- Based on the requirements (specified below), and considering MELI's business characteristics, it has been chosen not
  to differentiate between a seller and a buyer. This is because, due to the very characteristics of the platform, a
  buyer can be simultaneously a seller and vice versa, which is why it has been chosen not to make any difference
  between them.
- To facilitate the tests on the API, the following is the link to a Postman Collection, with all the corresponding
  requests: https://www.getpostman.com/collections/e928b4a5ebe4cf9c95bc

### Requirements

1. To be able to carry out the action of “Follow” a certain seller
2. Obtain the result of the number of users who follow a certain seller
3. Get a list of all users who follow a certain seller (Who follows me?)
4. Get a list of all the sellers that a certain user follows (Who am I following?)
5. Register a new post
6. Obtain a list of the publications made by the sellers that a user follows in the last two weeks (for this, take into
   account ordering by date, most recent publications first).
7. To be able to carry out the action of “Unfollow” (stop following) a certain seller.

On the other hand, since a good user experience is intended with respect to the form of presentation of the results of
each query, it is necessary that they can be ordered by any of the following criteria:

8. Alphabetical Ascending and Descending
9. Ascending and Descending Date

A functional analyst carried out the survey of the functional technical requirements and has provided the documentation
that is cited below to take into account when carrying out the corresponding development:
https://drive.google.com/file/d/1iPdb8VVgxi4SZtWNqwHo_lo-quODgi3i/view?usp=sharing

Bonus SocialMeli will also allow sellers to publish new products with exclusive special offers or discounts for their
followers for a certain period of time. For this, it proposes the following requirements:

10. Carry out the publication of a new promotional product.
11. Obtain the quantity of promotional products from a specific seller
12. Obtain a list of all the promotional products of a specific seller






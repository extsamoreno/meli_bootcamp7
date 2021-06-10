# Bootcamp Backend Java Spring Challenge

## IMPLEMENTATION COMMENTS

* For convenience, use in-memory persistence as the database.
* Separate into 2 repositories, one for users and one for products.
* I do not differentiate between users and sellers, they all belong to the user class.
* I do not handle the id of the publications and products, I assume that the values received in the body are valid.
* When saving a publication if there is already one with that id I throw an exception.
* I assume only one product per post.
* I assume that the product lives only inside the post.
* I don't have a repository for products only.
* For the bonus I decided not to modify the answer from the above endpoints, because I think it's best to check first
  with the consumer of the API, before modifying the response body
* When the application runs, the database is initialized with a set of values (see bootstrap and repositories)

### [POSTMAN COLLECTION](src/main/resources/Sosa_postman_collection.json)

## API REQUIREMENTS

### US 0001
To be able to carry out the action of Follow a certain seller

### US 0002
Obtain the result of the number of users who follow a certain seller

### US 0003
Get a list of all users who follow a certain seller (Who follows me?)

### US 0004
Obtain a list of all the sellers that a certain user follows (Who am I following?)

### US 0005
Register a new publication.

### US 0006 
Obtain a list of the publications made by sellers that a user follows in the last two weeks (for this take into account ordering by date, latest posts first).

### US 0007 
To be able to carry out the action of “Unfollow” a certain seller.

### US 0008
Alphabetical Ascending and Descending

### US 0009
Ascending and Descending Date

## BONUS

### US 0010
Carry out the publication of a new promotional product.

### US 0011
Obtain the quantity of promotional products from a specific seller

### US 0012
Obtain a list of all promotional products of a specific seller


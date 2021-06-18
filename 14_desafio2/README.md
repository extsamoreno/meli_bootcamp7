## Meli Challenge 2 - TuCasita

Software Developer: Diego Banfi

### General Considerations

- By way of database emulation, it has been chosen to work with .json files, which were mapped to Set objects
- These files that serve as information storage sources are districts_database.json and properties_database.json, which are located in the resources package
- In the beginning, this challenge had been focused on thinking about a database containing Properties, whose values were consulted in order to respond to the technical requirements, but then, thinking about it better, it was decided that these requests could be satisfied without the need to consult an entire Property, but simply passing the necessary data to obtain a correct result
- What convinced me to approach it in this way was that, thinking about the business needs of a real estate agency, it is very possible that you want to be able to quote a Property, know its total footage, know how much it costs according to the neighborhood in which it is located, etc., without having to have all the data of that property, or that that property is entered into the Real Estate database.
- Taking into account that the name of the company, the validation messages, etc., are in Spanish, it has been interpreted that this application would be used by Spanish-speaking people, for which it has been chosen to write the code in English, but all interaction with agents external to the application, handle it in Spanish.
- As requested, only the Service and Controller packages have been exclusively tested, obtaining 100% coverage
- To facilitate the tests on the API, the following is the link to a Postman Collection, with all the corresponding
    requests: https://www.getpostman.com/collections/4af70c65fe51b8a57d0f
  
  (If the import of the collection through the link does not work, the collection is also attached in the file "Meli Challenge 2 - TuCasita.postman_collection.json" located in the resources package)

- Inside the resources package, the generated javadoc documentation is also attached

### Requirements
#### Goal
The goal of this challenge is to apply the contents addressed so far during the MeLi's Bootcamp (Git, Java, Spring and Testing), with the main emphasis on validations and types of testing that can be used from a proposed statement, a specification requirements and attached documentation (see testing_challenge_technical_specifications.pdf, located in resources package)

#### Guidelines for activity
The challenge proposed below consists of 2 parts:

- A) Implement validations and different tests to a given scenario: Starting from a known scenario, the different data validation processes and necessary unit test processes must be established.
- B) Bonus: In the event that everything requested in point A is completed and time is still available, this activity can be carried out, which presents a higher level of complexity.


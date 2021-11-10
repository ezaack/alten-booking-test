**ALTEN BOOKING TEST**
***
*IMPORTANT*

As instructed just room 300 will be inserted in DB during startup.

*STACK*

-Java 11;

-Spring Boot to simplify some thins like ORM, Dependency Injection and transaction;

-H2 memory database

-Swagger for API tests and documentation
***

*VALIDATION FRAMEWORK*

Simple but powerfull pattern that alow to create complex validations in a more readable and maintanable way.
That is divided in three layers:

Condition: implements a simple verification that would be an if in a basic validator.

Rule: Receive a group of conditions and a violation message. If all the conditions returns true it will return the
violation message.

Validator: Receive a group of conditions and a group of rules. If all the conditions returns true and there is some
violation message it will throw an Bad Request Exception with this violation messages.
***
*API*

Obs: swagger is configured

POST /booking: Create a new booking

PUT /booking: Update the booking, being possible change all attributes

PATCH /booking: Update just checkIn and checkOut dates, used to re-schedule the booking

DELETE /booking: Cancel the booking by logic deletion

GET /booking/{idBooking}: Return the booking

GET /booking : Return all bookings filteres by room, minimal CheckIn and maximal CheckIn. All parameters thru query.

GET /available-dates: Return all rooms that have availables dates with the list of dates


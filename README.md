# README
To build use:
`mvn package`

To run use:
`./run`

To run unit tests use:
`mvn test`

To run system tests use:
`./cs32-test src/test/system/stars/*.test`

This will give you a barebones REPL, where you can enter text and you will be output at most 5 suggestions sorted alphabetically.

To start the server use:
`./run --gui [--port=<port>]`

## Project Details
* **Project**: Onboarding Project
* **CS Login**: lxu37
* **Time to Complete**: approximately 10-12 hours

## Design Choices
* **Star Class**
  * Represents a Star Object, with fields including the star's unique id, name, x, y, and z coordinates
* **Galaxy Class**
  * Represents a collection / list of Star Objects in the form of an ArrayList
  * I chose to use an ArrayList to store Star Objects due to its mutability, which was helpful when I wanted to add or remove Star objects from the Galaxy
  * Contains methods and helper methods that calculate the k-nearest neighbor algorithm 
    * I also chose to use ArrayLists as intermediate data structures to store distances and Star Ids belonging to the k-nearest neighbors, again, because of its mutability.


## Errors/Bugs
* One potential error to consider is the use of *Collections.sort* to sort the distances from smallest to largest
  * Unaware of the biases that may arise using *Collections.sort* that may cause the stars to be ordered in a non-random way
* There are no prominent bugs in the code, but there are likely potential edge cases or unspecified functionalities (by the user/client) that have not been considered

## Testing
* **StarTest**
    * Test suite for the Star Class
    * _**testSetDistance**_
      * Tests the setDistance method in the Star class to ensure that the distance field of the Star object is correctly populated when the method is called
      * Tests the distance calculation between two 3-dimensional points
      * Tests the Stars constructors
* **GalaxyTest**
    * Test suite for the Galaxy Class
    * Tests the Galaxy constructors 
    * _**testGetNearestKNeighbors**_
      * Tests the getNearestKNeighbors method in the Galaxy Class
      * Tests getKNeighbors method (called inside getNearestKNeighbors) to ensure that getKNeighbors returns an ordered list of Star Ids with length minimum(k, size of Galaxy)
    * _**testGetNearestKNeighborsWithName**_
      * Tests the getNearestKNeighborsWithName method in the Galaxy Class
      * Also tests the getKNeighbors method
      * Tests the searchForStarName method to ensure that given the name of a star that is in the Galaxy, the correct star is returned
    * _**testGetNearestKNeighborsWithWrongName**_
      * Tests the getNearestNeighborsWithName method using a star name that does not match the name of a star in the Galaxy
      



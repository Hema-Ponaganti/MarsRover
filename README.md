Refactorings Methods Used:

Magic numbers :
->The code uses magic numbers such as 0 and 1 to access X and Y coordinates in the list, it would be better to recognize objects in the problem and create them
Ex: Rover is a real object that has x and y coordinates with direction.
Plateau is a real object that has a area in coordinates

Misuse of List:
->The code uses a list to store X and Y coordinates of the rover

Proper naming conventions:
-> Findlocation - can declare a rover class that has rover properties and fields and behaviour like move as methods.
-> Declare a plateu class
    Fields: coordinates
    behavior: check boundaries of rover as it moves
->locationOfRover method can be renamed accordingly.
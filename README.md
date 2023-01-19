

#gpsPacman 
========

This Project focuses on converting gps (lat,lon,alt) points to pixelated points.  
We turn these pixelated points on a 2D image into a "Packman game", where such points represent either "packmen","fruits","ghosts","boxes".  
The objective of the game is for the packmen to "eat" all the fruits on the image in the fastest time possible, concidering their speed and radius of "eating". Every game has a time limit and the player has a score. the score increases when we succesfuly eat a fruit or other packman and decreases when we touch a "box" or get hit by a ghost, in addition we get additional points for the time left. After a certain game was played, we compare the score we get with other scores of other students with the help of a sql database.

#How to play
========
- Type the name of the configuration in the main class
- Go to Insert-->Packman
- Place your packman on the board with mouse
- Go to Play-->Play
- Click on the board and the packman will go in that direction

![alt tag](https://github.com/alexchagan/oopProject4/blob/master/oopProject4/game.jpeg)
- Pink circle: our packman
- Yellow circles: other packmen that steal fruits and you can eat them
- Red circles: ghosts that go after us and descrease our points
- Green circles: fruits

#Objective
========
Eat all the fruits on the gameboard in the fastest time while running away from ghosts and avoiding boxes.

#Relevant Packages & Classes
========
#GUI
========
- MyFrame: This Class represents the GUI of our game. Contain 3 functions:  
Putting our packman on the gameboard by clicking on the mouse.  
Starting the game(making all the objects start moving).  
Moving our packman to direction we click with the mouse.  

- Map: Represents our gameboard display and support the cordinates convertision from GIS to pixels

- Main: Represents the main class of our project. We intialize the GUI and choose the configuration(gameboard).

#Coords
========
- Coords: Contains certain calculations on gps points.

#Database
========
- Statistics: Responsible for getting info from database.
Takes your score and gets the average score of specific configuration from the database and prints both of them.

#Game
========
- Packman: Represents a packman or a ghost.
- Fruit: Represents a fruit.
- Box: Represents a "box", an area that our packman can't go through.
- GameInfo: Contains all the objects of our game and has th

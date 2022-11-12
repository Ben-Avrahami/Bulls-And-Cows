### Features

Bulls and Cows is an old code-breaking mind or paper and pencil game for two or more players, predating the commercially marketed board game Mastermind.
# Bulls And Cows- Java Implementation

[![](https://i.ytimg.com/vi/zH4B5p9NYEY/maxresdefault.jpg)](http://https://i.ytimg.com/vi/zH4B5p9NYEY/maxresdefault.jpg)



**Table of Contents**

[TOC]


How To Play
=============
Bulls and Cows is a 2 player game. One player thinks of a number, while the other player tries to guess it. In this Version the game is only for 1 player, and the computer is randomally chooses a number.

The number to be guessed must be a 4 digit number, using only digits from 1 - 9, each digit atmost once. e.g. 1234 is valid, 0123 is not valid, 9877 is not valid, 9876 is valid.

For every guess that the player makes, he gets 2 values -
the number of bulls and the number of cows.
1 bull means the guess contains and the target number have 1 digit in common, and in the correct position.
1 cow means the guess and the target have 1 digit in common, but not in correct position.

e.g. Let the target be 1234. Guessing 4321 will give 0 bulls and 4 cows. 3241 will give 1 bull and 3 cows. 4 bulls means you have won the game!

###### Done By
Ben Avrahami 
The game was created as an assignment in the course- Advanced Object Orianted Programming with Java (20554) in The Open University Of Israel.



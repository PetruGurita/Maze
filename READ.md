##Description

>Romen and Juliet want to meet in a labrinth. They must meet as soon as possible for the date.
>Both Romeo and Juliet can move in any of the 8 directions (if the map let them).

>The labrinth is represented as a n * m cells map. Romeo's position is represented with
the letter 'R' on map, and Juliet with 'J'. The labrinth's wall are represented with X (they can not pass though it).
>The available moves are represented as white spaces.

##Requirements
Using OOP concepts implement an algorithm that chooses a meeting point at which both 
Romeo and Juliet can arrive at the same time, and requires **minimum steps**.

##Approach

BFS is used in order to calculate the distance between Romeo and Juliet. Once for Juliet and Once for Romeo.
The distances are saved in two arrays: one for Romeo and one for Juliet. If for a specific cell the values in both matrixes 
are the same and the value is minimum then the meeting place is found.
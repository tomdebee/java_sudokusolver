# java_sudokusolver

First attempt at a Java based sudoku solver with commandline GUI.
Currently accepts no arguments and has 100 different sudoku's built into an array it will solve.
It employs a recursive bruteforce algorithm without any optimalisation and should be able to solve any proper sudoku. Time to solve may vary wildly.

In the process of refactoring.


Goal is to have the solver accept a sudoku as string (or array). E.g.:
```
java sudoku 003020600900305001001806400008102900700000008006708200002609500800203009005010300 200080300060070084030500209000105408000000000402706000301007040720040060004010003
```
And return the first possible solution it finds for every sudoku:
```
SOLVED:
4 8 3  9 2 1  6 5 7  
9 6 7  3 4 5  8 2 1  
2 5 1  8 7 6  4 9 3  

5 4 8  1 3 2  9 7 6  
7 2 9  5 6 4  1 3 8  
1 3 6  7 9 8  2 4 5  

3 7 2  6 8 9  5 1 4  
8 1 4  2 5 3  7 6 9  
6 9 5  4 1 7  3 8 2  

1: 71ms

SOLVED: 
2 4 5  9 8 1  3 7 6  
1 6 9  2 7 3  5 8 4  
8 3 7  5 6 4  2 1 9  

9 7 6  1 2 5  4 3 8  
5 1 3  4 9 8  6 2 7  
4 8 2  7 3 6  9 5 1  

3 9 1  6 5 7  8 4 2  
7 2 8  3 4 9  1 6 5  
6 5 4  8 1 2  7 9 3  

2: 8ms


Solved all in: 79 milliseconds
```

# Search algorithms comparison in Finding shortest path in 2D matrix
This project aims to solve the problem of finding shortest path in 2D Matrix using Blind Search and Heuristic Search


## Problem: 
Given a matrix of N*M order (N row, M column). Find the shortest distance from a source cell to a destination cell, traversing through limited cells only. This problem is meant for single source and destination. You can move only **up, down, left and right.** In the matrix, each cell is represented by a character, which is:

*  **S** represents ‘source’

*  **D** represents ‘destination’

* **1** represents cell you can travel

* **0** represents cell you can not travel

## Input format: 
First row is N and M. In the next N rows, each row includes M characters representing the cells.  

## Output format: 
Print out the shortest Distance and Sample of the path.

## For example:
* Input

4 5

S 1 1 0 1

1 0 1 1 1

1 1 1 1 1

1 1 0 1 D

* Output

Shortest Distance = 7

Sample of path:

**S 1 1** 0 1

1 0 **1** 0 1

1 1 **1 1 1**

1 1 0 1 **D**

## Comparison: 
In this project, I am going to solve this problem with:
* blind search algorithms:
  * Breadth-first
  * Uniform-cost
  * Depth-first
  * Depth-limited
  * Iterative deepening
* heuristic search algorithms: 
  * Hill climbing
  * Beam search
  * Best-first search 
  * A* search. 
  
All the algorithm will has been run on the same input and the same computer. The comparison would be provided and the evaluation is based on: *Complete, Time, Space, and Optimal.*


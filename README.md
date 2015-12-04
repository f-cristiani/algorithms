# algorithms
Algorithms implementation in Java. Developed using TDD and Refactoring techniques.

* Counting Inversions
* Sorting: Implemented using a common Sort interface. Template Method pattern [GOF] used in the tests.
  * MergeSort
  * QuickSort
* Randomized Selection: O(n) algorithm to find the kth order statistic (kth smallest number) of an array, using an uniformly distributed random pivot.
* Strongly Connected Components: Implementation of Kosaraju's Two-Pass Algorithm for computing Strongly Connected Components of a Graph with 'n' vertices and 'm' edges in O(n + m) time.
  * Template Method pattern for implementation of reverse and direct GraphWalkers.
  * Constructor Injection for providing the corresponding GraphWalker.
* ShortestPath: Implementation of Dijkstra's shortest-path algorithm from a source vertex to all other vertices in the graph.

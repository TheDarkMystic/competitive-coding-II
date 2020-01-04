package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-26
 */

// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.*;

// This class represents a directed graph using adjacency list
// representation
class BFS {
    /**
     * 1. For Graph as well we will use the Queue for performing the BFS.
     * 2. We will use the boolean[] to keep a track of the nodes because unlike tree during traversal
     *    we might keep moving into the circles by visiting same nodes repeatedly.
     * 3. In our example we are using adjacency List for the Graph Representation.
     *
     */

    // iterative BFS
    public static void BFS(Graph g) {
        System.out.println("Running BFS iteratively");
        Set<Integer> visited= new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        //add root to the stack
        int root = 0;
        queue.add(root);

        while (queue.isEmpty() == false) {
            //pop the node from stack, mark it as visited
            int node = queue.poll();

            //print the traversed node
            System.out.print(" " + node);
            visited.add(node);

            //get the list of neighbour of the current node and them to the stack, if they are not already
            //explored, for further exploration
            LinkedList<Integer> neighbours = g.neighbours[node];

            for (int neighbour : neighbours) {
                if (visited.add(neighbour) == false) {
                    queue.add(neighbour);
                    // mark the neighbour as visited
                    visited.add(neighbour);
                }
            }
        }
    }

    public static void main(String args[]) {
        Graph graph = new Graph(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(3, 4);
        graph.addEdge(2, 3);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(4, 5);

        System.out.println("\nPrinting the Graph :");
        graph.printGraph();

        System.out.println("\n\nFollowing is Depth First Traversal");
        BFS(graph);

    }
}

/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 * https://algorithms.tutorialhorizon.com/breadth-first-searchtraversal-in-a-graph/
 */
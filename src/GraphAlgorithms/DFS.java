package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-20
 */

// Java program to print DFS traversal from a given given graph

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

// This class represents a directed graph using adjacency list
// representation
class DFS {
    /**
     * 1. Use Stack.
     * 2. First add the Starting Node to the Stack.
     * 3. Pop out an element from Stack and add all of its connected nodes to stack.
     * 4. Repeat the above two steps until the Stack is empty.
     * 5. Below is a walk through of the graph above.
     *
     */

    // iterative DFS
    public static void DFSIterative(Graph g) {
        System.out.println("Running DFS iteratively");
        Set<Integer> visited= new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        //add root to the stack
        int root = 0;
        stack.push(root);

        while (stack.isEmpty() == false) {
            //pop the node from stack, mark it as visited
            int node = stack.pop();

            //print the traversed node
            System.out.print(" " + node);
            visited.add(node);

            //get the list of neighbour of the current node and them to the stack, if they are not already
            //explored, for further exploration
            LinkedList<Integer> neighbours = g.neighbours[node];

            for (int neighbour : neighbours) {
                if (visited.contains(neighbour) == false) {
                    stack.push(neighbour);
                    // mark the neighbour as visited
                    visited.add(neighbour);
                }
            }
        }
    }

    //recursive DFS

    public static void DFSRecursive(Graph g) {
        System.out.println("\n\nRunning DFS recursively");
        Set<Integer> visited= new HashSet<>();
        int root = 0;
        DFSRecursiveUtil(g, root, visited);
    }

    public static void DFSRecursiveUtil(Graph g, int node, Set<Integer> visited) {
        //mark the node as visited
        visited.add(node);
        // print the node
        System.out.print(" " + node);
        // explore the neighbours of the node recursively
        LinkedList<Integer> neighbours = g.neighbours[node];
        for (int neighbour : neighbours) {
            if (visited.contains(neighbour) == false) {
                //visited[neighbour]=true;
                DFSRecursiveUtil(g, neighbour, visited);
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
        DFSIterative(graph);
        DFSRecursive(graph);
    }
}



/**
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 * https://algorithms.tutorialhorizon.com/graph-depth-first-traversal/
 */


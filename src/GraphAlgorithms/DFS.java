package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-20
 */

// Java program to print DFS traversal from a given given graph

import java.util.LinkedList;
import java.util.Stack;

// This class represents a directed graph using adjacency list
// representation
class DFS {
    // iterative DFS
    public static void DFSIterative(Graph g) {
        System.out.println("Running DFS iteratively");
        int numOfVertices = g.numOfVertices;
        boolean visited[] = new boolean[numOfVertices];
        Stack<Integer> stack = new Stack<>();

        //add root to the stack
        int root = 0;
        stack.push(root);

        while (stack.isEmpty() == false) {
            //pop the node from stack, mark it as visited
            int node = stack.pop();

            //print the traversed node
            System.out.print(" " + node);
            visited[node] = true;

            //get the list of neighbour of the current node and them to the stack, if they are not already
            //explored, for further exploration
            LinkedList<Integer> neighbours = g.neighbours[node];

            for (int neighbour : neighbours) {
                if (visited[neighbour] == false) {
                    stack.push(neighbour);
                    // mark the neighbour as visited
                    visited[neighbour] = true;
                }
            }
        }
    }

    //recursive DFS

    public static void DFSRecursive(Graph g) {
        System.out.println("\n\nRunning DFS recursively");
        int numOfVertices = g.numOfVertices;
        boolean visited[] = new boolean[numOfVertices];
        int root = 0;
        DFSRecursiveUtil(g, root, visited);
    }

    public static void DFSRecursiveUtil(Graph g, int node, boolean[] visited) {
        //mark the node as visited
        visited[node] = true;
        // print the node
        System.out.print(" " + node);
        // explore the neighbours of the node recursively
        LinkedList<Integer> neighbours = g.neighbours[node];
        for (int neighbour : neighbours) {
            if (visited[neighbour] == false) {
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


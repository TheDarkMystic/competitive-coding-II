package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-26
 */

// Java program to print BFS traversal from a given source vertex.
// BFS(int s) traverses vertices reachable from s.

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
class BFS {


    // prints BFS traversal from a given source s
    public static void BFS(DirectedGraph graph, int s) {
        // Mark all the vertices as not visited(By default
        // set as false)
        int V = graph.getNumOfVertices();
        LinkedList<Integer>[] adj = graph.getEdgeList();
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s] = true;
        queue.add(s);

        while (queue.size() != 0) {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            System.out.print(s + " ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }

    // Driver method to
    public static void main(String args[]) {
        DirectedGraph graph = new DirectedGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");

        BFS(graph, 2);
    }
}

/**
 * https://www.geeksforgeeks.org/breadth-first-search-or-bfs-for-a-graph/
 */
package GraphAlgorithms;

/**
 * @author jakadam on 2019-12-20
 */

// Java program to print DFS traversal from a given given graph

import java.util.Iterator;
import java.util.LinkedList;

// This class represents a directed graph using adjacency list
// representation
class DFS {

    // A function used by DFS
    public static void DFSUtil(int v, boolean visited[], DirectedGraph g) {
        LinkedList<Integer>[] adj = g.getEdgeList();
        // Mark the current node as visited and print it
        visited[v] = true;
        System.out.print(v + " ");

        // Recur for all the vertices adjacent to this vertex
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited, g);
        }
    }

    // The function to do DFS traversal. It uses recursive DFSUtil()
    public static void DFS(DirectedGraph g) {
        int V = g.getNumOfVertices();
        // Mark all the vertices as not visited(set as
        // false by default in java)
        boolean visited[] = new boolean[V];

        // Call the recursive helper function to print DFS traversal
        // starting from all vertices one by one
        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited, g);
    }

    public static void main(String args[]) {
        DirectedGraph graph = new DirectedGraph(4);

        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 2);
        graph.addEdge(2, 0);
        graph.addEdge(2, 3);
        graph.addEdge(3, 3);

        System.out.println("Following is Depth First Traversal");

        DFS(graph);
    }
}



/**
 * https://www.geeksforgeeks.org/depth-first-search-or-dfs-for-a-graph/
 */
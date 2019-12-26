package GraphAlgorithms;

import java.util.LinkedList;

/**
 * @author jakadam on 2019-12-26
 */



class DirectedGraph {
    private int V; // No. of vertices

    // Array of lists for Adjacency List Representation
    private LinkedList<Integer> adj[];

    // Constructor
    DirectedGraph(int v) {
        V = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i)
            adj[i] = new LinkedList();
    }

    //Function to add an edge into the graph
    void addEdge(int v, int w) {
        adj[v].add(w); // Add w to v's list.
    }

    int getNumOfVertices() {
        return V;
    }

    LinkedList<Integer>[] getEdgeList() {
        return adj;
    }

}
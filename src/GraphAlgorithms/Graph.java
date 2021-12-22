package GraphAlgorithms;

import java.util.LinkedList;

/**
 * @author jakadam on 2020-01-01
 */

public class Graph {
    int numOfVertices;
    LinkedList[] neighbours;

    public Graph(int numOfVertices) {
        this.numOfVertices = numOfVertices;
        neighbours = new LinkedList[numOfVertices];

        //initialize the graph with empty neighbour lists for each vertex
        for (int i = 0; i < numOfVertices; i++) {
            neighbours[i] = new LinkedList<>();
        }
    }

    //adds an edge to the graph from source to destination
    public void addEdge(int source, int dest) {
        neighbours[source].addFirst(dest);
    }

    //print the graph
    public void printGraph() {
        for (int i = 0; i < numOfVertices; i++) {
            LinkedList<Integer> neighboursList = neighbours[i];

            //check if the list is empty or not
            if (neighboursList != null && neighboursList.size() != 0) {
                System.out.print("\nThe Node " + i + " is connected to :");
                for (int j = 0; j < neighboursList.size(); j++) {
                    System.out.print(" " + neighboursList.get(j));
                }
            }
        }
    }
}
/*
    https://algorithms.tutorialhorizon.com/graph-implementation-adjacency-list-better-set-2/
 */
package GraphAlgorithms;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

/**
 * @author jakadam on 2020-01-01
 */

/**
 * Topological Sort: A topological sort or topological ordering of a directed graph is a linear
 * ordering of its vertices such that for every directed edge uv from vertex u to vertex v, u comes
 * before v in the ordering. A topological ordering is possible if and only if the graph has no
 * directed cycles, that is, if it is a directed acyclic graph (DAG).
 */
public class TopologicalSort {
    /**
     * Approach:
     *
     * Shall we use Depth First Search?
     *
     * The DFS of the example above will be ‘7 6 4 3 1 0 5 2’ but in topological sort  2 should
     * appear before 1 and 5 should appear before 4. So it might look like that we can use DFS
     * but we cannot use DFS as it is but yes we can modify DFS to get the topological sort.
     *
     * Read about DFS if you need to brush up about it.
     *
     * Modified DFS:
     *
     * Use temporary stack to store the vertex.
     * Maintain a visited [] to keep track of already visited vertices.
     * In DFS we print the vertex and make recursive call to the adjacent vertices but here we will
     * make the recursive call to the adjacent vertices and then push the vertex to stack.
     * Observe closely the previous step, it will ensure that vertex will be pushed to stack only when
     * all of its adjacent vertices (descendants) are pushed into stack.
     * Finally print the stack.
     * For disconnected graph, Iterate through all the vertices, during iteration, at a time consider
     * each vertex as source (if not already visited).
     * Time Complexity: O(V+E)
     */

    public static void topSort(Graph g) {
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> topologicalOrder = new Stack<>();

        //for each node of the graph, call the modified DFS/ topSortUtil and recursively explore all the children
        for (int node = 0; node < g.numOfVertices; node++)
            if (visited.contains(node) == false)
                topSortUtil(g, node, visited, topologicalOrder);

        //print the ans stack
        while (topologicalOrder.isEmpty() == false) {
            System.out.print(topologicalOrder.pop() + " ");
        }
    }

    public static void topSortUtil(Graph g, int node, Set<Integer> visited, Stack<Integer> topologicalOrder) {
        // mark the node as visited
        visited.add(node);

        //explore all its neighbours recursively
        LinkedList<Integer> neighbours = g.neighbours[node];
        for (int neighbour : neighbours) {
            if (visited.contains(neighbour) == false) {
                topSortUtil(g, neighbour, visited, topologicalOrder);
            }
        }
        //add the node to the answer list once all the neighbours have been explored completely
        topologicalOrder.push(node);


    }

    public static void main(String args[]) {
        Graph graph = new Graph(8);
        graph.addEdge(7, 6);
        graph.addEdge(7, 5);
        graph.addEdge(6, 4);
        graph.addEdge(6, 3);
        graph.addEdge(5, 4);
        graph.addEdge(5, 2);
        graph.addEdge(3, 1);
        graph.addEdge(2, 1);
        graph.addEdge(1, 0);


        System.out.println("\nPrinting the Graph :");
        graph.printGraph();

        System.out.println("\n\nFollowing is Depth First Traversal");
        topSort(graph);
    }
}

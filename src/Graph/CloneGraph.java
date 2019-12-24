package Graph;

/**
 * @author jakadam on 2019-12-24
 */

/**
 * Clone an undirected graph. Each node in the graph contains a label and a list of its neighbors.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
        if (root == null)
            return root;

        //make a copy of the root node, this will be passed as an answer
        UndirectedGraphNode newRoot = new UndirectedGraphNode(root.label);

        /**
         * In order to clone the graph, we need to search it completely.
         * We have 2 options, BFS and DFS
         * As we want to maintain the relationships among the nodes in the form of Edges, BFS seems more
         * intuitive than DFS. We will explore the graph level by level. DFS can also be used.
         */
        // Initialize a queue for BFS traversal
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();

        // To keep track of visited(cloned) nodes, initialize a hashMap
        // We can use a map<int,UndirectedGraphNode> but what if the graph has 2 nodes with same label,
        // hence use Map<UndirectedGraphNode,UndirectedGraphNode> => Map<Cloned Node, Original Node>
        Map<UndirectedGraphNode, UndirectedGraphNode> visitedMap = new HashMap<>();


        // add the root to the queue and map
        queue.add(root);
        visitedMap.put(root, new UndirectedGraphNode(root.label));

        // start exploring/ cloning using BFS
        while (!queue.isEmpty()) {
            // dequeue the original node from the queue, we are going to process its neighbouring nodes
            UndirectedGraphNode originalNode = queue.poll();

            for (UndirectedGraphNode neighbour : originalNode.neighbors) {

                // check if the neighbour node is already cloned, if not process it
                if (!visitedMap.containsKey(neighbour)) {
                    // add it to neighbour map along with its clone as value
                    visitedMap.put(neighbour, new UndirectedGraphNode(neighbour.label));

                    // add it queue for further processing
                    queue.add(neighbour);
                }

                /**
                 * we are going to populate the neighbour list of the clone of originalNode
                 */
                visitedMap.get(originalNode)// get the cloned node
                        .neighbors.add(visitedMap.get(neighbour));// add the neighbour to the clonedNodes neighbour list
            }// for loop end
        }// while loop end
        return visitedMap.get(root);
    }
}

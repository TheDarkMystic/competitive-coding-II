package Graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jakadam on 2019-12-24
 */

public class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
};
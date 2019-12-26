package GraphAlgorithms;

/******************************************************************************
 *
 *  Weighted quick-union by rank with path compression by halving.
 find(int p) : returns the parent node of node p
 union(int p, int q): merges disjoint sets p and q, connects smaller set to larger
 set and returns the parent node of larger set as parent of union
 ******************************************************************************
 */

public class UF {

    private int[] parent;  // parent[i] = parent of i
    private byte[] rank;   // rank[i] = rank of subtree rooted at i (never more than 31)
    private int count;

    /**
     * Initializes an empty union-find data structure
     * Initially, each elements is in its own set.
     */
    public UF(int n) {
        if (n < 0) throw new IllegalArgumentException();
        count = n; // initially every node is a set, we have total n sets
        parent = new int[n];
        rank = new byte[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
        }
    }

    /**
     * Returns the canonical element of the set containing element
     */
    public int find(int p) {
        validate(p);
        while (parent[p] != p) {
            parent[p] = parent[parent[p]];    // path compression by halving
            p = parent[p];
        }
        return p;
    }

    /**
     * Merges the set containing element p with the
     * the set containing element q.
     */
    public void union(int p, int q) {
        int rootP = find(p);
        int rootQ = find(q);
        if (rootP == rootQ)
            return;

        // make root of smaller rank point to root of larger rank
        if (rank[rootP] < rank[rootQ])
            parent[rootP] = rootQ;
        else if (rank[rootP] > rank[rootQ])
            parent[rootQ] = rootP;
        else {
            parent[rootQ] = rootP;
            rank[rootP]++;
        }
        count--;
    }

    public int numOfSets() {
        return count;
    }

    // validate that p is a valid index
    private void validate(int p) {
        int n = parent.length;
        if (p < 0 || p >= n) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n - 1));
        }
    }
}

/**
 * Video Tutorial for Union Find Data Structure:
 * https://www.youtube.com/playlist?list=PLDV1Zeh2NRsBI1C-mR6ZhHTyfoEJWlxvq
 * <p>
 * Code Reference:
 * https://algs4.cs.princeton.edu/15uf/UF.java.html
 * <p>
 * GFG Theoretical Explanation
 * https://www.geeksforgeeks.org/union-find-algorithm-set-2-union-by-rank/
 */
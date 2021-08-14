package MachineCoding.LRU;


import java.util.HashMap;
import java.util.Map;

/**
 * @author jakadam on 2019-12-22
 */

/**
 * Design and implement a data structure for LRU (Least Recently Used) cache. It should support the following operations: get and set.
 * 1. get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * 2. set(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity, it should invalidate the least recently used item before inserting the new item.
 * The LRU Cache will be initialized with an integer corresponding to its capacity. Capacity indicates the maximum number of unique keys it can hold at a time.
 * Definition of “least recently used” : An access to an item is defined as a get or a set operation of the item. “Least recently used” item is the one with the oldest access time.
 * NOTE: If you are using any global variables, make sure to clear them in the constructor.
 * Example :
 * Input :
 * capacity = 2
 * set(1, 10)
 * set(5, 12)
 * get(5)        returns 12
 * get(1)        returns 10
 * get(10)       returns -1
 * set(6, 14)    this pushes out key = 5 as LRU is full.
 * get(5)        returns -1
 */

/**
class Node {
    Node prev, next;
    int val;
    int key;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    private Map<Integer, Node> map;
    int capacity;
    Node head, end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = null;
        end = null;
        map = new HashMap<>();
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        }
        return -1;

    }

    public void set(int key, int value) {
        Node n = map.get(key);
        if (n != null) {
            n.val = value;
            remove(n);
        } else {
            if (map.size() >= capacity) {
                //evict
                map.remove(end.key);
                remove(end);
            }
            n = new Node(key, value);

        }

        setHead(n);
    }

    private void setHead(Node n) {
        if (head == null) {
            head = n;
            end = head;
        } else {
            n.prev = null;
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    private void remove(Node n) {
        if (n.prev == null) {
            head = n.next;
        } else if (n.next == null) {
            end = n.prev;
            end.next = null;
        } else {
            n.prev.next = n.next;
            n.next.prev = n.prev;
        }
    }
}

/**
 * Refer EverNote Heaps&Maps for Theory
 * https://www.interviewbit.com/problems/lru-cache/
 */
//import java.util.*;

class Node {
    int key;
    int val;
    Node prev, next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
    }

}

public class LRUCache {
    Map<Integer, Node> lruCache;
    int capacity;
    Node head, end;

    public LRUCache(int capacity) {
        this.lruCache = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.end = null;
    }


    public int get(int key) {
        if (lruCache.containsKey(key) == false) {
            Node node = lruCache.get(key);
            remove(node);
            setHead(node);
            return node.val;
        } else {
            return -1;
        }
    }

    public void set(int key, int val) {
        Node n = lruCache.get(key);
        if (n != null) {
            n.val = val;
            remove(n);

        } else {
            if (lruCache.size() >= capacity) {
                lruCache.remove(end.key);
                remove(end);
            }
            n = new Node(key, val);
        }
        lruCache.put(key, n);
        setHead(n);
    }

    private void remove(Node node) {
        if (node.prev == null) {
            head = node.next;
            node.next.prev = null;
        } else if (node.next == null) {
            end = node.prev;
            end.next = null;
        } else {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }


    }

    private void setHead(Node node) {
        if (head == null) {
            head = node;
            end = head;
        } else {
            node.prev = null;
            head.prev = node;
            node.next = head;
            head = node;
        }
    }

}
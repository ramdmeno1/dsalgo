package cache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map = new HashMap<>();

    public LRUCache(int size) {
        this.size = size;
    }

    public int get(int key) {
        int value = -1;
        if (map.containsKey(key)) {
            Node node = map.get(key);
            value = node.value;
            delete(node);
            addFront(node);
        }
        return value;
    }

    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            Node node = new Node(key, value);
            map.put(key, node);

            addFront(node);
            if (map.size() > size) {
                map.remove(tail.key);
                tail = tail.prev;
                tail.next = null;
            }

        } else {
            Node node = map.get(key);
            node.value = value;
            delete(node);
            addFront(node);
        }
    }

    void addFront(Node node) {
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (tail == null)
            tail = head;
    }

    void delete(Node node) {
        if (node.prev != null)
            node.prev.next = node.next;
        else
            head = node.next;

        if (node.next != null)
            node.next.prev = node.prev;
        else
            tail = node.prev;
    }

    class Node {
        int key;
        int value;
        Node next;
        Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));
        cache.put(3, 3);
        System.out.println(cache.get(2));

        cache.put(4,4);
        System.out.println(cache.get(1));

        System.out.println(cache.get(3));
        System.out.println(cache.get(4));
    }
}

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private static class Node{
        private int key;
        private int value;
        private Node prev;
        private Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>(capacity);
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    public int get(int key){
        Node node = map.get(key);
        if(node == null){
            return -1;
        }
        // Move the node to the front of the list
        removeNode(node);
        addNode(node);
        return node.value;
    }
    public void put(int key, int value){
        Node node = map.get(key);

        if(node == null){
            // // The key is not in the cache yet.
            node = new Node(key, value);
            map.put(key, node);
            addNode(node);
        }else{
            // The key is already in the cache
            node.value = value;
            removeNode(node);
            addNode(node);
        }
    }
    private void addNode(Node node){
        node.next = head.next;
        node.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

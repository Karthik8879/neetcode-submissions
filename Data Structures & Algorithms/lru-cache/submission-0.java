class LRUCache {

    class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int k, int v) {
            key = k;
            val = v;
        }
    }

    HashMap<Integer, Node> hm = new HashMap<>();
    Node head = new Node(0, 0);
    Node tail = new Node(0, 0);
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    
    public int get(int key) {
        if(!hm.containsKey(key)) {
            return -1;
        }
        Node node = hm.get(key);
        remove(node);
        addToHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(hm.containsKey(key)) {
            Node node = hm.get(key);
            node.val = value;
            remove(node);
            addToHead(node);
        } else {
            if(hm.size() == capacity) {
                Node lru = tail.prev;
                remove(lru);
                hm.remove(lru.key);
            }
            Node node = new Node(key, value);
            hm.put(key, node);
            addToHead(node);
        }
    }
}

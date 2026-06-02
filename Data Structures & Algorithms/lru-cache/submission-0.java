class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {

    Map<Integer, Node> map;
    int capacity;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);

        this.head.next = this.tail;
        this.tail.prev = this.head;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node node = this.map.get(key);
            remove(node);
            insert(node);
            return node.val;
        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (this.map.containsKey(key)) {
            Node oldNode = this.map.get(key);
            remove(oldNode);
        }

        Node node = new Node(key, value);
        insert(node);
        this.map.put(key, node);

        if (this.map.size() > capacity) {
            decrease();
        }
    }

    private void insert(Node node) {
        Node tmp = this.tail.prev;
        tmp.next = node;
        node.prev = tmp;
        node.next = this.tail;
        this.tail.prev = node;
    }

    private void remove(Node node) {
        Node prevNode = node.prev;
        Node nextNode = node.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private void decrease() {
        this.map.remove(this.head.next.key);

        Node tmp = this.head.next.next;
        this.head.next = tmp;
        if (tmp != null) {
            tmp.prev = this.head;
        }
    }
}

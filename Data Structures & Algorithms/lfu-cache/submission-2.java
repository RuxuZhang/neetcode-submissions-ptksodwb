class Node {
    int key;
    int val;
    int count;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.count = 1;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public DoublyLinkedList() {
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public void add(Node node) {
        Node next = this.head.next;
        this.head.next = node;
        node.prev = this.head;
        node.next = next;
        next.prev = node;
    }

    public boolean isEmpty() {
        return this.head.next == this.tail;
    }

    public int removeLFU() {
        int key = this.tail.prev.key;
        Node node = this.tail.prev.prev;
        node.next = this.tail;
        this.tail.prev = node;
        return key;
    }
}

class LFUCache {

    Map<Integer, DoublyLinkedList> listMap;
    Map<Integer, Node> nodeMap;
    int capacity;
    int lfu;

    public LFUCache(int capacity) {
        this.listMap = new HashMap<>();
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;

        this.listMap.put(1, new DoublyLinkedList());
    }
    
    public int get(int key) {
        if (!nodeMap.containsKey(key) || this.capacity == 0) {
            return -1;
        }

        Node cur = nodeMap.get(key);
        bump(cur);

        return nodeMap.get(key).val;
    }

    public void put(int key, int value) {
        if (this.capacity == 0) {
            return;
        }

        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            bump(node);
            return;
        }

        if (nodeMap.size() == this.capacity) {
            DoublyLinkedList leastFreqDll = listMap.get(this.lfu);
            int removeKey = leastFreqDll.removeLFU();
            this.nodeMap.remove(removeKey);
        }

        Node node = new Node(key, value);
        this.nodeMap.put(key, node);
        this.listMap.get(1).add(node);
        this.lfu = 1;
    }

    private void bump(Node node) {
        Integer count = node.count;
        remove(node);
        
        if (this.lfu == count && this.listMap.get(count).isEmpty()) {
            this.lfu++;
        }

        count = count + 1;
        node.count = count;
        this.listMap.computeIfAbsent(count, x -> new DoublyLinkedList()).add(node);
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
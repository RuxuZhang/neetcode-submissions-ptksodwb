class Node {
    int key;
    int value;
    Node next;

    public Node (int key, int value) {
        this.key = key;
        this.value = value;
        this.next = null;
    }
}

class MyHashMap {

    Node[] array;
    int n;

    public MyHashMap() {
        n = 1000;
        array = new Node[n];
        for (int i = 0; i < n; i++) {
            array[i] = new Node(-1, -1);
        }
    }
    
    public void put(int key, int value) {
        int index = key % n;
        Node node = array[index];

        while (node.next != null) {
            node = node.next;
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        node.next = new Node(key, value);
    }
    
    public int get(int key) {
        int index = key % n;
        Node node = array[index];

        while (node.next != null) {
            node = node.next;
            if (node.key == key) {
                return node.value;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        int index = key % n;
        Node node = array[index];
        Node prev = null;

        while (node.next != null) {
            prev = node;
            node = node.next;
            if (node.key == key) {
                prev.next = node.next;
                return;
            }
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();
        Node p = head;
        while (p != null) {
            map.put(p, new Node(p.val));
            p = p.next;
        }

        p = head;
        while(p != null) {
            Node next = p.next == null ? null : map.get(p.next);
            Node random = p.random == null ? null : map.get(p.random);
            Node copy = map.get(p);
            copy.next = next;
            copy.random = random;
            p = p.next;
        }

        return head == null ? null : map.get(head);
    }
}

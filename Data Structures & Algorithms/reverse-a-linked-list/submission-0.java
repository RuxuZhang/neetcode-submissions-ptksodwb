/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode p1 = head.next;
        ListNode p2 = head;
        ListNode p3 = null;

        while (p1 != null) {
            p2.next = p3;
            p3 = p2;
            p2 = p1;
            p1 = p1.next;
        }
        p2.next = p3;

        return p2;
    }
}

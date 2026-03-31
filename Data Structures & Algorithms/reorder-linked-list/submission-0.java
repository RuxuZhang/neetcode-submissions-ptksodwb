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
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode f = head;
        ListNode s = head;
        while(f != null && f.next != null) {
            f = f.next.next;
            s = s.next;
        }

        ListNode cur = s.next;
        s.next = null;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        ListNode p1 = head;
        ListNode p2 = prev;
        while (p2 != null) {
            ListNode t1 = p1.next;
            ListNode t2 = p2.next;

            p1.next = p2;
            p2.next = t1;

            p1 = t1;
            p2 = t2;
        }
    }
}

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode start = dummy;
        ListNode node = dummy;

        while (node != null) {
            int step = 0;
            while (node != null && step < k) {
                node = node.next;
                step++;
            }

            if (node != null) {
                ListNode next = node.next;
                ListNode tail = reverseK(start.next, k);
                tail.next = next;
                start.next = node;

                start = tail;
                node = tail;
            }
        }

        return dummy.next;
    }

    private ListNode reverseK(ListNode node, int k) {
        ListNode prev = null;
        ListNode cur = node;
        for (int i = 0; i < k; i++) {
            ListNode next = cur == null ? null : cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return node;
    }
}

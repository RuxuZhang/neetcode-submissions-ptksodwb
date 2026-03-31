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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;
        ListNode prev = new ListNode(0);
        prev.next = p2;

        int carry = 0;

        while (p1 != null || p2 != null) {
            int v1 = p1 == null ? 0 : p1.val;
            int v2 = p2 == null ? 0 : p2.val;

            int sum = v1 + v2 + carry;
            carry = sum / 10;

            if (p2 == null) {
                ListNode newNode = new ListNode(sum % 10);
                prev.next = newNode;
            } else {
                p2.val = sum % 10;
            }
            p1 = p1 == null ? null : p1.next;
            p2 = p2 == null ? null : p2.next;
            prev = prev.next;
        }

        if (carry != 0) {
            ListNode newNode = new ListNode(carry);
            prev.next = newNode;
        }

        return l2;
    }
}

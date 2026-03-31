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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode p1 = list1;
        ListNode dummy = new ListNode(-100, list2);
        ListNode p2 = dummy;

        while (p2.next != null && p1 != null) {
            if (p1.val >= p2.val && p1.val < p2.next.val) {
                ListNode tmp = p1.next;
                p1.next = p2.next;
                p2.next = p1;
                p1 = tmp;
            }
            p2 = p2.next;
        }

        if (p1 != null) {
            p2.next = p1;
        }

        return dummy.next;
    }
}
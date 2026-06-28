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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p1 = head;
        ListNode p2 = head.next;

        while (p2 != null) {
            insert(p1, p2);

            p1 = p2;
            p2 = p2.next;
        }

        return head;
    }

    private void insert(ListNode p1, ListNode p2) {
        int gcd = findGCD(p1.val, p2.val);
        ListNode m = new ListNode(gcd);

        m.next = p2;
        p1.next = m;
    }

    private int findGCD(int a, int b) {
        if (b > a) {
            int tmp = a;
            a = b;
            b = tmp;
        }

        int rem = a % b;
        int res = b;
        while (rem != 0) {
            res = rem;
            rem = b % rem;
        }

        return res;
    }
}
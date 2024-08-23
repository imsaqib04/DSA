public class CheckCycleLinkList {
    /**
     * Definition for singly-linked list.
     * class ListNode {
     * int val;
     * ListNode next;
     * ListNode(int x) {
     * val = x;
     * next = null;
     * }
     * }
     */

    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {
            return false;
        }

        ListNode L1 = head;
        ListNode L2 = head;

        while (L1 != null && L1.next != null) {
            L2 = L2.next;
            L1 = L1.next.next;
            if (L1 == L2) {
                return true;
            }
        }
        return false;
    }
}
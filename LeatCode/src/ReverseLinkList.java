public class ReverseLinkList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    public ListNode reverseList(ListNode head) {

        ListNode prev = null;

        ListNode curr = null;

        while (head != null) {

            curr = head.next;   // pointing to next node current
            head.next = prev;  // null for linking break here we use this  in 2nd iteration (1<-2)
            prev = head;       // store value head in the prev
            head = curr;       // and assign head to current node
        }

        return prev;
    }
}

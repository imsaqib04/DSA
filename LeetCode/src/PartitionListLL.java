public class PartitionListLL {
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
    public ListNode partition(ListNode head, int x) {

        ListNode smallDummy = new ListNode ( 0 );
        ListNode greaterDummy = new ListNode ( 0 );

        ListNode small = smallDummy;
        ListNode greater = greaterDummy;

        while (head != null) {
            if (head.val < x) {
                small.next = head;   // (initially small)0->1   assign head value in small(1)
                small = small.next;  // assign into small to small.next 0->1(small)
            } else {
                greater.next = head;
                greater = greater.next;
            }
            head = head.next;
        }
        greater.next = null;
        small.next = greaterDummy.next;
        return smallDummy.next;
    }
}
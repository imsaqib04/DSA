public class RotateListLL {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;

        int len = 0;
        while (current != null) {
            len++;
            current = current.next;
        }

        k = k % len;

        if (k == 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (k > 0) {
            fast = fast.next;
            k--;
        }

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode newNode = slow.next;

        slow.next = null;
        fast.next = head;

        return newNode;
    }
}
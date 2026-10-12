/**
 * LeetCode 203: Remove Linked List Elements
 *
 * Time: O(n)
 * Extra space: O(1)
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // Remove matching nodes at the beginning.
        while (head != null && head.val == val) {
            head = head.next;
        }

        ListNode current = head;

        // Check the node after current before moving forward.
        while (current != null && current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }

        return head;
    }
}

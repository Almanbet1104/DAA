/**
 * LeetCode 83: Remove Duplicates from Sorted List
 *
 * Time: O(n)
 * Extra space: O(1)
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Skip the duplicate node.
                current.next = current.next.next;
            } else {
                // Move forward only when the next value is different.
                current = current.next;
            }
        }

        return head;
    }
}

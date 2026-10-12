# 234. Palindrome Linked List

## 1. Problem

Determine whether the values in a singly linked list read the same from left to right and from right to left. Return `true` if they do and `false` otherwise.

## 2. Approach

For this straightforward solution, I copy the node values into an array-like list. A singly linked list cannot move backward, so storing the values lets me compare both ends easily.

1. Traverse the linked list and append every value to `values`.
2. Set `left` to the first index and `right` to the last index.
3. Compare the values at those indices. If they differ, return `false`.
4. If they match, move `left` one step right and `right` one step left.
5. If the pointers meet or cross without finding a mismatch, return `true`.

### Trace

Input: `1 -> 2 -> 2 -> 1`

After copying, `values = [1, 2, 2, 1]`.

1. Compare index 0 and index 3: `1 == 1`. Move inward.
2. Compare index 1 and index 2: `2 == 2`. Move inward again.
3. The indices have met/crossed, and no mismatch was found.

Output: `true`

For input `1 -> 2`, the array is `[1, 2]`. The first comparison is `1 != 2`, so the method returns `false`.

### Testing and challenges

I would test a single node, an even-length palindrome, an odd-length palindrome, a non-palindrome, and a list whose first and last values differ. An easy-to-miss case is an odd-length list: its middle value does not need a matching partner, so the loop uses `left < right`, not `left != right`.

## 3. Time and space complexity

**Time: O(n).** Copying the values visits each node once. Comparing the two ends takes at most about n/2 comparisons, which is still O(n). The two phases together are linear.

**Extra space: O(n).** The list stores one value for every node, so the additional memory grows proportionally to the number of nodes.

## 4. Reflection / Improvement

Yes. The follow-up can be achieved in O(n) time and O(1) extra space by finding the middle with slow and fast pointers, reversing the second half, and comparing the two halves. This avoids storing all values, but it requires careful pointer handling. If preserving the original list structure is important, the reversed half should be restored before returning.


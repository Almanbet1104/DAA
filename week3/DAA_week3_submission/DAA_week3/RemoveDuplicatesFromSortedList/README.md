# 83. Remove Duplicates from Sorted List

## 1. Problem

Given a sorted singly linked list, remove repeated values so that every value appears once. Return the head of the resulting list.

## 2. Approach

I use one pointer, `current`, to inspect each node and its next node. Because the list is sorted, equal values appear next to each other.

- If `current.val` equals `current.next.val`, I skip the next node by setting `current.next = current.next.next`.
- If the values differ, I move `current` to the next node.
- I stop when `current` is `null` or there is no next node.

The list is modified in place, so I do not need to create a second list.

### Trace

Input: `1 -> 1 -> 2 -> 3 -> 3 -> null`

1. `current` is at the first `1`. The next value is also `1`, so I skip the second node. The list becomes `1 -> 2 -> 3 -> 3`.
2. The current node is still the first `1`. Its next value is `2`, so I move to `2`.
3. `2` and `3` differ, so I move to `3`.
4. The current `3` and next `3` are equal, so I skip the second `3`.
5. The current node has no next node, so the loop ends.

Output: `1 -> 2 -> 3 -> null`

### Testing and challenges

I would test an empty list, a one-node list, a list with no duplicates, a list where every value is the same, and duplicates at the beginning, middle, and end. One important detail is not to advance `current` after deleting a duplicate: there could be several identical nodes in a row. Advancing immediately could leave some duplicates behind.

## 3. Time and space complexity

**Time: O(n).** Each iteration either removes one node or advances the pointer. The pointer moves through the list, and each node is handled a constant number of times.

**Extra space: O(1).** The algorithm uses only one pointer and changes existing links. It does not allocate a data structure proportional to the list size.

## 4. Reflection / Improvement

For a sorted list, this is already an efficient approach: it takes linear time and constant extra space. A brute-force approach using a set would need additional memory and is unnecessary because sorting places duplicates next to one another.


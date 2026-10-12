# 203. Remove Linked List Elements

## 1. Problem

Given a linked list and a value `val`, remove every node whose value equals `val`. Return the head of the remaining list.

## 2. Approach

First, I remove matching nodes from the beginning. This matters because the original head itself might need to be deleted, and the returned head must point to the first node that remains.

Then I use `current` to inspect the node after it:

- If `current.next.val == val`, I skip that node by linking `current.next` to `current.next.next`.
- Otherwise, I move `current` forward.
- The loop stops when there is no next node to inspect.

### Trace

Input: `1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6`, with `val = 6`

1. The head is `1`, which is not `6`, so it stays.
2. `current` is `1`; its next node is `2`, so move to `2`.
3. The next node is `6`, so bypass it. The list becomes `1 -> 2 -> 3 -> 4 -> 5 -> 6`.
4. Continue checking the next nodes: `3`, `4`, and `5` remain.
5. The final next node is `6`, so bypass it. The list becomes `1 -> 2 -> 3 -> 4 -> 5`.
6. There is no next node, so stop and return the head.

Output: `1 -> 2 -> 3 -> 4 -> 5 -> null`

### Testing and challenges

I would test an empty list, no matching values, all nodes matching, matching nodes at the head, and consecutive matches in the middle or at the end. A common mistake is deleting nodes after the head but forgetting that the head itself may need to change. Another is moving `current` immediately after deletion, which can skip checking consecutive matching nodes.

## 3. Time and space complexity

**Time: O(n).** The initial loop removes matching head nodes, and the second loop processes the remaining nodes. Together, they examine at most a linear number of nodes.

**Extra space: O(1).** The algorithm uses a constant number of pointers and modifies the existing links.

## 4. Reflection / Improvement

A dummy-head node can simplify the implementation because the same deletion logic then handles the original head and all later nodes. It would still take O(n) time and O(1) extra space. The current solution already has these asymptotic complexities, but the dummy-head version can make the code more uniform.


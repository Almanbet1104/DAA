# 160. Intersection of Two Linked Lists

## 1. Problem

Given the heads of two singly linked lists, return the actual node where they begin to share the same tail. If they never share a node, return `null`.

Two nodes with the same value are not necessarily the same node. Intersection means that both lists refer to the same node in memory.

## 2. Approach

I use two pointers, `a` and `b`, starting at the heads of the two lists. When a pointer reaches the end of its list, I move it to the other list's head. The loop stops when the pointers are equal.

After switching lists, each pointer traverses a total distance of `m + n` if there is no intersection or if an intersection exists. This balances the difference between the list lengths. If there is an intersection, the pointers reach the shared node together. If there is none, both eventually become `null` and are equal.

### Trace

Suppose:

- A: `4 -> 1 --> 8 -> 4 -> 5`
- B: `5 -> 6 -> 1 -> 8 -> 4 -> 5`

The two lists share the same node with value `8` and all nodes after it.

1. Initially, `a` points to A's `4`; `b` points to B's `5`.
2. Both pointers move one node at a time. They do not stop merely because two values match: they compare node references.
3. When `a` reaches the end of A, it switches to B's head. When `b` reaches the end of B, it switches to A's head.
4. After the length difference has been balanced, both pointers arrive at the shared node containing `8`.
5. Since `a == b`, the loop ends and that node is returned.

For lists without an intersection, the pointers eventually both become `null`; the method returns `null`.

### Testing and challenges

I would test an intersection at the heads, an intersection at the final shared tail, lists of unequal lengths, and lists that never intersect. A key challenge is comparing node references with `==`, not comparing `a.val` and `b.val`. Equal values alone do not prove that the lists share a node.

## 3. Time and space complexity

**Time: O(m + n).** Each pointer traverses at most both lists once. Therefore, the total work is proportional to the combined number of nodes.

**Extra space: O(1).** Only two pointers are used, regardless of list size.

## 4. Reflection / Improvement

A brute-force solution could compare every node in A with every node in B, taking O(mn) time. A hash set could reduce expected time to O(m + n) but use O(m) extra space. The two-pointer solution achieves O(m + n) time and O(1) extra space, so it already meets the follow-up requirement.


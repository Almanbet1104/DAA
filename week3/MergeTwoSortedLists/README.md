# Merge Two Sorted Lists

## 1. Problem

We are given two singly linked lists. Both lists are already sorted in non-decreasing order.

The task is to combine them into one sorted linked list.

For example:

```text
list1: 1 → 2 → 4
list2: 1 → 3 → 4

result: 1 → 1 → 2 → 3 → 4 → 4
```

The important part is that we should reuse the existing nodes instead of creating a completely new list of values.

---

## 2. Approach

I use two pointers, one for each input list.

I also create a temporary `dummy` node. The `current` pointer represents the last node in the merged list.

At every iteration:

1. Compare the values of the current nodes of `list1` and `list2`.
2. Take the smaller value.
3. Connect that node to the merged list.
4. Move the pointer of the list from which the node was taken.
5. Move `current` forward.

When one of the lists becomes empty, all remaining nodes from the other list are already sorted, so I attach the rest directly.

### Example tracing

Input:

```text
list1: 1 → 2 → 4
list2: 1 → 3 → 4
```

Initial:

```text
merged: empty
list1 → 1
list2 → 1
```

### Iteration 1

Compare `1` and `1`.

They are equal, so I take the node from `list1`.

```text
merged: 1
list1 → 2
list2 → 1
```

### Iteration 2

Compare `2` and `1`.

`1` is smaller, so I take the node from `list2`.

```text
merged: 1 → 1
list1 → 2
list2 → 3
```

### Iteration 3

Compare `2` and `3`.

`2` is smaller.

```text
merged: 1 → 1 → 2
list1 → 4
list2 → 3
```

### Iteration 4

Compare `4` and `3`.

`3` is smaller.

```text
merged: 1 → 1 → 2 → 3
list1 → 4
list2 → 4
```

### Iteration 5

Compare `4` and `4`.

I take the node from `list1`.

```text
merged: 1 → 1 → 2 → 3 → 4
list1 → null
list2 → 4
```

Now `list1` is empty.

The remaining node from `list2` can be attached directly:

```text
merged: 1 → 1 → 2 → 3 → 4 → 4
```

The algorithm returns `dummy.next`, which is the first real node of the merged list.

---

## 3. Time Complexity

**Time Complexity: O(n + m)**

Where:

- `n` = number of nodes in `list1`
- `m` = number of nodes in `list2`

The algorithm moves through each node at most once.

For example, if the first list has 3 nodes and the second list has 3 nodes, at most all 6 nodes need to be processed.

Therefore:

```text
O(n + m)
```

---

## Space Complexity

**Space Complexity: O(1)**

I only use a few pointers:

```text
dummy
current
list1
list2
```

I do not create another linked list containing copies of the nodes. The existing nodes are connected together.

Therefore, the additional memory used is constant:

```text
O(1)
```

---

## 4. Reflection / Improvement

This solution is already optimal in terms of time complexity.

Every node may need to be examined, so it is not possible to generally do better than:

```text
O(n + m)
```

The main possible improvement would be a small code simplification, for example avoiding the `dummy` node and handling the first node separately. However, that would not improve the Big-O complexity.

The `dummy` node makes the implementation simpler because I do not need special logic for choosing the head of the merged list.

### Final complexity

```text
Time:  O(n + m)
Space: O(1)
```
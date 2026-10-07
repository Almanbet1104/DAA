# Linked List Cycle

## 1. Problem

We are given the head of a singly linked list.

The task is to determine whether the list contains a cycle.

Normally, following `next` eventually reaches `null`:

```text
1 → 2 → 3 → null
```

A cycle occurs when a node points back to a previous node:

```text
1 → 2 → 3
    ↑     ↓
    ← ← ←
```

The function should return:

```text
true
```

if a cycle exists and:

```text
false
```

otherwise.

---

## 2. Approach

My first approach uses a `HashSet`.

The idea is simple: keep track of every node that I have already visited.

I start at the head of the list and repeatedly follow the `next` pointer.

For every node:

1. Check whether the node is already in the set.
2. If it is already there, I have reached the same node again, so there is a cycle.
3. If it is not there, add it to the set.
4. Move to the next node.
5. If `current` becomes `null`, there is no cycle.

### Example 1 — No cycle

Input:

```text
1 → 2 → 3 → null
```

Tracing:

```text
current = 1
visited = {}

1 is not visited
visited = {1}

current = 2

2 is not visited
visited = {1, 2}

current = 3

3 is not visited
visited = {1, 2, 3}

current = null
```

We reached `null`, so there is no cycle.

Result:

```text
false
```

---

### Example 2 — Cycle

Consider:

```text
3 → 2 → 0 → -4
    ↑         ↓
    ← ← ← ← ←
```

The `-4` node points back to the node containing `2`.

Tracing:

```text
current = 3
visited = {}

Add 3

current = 2
visited = {3}

Add 2

current = 0
visited = {3, 2}

Add 0

current = -4
visited = {3, 2, 0}

Add -4

current = 2
visited = {3, 2, 0, -4}
```

Now node `2` is already in the set.

This means we have reached the same node again.

Therefore:

```text
return true
```

---

## 3. Time Complexity

**Time Complexity: O(n)**

Where `n` is the number of nodes that we visit.

In the worst case, we may have to visit every node once before determining that there is no cycle.

With a cycle, we may also need to travel through the nodes until we encounter a node that has already been visited.

The `HashSet` lookup is approximately `O(1)` on average.

Therefore, the overall time complexity is:

```text
O(n)
```

---

## Space Complexity

**Space Complexity: O(n)**

The `HashSet` stores every different node that we visit.

In a list without a cycle, this could mean storing all `n` nodes.

For example:

```text
1 → 2 → 3 → 4 → null
```

would result in:

```text
visited = {1, 2, 3, 4}
```

Therefore, the additional memory can grow with the size of the linked list:

```text
O(n)
```

---

## 4. Reflection / Improvement

There is a more memory-efficient solution called **Floyd's Cycle Detection Algorithm**, also known as the **slow and fast pointer method**.

Instead of storing visited nodes, it uses two pointers:

```text
slow
fast
```

The `slow` pointer moves one node at a time:

```text
slow = slow.next
```

The `fast` pointer moves two nodes at a time:

```text
fast = fast.next.next
```

If there is no cycle, `fast` will eventually reach `null`.

If there is a cycle, the faster pointer will eventually catch the slower pointer inside the cycle.

For example:

```text
3 → 2 → 0 → -4
    ↑         ↓
    ← ← ← ← ←
```

Inside the cycle:

```text
slow → one step
fast → two steps
```

Eventually:

```text
slow == fast
```

which proves that a cycle exists.

The improved algorithm has:

```text
Time:  O(n)
Space: O(1)
```

So the improvement does **not** make the algorithm faster in Big-O terms. Instead, it significantly reduces the additional memory from:

```text
O(n) → O(1)
```

### Comparison

| Approach | Time | Extra Space |
|---|---:|---:|
| My HashSet solution | O(n) | O(n) |
| Floyd's algorithm | O(n) | O(1) |

The HashSet solution is easier for me to understand initially because I explicitly remember every visited node. Floyd's algorithm is more memory-efficient, but it requires understanding why two pointers moving at different speeds must meet inside a cycle.

### Final complexity of my submitted solution

```text
Time:  O(n)
Space: O(n)
```

### Improved complexity

```text
Time:  O(n)
Space: O(1)
```
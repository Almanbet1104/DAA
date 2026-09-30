# Recursive Binary Search in Java

## Overview

This project implements Binary Search using recursion.

Binary Search works only with sorted arrays.

Example:

```text
[10,20,30,40,50,60,70,80,90]
```

---

## Algorithm

The function calls itself until:

```text
low > high
```

or

```text
target is found
```

---

## Code

```java
public static int binarySearchRecursive(
        int[] a,
        int target,
        int low,
        int high) {

    if (low > high) {
        return -1;
    }

    int mid = low + (high - low) / 2;

    if (a[mid] == target) {
        return mid;
    }

    if (target < a[mid]) {
        return binarySearchRecursive(
            a,
            target,
            low,
            mid - 1
        );
    }

    return binarySearchRecursive(
        a,
        target,
        mid + 1,
        high
    );
}
```

---

## Example Runs

Array:

```text
[10,20,30,40,50,60,70,80,90]
```

### Example 1

Search:

```text
30
```

Result:

```text
Index = 2
```

---

### Example 2

Search:

```text
70
```

Result:

```text
Index = 6
```

---

### Example 3

Search:

```text
25
```

Result:

```text
-1
```

---

## Recursive Call Visualization

Search for 30:

```text
binarySearch(30,0,8)
          ↓
binarySearch(30,0,3)
          ↓
binarySearch(30,2,3)
          ↓
FOUND
```

Search for 25:

```text
binarySearch(25,0,8)
          ↓
binarySearch(25,0,3)
          ↓
binarySearch(25,2,3)
          ↓
binarySearch(25,2,1)
          ↓
NOT FOUND
```

---

## Complexity Analysis

### Time Complexity

```text
O(log n)
```

---

### Space Complexity

```text
O(log n)
```

Recursive calls use stack memory.

---

## Difference from Iterative Version

| Iterative | Recursive |
|------------|------------|
| Uses loop | Uses recursion |
| O(1) space | O(log n) space |
| Faster in practice | More elegant |

---

## Files

```text
BinarySearchRecursive.java
README.md
```
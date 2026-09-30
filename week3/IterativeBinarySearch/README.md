# Iterative Binary Search in Java

## Overview

This project implements Binary Search using an iterative approach.

Binary Search works only on sorted arrays.

Example:

```text
[10, 20, 30, 40, 50, 60, 70, 80, 90]
```

The algorithm repeatedly divides the search area in half.

---

## Algorithm

Variables:

- low → first index
- high → last index
- mid → middle index

Formula:

```java
int mid = low + (high - low) / 2;
```

If:

```text
target < a[mid]
```

Search left half.

If:

```text
target > a[mid]
```

Search right half.

---

## Code

```java
public static int binarySearchIterative(int[] a, int target) {

    int low = 0;
    int high = a.length - 1;

    while (low <= high) {

        int mid = low + (high - low) / 2;

        if (a[mid] == target) {
            return mid;
        }
        else if (target < a[mid]) {
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    }

    return -1;
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
-1 (not found)
```

---

## Search Visualization

Example:

```text
[10 20 30 40 50 60 70 80 90]
                 ↑
                50

30 < 50

[10 20 30 40]
        ↑
       20

30 > 20

[30 40]
 ↑
30

FOUND
```

---

## Complexity Analysis

### Time Complexity

```text
O(log n)
```

The search area is divided by 2 each iteration.

---

### Space Complexity

```text
O(1)
```

No extra memory is used.

---

## Files

```text
IterativeBinarySearch.java
README.md
```
# First Bad Version

## Problem

There are `n` versions numbered from `1` to `n`.

At some point, a version becomes bad. Once a version is bad, **all versions after it are also bad**.

We are given the API:

```java
boolean isBadVersion(int version);
```

The API returns:

* `true` if the version is bad.
* `false` if the version is good.

The goal is to find the **first bad version** while minimizing the number of API calls.

## Example 1

**Input:**

```text
n = 5
bad = 4
```

**Output:**

```text
4
```

**Explanation:**

```text
Version:  1   2   3   4   5
Status:   ✓   ✓   ✓   ✗   ✗
                      ↑
                 First bad
```

The algorithm may make these calls:

```text
isBadVersion(3) → false
isBadVersion(5) → true
isBadVersion(4) → true
```

Therefore, the first bad version is `4`.

## Example 2

**Input:**

```text
n = 1
bad = 1
```

**Output:**

```text
1
```

## Algorithm

This problem can be solved using binary search.

The versions have a special pattern:

```text
Good Good Good Bad Bad Bad
```

We need to find the first `Bad`.

1. Set `left = 1`.
2. Set `right = n`.
3. Calculate the middle version.
4. Call `isBadVersion(mid)`.
5. If `mid` is bad:

   * `mid` could be the first bad version.
   * Search the left half.
6. If `mid` is good:

   * The first bad version must be after `mid`.
   * Search the right half.
7. Continue until `left == right`.
8. Return `left`.

## Java Implementation

```java
/* The isBadVersion API is defined in the parent class VersionControl.
   boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int left = 1;
        int right = n;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
```

## Complexity

### Time Complexity

**O(log n)**

Each API call eliminates approximately half of the possible versions.

### Space Complexity

**O(1)**

Only `left`, `right`, and `mid` are stored.

## Important Detail

The middle value is calculated as:

```java
int mid = left + (right - left) / 2;
```

instead of:

```java
int mid = (left + right) / 2;
```

This prevents integer overflow when `n` is very large.

The maximum constraint is:

```text
n <= 2^31 - 1
```

## Constraints

* `1 <= bad <= n`
* `n <= 2^31 - 1`

## Key Concept

This problem uses binary search to find a **boundary**:

```text
Good Good Good | Bad Bad Bad
                ↑
          First Bad Version
```

The goal is not simply to find any bad version, but to find the **first** bad version using the minimum possible API calls.

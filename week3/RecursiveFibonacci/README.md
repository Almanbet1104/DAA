# Recursive Fibonacci in Java

## Overview

This project implements the Fibonacci sequence using recursion.

The Fibonacci sequence is defined as:

F(0) = 0  
F(1) = 1  
F(n) = F(n-1) + F(n-2)

Example sequence:

0 1 1 2 3 5 8 13 21 34 55

---

## Algorithm

The recursive algorithm works by calling itself:

```java
return fibonacci(n - 1) + fibonacci(n - 2);
```

Base cases:

```java
if (n <= 1)
    return n;
```

---

## Code

```java
public static int fibonacci(int n) {
    if (n <= 1) {
        return n;
    }

    return fibonacci(n - 1) + fibonacci(n - 2);
}
```

---

## Example Runs

### Example 1

Input:

```text
n = 5
```

Output:

```text
5
```

---

### Example 2

Input:

```text
n = 7
```

Output:

```text
13
```

---

### Example 3

Input:

```text
n = 10
```

Output:

```text
55
```

---

## Recursive Call Structure

Example:

```text
fibonacci(4)
├── fibonacci(3)
│   ├── fibonacci(2)
│   └── fibonacci(1)
└── fibonacci(2)
```

The recursion continues until:

```text
fibonacci(1) = 1
fibonacci(0) = 0
```

---

## Complexity Analysis

### Time Complexity

```text
O(2^n)
```

The same values are calculated many times.

---

### Space Complexity

```text
O(n)
```

Because recursive calls are stored in the call stack.

---

## Files

```text
FibonacciRecursion.java
README.md
```
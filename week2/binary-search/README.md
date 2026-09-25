#Binary Search
##Problem

Given an integer array nums sorted in ascending order and an integer target, find the index of target.

If target exists in the array, return its index. Otherwise, return -1.

The algorithm must have a runtime complexity of O(log n).

Example 1

Input:

nums = [-1, 0, 3, 5, 9, 12]
target = 9

Output:

4

Explanation:

The value 9 exists in the array at index 4.

Example 2

Input:

nums = [-1, 0, 3, 5, 9, 12]
target = 2

Output:

-1

Explanation:

The value 2 does not exist in the array.

Algorithm

Binary search works because the array is already sorted.

Set left to the first index.
Set right to the last index.
Calculate the middle index.
Compare nums[mid] with target.
If they are equal, return mid.
If nums[mid] is smaller than target, search the right half.
If nums[mid] is greater than target, search the left half.
If the search range becomes empty, return -1.
Java Implementation
class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }
}
Complexity
Time Complexity

O(log n)

Each iteration eliminates approximately half of the remaining elements.

Space Complexity

O(1)

Only a few variables are used, regardless of the input size.

Constraints
1 <= nums.length <= 10^4
-10^4 < nums[i], target < 10^4
All integers in nums are unique.
nums is sorted in ascending order.
Key Concept

Binary search is more efficient than linear search for a sorted array.

For example:

Linear Search:  O(n)
Binary Search:  O(log n)

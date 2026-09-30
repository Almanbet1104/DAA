public class BinarySearchRecursive {

    public static int binarySearchRecursive(
            int[] a, int target, int low, int high) {

        // Base case: target was not found
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;

        // Target found
        if (a[mid] == target) {
            return mid;
        }

        // Search left half
        if (target < a[mid]) {
            return binarySearchRecursive(
                    a, target, low, mid - 1
            );
        }

        // Search right half
        return binarySearchRecursive(
                a, target, mid + 1, high
        );
    }

    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        int result1 = binarySearchRecursive(
                a, 30, 0, a.length - 1
        );

        int result2 = binarySearchRecursive(
                a, 70, 0, a.length - 1
        );

        int result3 = binarySearchRecursive(
                a, 25, 0, a.length - 1
        );

        System.out.println("Search 30: index = " + result1);
        System.out.println("Search 70: index = " + result2);
        System.out.println("Search 25: index = " + result3);
    }
}
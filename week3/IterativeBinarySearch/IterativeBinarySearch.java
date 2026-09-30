public class BinarySearchIterative {

    public static int binarySearchIterative(int[] a, int target) {

        int low = 0;
        int high = a.length - 1;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (a[mid] == target) {
                return mid;

            } else if (target < a[mid]) {
                high = mid - 1;

            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        int[] a = {10, 20, 30, 40, 50, 60, 70, 80, 90};

        System.out.println(
                "Search 30: index = " +
                        binarySearchIterative(a, 30)
        );

        System.out.println(
                "Search 70: index = " +
                        binarySearchIterative(a, 70)
        );

        System.out.println(
                "Search 25: index = " +
                        binarySearchIterative(a, 25)
        );
    }
}
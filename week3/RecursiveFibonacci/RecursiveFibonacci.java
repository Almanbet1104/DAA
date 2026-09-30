public class FibonacciRecursion {

    // Recursive method to find the nth Fibonacci number
    public static int fibonacci(int n) {
        // Base case
        if (n <= 1) {
            return n;
        }

        // Recursive case
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

        // Example 1
        System.out.println("Fibonacci(5) = " + fibonacci(5));

        // Example 2
        System.out.println("Fibonacci(7) = " + fibonacci(7));

        // Example 3
        System.out.println("Fibonacci(10) = " + fibonacci(10));
    }
}
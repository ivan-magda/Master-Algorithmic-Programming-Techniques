import java.util.Scanner;

public class MaximizingAdRevenue {

    private static long maxDotProduct(long[] a, long[] b) {
        bubbleSort(a);
        bubbleSort(b);

        long result = 0;
        for (int i = 0; i < a.length; i++) {
            result += a[i] * b[i];
        }

        return result;
    }

    private static void bubbleSort(long[] array) {
        int length = array.length;
        long temp;

        for (int i = 0; i < length; ++i) {
            for (int j = 1; j < (length - i); ++j) {
                if (array[j - 1] < array[j]) {
                    temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(maxDotProduct(a, b));
    }
}

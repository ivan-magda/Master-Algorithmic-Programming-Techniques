import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class MajorityElement {

    private static int majorityNaive(int[] array) {
        for (int currentElement : array) {
            int count = 0;
            for (int i : array) {
                if (i == currentElement)
                    count++;
                if (count > array.length / 2)
                    return currentElement;
            }
        }

        return -1;
    }

    private static int findMajorityElement(int[] array, int start, int end) {
        if (start == end) return array[start];

        int middle = start + (end - start) / 2;
        int lhsElement = findMajorityElement(array, start, middle);
        int rhsElement = findMajorityElement(array, middle + 1, end);

        if (lhsElement == rhsElement) return lhsElement;

        int lhsCount = countForElementIn(array, start, end, lhsElement);
        int rhsCount = countForElementIn(array, start, end, rhsElement);

        int numberOfElements = end - start + 1;
        int threshold = numberOfElements / 2;

        if (lhsCount > threshold)
            return lhsElement;
        else if (rhsCount > threshold)
            return rhsElement;
        else return -1;
    }

    private static int countForElementIn(int[] array, int start, int end, int element) {
        int count = 0;
        for (int i = start; i <= end; ++i)
            if (element == array[i])
                count++;
        return count;
    }

    public static void main(String[] args) {
        baseInvocation();
    }

    private static void baseInvocation() {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        if (findMajorityElement(a, 0, a.length - 1) != -1) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    private static void stressTest() {
        while (true) {
            int n = randInt(1, 10);

            System.out.println("n = " + n);

            int[] a = new int[n];

            for (int i = 0; i < n; ++i) {
                int number = randInt(0, 20);
                a[i] = number;
                System.out.print(number + " ");
            }

            System.out.println("\n");

            int naive = majorityNaive(a);
            int divide = findMajorityElement(a, 0, a.length - 1);

            if (naive != divide) {
                System.out.println("Wrong answer: " + naive + " " + divide);
                break;
            } else {
                System.out.println("Ok");
            }
        }
    }

    private static int randInt(int min, int max) {
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    private static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}

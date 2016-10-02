import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;

public class RandomizedQuickSort {
    private static Random random = new Random();

    private static int[] partition3(int[] array, int startIdx, int endIdx) {
        int pivotElement = array[endIdx];

        int greaterIdx = startIdx;
        int equalIdx = endIdx;
        int i = startIdx;

        // equal elements places from the left of pivot element (right most).
        // < pivot on starter indexes.
        // > pivot after last < pivot element.
        // Scheme "<", ">", "=".
        while (i < endIdx && i < equalIdx) {
            if (array[i] < pivotElement) {
                swap(array, i++, greaterIdx++);
            } else if (array[i] == pivotElement) {
                swap(array, i, --equalIdx);
            } else {
                i++;
            }
        }

        int middleStartIdx = greaterIdx;
        int middleEndIdx = middleStartIdx;

        // Place equal elements between < and > elements.
        int numberOfEquals = (endIdx - equalIdx) + 1;
        if (numberOfEquals == 1) {
            swap(array, greaterIdx, endIdx);
        } else {
            int[] greaterElements = new int[equalIdx - greaterIdx];

            i = greaterIdx;
            int j = 0;

            // Copy greater elements.
            while (i < equalIdx) {
                greaterElements[j++] = array[i++];
            }

            // Place pivot and greater than pivot elements in right place.
            i = greaterIdx;
            j = 0;
            while (j++ < numberOfEquals) {
                middleEndIdx = i;
                array[i++] = pivotElement;
            }

            j = 0;
            while (j < greaterElements.length) {
                array[i++] = greaterElements[j++];
            }
        }

        return new int[]{middleStartIdx, middleEndIdx};
    }

    private static int partition2(int[] array, int startIdx, int endIdx) {
        int q = startIdx;

        for (int i = startIdx; i < endIdx; ++i) {
            if (array[i] <= array[endIdx]) {
                swap(array, i, q++);
            }
        }

        swap(array, q, endIdx);

        return q;
    }

    private static void randomizedQuickSort(int[] array, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int randPivotIdx = random.nextInt(endIdx - startIdx + 1) + startIdx;
            swap(array, endIdx, randPivotIdx);

            int[] pivotIndexes = partition3(array, startIdx, endIdx);
            randomizedQuickSort(array, startIdx, pivotIndexes[0] - 1);
            randomizedQuickSort(array, pivotIndexes[1] + 1, endIdx);
        }
    }

    private static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);

        int n = scanner.nextInt();

        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        randomizedQuickSort(a, 0, n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print(a[i] + " ");
        }
    }

    private static void test() {
        int[] array = {5, 3, 4, 9, 8, 4, 4, 10};
        randomizedQuickSort(array, 0, array.length - 1);

        System.out.print("After sorting: ");
        for (int item : array)
            System.out.print(item + " ");
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



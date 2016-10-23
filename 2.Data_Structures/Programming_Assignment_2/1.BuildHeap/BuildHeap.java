import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BuildHeap {
    private int[] array;
    private List<Swap> swaps = new ArrayList<>();

    private FastScanner in;
    private PrintWriter out;

    public static void main(String[] args) throws IOException {
        new BuildHeap().solve();
    }

    private void solve() throws IOException {
        in = new FastScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));
        readData();
        generateSwaps();
        writeResponse();
        out.close();
    }

    private void readData() throws IOException {
        int n = in.nextInt();
        array = new int[n];
        for (int i = 0; i < n; ++i) array[i] = in.nextInt();
    }

    private void writeResponse() {
        out.println(swaps.size());
        for (Swap swap : swaps) out.println(swap.index1 + " " + swap.index2);
    }

    private void generateSwaps() {
        int firstNonLeaf = (int) Math.floor(array.length / 2.0) - 1;
        for (int i = firstNonLeaf; i >= 0; i--)
            shiftDown(i);
    }

    private void shiftDown(int index) {
        int parentIndex = index;

        while (true) {
            int leftChildIndex = 2 * parentIndex + 1;
            int rightChildIndex = leftChildIndex + 1;

            int first = parentIndex;
            if (leftChildIndex < array.length && array[first] > array[leftChildIndex])
                first = leftChildIndex;
            if (rightChildIndex < array.length && array[first] > array[rightChildIndex])
                first = rightChildIndex;

            if (first == parentIndex) return;

            swap(parentIndex, first);
            parentIndex = first;
        }
    }

    private void swap(int parentIndex, int childIndex) {
        swaps.add(new Swap(parentIndex, childIndex));
        int tmp = array[parentIndex];
        array[parentIndex] = array[childIndex];
        array[childIndex] = tmp;
    }

    private static class Swap {
        int index1;
        int index2;

        Swap(int index1, int index2) {
            this.index1 = index1;
            this.index2 = index2;
        }
    }

    private static class FastScanner {
        private BufferedReader reader;
        private StringTokenizer tokenizer;

        FastScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
            tokenizer = null;
        }

        String next() throws IOException {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                tokenizer = new StringTokenizer(reader.readLine());
            }
            return tokenizer.nextToken();
        }

        int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
    }

}

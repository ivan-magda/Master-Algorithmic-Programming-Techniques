public class QuickSort {

    private static void quickSort(int[] array, int startIdx, int endIdx) {
        if (startIdx < endIdx) {
            int pivotIdx = partition(array, startIdx, endIdx);
            quickSort(array, startIdx, pivotIdx - 1);
            quickSort(array, pivotIdx + 1, endIdx);
        }
    }

    private static int partition(int[] array, int startIdx, int endIdx) {
        // Compare array[j] with array[r], for j = startIdx, p+1,...endIdx-1
        // maintaining that:
        //  array[startIdx..q-1] are values known to be <= to array[endIdx]
        //  array[q..j-1] are values known to be > array[endIdx]
        //  array[j..endIdx-1] haven't been compared with array[endIdx]
        // If array[j] > array[endIdx], just increment j.
        // If array[j] <= array[endIdx], swap array[j] with array[q],
        //   increment q, and increment j.
        // Once all elements in array[startIdx..endIdx-1]
        //  have been compared with array[endIdx],
        //  swap array[endIdx] with array[q], and return q.

        int q = startIdx;

        for (int j = startIdx; j < endIdx; ++j) {
            if (array[j] <= array[endIdx]) {
                swap(array, j, q++);
            }
        }

        swap(array, q, endIdx);

        return q;
    }

    private static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }

    public static void main(String[] args) {
        int[] array = {9, 7, 5, 11, 12, 2, 14, 3, 10, 4, 6};
        quickSort(array, 0, array.length - 1);

        System.out.print("After sorting: ");
        for (int item : array)
            System.out.print(item + " ");

    }

}

public class MergeSort {

    private static void merge(int[] array, int start, int middle, int end) {
        int[] lowHalf = new int[middle - start + 1];
        int[] highHalf = new int[end - middle];

        int k = start;
        int i, j;

        for (i = 0; k <= middle; ++i, ++k)
            lowHalf[i] = array[k];
        for (j = 0; k <= end; ++j, ++k)
            highHalf[j] = array[k];

        k = start;
        i = 0;
        j = 0;

        // Repeatedly compare the lowest untaken element in
        // lowHalf with the lowest untaken element in highHalf
        // and copy the lower of the two back into array.

        while (i < lowHalf.length && j < highHalf.length) {
            if (lowHalf[i] < highHalf[j]) {
                array[k++] = lowHalf[i++];
            } else {
                array[k++] = highHalf[j++];
            }
        }

        // Once one of lowHalf and highHalf has been fully copied
        // back into array, copy the remaining elements from the
        // other temporary array back into the array.

        while (i < lowHalf.length)
            array[k++] = lowHalf[i++];
        while (j < highHalf.length)
            array[k++] = highHalf[j++];
    }

    private static void mergeSort(int[] array, int start, int end) {
        if (start < end) {
            int middle = start + (end - start) / 2;

            mergeSort(array, start, middle);
            mergeSort(array, middle + 1, end);

            merge(array, start, middle, end);
        }
    }

    public static void main(String[] args) {
        int[] array = {14, 7, 3, 12, 9, 11, 6, 2};
        mergeSort(array, 0, array.length - 1);

        System.out.print("Array after sorting: ");
        for (int item: array) {
            System.out.print(item + " ");
        }
    }

}

public class SelectionSort {

    private static void swap(int[] array, int firstIdx, int secondIdx) {
        int temp = array[firstIdx];
        array[firstIdx] = array[secondIdx];
        array[secondIdx] = temp;
    }

    private static int minimumIndexOf(int[] array, int startIdx) {
        int minValue = array[startIdx];
        int minIdx = startIdx;

        for (int i = startIdx + 1; i < array.length; ++i) {
            if (minValue > array[i]) {
                minValue = array[i];
                minIdx = i;
            }
        }

        return minIdx;
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            int minIdx = minimumIndexOf(array, i);
            swap(array, minIdx, i);
        }
    }

    public static void main(String[] args) {
        int[] array = {22, 7, -1, 11, 99, 88, 9, 7, 42};

        System.out.print("Before: ");
        printArray(array);
        System.out.println("\n");

        sort(array);
        System.out.print("After: ");
        printArray(array);
    }

    private static void printArray(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
    }

}

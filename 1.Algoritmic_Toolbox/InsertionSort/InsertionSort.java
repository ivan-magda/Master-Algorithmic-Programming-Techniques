public class InsertionSort {

    private static void insert(int[] array, int rightIndex, int value) {
        int i = rightIndex;

        while (i >= 0 && array[i] > value) {
            array[i + 1] = array[i];
            --i;
        }

        array[i + 1] = value;
    }

    private static void sort(int[] array) {
        for (int i = 1; i < array.length; ++i) {
            if (array[i - 1] > array[i]) {
                insert(array, i - 1, array[i]);
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {22, 11, 99, 88, 9, 11, 7, 42, 0};

        System.out.print("Before: ");
        printArrayWithCollon(array);
        System.out.println("\n");

        sort(array);
        System.out.print("After: ");
        printArrayWithCollon(array);
    }

    private static void printArrayWithCollon(int[] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(array[i] + (i == array.length - 1 ? "" : ", "));
        }
    }

}

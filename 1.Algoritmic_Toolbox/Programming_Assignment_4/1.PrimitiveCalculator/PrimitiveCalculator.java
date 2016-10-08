import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import static java.lang.Integer.min;

public class PrimitiveCalculator {

    private static List<Integer> optimalSequence(int number) {
        List<Integer> sequence = new ArrayList<>();

        while (number >= 1) {
            sequence.add(number);
            if (number % 3 == 0) {
                number /= 3;
            } else if (number % 2 == 0) {
                number /= 2;
            } else {
                number -= 1;
            }
        }
        Collections.reverse(sequence);

        return sequence;
    }

    private static List<Integer> dpOptimalSequence(int number) {
        int[] arr = new int[number + 1];

        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i - 1] + 1;
            if (i % 2 == 0) arr[i] = min(1 + arr[i / 2], arr[i]);
            if (i % 3 == 0) arr[i] = min(1 + arr[i / 3], arr[i]);
        }

        List<Integer> sequence = new ArrayList<>();
        for (int i = number; i > 1; ) {
            sequence.add(i);
            if (arr[i - 1] == arr[i] - 1)
                i = i - 1;
            else if (i % 2 == 0 && (arr[i / 2] == arr[i] - 1))
                i = i / 2;
            else if (i % 3 == 0 && (arr[i / 3] == arr[i] - 1))
                i = i / 3;
        }
        sequence.add(1);
        Collections.reverse(sequence);

        return sequence;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();

        List<Integer> sequence = dpOptimalSequence(number);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }

}

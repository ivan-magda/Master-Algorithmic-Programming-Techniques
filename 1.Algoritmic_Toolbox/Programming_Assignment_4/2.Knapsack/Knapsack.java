import java.util.Scanner;

import static java.lang.Integer.max;

public class Knapsack {

    private static int optimalWeight(int W, int[] w) {
        int rows = w.length + 1;
        int columns = W + 1;
        int[][] value = new int[rows][columns];

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (w[i - 1] > j)
                    value[i][j] = value[i - 1][j];
                else
                    value[i][j] = max(w[i - 1] + value[i - 1][j - w[i - 1]], value[i - 1][j]);
            }
        }

        return value[w.length][W];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();

        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }

        System.out.println(optimalWeight(W, w));
    }

}

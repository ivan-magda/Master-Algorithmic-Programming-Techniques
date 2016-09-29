package com.ivanmagda;

import java.util.Scanner;

public class Fibonacci {

    public static long computeFibonacci(int n) {
        if (n <= 1) {
            return n;
        }

        long[] numbers = new long[n + 1];

        numbers[0] = 0;
        numbers[1] = 1;

        for (int i = 2; i < numbers.length; ++i) {
            numbers[i] = numbers[i - 1] + numbers[i - 2];
        }

        return numbers[n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = scanner.nextInt();
        System.out.println(computeFibonacci(number));

        scanner.close();
    }

}

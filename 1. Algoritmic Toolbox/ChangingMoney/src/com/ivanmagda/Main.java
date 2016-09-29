package com.ivanmagda;

import java.util.Scanner;

public class Main {

    private static int getChange(int m) {
        if (m < 1) return 0;

        int currentValue = m;
        int numberOfCoins = 0;

        while (currentValue > 0) {
            if (currentValue >= 10) {
                currentValue -= 10;
            } else if (currentValue >= 5) {
                currentValue -= 5;
            } else {
                if (currentValue < 5) {
                    return (numberOfCoins + currentValue);
                } else {
                    currentValue -= 1;
                }
            }

            numberOfCoins++;
        }

        return numberOfCoins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

        scanner.close();
    }

}

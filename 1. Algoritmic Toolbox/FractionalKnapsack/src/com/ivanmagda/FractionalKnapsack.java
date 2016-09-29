package com.ivanmagda;

import java.util.ArrayList;
import java.util.Scanner;

public class FractionalKnapsack {

    private static void bubbleSort(ArrayList<Item> items) {
        int n = items.size();
        Item temp;

        // Descending sort.

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (items.get(j - 1).unitPrice() < items.get(j).unitPrice()) {
                    temp = items.get(j - 1);
                    items.set(j - 1, items.get(j));
                    items.set(j, temp);
                }
            }
        }
    }

    private static class Item {
        private int value;
        private int weight;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
        }

        double unitPrice() {
            return (double) value / weight;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "value=" + value +
                    ", weight=" + weight +
                    '}';
        }
    }

    private static double getOptimalValue(int capacity, ArrayList<Item> items) {
        double value = 0;
        bubbleSort(items);

        for (int i = 0; i < items.size(); ++i) {
            if (capacity == 0) return value;

            Item item = items.get(i);
            int amount = Math.min(item.weight, capacity);

            capacity -= amount;
            value += amount * item.unitPrice();
        }

        return value;
    }

    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int numberOfItems = scanner.nextInt();
        int capacity = scanner.nextInt();
        ArrayList<Item> items = new ArrayList<>(numberOfItems);

        for (int i = 0; i < numberOfItems; i++) {
            int value = scanner.nextInt();
            int weight = scanner.nextInt();

            items.add(new Item(value, weight));
        }

        System.out.println(String.format("%.4f", getOptimalValue(capacity, items)));

        scanner.close();
    }

}

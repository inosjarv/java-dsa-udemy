package io.dsa.divideandconquer;

public class ZeroOneKnapsack {

    public static void main(String[] args) {
        int[] profits = {31, 26, 17, 72}, weights = {3, 1, 2, 5};
        int capacity = 7;
        System.out.println(zeroOneKnapsack(profits, weights, capacity));
    }

    public static int zeroOneKnapsack(int[] profits, int[] weights, int capacity) {
        return zeroOneKnapsack(profits, weights, capacity, 0);
    }

    private static int zeroOneKnapsack(int[] profits, int[] weights, int capacity, int currentIndex) {
        if (capacity <= 0 || currentIndex < 0 || currentIndex >= profits.length)
            return 0;

        int profit1 = 0;
        if (weights[currentIndex] <= capacity)
            profit1 = profits[currentIndex]
                    + zeroOneKnapsack(profits, weights,
                    capacity - weights[currentIndex], currentIndex + 1);

        int profit2 = zeroOneKnapsack(profits, weights, capacity,
                currentIndex + 1);

        return Math.max(profit1, profit2);
    }
}

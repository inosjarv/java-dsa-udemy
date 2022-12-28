package io.dsa.greedy;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10, 20, 50, 10, 1000};
        coinChange(coins, 2035);
    }

    static void coinChange(int[] coins, int N) {
        Arrays.sort(coins);
        int index = coins.length - 1;
        do {
            int coinValue = coins[index];
            index--;
            int maxAmount = (N / coinValue) * coinValue;
            if (maxAmount > 0) {
                System.out.println("Coin Value: " + coinValue +
                        " taken count: " + N / coinValue);
                N -= maxAmount;
            }
        } while (N != 0);
    }
}

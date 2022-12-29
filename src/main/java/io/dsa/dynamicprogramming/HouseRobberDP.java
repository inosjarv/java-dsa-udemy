package io.dsa.dynamicprogramming;

import java.util.Arrays;

public class HouseRobberDP {
    public static void main(String[] args) {
        int[] houses = {6, 7, 1, 30, 8, 2, 4};
        System.out.println(houseRobberRecursive(houses));
        System.out.println(houseRobberMemo(houses));
        System.out.println(houseRobberDP(houses));
    }

    public static int houseRobber(int[] houses, int currentHouse) {
        if (currentHouse >= houses.length) return 0;
        int pick = houses[currentHouse] +
                houseRobber(houses, currentHouse + 2);
        int skip = houseRobber(houses, currentHouse + 1);
        return Math.max(pick, skip);
    }

    public static int houseRobberMemo(int[] houses) {
        int[] memo = new int[houses.length + 1];
        Arrays.fill(memo, -1);
        return houseRobber(houses, 0, memo);
    }

    public static int houseRobberDP(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n + 2];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Math.max(houses[i] + dp[i + 2], dp[i + 1]);
        }

        return dp[0];
    }

    public static int houseRobber(int[] houses, int currentHouse, int[] memo) {
        if (currentHouse >= houses.length) return 0;
        if (memo[currentHouse] == -1) {
            int pick = houses[currentHouse] +
                    houseRobber(houses, currentHouse + 2, memo);
            int skip = houseRobber(houses, currentHouse + 1, memo);

            memo[currentHouse] = Math.max(pick, skip);
        }
        return memo[currentHouse];
    }

    public static int houseRobberRecursive(int[] houses) {
        return houseRobber(houses, 0);
    }
}

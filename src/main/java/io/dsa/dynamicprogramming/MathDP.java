package io.dsa.dynamicprogramming;

import java.util.*;

public class MathDP {
    public static void main(String[] args) {
        System.out.println(fibonacci(25, new HashMap<>()));
        System.out.println(fibonacciDP(25));
        System.out.println(fibonacci(20, new HashMap<>()));
        System.out.println(fibonacciDP(20));

        System.out.println();
        for (int i = 0; i <= 33; i += 11) {
            if (i == 33) {
                System.out.print(waysToGetNDP(i));
            } else System.out.print(waysToGetNDP(i) + ", ");
        }

        System.out.println();
        for (int i = 0; i <= 33; i += 11) {
            if (i == 33) {
                System.out.print(waysToGetNMemo(i));
            } else System.out.print(waysToGetNMemo(i) + ", ");
        }
    }

    static int fibonacciDP(int n) {
        List<Integer> dp = new ArrayList<>();
        dp.add(0);
        dp.add(1);

        for (int i = 2; i < n; i++) {
            int n1 = dp.get(i - 1);
            int n2 = dp.get(i - 2);
            dp.add(n1 + n2);
        }
        return dp.get(n - 1);
    }

    static int fibonacci(int n, Map<Integer, Integer> memo) {
        if (n == 1) return 0;
        if (n == 2) return 1;

        if (!memo.containsKey(n)) memo.put(n, fibonacci(n - 1, memo) + fibonacci(n - 2, memo));

        return memo.get(n);
    }

    static int waysToGetN(int n, int[] dp) {
        if (n == 0 || n == 1 || n == 2) return 1;
        if (n == 3) return 2;

        if (dp[n] == -1) {
            dp[n] = waysToGetN(n - 1, dp) + waysToGetN(n - 3, dp) + waysToGetN(n - 4, dp);
        }

        return dp[n];
    }

    static int waysToGetNMemo(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return waysToGetN(n, dp);
    }

    static int waysToGetNDP(int n) {
        if (n == 0 || n == 1 || n == 2) return 1;
        if (n == 3) return 2;

        int[] dp = new int[n + 1];
        dp[0] = dp[1] = dp[2] = 1;
        dp[3] = 2;

        for (int i = 4; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 3] + dp[i - 4];
        }

        return dp[n];
    }
}

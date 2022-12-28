package io.dsa.divideandconquer;

public class MathDivideAndConquer {
    public static void main(String[] args) {
        System.out.println("======================== Fibonacci ========================");
        for (int i = 0; i < 12; i++) {
            if (i == 11) System.out.print(fibonacci(i));
            else System.out.print(fibonacci(i) + ", ");
        }
        System.out.println();
        System.out.println("======================== WaysToGet ========================");

        for (int i = 0; i <= 33; i += 11) {
            if (i == 33) System.out.print(waysToGetN(i));
            else System.out.print(waysToGetN(i) + ", ");
        }
    }

    static int fibonacci(int n) {
        if (n < 0) throw new IllegalStateException();
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static int waysToGetN(int n) {
        if (n == 0 || n == 1 || n == 2) return 1;
        if (n == 3) return 2;

        return waysToGetN(n - 1) + waysToGetN(n - 3) + waysToGetN(n - 4);
    }
}

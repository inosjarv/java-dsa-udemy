package io.dsa.hashing;

public class HashUtils {
    private HashUtils() {
    }

    public static int modASCIIHashFun(String word, int MOD) {
        int sum = 0;
        for (char c : word.toCharArray())
            sum += c;

        return sum % MOD;
    }

    public static int addAllDigits(int sum) {
        int result = 0;
        while (sum > 0) {
            result += sum % 10;
            sum = sum / 10;
        }
        return result;
    }
}

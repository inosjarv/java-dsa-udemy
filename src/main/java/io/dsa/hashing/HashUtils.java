package io.dsa.hashing;

public class HashUtils {
    private HashUtils(){}
    public static int modASCIIHashFun(String word, int MOD) {
        int sum = 0;
        for (char c : word.toCharArray())
            sum += c;

        return sum % MOD;
    }

}

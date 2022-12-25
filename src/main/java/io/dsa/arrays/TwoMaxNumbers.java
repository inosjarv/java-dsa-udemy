package io.dsa.arrays;

public class TwoMaxNumbers {
    static String firstSecond(int[] arr) {
        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num: arr) {
            if (num > first) {
                second = first;
                first = num;
            } else {
                second = Math.max(second, num);
            }
        }

        return first + " " + second;
    }

    public static void main(String[] args) {
        System.out.println(firstSecond(new int[] {84,85,86,87,85,90,85,83,23,45,84,1,2,0}));
    }
}

package io.dsa.divideandconquer;

public class HouseRobber {
    public static void main(String[] args) {
        int[] houses = {6, 7, 1, 30, 8, 2, 4};
        System.out.println(maxMoney(houses));
    }

    public static int houseRobber(int[] houses, int currentHouse) {
        if (currentHouse >= houses.length) return 0;
        int pick = houses[currentHouse] + houseRobber(houses, currentHouse + 2);
        int skip = houseRobber(houses, currentHouse + 1);
        return Math.max(pick, skip);
    }

    public static int maxMoney(int[] houses) {
        return houseRobber(houses, 0);
    }
}

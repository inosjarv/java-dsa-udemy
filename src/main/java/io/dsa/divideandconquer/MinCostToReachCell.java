package io.dsa.divideandconquer;

public class MinCostToReachCell {

    public static void main(String[] args) {
        int[][] cost = {{4, 7, 8, 6, 4}, {6, 7, 3, 9, 2}, {3, 8, 1, 2, 4}, {7, 1, 7, 3, 7}, {2, 9, 8, 9, 3}};
        System.out.println(findMinCost(cost));
    }

    public static int findMinCost(int[][] cost) {
        return findMinCost(cost, cost.length - 1, cost[0].length - 1);
    }

    private static int findMinCost(int[][] cost, int row, int col) {
        if (row < 0 || col < 0) return Integer.MAX_VALUE;

        if (row == 0 && col == 0) return cost[row][col];

        return cost[row][col] + Math.min(findMinCost(cost, row - 1, col), findMinCost(cost, row, col - 1));
    }
}

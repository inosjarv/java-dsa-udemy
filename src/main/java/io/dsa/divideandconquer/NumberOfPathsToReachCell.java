package io.dsa.divideandconquer;

public class NumberOfPathsToReachCell {

    public static void main(String[] args) {
        int[][] matrix = {{4, 7, 1, 6}, {5, 7, 3, 9}, {3, 2, 1, 2}, {7, 1, 6, 3}};
        int cost = 25;
        System.out.println(findNumPaths(matrix, cost));
    }

    public static int findNumPaths(int[][] matrix, int cost) {
        return findNumPaths(matrix, matrix.length - 1, matrix[0].length - 1, cost);
    }

    private static int findNumPaths(int[][] matrix, int row, int col, int cost) {
        if (cost < 0) return 0;
        else if (row == 0 && col == 0) {
            if (matrix[0][0] - cost == 0)
                return 1;
            else
                return 0;
        } else if (row == 0)
            return findNumPaths(matrix, 0, col - 1, cost - matrix[row][col]);

        else if (col == 0)
            return findNumPaths(matrix, row - 1, 0, cost - matrix[row][col]);

        return findNumPaths(matrix, row - 1, col, cost - matrix[row][col])
                + findNumPaths(matrix, row, col - 1, cost - matrix[row][col]);
    }
}

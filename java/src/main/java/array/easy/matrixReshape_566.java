package Array.easy;

import java.util.LinkedList;
import java.util.Queue;

public class matrixReshape_566 {

    public int[][] queueSolution(int[][] mat, int r, int c) {

        /**
         * time comp: O(m*n)
         * space comp: O(m*n) 큐 사이즈가 m * n.
         */

        int[][] res = new int[r][c];

        if (mat.length == 0 || r * c != mat.length * mat[0].length )
            return mat;

        Queue<Integer> hold = new LinkedList<>();

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                hold.add(mat[i][j]);
            }
        }


        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                res[i][j] = hold.remove();
            }
        }
        return res;
    }

    public int[][] noExtraSpace(int[][] mat, int r, int c) {
        int[][] res = new int[r][c];

        if (mat.length == 0 || r * c != mat.length * mat[0].length )
            return mat;

        int row = 0, col = 0;

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                res[row][col] = mat[i][j];
                col++;
                if (col == c) {
                    row++;
                    c = 0;
                }
            }
        }

        return res;
    }
}

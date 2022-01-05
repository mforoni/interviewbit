package interviewbit;

/**
 * <pre>
 * Problem Description
 *
 * Given numRows, generate the first numRows of Pascal's triangle.
 * Pascal's triangle : To generate A[C] in row R, sum up A'[C] and A'[C-1] from previous row R - 1.
 *
 * Example:
 *
 * Given numRows = 5,
 *
 * Return
 *
 * [
 *      [1],
 *      [1,1],
 *      [1,2,1],
 *      [1,3,3,1],
 *      [1,4,6,4,1]
 * ]
 * Constraints:
 * 0 <= numRows <= 25
 * </pre>
 * @see <a href="https://www.interviewbit.com/problems/pascal-triangle/">www.interviewbit.com/problems/pascal-triangle</a>
 */
public class PascalTriangle {

    /**
     * Given N the number of rows:<br>
     * Time complexity is O(N^2)<br>
     * Space complexity is O(N^2)
     *
     * @param A
     * @return
     */
    public int[][] solve(int A) {
        if (A == 0) {
            return new int[0][0];
        }
        final int [][] pascalTriangle = new int[A][];
        pascalTriangle[0] = new int[1];
        pascalTriangle[0][0] = 1;
        for (int r = 1; r < A; r++) {
            int columns = pascalTriangle[r-1].length + 1;
            pascalTriangle[r] = new int[columns];
            pascalTriangle[r][0] = 1;
            for (int c = 1; c < columns; c++) {
                pascalTriangle[r][c] = c < pascalTriangle[r-1].length ?
                        pascalTriangle[r-1][c-1] + pascalTriangle[r-1][c] :
                        pascalTriangle[r-1][c-1];
            }
        }
        return pascalTriangle;
    }
}

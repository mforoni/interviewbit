package interviewbit;

import interviewbit.util.MoreInts;

import java.util.Arrays;

/**
 * <pre>
 * Determine if a Sudoku is valid, according to: http://sudoku.com.au/TheRules.aspx
 *
 * The Sudoku board could be partially filled, where empty cells are filled with the character ‘.’.
 *
 * image at https://www.interviewbit.com/problems/valid-sudoku
 *
 * The input corresponding to the above configuration :
 *
 * ["53..7....", "6..195...", ".98....6.", "8...6...3", "4..8.3..1", "7...2...6", ".6....28.", "...419..5", "....8..79"]
 * A partially filled sudoku which is valid.
 *
 * Note:
 *
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * Return 0 / 1 ( 0 for false, 1 for true ) for this problem
 * </pre>
 */
public class ValidSudoku {
    public int isValidSudoku(final String[] A) {
        if (A.length != 9) {
            return 0;
        }
        for (int i = 0; i < 9; i++) {
            if (A[i].length() != 9) {
                return 0;
            }
        }
        final int[][] sudoku = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = A[i].charAt(j) != '.' ? Character.getNumericValue(A[i].charAt(j)) : 0;
            }
        }
        //MoreInts.print(sudoku);
        // Validate rows: Each row must have the numbers 1-9 occuring just once.
        for (int i = 0; i < 9; i++) {
            final int[] occurrences = new int[10];
            for (int j = 0; j < 9; j++) {
                occurrences[sudoku[i][j]] += 1;
            }
            //System.out.println(String.format("Row validation %d: %s", i, Arrays.toString(occurrences)));
            for (int k = 1; k <= 9; k++) {
                if (occurrences[k] > 1) {
                    return 0;
                }
            }
        }
        // Validate columns: Each column must have the numbers 1-9 occuring just once.
        for (int j = 0; j < 9; j++) {
            final int[] occurrences = new int[10];
            for (int i = 0; i < 9; i++) {
                occurrences[sudoku[i][j]] += 1;
            }
            for (int k = 1; k <= 9; k++) {
                if (occurrences[k] > 1) {
                    return 0;
                }
            }
        }
        // Validate boxes: And the numbers 1-9 must occur just once in each of the 9 sub-boxes of the grid.
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                final int[] occurrences = new int[10];
                for (int k = 0; k < 9; k++) {
                    final int r = 3 * i + k % 3;
                    final int c = 3 * j + k / 3;
                    occurrences[sudoku[r][c]] += 1;
                }
                for (int k = 1; k <= 9; k++) {
                    if (occurrences[k] > 1) {
                        return 0;
                    }
                }
            }
        }
        return 1;
    }
}

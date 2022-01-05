package interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidSudokuTest {

    private static final String[] A1 = new String[] {
            "53..7....",
            "6..195...",
            ".98....6.",
            "8...6...3",
            "4..8.3..1",
            "7...2...6",
            ".6....28.",
            "...419..5",
            "....8..79"};
    private static final int SOL1 = 1;

    private static final String[] A2 = new String[] {
            "........4",
            ".9.7...9.",
            ".......6.",
            ".7.......",
            ".1.......",
            ".........",
            ".8.....1.",
            "3....2..6",
            ".......7." };
    private static final int SOL2 = 0;


    @Test
    public void testIsValidSudoku() {
        final ValidSudoku validSudoku = new ValidSudoku();

        assertEquals(SOL1, validSudoku.isValidSudoku(A1));
        assertEquals(SOL2, validSudoku.isValidSudoku(A2));
    }
}
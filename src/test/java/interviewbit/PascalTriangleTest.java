package interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PascalTriangleTest {

    private final int NUM_ROWS1 = 5;
    private final int[][] SOL1 = new int[][]
            {
                    {1},
                    {1,1},
                    {1, 2, 1},
                    {1, 3, 3, 1},
                    {1, 4, 6, 4, 1}
            };
    private final int NUM_ROWS2 = 1;
    private final int[][] SOL2 = new int[][]
            {
                {1}
            };
    private final int NUM_ROWS3 = 0;
    private final int[][] SOL3 = new int[][] { };

    @Test
    public void testSolve() {
        final PascalTriangle pascalTriangle = new PascalTriangle();
        assertArrayEquals(SOL1, pascalTriangle.solve(NUM_ROWS1));
        assertArrayEquals(SOL2, pascalTriangle.solve(NUM_ROWS2));
        assertArrayEquals(SOL3, pascalTriangle.solve(NUM_ROWS3));
    }
}
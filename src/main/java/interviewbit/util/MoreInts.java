package interviewbit.util;

import java.util.Arrays;

public class MoreInts {

    private MoreInts() {
    }

    public static void print(int[][] matrix) {
        Arrays.stream(matrix).forEach((i) -> {
            Arrays.stream(i).forEach((j) -> System.out.print(j + " "));
            System.out.println();
        });
    }
}

package interviewbit;

import interviewbit.util.MoreInts;

/**
 * <pre>
 * Given two strings A and B, find the minimum number of steps required to convert A to B. (each operation is counted as 1 step.)
 *
 * You have the following 3 operations permitted on a word:
 * - Insert a character
 * - Delete a character
 * - Replace a character
 *
 * Input Format:
 * - The first argument of input contains a string, A.
 * - The second argument of input contains a string, B.
 *
 * Output Format:
 * Return an integer, representing the minimum number of steps required.
 * Constraints:
 *
 * 1 <= length(A), length(B) <= 450
 *
 * Examples:
 *
 * Input 1:
 *     A = "abad"
 *     B = "abac"
 *
 * Output 1:
 *     1
 *
 * Explanation 1:
 *     Operation 1: Replace d with c.
 *
 * Input 2:
 *     A = "Anshuman"
 *     B = "Antihuman"
 *
 * Output 2:
 *     2
 *
 * Explanation 2:
 *     => Operation 1: Replace s with t.
 *     => Operation 2: Insert i.
 * </pre>
 * @see <a href="https://www.interviewbit.com/problems/edit-distance/">www.interviewbit.com/problems/edit-distance</a>
 */
public class EditDistance {

    public int minDistance(String A, String B) {
        if (A.isEmpty() && B.isEmpty()) {
            return 0;
        }
        else if (A.isEmpty()) {
            // Only option insert character in A
            int result = 1 + minDistance(A, B.substring(1));
            //System.out.println(String.format("A = %s, B = %s, result = %d", A, B, result));
            return result;
        }
        else if (B.isEmpty()) {
            // Only option delete character in A
            int result = 1 + minDistance(A.substring(1), B);
            //System.out.println(String.format("A = %s, B = %s, result = %d", A, B, result));
            return result;
        }
        else {
            if (A.charAt(0) == B.charAt(0)) {
                return minDistance(A.substring(1), B.substring(1));
            }
            // insert character in A matching character in B
            int insert = 1 + minDistance(A, B.substring(1));
            // delete character in A
            int delete = 1 + minDistance(A.substring(1), B);
            // replace character in A
            int replace = 1 + minDistance(A.substring(1), B.substring(1));
            //System.out.println(String.format("A = %s, B = %s, insert = %d", A, B, insert));
            //System.out.println(String.format("A = %s, B = %s, delete = %d", A, B, delete));
            //System.out.println(String.format("A = %s, B = %s, replace = %d", A, B, replace));
            int min = Math.min(insert, delete);
            return Math.min(min, replace);
        }
    }

    /**
     * Given N = length(A) and M = length(B):</br>
     * Time complexity is O(N*M)
     * Space complexity is O(N*M)
     *
     * @param A
     * @param B
     * @return
     */
    public static int efficientMinDistance(String A, String B) {
        final int M = A.length();
        final int N = B.length();
        final int[][] minDistance = new int[M+1][N+1];
        minDistance[0][0] = 0;
        for (int i = 1; i <= M; i++) {
            minDistance[i][0] = 1 + minDistance[i-1][0];
        }
        for (int j = 1; j <= N; j++) {
            minDistance[0][j] = 1 + minDistance[0][j-1];
        }
        for (int i = 1; i <= M; i ++) {
            for (int j = 1; j <= N; j++) {
                if (A.charAt(i-1) == B.charAt(j-1)) {
                    minDistance[i][j] = min(minDistance[i-1][j-1], minDistance[i-1][j] + 1, minDistance[i][j-1] + 1);
                } else {
                    minDistance[i][j] = min(minDistance[i-1][j-1] + 1, minDistance[i-1][j] + 1, minDistance[i][j-1] + 1);
                }
            }
        }
        //MoreInts.print(minDistance);
        return minDistance[M][N];
    }

    private static int min(int a, int b, int c) {
        if (a < b) {
            return Math.min(a, c);
        } else {
            return Math.min(b, c);
        }
    }
}

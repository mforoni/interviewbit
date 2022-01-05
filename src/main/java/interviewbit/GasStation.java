package interviewbit;

/**
 * <pre>
 * Given two integer arrays A and B of size N.
 *
 * There are N gas stations along a circular route, where the amount of gas at station i is A[i].
 *
 * You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i to its next station
 * (i+1). You begin the journey with an empty tank at one of the gas stations.
 *
 * Return the minimum starting gas station’s index if you can travel around the circuit once, otherwise return -1.
 *
 * You can only travel in one direction. i to i+1, i+2, … n-1, 0, 1, 2.. Completing the circuit means starting at i
 * and ending up at i again.
 *
 * Input Format
 * - The first argument given is the integer array A.
 * - The second argument given is the integer array B.
 *
 * Output Format
 * - Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
 *
 * For Example
 *
 * Input 1:
 *     A =  [1, 2]
 *     B =  [2, 1]
 * Output 1:
 *     1
 * Explanation 1:
 * - If you start from index 0, you can fill in A[0] = 1 amount of gas. Now your tank has 1 unit of gas.
 * But you need B[0] = 2 gas to travel to station 1.
 * - If you start from index 1, you can fill in A[1] = 2 amount of gas. Now your tank has 2 units of gas.
 * You need B[1] = 1 gas to get to station 0. So, you travel to station 0 and still have 1 unit of gas left over.
 * You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to
 * station 1, which you do and complete the circuit.
 * </pre>
 * @see <a href="https://www.interviewbit.com/problems/gas-station/">www.interviewbit.com/problems/gas-station</a>
 */
public class GasStation {

    /**
     * Idea: for each index check if it can complete the circuit starting from such index
     * Time complexity is O(N^2)<br>
     * Space complexity is O(1)
     *
     * @param A
     * @param B
     * @return
     * @see <a href="https://www.interviewbit.com/problems/gas-station/">www.interviewbit.com/problems/gas-station</a>
     */
    public int canCompleteCircuit(final int[] A, final int[] B) {
        for (int i = 0; i < A.length; i++) {
            if (canComplete(A, B, i)) {
                return i;
            }
        }
        return -1;
    }

    private boolean canComplete(final int[] A, final int[] B, final int startIndex) {
        int tankGas = 0;
        for (int i = 0; i < A.length; i++) {
            int index = (startIndex + i) % A.length;
            tankGas += A[index] - B[index];
            if (tankGas < 0) {
                return false;
            }
        }
        return tankGas >= 0;
    }
}

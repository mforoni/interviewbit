package interviewbit;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 * Given an array of size n, find the majority element. The majority element is the element that appears more than
 * floor(n/2) times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example :
 * Input : [2, 1, 2]
 * Return : 2 which occurs 2 times which is greater than 3/2.
 * </pre>
 * @see <a href="https://www.interviewbit.com/problems/majority-element/">www.interviewbit.com/problems/majority-element</a>
 */
public class MajorityElement {

    /**
     * Time complexity is O(N)<br>
     * Space complexity is O(N)
     *
     * @param A
     * @return
     */
    public int majorityElement(final int[] A) {
        final Map<Integer, Integer> counters = new HashMap<>();
        for (int a : A) {
            Integer counter = counters.get(a);
            counters.put(a, counter == null ? 1 : ++counter);
        }
        int candidate = -1;
        int max = -1;
        for (int elem : counters.keySet()) {
            if (counters.get(elem) > max) {
                max = counters.get(elem);
                candidate = elem;
            }
        }
        if (max > Math.floor((double) A.length / 2)) {
            return candidate;
        } else {
            throw new AssertionError();
        }
    }
}

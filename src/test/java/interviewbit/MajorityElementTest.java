package interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MajorityElementTest {

    private static final int[] A = new int[] {2, 1, 2};
    private static final int SOL = 2;

    @Test
    public void testMajorityElement() {
        final MajorityElement majorityElement = new MajorityElement();

        assertEquals(SOL, majorityElement.majorityElement(A));
    }

}
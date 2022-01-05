package interviewbit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GasStationTest {

    private final int[] A = new int[] {1, 2};
    private final int[] B = new int[] {2, 1};
    private final int SOL = 1;

    @Test
    public void testCanCompleteCircuit() {
        final GasStation gasStation = new GasStation();

        assertEquals(SOL, gasStation.canCompleteCircuit(A, B));
    }
}
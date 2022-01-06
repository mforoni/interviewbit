package interviewbit;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class SortListTest {

    private static final int[] ARRAY = new int[] { 1, 5, 4, 3 };
    private static final SortList.ListNode SOL = SortList.ListNode.fromArray(new int[] { 1, 3, 4, 5 });

    private static final int[] ARRAY_2 = new int[] { 5 , 66 , 68 , 42 , 73 , 25 , 84 , 63 , 72 , 20 , 77 , 38 , 8 , 99 , 92 ,
            49 , 74 , 45 , 30 , 51 , 50 , 95 , 56 , 19 , 31 , 26 , 98 , 67 , 100 , 2 , 24 , 6 , 37 , 69 , 11 , 16 ,
            61 , 23 , 78 , 27 , 64 , 87 , 3 , 85 , 55 , 22 , 33 , 62 };
    private static final SortList.ListNode SOL2;

    static {
        final int[] tmp = ARRAY_2.clone();
        Arrays.sort(tmp);
        SOL2 = SortList.ListNode.fromArray(tmp);
    }
    
    @Test
    public void testMergeSort() {
        SortList.ListNode A = SortList.ListNode.fromArray(ARRAY);
        SortList.ListNode result = SortList.mergeSort(A);
        assertEquals(SOL, result);

        A = SortList.ListNode.fromArray(ARRAY_2);
        result = SortList.mergeSort(A);
        assertEquals(SOL2, result);
    }

    @Test
    public void testSelectionSort() {
        SortList.ListNode actual = SortList.ListNode.fromArray(ARRAY);
        SortList.selectionSort(actual);
        assertEquals(SOL, actual);

        actual = SortList.ListNode.fromArray(ARRAY_2);
        SortList.selectionSort(actual);
        assertEquals(SOL2, actual);
    }

    @Test
    public void testBubbleSort() {
        SortList.ListNode actual = SortList.ListNode.fromArray(ARRAY);
        SortList.bubbleSort(actual);
        assertEquals(SOL, actual);

        actual = SortList.ListNode.fromArray(ARRAY_2);
        SortList.bubbleSort(actual);
        assertEquals(SOL2, actual);
    }
}
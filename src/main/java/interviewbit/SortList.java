package interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 * Sort a linked list in O(n log n) time using constant space complexity.
 *
 * Example :
 *
 * Input : 1 -> 5 -> 4 -> 3
 *
 * Returned list : 1 -> 3 -> 4 -> 5
 * </pre>
 * @see <a href="https://www.interviewbit.com/problems/sort-list">www.interviewbit.com/problems/sort-list</a>
 */
public class SortList {

    public ListNode sortList(ListNode A) {
        selectionSort(A);
        return A;
    }

    /**
     * Time complexity is O(NlogN)
     * Space complexity is O(N) due to merge function
     *
     * @param listNode
     * @see <a href="https://en.wikipedia.org/wiki/Merge_sort">en.wikipedia.org/wiki/Merge_sort</a>
     */
    public static ListNode mergeSort(ListNode listNode) {
        if (listNode.next == null) {
            return listNode;
        }
        // Recursive case. First, divide the list into equal-sized sub-lists consisting of the first half and second
        // half of the list.
        ListNode left = listNode;
        ListNode right = getMiddle(listNode);
        // Recursively sort both sub-lists.
        left = mergeSort(left);
        right = mergeSort(right);
        // Then merge the now-sorted sub-lists.
        return merge(left, right);
    }

    private static ListNode getMiddle(ListNode listNode) {
        int size = 0;
        ListNode current = listNode;
        while (current != null) {
            size += 1;
            current = current.next;
        }
        int counter = 0;
        int middleIndex = size / 2;
        current = listNode;
        while (counter < middleIndex - 1) {
            counter += 1;
            current = current.next;
        }
        //System.out.println(String.format("List: %s", listNode.toString()));
        ListNode result = current.next;
        current.next = null;
        //System.out.println(String.format("Split list: %s and %s", listNode.toString(), result.toString()));
        return result;
    }

    /**
     * Space complexity is O(N)
     *
     * @param left
     * @param right
     * @return
     */
    private static ListNode merge(ListNode left, ListNode right) {
        //System.out.println(String.format("Merge left %s and right %s", left.toString(), right.toString()));
        ListNode previous = null, head = null;
        while (left != null && right != null) {
            int result;
            if (left.val <= right.val) {
                result = left.val;
                left = left.next;
            } else {
                result = right.val;
                right = right.next;
            }
            ListNode current = new ListNode(result);
            if (previous != null) {
                previous.next = current;
            } else {
                head = current;
            }
            previous = current;
        }
        // Either left or right may have elements left; consume them.
        while (left != null) {
            ListNode current = new ListNode(left.val);
            previous.next = current;
            previous = current;
            left = left.next;
        }
        while (right != null) {
            ListNode current = new ListNode(right.val);
            previous.next = current;
            previous = current;
            right = right.next;
        }
        //System.out.println("Result: " + head.toString());
        return head;
    }

    /**
     * Time complexity: O(N^2)<br>
     * Space complexity: O(1)
     *
     * @see <a href="https://en.wikipedia.org/wiki/Bubble_sort">en.wikipedia.org/wiki/Bubble_sort</a>
     */
    public static void bubbleSort(ListNode listNode) {
        boolean swapped;
        do {
            swapped = false;
            ListNode current = listNode;
            while(current.next != null) {
                if (current.val > current.next.val) {
                    swap(current, current.next);
                    swapped = true;
                }
                current = current.next;
            }
        } while(swapped);
    }

    /**
     * Idea: For each node starting from head, find min element in the list starting from current node. Swap current node with min found.
     *
     * Time complexity: O(N^2)<br>
     * Space complexity: O(1)
     * @see <a href="https://en.wikipedia.org/wiki/Selection_sort">en.wikipedia.org/wiki/Selection_sort</a>
     */
    public static void selectionSort(final ListNode A) {
        ListNode current = A;
        while(current != null) {
            ListNode min = findMin(current);
            swap(current, min);
            current = current.next;
        }
    }

    private static void swap(ListNode a, ListNode b) {
        int tmp = a.val;
        a.val = b.val;
        b.val = tmp;
    }

    private static ListNode findMin(ListNode list) {
        assert list != null;
        ListNode current = list;
        ListNode min = current;
        while(current != null) {
            if (current.val < min.val) {
                min = current;
            }
            current = current.next;
        }
        return min;
    }

    static class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ListNode listNode = (ListNode) o;

            if (val != listNode.val) return false;
            if (next != null && listNode.next == null) return false;
            if (next == null && listNode.next != null) return false;
            if (next == null && listNode.next == null) return true;
            return this.next.equals(listNode.next);
        }

        @Override
        public String toString() {
            List<Integer> values = new ArrayList<>();
            ListNode current = this;
            while(current != null) {
                values.add(current.val);
                current = current.next;
            }
            return values.toString();
        }

        public static ListNode fromArray(int[] arr) {
            final ListNode head = new ListNode(arr[0]);
            ListNode previous = head;
            for (int i = 1; i < arr.length; i++) {
                final ListNode next = new ListNode(arr[i]);
                previous.next = next;
                previous = next;
            }
            return head;
        }
    }
}



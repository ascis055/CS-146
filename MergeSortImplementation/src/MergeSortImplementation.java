/*
 * MergeSortImplementation.java
 *
 * Implementation of Merge Sort algorithm
 */

import java.util.Arrays;

public class MergeSortImplementation {

    /*
     * Print an array of integers on the standard output
     */
    static void PrintArray(int[] array) {
        final int length = array.length;

        for (int i = 0; i < length; i++)
            System.out.print(array[i] + ((i < (length - 1)) ? ", " : "\n"));
    }

    /*
     * Merge two "halves" of array
     *
     * Ranges are defined as from start index (inclusive) to the end
     * index (exclusive).
     * First "half" is [start, middle), second "half" is [middle, end).
     */
    static void Merge(int[] array, int start, int middle, int end) {
        // Indexes for copy operations
        int dest_index, left_index, right_index;
        // Sizes of the left and right "halves" of the array
        final int left_length = middle - start;
        final int right_length = end - middle;
        // Copy original array into "halves"
        final int[] left = java.util.Arrays.copyOfRange(array, start, middle);
        final int[] right = java.util.Arrays.copyOfRange(array, middle, end);

        // Merge loop, stop at the end of either left or right "half"
        // Every pass of the loop increments destination index
        for (dest_index = start, left_index = 0, right_index = 0;
             (left_index < left_length) && (right_index < right_length);
             dest_index ++) {
            // Copy one item from either left or right "half" and advance
            // corresponding index. Left or right "half" is chosen based on
            // the lower value of its current item.
            if (left[left_index] < right[right_index])
                array[dest_index] = left[left_index ++];
            else
                array[dest_index] = right[right_index ++];
        }

        // Copy remaining members of left and right "halves"
        // Every pass of the loops increments destination index
        for (;
             left_index < (left_length);
             dest_index ++)
            array[dest_index] = left[left_index ++];
        for (;
             right_index < (right_length);
             dest_index ++)
                array[dest_index] = right[right_index ++];
    }

    /*
     * Merge sort implementation
     *
     * Operates on a range [start, end) within the array.
     */
    static void MergeSort_exec(int[] array, int start, int end) {
        final int middle;

        // Return immediately in trivial cases
        if ((end - start) <= 1)
            return;

        // Determine middle point
        middle = (start + end) / 2;

        // Sort both array "halves" by recursively calling this function
        MergeSort_exec(array, start, middle);
        MergeSort_exec(array, middle, end);

        // Merge "halves"
        Merge(array, start, middle, end);
    }

    /*
     * Merge sort implementation wrapper
     *
     * Calls implementation on the whole array.
     */
    public static void MergeSort(int[] array) {
        MergeSort_exec(array, 0, array.length);
    }

    /*
     * Test program
     */
    public static void main(String[] args) {
        int[] testarray0 = {5, 2, 4, 6, 1, 3, 2, 6};
        int[] testarray1 = {5, 2, 0, 15, 18, 3, 12, 4};
        int[] testarray2 = {5, 2, 0, 15, 18, 3, 12};

        System.out.print("Before sorting: ");
        PrintArray(testarray0);
        MergeSort(testarray0);
        System.out.print(" After sorting: ");
        PrintArray(testarray0);

        System.out.print("Before sorting: ");
        PrintArray(testarray1);
        MergeSort(testarray1);
        System.out.print(" After sorting: ");
        PrintArray(testarray1);

        System.out.print("Before sorting: ");
        PrintArray(testarray2);
        MergeSort(testarray2);
        System.out.print(" After sorting: ");
        PrintArray(testarray2);
    }
}

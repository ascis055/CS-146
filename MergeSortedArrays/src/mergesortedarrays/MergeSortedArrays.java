/*
 * MergeSortedArrays.java
 *
 * Implementation of Merge operation for Merge Sort algorithm
 */

package mergesortedarrays;
import java.util.Arrays;

public class MergeSortedArrays {

    /*
     * Print an array of integers on the standard output
     */
    public static void PrintArray(int[] array) {
        final int length = array.length;

        for (int i = 0; i < length; i++)
            System.out.print(array[i] + ((i < (length - 1)) ? ", " : "\n"));
    }

    /*
     * Merge arrays
     */
    public static int[] Merge(final int[] left, final int[] right) {
        // Indexes for copy operations
        int dest_index, left_index, right_index;

        // Sizes of the left and right "halves" of the array
        final int left_length = left.length;
        final int right_length = right.length;
        int [] array = new int[left_length + right_length];

        // Merge loop, stop at the end of either left or right "half"
        // Every pass of the loop increments destination index
        for (dest_index = 0, left_index = 0, right_index = 0;
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
        return array;
    }
}

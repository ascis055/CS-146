/*
 * HoarePartition.java
 *
 * Implementation of Hoare partition algorithm
 */

package hoarepartition;
import java.util.Arrays;

public class HoarePartition {

    /*
     * Print an array of integers on the standard output
     */
    public static void PrintArray(int[] array) {
        final int length = array.length;

        if (length == 0) {
            System.out.print("<empty>\n");
        }
        for (int i = 0; i < length; i++)
            System.out.print(array[i] + ((i < (length - 1)) ? ", " : "\n"));
    }

    /*
     * Partition array
     */
    public static int Partition(int[] array) {
        // Pivot value, temporary variable for exchange and indexes
        int tmp, i, j, pivot;

        // Empty arrays and array with one item only
        // do not require any processing
        if (array.length <= 1)
            return 0;

        // Pivot value, first item of the array
        pivot = array[0];

        j = array.length;
        i = -1;

        while (true) {
            do i++; while (array[i] < pivot);
            do j--; while (array[j] > pivot);

            if (i >= j)
                return j;

            tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
        }
    }
}

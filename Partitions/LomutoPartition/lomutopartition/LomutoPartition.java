/*
 * LomutoPartition.java
 *
 * Implementation of Lomuto partition algorithm
 */

package lomutopartition;
import java.util.Arrays;

public class LomutoPartition {

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
        int pivot, tmp, i, j, high;

        high = array.length - 1;

        // Empty arrays and array with one item only
        // do not require any processing
        if (high <= 0)
            return 0;

        // Pivot value, last item of the array
        pivot = array[high];

        // Scan the array
        for (i = -1, j = 0; j < high; j++) {
            if (array[j] <= pivot) {
                i++;
                // Exchange item values
                tmp = array[j];
                array[j] = array[i];
                array[i] = tmp;
            }
        }

        // Exchange item values
        tmp = array[high];
        array[high] = array[i + 1];
        array[i + 1] = tmp;

        return i + 1;
    }
}

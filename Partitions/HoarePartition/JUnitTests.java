import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import hoarepartition.*;

class JUnitTests {
    private final HoarePartition partition =
        new HoarePartition();

    private int[] GenRandomArray() {
        Random random = new Random();
        int len = random.nextInt(99) + 1;
        int [] array = new int[len];
        for (int i = 0; i < len; i++)
                array[i] = random.nextInt(1024);
        return array;
    }

    private boolean isPartitioned(int[] array, int index) {
        int i, pivot;

        if (array.length <= 1)
            return index == 0;

        for (pivot = array[0], i = 1; i <= index; i++)
            pivot = (array[i] > pivot) ? array[i] : pivot;

        for (i = index + 1; i < array.length; i++)
            if (array[i] < pivot)
                return false;

        return true;
    }

    @Test
    void TestPartition1() {
        int[] array = {10, 17, 19, 21, 44, 55, 57, 63, 65, 67};
        int result;

        System.out.print("Input array: ");
        partition.PrintArray(array);

        result = partition.Partition(array);

        System.out.print("Partitioned array: ");
        partition.PrintArray(array);
        System.out.print("Partition index: " + result + "\n\n");

        assertTrue(isPartitioned(array, result), "Array is not partitioned");
    }

    @Test
    void TestPartition2() {
        int[] array = {};
        int result;

        System.out.print("Input array: ");
        partition.PrintArray(array);

        result = partition.Partition(array);

        System.out.print("Partitioned array: ");
        partition.PrintArray(array);
        System.out.print("Partition index: " + result + "\n\n");

        assertTrue(isPartitioned(array, result), "Array is not partitioned");
    }

    @Test
    void TestPartition3() {
        int[] array = {84, 3, 7, 1, 9, 6, 2, 5};
        int result;

        System.out.print("Input array: ");
        partition.PrintArray(array);

        result = partition.Partition(array);

        System.out.print("Partitioned array: ");
        partition.PrintArray(array);
        System.out.print("Partition index: " + result + "\n\n");

        assertTrue(isPartitioned(array, result), "Array is not partitioned");
    }

    @RepeatedTest(10)
    void TestPartitionRandom() {
        int[] array = GenRandomArray();
        int result;

        result = partition.Partition(array);

        assertTrue(isPartitioned(array, result), "Array is not partitioned");
    }
}

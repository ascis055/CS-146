import org.junit.jupiter.api.RepeatedTest;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import mergesortedarrays.*;

class JUnitTests {
    private final MergeSortedArrays mergearrays =
        new MergeSortedArrays();

    private int[] GenSortedArray() {
        Random random = new Random();
        int len = random.nextInt(99) + 1;
        int [] array = new int[len];
        array[0] = random.nextInt(1024 * len) - (1024 * len / 2);
        for (int i = 1; i < len; i++)
                array[i] = array[i - 1] + random.nextInt(1024);
        return array;
    }

    private boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++)
            if (array[i - 1] > array[i])
                return false;
        return true;
    }

    @RepeatedTest(10)
    void TestMerge() {
        int[] array1 = GenSortedArray();
        int[] array2 = GenSortedArray();
        
        int[] array = mergearrays.Merge(array1, array2);

        assertTrue(isSorted(array), "Array is not sorted after merge");
    }
}

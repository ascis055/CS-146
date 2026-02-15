/*
 * Heap.java
 *
 * Builds a heap
 */

package heap;

import java.util.Arrays;

class WordFreq {
    String word;
    int frequency;

    WordFreq(String arg_word, int arg_frequency)
    {
        word = arg_word;
        frequency = arg_frequency;
    }
}

public class Heap {
    /*
     * Print an array of integers on the standard output
     */
    public static void PrintArray(WordFreq[] array) {
        final int length = array.length;
        int i, len, maxlen;

        /* Determine maximum word length */
        for (i = 0, maxlen = 0; i < length; i++) {
            len = array[i].word.length();
            if (len > maxlen)
                maxlen = len;
        }

        /* Print array, pad words to produce a table */
        for (i = 0; i < length; i++)
            System.out.print(array[i].word
                             + " ".repeat(maxlen - array[i].word.length() + 1)
                             + array[i].frequency + "\n");
    }

    /*
     * Max-Heapify
     */
    public static void Heapify(WordFreq[] array, int index) {
        WordFreq tmp;
        int left, right, largest;

        left = index * 2 + 1;
        right = index * 2 + 2;
        largest = index;

        /*
         * Determine, which node among parent and two children, if
         * they exist, contains the largest value
         */
        if ((left < array.length)
            && (array[left].frequency > array[largest].frequency))
            largest = left;

        if ((right < array.length)
            && (array[right].frequency > array[largest].frequency))
            largest = right;

        if (largest != index) {
            /*
             * If the largest node is not the parent, exchange it with
             * parent
             */
            tmp = array[largest];
            array[largest] = array[index];
            array[index] = tmp;
            /*
             * Call this procedure recursively on the new location of
             * the former parent value
             */
            Heapify(array, largest);
        }
    }

    /*
     * Build-Max-Heap
     */
    public static void buildMaxHeap(WordFreq[] array) {

        /* Don't do anything with arrays without at least two items */
        if (array.length < 2)
            return;

        /*
         * Call Heapify on items of the array that represent non-leaf
         * nodes
         */
        for (int i = array.length / 2 - 1; i >= 0; i--)
            Heapify(array, i);
    }

    /*
     * Main program
     */
    public static void main(String[] args) {
        /* Original array */
        WordFreq words[] = {
            new WordFreq("happy", 400),
            new WordFreq("satisfied", 100),
            new WordFreq("neutral", 300),
            new WordFreq("would buy again", 200),
            new WordFreq("terrible", 160),
            new WordFreq("inconvenient", 900),
            new WordFreq("difficult to use", 100),
            new WordFreq("easy to use", 140),
            new WordFreq("would recommend to friends", 800),
            new WordFreq("visit the store", 700)
        };

        buildMaxHeap(words);

        PrintArray(words);
    }
}

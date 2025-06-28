package ch.wiss.magicsort.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MergeSortTest {

    @Test
    public void sortIntegers_unsortedList() {
        // ARRANGE
        List<Integer> arr = Arrays.asList(5, 1, 10, 30, 0, 25, 6, 19, 100, 150, 31, 12, 13);
        List<Integer> expected = Arrays.asList(0, 1, 5, 6, 10, 12, 13, 19, 25, 30, 31, 100, 150);

        // ACT
        List<Integer> sortedArr = new MergeSort().sort(arr);

        //DEBUG
        System.out.println("Sorted: " + sortedArr);

        // ASSERT
        assertEquals(expected, sortedArr);
    }

    @Test
    public void sortIntegers_alreadySortedList() {
        // ARRANGE
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        // ACT
        List<Integer> result = new MergeSort().sort(input);

        //DEBUG
        System.out.println("Sorted (alreadySorted): " + result);

        // ASSERT
        assertEquals(expected, result);
    }

    @Test
    public void sortIntegers_withDuplicates() {
        List<Integer> input = Arrays.asList(4, 2, 5, 2, 3, 4);
        List<Integer> expected = Arrays.asList(2, 2, 3, 4, 4, 5);

        List<Integer> result = new MergeSort().sort(input);

        System.out.println("Sorted (withDuplicates): " + result);
        assertEquals(expected, result);
    }

    @Test
    public void sortIntegers_emptyList() {
        List<Integer> input = Collections.emptyList();
        List<Integer> expected = Collections.emptyList();

        List<Integer> result = new MergeSort().sort(input);

        System.out.println("Sorted (emptyList): " + result);
        assertEquals(expected, result);
    }
}

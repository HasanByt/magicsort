package ch.wiss.magicsort.algorithms;

import ch.wiss.magicsort.SortResult;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class InsertionSortTest {

    private final InsertionSort sorter = new InsertionSort();

    @Test
    public void testSortBasic() {
        List<Integer> input = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5);

        SortResult result = sorter.sort(input);
        assertEquals(expected, result.sorted());
    }

    @Test
    public void testSortEmptyList() {
        List<Integer> input = Collections.emptyList();
        SortResult result = sorter.sort(input);
        assertTrue(result.sorted().isEmpty());
    }

    @Test
    public void testSortSingleElement() {
        List<Integer> input = Collections.singletonList(42);
        SortResult result = sorter.sort(input);
        assertEquals(Collections.singletonList(42), result.sorted());
    }

    @Test
    public void testSortWithDuplicates() {
        List<Integer> input = Arrays.asList(5, 5, 5, 1, 3, 2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 5, 5);

        SortResult result = sorter.sort(input);
        assertEquals(expected, result.sorted());
    }

    @Test
    public void testSortAlreadySorted() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        SortResult result = sorter.sort(input);
        assertEquals(input, result.sorted());
    }

    @Test
    public void testNullInput() {
        SortResult result = sorter.sort(null);
        assertTrue(result.sorted().isEmpty());
    }

    @Test
    public void testAlgorithmName() {
        assertEquals("insertion", sorter.getAlgorithmName());
    }
}

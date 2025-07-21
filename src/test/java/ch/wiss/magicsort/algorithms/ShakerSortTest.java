package ch.wiss.magicsort.algorithms;

import ch.wiss.magicsort.SortResult;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShakerSortTest {

    private final ShakerSort shakerSort = new ShakerSort();

    @Test
    public void testEmptyList() {
        List<Integer> input = Collections.emptyList();
        SortResult result = shakerSort.sort(input);
        assertTrue(result.sorted().isEmpty());
    }

    @Test
    public void testSingleElement() {
        List<Integer> input = Collections.singletonList(42);
        SortResult result = shakerSort.sort(input);
        assertEquals(Arrays.asList(42), result.sorted());
    }

    @Test
    public void testSortedInput() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        SortResult result = shakerSort.sort(input);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result.sorted());
    }

    @Test
    public void testUnsortedInput() {
        List<Integer> input = Arrays.asList(5, 3, 1, 4, 2);
        SortResult result = shakerSort.sort(input);
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result.sorted());
    }

    @Test
    public void testDuplicates() {
        List<Integer> input = Arrays.asList(3, 1, 2, 3, 1);
        SortResult result = shakerSort.sort(input);
        assertEquals(Arrays.asList(1, 1, 2, 3, 3), result.sorted());
    }

    @Test
    public void testNullInput() {
        SortResult result = shakerSort.sort(null);
        assertTrue(result.sorted().isEmpty());
    }

    @Test
    public void testGetAlgorithmName() {
        assertEquals("shaker", shakerSort.getAlgorithmName());
    }

    @Test
    public void testCorrectClassIsUsed() {
        assertEquals("ch.wiss.magicsort.algorithms.ShakerSort", shakerSort.getClass().getName());
    }
}

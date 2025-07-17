package ch.wiss.magicsort.algorithms;

import ch.wiss.magicsort.SortResult;
import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeSortTest {

    private final BinaryTreeSort sorter = new BinaryTreeSort();

    @Test
    public void testSortBasic() {
        List<Integer> input = Arrays.asList(5, 2, 9, 1, 3);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 9);

        SortResult result = sorter.sort(input);
        assertEquals(expected, result.getSorted());
    }

    @Test
    public void testSortEmptyList() {
        List<Integer> input = Collections.emptyList();
        SortResult result = sorter.sort(input);
        assertTrue(result.getSorted().isEmpty());
    }

    @Test
    public void testSortSingleElement() {
        List<Integer> input = Collections.singletonList(42);
        SortResult result = sorter.sort(input);
        assertEquals(Collections.singletonList(42), result.getSorted());
    }

    @Test
    public void testSortWithDuplicates() {
        List<Integer> input = Arrays.asList(4, 2, 4, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 2, 4, 4);

        SortResult result = sorter.sort(input);
        assertEquals(expected, result.getSorted());
    }

    @Test
    public void testSortAlreadySorted() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        SortResult result = sorter.sort(input);
        assertEquals(input, result.getSorted());
    }

    @Test
    public void testNullInput() {
        SortResult result = sorter.sort(null);
        assertTrue(result.getSorted().isEmpty());
    }

    @Test
    public void testAlgorithmName() {
        assertEquals("BinaryTreeSort", sorter.getAlgorithmName());
    }
}

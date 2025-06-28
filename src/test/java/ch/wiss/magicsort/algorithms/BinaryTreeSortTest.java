package ch.wiss.magicsort.algorithms;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class BinaryTreeSortTest {

    private final BinaryTreeSort sorter = new BinaryTreeSort();

    @Test
    public void testSortBasic() {
        //ARRANGE
        List<Integer> input = Arrays.asList(5, 2, 9, 1, 3);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 9);

        //ACT
        List<Integer> result = sorter.sort(input);

        //ASSERT
        assertEquals(expected, result);
    }

    @Test
    public void testSortEmptyList() {
        List<Integer> input = Collections.emptyList();
        List<Integer> result = sorter.sort(input);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSortSingleElement() {
        List<Integer> input = Collections.singletonList(42);
        List<Integer> result = sorter.sort(input);
        assertEquals(Collections.singletonList(42), result);
    }

    @Test
    public void testSortWithDuplicates() {
        List<Integer> input = Arrays.asList(4, 2, 4, 2, 1);
        List<Integer> expected = Arrays.asList(1, 2, 2, 4, 4);

        List<Integer> result = sorter.sort(input);
        assertEquals(expected, result);
    }

    @Test
    public void testSortAlreadySorted() {
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> result = sorter.sort(input);
        assertEquals(input, result);
    }

    @Test
    public void testNullInput() {
        List<Integer> result = sorter.sort(null);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testAlgorithmName() {
        assertEquals("binarytreesort", sorter.getAlgorithmName());
    }
}

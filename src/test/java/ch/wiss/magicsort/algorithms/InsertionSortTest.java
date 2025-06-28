package ch.wiss.magicsort.algorithms;

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
        // Arrange
        List<Integer> input = Arrays.asList(5, 4, 3, 2, 1);
        List<Integer> output = Arrays.asList(1, 2, 3, 4, 5);

        // Act
        List<Integer> result = sorter.sort(input);

        // Assert
        assertEquals(output, result);
    }

    @Test
    public void testSortEmptyList() {
        // Arrange
        List<Integer> input = Collections.emptyList();
        // Act
        List<Integer> result = sorter.sort(input);
        // Assert
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSortSingleElement() {
        // Arrange
        List<Integer> input = Collections.singletonList(42);
        // Act
        List<Integer> result = sorter.sort(input);
        // Assert
        assertEquals(Collections.singletonList(42), result);
    }

    @Test
    public void testSortWithDuplicates() {
        // Arrange
        List<Integer> input = Arrays.asList(5, 5, 5, 1, 3, 2);
        List<Integer> expected = Arrays.asList(1, 2, 3, 5, 5, 5);
        // Act
        List<Integer> result = sorter.sort(input);
        // Assert
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
        assertEquals("insertion", sorter.getAlgorithmName());
    }

}

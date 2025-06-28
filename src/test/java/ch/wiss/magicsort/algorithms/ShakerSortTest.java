package ch.wiss.magicsort.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShakerSortTest {

    private final ShakerSort shakerSort = new ShakerSort();

    // Leere Liste: Keine Fehler bei leeren Daten
    @Test
    public void testEmptyList() {
        // Arrange
        List<Integer> input = Collections.emptyList();

        // Act
        List<Integer> result = shakerSort.sort(input);

        // Assert
        assertTrue(result.isEmpty());
    }

    // Ein Element: Keine unnötigen Änderungen
    @Test
    public void testSingleElement() {
        // Arrange
        List<Integer> input = Collections.singletonList(42);

        // Act
        List<Integer> result = shakerSort.sort(input);

        // Assert
        assertEquals(Arrays.asList(42), result);
    }

    // Schon sortiert: Algorithmus soll nichts kaputt machen
    @Test
    public void testSortedInput() {
        // Arrange
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        // Act
        List<Integer> result = shakerSort.sort(input);

        // Assert
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    // Richtige Sortierung: Grundfunktion muss stimmen
    @Test
    public void testUnsortedInput() {
        // Arrange
        List<Integer> input = Arrays.asList(5, 3, 1, 4, 2);

        // Act
        List<Integer> result = shakerSort.sort(input);

        // Assert
        assertEquals(Arrays.asList(1, 2, 3, 4, 5), result);
    }

    // Duplikate korrekt behandeln: Realistische Datenlage
    @Test
    public void testDuplicates() {
        // Arrange
        List<Integer> input = Arrays.asList(3, 1, 2, 3, 1);

        // Act
        List<Integer> result = shakerSort.sort(input);

        // Assert
        assertEquals(Arrays.asList(1, 1, 2, 3, 3), result);
    }

    // Kein Absturz bei null: Robustheit gegen fehlerhafte Eingaben
    @Test
    public void testNullInput() {
        // Arrange
        List<Integer> input = null;

        // Act
        List<Integer> result = shakerSort.sort(input);

        // Assert
        assertTrue(result.isEmpty());
    }

    // Metadaten stimmen: Dynamische Auswahl per Namen möglich
    @Test
    public void testGetAlgorithmName() {
        // Act
        String name = shakerSort.getAlgorithmName();

        // Assert
        assertEquals("shaker", name);
    }

    // Optional: Sicherstellen, dass die richtige Klasse getestet wird
    @Test
    public void testCorrectClassIsUsed() {
        assertEquals("ch.wiss.magicsort.algorithms.ShakerSort", shakerSort.getClass().getName());
    }
}
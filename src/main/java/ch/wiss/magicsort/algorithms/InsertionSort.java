package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class InsertionSort implements ISort {

    @Override
    public SortResult sort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return new SortResult(Collections.emptyList(), 0, 0);
        }

        List<Integer> sorted = new ArrayList<>(list);
        int comparisons = 0;

        long start = System.nanoTime();

        for (int i = 1; i < sorted.size(); i++) {
            int key = sorted.get(i);
            int j = i - 1;

            while (j >= 0 && sorted.get(j) > key) {
                comparisons++;
                sorted.set(j + 1, sorted.get(j));
                j--;
            }

            // Wenn Bedingung fehlschlägt, gab es trotzdem einen Vergleich
            if (j >= 0) {
                comparisons++;
            }

            sorted.set(j + 1, key);
        }

        long duration = System.nanoTime() - start;
        return new SortResult(sorted, comparisons, duration / 1_000_000.0);
    }

    @Override
    public String getAlgorithmName() {
        return "insertion";
    }
}

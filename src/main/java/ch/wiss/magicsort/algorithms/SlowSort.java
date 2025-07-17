package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class SlowSort implements ISort {

    private int comparisons;

    @Override
    public SortResult sort(List<Integer> input) {
        if (input == null || input.size() <= 1) {
            return new SortResult(input == null ? List.of() : new ArrayList<>(input), 0, 0);
        }

        List<Integer> list = new ArrayList<>(input);
        comparisons = 0;
        long startTime = System.nanoTime();

        slowSort(list, 0, list.size() - 1);

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        return new SortResult(list, comparisons, durationMs);
    }

    private void slowSort(List<Integer> list, int i, int j) {
        if (i >= j) return;

        int m = (i + j) / 2;

        slowSort(list, i, m);
        slowSort(list, m + 1, j);

        comparisons++;
        if (list.get(j) < list.get(m)) {
            Collections.swap(list, j, m);
        }

        slowSort(list, i, j - 1);
    }

    @Override
    public String getAlgorithmName() {
        return "slowsort";
    }
}

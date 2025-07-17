package ch.wiss.magicsort.algorithms;

import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class BubbleSort implements ISort {

    @Override
    public SortResult sort(List<Integer> list) {
        long comparisons = 0;
        int n = list.size();
        boolean swapped;

        long startTime = System.nanoTime();

        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                comparisons++;
                if (list.get(i - 1) > list.get(i)) {
                    int temp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                    swapped = true;
                }
            }
            n--;
        } while (swapped);

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        return new SortResult(list, comparisons, durationMs);
    }

    @Override
    public String getAlgorithmName() {
        return "BubbleSort";
    }
}

package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class GnomeSort implements ISort {

    @Override
    public SortResult sort(List<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return new SortResult(Collections.emptyList(), 0, 0);
        }

        List<Integer> sortedList = new ArrayList<>(inputList);
        int comparisons = 0;
        int index = 0;

        long start = System.nanoTime();

        while (index < sortedList.size()) {
            if (index == 0) {
                index++;
            } else {
                comparisons++;
                if (sortedList.get(index).compareTo(sortedList.get(index - 1)) >= 0) {
                    index++;
                } else {
                    Integer temp = sortedList.get(index);
                    sortedList.set(index, sortedList.get(index - 1));
                    sortedList.set(index - 1, temp);
                    index--;
                }
            }
        }

        long durationNs = System.nanoTime() - start;
        double durationMs = durationNs / 1_000_000.0;

        return new SortResult(sortedList, comparisons, durationMs);
    }

    @Override
    public String getAlgorithmName() {
        return "gnomesort";
    }
}

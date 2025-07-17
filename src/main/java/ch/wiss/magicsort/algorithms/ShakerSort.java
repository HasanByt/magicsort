package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class ShakerSort implements ISort {

    @Override
    public SortResult sort(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return new SortResult(List.of(), 0, 0);
        }

        List<Integer> list = new ArrayList<>(input);
        int left = 0;
        int right = list.size() - 1;
        boolean swapped = true;
        int comparisons = 0;

        long startTime = System.nanoTime();

        while (swapped) {
            swapped = false;

            // von links nach rechts
            for (int i = left; i < right; i++) {
                comparisons++;
                if (list.get(i) > list.get(i + 1)) {
                    swap(list, i, i + 1);
                    swapped = true;
                }
            }

            right--;

            // von rechts nach links
            for (int i = right; i > left; i--) {
                comparisons++;
                if (list.get(i - 1) > list.get(i)) {
                    swap(list, i - 1, i);
                    swapped = true;
                }
            }

            left++;
        }

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        return new SortResult(list, comparisons, durationMs);
    }

    private void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    @Override
    public String getAlgorithmName() {
        return "shaker";
    }
}

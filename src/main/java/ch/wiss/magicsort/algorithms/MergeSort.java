package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class MergeSort implements ISort {

    private int comparisons = 0;

    @Override
    public SortResult sort(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return new SortResult(List.of(), 0, 0);
        }

        comparisons = 0; // Zähler zurücksetzen
        long startTime = System.nanoTime();

        List<Integer> sorted = mergeSort(list);

        long duration = System.nanoTime() - startTime;

        return new SortResult(sorted, comparisons, duration / 1_000_000.0);
    }

    private List<Integer> mergeSort(List<Integer> list) {
        if (list.size() < 2) {
            return list;
        }

        int mid = list.size() / 2;
        List<Integer> left = mergeSort(new ArrayList<>(list.subList(0, mid)));
        List<Integer> right = mergeSort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        List<Integer> merged = new ArrayList<>();
        int i = 0;
        int j = 0;

        while (i < left.size() && j < right.size()) {
            comparisons++;
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i++));
            } else {
                merged.add(right.get(j++));
            }
        }

        while (i < left.size()) {
            merged.add(left.get(i++));
        }

        while (j < right.size()) {
            merged.add(right.get(j++));
        }

        return merged;
    }

    @Override
    public String getAlgorithmName() {
        return "mergesort";
    }
}

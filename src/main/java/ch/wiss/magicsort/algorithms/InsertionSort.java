package ch.wiss.magicsort.algorithms;

import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;

public class InsertionSort implements ISort {

    @Override
    public List<Integer> sort(List<Integer> list) {
        if (list == null || list.size() < 1) {
            return Collections.emptyList();
        }

        // In-place Insertion Sort
        for (int i = 1; i < list.size(); i++) { //
            int key = list.get(i);
            int j = i - 1;

            while (j >= 0 && list.get(j) > key) {
                list.set(j + 1, list.get(j)); // Schiebe Element nach rechts
                j--;
            }

            list.set(j + 1, key); // Füge key an der richtigen Stelle ein
        }

        return list; // In-place sortiert
    }

    @Override
    public String getAlgorithmName() {
        return "insertion";
    }
}

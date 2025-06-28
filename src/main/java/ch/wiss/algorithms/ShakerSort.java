package ch.wiss.algorithms;

import java.util.ArrayList;
import java.util.List;

import ch.wiss.magicsort.ISort;

/**
 * ShakerSortService ist eine Implementierung des ShakerSort-Algorithmus.
 * Der Algorithmus ist eine Variante von BubbleSort, die abwechselnd von links
 * nach rechts und von rechts nach links sortiert.
 */
public class ShakerSort implements ISort {

    /**
     * Sortiert die gegebene Liste mit dem ShakerSort-Algorithmus.
     *
     * @param input Die zu sortierende Liste.
     * @return Eine neue Liste mit den sortierten Elementen.
     */
    @Override
    public List<Integer> sort(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return new ArrayList<>();
        }

        List<Integer> list = new ArrayList<>(input);
        int left = 0;
        int right = list.size() - 1;
        boolean swapped = true;

        while (swapped) {
            swapped = false;

            // von links nach rechts
            for (int i = left; i < right; i++) {
                if (list.get(i) > list.get(i + 1)) {
                    swap(list, i, i + 1);
                    swapped = true;
                }
            }

            right--;

            // von rechts nach links
            for (int i = right; i > left; i--) {
                if (list.get(i - 1) > list.get(i)) {
                    swap(list, i - 1, i);
                    swapped = true;
                }
            }

            left++;
        }

        return list;
    }

    private void swap(List<Integer> list, int i, int j) {
        Integer temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    /**
     * Gibt den Namen des Algorithmus zurück.
     *
     * @return "shaker"
     */
    @Override
    public String getAlgorithmName() {
        return "shaker";
    }
}

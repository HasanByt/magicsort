package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.List;

import ch.wiss.magicsort.ISort;

public class MergeSort implements ISort {
    @Override
    public List<Integer> sort(List<Integer> list) {

        // Falls Liste nur 1 Element beinhaltet: Return List da bereits sortiert. Ist
        // auch der Auslöser, damit der merge beginnt bei der Rekursion sobald es nur
        // noch ein Element gibt in der Liste.
        if (list.size() < 2) {
            return list;
        }

        // Liste wird halbiert
        int mid = list.size() / 2;

        // Hier werden zwei neue Listen erstellt links und rechts und diese werden
        // nochmals rekursiv aufgerufen. Die Liste links sortiert von 0 bis mid - 1. Das
        // -1 stammt von der sublist methode welche die Werte innerhalb der liste
        // basierend auf dem Listindex nimmt und abruft
        List<Integer> left = sort(new ArrayList<>(list.subList(0, mid)));
        List<Integer> right = sort(new ArrayList<>(list.subList(mid, list.size())));

        return merge(left, right);
    }

    private List<Integer> merge(List<Integer> left, List<Integer> right) {
        // Die neue Liste welche die sortierte Liste beinhaltet
        List<Integer> merged = new ArrayList<>();

        int i = 0;
        int j = 0;

        // Es beginnt mit dem Vergleichen von einzelnen Elementen im Array.
        while (i < left.size() && j < right.size()) {
            if (left.get(i) <= right.get(j)) {
                merged.add(left.get(i));
                i++;
            } else {
                merged.add(right.get(j));
                j++;
            }
        }

        // Falls ein Element oben übrig bleibt wird Sie mithilfe den unteren while loops
        // an der letzten Stelle hinzugefügt, da es sich hierbei um das grösste Element
        // handelt innerhalb der Liste.
        while (i < left.size()) {
            merged.add(left.get(i));
            i++;
        }

        while (j < right.size()) {
            merged.add(right.get(j));
            j++;
        }

        return merged;
    }

    @Override
    public String getAlgorithmName() {
        return "mergesort";
    }
}

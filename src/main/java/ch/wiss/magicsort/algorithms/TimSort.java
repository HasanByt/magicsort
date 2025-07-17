package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class TimSort implements ISort {

    @Override
    public SortResult sort(List<Integer> input) {
        if (input == null || input.size() <= 1) {
            return new SortResult(input == null ? List.of() : new ArrayList<>(input), 0, 0);
        }

        List<Integer> list = new ArrayList<>(input);

        long start = System.nanoTime();
        Collections.sort(list); // TimSort ist default in Java für Objekte
        long end = System.nanoTime();

        // TimSort ist komplex, daher können Vergleiche nicht genau gezählt werden
        // → du kannst -1 setzen oder grob schätzen (hier setzen wir -1)
        return new SortResult(list, -1, (end - start) / 1_000_000.0);
    }

    @Override
    public String getAlgorithmName() {
        return "timsort";
    }
}

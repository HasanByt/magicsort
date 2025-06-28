package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;

public class GnomeSort implements ISort {

    @Override
    public List<Integer> sort(List<Integer> inputList) {
        if (inputList == null || inputList.isEmpty()) {
            return Collections.emptyList();
        }
        List<Integer> sortedList = new ArrayList<>(inputList);

        int index = 0;
        while (index < sortedList.size()) {
            if (index == 0) {
                index++;
            } else if (sortedList.get(index).compareTo(sortedList.get(index - 1)) >= 0) {
                index++;
            } else {

                Integer temp = sortedList.get(index);
                sortedList.set(index, sortedList.get(index - 1));
                sortedList.set(index - 1, temp);
                index--;
            }
        }
        return sortedList;
    }

    @Override
    public String getAlgorithmName() {
        return "gnomesort";
    }
}

package ch.wiss.magicsort;

import java.util.List;

public interface ISort {
    List<Integer> sort(List<Integer> sortedList);

    String getAlgorithmName();
}
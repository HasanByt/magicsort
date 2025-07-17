package ch.wiss.magicsort;

import java.util.List;

public interface ISort {

    String getAlgorithmName();
    SortResult sort(List<Integer> unsorted);
}
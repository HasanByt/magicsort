package ch.wiss.magicsort;

import java.util.ArrayList;
import java.util.List;



public class App {
    public static void main(String[] args) {
        System.out.println("Project running");


        List<Integer> unsortedList = List.of(33,6,12,73,25);

        ISort sorter = SortFactory.getSorter(SortAlgorithm.BINARY_TREE);

        List<Integer> sortedList = sorter.sort(unsortedList);
        System.out.println(sortedList);
    }
}

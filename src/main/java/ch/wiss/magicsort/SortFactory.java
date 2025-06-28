package ch.wiss.magicsort;

import ch.wiss.magicsort.algorithms.BinaryTreeSort;
import ch.wiss.magicsort.algorithms.BubbleSort;
import ch.wiss.magicsort.algorithms.GnomeSort;
import ch.wiss.magicsort.algorithms.InsertionSort;
import ch.wiss.magicsort.algorithms.MergeSort;
import ch.wiss.magicsort.algorithms.ShakerSort;
import ch.wiss.magicsort.algorithms.SlowSort;
import ch.wiss.magicsort.algorithms.TimSort;

public class SortFactory {

    public static ISort getSorter(SortAlgorithm algorithm) {
        switch (algorithm) {
            case BINARY_TREE:
                return new BinaryTreeSort();
            case BUBBLE:
                return new BubbleSort();
            case INSERTION:
                return new InsertionSort();
            case GNOME:
                return new GnomeSort();
            case MERGE:
                return new MergeSort();
            case SHAKER:
                return new ShakerSort();
            case SLOW:
                return new SlowSort();
            case TIM:
                return new TimSort();
            default:
                throw new IllegalArgumentException("Unbekannter Algorithmus: " + algorithm);
        }
    }
}
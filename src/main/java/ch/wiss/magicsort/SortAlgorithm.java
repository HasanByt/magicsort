package ch.wiss.magicsort;

import java.util.Arrays;

public enum SortAlgorithm {
    BINARY_TREE("binarytreesort"),
    BUBBLE("bubblesort"),
    GNOME("gnomesort"),
    INSERTION("insertionsort"),
    MERGE("mergesort"),
    SHAKER("shakersort"),
    SLOW("slowsort"),
    TIM("timsort");

    private final String dbName;

    SortAlgorithm(String dbName) {
        this.dbName = dbName;
    }

    public String getDbName() {
        return dbName;
    }

    public static SortAlgorithm fromDbName(String name) {
        return Arrays.stream(values())
                .filter(a -> a.dbName.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unbekannter Algorithmus: " + name));
    }
}

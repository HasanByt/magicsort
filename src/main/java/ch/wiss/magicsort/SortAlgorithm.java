package ch.wiss.magicsort;

import java.util.Arrays;

public enum SortAlgorithm {
    BINARY_TREE("BinaryTreeSort"),
    BUBBLE("BubbleSort"),
    GNOME("GnomeSort"),
    INSERTION("InsertionSort"),
    MERGE("MergeSort"),
    SHAKER("ShakerSort"),
    SLOW("SlowSort"),
    TIM("TimSort");

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

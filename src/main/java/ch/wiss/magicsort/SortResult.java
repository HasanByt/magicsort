package ch.wiss.magicsort;

import java.util.List;

public class SortResult {
    private final List<Integer> sorted;
    private final long comparisons;
    private final double durationMs;

    public record SortResult(List<Integer> sorted, long comparisons, double durationMs) {
        this.sorted = sorted;
        this.comparisons = comparisons;
        this.durationMs = durationMs;
    }

    public List<Integer> getSorted() {
        return sorted;
    }

    public long getComparisons() {
        return comparisons;
    }

    public double getDurationMs() {
        return durationMs;
    }
}

package ch.wiss.magicsort;

import java.util.List;

public record SortResult(List<Integer> sorted, long comparisons, double durationMs) {}

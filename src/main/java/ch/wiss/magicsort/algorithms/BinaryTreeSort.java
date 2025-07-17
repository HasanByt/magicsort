package ch.wiss.magicsort.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;
import ch.wiss.magicsort.SortResult;

public class BinaryTreeSort implements ISort {

    private long comparisons; // zählt Vergleiche

    private static class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;
        BinaryTreeSort sortRef;

        public TreeNode(Integer value, BinaryTreeSort sortRef) {
            this.value = value;
            this.sortRef = sortRef;
        }

        public void insert(Integer newValue) {
            sortRef.comparisons++; // Vergleich zählt
            if (newValue.compareTo(value) <= 0) {
                if (left == null)
                    left = new TreeNode(newValue, sortRef);
                else
                    left.insert(newValue);
            } else {
                if (right == null)
                    right = new TreeNode(newValue, sortRef);
                else
                    right.insert(newValue);
            }
        }

        public void inOrder(List<Integer> result) {
            if (left != null)
                left.inOrder(result);
            result.add(value);
            if (right != null)
                right.inOrder(result);
        }
    }

    @Override
    public SortResult sort(List<Integer> input) {
        comparisons = 0;

        if (input == null || input.isEmpty()) {
            return new SortResult(Collections.emptyList(), 0, 0.0);
        }

        long startTime = System.nanoTime();

        TreeNode root = new TreeNode(input.get(0), this);
        for (int i = 1; i < input.size(); i++) {
            root.insert(input.get(i));
        }

        List<Integer> sorted = new ArrayList<>();
        root.inOrder(sorted);

        long endTime = System.nanoTime();
        double durationMs = (endTime - startTime) / 1_000_000.0;

        return new SortResult(sorted, comparisons, durationMs);
    }

    @Override
    public String getAlgorithmName() {
        return "BinaryTreeSort";
    }
}

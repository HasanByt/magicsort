package ch.wiss.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ch.wiss.magicsort.ISort;

/**
 * BinaryTreeSortService ist eine Implementierung des Sortieralgorithmus "Binary
 * Tree Sort".
 * <p>
 * Dieser Algorithmus erstellt aus den Eingabewerten einen Binary Search Tree
 * (BST)
 * und traversiert diesen anschließend in In-Order-Reihenfolge, um die Werte
 * sortiert zurückzugeben.
 * <p>
 * Die Eingabe ist eine Liste von Strings, die nach ihrer natürlichen Ordnung
 * (alphabetisch)
 * sortiert wird.
 *
 */
public class BinaryTreeSort implements ISort {

    /**
     * Interne Klasse zur Darstellung eines Knotens im Binärbaum.
     */
    private static class TreeNode {
        Integer value;
        TreeNode left;
        TreeNode right;

        /**
         * Konstruktor für einen neuen Knoten mit dem gegebenen Wert.
         *
         * @param value Der zu speichernde Wert.
         */
        public TreeNode(Integer value) {
            this.value = value;
        }

        /**
         * Fügt einen neuen Wert korrekt in den Binärbaum ein.
         *
         * @param newValue Der einzufügende Wert.
         */
        public void insert(Integer newValue) {
            if (newValue.compareTo(value) <= 0) {
                if (left == null)
                    left = new TreeNode(newValue);
                else
                    left.insert(newValue);
            } else {
                if (right == null)
                    right = new TreeNode(newValue);
                else
                    right.insert(newValue);
            }
        }

        /**
         * Führt eine In-Order-Traversierung durch, um die sortierten Werte zu sammeln.
         *
         * @param result Liste zur Aufnahme der sortierten Werte.
         */
        public void inOrder(List<Integer> result) {
            if (left != null)
                left.inOrder(result);
            result.add(value);
            if (right != null)
                right.inOrder(result);
        }
    }

    /**
     * Sortiert die gegebene Liste mit dem Binary Tree Sort Algorithmus.
     *
     * @param input Die zu sortierende Liste.
     * @return Eine neue Liste mit den sortierten Elementen.
     */
    @Override
    public List<Integer> sort(List<Integer> input) {
        if (input == null || input.isEmpty()) {
            return Collections.emptyList();
        }

        TreeNode root = new TreeNode(input.get(0));
        for (int i = 1; i < input.size(); i++) {
            root.insert(input.get(i));
        }

        List<Integer> sorted = new ArrayList<>();
        root.inOrder(sorted);
        return sorted;
    }

    /**
     * Gibt den Namen des Algorithmus zurück.
     *
     * @return "binarytreesort"
     */
    @Override
    public String getAlgorithmName() {
        return "binarytreesort";
    }
}

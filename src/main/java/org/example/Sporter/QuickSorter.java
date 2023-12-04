package org.example.Sporter;

import java.util.ArrayList;
import java.util.Collections;

public class QuickSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        quickSort(input, 0, input.size() - 1);
        return input;
    }

    private void quickSort(ArrayList<Integer> arr, int low, int high) {
        if (low < high) {
            int pivotIndex  = partition(arr, low, high);

            quickSort(arr, low, pivotIndex  - 1);
            quickSort(arr, pivotIndex  + 1, high);
        }
    }

    private int partition(ArrayList<Integer> arr, int low, int high) {
        int pivot = arr.get(high);
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr.get(j) < pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }

        int temp = arr.get(i + 1);
        arr.set(i + 1, arr.get(high));
        arr.set(high, temp);

        return i + 1;
    }
}

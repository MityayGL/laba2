package org.example.Sporter;

import java.util.ArrayList;

public class BubbleSorter implements Sorter {
    @Override
    public ArrayList<Integer> sort(ArrayList<Integer> input) {
        int n = input.size();
        boolean swapped;

        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (input.get(j) > input.get(j + 1)) {
                    int temp = input.get(j);
                    input.set(j, input.get(j + 1));
                    input.set(j + 1, temp);

                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return input;
    }
}

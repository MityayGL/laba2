package org.example;

import org.example.Sporter.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

enum SortingType {
    BubbleSorter,
    ShellSorter,
    MergeSorter,
    QuickSorter
}

public class Main {

    public static Sorter choiceSorterMethod(SortingType type) {
        Sorter sorter = null;

        switch (type) {
            case BubbleSorter -> sorter = new BubbleSorter();
            case MergeSorter -> sorter = new MergeSorter();
            case QuickSorter -> sorter = new QuickSorter();
            case ShellSorter -> sorter = new ShellSorter();
        }
        return sorter;
    }

    public static void main(String[] args) {

        for (int count: new int[]{10, 1_000, 10_000, 1_000_000}) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            fill(arrayList, count);
            System.out.println("\n\nCount: " + count);
            printArray(arrayList);

            for (SortingType type: new SortingType[]{SortingType.BubbleSorter, SortingType.MergeSorter, SortingType.QuickSorter, SortingType.ShellSorter}) {
                Sorter sorter = choiceSorterMethod(type);
                timeSorting(new ArrayList<>(arrayList), sorter, type.toString());
            }
        }
    }

    private static void fill(ArrayList<Integer> arrayList, int count) {
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            arrayList.add(random.nextInt(count));
        }
    }

    private static void printArray(ArrayList<Integer> arrayList) {
        int limit = Math.min(arrayList.size(), 50);
        List<Integer> printList = arrayList.subList(0, limit);
        System.out.print(printList.toString());
    }
    private static void timeSorting(ArrayList<Integer> arrayList, Sorter sorter, String sorterType) {
        long startTime = System.currentTimeMillis();
        ArrayList<Integer> sortedList = sorter.sort(arrayList);
        System.out.printf("\n%s: %d ms ", sorterType, System.currentTimeMillis() - startTime);
        printArray(sortedList);
    }
}
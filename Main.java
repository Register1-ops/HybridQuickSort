import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int iterations = 1;

        long totalTimeRandomQuick = 0;
        long totalTimeReversedQuick = 0;
        long totalTimeOrderedQuick = 0;

        long totalTimeRandomHybrid = 0;
        long totalTimeReversedHybrid = 0;
        long totalTimeOrderedHybrid = 0;

        // Random QuickSort
        for (int loop = 0; loop < iterations; loop++) {
            QuickSortAlgorithmClass quickSortRandom = new QuickSortAlgorithmClass();
            differentTypeLists randomLists1 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> randomList1 = randomLists1.createRandomList();
            //System.out.println(randomList1);
            long startTimeRandomQuick = System.currentTimeMillis();
            quickSortRandom.QuickSort(randomList1);
            long endTimeRandomQuick = System.currentTimeMillis();
            totalTimeRandomQuick += (endTimeRandomQuick - startTimeRandomQuick);
        }
        System.out.println("Average time for Random QuickSort: " + (totalTimeRandomQuick / iterations) + " ms");

        // Random HybridQuickSort
        for (int loop = 0; loop < iterations; loop++) {
            HybridQuickSortAlgorithm hybridSortRandom = new HybridQuickSortAlgorithm();
            differentTypeLists randomLists2 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> randomList2 = randomLists2.createRandomList();
            long startTimeRandomHybrid = System.currentTimeMillis();
            hybridSortRandom.HybridQuickSort(randomList2);
            long endTimeRandomHybrid = System.currentTimeMillis();
            totalTimeRandomHybrid += (endTimeRandomHybrid - startTimeRandomHybrid);
        }
        System.out.println("Average time for Random HybridQuickSort: " + (totalTimeRandomHybrid / iterations) + " ms\n");

        // Reversed QuickSort
        for (int loop = 0; loop < iterations; loop++) {
            QuickSortAlgorithmClass quickSortReversed = new QuickSortAlgorithmClass();
            differentTypeLists reversedLists1 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> reversedList1 = reversedLists1.reversedList();
            //System.out.println(reversedList1);
            long startTimeReversedQuick = System.currentTimeMillis();
            quickSortReversed.QuickSort(reversedList1);
            long endTimeReversedQuick = System.currentTimeMillis();
            totalTimeReversedQuick += (endTimeReversedQuick - startTimeReversedQuick);
        }
        System.out.println("Average time for Reversed QuickSort: " + (totalTimeReversedQuick / iterations) + " ms");

        // Reversed HybridQuickSort
        for (int loop = 0; loop < iterations; loop++) {
            HybridQuickSortAlgorithm hybridSortReversed = new HybridQuickSortAlgorithm();
            differentTypeLists reversedLists2 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> reversedList2 = reversedLists2.reversedList();
            long startTimeReversedHybrid = System.currentTimeMillis();
            hybridSortReversed.HybridQuickSort(reversedList2);
            long endTimeReversedHybrid = System.currentTimeMillis();
            totalTimeReversedHybrid += (endTimeReversedHybrid - startTimeReversedHybrid);
        }
        System.out.println("Average time for Reversed HybridQuickSort: " + (totalTimeReversedHybrid / iterations) + " ms\n");

        // Ordered QuickSort
        for (int loop = 0; loop < iterations; loop++) {
            QuickSortAlgorithmClass quickSortOrdered = new QuickSortAlgorithmClass();
            differentTypeLists orderedLists1 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> orderedList1 = orderedLists1.createRandomList();
            long startTimeOrderedQuick = System.currentTimeMillis();
            quickSortOrdered.QuickSort(orderedList1);
            long endTimeOrderedQuick = System.currentTimeMillis();
            totalTimeOrderedQuick += (endTimeOrderedQuick - startTimeOrderedQuick);
        }
        System.out.println("Average time for Ordered QuickSort: " + (totalTimeOrderedQuick / iterations) + " ms");

        // Ordered HybridQuickSort
        for (int loop = 0; loop < iterations; loop++) {
            HybridQuickSortAlgorithm hybridSortOrdered = new HybridQuickSortAlgorithm();
            differentTypeLists orderedLists2 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> orderedList2 = orderedLists2.createRandomList();
            long startTimeOrderedHybrid = System.currentTimeMillis();
            hybridSortOrdered.HybridQuickSort(orderedList2);
            long endTimeOrderedHybrid = System.currentTimeMillis();
            totalTimeOrderedHybrid += (endTimeOrderedHybrid - startTimeOrderedHybrid);
        }
        System.out.println("Average time for Ordered HybridQuickSort: " + (totalTimeOrderedHybrid / iterations) + " ms\n");
    }
}

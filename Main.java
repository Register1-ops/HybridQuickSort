import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int iterations = 5;

        long totalTimeRandomQuick = 0;
        long totalTimeReversedQuick = 0;
        long totalTimeOrderedQuick = 0;

        long totalTimeRandomHybrid = 0;
        long totalTimeReversedHybrid = 0;
        long totalTimeOrderedHybrid = 0;

        for (int loop = 0; loop < iterations; loop++) {
            // Random QuickSort
            QuickSortAlgorithmClass quickSortRandom = new QuickSortAlgorithmClass();
            differentTypeLists randomLists1 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> randomList1 = randomLists1.createRandomList();
            long startTimeRandomQuick = System.currentTimeMillis();
            quickSortRandom.QuickSort(randomList1);
            long endTimeRandomQuick = System.currentTimeMillis();
            totalTimeRandomQuick += (endTimeRandomQuick - startTimeRandomQuick);
            
            // Random HybridQuickSort
            HybridQuickSortAlgorithm hybridSortRandom = new HybridQuickSortAlgorithm();
            differentTypeLists randomLists2 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> randomList2 = randomLists2.createRandomList();
            long startTimeRandomHybrid = System.currentTimeMillis();
            hybridSortRandom.HybridQuickSort(randomList2); // Make sure method is named HybridQuickSort
            long endTimeRandomHybrid = System.currentTimeMillis();
            totalTimeRandomHybrid += (endTimeRandomHybrid - startTimeRandomHybrid);

            // Reversed QuickSort
            QuickSortAlgorithmClass quickSortReversed = new QuickSortAlgorithmClass();
            differentTypeLists reversedLists1 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> reversedList1 = reversedLists1.reversedList();
            long startTimeReversedQuick = System.currentTimeMillis();
            quickSortReversed.QuickSort(reversedList1);
            long endTimeReversedQuick = System.currentTimeMillis();
            totalTimeReversedQuick += (endTimeReversedQuick - startTimeReversedQuick);

            // Reversed HybridQuickSort
            HybridQuickSortAlgorithm hybridSortReversed = new HybridQuickSortAlgorithm();
            differentTypeLists reversedLists2 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> reversedList2 = reversedLists2.reversedList();
            long startTimeReversedHybrid = System.currentTimeMillis();
            hybridSortReversed.HybridQuickSort(reversedList2);
            long endTimeReversedHybrid = System.currentTimeMillis();
            totalTimeReversedHybrid += (endTimeReversedHybrid - startTimeReversedHybrid);

            // Ordered QuickSort
            QuickSortAlgorithmClass quickSortOrdered = new QuickSortAlgorithmClass();
            differentTypeLists orderedLists1 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> orderedList1 = orderedLists1.createRandomList(); // Make sure this method exists
            quickSortOrdered.QuickSort(orderedList1);
            long startTimeOrderedQuick = System.currentTimeMillis();
            quickSortOrdered.QuickSort(orderedList1);
            long endTimeOrderedQuick = System.currentTimeMillis();
            totalTimeOrderedQuick += (endTimeOrderedQuick - startTimeOrderedQuick);

            // Ordered HybridQuickSort
            HybridQuickSortAlgorithm hybridSortOrdered = new HybridQuickSortAlgorithm();
            differentTypeLists orderedLists2 = new differentTypeLists();
            ArrayList<ArrayList<Integer>> orderedList2 = orderedLists2.createRandomList(); // Make sure this method exists
            hybridSortOrdered.HybridQuickSort(orderedList2);
            long startTimeOrderedHybrid = System.currentTimeMillis();
            hybridSortOrdered.HybridQuickSort(orderedList2);
            long endTimeOrderedHybrid = System.currentTimeMillis();
            totalTimeOrderedHybrid += (endTimeOrderedHybrid - startTimeOrderedHybrid);
        }

        System.out.println("Average time for Random QuickSort: " + (totalTimeRandomQuick / iterations) + " ms");
        System.out.println("Average time for Random HybridQuickSort: " + (totalTimeRandomHybrid / iterations) + " ms\n");

        System.out.println("Average time for Reversed QuickSort: " + (totalTimeReversedQuick / iterations) + " ms");
        System.out.println("Average time for Reversed HybridQuickSort: " + (totalTimeReversedHybrid / iterations) + " ms\n");

        System.out.println("Average time for Ordered QuickSort: " + (totalTimeOrderedQuick / iterations) + " ms");
        System.out.println("Average time for Ordered HybridQuickSort: " + (totalTimeOrderedHybrid / iterations) + " ms\n");
    }
}

import java.util.*;

public class HybridQuickSortAlgorithm {

    Random random = new Random();
    int threshold = 5;  // Threshold for switching to InsertionSort

    // Sort each inner list of the listOfItems
    public ArrayList<ArrayList<Integer>> HybridQuickSort(ArrayList<ArrayList<Integer>> listOfItems) {
        if (listOfItems == null || listOfItems.isEmpty()) {
            return listOfItems;
        }

        // Iterate through the list of inner lists and apply hybrid quicksort
        for (int value = 0; value < listOfItems.size(); value++) {
            ArrayList<Integer> innerList = listOfItems.get(value);
            IterativeQuickSort(innerList);
        }

        return listOfItems;
    }

    // Iterative QuickSort implementation using stack
    public void IterativeQuickSort(ArrayList<Integer> innerList) {
        int low = 0;
        int high = innerList.size() - 1;

        // Stack to simulate recursion
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if ((high - low + 1) <= threshold) {
                // When the size is smaller than threshold, use InsertionSort
                InsertionSort(innerList, low, high);
            } else {
                // Otherwise, use QuickSort
                int pivotIndex = Partition(innerList, low, high);

                // Push left and right partitions onto the stack
                if (pivotIndex - 1 > low) {
                    stack.push(low);
                    stack.push(pivotIndex - 1);
                }
                if (pivotIndex + 1 < high) {
                    stack.push(pivotIndex + 1);
                    stack.push(high);
                }
            }
        }
    }

    // Insertion Sort for smaller partitions
    public void InsertionSort(ArrayList<Integer> innerList, int low, int high) {
        for (int i = low + 1; i <= high; i++) {
            int key = innerList.get(i);
            int j = i - 1;

            // Shift elements of innerList[low..i-1] that are greater than key
            while (j >= low && innerList.get(j) > key) {
                innerList.set(j + 1, innerList.get(j));
                j--;
            }

            // Place key in its correct position
            innerList.set(j + 1, key);
        }
    }

    // Partition logic for quicksort (ascending order)
    public int Partition(ArrayList<Integer> innerList, int low, int high) {
        // Median-of-three pivot selection for better performance
        int pivotIndex = medianOfThree(innerList, low, high);
        Swap(innerList, pivotIndex, high);  // Move pivot to the end
        int pivot = innerList.get(high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (innerList.get(j) <= pivot) { // Ascending order
                i++;
                Swap(innerList, i, j);
            }
        }
        Swap(innerList, i + 1, high); // Move pivot to its correct position
        return i + 1;
    }

    // Median-of-three pivot selection for better performance on partially sorted lists
    private int medianOfThree(ArrayList<Integer> list, int low, int high) {
        int mid = low + (high - low) / 2;
        int a = list.get(low);
        int b = list.get(mid);
        int c = list.get(high);

        // Sort the three values and return the index of the median
        if (a > b) {
            if (a < c) return low;
            else if (b > c) return mid;
            else return high;
        } else {
            if (a > c) return low;
            else if (b < c) return mid;
            else return high;
        }
    }

    // Swap two elements in the list
    public void Swap(ArrayList<Integer> innerList, int i, int j) {
        int temp = innerList.get(i);
        innerList.set(i, innerList.get(j));
        innerList.set(j, temp);
    }
}

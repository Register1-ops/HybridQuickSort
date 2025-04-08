import java.util.*;

public class QuickSortAlgorithmClass {

    Random random = new Random(); // still here, but unused

    // Sort each inner list of the listOfItems
    public ArrayList<ArrayList<Integer>> QuickSort(ArrayList<ArrayList<Integer>> listOfItems) {
        if (listOfItems == null || listOfItems.isEmpty()) {
            return listOfItems;
        }

        // Iterate through the list of inner lists and apply quicksort
        for (int value = 0; value < listOfItems.size(); value++) {
            ArrayList<Integer> innerList = listOfItems.get(value);
            IterativeQuickSort(innerList); // Sorting each inner list
        }

        return listOfItems;
    }

    // Iterative quicksort implementation using a stack
    public void IterativeQuickSort(ArrayList<Integer> innerList) {
        int low = 0;
        int high = innerList.size() - 1;

        // Stack to simulate recursion, avoiding deep recursion stack
        Stack<Integer> stack = new Stack<>();
        stack.push(low);
        stack.push(high);

        // While there are elements to sort
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if (low < high) {
                // Partition the list and get the pivot index
                int pivotIndex = Partition(innerList, low, high);

                // Push the sublists back onto the stack
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

    // Partition logic for quicksort (ascending order)
    public int Partition(ArrayList<Integer> innerList, int low, int high) {
        if (high <= low) return low; // Prevent invalid partition range

        // Median-of-three pivot selection (optional, for improved performance)
        int mid = low + (high - low) / 2;
        int pivotIndex = medianOfThree(innerList, low, mid, high);
        Swap(innerList, pivotIndex, high); // Move pivot to the end
        int pivot = innerList.get(high);

        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (innerList.get(j) <= pivot) { // Ascending order
                i++;
                Swap(innerList, i, j);
            }
        }
        Swap(innerList, i + 1, high); // Move pivot to correct position
        return i + 1;
    }

    // Median-of-three pivot selection to improve performance in sorted/partially sorted lists
    private int medianOfThree(ArrayList<Integer> list, int low, int mid, int high) {
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

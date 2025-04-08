import java.util.*;

public class HybridQuickSortAlgorithm {

    Random random = new Random();
    int threshold = 50;

    public ArrayList<ArrayList<Integer>> HybridQuickSort(ArrayList<ArrayList<Integer>> listOfItems) {
        if (listOfItems == null || listOfItems.isEmpty()) {
            return listOfItems;
        }

        for (int value = 0; value < listOfItems.size(); value++) {
            ArrayList<Integer> innerList = listOfItems.get(value);
            IterativeQuickSort(innerList);
            listOfItems.set(value, innerList);
        }

        return listOfItems;
    }

    // Iterative QuickSort implementation using stack
    public void IterativeQuickSort(ArrayList<Integer> innerList) {
        int low = 0;
        int high = innerList.size() - 1;

        // Stack to simulate the recursion
        Stack<Integer> stack = new Stack<>();
        
        // Push initial low and high indices to the stack
        stack.push(low);
        stack.push(high);

        // While there are elements to sort
        while (!stack.isEmpty()) {
            high = stack.pop();
            low = stack.pop();

            if ((high - low + 1) <= threshold) {
                InsertionSort(innerList, low, high);

            }
            
            else{
                int pivotIndex = Partition(innerList, low, high);

                // Push left and right partitions to the stack
                stack.push(low);
                stack.push(pivotIndex - 1);
                
                stack.push(pivotIndex + 1);
                stack.push(high);
            
            }
        }
        //System.out.println("\n\n0---------------------0");
    }

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
        int pivot = innerList.get(high);  // Use the last element as the pivot
        int i = low - 1;
        //System.out.println("1");

        for (int j = low; j < high; j++) {
            if (innerList.get(j) <= pivot) {
                i++;
                Swap(innerList, i, j);
            }
        }

        Swap(innerList, i + 1, high);  // Place pivot in the correct position
        return i + 1;
    }


    // Swap two elements in the list
    public void Swap(ArrayList<Integer> innerList, int i, int j) {
        int temp = innerList.get(i);
        innerList.set(i, innerList.get(j));
        innerList.set(j, temp);
    }
    
}

import java.util.*;

public class ReverseList {

    Random random = new Random();

    public ArrayList<ArrayList<Integer>> ReverseQuickSort(ArrayList<ArrayList<Integer>> listOfItems) {
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

            if (low < high) {
                int pivotIndex = Partition(innerList, low, high);

                // Push left and right partitions to the stack
                stack.push(low);
                stack.push(pivotIndex - 1);
                
                stack.push(pivotIndex + 1);
                stack.push(high);
            }
        }
    }

    // Partition logic for quicksort (ascending order)
    public int Partition(ArrayList<Integer> innerList, int low, int high) {
        Random rand = new Random();
        int randomIndex = rand.nextInt(high - low + 1) + low;  // Random index in range
        Swap(innerList, randomIndex, high);  // Swap pivot with the last element
        int pivot = innerList.get(high);
        
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (innerList.get(j) <= pivot) {
                i = i + 1;
                Swap(innerList, i, j);
            }
        }
        Swap(innerList, i + 1, high);  // Place the pivot at the correct position
        return i + 1;
    }
    

    // Swap two elements in the list
    public void Swap(ArrayList<Integer> innerList, int i, int j) {
        int temp = innerList.get(i);
        innerList.set(i, innerList.get(j));
        innerList.set(j, temp);
    }
}

import java.util.ArrayList;
import java.util.Random;

public class differentTypeLists {

    Random random = new Random();
    int[] sizes  = { 1000, 5000, 10000, 50000, 75000, 100000, 500000};


    public ArrayList<ArrayList<Integer>> createRandomList(){
        Random random = new Random();
        ArrayList<ArrayList<Integer>> listOfItems = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < this.sizes.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < this.sizes[i]; j++) {
                list.add(random.nextInt(500000) + 1);
            }
            listOfItems.add(list);
        }
        return listOfItems;
    }

    public ArrayList<ArrayList<Integer>> reversedList(){
        ArrayList<ArrayList<Integer>> listOfItems = new ArrayList<ArrayList<Integer>>();
        for (int i = 0; i < this.sizes.length; i++) {
            ArrayList<Integer> list = new ArrayList<>();
            for (int j = 0; j < this.sizes[i]; j++) {
                list.add(random.nextInt(500000) + 1);
            }          
            listOfItems.add(list);

        }
        //System.out.println(listOfItems);
        ReverseList reverseList = new ReverseList();
        // Reversing the list using ReverseList class
        ArrayList<ArrayList<Integer>> reversedList = reverseList.ReverseQuickSort(listOfItems);
        //System.out.println("Reversed list: " + reversedList);
        return reversedList;
    }

    
}

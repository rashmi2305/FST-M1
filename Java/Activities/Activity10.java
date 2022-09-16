package Activities;
import java.util.ArrayList;
import java.util.HashSet;

public class Activity10 {
    public static void main(String[] args){
        //Create a HashSet named hs.
        HashSet<String> hs= new HashSet<String>();
        //Add 6 objects using add() method to the HashSet.
        hs.add("A");
        hs.add("B");
        hs.add("C");
        hs.add("D");
        hs.add("E");
        hs.add("F");
        //Then print the size of the HashSet using the size() method.
        System.out.println("Hash Set size is: " + hs.size());
        //Remove an element using the remove() method.
        hs.remove("F");
        //Also try to remove an element that is not present in the Set.
        hs.remove("G");     //No error is given if requested hashset value is not present
        //Use the contains() method to check if an item is in the Set or not.
        if(hs.contains("D")){
            System.out.println("D is present");
        }else{
            System.out.println("D is not present");
        }
        //Print the updated set.
        for(String item: hs){
            System.out.println(item);
        }
    }
}

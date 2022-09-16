package Activities;
import java.util.ArrayList;

public class Activity9 {
    public static void main(String[] args){
        //Create an ArrayList named myList of type String
        ArrayList<String> myList= new ArrayList<String>();
        //Add 5 names to the ArrayList using add() method.
        myList.add("John");
        myList.add("Test2");
        myList.add("Test3");
        myList.add("Test5");
        myList.add(3, "Test4");    //Adding object at specific locatoin
        for(String item: myList){
            System.out.println(item);
        }
        //Then use get() method to retrieve the 3rd name in the ArrayList.
        System.out.println("Third element in list: " + myList.get(2));
        //Use contains() method to check if a name exists in the ArrayList.
        if(myList.contains("Test3")){
            System.out.println("Test3 is present");
        }else{
            System.out.println("Test3 is not present");
        }
        //Use size() method to print the number of names in the ArrayList.
        System.out.println("Array List size is: " + myList.size());
        //Use remove() method to remove a name from the list and print the size() of the list again.
        myList.remove(4);
        System.out.println("Array List size is: " + myList.size());
    }
}

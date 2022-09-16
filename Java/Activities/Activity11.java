package Activities;

import java.util.HashMap;

public class Activity11 {
    public static void main(String[] args){
        //Create a Map named colours with integer keys and String values.
        HashMap<Integer, String> hm = new HashMap<Integer, String>();
        //Add 5 random colours to it and print the Map to the console.
        hm.put(1, "Red");
        hm.put(2, "Green");
        hm.put(3, "Blue");
        hm.put(4, "Orange");
        hm.put(5, "Brown");
        //Remove one colour using the remove() method.
        hm.remove(2);           //If double qoutes usd with 2, it will look for string 2 and will not remove index 2
        // Map after removing a colour
        System.out.println("After removing Index 2: " + hm);
        //Check if the colour green exists in the Map using the containsValue() method.
        if(hm.containsValue("Green")){
            System.out.println("Green is present");
        }else{
            System.out.println("Green is not present");
        }
        //Print the size of the Map using the size() method.
        System.out.println("Hash Set size is: " + hm.size());
    }
}

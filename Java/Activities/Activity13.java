package Activities;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;
//import java.util.*;

public class Activity13 {
    public static void main(String[] args){
        //accept number inputs from the console using Scanner class and store them in an array
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        ArrayList<Integer> myArr = new ArrayList<Integer>();

        while(myObj.hasNextInt()){
            myArr.add(myObj.nextInt());
        }
        Random indexGen = new Random();
        //convert the ArrayList into an array using the toArray() method
        Integer nums[] = myArr.toArray(new Integer[0]);
        int index = indexGen.nextInt(nums.length);
        //indexGen to generate an integer value with the bounds set to the length of nums array.
        System.out.println("Next int value: " + nums[index]);
        myObj.close();
    }
}

package Activities;

import java.util.Arrays;

public class Activity4 {

    static void insertionsort(int[] myArray) {
        int i;
        int j = 0;
        for (i = 0; i < myArray.length; i++) {
            int key = myArray[i];
            j = i - 1;
            System.out.println(key);
            while (j >= 0 && key < myArray[j]) {
                myArray[j + 1] = myArray[j];
                --j;
            }
            myArray[j + 1] = key;
        }
    }

    public static void main(String[] args) {
        int[] data = {9, 5, 1, 4, 3};
        insertionsort(data);
        System.out.println("Sorted Array in Ascending Order: ");
        System.out.println(Arrays.toString(data));
    }
}
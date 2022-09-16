package Activities;

public class Activity2 {
    public static void main(String[] args){
        int[] myArray = {10, 77, 10, 54, -11, 10,10};
        int searchNum = 10;
        int temp_sum = 0;
        for(int item:myArray){
            System.out.println(item);
            if (item == searchNum) {
                //Add them
                temp_sum += searchNum;
            }
        }
        if(temp_sum==30){
            System.out.println("sum is 30");
        }
        else{
            System.out.println("sum is not 30");
        }
    }
}

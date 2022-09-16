package Activities;
//creating a functional interface and use it with a lambda expression.
//Create an interface named Addable that contains a single method, add(). This method accepts two arguments, num1 and num2.
interface Addable{
    int Add(int num1, int num2);
}
//create a class named Activity12 with a main method.
public class Activity12 {
    public static void main(String[] args){
        //create two variables, both of type Addable(the interface).
        //ad1, contains a lambda expression(no body), that saves the result of num1 plus num2.
        Addable ad1 = (num1,num2) -> num1 + num2;
        System.out.println(ad1.Add(10, 200));
        //ad2, contains a lambda function(has a body), that also saves the result of num1 plus num2
        Addable ad2 = (int num1,int num2) -> {
            return (num1 + num2);
        };
        System.out.println(ad1.Add(100, 200));
    }
}

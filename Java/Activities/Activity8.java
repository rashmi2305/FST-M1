package Activities;

//Create a class named CustomException that extends the Exception class.
class CustomException extends Exception{
    //Add a private String variable named message that is going to be the exception message.
    private String message = null;
    //Add constructor that initializes the message variable with the custom String passed in
    public CustomException(String message){
        this.message = message;
    }
    //Add an Override annotation for getMessage() that returns the custom message
    @Override
    public String getMessage() {
        return message;
    }
}
public class Activity8 {
    static void exceptionTest(String str) throws CustomException {
        if(str == null) {
            throw new CustomException("String value is null");
        } else {
            System.out.println(str);
        }
    }
    public static void main(String[] args){
        try{
            // Method call with correct input
            Activity8.exceptionTest("Will print to console");
            // Method call with incorrect input
            Activity8.exceptionTest(null); // Exception is thrown here
            Activity8.exceptionTest("Won't execute");
        } catch(CustomException ce){
            System.out.println("Inside catch block: " + ce.getMessage());
        }

    }
}

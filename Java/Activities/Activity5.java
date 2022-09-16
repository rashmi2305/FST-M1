//Abstract class
abstract class Book {
    String sTitle;
    abstract void setTitle(String s);
    String getTitle(){
        return sTitle;
    }
}

class MyBook extends Book{
    public void setTitle(String s){
        sTitle = s;
    }
}

public class Activity5 {

    public static void main(String []args) {
        //Initialize title of the book
        String title = "Hover Car Racer";
        //Create object for MyBook
        Book newNovel = new MyBook();
        //Set title
        newNovel.setTitle(title);

        //Print result
        System.out.println("The title is: " + newNovel.getTitle());
    }
}
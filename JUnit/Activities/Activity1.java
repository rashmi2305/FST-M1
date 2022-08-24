//will be testing an ArrayList with elements:

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Activity1 {
    //Create a test fixture that declares a static ArrayList named list.
    static ArrayList<String> list;
    //Create a setUp() method with the @BeforeAll annotation. Add the following to the setUp() method:
    //// Initialize test fixtures before each test method
    @BeforeEach
    void setUp() throws Exception{
        list = new ArrayList<String>();
        list.add("alpha");
        list.add("beta");
    }

    //Create 2 @Test methods, insertTest() and replaceTest().
    @Test
    public void insertTest(){
        //In insertTest(),
        //Write an assertion to check the size of the ArrayList. The expected value is 2.
        assertEquals(2,list.size(),"Array list size is incorrect");
        //Add a new value to the list and write another assertion to check the size of the new list. The expected values of the list should be 3.
        list.add("gamma");
        assertEquals(3,list.size(),"Array list size is incorrect");
        //Finally write assertions for checking each of the values in the ArrayList.
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("beta", list.get(1), "Wrong element");
        assertEquals("gamma", list.get(2), "Wrong element");
    }

    @Test
    void replaceTest(){
        //In replaceTest(),
        //Write an assertion to check the size of the ArrayList. The expected value is 2.
        assertEquals(2,list.size(),"Array list size is incorrect");
        //Add a new value to the list and write another assertion to check the size of the new list. The expected values of the list should be 3.
        list.add("gamma");
        assertEquals(3,list.size(),"Array list size is incorrect");
        //Finally, use the ArrayList set() method to replace the value on index 1 to a different value.
        list.set(1,"theta");
        //Write an assertion to assert the values of the ArrayList.
        assertEquals("alpha", list.get(0), "Wrong element");
        assertEquals("theta", list.get(1), "Wrong element");
        assertEquals("gamma", list.get(2), "Wrong element");
    }

}

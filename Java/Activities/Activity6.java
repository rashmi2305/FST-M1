package Activities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Plane {
    private List<String> passengers;
    private int maxPassengers;
    private Date lastTimeTookOf;
    private Date lastTimeLanded;
    //Add a constructor that initializes the values of maxPassengers and the array passengers to an empty array.
    public Plane(int maxPassengers){
        this.maxPassengers = maxPassengers;
        this.passengers = new ArrayList<>();
    }
    public void onboard(String passengers){
        this.passengers.add(passengers);
    }
    public Date takeOff(){      ///return value is date
        this.lastTimeTookOf = new Date();
        return lastTimeTookOf;              //returns the current date and time
    }
    //land(): sets the value of lastTimeLanded to the current date and time. Also clear() the array.
    public void land(){                     //void is used as no return value
        this.lastTimeLanded = new Date();
        this.passengers.clear();
    }
    //getLastTimeLanded(): returns the value of lastTimeLanded.
    public Date getLastTimeLanded(){
        return lastTimeLanded;
    }
    //getPassesngers(): returns the array of passengers.(use List<String>)
    public List<String> getPassesngers(){
        return passengers;
    }
}

public class Activity6 {
    public static void main(String[] args) throws InterruptedException{     //Interrupted exception added for sleep method
        Plane oPlane = new Plane(5);     //create an object of the Plane class named plane.
        // Set the maxPassengers value to 10 by passing it to the constructor.
        oPlane.onboard("Tes1");
        oPlane.onboard("Tes2");
        oPlane.onboard("Tes3");
        oPlane.onboard("Tes4");
        oPlane.onboard("Tes5");
        Date takeoffTime = oPlane.takeOff();//Print the take-off time using the takeOff() method.
        System.out.println("Take off time is: "+ takeoffTime);
        //Print the list of passengers using the getPassengers() method.
        System.out.println("Passenger List: "+ oPlane.getPassesngers());
        Thread.sleep(5000); //Thread.sleep() method to pause execution for 5 seconds.
        //Land() the plane and print the time of landing using getLastTimeLanded() method.
        oPlane.land();      //If not called, landing time in next statement will be Null
        System.out.println("Landing Time: "+ oPlane.getLastTimeLanded());
    }
}

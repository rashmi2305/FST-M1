package Activities;
//implementing Hybrid Inheritance (Multiple and Simple)

interface BicycleParts{
    public int iGears = 0;      //Needs to be initialized to value, else will give error
    public int speed = 0;
}

interface BicycleOperations{
    public void applyBrake(int decrement);       //Can't have a body as method in interface
    public void speedUp(int increment);
}

class Bicycle implements BicycleParts, BicycleOperations{
    public int iGears;
    public int currentSpeed;
    public Bicycle(int iGears, int currentSpeed){       //Initialize the values of gears and currentSpeed in a constructor.
        this.iGears = iGears;
        this.currentSpeed = currentSpeed;
    }
    public void applyBrake(int decrement){
        currentSpeed -= decrement;
        System.out.println("Current speed: " + currentSpeed);
    }
    public void speedUp(int increment){
        currentSpeed -= increment;
        System.out.println("Current speed: " + currentSpeed);
    }
    public String bicycleDesc() {
        return("No of gears are "+ iGears + "\nSpeed of bicycle is " + currentSpeed);
    }
}

class MountainBike extends Bicycle{
    public int seatHeight;
    public MountainBike(int iGears, int currentSpeed, int seatHeight){  //constructor for MountainBike, use the super keyword to include gears and currentSpeed for this class. Also initialize seatHeight.
        //Invoking base-class(Bicycle) constructor
        super(iGears, currentSpeed);
        this.seatHeight = seatHeight;
    }
    public void setHeight(int newValue) {
        seatHeight = newValue;
    }
    public String bicycleDesc() {
        return("seat Height is " + seatHeight);
    }
}
public class Activity7 {
    public static void main(String[] args) throws InterruptedException{
    MountainBike mb = new MountainBike(4,40,7);
    System.out.println(mb.bicycleDesc());
    mb.speedUp(20);
    mb.applyBrake(5);
    }
}

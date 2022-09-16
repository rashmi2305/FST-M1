package Activities;

public class Car {
    String sColor;
    String sTransmission;
    int iMake;
    int iTyres;
    int iDoors;

    //Constructor
    Car(){
        iTyres = 4;
        iDoors = 5;
    }
    //Method creation
    public void displayCharacteristics(){
        System.out.println("Value for tyres is: " + iTyres);
        System.out.println("Value for make is: " + iMake);
    }
    public void accelarate(){
        System.out.println("Car is moving");
    }
    public void brake(){
        System.out.println("Car is stopped");
    }
}

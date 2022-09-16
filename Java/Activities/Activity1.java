package Activities;

public class Activity1 {
    public static void main(String[] args){
        Car Audi = new Car();
        Audi.iMake = 2004;
        Audi.sColor = "Black";
        Audi.sTransmission = "Manual";
        Audi.displayCharacteristics();
        Audi.accelarate();
        Audi.brake();
    }
}

package method_1;

public class Car extends Vehicle{
    private final int passengerCapacity;
    private final String compartments;

    public Car(String type, String brand, String color, int passengerCapacity, int yearOfManufacture, String compartments) {
        super(type, brand, color, yearOfManufacture);
        this.passengerCapacity = passengerCapacity;
        this.compartments = compartments;
    }

    public void printVehicle() {
        super.printVehicle();
        System.out.println("载客量"+passengerCapacity+"人 厢数"+compartments);
    }

    public int getPassengerCapacity() {
        return passengerCapacity;
    }

    public String getCompartments() {
        return compartments;
    }

}

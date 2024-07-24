package lab7_1;

public class Car extends Vehicle{
    private final int passengerCapacity;
    private final String compartments;

    public Car(String type, String brand, String color, int passengerCapacity, int yearOfManufacture, String compartments) {
        super(type, brand, color, yearOfManufacture);
        if(passengerCapacity < 0 ){
            throw new IllegalArgumentException("载客量输入不合法");
        } else if (compartments.charAt(0) - '0' < 0 ) {
            throw new IllegalArgumentException("厢数输入不合法");
        }
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

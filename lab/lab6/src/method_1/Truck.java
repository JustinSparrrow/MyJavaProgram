package method_1;

public class Truck extends Vehicle{
    private final double deadweightCapacity;

    public Truck(String type, String brand, String color, double deadweightCapacity, int yearOfManufacture) {
        super(type, brand, color, yearOfManufacture);
        this.deadweightCapacity = deadweightCapacity;
    }

    public void printVehicle() {
        super.printVehicle();
        System.out.println("载重量"+deadweightCapacity+"吨");
    }

    public double getDeadweightCapacity() {
        return deadweightCapacity;
    }

}

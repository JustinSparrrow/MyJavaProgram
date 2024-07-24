package lab7_1;

public class Truck extends Vehicle{
    private final double deadweightCapacity;

    public Truck(String type, String brand, String color, double deadweightCapacity, int yearOfManufacture) {
        super(type, brand, color, yearOfManufacture);
        if(deadweightCapacity < 0.0){
            throw new IllegalArgumentException("载重量输入错误");
        }
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

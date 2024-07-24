package method_1;

public class Vehicle {

    private final String type;
    private final String brand;
    private final String color;
    private final int yearOfManufacture;

    public Vehicle(String type, String brand, String color, int yearOfManufacture) {
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
    }

    public void printVehicle(){
        System.out.print("："+type+"，品牌："+brand+" 颜色："+color+" 出厂年份："+yearOfManufacture);
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

}

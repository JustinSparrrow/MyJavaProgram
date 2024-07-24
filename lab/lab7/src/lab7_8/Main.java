package lab7_8;

import java.util.ArrayList;

public class Main {

    public ArrayList<CarbonFootprint> arrayList = new ArrayList<>();

    public void printMessage(){
        Bicycle bicycle = new Bicycle();
        Building building = new Building();
        Car car = new Car();
        arrayList.add(bicycle);
        arrayList.add(building);
        arrayList.add(car);
        for (CarbonFootprint carbonFootprint : arrayList) {
            System.out.println(carbonFootprint.getCarbonFootprint());
        }
    }

    public static void main(String[] args) {
        new Main().printMessage();
    }
}

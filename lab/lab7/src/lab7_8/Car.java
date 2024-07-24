package lab7_8;

public class Car implements CarbonFootprint{

    private double mileage;
    private Vehicle vehicle;
    private double efficacy;

    @Override
    public double getCarbonFootprint() {
        return 0;
    }
}

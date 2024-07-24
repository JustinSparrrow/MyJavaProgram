package lab7_8;

public class Bicycle implements CarbonFootprint{
    private double mileage;
    private double efficacy;

    @Override
    public double getCarbonFootprint() {
        return 0;
    }
}

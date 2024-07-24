package lab7_7;

public class SalariedCompensationModel implements CompensationModel{

    private final double weeklySalary;

    public SalariedCompensationModel(double weeklySalary) {
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double earnings() {
        return weeklySalary;
    }

}

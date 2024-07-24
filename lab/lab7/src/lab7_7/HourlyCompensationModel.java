package lab7_7;

public class HourlyCompensationModel implements CompensationModel{

    private double wage;
    private double hours;

    public
    HourlyCompensationModel(double wage, double hours) {
        this.wage = wage;
        this.hours = hours;
    }

    @Override
    public double earnings() {
        return hours <= 40 ? wage * hours : 40 * wage + (hours - 40) * wage * 1.5;
    }

}

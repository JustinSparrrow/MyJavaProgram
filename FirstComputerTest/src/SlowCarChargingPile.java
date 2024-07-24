import java.util.Formatter;

public class SlowCarChargingPile extends CarChargingPile{
    // 费用
    private double price = 1.1;

    public SlowCarChargingPile(String Type, int ID, String location, String maximumCurrent, String voltage) {
        super(Type, ID, location, maximumCurrent, voltage);
    }

    public double chargingCost(){
        double cost = price * getChargingDegree();
        String NumberCost = new Formatter().format("%.2f", cost).toString();
        return Double.parseDouble(NumberCost);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        // 保留两位小数
        price = Double.parseDouble(new Formatter().format("%.2f", price).toString());
        this.price = price;
    }
}

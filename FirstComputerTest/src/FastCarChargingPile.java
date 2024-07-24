import java.util.Formatter;

public class FastCarChargingPile extends CarChargingPile{

    private double price = 1.2;
    private double cost = 1.0;

    public FastCarChargingPile(String Type, int ID, String location, String maximumCurrent, String voltage) {
        super(Type, ID, location, maximumCurrent, voltage);
    }

    public double chargingCost(){
        int times = (int) (getTime()/20);
        double money = price * getChargingDegree() + cost*times;
        // 保留两位小数
        String NumberMoney = new Formatter().format("%.2f", money).toString();
        return Double.parseDouble(NumberMoney);
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}

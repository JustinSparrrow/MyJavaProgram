package lab7_8;

public class Building implements CarbonFootprint{

    private int people;         // 家庭人数
    private double power;       // 电力
    private double naturalGas;  // 天然气
    private double heatFuel;    // 热力用燃油
    private double coal;        // 煤炭
    private double liquefiedGas;    // 液化气
    private double propane;     // 丙烷
    private double woodChipSlates;  // 木屑板条

//    public Building(int people, double power, double naturalGas, double heatFuel, double coal, double liquefiedGas, double propane, double woodChipSlates) {
//        this.people = people;
//        this.power = power;
//        this.naturalGas = naturalGas;
//        this.heatFuel = heatFuel;
//        this.coal = coal;
//        this.liquefiedGas = liquefiedGas;
//        this.propane = propane;
//        this.woodChipSlates = woodChipSlates;
//    }

    @Override
    public double getCarbonFootprint() {
        return 0;
    }
}

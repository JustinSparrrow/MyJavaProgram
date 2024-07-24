// 父类
public class CarChargingPile {

    private String Type;
    private int ID;                 // 编号
    private String location;        // 位置
    private String maximumCurrent;  // 最大电流
    private String voltage;         // 电压
    private boolean useCondition = false;    // 使用状态

    private double time;
    private double chargingDegree;


    // 构造方法
    public CarChargingPile(String Type, int ID, String location, String maximumCurrent, String voltage) {
        if(ID > 9999 || ID < 1){
            System.out.println("编号错误！请重新输入");
            return;
        }
        this.ID = ID;
        this.Type = Type;
        this.location = location;
        this.maximumCurrent = maximumCurrent;
        this.voltage = voltage;
    }

    // 充电费用
    public double chargingCost(){
        return 0.00;
    }

    // 输出信息
    public void printMessage(){
        System.out.print(ID+" "+location+" "+maximumCurrent+" "+voltage+" "+useCondition+" ");
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMaximumCurrent() {
        return maximumCurrent;
    }

    public void setMaximumCurrent(String maximumCurrent) {
        this.maximumCurrent = maximumCurrent;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public boolean isUseCondition() {
        return useCondition;
    }

    public void setUseCondition(boolean useCondition) {
        this.useCondition = useCondition;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public double getChargingDegree() {
        return chargingDegree;
    }

    public void setChargingDegree(double chargingDegree) {
        this.chargingDegree = chargingDegree;
    }
}

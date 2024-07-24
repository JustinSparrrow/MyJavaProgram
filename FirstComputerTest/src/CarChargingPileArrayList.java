import java.util.ArrayList;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class CarChargingPileArrayList {

    // 列表
    private ArrayList<CarChargingPile> pileArrayList = new ArrayList<>();

    Scanner scanner = new Scanner(System.in);

    public void addPile(){
        boolean flag = true;
        while (flag) {
            System.out.println("请按照以下格式输入：\n" +
                    "编号、位置、最大电流、电压\n" +
                    "如：\n" +
                    "快充 111 西部片区 400A 250KW\n" +
                    "慢充 222 主校区 100A 6KW\n" +
                    "其中“编号“为1-9999的整数。");
            String line = scanner.nextLine();
            String[] s = line.split(" ");
            if (s.length != 5) {
                System.out.println("参数个数不对！请重新输入：");
            } else if (!s[0].equals("快充") && !s[0].equals("慢充")) {
                System.out.println("没有该类型的充电桩，请重新输入：");
            } else if (Integer.parseInt(s[1]) < 1 || Integer.parseInt(s[1]) > 9999 || isIDSame(Integer.parseInt(s[1]))) {
                System.out.println("编号错误！请重新输入");
            } else {
                System.out.println("输入成功！");
                if (s[0].equals("快充")) {
                    FastCarChargingPile fastCarChargingPile = new FastCarChargingPile(s[0], Integer.parseInt(s[1]), s[2], s[3], s[4]);
                    pileArrayList.add(fastCarChargingPile);
                } else if (s[0].equals("慢充")) {
                    SlowCarChargingPile slowCarChargingPile = new SlowCarChargingPile(s[0], Integer.parseInt(s[1]), s[2], s[3], s[4]);
                    pileArrayList.add(slowCarChargingPile);
                }
            }
            System.out.println("是否结束新增？（Y/n）");
            String m = scanner.next();
            if(m.equals("Y") || m.equals("y")){
                flag = false;
            } else {
                System.out.println("请继续输入：");
            }
            scanner.nextLine();
        }
    }

    // 判断编号是否重复
    private boolean isIDSame(int ID){
        for(int i = 0; i < pileArrayList.size(); i++){
            if(ID == pileArrayList.get(i).getID()){
                return true;
            }
        }
        return false;
    }

    // 充电
    public void charging(){
        Random random = new Random();
        int len = pileArrayList.size();
        for(int i = 0; i < len/2; i++){
            int n = random.nextInt(len);
            if(!pileArrayList.get(n).isUseCondition()){
                double chargingDegree = Math.random()*80 + 10;
                double chargingTime = Math.random()*240 + 20;
                pileArrayList.get(n).setChargingDegree(chargingDegree);
                pileArrayList.get(n).setTime(chargingTime);
                pileArrayList.get(n).setUseCondition(true);
            } else {
                i -= 1;
            }
        }
        System.out.println("开启充电！");
    }

    // 打印信息
    public void printPileMessage(){
        for (CarChargingPile carChargingPile : pileArrayList) {
            carChargingPile.printMessage();
            System.out.println();
        }
    }

    // 打印充电费用
    public void printPileChargingCost(){
        for (int i = 0; i < pileArrayList.size(); i++){
            if(pileArrayList.get(i).isUseCondition()) {
                if (pileArrayList.get(i).getType().equals("快充")) {
                    FastCarChargingPile fastCarChargingPile = (FastCarChargingPile) pileArrayList.get(i);
                    double price = fastCarChargingPile.chargingCost();
                    fastCarChargingPile.printMessage();
                    System.out.println("充电费用："+price);
                } else {
                    SlowCarChargingPile slowCarChargingPile = (SlowCarChargingPile) pileArrayList.get(i);
                    double price = slowCarChargingPile.chargingCost();
                    slowCarChargingPile.printMessage();
                    System.out.println("充电费用"+price);
                }
            }
        }
    }

    // 涨价
    public void riseInSlowChargingPrice(){
        double money = 1.1;
        for(int i = 0; i < pileArrayList.size(); i++){
            if(pileArrayList.get(i).getType().equals("慢充")){
                SlowCarChargingPile slowCarChargingPile = (SlowCarChargingPile) pileArrayList.get(i);
                money = slowCarChargingPile.getPrice()*1.05;
                slowCarChargingPile.setPrice(money);
            }
        }
        System.out.println("上调成功！此时的收费标准为"+ new Formatter().format("%.2f", money));
    }

    public ArrayList<CarChargingPile> getPileArrayList() {
        return pileArrayList;
    }

    public void setPileArrayList(ArrayList<CarChargingPile> pileArrayList) {
        this.pileArrayList = pileArrayList;
    }
}

import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    CarChargingPileArrayList pileArrayList = new CarChargingPileArrayList();
    public void showUI(){
        boolean flag = true;
        while (flag){
            System.out.println("请输入命令编号：\n" +
                    "1. 新增充电桩\n" +
                    "2. 充电桩充电\n" +
                    "3. 列出所有充电桩信息\n" +
                    "4. 列出每台充电桩已充电费用\n" +
                    "5. 将慢速充电桩收费标准上调5%\n" +
                    "6. 退出");
            // 异常处理
            try {
                int n = scanner.nextInt();
                if(n < 1 || n > 6){
                    System.out.println("请输入1-6之间的整数！");
                } else {
                    switch (n){
                        case 1 -> pileArrayList.addPile();
                        case 2 -> pileArrayList.charging();
                        case 3 -> pileArrayList.printPileMessage();
                        case 4 -> pileArrayList.printPileChargingCost();
                        case 5 -> pileArrayList.riseInSlowChargingPrice();
                        case 6 -> flag = false;
                    }
                }
            } catch (Exception e){
                System.out.println("请输入1-6之间的整数！");
            }
        }
    }

    public static void main(String[] args) {
        new Menu().showUI();
    }
}

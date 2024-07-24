package method_1;

import java.util.Scanner;

public class Menu {

    VehicleList vehicleList = new VehicleList();
    Scanner scanner = new Scanner(System.in);

    public void showUI(){
        boolean flag = true;
        while (flag) {
            System.out.println("请输入对应输入进行相应菜单操作：\n1. \t新增车辆\n2. \t查询车辆\n3. \t列出所有车辆\n4. \t结束程序");
            int n = scanner.nextInt();
            switch (n) {
                case 1 -> vehicleList.addCar();
                case 2 -> vehicleList.searchCar();
                case 3 -> vehicleList.printCar();
                case 4 -> flag = false;
                default -> System.out.println("请输入1-4的整数");
            }
        }
    }

    public static void main(String[] args) {
        new Menu().showUI();
    }
}

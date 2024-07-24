package method_1;

import java.util.ArrayList;
import java.util.Scanner;

public class VehicleList {
    Scanner scanner = new Scanner(System.in);
    private final ArrayList<Vehicle> vehicleArrayList = new ArrayList<>();

    public ArrayList<Vehicle> getCarArrayList() {
        return vehicleArrayList;
    }

    public void addCar(){
        boolean flag = true;
        while (flag) {
            System.out.println("请输入车辆信息，示例：\n\t小汽车 丰田 红色 4 2007 2厢\n\t卡车 雷诺 红色 3.5 2008\n结束新增，请输入end");
            String line = scanner.nextLine();
            if (line.equals("end")) flag = false;
            else {
                String[] s = line.split(" ");
                if(s[0].equals("小汽车")){
                    Car car = new Car(s[0], s[1], s[2], Integer.parseInt(s[3]), Integer.parseInt(s[4]), s[5]);
                    getCarArrayList().add(car);
                    System.out.println("创建成功\n");
                    car.printVehicle();
                } else if (s[0].equals("卡车")) {
                    Truck truck = new Truck(s[0], s[1], s[2], Double.parseDouble(s[3]), Integer.parseInt(s[4]));
                    getCarArrayList().add(truck);
                    System.out.println("创建成功\n");
                    truck.printVehicle();
                } else {
                    System.out.println("第一个应为小汽车或者卡车\n\n创建不成功！");
                }
            }
        }
    }

    public void searchCar(){
        boolean flag = true;
        while (flag) {
            System.out.println("请按照“类型 商标 颜色 出厂年份”的顺序输入条件，若条件为空用“null”代替，2个示例：\n\t小汽车 丰田 红色 2007\n\tnull 丰田 null null\n输入end返回上级菜单");
            String line = scanner.nextLine();
            if (line.equals("end")) flag = false;
            else {
                String[] s = line.split(" ");
                ArrayList<Vehicle> vehicles = new ArrayList<>();
                for(int i = 0; i < getCarArrayList().size(); i++){
                    if(s[0].equals(getCarArrayList().get(i).getType()) || s[0].equals("null")){
                        if(s[1].equals(getCarArrayList().get(i).getBrand()) || s[1].equals("null")){
                            if(s[2].equals(getCarArrayList().get(i).getColor()) || s[2].equals("null")){
                                if(s[3].equals("null") || Integer.parseInt(s[3]) == getCarArrayList().get(i).getYearOfManufacture()){
                                    vehicles.add(getCarArrayList().get(i));
                                }
                            }
                        }
                    }
                }
                if(vehicles.isEmpty()){
                    System.out.println("没有搜索到相应的交通工具");
                } else {
                    System.out.println("搜索到"+vehicles.size()+"辆车，信息如下：");
                    for (Vehicle vehicle : vehicles) {
                        vehicle.printVehicle();
                    }
                }
            }
        }
    }

    public void printCar(){
        System.out.println("目前有"+ vehicleArrayList.size()+"辆车信息如下：");
        for(int i = 0; i < getCarArrayList().size(); i++){
            System.out.print(i+1);
            getCarArrayList().get(i).printVehicle();
        }
    }
}

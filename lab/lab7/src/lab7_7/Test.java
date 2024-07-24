package lab7_7;

import java.util.Scanner;

public class Test {
    Employee hourlyEmployee = new Employee(new HourlyCompensationModel(300, 240));
    Employee salariedEmployee = new Employee(new SalariedCompensationModel(3000));
    Employee basePlusEmployee = new Employee(new BasePlusCommissionCompensationModel(400, 200, 4000));
    Employee commissionEmployee = new Employee(new CommissionCompensationModel(200, 400));


    public void showEarning(){
        double hourlyEmployeeEarning = hourlyEmployee.earnings();
        double salariedEmployeeEarning = salariedEmployee.earnings();
        double basePlusEmployeeEarning = basePlusEmployee.earnings();
        double commissionEmployeeEarning = commissionEmployee.earnings();
        System.out.println("HourlyCompensationModel: "+ hourlyEmployeeEarning + "\nSalariedCompensationModel: "+salariedEmployeeEarning
        + "\nBasePlusCommissionCompensationModel: "+basePlusEmployeeEarning + "\nCommissionCompensationModel: "+commissionEmployeeEarning);
    }

    private CompensationModel createCompensationModel(int type) {
        return switch (type) {
            case 1 -> new HourlyCompensationModel(300, 240);
            case 2 -> new SalariedCompensationModel(3000);
            case 3 -> new BasePlusCommissionCompensationModel(400, 200, 4000);
            case 4 -> new CommissionCompensationModel(200, 400);
            default -> throw new IllegalArgumentException("错误输入");
        };
    }

    public void changeCompensationModel(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入想要修改的员工的薪资模式（1/2/3/4）：");
        int n = scanner.nextInt();
        System.out.println("请输入想要修改成的员工的薪资模式（1/2/3/4）：");
        int m = scanner.nextInt();
        CompensationModel newModel = createCompensationModel(m);
        switch (n){
            case 1: hourlyEmployee.setCompensationModel(newModel); break;
            case 2: salariedEmployee.setCompensationModel(newModel); break;
            case 3: basePlusEmployee.setCompensationModel(newModel); break;
            case 4: commissionEmployee.setCompensationModel(newModel); break;
            default: System.out.println("错误输入");
        }
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.showEarning();
        test.changeCompensationModel();
        test.showEarning();
    }
}
package lab3_3;

import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Student student;

        System.out.println("请输入两个学生信息");
        for(int i = 0; i < 2; i++){
            Scanner scanner = new Scanner(System.in);

            System.out.print("请输入学生学号：");
            String Id = scanner.nextLine();

            System.out.print("请输入学生姓名：");
            String name = scanner.nextLine();

            System.out.print("请输入学生班级：");
            int Class = Integer.parseInt(scanner.nextLine());

            System.out.print("请输入学生电话（可选）：");
            String phoneNumber = scanner.nextLine();

            if(phoneNumber == null){
                student = new Student(Id, name, Class);
            } else {
                student = new Student(Id, name, Class, phoneNumber);
            }
            Course course_1 = new Course("1", "计算机组成原理");
            Course course_2 = new Course("2", "计算机网络");
            course_1.getScore(student.getName());
            course_2.getScore(student.getName());
        }
    }
}

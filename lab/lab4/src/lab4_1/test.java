package lab4_1;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Undergraduate undergraduate_1 = new Undergraduate("1","Alice",1);
        Undergraduate undergraduate_2 = new Undergraduate("2", "Jack", 2);

        GraduateStudent graduateStudent_1 = new GraduateStudent("1", "Mike", 1, "Tom");
        GraduateStudent graduateStudent_2 = new GraduateStudent("2", "Amy", 2, "Jenny");

        ArrayList<Undergraduate> undergraduateList = new ArrayList<>();
        undergraduateList.add(undergraduate_1);
        undergraduateList.add(undergraduate_2);
        ArrayList<GraduateStudent> graduateStudentList = new ArrayList<>();
        graduateStudentList.add(graduateStudent_1);
        graduateStudentList.add(graduateStudent_2);

        for (Undergraduate undergraduate : undergraduateList) {
            for (int j = 0; j < 2; ++j) {
                String line = "";
                boolean flag = false;
                int n = j + 1;
                while (!flag) {
                    System.out.println("本科生" + undergraduate.getName() + "第" + n + "次选课：");
                    line = scanner.nextLine();
                    if (Objects.equals(line, "q"))
                        break;
                    flag = undergraduate.CourseSelection(line);
                }
            }
        }
        for (GraduateStudent graduateStudent : graduateStudentList) {
            for (int j = 0; j < 2; j++) {
                String line = "";
                boolean flag = false;
                int n = j+1;
                while (!flag) {
                    System.out.println("研究生" + graduateStudent.getName() + "第" + n + "次选课：");
                    line = scanner.nextLine();
                    if (Objects.equals(line, "q"))
                        break;
                    flag = graduateStudent.CourseSelection(line);
                }
            }
        }
        undergraduate_1.printClassList();
        undergraduate_2.printClassList();
        graduateStudent_1.printClassList();
        graduateStudent_2.printClassList();
    }
}

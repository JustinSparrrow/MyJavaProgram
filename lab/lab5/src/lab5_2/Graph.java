package lab5_2;

import java.util.Scanner;

public class Graph {

    int calculateArea() {
        return 0;
    }

    boolean ifCorrect(){
        return false;
    }

    public void test(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; ++i){
            String s = scanner.nextLine();
            String[] str = s.split(" ");
//            System.out.println(str.length);
            if(str.length == 2){
                Rectangle rectangle = new Rectangle(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                if(rectangle.ifCorrect()) {
                    System.out.println(rectangle.calculateArea());
                } else {
                    System.out.println("错误输入，请重新输入！");
                    i--;
                }
            } else if (str.length == 3){
                Triangle triangle = new Triangle(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                if(triangle.ifCorrect()) {
                    System.out.println(triangle.calculateArea());
                } else {
                    System.out.println("错误输入，请重新输入！");
                    i--;
                }
            } else {
                System.out.println("Error!");
            }
        }
    }

    public static void main(String[] args) {
        new Graph().test();
    }
}

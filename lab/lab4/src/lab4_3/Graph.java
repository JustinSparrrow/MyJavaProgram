package lab4_3;

import java.util.Scanner;

public class Graph {

    private int height;
    private int width;
    private int a;
    private int b;
    private int c;

    public Graph(int height, int width){
        this.height = height;
        this.width = width;
    }

    public Graph(int a, int b, int c){
        this.a = a;
        this.b = b;
        this.c = c;
    }

    int calculateArea() {
        return 0;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        for(int i = 0; i < n; i++){
            String s = scanner.nextLine();
            String[] str = s.split(" ");
            System.out.println(str.length);
            if(str.length == 2){
                Rectangle rectangle = new Rectangle(Integer.parseInt(str[0]), Integer.parseInt(str[1]));
                System.out.println(rectangle.calculateArea());
            } else if (str.length == 3){
                Triangle triangle = new Triangle(Integer.parseInt(str[0]), Integer.parseInt(str[1]), Integer.parseInt(str[2]));
                System.out.println(triangle.calculateArea());
            } else {
                System.out.println("Error!");
            }
        }
    }
}

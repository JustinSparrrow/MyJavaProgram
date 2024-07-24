package lab5_2;

public class Triangle extends Graph{
    int a, b, c;

    public Triangle(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public boolean ifCorrect(){
        return (a + b > c) && (a + c > b) && (b + c > a) && a > 0 && b > 0 && c > 0;
    }

    public int calculateArea(){
        double p = (double) (a + b + c) / 2;
        return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

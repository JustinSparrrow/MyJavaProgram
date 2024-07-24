package lab4_3;

public class Triangle extends Graph{
    int a, b, c;

    public Triangle(int a, int b, int c) {
        super(a, b, c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int calculateArea(){
        double p = (double) (a + b + c) / 2;
        return (int) Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}

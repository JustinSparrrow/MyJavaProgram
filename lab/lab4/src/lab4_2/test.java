package lab4_2;

public class test {

    public static void main(String[] args) {
        Rational rational_1 = new Rational(10, 20);
        Rational rational_2 = new Rational(3, -4);

        System.out.println(rational_1);
        System.out.println(rational_2);

        System.out.println(rational_1.addition(rational_2));
        System.out.println(rational_1.subtraction(rational_2));
        System.out.println(rational_1.multiplication(rational_2));
        System.out.println(rational_1.division(rational_2));
    }
}

package lab4_2;

public class Rational extends Number implements Comparable{

    private int numerator;
    private int denominator;

    private int flag;

    // flag = 1，代表有理数是分数
    public Rational(int numerator, int denominator){
        if(denominator == 0){
            System.out.println("Error!");
            return;
        }
        this.numerator = numerator;
        this.denominator = denominator;
        simplify();
        flag = 1;
//        System.out.println(this.numerator+", "+this.denominator);
    }

    // flag = 2，代表有理数是整数
    public Rational(int numerator){
        this.numerator = numerator;
        this.denominator = 1;
        flag = 2;
    }

    // flag = 3，代表输入方式是字符串
    public Rational(String number){
        this.numerator = Integer.parseInt(number);
        flag = 3;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        }
        return numerator + "/" + denominator;
    }

    private void simplify() {
        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }
        int gcd = findGCD(Math.abs(numerator), Math.abs(denominator));
        numerator /= gcd;
        denominator /= gcd;
//        System.out.println(numerator+", "+denominator);
    }

    private int simplify(Rational rational){
        int gcd = findGCD(rational.numerator, rational.denominator);
        rational.numerator /= gcd;
        rational.denominator /= gcd;
        if(rational.denominator == 1){
            return 2;
        }
        return 1;
    }

    private int simplify(int numerator, int denominator){
        int gcd = findGCD(numerator, denominator);
        numerator /= gcd;
        denominator /= gcd;
        if(denominator == 1){
            return 2;
        }
        return 1;
    }

    private int findGCD(int a, int b){

        while (b != 0){
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public Rational addition(Rational rational){
        if(flag == 1){
            // 第一个数字是分数，第二个数字也是分数
            if(rational.flag == 1) {
                int temp = denominator;
                denominator *= rational.denominator;
                numerator *= rational.denominator;
                rational.denominator *= temp;
                rational.numerator *= temp;
                numerator += rational.numerator;
                if(simplify(this) == 2) {
                    return new Rational(numerator/denominator);
                }
                return new Rational(numerator, denominator);
            }
            // 第一个数字是分数，第二个数字不是分数
            else {
                rational.numerator *= denominator;
                numerator += rational.numerator;
                if(simplify(this) == 2){
                    return new Rational(numerator/denominator);
                }
                return new Rational(numerator, denominator);
            }
        } else {
            // 第一个数字不是分数，第二个数字是分数
            if(rational.flag == 1) {
                numerator *= rational.denominator;
                rational.numerator += numerator;
                if(simplify((rational)) == 2){
                    return new Rational(rational.numerator/rational.denominator);
                }
                return new Rational(rational.numerator, rational.denominator);
            }
            // 第一个数字不是分数，第二个数字也不是分数
            else {
                return new Rational(numerator+rational.numerator);
            }
        }
    }

    public Rational subtraction(Rational rational){
        rational.numerator = -rational.numerator;
        return this.addition(rational);
    }

    public Rational multiplication(Rational rational){
        if(flag == 1){
            if(rational.flag == 1){
                numerator *= rational.numerator;
                denominator *= rational.denominator;
//                System.out.println(numerator+" "+denominator);
            }
            else {
                rational.numerator *= denominator;
                numerator += rational.numerator;
            }
            if(simplify(numerator, denominator) == 2){
                return new Rational(numerator/denominator);
            }
            return new Rational(numerator, denominator);
        }
        else {
            if(rational.flag == 1){
                numerator *= rational.denominator;
                rational.numerator += numerator;
                if(simplify(rational.numerator, rational.denominator) == 2){
                    return new Rational(rational.numerator/rational.denominator);
                }
                return new Rational(rational.numerator, rational.denominator);
            }
            else {
                return new Rational(numerator *= rational.numerator);
            }
        }
    }

    public Rational division(Rational rational){
        if(rational.flag == 1){
            int temp = rational.denominator;
            rational.denominator = rational.numerator;
            rational.numerator = temp;
//            System.out.println(rational);
            return multiplication(rational);
        }
        else {
            if(rational.numerator == 0){
                System.out.println("Error");
                return null;
            }
            rational.denominator = rational.numerator;
            rational.numerator = 1;
            return multiplication(rational);
        }
    }

    public Rational getAbsoluteValue(){
        if(isNegative() && flag == 1){
            if(numerator < 0)
                return new Rational(-numerator, denominator);
            else
                return new Rational(numerator, -denominator);
        }
        else
            return this;
    }

    public boolean isNegative(){
        if(flag == 1){
            if(numerator < 0){
                return denominator >= 0;
            }
            else {
                return denominator < 0;
            }
        }
        else {
            return numerator < 0;
        }
    }

    public boolean equals(Rational rational){
        if(this.flag == 1){
            int x1 = simplify(rational);
            if(rational.flag == 1){
                int x2 = simplify(rational);
                return this.numerator == rational.numerator && this.denominator == rational.denominator;
            }
            else {
                return this.numerator == rational.numerator;
            }
        }
        else {
            if(rational.flag == 1){
                int x1 = simplify(rational);
            }
            return this.numerator == rational.numerator;
        }
    }


    @Override
    public int intValue() {
        if(flag == 1){
            numerator *= 10;
            int temp = numerator / denominator;
            if(temp%10 > 4){
                temp += 10;
            }
            return temp/10;
        }
        else return numerator;
    }

    @Override
    public long longValue() {
        return 0;
    }

    @Override
    public float floatValue() {
        return 0;
    }

    @Override
    public double doubleValue() {
        if(flag == 1){
            numerator *= 10;
            double temp = (double) numerator / denominator;
            if(temp%10 > 4){
                temp += 10;
            }
            return temp/10;
        }
        else return numerator;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    public Rational compareTo(Rational rational){
        if(this.isNegative()){
            if(rational.isNegative()){
                Rational temp = subtraction(rational);
                if(temp.isNegative())
                    return rational;
                else return this;
            }
            else {
                return rational;
            }
        }
        else {
            if(rational.isNegative())
                return this;
            else {
                Rational temp = subtraction(rational);
                if(temp.isNegative())
                    return rational;
                else
                    return this;
            }
        }
    }
}

package operation;


public class calculation {

    double addition(double n1,double n2){
        return n1 + n2;
    }
    double subtraction(double n1,double n2){
        return n1 - n2;
    }
    double multiplication(double n1,double n2){
        return n1*n2;
    }
    double division(double n1,double n2){
        if(n2 == 0)
            System.out.println("Error!");
        return n1/n2;
    }

}

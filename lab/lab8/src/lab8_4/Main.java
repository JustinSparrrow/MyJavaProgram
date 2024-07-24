package lab8_4;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    private Set<Integer> factor = new HashSet<>();

    private boolean isPrime(int n){
        for(int i = 2; i < Math.sqrt(n); i++){
            if(n % i == 0)
                return false;
        }
        return true;
    }

    private void factor(){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if(n == 0 || n ==1){
            System.out.println("错误输入！");
            return;
        }
        if(isPrime(n)){
            factor.add(1);
            factor.add(n);
        } else {
            for(int i = 2; n != 1; i++){
                if(n % i == 0){
                    factor.add(i);
                    n /= i;
                    i = 2;
                }
            }
        }
        System.out.println(factor);
    }

    public static void main(String[] args) {
        new Main().factor();
    }
}

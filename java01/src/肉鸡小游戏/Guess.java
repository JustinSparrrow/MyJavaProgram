package jiayu0309肉鸡小游戏;

import java.util.Random;
import java.util.Scanner;

public class Guess {
    Random random = new Random();

    private final int number = random.nextInt(100);

    public boolean isright(int n){
        return n == number;
    }
    public void print(){
        System.out.println(number);
    }

    public static void main(String[] arg){
        boolean Again = true;
        Guess guess = new Guess();
        int q = 1;
        int s = 100;
        while(Again) {
            int n;
            System.out.println("请猜测一个"+q+"～"+s+"之间的数字吧：");
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            boolean right = guess.isright(n);
            if (right) {
                System.out.println("恭喜你，猜对了！");
                Again = false;
                System.out.print("随机出来的数字是：");
                guess.print();
            } else {
                if(n>(guess.number+10)){
                    System.out.println("你猜的数字太大了，再试一次吧");
                }else if(n<(guess.number-10)){
                    System.out.println("你猜的数字太小了，再试一次吧");
                }
                else{
                    System.out.println("很接近了，再猜一次吧");
                }
            }
        }
    }
}

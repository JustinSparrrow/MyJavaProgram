package lab3_m;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Scanner;

public class CAI {
    public void cai(int num_1, int num_2){
        int correct = 0;
        int wrong = 0;
        for(int i = 0; i < 10; i++){
            int num = 10-i-1;
            System.out.println("How much is " + num_1 + " times " + num_2 + "?");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (answer == num_1 * num_2) {
                correct += 1;
                int n = new SecureRandom().nextInt(4);
                switch (n){
                    case 0 -> System.out.println("Very good!");
                    case 1 -> System.out.println("Excellent!");
                    case 2 -> System.out.println("Nice work!");
                    case 3 -> System.out.println("Keep up the good work!");
                }
                System.out.println("还有"+num+"题");
                num_1 = new SecureRandom().nextInt(10);
                num_2 = new SecureRandom().nextInt(10);
            } else {
                wrong += 1;
                System.out.println("No. Please try again.");
                int n = new SecureRandom().nextInt(4);
                switch (n){
                    case 0 -> System.out.println("No. Please try again.");
                    case 1 -> System.out.println("Wrong. Try once more.");
                    case 2 -> System.out.println("Don't give up!");
                    case 3 -> System.out.println("No. Keep trying.");
                }
                System.out.println("还有"+num+"题");
            }
        }
        double accuracy = (double) correct /10 * 100;
        if(accuracy < 75){
            System.out.println("Your accuracy is "+accuracy+"%. Please ask your teacher for extra help.");
        } else {
            System.out.println("Your accuracy is "+accuracy+"%. Congratulations, you are ready to go to the next level！");
        }
    }

    public static void main(String[] args) {
        int num_1 = new SecureRandom().nextInt(10);
        int num_2 = new SecureRandom().nextInt(10);
        CAI cai = new CAI();
        cai.cai(num_1, num_2);
    }
}

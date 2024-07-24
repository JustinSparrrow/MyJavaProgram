package lab3_4;

import java.security.SecureRandom;
import java.util.Scanner;

public class CAI {

    public void cai(){
        int num_1 = new SecureRandom().nextInt(10);
        int num_2 = new SecureRandom().nextInt(10);
        while (true) {
            System.out.println("How much is " + num_1 + " times " + num_2 + "?");
            Scanner scanner = new Scanner(System.in);
            int answer = scanner.nextInt();
            if (answer == num_1 * num_2) {
                System.out.println("Very Good!");
                return;
            } else {
                System.out.println("No. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        CAI cai = new CAI();
        cai.cai();
        cai.cai();
    }
}

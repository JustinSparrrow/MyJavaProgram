package lab8_2;

import java.util.HashMap;
import java.util.Scanner;

public class Main {

    private HashMap<String, Integer> repeat = new HashMap<>();
    public int RepeatingCharacter(){
        int num = 0;
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        scanner.close();
        line = line.replace(",", " ");
        line = line.replace(".", " ");
        line = line.toLowerCase();

        String[] s = line.split(" ");
        for (String string : s) {
            if (repeat.containsKey(string)) {
                int count = repeat.get(string);
                repeat.put(string, count + 1);
            } else {
                repeat.put(string, 1);
            }
        }
        for(String key: repeat.keySet()){
            if(repeat.get(key) != 1)
                num++;
        }
        return num;
    }

    public static void main(String[] args) {
        System.out.println(new Main().RepeatingCharacter());
    }
}

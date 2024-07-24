package lab8_1;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class nameSet {

    private Set<String> name = new HashSet<>();

    public nameSet(String[] name){
        for (String s : name) {
            this.name.add(s);
        }
    }

    public void readName(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("是否添加名字？（Y/N）");
        String n = scanner.nextLine();
        if(n.equals("Y") || n.equals("y")) {
            boolean flag = true;
            while (flag) {
                String line = scanner.nextLine();
                String[] s = line.split(" ");
                for (String string : s) {
                    name.add(string);
                }
                System.out.println("是否继续添加？");
                String m = scanner.nextLine();
                if(!m.equals("Y") && !m.equals("y")){
                    flag = false;
                    System.out.println("停止添加。");
                    printName();
                }
            }
        } else {
            printName();
        }
    }

    private void printName(){
//        System.out.println(name);
        for(String string: name){
            System.out.println(string);
        }
    }

    public static void main(String[] args) {
        String[] name = new String[3];
        name[0] = "Zhang";
        name[1] = "Li";
        name[2] = "Wang";
        nameSet nameSet = new nameSet(name);
        nameSet.readName();
    }
}

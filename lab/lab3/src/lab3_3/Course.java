package lab3_3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Course {
    public String class_ID;

    public String class_name;

    public Course(String class_ID, String class_name) {
        this.class_ID = class_ID;
        this.class_name = class_name;
    }

    public void getScore(String name){
        String fileName = "/Users/moqi/Desktop/作业/大二下/Java/lab/lab3/src/lab3_3/assets/"+class_ID+"_"+class_name+".txt";
//        System.out.println(fileName);

        try {
            boolean flag = false;
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null){
                String[] content = line.split(" ");

                if(content[0].equals(name)){
                    System.out.println(name+"的"+class_name+"成绩是"+content[3]);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println(name+"没有选"+class_name);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

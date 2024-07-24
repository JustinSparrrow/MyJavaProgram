package lab9_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class readWords {

    private String[][] s = new String[4][];

    private String[] changeType(String line, int flag){
        if(flag == 1) {
            StringBuilder newLine = new StringBuilder();
            for (int i = 0; i < line.length(); i++) {
                if ((line.charAt(i) >= 65 && line.charAt(i) <= 90) || (line.charAt(i) >= 97 && line.charAt(i) <= 122)  || (line.charAt(i) != '-')){
                    newLine.append(line.charAt(i));
                } else {
                    newLine.append(' ');
                }
            }
            return newLine.toString().split(" ");
        } else if (flag == 2){
            return line.split("\\.");
        }
        return null;
    }

    public void printTxt(String[][] s){
        for (String[] strings : s) System.out.println(Arrays.toString(strings));
    }

    public void printWords(){
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/Users/moqi/Desktop/作业/大二下/Java/lab/lab9/src/lab9_1/text.txt"));
            String line = reader.readLine();
            int n = 0;
            while (line != null){
                s[n] = changeType(line, 1);
                n++;
                line = reader.readLine();
            }
            Set<String> words = new HashSet<>();
            for(int i = 0; i < s.length; i++){
                for(int j = 0; j < s[i].length; j++){
                    words.add(s[i][j]);
                }
            }
            System.out.println(words);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void printThe() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader("/Users/moqi/Desktop/作业/大二下/Java/lab/lab9/src/lab9_1/text.txt"));
            String line = reader.readLine();
            int n = 0;
            while (line != null) {
                s[n] = changeType(line, 2);
                n++;
                line = reader.readLine();
            }
            for(int i = 0; i < s.length; i++){
                for (int j = 0; j < s[i].length; j++){
                    if(s[i][j].matches(".*\\bthe\\b.*") || s[i][j].matches(".*\\bThe\\b.*")){
                        System.out.println(i+" "+j+s[i][j]+".");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[][] getS() {
        return s;
    }

    public static void main(String[] args) {
        readWords words = new readWords();
        words.printWords();
        System.out.println("--------------------------");
        words.printTxt(words.getS());
        System.out.println("--------------------------");
        words.printThe();
        System.out.println("--------------------------");
        words.printTxt(words.getS());
    }
}

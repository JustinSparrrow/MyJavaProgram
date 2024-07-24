package org.example.lab10_3;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.*;

public class BoBingController {

    public Label resultLabel;
    public ImageView p1, p2, p3, p4, p5, p6;
    HashMap<String, Integer> price = new HashMap<>();
    ImageView[] imageViews = new ImageView[6];

    @FXML
    public void initialize(){
        imageViews[0] = p1;
        imageViews[1] = p2;
        imageViews[2] = p3;
        imageViews[3] = p4;
        imageViews[4] = p5;
        imageViews[5] = p6;
    }

    public BoBingController(){
        price.put("状元", 1);
        price.put("对堂", 2);
        price.put("三红", 4);
        price.put("四进", 8);
        price.put("二举", 16);
        price.put("一秀", 32);
    }

    public void getPrice(HashMap<String, Integer> price, String priceName){
        int value = price.get(priceName);
        if(value != 0){
            value--;
            resultLabel.setText("恭喜您获得"+priceName+"！"+priceName+"还剩"+value+"次");
        } else {
            resultLabel.setText(priceName+"已经被拿完哩");
        }
    }

    public void dice(){
        String playerName = "玩家";
        System.out.print(playerName+"进行游戏：");
        int[] dice = new int[6];
        int[] nums = new int[6];
        for(int i = 0; i < 6; i++){
            dice[i] = (int) (Math.random() * 6 + 1);
//            System.out.print(dice[i]+" ");
            switch (i){
                case 0 -> imageViews[0].setImage(imageViews[dice[i]-1].getImage());
                case 1 -> imageViews[1].setImage(imageViews[dice[i]-1].getImage());
                case 2 -> imageViews[2].setImage(imageViews[dice[i]-1].getImage());
                case 3 -> imageViews[3].setImage(imageViews[dice[i]-1].getImage());
                case 4 -> imageViews[4].setImage(imageViews[dice[i]-1].getImage());
                case 5 -> imageViews[5].setImage(imageViews[dice[i]-1].getImage());
            }
        }
        System.out.println();
        for(int i = 0; i < 6; i++){
            switch (dice[i]){
                case 1 -> nums[0]++;
                case 2 -> nums[1]++;
                case 3 -> nums[2]++;
                case 4 -> nums[3]++;
                case 5 -> nums[4]++;
                case 6 -> nums[5]++;
            }
        }
        if (nums[0] == 1 && nums[1] == 1 && nums[2] ==1 && nums[3] == 1 && nums[4] == 1 && nums[5] == 1){
            String priceName = "对堂";
            getPrice(price, priceName);
        } else if (nums[3] == 1){
            String priceName = "一秀";
            getPrice(price, priceName);
            p4.setImage(p1.getImage());
            if(nums[0] == 4 || nums[1] == 4 || nums[2] == 4 || nums[4] == 4 || nums[5] == 4){
                priceName = "四进";
                getPrice(price, priceName);
            } else if (nums[0] == 5 || nums[1] == 5 || nums[2] == 5 || nums[4] == 5 || nums[5] == 5){
                System.out.println("五子！");
                priceName = "状元";
                getPrice(price, priceName);
            }
        } else if (nums[3] == 2){
            String priceName = "二举";
            getPrice(price, priceName);
            getPrice(price, priceName);
            p4.setImage(p2.getImage());
            if(nums[0] == 4 || nums[1] == 4 || nums[2] == 4 || nums[4] == 4 || nums[5] == 4){
                priceName = "四进";
                getPrice(price, priceName);
            }
        } else if (nums[0] == 4 || nums[1] == 4 || nums[2] == 4 || nums[4] == 4 || nums[5] == 4){
            String priceName = "四进";
            getPrice(price, priceName);
        } else if (nums[3] == 3){
            String priceName = "三红";
            getPrice(price, priceName);
            p4.setImage(p3.getImage());
        } else if (nums[3] == 4 && nums[0] != 2){
            System.out.println("四红！");
            String priceName = "状元";
            getPrice(price, priceName);
        } else if (nums[0] == 5 || nums[1] == 5 || nums[2] == 5 || nums[4] == 5 || nums[5] == 5){
            System.out.println("五子！");
            String priceName = "状元";
            getPrice(price, priceName);
        } else if (nums[3] == 5) {
            System.out.println("五王！");
            String priceName = "状元";
            getPrice(price, priceName);
        } else if (nums[0] == 2 && nums[3] == 4) {
            System.out.println("状元插金花！");
            String priceName = "状元";
            getPrice(price, priceName);
        } else if (nums[3] == 6) {
            System.out.println("六勃红！");
            String priceName = "状元";
            getPrice(price, priceName);
        } else if (nums[1] == 6 || nums[2] == 6 || nums[4] == 6 || nums[5] == 6) {
            System.out.println("六勃黑！");
            String priceName = "状元";
            getPrice(price, priceName);
        } else if (nums[0] == 6) {
            System.out.println("遍地锦！");
            String priceName = "状元";
            getPrice(price, priceName);
        } else {
            resultLabel.setText("可惜，本次没有获奖。");
        }
    }

    public void waitForEnter(Scanner scanner) {
        System.out.println("按 Enter 键继续...");
        scanner.nextLine(); // 等待用户输入 Enter 键
    }

    @FXML
    public void bobingButton() {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("请输入游玩人数(6~10)：");
        int counts = 0;
//        int playerNumbers = 6;
//        int[] count = new int[playerNumbers];
//        int[][] players = new int[playerNumbers][7];
        BoBingController boBing = new BoBingController();
        boolean flag = true;
        while (flag){
//                boBing.waitForEnter(scanner);
            boBing.dice();

            boolean allZeros = true;
            for(Map.Entry<String, Integer> entry: boBing.price.entrySet()){
                if(entry.getValue() != 0){
                    allZeros = false;
                    break;
                }
            }
            if(allZeros){
                flag = false;
                break;
            }
        }
        resultLabel.setText("游戏结束，所有奖品都被拿完哩！\n总共投掷"+counts+"次。");
//        for(int i = 0; i < playerNumbers; i++){
//            counts += count[i];
//        }
//        for(int i = 0; i < playerNumbers; i++){
//            System.out.println("玩家"+i+"共投掷"+count[i]+"次，"+"获得奖项：");
//            System.out.print("状元："+players[i][1]+"次"+"\t");
//            System.out.print("对堂："+players[i][2]+"次"+"\t");
//            System.out.print("三红："+players[i][3]+"次"+"\t");
//            System.out.print("四进："+players[i][4]+"次"+"\t");
//            System.out.print("二举："+players[i][5]+"次"+"\t");
//            System.out.println("一秀："+players[i][6]+"次");
//        }
//        System.out.println("总共投掷"+counts+"次。");
    }
}
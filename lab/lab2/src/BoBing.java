import java.util.*;

public class BoBing {

    HashMap<String, Integer> price = new HashMap<>();

    public BoBing(){
        price.put("状元", 1);
        price.put("对堂", 2);
        price.put("三红", 4);
        price.put("四进", 8);
        price.put("二举", 16);
        price.put("一秀", 32);
    }

    public void getPrice(HashMap<String, Integer> price, String priceName, String playerName, int[] players){
        int value = price.get(priceName);
        if(value != 0){
            value--;
            System.out.println("恭喜"+playerName+"获得"+priceName+"！"+priceName+"还剩"+value+"次");
            price.put(priceName, value);
            switch (priceName){
                case "状元" -> players[1]++;
                case "对堂" -> players[2]++;
                case "三红" -> players[3]++;
                case "四进" -> players[4]++;
                case "二举" -> players[5]++;
                case "一秀" -> players[6]++;
            }
        } else {
            System.out.println(priceName+"已经被拿完哩");
        }
    }

    public void dice(int player, int[] players){
        String playerName = "玩家"+player;
        System.out.print(playerName+"进行游戏：");
        int[] dice = new int[6];
        int[] nums = new int[6];
        for(int i = 0; i < 6; i++){
            dice[i] = (int) (Math.random() * 6 + 1);
            System.out.print(dice[i]+" ");
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
            getPrice(price, priceName, playerName, players);
        } else if (nums[3] == 1){
            String priceName = "一秀";
            getPrice(price, priceName, playerName, players);
            if(nums[0] == 4 || nums[1] == 4 || nums[2] == 4 || nums[4] == 4 || nums[5] == 4){
                priceName = "四进";
                getPrice(price, priceName, playerName, players);
            } else if (nums[0] == 5 || nums[1] == 5 || nums[2] == 5 || nums[4] == 5 || nums[5] == 5){
                System.out.println("五子！");
                priceName = "状元";
                getPrice(price, priceName, playerName, players);
            }
        } else if (nums[3] == 2){
            String priceName = "二举";
            getPrice(price, priceName, playerName, players);
            if(nums[0] == 4 || nums[1] == 4 || nums[2] == 4 || nums[4] == 4 || nums[5] == 4){
                priceName = "四进";
                getPrice(price, priceName, playerName, players);
            }
        } else if (nums[0] == 4 || nums[1] == 4 || nums[2] == 4 || nums[4] == 4 || nums[5] == 4){
            String priceName = "四进";
            getPrice(price, priceName, playerName, players);
        } else if (nums[3] == 3){
            String priceName = "三红";
            getPrice(price, priceName, playerName, players);
        } else if (nums[3] == 4 && nums[0] != 2){
            System.out.println("四红！");
            String priceName = "状元";
            getPrice(price, priceName, playerName, players);
        } else if (nums[0] == 5 || nums[1] == 5 || nums[2] == 5 || nums[4] == 5 || nums[5] == 5){
            System.out.println("五子！");
            String priceName = "状元";
            getPrice(price, priceName, playerName, players);
        } else if (nums[3] == 5) {
            System.out.println("五王！");
            String priceName = "状元";
            getPrice(price, priceName, playerName, players);
        } else if (nums[0] == 2 && nums[3] == 4) {
            System.out.println("状元插金花！");
            String priceName = "状元";
            getPrice(price, priceName, playerName, players);
        } else if (nums[3] == 6) {
            System.out.println("六勃红！");
            String priceName = "状元";
            getPrice(price, priceName, playerName, players);
        } else if (nums[1] == 6 || nums[2] == 6 || nums[4] == 6 || nums[5] == 6) {
            System.out.println("六勃黑！");
            String priceName = "状元";
            getPrice(price, priceName, playerName, players);
        } else if (nums[0] == 6) {
            System.out.println("遍地锦！");
            String priceName = "状元";
            getPrice(price, priceName, playerName, players);
        }
    }

    public void waitForEnter(Scanner scanner) {
        System.out.println("按 Enter 键继续...");
        scanner.nextLine(); // 等待用户输入 Enter 键
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("请输入游玩人数(6~10)：");
        int counts = 0;
        int playerNumbers = scanner.nextInt();
        int[] count = new int[playerNumbers];
        int[][] players = new int[playerNumbers][7];
        BoBing boBing = new BoBing();
        boolean flag = true;
        while (flag){
            for(int i = 0; i < playerNumbers; i++){
//                boBing.waitForEnter(scanner);
                boBing.dice(i, players[i]);
                count[i]++;

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
        }
        System.out.println("游戏结束，所有奖品都被拿完哩！");
        for(int i = 0; i < playerNumbers; i++){
            counts += count[i];
        }
        for(int i = 0; i < playerNumbers; i++){
            System.out.println("玩家"+i+"共投掷"+count[i]+"次，"+"获得奖项：");
            System.out.print("状元："+players[i][1]+"次"+"\t");
            System.out.print("对堂："+players[i][2]+"次"+"\t");
            System.out.print("三红："+players[i][3]+"次"+"\t");
            System.out.print("四进："+players[i][4]+"次"+"\t");
            System.out.print("二举："+players[i][5]+"次"+"\t");
            System.out.println("一秀："+players[i][6]+"次");
        }
        System.out.println("总共投掷"+counts+"次。");
    }
}
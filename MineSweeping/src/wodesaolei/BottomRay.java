package wodesaolei;
/*
* 初始化地雷*/
public class BottomRay {
    //存放坐标
    static  int[] rays = new int[GameUtil.RAY_MAX * 2];
    //地雷坐标  随即摆放地雷
    int x, y;
    //是否放置
    //true表示可以放置 false表示不可以放置
    boolean isPlace = true;

    void newRay(){
        for (int i = 0; i < GameUtil.RAY_MAX * 2; i += 2){
            x = (int) (Math.random()*GameUtil.MAP_W + 1); //1-12
            y = (int) (Math.random()*GameUtil.MAP_H + 1); //1-12 防止数组越界

            rays[i] = x;
            rays[i+1] = y;

            //解决地雷重合问题
            for (int j = 0; j < i; j += 2)
            {
                if (x == rays[j] && y ==rays[j+1]) {
                    i -= 2; //回退坐标，因为这里有了，需要再次random一次
                    isPlace = false;
                    break;
                }
            }
            //将坐标放入数组
            if(isPlace){
                rays[i] = x;
                rays[i+1] = y;
            }
            isPlace = true;
        }

        for (int i = 0; i < GameUtil.RAY_MAX * 2; i +=2){
            GameUtil.DATA_BOTTOM[rays[i]][rays[i+1]] = -1;
        }
    }
}

package wodesaolei;

/*底层地图
绘制游戏相关组件
*/
import java.awt.*;

public class MapBottom {
    BottomRay bottomRay = new BottomRay();
    BottomNumber bottomNumber = new BottomNumber();
    {
        bottomRay.newRay();
        bottomNumber.newNum();
    }

    void reGame(){
        for(int i = 1; i <= GameUtil.MAP_W; i++){
            for(int j = 1 ; j <= GameUtil.MAP_H; j++){
                GameUtil.DATA_BOTTOM[i][j] = 0;

            }
        }
        bottomRay.newRay();
        bottomNumber.newNum();
    }

    void paintSelf(Graphics g){

        g.setColor(Color.black);


        //画竖线
        for (int i = 0; i <= GameUtil.MAP_W; i++){
            g.drawLine(GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET,
                    GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET + GameUtil.MAP_H * GameUtil.SQUARE_LENGTH);
        }
        //画横线
        for (int i = 0; i <= GameUtil.MAP_H; i++){
            g.drawLine(GameUtil.OFFSET,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH,
                    GameUtil.OFFSET + GameUtil.MAP_W * GameUtil.SQUARE_LENGTH,
                    3 * GameUtil.OFFSET + i * GameUtil.SQUARE_LENGTH);
        }

        //雷
        for (int i = 1; i <= GameUtil.MAP_W; i++)
            for (int j = 1; j <= GameUtil.MAP_H ; j++)
            {
                if(GameUtil.DATA_BOTTOM[i][j] == -1) {
                    g.drawImage(GameUtil.lei,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                //数字
                if(GameUtil.DATA_BOTTOM[i][j] >= 0) {
                    g.drawImage(GameUtil.images[GameUtil.DATA_BOTTOM[i][j]],
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
            }
        }

        GameUtil.drawWord(g,""+(GameUtil.RAY_MAX - GameUtil.FLAG_NUM),
                GameUtil.OFFSET,
                2*GameUtil.OFFSET,
                30,Color.black);
        GameUtil.drawWord(g,""+(GameUtil.END_TIME - GameUtil.START_TIME)/1000,
                GameUtil.OFFSET + GameUtil.SQUARE_LENGTH*GameUtil.MAP_W - 1,
                2*GameUtil.OFFSET,
                30,Color.black);

        switch (GameUtil.state){
            case 0:
                GameUtil.END_TIME = System.currentTimeMillis();
                g.drawImage(GameUtil.face,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        GameUtil.SQUARE_LENGTH - 2,
                        GameUtil.SQUARE_LENGTH - 2,
                        null);
                break;
            case 1:
                g.drawImage(GameUtil.win,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        GameUtil.SQUARE_LENGTH - 1,
                        GameUtil.SQUARE_LENGTH - 1,
                        null);
                break;
            case 2:
                g.drawImage(GameUtil.lose,
                        GameUtil.OFFSET+GameUtil.SQUARE_LENGTH*(GameUtil.MAP_W/2),
                        GameUtil.OFFSET,
                        GameUtil.SQUARE_LENGTH - 2,
                        GameUtil.SQUARE_LENGTH - 2,
                        null);
                break;

            default:
        }
    }
}

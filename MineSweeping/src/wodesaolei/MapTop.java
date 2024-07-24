package wodesaolei;

import java.awt.*;

public class MapTop {

    int temp_x;
    int temp_y;

    void reGame(){
        for(int i = 1; i <= GameUtil.MAP_W; i++){
            for(int j = 1 ; j <= GameUtil.MAP_H; j++){
                GameUtil.DATA_TOP[i][j] = 0;
            }
        }
    }

    void logic(){

        temp_x = 0;
        temp_y = 0;
        if(GameUtil.MOUSE_X > GameUtil.OFFSET && GameUtil.MOUSE_Y > 3*GameUtil.OFFSET) {
            temp_x = (GameUtil.MOUSE_X - GameUtil.OFFSET) / GameUtil.SQUARE_LENGTH + 1;
            temp_y = (GameUtil.MOUSE_Y - GameUtil.OFFSET * 3) / GameUtil.SQUARE_LENGTH + 1;
        }
        if (temp_x >= 1 && temp_x <= GameUtil.MAP_W && temp_y >= 1 && temp_y <= GameUtil.MAP_H) {

            if (GameUtil.LEFT) {
                if(GameUtil.DATA_TOP[temp_x][temp_y] == 0){
                    GameUtil.DATA_TOP[temp_x][temp_y] = -1;
                }
                SpaceOpen(temp_x, temp_y);
                GameUtil.LEFT = false;
            }
            if (GameUtil.RIGHT) {
                if(GameUtil.DATA_TOP[temp_x][temp_y] == 0){
                    GameUtil.DATA_TOP[temp_x][temp_y] = 1;
                    GameUtil.FLAG_NUM ++;
                }
                else if(GameUtil.DATA_TOP[temp_x][temp_y] == 1){
                    GameUtil.DATA_TOP[temp_x][temp_y] = 0;
                    GameUtil.FLAG_NUM --;
                }
                else if(GameUtil.DATA_TOP[temp_x][temp_y] == -1){
                    numOpen(temp_x,temp_y);
                }
                GameUtil.RIGHT = false;
            }
        }
        boom();
        victory();
    }

    void numOpen(int x,int y){
        int count = 0;
        if (GameUtil.DATA_BOTTOM[x][y] > 0){
            for(int i = x-1; i <= x+1; i++){
                for(int j = y-1; j <= y+1; j++){
                    if(GameUtil.DATA_TOP[i][j] == 1)
                        count ++;
                }
            }
        }
        if(count == GameUtil.DATA_BOTTOM[x][y]){
            for(int i = x-1; i <= x+1; i++){
                for(int j = y-1; j <= y+1; j++){
                    if(GameUtil.DATA_TOP[i][j] != 1){
                        GameUtil.DATA_TOP[i][j] = -1;
                    }
                    if(i >= 1&&j>=1&&i<=GameUtil.MAP_W&&y<=GameUtil.MAP_H){
                        SpaceOpen(i,j);
                    }
                }
            }
        }
    }

    boolean boom(){
        if(GameUtil.FLAG_NUM == GameUtil.RAY_MAX){
            if(GameUtil.FLAG_NUM == GameUtil.RAY_MAX){
                for(int i = 1; i <= GameUtil.MAP_W; i++){
                    for(int j = 1; j <= GameUtil.MAP_H; j++){
                        if(GameUtil.DATA_TOP[i][j] == 0){
                            GameUtil.DATA_TOP[i][j] = -1;
                        }
                    }
                }
            }
        }
        for(int i = 1; i<=GameUtil.MAP_W; i++){
            for(int j = 1; j <= GameUtil.MAP_H; j++){
                if(GameUtil.DATA_TOP[i][j] == -1 && GameUtil.DATA_BOTTOM[i][j] == -1){
                    GameUtil.state = 2;
                    seeBoom();
                    return true;
                }
            }
        }
        return false;
    }

    void seeBoom(){
        for(int i = 1; i <= GameUtil.MAP_W; i++){
            for(int j = 1; j <=GameUtil.MAP_H; j++){
                if(GameUtil.DATA_BOTTOM[i][j] == -1 && GameUtil.DATA_TOP[i][j] != 1){
                    GameUtil.DATA_TOP[i][j] = -1;
                }
                if(GameUtil.DATA_BOTTOM[i][j] != -1 && GameUtil.DATA_TOP[i][j] == 1){
                    GameUtil.DATA_TOP[i][j] = 2;
                }
            }
        }
    }

    boolean victory(){
        int count = 0;
        for(int i = 1; i <= GameUtil.MAP_W; i++){
            for(int j = 1; j <= GameUtil.MAP_H; j++){
                if(GameUtil.DATA_TOP[i][j] != -1){
                    count ++;
                }
            }
        }
        if(count == GameUtil.RAY_MAX){
            GameUtil.state = 1;
            for(int i = 1; i <= GameUtil.MAP_W; i++){
                for(int j = 1; j <=GameUtil.MAP_H; j++){
                    if(GameUtil.DATA_TOP[i][j] == 0){
                        GameUtil.DATA_TOP[i][j] = 1;
                    }
                }
            }
            return true;
        }
        return false;
    }

    void SpaceOpen(int x,int y){
        if(GameUtil.DATA_BOTTOM[x][y] == 0){
            for (int i = x-1; i <= x+1; i++){
                for(int j = y-1; j <= y+1; j++){
                    if(GameUtil.DATA_TOP[i][j] != -1) {
                        if(GameUtil.DATA_TOP[i][j] == 1){
                            GameUtil.FLAG_NUM --;
                        }
                        GameUtil.DATA_TOP[i][j] = -1;
                        //控制其必须在雷区当中才会递归
                        if(i>=1&&j>=1&&i<=GameUtil.MAP_W&&y<=GameUtil.MAP_H){
                            SpaceOpen(i,j);
                        }
                    }
                }
            }
        }
    }

    void paintSelf(Graphics g) {

        logic();

        for (int i = 1; i <= GameUtil.MAP_W; i++)
            for (int j = 1; j <= GameUtil.MAP_H; j++) {
                if (GameUtil.DATA_TOP[i][j] >= 0) {
                    g.drawImage(GameUtil.top,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                if (GameUtil.DATA_TOP[i][j] == 1) {
                    g.drawImage(GameUtil.flag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                if (GameUtil.DATA_TOP[i][j] == 2) {
                    g.drawImage(GameUtil.noflag,
                            GameUtil.OFFSET + (i - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.OFFSET * 3 + (j - 1) * GameUtil.SQUARE_LENGTH + 1,
                            GameUtil.SQUARE_LENGTH - 2,
                            GameUtil.SQUARE_LENGTH - 2,
                            null);
                }
                }

            }

    }


import javax.swing.*;
import java.awt.*;

public class MoveObject {

    private int x, y, size = 80;
    private int speedX = 0, speedY = 0;

    public MoveObject(){

    }

    public MoveObject(int x, int y){
        this.x = x;
        this.y = y;
    }

    // 移动
    public void move(){
        y += speedY;
        x += speedX;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getSpeedX() {
        return speedX;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
    }
}

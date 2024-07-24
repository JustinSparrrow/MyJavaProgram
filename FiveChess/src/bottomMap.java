import javax.swing.*;
import java.awt.*;

public class bottomMap extends JPanel {
    public int[][] ChessArr; //将ChessArr数组对象传递过来

    //重写组建的paint方法
    public void paint(Graphics g){
        //1。绘制组建本身，即保留画笔原先功能
        super.paint(g);

        //2.绘制棋盘
        for(int ix = 0; ix < GameUntil.LINE; ix++){
            g.drawLine(GameUntil.X0, GameUntil.Y0+GameUntil.SIZE*ix, GameUntil.X0+(GameUntil.LINE -1)*GameUntil.SIZE, GameUntil.Y0+ GameUntil.SIZE *ix);
            g.drawLine(GameUntil.X0+GameUntil.SIZE*ix, GameUntil.Y0,GameUntil.X0+GameUntil.SIZE*ix, GameUntil.Y0+(GameUntil.LINE-1)*GameUntil.SIZE);
        }

        //3.棋子重绘
        for(int jx = 0; jx < ChessArr.length; jx++){
            for(int ix = 0; ix < ChessArr[0].length; ix++){
                int chess = ChessArr[ix][jx];
                if(chess == 1){
                    g.setColor(Color.black);
                    g.fillOval(ix*GameUntil.SIZE+GameUntil.X0-GameUntil.Chess/2,jx*GameUntil.SIZE+GameUntil.Y0-GameUntil.Chess/2, GameUntil.Chess, GameUntil.Chess);
                }
                else if(chess == 2){
                    g.setColor(Color.white);
                    g.fillOval(ix*GameUntil.SIZE+GameUntil.X0-GameUntil.Chess/2,jx*GameUntil.SIZE+GameUntil.Y0-GameUntil.Chess/2, GameUntil.Chess, GameUntil.Chess);
                }
            }
        }
    }
}

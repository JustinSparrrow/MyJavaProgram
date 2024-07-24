import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class newGameMouse extends MouseAdapter implements ActionListener {

    public Graphics gr = null; //创建画笔对象
    public int chessCount = 0; //棋盘上棋子的数目
    public int setX, setY; //保存棋子的交点值
    public int[][] ChessArr = new int[GameUntil.LINE][GameUntil.LINE]; //定义二维数组保存棋子数据
    public int[] chessX = new int[GameUntil.LINE * GameUntil.LINE]; //保存棋子横坐标
    public int[] chessY = new int[GameUntil.LINE * GameUntil.LINE]; //保存棋子纵坐标
    boolean startGame = false; //游戏状态
    String button;
    bottomMap map;

    AI computerGame = new AI();

    public newGameMouse() {
        computerGame.ChessArr = ChessArr;
    }

    public void GameStart() {
        startGame = true;
        //清空数组
        for (int jx = 0; jx < ChessArr.length; jx++) {
            for (int ix = 0; ix < ChessArr[0].length; ix++) {
                ChessArr[ix][jx] = 0;
            }
        }
        map.repaint();
        chessCount = 0;
    }

    public void ComUser() {
        GameStart();
        for (int ix = 0; ix < GameUntil.LINE; ix++) {
            for (int jx = 0; jx < GameUntil.LINE; jx++) {
                computerGame.chessValue[ix][jx] = 0;
            }
        }
    }

    public void withDraw() {
        for (int jx = 0; jx < ChessArr.length; jx++) {
            for (int ix = 0; ix < ChessArr[0].length; ix++) {
                ChessArr[ix][jx] = 0;
            }
        }
        map.paint(gr);
        for (int ix = 1; ix <= (chessCount - 1); ix++) {
            int x = chessX[ix];
            int y = chessY[ix];

            if (ix % 2 != 0) {
                gr.setColor(Color.black);
                ChessArr[x][y] = 1;
                gr.fillOval(x * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, y * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
            } else if (ix % 2 == 0) {
                gr.setColor(Color.white);
                ChessArr[x][y] = 2;
                gr.fillOval(x * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, y * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
            }
        }
        chessCount--;
    }

    public void Replay() {
        for (int jx = 1; jx < ChessArr.length; jx++) {
            for (int ix = 1; ix < ChessArr[0].length; ix++) {
                ChessArr[ix][jx] = 0;
            }
        }
        map.paint(gr); //

        //按顺序取出棋子

        for (int ix = 1; ix <= chessCount; ix++) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

//                    System.out.println("chessCount = "+chessCount+" ix = "+ix);

            int x = chessX[ix];
            int y = chessY[ix];

            if (ix % 2 != 0) {
                gr.setColor(Color.black);
                ChessArr[x][y] = 1;
                gr.fillOval(x * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, y * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
            } else if (ix % 2 == 0) {
                gr.setColor(Color.white);
                ChessArr[x][y] = 2;
                gr.fillOval(x * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, y * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
            }
        }
    }

    public void actionPerformed(ActionEvent e) {
        button = e.getActionCommand();
        switch (button) {
            case "人机对战" -> ComUser();
            case "双人对战" -> GameStart();
            case "悔棋" -> withDraw();
            case "复盘" -> Replay();
        }
    }

    //画棋子
    public void paintChess(int setX, int setY) {
        if (chessCount % 2 == 0 && ChessArr[setX][setY] == 0) {
            gr.setColor(Color.black);
            ChessArr[setX][setY] = 1;
            gr.fillOval(setX * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, setY * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
            chessCount++;
        } else if (chessCount % 2 != 0 && ChessArr[setX][setY] == 0) {
            gr.setColor(Color.white);
            ChessArr[setX][setY] = 2;
            gr.fillOval(setX * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, setY * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
            chessCount++;
        }
    }

    //判断输赢的函数

    /**
     * 判断水平方向棋子相连的情况
     *
     * @param x 当前棋子的交点值
     * @param y 当前棋子的交点值
     * @return 返回棋子和连个数
     * 其他情况相同
     */
    public int isXwin(int x, int y) {
        int count = 1; //棋子计数器
        //向左
        for (int ix = x - 1; ix >= 0; ix--) {
            if (ChessArr[x][y] == ChessArr[ix][y]) {
                count++;
            } else break;
        }
        //向右
        for (int ix = x + 1; ix < ChessArr.length; ix++) {
            if (ChessArr[x][y] == ChessArr[ix][y]) {
                count++;
            } else break;
        }
        return count;
    }

    //判断竖直方向
    public int isYwin(int x, int y) {
        int count = 1;
        //向上
        for (int ix = y - 1; ix >= 0; ix--) {
            if (ChessArr[x][y] == ChessArr[x][ix]) {
                count++;
            } else break;
        }
        //向下
        for (int ix = y + 1; ix < ChessArr[0].length; ix++) {
            if (ChessArr[x][y] == ChessArr[x][ix]) {
                count++;
            } else break;
        }

        return count;
    }

    //判断斜向左上方向
    public int isXYwin(int x, int y) {
        int count = 1;
        //左上
        for (int ix = x - 1, jx = y - 1; ix >= 0 && jx >= 0; jx--, ix--) {
            if (ChessArr[x][y] == ChessArr[ix][jx]) {
                count++;
            } else break;
        }
        //右下
        for (int ix = x + 1, jx = y + 1; ix < ChessArr.length && jx < ChessArr[0].length; ix++, jx++) {
            if (ChessArr[x][y] == ChessArr[ix][jx]) {
                count++;
            } else break;
        }

        return count;
    }

    //判断右上方向
    public int isYXwin(int x, int y) {
        int count = 1;
        for (int ix = x - 1, jx = y + 1; ix >= 0 && jx < ChessArr[0].length; ix--, jx++) {
            if (ChessArr[x][y] == ChessArr[ix][jx]) {
                count++;
            } else break;
        }
        for (int ix = x + 1, jx = y - 1; ix < ChessArr.length && jx >= 0; ix++, jx--) {
            if (ChessArr[x][y] == ChessArr[ix][jx]) {
                count++;
            } else break;
        }

        return count;
    }

    public void gameWin(int Line, int Row, int leftUpDiagonal, int rightUpDiagonal, int x, int y) {
        if (Line == 5 || Row == 5 || leftUpDiagonal == 5 || rightUpDiagonal == 5) {
            String winner = "";
            if (ChessArr[x][y] == 1) {
                System.out.println("Black is the winner!");
                winner = "Black is the winner!";
            } else if (ChessArr[x][y] == 2) {
                System.out.println("White is the winner!");
                winner = "White is the winner!";
            }
            startGame = false;

            System.out.println("chessCount = " + chessCount);

            gr.setFont(new Font("楷体", Font.PLAIN, 60));
            gr.setColor(Color.red);
            gr.drawString(winner, 180, 400);

            JFrame iswinner = new JFrame("Game over!");
            iswinner.setSize(300, 200);
            iswinner.setLocationRelativeTo(null);
            iswinner.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            iswinner.setVisible(true);

            JLabel content = new JLabel(winner, JLabel.CENTER);
            iswinner.add(content);
        }
    }

    public void mouseClicked(MouseEvent e) {

        //控制游戏开始
        if (!startGame) {
            return;
        }

        int x = e.getX(); //获取鼠标点击位置的横坐标
        int y = e.getY(); //获取鼠标点击位置的纵坐标

        //规定落子
        //计算交点值
        if ((x - GameUntil.X0) % GameUntil.SIZE > GameUntil.SIZE / 2) {
            setX = (x - GameUntil.X0) / GameUntil.SIZE + 1;
        } else {
            setX = (x - GameUntil.X0) / GameUntil.SIZE;
        }

        if ((y - GameUntil.Y0) % GameUntil.SIZE > GameUntil.SIZE / 2) {
            setY = (y - GameUntil.Y0) / GameUntil.SIZE + 1;
        } else {
            setY = (y - GameUntil.Y0) / GameUntil.SIZE;
        }

        if (("人机对战").equals(button)) {
            //玩家画棋子

            if (ChessArr[setX][setY] == 0) {
                gr.setColor(Color.black);
                ChessArr[setX][setY] = 1;
                gr.fillOval(setX * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, setY * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
                chessCount++;

                chessX[chessCount] = setX;
                chessY[chessCount] = setY;

                int Line = isXwin(setX, setY); //横行相同的个数
                int Row = isYwin(setX, setY); //竖列相同的个数
                int leftUpDiagonal = isXYwin(setX, setY); //斜向左上方相同的个数
                int rightUpDiagonal = isYXwin(setX, setY); //斜向右上方相同的个数

                gameWin(Line, Row, leftUpDiagonal, rightUpDiagonal, setX, setY);
                if (startGame == false) {
                    return;
                }

                //ai下棋
                try {
                    Thread.sleep(300);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }

                computerGame.ai(); //调用ai方法
                int[] m = computerGame.max(); //选取最大值
                //System.out.println("x = " + m[0] + " y = " + m[1]);
                ChessArr[m[0]][m[1]] = 2;
                gr.setColor(Color.white);
                gr.fillOval(m[0] * GameUntil.SIZE + GameUntil.X0 - GameUntil.Chess / 2, m[1] * GameUntil.SIZE + GameUntil.Y0 - GameUntil.Chess / 2, GameUntil.Chess, GameUntil.Chess);
                chessCount++;

                chessX[chessCount] = m[0];
                chessY[chessCount] = m[1];

                int LineW = isXwin(m[0], m[1]); //横行相同的个数
                int RowW = isYwin(m[0], m[1]); //竖列相同的个数
                int leftUpDiagonalW = isXYwin(m[0], m[1]); //斜向左上方相同的个数
                int rightUpDiagonalW = isYXwin(m[0], m[1]); //斜向右上方相同的个数

                gameWin(LineW, RowW, leftUpDiagonalW, rightUpDiagonalW, m[0], m[1]);
            }

        } else {
            //双人下棋
            paintChess(setX, setY); //调用画棋子方法


            //按顺序保存棋子，方便复盘
            chessX[chessCount] = setX;
            chessY[chessCount] = setY;

            int Line = isXwin(setX, setY); //横行相同的个数
            int Row = isYwin(setX, setY); //竖列相同的个数
            int leftUpDiagonal = isXYwin(setX, setY); //斜向左上方相同的个数
            int rightUpDiagonal = isYXwin(setX, setY); //斜向右上方相同的个数

            gameWin(Line, Row, leftUpDiagonal, rightUpDiagonal, setX, setY);
        }
    }
}
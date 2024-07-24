import java.util.HashMap;

public class AI {
    //权值算法
    //1.定义哈希表保存棋局对应的权值: HashMap<K(棋局),V(权值)>
    HashMap<String,Integer> hm = new HashMap<>();

    public int[][] chessValue = new int[GameUntil.LINE][GameUntil.LINE]; //保存权值

    public int[][] ChessArr;

    //定义哈希表里的值
    public AI(){
        hm.put("1",2);
        hm.put("11",20);
        hm.put("111",200);
        hm.put("1111",2000);

        hm.put("12",1);
        hm.put("112",10);
        hm.put("1112",100);
        hm.put("11112",1000);

        hm.put("22",30);
        hm.put("222",3000);
        hm.put("2222",300000);
    }

    //判断输赢的程序

    //搜索棋盘的棋局情况，根据找到棋盘在棋子周围的空位值设置权值
    public void ai(){
        Integer[] value = new Integer[8];
        for(int ix = 0; ix < 8; ix++){
            value[ix] = 0;
        }
        for(int ix = 0; ix < GameUntil.LINE; ix++){
            for(int jx = 0; jx < GameUntil.LINE; jx++){
                //判断当前位置是否为空(只有空位需要设置权值)
                if(ChessArr[ix][jx] == 0){
                    //搜索该空位八个方向上的棋局相连情况
                    //定义变量保存棋局和棋子颜色
                    String code = "";
                    int color = 0;
                    //向右
                    for(int kx = jx+1; kx < GameUntil.LINE; kx++){
                        if(ChessArr[ix][kx] == 0){
                            break;
                        } //空位边上也是空的
                        else{
                            //记录棋子颜色
                            if (color == 0){
                                color = ChessArr[ix][kx]; //记录第一个棋子颜色
                                code += ChessArr[ix][kx];  //记录棋局
                            }else if (color == ChessArr[ix][kx]){
                                code += ChessArr[ix][kx];
                            }else {
                                code += ChessArr[ix][kx];
                                break;
                            }
                        }
                    }
                    value[0] = hm.get(code);

                    if(value[0] != null){
                        chessValue[ix][jx] += value[0];
                    }
                    System.out.println("code:" + code);
                    System.out.println("右边的权值:"+value[0]);
                    code = "";
                    color = 0;

                    //向左
                    for(int kx = jx-1; kx >= 0; kx--){
                        if(ChessArr[ix][kx] == 0)
                        {
                            break;
                        }else {
                            if(color == 0){
                                color = ChessArr[ix][kx]; //
                                code += ChessArr[ix][kx];
                            } else if(color == ChessArr[ix][kx]){
                                code += ChessArr[ix][kx];
                            }else {
                                code += ChessArr[ix][kx];
                                break;
                            }
                        }
                    }
                    value[1] = hm.get(code);
                    if(value[1] != null){
                        chessValue[ix][jx] += value[1];
                    }
                    code = "";
                    color = 0;
                    //向上
                    for(int kx = ix-1; kx >= 0; kx--){
                        if(ChessArr[kx][jx] == 0){
                            break;
                        }
                        else {
                            if(color == 0){
                                color = ChessArr[kx][jx];
                                code += ChessArr[kx][jx];
                            } else if(color == ChessArr[kx][jx]){
                                code += ChessArr[kx][jx];
                            } else {
                                code += ChessArr[kx][jx];
                                break;
                            }
                        }
                    }
                    value[2] = hm.get(code);
                    if(value[2] != null){
                        chessValue[ix][jx] += value[2];
                    }
                    code = "";
                    color = 0;
                    //向下
                    for(int kx = ix+1; kx < GameUntil.LINE; kx++){
                        if(ChessArr[kx][jx] == 0){
                            break;
                        }
                        else {
                            if(color == 0){
                                color = ChessArr[kx][jx];
                                code += ChessArr[kx][jx];
                            } else if (color == ChessArr[kx][jx]){
                                code += ChessArr[kx][jx];
                            } else {
                                code += ChessArr[kx][jx];
                                break;
                            }
                        }
                    }
                    value[3] = hm.get(code);
                    if(value[3] != null){
                        chessValue[ix][jx] += value[3];
                    }
                    code = "";
                    color = 0;
                    //左上
                    for(int kx = ix-1, hx = jx-1; kx >= 0 && hx >= 0; kx--, hx--){
                        if(ChessArr[kx][hx] == 0){
                            break;
                        }
                        else {
                            if(color == 0){
                                color = ChessArr[kx][hx];
                                code += ChessArr[kx][hx];
                            } else if (color == ChessArr[kx][hx]){
                                code += ChessArr[kx][hx];
                            }else {
                                code += ChessArr[kx][hx];
                                break;
                            }
                        }
                    }
                    value[4] = hm.get(code);
                    if(value[4] != null){
                        chessValue[ix][jx] += value[4];
                    }
                    code = "";
                    color = 0;
                    //右上
                    for(int kx = ix-1, hx = jx+1; kx >= 0 && hx < GameUntil.LINE; kx--, hx++){
                        if(ChessArr[kx][hx] == 0){
                            break;
                        }
                        else {
                            if(color == 0){
                                color = ChessArr[kx][hx];
                                code += ChessArr[kx][hx];
                            } else if (color == ChessArr[kx][hx]){
                                code += ChessArr[kx][hx];
                            }else {
                                code += ChessArr[kx][hx];
                                break;
                            }
                        }
                    }
                    value[5] = hm.get(code);
                    if(value[5] != null){
                        chessValue[ix][jx] += value[5];
                    }
                    code = "";
                    color = 0;
                    //右下
                    for(int kx = ix+1, hx = jx+1; kx < GameUntil.LINE && hx < GameUntil.LINE; kx++, hx++){
                        if(ChessArr[kx][hx] == 0){
                            break;
                        }
                        else {
                            if(color == 0){
                                color = ChessArr[kx][hx];
                                code += ChessArr[kx][hx];
                            } else if (color == ChessArr[kx][hx]){
                                code += ChessArr[kx][hx];
                            }else {
                                code += ChessArr[kx][hx];
                                break;
                            }
                        }
                    }
                    value[6] = hm.get(code);
                    if(value[6] != null){
                        chessValue[ix][jx] += value[6];
                    }
                    code = "";
                    color = 0;
                    //左下
                    for(int kx = ix+1, hx = jx-1; kx < GameUntil.LINE && hx >= 0; kx++, hx--){
                        if(ChessArr[kx][hx] == 0){
                            break;
                        }
                        else {
                            if(color == 0){
                                color = ChessArr[kx][hx];
                                code += ChessArr[kx][hx];
                            } else if (color == ChessArr[kx][hx]){
                                code += ChessArr[kx][hx];
                            }else {
                                code += ChessArr[kx][hx];
                                break;
                            }
                        }
                    }
                    value[7] = hm.get(code); //将哈希表的权值传回去
                    if(value[7] != null){
                        chessValue[ix][jx] += value[7];
                    }
//                    for(int kx = 0; kx < ChessArr.length; kx++){
//                        System.out.println();
//                        for(int hx = 0; hx < ChessArr[0].length; hx++){
//                            System.out.print(ChessArr[hx][kx]);
//                        }
//                    }
                }
            }
        }
    }

    int[] max(){
        int[] a = new int[2];
        int maxValue = 0;
        System.out.println();
        for(int jx = 0; jx < ChessArr.length; jx++){
            System.out.println();
            for(int ix = 0; ix < ChessArr[0].length; ix++){
                System.out.print(chessValue[ix][jx]+" ");
                if(ChessArr[ix][jx] == 0){
                    if(chessValue[ix][jx] > maxValue && ChessArr[ix][jx] == 0){
                        maxValue = chessValue[ix][jx];
                        a[0] = ix;
                        a[1] = jx;
                    }
                }
                else {
                    chessValue[ix][jx] = 0;
                }
            }
        }
        return a;
    }
}

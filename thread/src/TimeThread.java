import java.util.ArrayList;

// 时间线程类
public class TimeThread implements Runnable {
    public long time = 2000;
    public ArrayList<MoveObject> listMoveObject;

    public TimeThread(ArrayList<MoveObject> listMoveObject){
        this.listMoveObject = listMoveObject;
    }

    public void run() {
        //定时创建敌人
        while(true){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            //定时创建对象
            MoveObject moveObject = new MoveObject();
            listMoveObject.add(moveObject);
        }

    }
}

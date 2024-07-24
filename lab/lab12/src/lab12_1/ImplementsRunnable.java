package lab12_1;

public class ImplementsRunnable implements Runnable{

    public ImplementsRunnable(){
        for(int i = 0; i < 10; i++){
            System.out.println(Thread.currentThread() + i);
        }
    }

    @Override
    public void run() {

    }
}
package jiayu0409动态数组;
import java.util.ArrayList;


public class Arrlist<E> {

    public Object[] arr = new Object[0]; //创建初始数组，数组长度为0
    public int size;

    //添加末尾
    //在最后一位增加一格填入新进来的数据，其他的直接从原数组里面复制
    public void add(E e){
        //扩容
        Object[] nArr = new Object[arr.length+1]; //创建新的数组长度是原数组长度+1
        nArr[arr.length] = e;
        System.arraycopy(arr, 0, nArr, 0, arr.length);
        //更新数组地址
        arr = nArr;
        size++;
    }

    //添加到指定位置
    public void add(int index,E e){
        if(index < 0 || index > size){
            System.out.println("Error!");
        }
        Object[] nArr = new Object[arr.length+1];
        int ix;
        for(ix = 0; ix < index; ix++){
            nArr[ix] = arr[ix];
        }
        nArr[index] = e;
        ix = index+1;
        for(int jx = index; jx < arr.length; ix++,jx++){
            nArr[ix] = arr[jx];
        }
        arr = nArr;
        size++;
    }

    //移除
    public void deleteArr(int index){
        if(index < 0 || index > size){
            System.out.println("Error!");
        }
        int ix;
        for(ix = index; ix < arr.length-1; ix++){
            arr[ix] = arr[ix+1];
        }
        size--;
    }

    //移除指定数据
    public void remove(E e){
        boolean right = false;
        for (Object o : arr) {
            if (o == e) {
                right = true;
                break;
            }
        }
        if(right) {
            int turn = 0;
            for (Object o : arr) {
                if (o == e) {
                    deleteArr(turn);
                }
            }
        }
    }

    //获取指定数据
    public void get(int index) {
        if(index < 0 || index > size){
            System.out.println("Error!");
        }
    }

    public int size(){
        size = arr.length;
        return size;
    }

    public static void main(String[] args){
        Arrlist<String> arrlist = new Arrlist<>();

        //获取当前系统时间
        long start = System.currentTimeMillis();
        //性能测试
        for(int ix = 0; ix < 50000; ix++){
            arrlist.add("a");
        }
        arrlist.add(2,"b");
        arrlist.deleteArr(3);
        arrlist.remove("a");
        int m = arrlist.size();
        System.out.println(m);
        long end = System.currentTimeMillis();
        System.out.println("Arrlist 耗时： "+(end - start));

        ArrayList<String> aList = new ArrayList<>();

        //获取当前系统时间
        start = System.currentTimeMillis();
        //性能测试
        for(int i=0;i<100000;i++) {
            aList.add("a");
        }
        end = System.currentTimeMillis();
        System.out.println("ArrayList 耗时："+(end - start));
    }
}

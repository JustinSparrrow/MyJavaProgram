package jiayu0520图像基础;

public class PixelArr implements MList{

    public int[] arr = new int[0];
    public int size;

    @Override
    public void add(int data) {
        //扩容原数组
        int[] nArr = new int[arr.length+1];
        nArr[arr.length+1] = data;
        //复制内容
        for(int ix = 0; ix < arr.length; ix++){
            nArr[ix] = arr[ix];
        }
        arr = nArr;
        size++;
    }

    @Override
    public void add(int index, int data) {
        //判断是否合法
        if(index >= arr.length){
            System.out.println("Error!");
            return;
        }
        //扩容原数组
        int[] nArr = new int[arr.length];
        nArr[index] = data;
        for(int ix = 0; ix < index; ix++){
            nArr[ix] = arr[ix];
        }
        for(int ix = index; ix < arr.length; ix++){
            nArr[ix+1] = arr[ix];
        }
        arr = nArr;
        size++;
    }

    @Override
    public void remove(int index) {
        //判断是否合法
        if (index >= arr.length){
            System.out.println("Error!");
            return;
        }
        for(int ix = index; ix < arr.length; ix++){
            arr[ix] = arr[ix+1];
        }
        size--;
    }

    @Override
    public boolean removes(int data) {
        int count = 0;
        for(int ix = 0; ix < arr.length; ix++){
            if(arr[ix] == data) {
                remove(ix);
                count++;
            }
        }
        if(count == 0) {
            return false;
        }
        return true;
    }

    @Override
    public void linkerCombine() {

    }

    @Override
    public int get(int index) {
        return arr[index];
    }

    @Override
    public int size() {
        size = arr.length;
        return size;
    }
}

package jiayu0520图像基础;

//自定义接口
public interface MList {

    //添加到末尾
    public void add(int data);
    //添加到指定位置
    public void add(int index, int data);
    //移除
    public void remove(int index);
    //移除指定数据
    public boolean removes(int data);
    //两个链表合并
    public void linkerCombine();
    //获取
    public int get(int index);
    //长度
    public int size();
}

package jiayu0520图像基础;

import java.awt.image.PixelInterleavedSampleModel;

public class PixelList implements MList{

    public Node root;
    public Node last;
    public int size;

    public PixelList(){
        root = new Node();
    }

    @Override
    public void add(int data) {
        Node node = new Node(data);
        //取出头节点
        Node head = root.next;
        if(head == null){
            root.next = node;
            last = node;
        }
    }

    @Override
    public void add(int index, int data) {

    }

    @Override
    public void remove(int index) {

    }

    @Override
    public boolean removes(int data) {
        return false;
    }

    @Override
    public void linkerCombine() {

    }

    @Override
    public int get(int index) {
        return 0;
    }

    @Override
    public int size() {
        return 0;
    }
}

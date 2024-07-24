package jiayu0416动态链表;

//单向链表
public class Linklist {

    //保存链表的头节点
    private final Node root;
    private Node last;  //记录尾节点
    private int size;

    //初始化根节点
    public Linklist(){
        root = new Node();
    }

    //添加末尾(加值)
    public void add(int data){
        //创建新节点保存数据
        Node nNode = new Node(data);
        //取出头节点
        Node head = root.next;
        //尾节点后移
        if(head == null){
            root.next = nNode;//保存头节点到根节点
            last = nNode;
        }else {
            //遍历到尾节点
            last.next = nNode;
            last = nNode;
        }
        size++;
    }

    //添加到指定位置
    public void add(int index,int data){
        Node nNode = new Node(data);
        Node p = root.next;
        Node s = null;
        if(p == null){
            root.next = nNode;
        }
        else {
            int j = 0;
            while (p != null && j < index - 1) {
                p = p.next;
                j++;
            }
            s = p;
            p = p.next;
            s.next = nNode.next;
            nNode.next = p;
        }
        size++;
    }

    //移除
    public void remove(int index){
        int j = 0;
        Node p = root.next;
        if(p == null){
            System.out.println("Error!");
        }
        else{
            while(p!=null && j < index-1){
                p = p.next;
                j++;
            }
            p.next = p.next.next;
        }
        size--;
    }

    //移除指定数据
    public boolean removes(int data){
        Node p = root.next;
        int j = 0;
        if(p == null){
            System.out.println("Error!");
        }else {
            while (p!=null){
                if(p.data == data){
                    remove(j);
                    p = p.next;
                    j++;
                }
                else{
                    p = p.next;
                    j++;
                }
            }
        }
        return false;
    }

    //获取指定数据
    public Node get(int index){
        Node p = root.next;
        for(int ix = 1; p!=null; ix++){
            if(ix == index){
                return p;
            }
            else{
                p = p.next;
            }
        }
        return null;
    }

    public static void main(String[] args){
        Linklist linklist = new Linklist();
        for(int i = 0; i < 10; i++){
            linklist.add(i+1);
        }
//        linklist.add(2,10);
        Node node = linklist.get(10);
        System.out.println(node.data);
    }
}

package lab7_2;

public class SomeClass {
    public SomeClass() throws Exception{
        throw new Exception("构造方法抛出异常");
    }

    public static void main(String[] args) {
        try {
            SomeClass someClass = new SomeClass();
        } catch (Exception e) {
            System.out.println(e);;
        }
    }
}


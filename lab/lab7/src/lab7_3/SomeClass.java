package lab7_3;

public class SomeClass {

    public void someMethod() throws Exception {
        try {
            someMethod2();
        } catch (Exception e){
            System.out.println("someMethod捕获异常");
            throw e;
        }
    }

    public void someMethod2() throws Exception{
        throw new Exception("someMethod2发生异常");
    }

    public static void main(String[] args) {
        try {
            new SomeClass().someMethod();
        } catch (Exception e){
            System.out.println("主函数捕获异常");
            e.printStackTrace();
        }
    }
}

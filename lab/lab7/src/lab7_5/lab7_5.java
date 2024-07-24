package lab7_5;

public class lab7_5 {

    public static <T> boolean isEqualTo(T obj1, T obj2){
        return obj1.equals(obj2);
    }

    public static void main(String[] args) {
        Integer a = 1;
        char b = '1';
        System.out.println(isEqualTo(a, b));

        Object c = 3;
        Object d = "你好";
        System.out.println(isEqualTo(c, d));
    }
}

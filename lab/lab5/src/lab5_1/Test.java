package lab5_1;

public class Test {

    public void PartingLine(){
        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {
        Test test = new Test();

        new Vehicle().run();
        test.PartingLine();

        new Motor().run();
        test.PartingLine();

        new Ship().run();
        test.PartingLine();

        new Aeroplane().run();
        test.PartingLine();

        new Bus().run();
        test.PartingLine();

        new Car().run();
        test.PartingLine();
    }
}

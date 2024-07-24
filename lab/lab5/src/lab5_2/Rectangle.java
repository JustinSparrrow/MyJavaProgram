package lab5_2;

public class Rectangle extends Graph{
    int height, width;
    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public boolean ifCorrect(){
        return height > 0 && width > 0;
    }

    public int calculateArea(){
        return height*width;
    }
}

package lab4_3;

public class Rectangle extends Graph{
    int height, width;
    public Rectangle(int height, int width) {
        super(height, width);
        this.height = height;
        this.width = width;
    }

    public int calculateArea(){
        return height*width;
    }
}

package lab4_5;

public enum TrafficLight {
    RED(255, 0, 0),
    GREEN(0, 255, 0),
    YELLOW(255, 255, 0);

    private int red;
    private int green;
    private int blue;

    TrafficLight(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }

    public int getRed() {
        return red;
    }

    public void setRed(int red) {
        this.red = red;
    }

    public int getGreen() {
        return green;
    }

    public void setGreen(int green) {
        this.green = green;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public static void main(String[] args) {
        System.out.println("红灯："+TrafficLight.RED.getRed()+", "+ TrafficLight.RED.getGreen() + ", " + TrafficLight.RED.getBlue());
        System.out.println("绿灯："+TrafficLight.GREEN.getRed()+", "+ TrafficLight.GREEN.getGreen() + ", " + TrafficLight.GREEN.getBlue());
        System.out.println("黄灯："+TrafficLight.YELLOW.getRed()+", "+ TrafficLight.YELLOW.getGreen() + ", " + TrafficLight.YELLOW.getBlue());
    }
}

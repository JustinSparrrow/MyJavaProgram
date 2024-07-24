package org.example.lab10_2;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class MyDraw {

    public int x1, y1, x2, y2;
    public Color color;

    public MyDraw(int x1, int y1, int x2, int y2, Color color) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.color = color;
    }

    public void drawLine(GraphicsContext gc) {
        gc.setStroke(color);
        gc.setLineWidth(5);
        gc.strokeLine(x1, y1, x2, y2);
    }

    public void drawRect(GraphicsContext gc) {
        gc.setStroke(color);
        gc.strokeRect(x1, y1, x2, y2);
    }

    public void drawOval(GraphicsContext gc){
        gc.setStroke(color);
        gc.strokeOval(x1, y1, x2, x2);
    }
}

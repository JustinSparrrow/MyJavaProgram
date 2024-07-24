package com.example.lab4_4;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.util.Random;

public class HelloController {
    @FXML
    private Label welcomeText;
    @FXML
    private TextField inputField;
    @FXML
    private Button button;
    @FXML
    private Canvas canvas;

    private String type;
    private int count = 0;
    private Random random = new Random();
    private int shape;

    @FXML
    protected void onHelloButtonClick() {
        if (count >= 20) {
            welcomeText.setText("绘制次数已达上限！");
            button.setDisable(true); // 禁用按钮
            return;
        }

        if (count == 0) {
            shape = random.nextInt(3);
            promptUserForShape();
            count++;
        } else {
            if (isInputValid()) {
                String[] parts = inputField.getText().split(",");
                int a = Integer.parseInt(parts[0].trim());
                int b = Integer.parseInt(parts[1].trim());
                drawShape(shape, a, b);
                count++;
                if (count < 20) {
                    shape = random.nextInt(3);
                    promptUserForShape();
                } else {
                    welcomeText.setText("绘制次数已达上限！");
                    count = 20;
                    button.setDisable(true); // 禁用按钮
                }
            } else {
                welcomeText.setText("输入错误，请重新输入");
            }
        }
    }

    private boolean isValidPosition(int shape, double x, double y, int a, int b) {
        return switch (shape) {
            case 0 ->
                // 对于线条，检查起点和终点是否在画布内
                    (x >= 0 && x <= canvas.getWidth()) &&
                            (y >= 0 && y <= canvas.getHeight()) &&
                            (a >= 0 && a <= canvas.getWidth()) &&
                            (b >= 0 && b <= canvas.getHeight());
            case 1, 2 ->
                // 对于矩形和圆形，检查起点加上宽度和高度是否超过画布
                    (x + a <= canvas.getWidth()) && (y + b <= canvas.getHeight());
            default -> false;
        };
    }

    private void promptUserForShape() {
        switch (shape) {
            case 0:
                type = "Line";
                welcomeText.setText("请输入终点坐标（用,隔开）：");
                break;
            case 1:
                type = "Rectangle";
                welcomeText.setText("请输入长和宽（用,隔开）：");
                break;
            case 2:
                type = "Circle";
                welcomeText.setText("请输入宽和高（用,隔开）：");
                break;
        }
        inputField.clear();
        inputField.setVisible(true);
        button.setText("绘制" + type+count);
    }

    private void drawShape(int shape, int a, int b) {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Color color = new Color(random.nextDouble(), random.nextDouble(), random.nextDouble(), 1.0);
        gc.setFill(color);
        gc.setStroke(color);

        double x = random.nextDouble() * canvas.getWidth();
        double y = random.nextDouble() * canvas.getHeight();

        if (!isValidPosition(shape, x, y, a, b)) {
            welcomeText.setText("请重新输入");
            return;
        }

        switch (shape) {
            case 0:
                gc.strokeLine(x, y, a, b);
                break;
            case 1:
                gc.fillRect(x, y, a, b);
                break;
            case 2:
                gc.fillOval(x, y, a, b);
                break;
        }
    }

    private boolean isInputValid() {
        String input = inputField.getText();
        if (input == null || input.isEmpty()) {
            return false;
        }
        String[] parts = input.split(",");
        if (parts.length != 2) {
            return false;
        }
        return isInteger(parts[0].trim()) && isInteger(parts[1].trim());
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}

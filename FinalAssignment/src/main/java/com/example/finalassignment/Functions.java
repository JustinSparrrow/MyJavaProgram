package com.example.finalassignment;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextFlow;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;

public class Functions {

    public MenuItem menuItemNew;
    public TreeView file;
    public StackPane stackPane;
    public TextFlow myTextFlow;
    public TextArea myTextArea;
    public Label status;
    public MenuItem menuItemOpen;
    public MenuItem menuItemSave;
    public MenuItem menuItemSaveAs;
    public MenuItem menuItemCancel;
    public MenuItem menuItemClear;
    public MenuItem menuItemType;
    public MenuItem menuItemSize;
    public MenuItem menuItemColor;
    public Menu menuItemSearch;

    private File currentFile;
    private boolean isTextChanged = false;

    @FXML
    private void initialize() {
        myTextArea.textProperty().addListener((observableValue, oldValue, newValue) -> {
            isTextChanged = true;
            setStatus();
        });

        myTextArea.caretPositionProperty().addListener((observable, oldPosition, newPosition) -> {
            setStatus();
        });
    }

    @FXML
    protected void createFile() {
        if (isTextChanged) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("未保存的更改");
            alert.setHeaderText("当前文本未保存，是否保存?");
            alert.setContentText("选择保存将保存当前文本，选择不保存将丢失当前更改，选择取消将返回编辑。");

            ButtonType saveButton = new ButtonType("保存");
            ButtonType dontSaveButton = new ButtonType("不保存");
            ButtonType cancelButton = new ButtonType("取消", ButtonType.CLOSE.getButtonData());

            alert.getButtonTypes().setAll(saveButton, dontSaveButton, cancelButton);

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent()) {
                if (result.get() == saveButton) {
                    saveFile();
                    clearTextArea();
                } else if (result.get() == dontSaveButton) {
                    clearTextArea();
                }
            }
        } else {
            clearTextArea();
        }
    }

    private void clearTextArea() {
        myTextArea.clear();
        status.setText("新建文件");
        currentFile = null;
        isTextChanged = false;
    }

    @FXML
    protected void openFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            currentFile = file;
            loadFileContent(file);
        }
    }

    private void loadFileContent(File file) {
        try {
            byte[] content = Files.readAllBytes(file.toPath());
            myTextArea.setText(new String(content));
            status.setText("打开文件: " + file.getName());
            isTextChanged = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void saveFile() {
        if (currentFile != null) {
            save(currentFile);
        } else {
            saveAs();
        }
    }

    @FXML
    protected void saveAs() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
        File file = fileChooser.showSaveDialog(new Stage());
        if (file != null) {
            currentFile = file;
            save(file);
        }
    }

    private void save(File file) {
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(myTextArea.getText());
            status.setText("保存文件: " + file.getName());
            isTextChanged = false;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    protected void cancel() {
        myTextArea.undo();
    }

    @FXML
    protected void clearPage() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("清空页面");
        alert.setHeaderText("是否清空当前页面？");
        alert.setContentText("选择确定将清空当前文本，选择取消则返回编辑");

        ButtonType clearButton = new ButtonType("清空");
        ButtonType unclearButton = new ButtonType("取消", ButtonType.CLOSE.getButtonData());

        alert.getButtonTypes().setAll(clearButton, unclearButton);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == clearButton) {
            myTextArea.clear();
            status.setText("页面已清空");
            isTextChanged = false;
        }
    }

    @FXML
    protected void search() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("查找");
        dialog.setHeaderText("查找文本");
        dialog.setContentText("请输入要查找的文本:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(searchText -> {
            String text = myTextArea.getText();
            int index = text.indexOf(searchText);
            if (index != -1) {
                myTextArea.selectRange(index, index + searchText.length());
                status.setText("找到文本: " + searchText);
            } else {
                status.setText("未找到文本: " + searchText);
            }
        });
    }

    @FXML
    protected void changeTextType() {
        ChoiceDialog<String> dialog = new ChoiceDialog<>("常规", "常规", "粗体", "斜体", "粗斜体");
        dialog.setTitle("更改文本类型");
        dialog.setHeaderText("选择文本类型");
        dialog.setContentText("选择类型:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(type -> {
            FontWeight fontWeight = FontWeight.NORMAL;
            FontPosture fontPosture = FontPosture.REGULAR;

            switch (type) {
                case "粗体":
                    fontWeight = FontWeight.BOLD;
                    break;
                case "斜体":
                    fontPosture = FontPosture.ITALIC;
                    break;
                case "粗斜体":
                    fontWeight = FontWeight.BOLD;
                    fontPosture = FontPosture.ITALIC;
                    break;
            }

            myTextArea.setFont(Font.font(myTextArea.getFont().getFamily(), fontWeight, fontPosture, myTextArea.getFont().getSize()));
            status.setText("更改文本类型为: " + type);
        });
    }

    @FXML
    protected void changeTextSize() {
        TextInputDialog dialog = new TextInputDialog("12");
        dialog.setTitle("更改文本大小");
        dialog.setHeaderText("输入文本大小");
        dialog.setContentText("请输入文本大小:");

        Optional<String> result = dialog.showAndWait();
        result.ifPresent(size -> {
            try {
                int newSize = Integer.parseInt(size);
                myTextArea.setFont(Font.font(myTextArea.getFont().getFamily(), newSize));
                status.setText("更改文本大小为: " + newSize);
            } catch (NumberFormatException e) {
                status.setText("无效的文本大小: " + size);
            }
        });
    }

    @FXML
    protected void changeTextColor() {
        ColorPicker colorPicker = new ColorPicker();
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("选择文本颜色");
        dialog.getDialogPane().setContent(colorPicker);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Color newColor = colorPicker.getValue();
            myTextArea.setStyle("-fx-text-fill: #" + newColor.toString().substring(2, 8) + ";");
            status.setText("更改文本颜色");
        }
    }

    @FXML
    protected void setStatus() {
        int caretPosition = myTextArea.getCaretPosition();
        int lineNumber = myTextArea.getText(0, caretPosition).split("\n").length;
        int columnNumber = caretPosition - myTextArea.getText(0, caretPosition).lastIndexOf("\n") - 1;
        String encoding = "UTF-8"; // 默认编码格式

        if (currentFile != null) {
            try {
                byte[] content = Files.readAllBytes(currentFile.toPath());
                encoding = detectEncoding(content);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        status.setText("光标位置: 第 " + lineNumber + " 行, 第 " + columnNumber + " 列 | 文件编码: " + encoding);
    }

    private String detectEncoding(byte[] content) {
        String encoding = "UTF-8";
        if (new String(content, StandardCharsets.UTF_8).equals(new String(content))) {
            encoding = "UTF-8";
        } else if (new String(content, StandardCharsets.ISO_8859_1).equals(new String(content))) {
            encoding = "ISO-8859-1";
        } else if (new String(content, StandardCharsets.US_ASCII).equals(new String(content))){
            encoding = "US_ASCII";
        }

        return encoding;
    }
}
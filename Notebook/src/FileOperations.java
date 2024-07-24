import javax.swing.*;
import java.io.*;

public class FileOperations {

    private JTextArea textArea;
    private JFrame jFrame;
    private File currentFile;

    private String filename;

    public FileOperations(JTextArea textArea, JFrame jFrame) {
        this.textArea = textArea;
        this.jFrame = jFrame;
        this.filename = "新建文件（未保存）";
        jFrame.setTitle(filename);
    }

    // 当前文件是否保存
    private boolean currentFileSave() {
        if (textArea.getText().isEmpty()) {
            return true;
        }
        int option = JOptionPane.showConfirmDialog(jFrame, "当前文件未保存，是否保存？", "提示", JOptionPane.YES_NO_CANCEL_OPTION);
        if (option == JOptionPane.YES_OPTION) {
            saveFile();
            return true;
        } else return option == JOptionPane.NO_OPTION;
    }

    public void newFile() {
        if (currentFileSave()) {
            filename = "新建文件（未保存）";
            jFrame.setTitle(filename);
            textArea.setText("");
            currentFile = null;
        }
    }

    public void openFile() {
        if (currentFileSave()) {
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(jFrame);
            if (option == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
                filename = currentFile.getName();
                jFrame.setTitle(filename);
                try (BufferedReader reader = new BufferedReader(new FileReader(currentFile))) {
                    textArea.read(reader, null);
                } catch (IOException e) {
                    Method.showError("无法打开文件: " + e.getMessage());
                }
            }
        }
    }

    public void saveFile() {
        if (currentFile == null) {
            saveAs();
        } else {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
                textArea.write(writer);
                filename = currentFile.getName();
                jFrame.setTitle(filename);
            } catch (IOException e) {
                Method.showError("无法保存文件: " + e.getMessage());
            }
        }
    }

    public void saveAs() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(jFrame);
        if (option == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            if (!currentFile.getName().endsWith(".txt")) {
                currentFile = new File(currentFile.getAbsolutePath() + ".txt");
            }
            saveFile();
        }
    }
}
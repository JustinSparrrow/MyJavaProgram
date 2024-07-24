import javax.swing.*;
import javax.swing.undo.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditOperations {

    private JTextArea textArea;
    private UndoManager undoManager;
    private boolean isEdit;

    public EditOperations(JTextArea textArea) {
        this.textArea = textArea;
        this.undoManager = new UndoManager();
        this.textArea.getDocument().addUndoableEditListener(undoManager);
        textArea.setEditable(false);
        isEdit = false;
    }

    public void enableEditing() {
        if (isEdit) {
            textArea.setEditable(false);
            isEdit = false;
        } else {
            textArea.setEditable(true);
            isEdit = true;
        }
    }

    public void cancel() {
        try {
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        } catch (CannotUndoException e) {
            Method.showError("无法撤销: " + e.getMessage());
        }
    }

    public void redo() {
        try {
            if (undoManager.canRedo()) {
                undoManager.redo();
            }
        } catch (CannotRedoException e) {
            Method.showError("无法重做: " + e.getMessage());
        }
    }

    public void findAndReplace() {
        JDialog dialog = new JDialog((Frame) null, "查找和替换", true);
        dialog.setLayout(new GridLayout(3, 1));
        dialog.setSize(450, 200);

        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel findLabel = new JLabel("查找:");
        JTextField findField = new JTextField();
        JLabel replaceLabel = new JLabel("替换为:");
        JTextField replaceField = new JTextField();

        inputPanel.add(findLabel);
        inputPanel.add(findField);
        inputPanel.add(replaceLabel);
        inputPanel.add(replaceField);
        dialog.add(inputPanel);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 4));
        JButton findNextButton = new JButton("查找下一个");
        JButton findPreviousButton = new JButton("查找上一个");
        JButton replaceButton = new JButton("替换单个");
        JButton replaceAllButton = new JButton("替换全部");

        buttonPanel.add(findNextButton);
        buttonPanel.add(findPreviousButton);
        buttonPanel.add(replaceButton);
        buttonPanel.add(replaceAllButton);
        dialog.add(buttonPanel);

        JLabel messageLabel = new JLabel();
        dialog.add(messageLabel);

        findNextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = findField.getText();
                String text = textArea.getText();
                int pos = textArea.getCaretPosition();
                int start = text.indexOf(findText, pos);
                if (start != -1) {
                    textArea.select(start, start + findText.length());
                } else {
                    messageLabel.setText("找不到文本: " + findText);
                }
            }
        });

        findPreviousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = findField.getText();
                String text = textArea.getText();
                int pos = textArea.getCaretPosition();
                int start = text.lastIndexOf(findText, pos - findText.length() - 1);
                if (start != -1) {
                    textArea.select(start, start + findText.length());
                } else {
                    messageLabel.setText("找不到文本: " + findText);
                }
            }
        });

        replaceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = findField.getText();
                String replaceText = replaceField.getText();
                String text = textArea.getText();
                int pos = textArea.getCaretPosition();
                int start = text.indexOf(findText, pos);
                if (start != -1) {
                    textArea.select(start, start + findText.length());
                    textArea.replaceSelection(replaceText);
                } else {
                    messageLabel.setText("找不到文本: " + findText);
                }
            }
        });

        replaceAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String findText = findField.getText();
                String replaceText = replaceField.getText();
                String text = textArea.getText();
                text = text.replaceAll(findText, replaceText);
                textArea.setText(text);
            }
        });

        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}
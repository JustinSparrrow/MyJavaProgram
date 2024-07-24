import javax.swing.*;
import javax.swing.undo.AbstractUndoableEdit;
import javax.swing.undo.UndoManager;
import java.awt.*;

public class FormatOperations {
    private JTextArea textArea;
    private JFrame frame;
    private UndoManager undoManager;

    public FormatOperations(JFrame frame, JTextArea textArea, UndoManager undoManager) {
        this.textArea = textArea;
        this.frame = frame;
        this.undoManager = undoManager;
    }

    public void setFontStyle() {
        JDialog dialog = new JDialog(frame, "设置字体", true);
        dialog.setLayout(new GridLayout(4, 2));

        JLabel sizeLabel = new JLabel("字体大小:");
        JTextField sizeField = new JTextField();
        dialog.add(sizeLabel);
        dialog.add(sizeField);

        JLabel styleLabel = new JLabel("字体样式:");
        String[] styles = {"常规", "粗体", "斜体", "粗斜体"};
        JComboBox<String> styleBox = new JComboBox<>(styles);
        dialog.add(styleLabel);
        dialog.add(styleBox);

        JButton applyButton = new JButton("应用");
        JButton cancelButton = new JButton("取消");
        dialog.add(applyButton);
        dialog.add(cancelButton);

        applyButton.addActionListener(e -> {
            try {
                int fontSize = Integer.parseInt(sizeField.getText());
                int fontStyle = styleBox.getSelectedIndex();
                Font oldFont = textArea.getFont();
                Font newFont = new Font(oldFont.getFontName(), fontStyle, fontSize);
                textArea.setFont(newFont);

                undoManager.addEdit(new AbstractUndoableEdit() {
                    @Override
                    public void undo() {
                        super.undo();
                        textArea.setFont(oldFont);
                    }

                    @Override
                    public void redo() {
                        super.redo();
                        textArea.setFont(newFont);
                    }
                });

                dialog.dispose();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(dialog, "请输入有效的字体大小。", "错误", JOptionPane.ERROR_MESSAGE);
            }
        });

        cancelButton.addActionListener(e -> dialog.dispose());

        dialog.pack();
        dialog.setLocationRelativeTo(frame);
        dialog.setVisible(true);
    }

    public void setTextColor() {
        Color oldColor = textArea.getForeground();
        Color newColor = JColorChooser.showDialog(frame, "选择文本颜色", oldColor);
        if (newColor != null) {
            textArea.setForeground(newColor);

            undoManager.addEdit(new AbstractUndoableEdit() {
                @Override
                public void undo() {
                    super.undo();
                    textArea.setForeground(oldColor);
                }

                @Override
                public void redo() {
                    super.redo();
                    textArea.setForeground(newColor);
                }
            });
        }
    }

    public void toggleWordWrap() {
        textArea.setLineWrap(!textArea.getLineWrap());
        textArea.setWrapStyleWord(textArea.getLineWrap());
    }
}
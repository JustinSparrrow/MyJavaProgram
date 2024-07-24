import javax.swing.*;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.undo.UndoManager;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;

public class Main {
    private FileOperations fileOperations;
    private EditOperations editOperations;
    private FormatOperations formatOperations;
    private JLabel statusLabel;
    private String encoding = StandardCharsets.UTF_8.name();
    private String filename = "记事本";
    private UndoManager undoManager = new UndoManager();

    public void showUI() {
        JFrame jFrame = new JFrame(filename);
        jFrame.setSize(800, 600);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 创建菜单栏
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(Color.decode("#87CEEB"));

        // 创建“文件”菜单
        JMenu fileMenu = new JMenu("文件");
        JMenuItem newItem = new JMenuItem("新建");
        JMenuItem openItem = new JMenuItem("打开");
        JMenuItem saveItem = new JMenuItem("保存");
        JMenuItem saveAsItem = new JMenuItem("另存为");
        JMenuItem exitItem = new JMenuItem("退出");
        fileMenu.add(newItem);
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(saveAsItem);
        fileMenu.addSeparator();
        fileMenu.add(exitItem);
        menuBar.add(fileMenu);

        // 创建“编辑”菜单
        JMenu editMenu = new JMenu("编辑");
        JMenuItem isEdited = new JMenuItem("编辑");
        JMenuItem cancel = new JMenuItem("撤销");
        JMenuItem redo = new JMenuItem("重做");
        JMenuItem lookUp = new JMenuItem("查找");
        editMenu.add(isEdited);
        editMenu.add(cancel);
        editMenu.add(redo);
        editMenu.add(lookUp);
        menuBar.add(editMenu);

        // 创建“格式”菜单
        JMenu formatMenu = new JMenu("格式");
        JMenuItem fontItem = new JMenuItem("设置字体");
        JMenuItem colorItem = new JMenuItem("设置颜色");
        JCheckBoxMenuItem wrapItem = new JCheckBoxMenuItem("自动换行");
        formatMenu.add(fontItem);
        formatMenu.add(colorItem);
        formatMenu.add(wrapItem);
        menuBar.add(formatMenu);

        // 创建“帮助”菜单
        JMenu helpMenu = new JMenu("帮助");
        JMenuItem aboutItem = new JMenuItem("关于");
        helpMenu.add(aboutItem);
        menuBar.add(helpMenu);

        jFrame.setJMenuBar(menuBar);

        // 创建文本编辑区域
        JTextArea textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        jFrame.add(scrollPane, BorderLayout.CENTER);

        // 创建状态栏
        statusLabel = new JLabel("行: 1, 列: 1 | 编码: " + encoding);
        jFrame.add(statusLabel, BorderLayout.SOUTH);

        // 添加光标监听器，更新状态栏信息
        textArea.addCaretListener(new CaretListener() {
            @Override
            public void caretUpdate(CaretEvent e) {
                int caretPos = textArea.getCaretPosition();
                int line = 0;
                int column = 0;
                try {
                    line = textArea.getLineOfOffset(caretPos);
                    column = caretPos - textArea.getLineStartOffset(line);
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                statusLabel.setText("行: " + (line + 1) + ", 列: " + (column + 1) + " | 编码: " + encoding);
            }
        });

        // 初始化文件操作类
        fileOperations = new FileOperations(textArea, jFrame);

        // 初始化编辑操作类
        editOperations = new EditOperations(textArea);

        // 初始化格式操作类
        formatOperations = new FormatOperations(jFrame, textArea, undoManager);

        // 添加菜单项的动作监听器
        newItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileOperations.newFile();
            }
        });

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileOperations.openFile();
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileOperations.saveFile();
            }
        });

        saveAsItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fileOperations.saveAs();
            }
        });

        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        isEdited.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editOperations.enableEditing();
            }
        });

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editOperations.cancel();
            }
        });

        redo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editOperations.redo();
            }
        });

        lookUp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                editOperations.findAndReplace();
            }
        });

        fontItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formatOperations.setFontStyle();
            }
        });

        colorItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formatOperations.setTextColor();
            }
        });

        wrapItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                formatOperations.toggleWordWrap();
            }
        });

        aboutItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jFrame, "Java Swing记事本\n使用JColorChooser、JComboBox、\nJFileChooser、JDialog等控件完成" , "关于", JOptionPane.INFORMATION_MESSAGE);
            }
        });


        jFrame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main().showUI();
    }
}
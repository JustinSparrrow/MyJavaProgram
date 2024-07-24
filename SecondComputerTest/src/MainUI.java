import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainUI {
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    private JList<String> employeeList;
    private ArrayList<Employee> employees = new ArrayList<>();

    private TextField idField;
    private TextField nameField;
    private TextField sectionField;
    private TextField jobLevelField;

    public void showUI() {
        JFrame jf = new JFrame("员工信息管理");
        jf.setLocationRelativeTo(null);
        jf.setSize(800, 600);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());

        // 创建员工列表模型和JList
        employeeList = new JList<>(listModel);
        employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        employeeList.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                int selectedIndex = employeeList.getSelectedIndex();
                if (selectedIndex != -1) {
                    Employee selectedEmployee = employees.get(selectedIndex);
                    idField.setText(String.valueOf(selectedEmployee.getId()));
                    nameField.setText(selectedEmployee.getName());
                    sectionField.setText(selectedEmployee.getSection());
                    jobLevelField.setText(String.valueOf(selectedEmployee.getJobLevel()));
                }
            }
        });

        JScrollPane leftScrollPane = new JScrollPane(employeeList);
        leftScrollPane.setPreferredSize(new Dimension(300, 400));
        jf.add(leftScrollPane, BorderLayout.WEST);

        JPanel right = new JPanel(new GridLayout(4, 1, 10, 10));
        right.setPreferredSize(new Dimension(480, 500));
        JPanel idPanel = new JPanel();
        JPanel namePanel = new JPanel();
        JPanel sectionPanel = new JPanel();
        JPanel jobLevelPanel = new JPanel();

        Label idLabel = new Label("ID: ");
        Label nameLabel = new Label("姓名：");
        Label sectionLabel = new Label("部门：");
        Label jobLevelLabel = new Label("岗位级别：");

        Dimension dimension = new Dimension(400, 30);
        idField = new TextField();
        idField.setPreferredSize(dimension);
        nameField = new TextField();
        nameField.setPreferredSize(dimension);
        sectionField = new TextField();
        sectionField.setPreferredSize(dimension);
        jobLevelField = new TextField();
        jobLevelField.setPreferredSize(dimension);

        idPanel.add(idLabel);
        idPanel.add(idField);
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        sectionPanel.add(sectionLabel);
        sectionPanel.add(sectionField);
        jobLevelPanel.add(jobLevelLabel);
        jobLevelPanel.add(jobLevelField);

        right.add(idPanel);
        right.add(namePanel);
        right.add(sectionPanel);
        right.add(jobLevelPanel);

        jf.add(right, BorderLayout.CENTER);

        JPanel bottom = new JPanel();
        bottom.setPreferredSize(new Dimension(800, 50));

        Function function = new Function(idField, nameField, sectionField, jobLevelField, listModel, employeeList, employees);
        Button addNew = new Button("新增");
        addNew.addActionListener(function);
        Button saveNew = new Button("保存");
        saveNew.addActionListener(function);
        Button delete = new Button("删除");
        delete.addActionListener(function);
        Button saveAs = new Button("保存至文件");
        saveAs.addActionListener(function);

        bottom.add(addNew);
        bottom.add(saveNew);
        bottom.add(delete);
        bottom.add(saveAs);

        jf.add(bottom, BorderLayout.SOUTH);

        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new MainUI().showUI();
    }
}
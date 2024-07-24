import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Function implements ActionListener {

    private TextField idField;
    private TextField nameField;
    private TextField sectionField;
    private TextField jobLevelField;
    private DefaultListModel<String> listModel;
    private JList<String> employeeList;
    private ArrayList<Employee> employees;

    public Function(TextField idField, TextField nameField, TextField sectionField, TextField jobLevelField, DefaultListModel<String> listModel, JList<String> employeeList, ArrayList<Employee> employees) {
        this.idField = idField;
        this.nameField = nameField;
        this.sectionField = sectionField;
        this.jobLevelField = jobLevelField;
        this.listModel = listModel;
        this.employeeList = employeeList;
        this.employees = employees;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();
        switch (s) {
            case "新增" -> addNewEmployee();
            case "保存" -> saveEmployeeInformation();
            case "删除" -> deleteEmployeeInformation();
            case "保存至文件" -> saveAs();
        }
    }

    public void addNewEmployee() {
        Employee employee = new Employee(0, "", "", 0);
        employees.add(employee);
        listModel.addElement(employee.getId()+"");
        employeeList.setSelectedIndex(employees.size() - 1);
        clearFields();
    }

    public void saveEmployeeInformation() {
        int selectedIndex = employeeList.getSelectedIndex();
        if (selectedIndex != -1) {
            try {
                Employee employee = employees.get(selectedIndex);
                employee.setId(Integer.parseInt(idField.getText()));
                employee.setName(nameField.getText());
                employee.setSection(sectionField.getText());
                employee.setJobLevel(Integer.parseInt(jobLevelField.getText()));
                listModel.set(selectedIndex, employee.getId()+"");
                clearFields();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "输入不正确，请输入有效的数字", "错误", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void deleteEmployeeInformation() {
        int selectedIndex = employeeList.getSelectedIndex();
        if (selectedIndex != -1) {
            employees.remove(selectedIndex);
            listModel.remove(selectedIndex);
            clearFields();
        }
    }

    public void saveAs() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("resource/employeesData.txt"))) {
            for (Employee employee : employees) {
                writer.write(employee.getId() + "," + employee.getName() + "," + employee.getSection() + "," + employee.getJobLevel());
                writer.newLine();
            }
            JOptionPane.showMessageDialog(null, "员工信息已保存到文件");
        } catch (IOException eio) {
            eio.printStackTrace();
            JOptionPane.showMessageDialog(null, "保存文件时出错");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        sectionField.setText("");
        jobLevelField.setText("");
    }
}
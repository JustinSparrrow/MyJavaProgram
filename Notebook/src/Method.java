import javax.swing.*;

public class Method {

    public static void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "错误", JOptionPane.ERROR_MESSAGE);
    }
}

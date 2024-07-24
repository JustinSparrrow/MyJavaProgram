package lab9_2;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regularExpression {

    private String userName;
    private String userPass;
    private String userMail;

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入用户名：");
        userName = scanner.nextLine();
        System.out.println("请输入密码：");
        userPass = scanner.nextLine();
        System.out.println("请输入用户邮箱：");
        userMail = scanner.nextLine();
        if(verify()){
            System.out.println("输入正确！");
        }
    }

    public boolean verify(){
        if(userName.isEmpty() || userPass.isEmpty() || userMail.isEmpty()){
            return false;
        } else {
            String usernameRegex = "^[A-Za-z]\\w*";
            String passwordRegex = "^[A-Za-z0-9_]{8,}$";
            String emailRegex = "^[A-Za-z0-9_.]+@[A-Za-z0-9.-]+$";

            Pattern patternUsername = Pattern.compile(usernameRegex);
            Pattern patternPassword = Pattern.compile(passwordRegex);
            Pattern patternEmail = Pattern.compile(emailRegex);

            Matcher matcherUsername = patternUsername.matcher(userName);
            Matcher matcherPassword = patternPassword.matcher(userPass);
            Matcher matcherEmail = patternEmail.matcher(userMail);

            if(!matcherUsername.matches()) {
                System.out.println("用户名错误：不能为空，只能由字母、数字和_组成，第一位不能为数字。");
                return false;
            }

            if(!matcherPassword.matches()) {
                System.out.println("密码错误：不能为空，密码长度至少8位，由字母、数字、下划线组成。");
                return false;
            }

            if(!matcherEmail.matches()) {
                System.out.println("邮箱错误：不能为空，需包含'@'符号。");
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new regularExpression().input();
    }
}

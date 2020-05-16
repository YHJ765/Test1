package Input_Search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入用户名");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("请输入密码");
        Scanner scanner2 = new Scanner(System.in);
        String password = scanner.nextLine();
        User user = Demo07.getUser(name, password);
        if(user == null) {
            System.out.println("登录失败");
        }else {
            System.out.println("欢迎登录");
        }
    }
}
package Input_FuzzySearch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        System.out.println("请输入关键字");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        //System.out.println("请输入姓名");
        //Scanner scanner2 = new Scanner(System.in);
        //String password = scanner2.nextLine();
        //User user = Demo07.getUser(name, password);
        User user = Demo07.getUser(name);
        if(user == null) {
            System.out.println("登录失败");
        }else {
            System.out.println("欢迎登录");
        }
    }
}
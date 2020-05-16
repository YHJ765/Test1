package Input_Search;

import java.io.Console;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.PreparedStatement;

public class Demo07 {
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            throw new RuntimeException("驱动加载失败");
        }
    }
    static Connection connection = null;
    static java.sql.PreparedStatement statement = null;
    public static User getUser(String name1,String password1) {
        User user = null;
        try {
            String url = "jdbc:mysql://localhost:3306/Search_test?useSSL=false&serverTimezone=UTC";
            connection = DriverManager.getConnection(url,"root","root765");
            String sql = "select * from users where user_name=? and user_password=?";
            //  对sql语句进行预编译
            statement = connection.prepareStatement(sql);
            //  给sql语句的占位符 进行赋值
            //  参数1 填索引 sql语句中问号索引
            statement.setString(1, name1);
            statement.setString(2, password1);
            System.out.println(sql);
            ResultSet resultSet = statement.executeQuery();
            //  只返回一条数据
            if(resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("user_name"));
                user.setPassword(resultSet.getString("user_password"));
                user.setEmail(resultSet.getString("email"));
                user.setBirthday(resultSet.getDate("birthday"));
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {
            if(connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            if(statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
        return user;
    }
}
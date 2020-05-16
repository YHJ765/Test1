package Input_FuzzySearch;


import com.alibaba.fastjson.JSON;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//import static com.mysql.cj.MysqlType.JSON;

public class Demo08 {
    public static void main(String[] args) {
        int resultCount = 0;
        for (List<Map> maps : getMoreResultSet()) {
            System.out.println("结果集" + resultCount++ + " : ");
            System.out.println(JSON.toJSONString(maps));
        }
    }

    public static List<List<Map>> getMoreResultSet() {
        List<List<Map>> resultList = new ArrayList<>();

        Connection conn = null;
        CallableStatement cstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/Search_test?useSSL=false&serverTimezone=UTC";
            conn = DriverManager.getConnection(url,"root","root765");
            // 该语句会返回多个结果集
            cstmt = conn.prepareCall("select Phone from Search ");
            rs = cstmt.executeQuery();
            boolean oprFlg = cstmt.execute();
            // 外循环获取结果集的个数
            while (oprFlg) {
                List<Map> result = new ArrayList<>();
                rs = cstmt.getResultSet();
                // 内循环获取每个结果集的记录
                while (rs.next()) {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    int columnCount = rsmd.getColumnCount();
                    Map map = new HashMap();
                    for (int i = 0; i < columnCount; i++) {
                        map.put(rsmd.getColumnName(i + 1).toLowerCase(), rs.getObject(i + 1));
                    }
                    result.add(map);
                }
                resultList.add(result);
                oprFlg = cstmt.getMoreResults();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }finally{
            if(null !=rs ){
                try {
                    rs.close();
                } catch (SQLException ex) {
                }
            }
            if(null != cstmt){
                try {
                    cstmt.close();
                } catch (SQLException ex) {
                }
            }
            if(null != conn){
                try {
                    conn.close();
                } catch (SQLException ex) {
                }
            }
        }
        return resultList;
    }
}

package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class BaseDao {
    private static final String  driver="com.mysql.cj.jdbc.Driver";
    private static final String  url="jdbc:mysql://localhost:3306/shopdemo?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
    private static final String  uid="root";
    private static final String  pwd="123456";

    //获取连接
    public static Connection getConnection(){
        Connection con=null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url,uid,pwd);
            System.out.println("DB Connection Successed!\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    //关闭连接
    public static void closeAll(ResultSet rs, Statement st, Connection con){
        try {
            if(rs!=null){
                rs.close();
                rs=null;
            }
            if(st!=null){
                st.close();
                st=null;
            }
            if(con!=null){
                con.close();
                con=null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

package cn.tedu;

import java.sql.*;

public class Demo03 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root", "root"
        );
        Statement s=conn.createStatement();
//        s.executeUpdate("insert into emp(name) values('Tom')");
//        s.executeUpdate("update emp set name='jerry' where name='Tom'");
//
        ResultSet rs=s.executeQuery("select * from emp");
        while(rs.next()){
            String name=rs.getString("name");
            double sal =rs.getDouble("sal");
            System.out.println(name+":"+sal);
        }
        conn.close();
        System.out.println("执行完成");
    }
}

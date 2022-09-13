package cn.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) throws SQLException {
        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/empdb?characterEncoding=utf8&serverTimezone=Asia/Shanghai&useSSL=false",
                "root", "root"
        );
        System.out.println("连接对象:" + conn);
        Statement s=conn.createStatement();
        s.execute("create table JDBCt1(name varchar(20),age int)");
        conn.close();
        System.out.println("执行完成");
    }
}

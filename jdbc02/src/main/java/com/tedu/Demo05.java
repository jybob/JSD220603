package com.tedu;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo05 {
    public static void main(String[] args) {
        try( Connection conn=DBUtils.getConn();)
        {
            Statement s= conn.createStatement();
            s.execute("create table hero(id varchar(20),name varchar(20),age int)");
//            s.executeUpdate("insert into hero(name,age) values('孙悟空',500),('猪八戒',300)");
//            s.executeUpdate("delete from emp where name='猪八戒'");
//            s.executeUpdate("update emp set name='齐天大圣' where name='孙悟空'");
//            ResultSet rs=s.executeQuery("select * from hero");
////            while(rs.next()){
////                String name=rs.getString("name");
////                int age=rs.getInt("age");
////                System.out.println(name+":"+age);
////            }

        } catch (SQLException throwables) {


            throwables.printStackTrace();
        }
    }
}

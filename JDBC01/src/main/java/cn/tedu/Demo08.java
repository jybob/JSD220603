package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        try(Connection conn=DBUtils.getConn();)
        {
            String sql="select password from user where username=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                if(rs.getString("password").equals(password)){
                    System.out.println("登录成功!");
                }else{
                    System.out.println("密码错误");
                }
            }else{
                System.out.println("用户名不存在");
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

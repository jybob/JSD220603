package cn.tedu;

import java.sql.*;
import java.util.Scanner;

public class Demo07 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入用户名");
        String username=sc.nextLine();
        System.out.println("请输入密码");
        String password=sc.nextLine();
        try(Connection conn=DBUtils.getConn();)
        {
//            Statement s=conn.createStatement();
//            ResultSet rs=s.executeQuery("select count(*) from user where username='"+username+"' and password='"+password+"'");
            String sql="select count(*) from user where username=? and password=?";
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs=ps.executeQuery();
            rs.next();
            int count=rs.getInt(1);
            if(count>0){
                System.out.println("登录成功");
            }else{
                System.out.println("用户名或密码错误");
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

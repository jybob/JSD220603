package cn.tedu.boot02.Controller;

import cn.tedu.boot02.entity.User;
import cn.tedu.boot02.utils.DBUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
public class UserController {
    @RequestMapping("/reg")
    public String reg(User user) {
        System.out.println("user = " + user);
        try (Connection conn = DBUtils.getConn();) {
            String sql = "select id from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return "用户名已存在";
            }
            String insert_sql = "insert into user values(null,?,?,?)";
            ps = conn.prepareStatement(insert_sql);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getNick());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "注册成功!";
    }

    @RequestMapping("/login")
    public String login(User user) {
        System.out.println("user = " + user);
        try (Connection conn = DBUtils.getConn();) {
            String sql = "select password from user where username=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, user.getUsername());
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                if(user.getPassword().equals(rs.getString(1))){
                    return "登录成功!";
                }
                return "密码错误";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return "用户名不存在";
    }
}

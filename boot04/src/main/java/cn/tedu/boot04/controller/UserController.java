package cn.tedu.boot04.controller;

import cn.tedu.boot04.entity.User;
import cn.tedu.boot04.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserMapper mapper;

    @RequestMapping("/reg")
    public String reg(User user) {
        User u = mapper.selectByUsername(user.getUsername());
        if (u != null) {
            return "用户名已存在!";
        }
        mapper.insert(user);

        return "注册成功!";
    }
    @RequestMapping("/login")
    public String login(User user){
        System.out.println("user="+user);
        User u= mapper.selectByUsername(user.getUsername());
        if(u!=null){
            if(user.getPassword().equals(u.getPassword())){
                return "登录成功!";
            }
                return "密码错误";

        }
        return "用户名不存在";
    }
}

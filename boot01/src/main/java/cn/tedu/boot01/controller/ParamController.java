package cn.tedu.boot01.controller;

import cn.tedu.boot01.entity.Emp;
import cn.tedu.boot01.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ParamController {
    @RequestMapping("/p1")
    @ResponseBody
    public String p1(HttpServletRequest request , HttpServletResponse response){
String info=request.getParameter("info");
        return "接受到参数:"+info;
    }

    @RequestMapping("/p2")
    @ResponseBody
    public String p2(String name,int age){
        return name+":"+age;
    }

    @RequestMapping("/p3")
    @ResponseBody
    public String p3(Emp emp){
        return emp.toString();
    }
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(User user){
        double bmi=user.getWeight()/ user.getHeight()/ user.getHeight();
        if(bmi<18.4){
            return "您的身材消瘦";
        }else if(bmi>18.5 && bmi<23.9){
            return "您的身材为正常";
        }else if(bmi>24&&bmi<27.9){
            return "您的体重为超重";
        }else{
            return "您的身材为肥胖";
        }
    }
}

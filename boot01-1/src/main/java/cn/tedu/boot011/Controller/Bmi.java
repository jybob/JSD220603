package cn.tedu.boot011.Controller;

import cn.tedu.boot011.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class Bmi {
    @RequestMapping("/bmi")
    @ResponseBody
    public String bmi(User user){
double bmi= user.getWeight()/ user.getHeight()/ user.getHeight();
return "";


    }
}

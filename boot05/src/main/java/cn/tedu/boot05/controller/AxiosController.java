package cn.tedu.boot05.controller;

import cn.tedu.boot05.entity.User;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxiosController {
    @RequestMapping("/helloAxios")
    public String helloAxios(String info) {


        return "测试成功!info=" + info;
    }

    @RequestMapping("/postAxios")
    public String postAxios(@RequestBody User user) {
        return "测试成功!" + user.toString();
    }

    @RequestMapping("/bmi")
    public String bmi(double h,double w){
       double result=w/h/h;
        if(result<18.5){
            return "有点瘦了";
        }
        if(result<23.9){
            return "正常";
        }
        if(result<27.9){
            return "超重";
        }
      return "肥胖";
    }
}

package mvc.controller;

import mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Arrays;

/**
 * @Author Mi
 * @Date 2022/3/28 16:07
 * @Version 1.0
 */
@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    //request表示当前请求      -- 一般不用 - -
    public String testServletAPI(HttpServletRequest request){
        HttpSession session = request.getSession();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(username + "  " + password);

        return "target";
    }



    @RequestMapping("/testParam")
    //请求参数的名称跟形参名保持一致   会自动赋值
    //如果不一致可以使用别名  设置required=false，这样可以不传入，设置true(默认)则必须要传这个数
    //defaultValue：默认值，没有传入值或传入值为空时使用 (常用)     设置了required就无效了
    //@RequestBody  获取请求体
    public String testParam(@RequestParam(value = "username",
                required = false,
                defaultValue = "hh")String username ,
                String password ,
                String[] hobby,
                @CookieValue("JSESSIONID")String JSESSIONID){
        System.out.println(username + "  " + password);
//        System.out.println(hobby);    String hobby    //a,b,c  得到字符串
        System.out.println(Arrays.toString(hobby)); //[a, b, c] 也可以是数组
        System.out.println("cookie="+JSESSIONID);
        return "target";
    }



    @RequestMapping("/testPOJO")
    public String testPOJO(User user){
        System.out.println(user);
        return "target";
    }

}

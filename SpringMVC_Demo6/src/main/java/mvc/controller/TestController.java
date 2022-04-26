package mvc.controller;

import mvc.bean.User;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *
 * @RestController: 标识在控制类上，就相当于为类添加了@Controller注解
 *                  并且为类中的每个方法添加了@ResponseBody注解
 *
 */
//@RestController
@Controller
public class TestController {

    /**
     * 获取请求体
     *      注解方式
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "success";
    }


    /**
     * 获取请求报文
     */
    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("请求头：" + requestEntity.getHeaders());
        System.out.println("请求体：" + requestEntity.getBody());
        return "success";
    }


    /**
     * 通过Response响应数据
     */
    @RequestMapping("/testResponse")
    public void testResponse(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }


    /**
     * 通过注解响应页面
     *      设置了@ResponseBody 后，当前响应的就不是success视图名称了，而是当前响应体
     *      返回的可以是对象
     */
    @RequestMapping("/testResponseBody")
    @ResponseBody
    public String testResponseBody(){
        return "success";
    }

    @RequestMapping("/testResponseUser")
    @ResponseBody
    public User testResponseUser(){
        User user = new User(213,"fu","abc");
        return user;
    }
}

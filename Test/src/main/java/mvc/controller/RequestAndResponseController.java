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
 * @Author Mi
 * @Date 2022/4/3 13:39
 * @Version 1.0
 */
@Controller
public class RequestAndResponseController {

    /**
     * 测试
     *      @RequestBody
     *      requestEntity
     *      @ResponseBody
     *      ResponseEntity
     *
     */

    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String requestBody){
        System.out.println(requestBody);
        return "success";
    }

    @RequestMapping("/testRequestEntity")
    public String testRequestEntity(RequestEntity<String> requestEntity){
        System.out.println("-----------------------------------------");
        System.out.println(requestEntity.getBody());
        System.out.println(requestEntity.getHeaders());
        System.out.println("-----------------------------------------");
        return "success";
    }

    @RequestMapping("/testResponseBody")
    public void testResponseBody(HttpServletResponse response) throws IOException {
        response.getWriter().println("hello,response");
    }


    @RequestMapping("/testResponseBodyReturnUser")
    @ResponseBody
    public User testResponseBodyReturnUser(){
        User user = new User(1,"李四","123123");
        return user;
    }

}

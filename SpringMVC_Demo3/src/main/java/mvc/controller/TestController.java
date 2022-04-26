package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Mi
 * @Date 2022/3/29 14:22
 * @Version 1.0
 */
@Controller
public class TestController {

//    @RequestMapping("/")
//    public String index(){
//        System.out.println("主页");
//        return "index";
//    }

    @RequestMapping("/testView")
    public String testView(){
        return "testView";
    }

}

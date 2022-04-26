package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Mi
 * @Date 2022/4/3 16:28
 * @Version 1.0
 */
@Controller
public class TestController {


    @RequestMapping("/")
    public String index(){
        return "index";
    }
}

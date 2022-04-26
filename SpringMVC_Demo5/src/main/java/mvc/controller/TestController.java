package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Mi
 * @Date 2022/3/30 16:59
 * @Version 1.0
 */
@Controller
public class TestController {

    @RequestMapping("/success")
    public String testSuccess(){
        return "success";
    }
}

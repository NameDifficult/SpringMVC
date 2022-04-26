package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Mi
 * @Date 2022/3/28 12:49
 * @Version 1.0
 */
@Controller
public class ControllerTest {

    @RequestMapping("/")
    public String index(){
        return "index";
    }


    @RequestMapping("/param")
    public String test_param(){
        return "test_param";
    }
}

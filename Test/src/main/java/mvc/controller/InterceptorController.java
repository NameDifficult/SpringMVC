package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Mi
 * @Date 2022/4/3 14:56
 * @Version 1.0
 */
@Controller
public class InterceptorController {


    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

}

package mvc.controller;

/**
 * @Author Mi
 * @Date 2022/4/2 22:17
 * @Version 1.0
 */


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 拦截器 ：
 *      一个在控制器执行之前执行
 *      一个在控制器执行之后执行
 *      一个在渲染视图之后执行
 */
@Controller
public class Lanjieqi {


    @RequestMapping("/testInterceptor")
    public String testInterceptor(){
        return "success";
    }

}

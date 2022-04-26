package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Mi
 * @Date 2022/3/27 23:09
 * @Version 1.0
 */
@Controller
public class HelloController {
    /**
     *  HTML等中的请求地址要和 @RequestMapping(value="")中的请求地址保持一致
     *  匹配成功后会根据方法返回的视图名称。该视图名称会被视图解析器解析，加上前缀和后缀组成路径
     *  通过thymeleaf对视图进行渲染，最终转发视图到对应页面
     *  跳转的方式是 --- 转发
     */

    //请求映射的注解
    @RequestMapping("/") // / --> /WEB-INF/templates/index.html
    public String index(){
        //返回视图名称，会被视图解析器解析
        return "index";
    }


    @RequestMapping("/target")
    public String toTarget(){
        return "target";
    }

}

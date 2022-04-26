package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author Mi
 * @Date 2022/3/30 15:25
 * @Version 1.0
 */
@Controller
public class ViewController {
    @RequestMapping("/testThymeleafView")
    public String testThymeleafView(){
        System.out.println("这里是testThymeleafView");
        return "success";
    }


    /**
     *            请求转发
     * @return
     */
    @RequestMapping("/testForward")
    public String testForward(){
        System.out.println("这里是testForward");
        return "forward:/testThymeleafView";
    }




    /**
     *            请求重定向
     * @return
     */
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("这里是testRedirect");
        return "redirect:/testThymeleafView";
    }
}

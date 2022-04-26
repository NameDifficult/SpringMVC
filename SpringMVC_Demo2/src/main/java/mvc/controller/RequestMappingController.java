package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 在HTML等标签中进行跳转到此类控制器所指示的方法时，需要先定位到类中的mapping，再定位到方法
 * 例如：
 * <a th:href="@{/hello/helloTarget}">跳转</a>
 *
 */
@RequestMapping("hello")
@Controller
public class RequestMappingController {


    /**
     * 里面value值可以有多个，即设置不同的名字，满足其中一个就可以
     * @RequestMapping(
     *                  value = {"helloTarget","target"},
     *                  method = {RequestMethod.GET,RequestMethod.POST}    默认两个都可以
     *      )
     */

//    @GetMapping("/helloTarget")
//    @PostMapping("/helloTarget")
//    @PutMapping("/helloTarget")
//    @DeleteMapping("/helloTarget")
    @RequestMapping(value = "/helloTarget" ,method = {RequestMethod.GET,RequestMethod.POST})
    public String target(){
        return "target";
    }


    /**
     * 路径可以使用ant风格的值  ？：匹配任意一个字符
     *                      * ：匹配0个或多个字符
     *
     * @return
     */
//    @RequestMapping("/test*")
    @RequestMapping("/test?")
    public String test(){
        return "target";
    }


    /**
     *      <a th:href="@{/hello/testPath/123/admin}"></a>
     *      相当于：
     *          /testPath?id=123&username=admin
     *       当requestMapping中有占位符，则HTML等文件中的转发地址也必须要有有值传给占位符
     * @param id            占位符
     * @param username      占位符
     * @return
     */
    @RequestMapping("/testPath/{id}/{username}")
    public String testPath(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("id=" + id);
        System.out.println("username = " + username);
        return "target";
    }

}

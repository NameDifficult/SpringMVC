package mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author Mi
 * @Date 2022/3/29 14:50
 * @Version 1.0
 */
@Controller
public class ScopeController {


    /**
     * 方式一：
     * 向request域中传数据
     * @return
     */
    @RequestMapping("/testRequestByServletAPI")
    public String testRequestByServletAPI(HttpServletRequest request){
        request.setAttribute("username","张三");
        return "success";
    }



    /**
     * 方式二：   (建议使用)
     * 向request域中传数据
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","李四");
        modelAndView.setViewName("success");
        return modelAndView;
    }



    /**
     * 方式三：
     * 向request域中传数据
     * @return
     */
    @RequestMapping("/testModel")
    public String testModel(Model model){
        model.addAttribute("username","王五");
        return "success";
    }



    /**
     * 方式四：
     * 向request域中传数据
     * @return
     */
    @RequestMapping("/testMAP")
    public String testMAP(Map<String,Object> requestMap){
        requestMap.put("username","六六");
        requestMap.put("password","123456");
        return "success";
    }






    /**
     * 方式五：
     * 向request域中传数据
     * @return
     */
    @RequestMapping("/testModelMap")
    public String testModel(ModelMap modelMap){
        modelMap.addAttribute("username","王五");
        modelMap.addAttribute("password","abcd");
        return "success";
    }



    /**
     *
     *  向session域中传数据
     *
     */
    @RequestMapping("/testSession")
    public String testSession(HttpSession session){
        session.setAttribute("username","田七");
        return "success";
    }



    /**
     *
     *  向context域中传数据
     *
     */
    @RequestMapping("/testApplication")
    public String testApplication(HttpSession session){
        ServletContext servletContext = session.getServletContext();
        servletContext.setAttribute("username","哈哈哈");
        return "success";
    }






}

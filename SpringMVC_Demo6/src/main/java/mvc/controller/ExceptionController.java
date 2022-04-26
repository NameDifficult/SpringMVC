package mvc.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @Author Mi
 * @Date 2022/4/3 15:44
 * @Version 1.0
 */
@ControllerAdvice
public class ExceptionController {


    /**
     *          如果出现了value中指定的异常，就会跳转到方法指定视图
     * @return
     */
    @ExceptionHandler(value = {ArithmeticException.class,NullPointerException.class})
    public String exception(Exception ex, Model model){
        model.addAttribute("ex",ex);
        return "error";
    }


}

package mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author Mi
 * @Date 2022/4/2 22:24
 * @Version 1.0
 */

/**
 * 拦截器
 */
@Component
public class FirstInterceptor implements HandlerInterceptor {

    /**
     *          在控制器执行之前执行
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("FirstInterceptor----->preHandle");
        return true;
    }


    /**
     *          在控制器执行之后执行
     *
     * */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("FirstInterceptor----->postHandle");
    }



    /**
     *          在渲染视图之后执行
     *
     * */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("FirstInterceptor----->afterCompletion");
    }
}
